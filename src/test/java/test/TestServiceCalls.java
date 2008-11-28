package test;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.List;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.resources.Photo;
import net.brightkite4j.brightkite.resources.PlaceObject;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class TestServiceCalls {

	@Test
	public void testGetMe() throws Exception {
		String xml = UtilsForTesting.readTestData("person.xml");
		String url = "http://brightkite.com/me.xml";
		DateTime expectedLastCheckedInAt = new DateTime(
				2008, 7, 10, 20, 8, 35, 0, DateTimeZone.UTC
		);
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setHttpService(service);
		bk.setCredentials("foo", "bar");
		Person me = bk.getMe();

		//Person
		assertNull(me.getFullname());
		assertEquals("FrankZappa", me.getLogin());
		assertEquals("Totally sweet", me.getDescription());
		assertNull(me.getWebsite());
		assertNull(me.getAge());
		assertEquals("unspecified", me.getSex());
		assertEquals("/images/default_user_avatar_small.png", me.getSmallAvatarUrl());
		assertEquals("/images/default_user_avatar_smaller.png", me.getSmallerAvatarUrl());
		assertEquals("/images/default_user_avatar_tiny.png", me.getTinyAvatarUrl());
		assertTrue(expectedLastCheckedInAt.isEqual(me.getLastCheckedIn()));
		verify(service);
	}

	@Test
	public void testGetFriendstream() throws Exception {
		String xml = UtilsForTesting.readTestData("friendstream.xml");
		String url = "http://brightkite.com/me/friendstream.xml";
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setHttpService(service);
		bk.setCredentials("foo", "bar");
		List<PlaceObject> streamList = bk.getFriendstream();
		
		assertEquals(3, streamList.size());
		Photo photo = (Photo)streamList.get(0);
		// couple spot checks
		assertEquals("Hooch", photo.getBody());
		assertEquals("Jim Bob", photo.getCreator().getFullname());
		verify(service);
	}

	private HTTPService getMockService() {
		return createMock(HTTPService.class);
	}
}
