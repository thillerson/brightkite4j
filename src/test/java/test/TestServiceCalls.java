package test;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.List;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.resources.Comment;
import net.brightkite4j.brightkite.resources.DirectMessage;
import net.brightkite4j.brightkite.resources.Note;
import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.resources.Photo;
import net.brightkite4j.brightkite.resources.Place;
import net.brightkite4j.brightkite.resources.PlaceObject;
import net.brightkite4j.brightkite.resources.Placemark;

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

	@Test
	public void testGetMyFriends() throws Exception {
		String xml = UtilsForTesting.readTestData("friends.xml");
		String url = "http://brightkite.com/me/friends.xml";
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		List<Person> friendList = bk.getMyFriends();
		
		assertEquals(3, friendList.size());
		Person friend = friendList.get(0);
		assertEquals("Peacy P", friend.getFullname());
		assertEquals("29 minutes", friend.getLastCheckedInAsWords());
		assertEquals("3850 Paseo del Prado St, Boulder, CO 80301, USA", friend.getPlace().getName());
		friend = friendList.get(1);
		assertEquals("x2jsf95", friend.getPlace().getShortcode());
		verify(service);
	}

	@Test
	public void testGetMyPendingFriends() throws Exception {
		String xml = UtilsForTesting.readTestData("pending_friends.xml");
		String url = "http://brightkite.com/me/pending_friends.xml";
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		List<Person> pendingFriendList = bk.getMyPendingFriends();
		
		assertEquals(1, pendingFriendList.size());
		Person friend = pendingFriendList.get(0);
		assertEquals("Joe Schmoe", friend.getFullname());
		verify(service);
	}

	@Test
	public void testGetMyBlockedPeople() throws Exception {
		String xml = UtilsForTesting.readTestData("blocked_people.xml");
		String url = "http://brightkite.com/me/blocked_people.xml";
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		List<Person> blockedPeopleList = bk.getMyBlockedPeople();
		
		assertEquals(1, blockedPeopleList.size());
		Person friend = blockedPeopleList.get(0);
		assertEquals("Joe Schmoe", friend.getFullname());
		verify(service);
	}

	@Test
	public void testGetPlacemarks() throws Exception {
		String xml = UtilsForTesting.readTestData("placemarks.xml");
		String url = "http://brightkite.com/me/placemarks.xml";
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		List<Placemark> placemarksList = bk.getMyPlacemarks();
		
		assertEquals(3, placemarksList.size());
		Placemark placemark = placemarksList.get(0);
		assertEquals("Snooze", placemark.getPlacemark());
		assertEquals("thillerson", placemark.getUser().getLogin());
		placemark = placemarksList.get(1);
		assertEquals("xfn44bd", placemark.getPlace().getShortcode());
		verify(service);
	}
	
	@Test
	public void testGetSentDirectMessages() throws Exception {
		String xml = UtilsForTesting.readTestData("sent_messages.xml");
		String url = "http://brightkite.com/me/sent_messages.xml";
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		List<DirectMessage> sentMessageList = bk.getMySentDirectMessages();
		
		assertEquals(0, sentMessageList.size());
		verify(service);
	}
	
	@Test
	public void testGetReceivedDirectMessages() throws Exception {
		String xml = UtilsForTesting.readTestData("received_messages.xml");
		String url = "http://brightkite.com/me/received_messages.xml";
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		List<DirectMessage> receivedMessageList = bk.getMyReceivedDirectMessages();
		
		assertEquals(1, receivedMessageList.size());
		DirectMessage message = receivedMessageList.get(0);
		assertEquals("read", message.getStatus());
		assertEquals("Dave", message.getSender().getFullname());
		assertEquals("Tony Hillerson", message.getRecipient().getFullname());
		
		verify(service);
	}
	
	@Test
	public void testGetPlace() throws Exception {
		String xml = UtilsForTesting.readTestData("place.xml");
		String url = "http://brightkite.com/places/da4b9237bacccdf19c0760cab7aec4a8359010b0.xml";
		
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		
		Place usa = bk.getPlace("da4b9237bacccdf19c0760cab7aec4a8359010b0");
		
		assertEquals("US", usa.getCountry());
		assertEquals("USA", usa.getDisplayLocation());
		
		verify(service);
	}
	
	private HTTPService getMockService() {
		return createMock(HTTPService.class);
	}
}
