package test;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.List;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.resources.Comment;
import net.brightkite4j.brightkite.resources.Note;
import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.resources.Photo;
import net.brightkite4j.brightkite.resources.PlaceObject;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Ignore;
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
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		List<PlaceObject> streamList = bk.getFriendstream();
		
		assertEquals(3, streamList.size());
		// couple spot checks
		Photo photo = (Photo)streamList.get(0);
		assertEquals("Hooch", photo.getBody());
		assertEquals("Jim Bob", photo.getCreator().getFullname());
		Note note = (Note)streamList.get(1);
		assertEquals("Turkey good!", note.getBody());
		assertEquals("Aspen", note.getPlace().getName());
		photo = (Photo)streamList.get(2);
		assertEquals("/images/photo_object/photos/1/6/165999/photo.jpg", photo.getPhoto());
		assertEquals("ee89abaea22411dd927bf394a1b5bc3f", photo.getPlace().getId());
		verify(service);
	}

	@Test
	public void testGetNearbytream() throws Exception {
		String xml = UtilsForTesting.readTestData("nearbystream.xml");
		String url = "http://brightkite.com/me/nearbystream.xml";
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		List<PlaceObject> streamList = bk.getNearbystream();
		
		assertEquals(3, streamList.size());
		// couple spot checks
		Photo photo = (Photo)streamList.get(0);
		assertEquals("Hooch", photo.getBody());
		assertEquals("Jim Bob", photo.getCreator().getFullname());
		Note note = (Note)streamList.get(1);
		assertEquals("Turkey good!", note.getBody());
		assertEquals("Aspen", note.getPlace().getName());
		photo = (Photo)streamList.get(2);
		assertEquals("/images/photo_object/photos/1/6/165999/photo.jpg", photo.getPhoto());
		assertEquals("ee89abaea22411dd927bf394a1b5bc3f", photo.getPlace().getId());
		verify(service);
	}

	@Test
	public void testGetMentionstream() throws Exception {
		String xml = UtilsForTesting.readTestData("mentionsstream.xml");
		String url = "http://brightkite.com/me/mentionsstream.xml";
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		List<PlaceObject> streamList = bk.getMentions();
		
		assertEquals(0, streamList.size());
		verify(service);
	}

	@Test
	public void testGetCommentsstream() throws Exception {
		String xml = UtilsForTesting.readTestData("commentsstream.xml");
		String url = "http://brightkite.com/me/commentsstream.xml";
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		List<Comment> streamList = bk.getCommentstream();
		
		assertEquals(1, streamList.size());
		Comment comment = streamList.get(0);
		assertEquals("84", comment.getComment());
		assertEquals("6 days", comment.getCreatedAtAsWords());
		assertEquals("Jim Bob", comment.getUser().getFullname());
		verify(service);
	}

	private HTTPService getMockService() {
		return createMock(HTTPService.class);
	}
}
