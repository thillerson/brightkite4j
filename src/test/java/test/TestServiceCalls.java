package test;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.List;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.api.Parameter;
import net.brightkite4j.brightkite.resources.Checkin;
import net.brightkite4j.brightkite.resources.Comment;
import net.brightkite4j.brightkite.resources.DirectMessage;
import net.brightkite4j.brightkite.resources.Friendship;
import net.brightkite4j.brightkite.resources.Note;
import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.resources.Photo;
import net.brightkite4j.brightkite.resources.Place;
import net.brightkite4j.brightkite.resources.PlaceObject;
import net.brightkite4j.brightkite.resources.PlaceObjectFilter;
import net.brightkite4j.brightkite.resources.Placemark;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class TestServiceCalls {

	@Test
	public void testGetMe() throws Exception {
		String xml = UtilsForTesting.readTestData("person.xml");
		String url = "http://brightkite.com/me.xml";
		DateTime expectedLastCheckedInAt = new DateTime(2008, 7, 10, 20, 8, 35, 0, DateTimeZone.UTC);

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

		// Person
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
		Photo photo = (Photo) streamList.get(0);
		assertEquals("Hooch", photo.getBody());
		assertEquals("Jim Bob", photo.getCreator().getFullname());
		Note note = (Note) streamList.get(1);
		assertEquals("Turkey good!", note.getBody());
		assertEquals("Aspen", note.getPlace().getName());
		photo = (Photo) streamList.get(2);
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
		Photo photo = (Photo) streamList.get(0);
		assertEquals("Hooch", photo.getBody());
		assertEquals("Jim Bob", photo.getCreator().getFullname());
		Note note = (Note) streamList.get(1);
		assertEquals("Turkey good!", note.getBody());
		assertEquals("Aspen", note.getPlace().getName());
		photo = (Photo) streamList.get(2);
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
		String xml = UtilsForTesting.readTestData("people.xml");
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

		assertEquals(2, blockedPeopleList.size());
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

	@Test
	public void testGetPlaceObjectsAtPlace() throws Exception {
		Note note;
		Photo photo;
		Checkin checkin;
		PlaceObject placeObject;
		String placeXML = UtilsForTesting.readTestData("place.xml"); // USA
		Place usa = Place.fromXML(placeXML);
		String xml = UtilsForTesting.readTestData("place_objects_at_place.xml");
		String url = "http://brightkite.com/places/da4b9237bacccdf19c0760cab7aec4a8359010b0/objects.xml";

		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.get(url, null);
		expectLastCall().andReturn(xml);
		replay(service);

		List<PlaceObject> usaPlaceObjects = bk.getPlaceObjectsAtPlace(usa);

		assertEquals(20, usaPlaceObjects.size());

		placeObject = usaPlaceObjects.get(0);
		assertTrue(placeObject.isACheckin());
		checkin = (Checkin) placeObject;
		assertEquals("e12aee0cbdc011ddbeb2003048c0801e", checkin.getId());
		assertEquals(0, checkin.getCommentsCount());
		assertEquals("Nathan Rein", checkin.getCreator().getFullname());

		placeObject = usaPlaceObjects.get(1);
		assertTrue(placeObject.isANote());
		note = (Note) placeObject;
		assertEquals("a30bc9d4bdc011dd959a003048c0801e", note.getId());
		assertEquals(2, note.getCommentsCount());
		assertEquals("San Diego, CA, US", note.getPlace().getName());

		placeObject = usaPlaceObjects.get(2);
		assertTrue(placeObject.isAPhoto());
		photo = (Photo) placeObject;
		assertEquals("$2.74 for reg in Hilo.", photo.getBody());
		assertEquals("Hilo, HI, USA", photo.getPlace().getDisplayLocation());

		verify(service);
	}

	@Test
	public void testGetPlaceObjectsAtPlaceWithFilters() throws Exception {
		@SuppressWarnings("unused")
		List<PlaceObject> usaPlaceObjects;
		String placeXML = UtilsForTesting.readTestData("place.xml"); // USA
		Place usa = Place.fromXML(placeXML);
		String placeObjectsXML = UtilsForTesting.readTestData("place_objects_at_place.xml");
		String notesXML = UtilsForTesting.readTestData("notes_at_place.xml");
		String photosXML = UtilsForTesting.readTestData("photos_at_place.xml");
		String checkinsXML = UtilsForTesting.readTestData("checkins_at_place.xml");
		String baseURL = "http://brightkite.com/places/da4b9237bacccdf19c0760cab7aec4a8359010b0/objects.xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		Parameter[] params;

		service = getMockService();
		bk.setHttpService(service);
		params = new Parameter[]{new Parameter("filters", "notes")};
		service.get(eq(baseURL), aryEq(params));
		expectLastCall().andReturn(notesXML);
		replay(service);
		List<Note> usaNotes = bk.getNotesAtPlace(usa);
		assertEquals(8, usaNotes.size());
		verify(service);

		service = getMockService();
		bk.setHttpService(service);
		params = new Parameter[]{new Parameter("filters", "photos")};
		service.get(eq(baseURL), aryEq(params));
		expectLastCall().andReturn(photosXML);
		replay(service);
		List<Photo> usaPhotos = bk.getPhotosAtPlace(usa);
		assertEquals(10, usaPhotos.size());
		verify(service);

		service = getMockService();
		bk.setHttpService(service);
		params = new Parameter[]{new Parameter("filters", "checkins")};
		service.get(eq(baseURL), aryEq(params));
		expectLastCall().andReturn(checkinsXML);
		replay(service);
		List<Checkin> usaCheckins = bk.getCheckinsAtPlace(usa);
		assertEquals(2, usaCheckins.size());
		verify(service);

		service = getMockService();
		bk.setHttpService(service);
		params = new Parameter[]{new Parameter("filters", "notes,checkins")};
		service.get(eq(baseURL), aryEq(params));
		expectLastCall().andReturn(placeObjectsXML); // wrong xml, but i'm just testing the url
		replay(service);
		usaPlaceObjects = bk.getPlaceObjectsAtPlace(usa, PlaceObjectFilter.createFilter(PlaceObjectFilter.NOTES | PlaceObjectFilter.CHECKINS));
		verify(service);

		service = getMockService();
		bk.setHttpService(service);
		params = new Parameter[]{new Parameter("filters", "photos,checkins")};
		service.get(eq(baseURL), aryEq(params));
		expectLastCall().andReturn(placeObjectsXML); // wrong xml, but i'm just testing the url
		replay(service);
		usaPlaceObjects = bk.getPlaceObjectsAtPlace(usa, PlaceObjectFilter.createFilter(PlaceObjectFilter.PHOTOS | PlaceObjectFilter.CHECKINS));
		verify(service);

		service = getMockService();
		bk.setHttpService(service);
		params = new Parameter[]{new Parameter("filters", "notes,photos")};
		service.get(eq(baseURL), aryEq(params));
		expectLastCall().andReturn(placeObjectsXML); // wrong xml, but i'm just testing the url
		replay(service);
		usaPlaceObjects = bk.getPlaceObjectsAtPlace(usa, PlaceObjectFilter.createFilter(PlaceObjectFilter.NOTES | PlaceObjectFilter.PHOTOS));
		verify(service);

		service = getMockService();
		bk.setHttpService(service);
		params = new Parameter[]{new Parameter("filters", "notes,photos,checkins")};
		service.get(eq(baseURL), aryEq(params));
		expectLastCall().andReturn(placeObjectsXML); // wrong xml, but i'm just testing the url
		replay(service);
		usaPlaceObjects = bk.getPlaceObjectsAtPlace(usa, PlaceObjectFilter.createFilter(PlaceObjectFilter.NOTES | PlaceObjectFilter.PHOTOS | PlaceObjectFilter.CHECKINS));
		verify(service);
	}
	
	@Test
	public void testCheckingIn() throws Exception {
		Checkin checkin;
		Place place = new Place();
		place.setId("da4b9237bacccdf19c0760cab7aec4a8359010b0");
		// this place and checkin don't match, but it's just for testing that the url gets called
		// and a checkin comes back out
		String checkinXML = UtilsForTesting.readTestData("checkin.xml"); 
		String url = "http://brightkite.com/places/da4b9237bacccdf19c0760cab7aec4a8359010b0/checkins.xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.post(url)).andReturn(checkinXML);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		checkin = bk.checkin(place);
		assertEquals("356a192b7913b04c54574d18c28d46e6395428ab", checkin.getPlace().getId());
		verify(service);
	}

	@Test
	public void testDeleteCheckin() throws Exception {
		Checkin checkin = Checkin.fromXML(UtilsForTesting.readTestData("checkin.xml"));
		Place place = new Place();
		place.setId(checkin.getPlace().getId());
		String url = "http://brightkite.com/objects/" + checkin.getId() + ".xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		service.delete(url);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		bk.deleteCheckin(checkin);
		verify(service);
	}

	@Test
	public void testGetPeopleAtPlace() throws Exception {
		String xml = UtilsForTesting.readTestData("people.xml");
		Place place = Place.fromXML(UtilsForTesting.readTestData("place.xml"));
		String url = "http://brightkite.com/places/" + place.getId() + "/people.xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		Parameter[] params = new Parameter[2];
		expect(service.get(eq(url), aryEq(params))).andReturn(xml);
		replay(service);
		
		List<Person> people = bk.getPeopleAtPlace(place);
		assertEquals(2, people.size());
		Person p = people.get(0);
		assertEquals("Joe Schmoe", p.getFullname());
		verify(service);
	}

	@Test
	public void testGetPeopleAtPlaceWithRadius() throws Exception {
		String xml = UtilsForTesting.readTestData("people.xml");
		Place place = Place.fromXML(UtilsForTesting.readTestData("place.xml"));
		String url = "http://brightkite.com/places/" + place.getId() + "/people.xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		Parameter radiusParam = new Parameter("radius", 2000);
		Parameter[] params = new Parameter[]{radiusParam, null};
		expect(service.get(eq(url), aryEq(params))).andReturn(xml);
		replay(service);
		
		List<Person> people = bk.getPeopleAtPlace(place, 2000);
		assertEquals(2, people.size());
		Person p = people.get(0);
		assertEquals("Joe Schmoe", p.getFullname());
		verify(service);
	}

	@Test
	public void testGetPeopleAtPlaceWithHoursAgo() throws Exception {
		String xml = UtilsForTesting.readTestData("people.xml");
		Place place = Place.fromXML(UtilsForTesting.readTestData("place.xml"));
		String url = "http://brightkite.com/places/" + place.getId() + "/people.xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		Parameter hoursAgoParam = new Parameter("hours_ago", 2);
		Parameter[] params = new Parameter[]{null, hoursAgoParam};
		expect(service.get(eq(url), aryEq(params))).andReturn(xml);
		replay(service);
		
		List<Person> people = bk.getPeopleAtPlace(place, null, 2);
		assertEquals(2, people.size());
		Person p = people.get(0);
		assertEquals("Joe Schmoe", p.getFullname());
		verify(service);
	}

	@Test
	public void testGetPeopleAtPlaceWithRadiusAndHoursAgo() throws Exception {
		String xml = UtilsForTesting.readTestData("people.xml");
		Place place = Place.fromXML(UtilsForTesting.readTestData("place.xml"));
		String url = "http://brightkite.com/places/" + place.getId() + "/people.xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		Parameter radiusParam = new Parameter("radius", 2000);
		Parameter hoursParam = new Parameter("hours_ago", 2);
		Parameter[] params = new Parameter[]{radiusParam, hoursParam};
		expect(service.get(eq(url), aryEq(params))).andReturn(xml);
		replay(service);
		
		List<Person> people = bk.getPeopleAtPlace(place, 2000, 2);
		assertEquals(2, people.size());
		Person p = people.get(0);
		assertEquals("Joe Schmoe", p.getFullname());
		verify(service);
	}

	@Test
	public void testGetPlacemarksAtPlace() throws Exception {
		// Placemarks in xml don't correlate to place, just testing url and the fact that I get some placemarks back
		String xml = UtilsForTesting.readTestData("placemarks.xml");
		Place place = Place.fromXML(UtilsForTesting.readTestData("place.xml"));
		String url = "http://brightkite.com/places/" + place.getId() + "/placemarks.xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(url)).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		List<Placemark> placemarks = bk.getPlacemarksAtPlace(place);
		assertEquals(3, placemarks.size());
		Placemark p = placemarks.get(0);
		assertEquals("Snooze", p.getPlacemark());
		verify(service);
	}

	@Test
	public void testGetPlaceObjects() throws Exception {
		String url;
		HTTPService service;
		String noteXML = UtilsForTesting.readTestData("note.xml");
		Note note = Note.fromXML(noteXML);
		Brightkite bk = Brightkite.getInstance();
		
		service = getMockService();
		url = "http://brightkite.com/objects/" + note.getId() + ".xml";
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(url)).andReturn(noteXML);
		replay(service);
		bk.setCredentials("foo", "bar");
		Note returnedNote = bk.getNote(note.getId());
		assertEquals("No para hasta conquistar! Vamos Espa–a!", returnedNote.getBody());
		verify(service);
	}

	@Test
	public void testGetComment() throws Exception {
		String url;
		HTTPService service;
		// note doesn't necessarily match comments, just testing.
		String noteXML = UtilsForTesting.readTestData("note.xml");
		Note note = Note.fromXML(noteXML);
		String xml = UtilsForTesting.readTestData("comments.xml");
		Brightkite bk = Brightkite.getInstance();
		
		service = getMockService();
		url = "http://brightkite.com/objects/" + note.getId() + "/comments.xml";
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(url)).andReturn(xml);
		replay(service);
		bk.setCredentials("foo", "bar");
		List<Comment> comments = bk.getCommentsAboutPlaceObject(note);
		assertEquals(1, comments.size());
		assertEquals("And vice versa? ie \"The Leftovers of the Day\"", comments.get(0).getComment());
		verify(service);
	}

	@Test
	public void testLeaveComment() throws Exception {
		String url;
		HTTPService service;
		// note doesn't necessarily match comments, just testing.
		String noteXML = UtilsForTesting.readTestData("note.xml");
		Note note = Note.fromXML(noteXML);
		String xml = UtilsForTesting.readTestData("comment.xml");
		Brightkite bk = Brightkite.getInstance();
		
		service = getMockService();
		url = "http://brightkite.com/objects/" + note.getId() + "/comments.xml";
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		Parameter commentParam = new Parameter("comment[comment]", "84");
		Parameter watchParam = new Parameter("watch_item", false);
		Parameter[] params = new Parameter[]{ commentParam, watchParam };
		expect(service.post(eq(url), aryEq(params))).andReturn(xml);
		replay(service);
		bk.setCredentials("foo", "bar");
		Comment returnedComment = bk.leaveComment(note, "84");
		assertEquals("84", returnedComment.getComment());
		verify(service);
	}

	@Test
	public void testLeaveNote() throws Exception {
		String url;
		HTTPService service;
		// note doesn't necessarily match place, just testing.
		String placeXML = UtilsForTesting.readTestData("place.xml");
		Place usa = Place.fromXML(placeXML);
		String xml = UtilsForTesting.readTestData("note.xml");
		Brightkite bk = Brightkite.getInstance();
		
		service = getMockService();
		url = "http://brightkite.com/places/" + usa.getId() + "/notes.xml";
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		Parameter noteParam = new Parameter("note[body]", "No para hasta conquistar! Vamos Espa–a!");
		Parameter[] params = new Parameter[]{ noteParam };
		expect(service.post(eq(url), aryEq(params))).andReturn(xml);
		replay(service);
		bk.setCredentials("foo", "bar");
		Note returnedNote = bk.leaveNote(usa, "No para hasta conquistar! Vamos Espa–a!");
		assertEquals("No para hasta conquistar! Vamos Espa–a!", returnedNote.getBody());
		verify(service);
	}

	@Test
	public void testDMUser() throws Exception {
		String url;
		HTTPService service;
		// note doesn't necessarily match place, just testing.
		String personXML = UtilsForTesting.readTestData("person.xml");
		Person person = Person.fromXML(personXML);
		Brightkite bk = Brightkite.getInstance();
		
		service = getMockService();
		url = "http://brightkite.com/people/" + person.getLogin() + "/received_messages.xml";
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		// I know, this is the nudge message text.
		Parameter dmParam = new Parameter("message[body]", "Nudge Nudge! This would be a good time to check in and post something, I'm wondering what you're up to.");
		Parameter[] params = new Parameter[]{ dmParam };
		expect(service.post(eq(url), aryEq(params))).andReturn("");
		replay(service);
		bk.setCredentials("foo", "bar");
		bk.directMessage(person, "Nudge Nudge! This would be a good time to check in and post something, I'm wondering what you're up to.");
		verify(service);
	}

	@Test
	public void testGetUser() throws Exception {
		String url;
		HTTPService service;
		// note doesn't necessarily match place, just testing.
		String xml = UtilsForTesting.readTestData("person.xml");
		Brightkite bk = Brightkite.getInstance();
		
		service = getMockService();
		url = "http://brightkite.com/people/FrankZappa.xml";
		bk.setHttpService(service);
		expect(service.get(eq(url))).andReturn(xml);
		replay(service);
		Person person = bk.getPerson("FrankZappa");
		assertEquals("FrankZappa", person.getLogin());
		verify(service);
	}

	@Test
	public void testGetFriendshipForPerson() throws Exception {
		String xml = UtilsForTesting.readTestData("friendship.xml");
		Person person = Person.fromXML(UtilsForTesting.readTestData("person.xml"));
		String url = "http://brightkite.com/people/" + person.getLogin() + "/friendship.xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		service.setCredentials("foo", "bar");
		service.hasCredentials();
		expectLastCall().andReturn(true);
		expect(service.get(url)).andReturn(xml);
		replay(service);
		
		bk.setCredentials("foo", "bar");
		Friendship friendship = bk.getFriendshipForPerson(person);
		assertEquals("firetoad", friendship.getFriendable().getLogin());
		verify(service);
	}

	@Test
	public void testGetFriendsForPerson() throws Exception {
		String xml = UtilsForTesting.readTestData("friends.xml");
		Person person = Person.fromXML(UtilsForTesting.readTestData("person.xml"));
		String url = "http://brightkite.com/people/" + person.getLogin() + "/friends.xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		expect(service.get(url)).andReturn(xml);
		replay(service);
		
		List<Person> friends = bk.getFriendsOfPerson(person);
		assertEquals("Peacy P", friends.get(0).getFullname());
		verify(service);
	}

	@Test
	public void testGetPendingFriendsForPerson() throws Exception {
		String xml = UtilsForTesting.readTestData("pending_friends.xml");
		Person person = Person.fromXML(UtilsForTesting.readTestData("person.xml"));
		String url = "http://brightkite.com/people/" + person.getLogin() + "/pending_friends.xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		expect(service.get(url)).andReturn(xml);
		replay(service);
		
		List<Person> friends = bk.getPendingFriendsOfPerson(person);
		assertEquals("Joe Schmoe", friends.get(0).getFullname());
		verify(service);
	}

	@Test
	public void testGetPlaceObjectsByPerson() throws Exception {
		// notes dont correlate to person, just testing url and the fact that I get some notes back
		String xml = UtilsForTesting.readTestData("notes_at_place.xml");
		Person person = Person.fromXML(UtilsForTesting.readTestData("person.xml"));
		String url = "http://brightkite.com/people/" + person.getLogin() + "/objects.xml";
		Brightkite bk = Brightkite.getInstance();
		HTTPService service = getMockService();
		bk.setHttpService(service);
		expect(service.get(url, null)).andReturn(xml);
		replay(service);
		
		List<PlaceObject> objects = bk.getPlaceObjectsByPerson(person);
		Note note = (Note)objects.get(0);
		assertEquals("Simanda Home Solutons", note.getCreator().getFullname());
		verify(service);
	}

	private HTTPService getMockService() {
		return createMock(HTTPService.class);
	}
}
