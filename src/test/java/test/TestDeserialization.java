package test;

import static org.junit.Assert.*;

import net.brightkite4j.brightkite.resources.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Ignore;
import org.junit.Test;

public class TestDeserialization {
	
	@Test
	public void testDeserializeBlockFromXML() throws Exception {
		String xml = UtilsForTesting.readTestData("block.xml");

		Block testBlock = Block.fromXML(xml);

		DateTime createdAt = testBlock.getCreatedAt();
		
		DateTime expectedCreatedAt = new DateTime(
				2008, 7, 10, 20, 8, 35, 0, DateTimeZone.UTC
		);

		assertEquals("FrankZappa", testBlock.getBlocker());
		assertEquals("batman", testBlock.getBlockee());
		assertTrue(expectedCreatedAt.isEqual(createdAt));
	}
	
	@Test
	public void testDeserializeCheckinFromXML() throws Exception {
		String xml = UtilsForTesting.readTestData("checkin.xml");

		Checkin testCheckin = Checkin.fromXML(xml);  
		
		DateTime createdAt = testCheckin.getCreatedAt();
		Person creator = testCheckin.getCreator();
		Place place = testCheckin.getPlace();
		
		DateTime expectedCreatedAt = new DateTime(
				2008, 6, 10, 22, 46, 15, 0, DateTimeZone.UTC
		);

		//Checkin
		assertEquals("da4b9237bacccdf19c0760cab7aec4a8359010b0", testCheckin.getId());
		assertTrue(testCheckin.isPublic());
		assertEquals("29 days", testCheckin.getCreatedAtAsWords());
		assertTrue(expectedCreatedAt.isEqual(createdAt));
		
		//Creator
		assertNull(creator.getFullname());
		assertEquals("firetoad", creator.getLogin());
		assertEquals("/images/default_user_avatar_small.png", creator.getSmallAvatarUrl());
		assertEquals("/images/default_user_avatar_smaller.png", creator.getSmallerAvatarUrl());
		assertEquals("/images/default_user_avatar_tiny.png", creator.getTinyAvatarUrl());
		
		//Place
		assertEquals("address", place.getScope());
		assertEquals("356a192b7913b04c54574d18c28d46e6395428ab", place.getId());
		assertEquals("3850 Paseo del Prado St, Boulder, CO 80301, USA", place.getName());
		assertEquals("3850 Paseo Del Prado St, Boulder, CO 80301, USA", place.getDisplayLocation());
		assertEquals(-105.256712, place.getLongitude(), 0.000001);
		assertEquals(40.044001, place.getLatitude(), 0.000001);
	}
	
	@Test
	public void testDeserializeDirectMessageFromXML() throws Exception {
		String xml = UtilsForTesting.readTestData("direct_message.xml");

		DirectMessage directMessage = DirectMessage.fromXML(xml);  
		
		DateTime createdAt = directMessage.getCreatedAt();
		Person sender = directMessage.getSender();
		Person recipient = directMessage.getRecipient();
		
		DateTime expectedCreatedAt = new DateTime(
				2008, 6, 20, 21, 33, 28, 0, DateTimeZone.UTC
		);

		//Checkin
		assertEquals("Nudge Nudge! This would be a good time to check in and post something, I'm wondering what you're up to.", directMessage.getBody());
		assertEquals("19 days", directMessage.getCreatedAtAsWords());
		assertFalse(directMessage.isRead());
		assertTrue(directMessage.isUnread());
		assertTrue(expectedCreatedAt.isEqual(createdAt));
		
		//Sender
		assertNull(sender.getFullname());
		assertEquals("firetoad", sender.getLogin());
		assertEquals("/images/default_user_avatar_small.png", sender.getSmallAvatarUrl());
		assertEquals("/images/default_user_avatar_smaller.png", sender.getSmallerAvatarUrl());
		assertEquals("/images/default_user_avatar_tiny.png", sender.getTinyAvatarUrl());
		
		//Recipient
		assertEquals("Me!", recipient.getFullname());
		assertEquals("mike", recipient.getLogin());
		assertEquals("/images/default_user_avatar_small.png", recipient.getSmallAvatarUrl());
		assertEquals("/images/default_user_avatar_smaller.png", recipient.getSmallerAvatarUrl());
		assertEquals("/images/default_user_avatar_tiny.png", recipient.getTinyAvatarUrl());
	}

	@Test
	public void testDeserializeFriendshipFromXML() throws Exception {
		String xml = UtilsForTesting.readTestData("friendship.xml");

		Friendship friendship = Friendship.fromXML(xml);  
		
		DateTime createdAt = friendship.getCreatedAt();
		Person friendable = friendship.getFriendable();
		Person user = friendship.getUser();
		
		DateTime expectedCreatedAt = new DateTime(
				2008, 6, 18, 22, 50, 17, 0, DateTimeZone.UTC
		);

		//Friendship
		assertFalse(friendship.isPostEmailNotifications());
		assertFalse(friendship.isCheckinEmailNotifications());
		assertFalse(friendship.isTrusted());
		assertTrue(friendship.isPostStreamFeeding());
		assertTrue(friendship.isCheckinStreamFeeding());
		assertFalse(friendship.isPostSMSNotifications());
		assertFalse(friendship.isCheckinSMSNotifications());
		assertTrue(expectedCreatedAt.isEqual(createdAt));
		
		//Friendable
		assertNull(friendable.getFullname());
		assertEquals("firetoad", friendable.getLogin());
		assertEquals("/images/default_user_avatar_small.png", friendable.getSmallAvatarUrl());
		assertEquals("/images/default_user_avatar_smaller.png", friendable.getSmallerAvatarUrl());
		assertEquals("/images/default_user_avatar_tiny.png", friendable.getTinyAvatarUrl());
		
		//User
		assertEquals("Me!", user.getFullname());
		assertEquals("mike", user.getLogin());
		assertEquals("/images/default_user_avatar_small.png", user.getSmallAvatarUrl());
		assertEquals("/images/default_user_avatar_smaller.png", user.getSmallerAvatarUrl());
		assertEquals("/images/default_user_avatar_tiny.png", user.getTinyAvatarUrl());
	}

	@Test
	public void testDeserializePersonFromXML() throws Exception {
		String xml = UtilsForTesting.readTestData("person.xml");

		Person person = Person.fromXML(xml);  
		
		DateTime expectedLastCheckedInAt = new DateTime(
				2008, 7, 10, 20, 8, 35, 0, DateTimeZone.UTC
		);

		//Person
		assertNull(person.getFullname());
		assertEquals("FrankZappa", person.getLogin());
		assertEquals("Totally sweet", person.getDescription());
		assertNull(person.getWebsite());
		assertNull(person.getAge());
		assertEquals("unspecified", person.getSex());
		assertEquals("/images/default_user_avatar_small.png", person.getSmallAvatarUrl());
		assertEquals("/images/default_user_avatar_smaller.png", person.getSmallerAvatarUrl());
		assertEquals("/images/default_user_avatar_tiny.png", person.getTinyAvatarUrl());
		assertTrue(expectedLastCheckedInAt.isEqual(person.getLastCheckedIn()));
	}

	@Test
	public void testDeserializePlaceFromXML() throws Exception {
		String xml = UtilsForTesting.readTestData("place.xml");

		Place place = Place.fromXML(xml);
		
		//Place
		assertEquals("da4b9237bacccdf19c0760cab7aec4a8359010b0", place.getId());
		assertEquals("country", place.getScope());
		assertEquals("USA", place.getName());
		assertEquals("USA", place.getDisplayLocation());
		assertNull(place.getStreet());
		assertNull(place.getStreet2());
		assertNull(place.getCity());
		assertNull(place.getState());
		assertNull(place.getZip());
		assertEquals(-95.712891, place.getLongitude(), 0.000001);
		assertEquals(37.090240, place.getLatitude(), 0.000001);
	}

	@Test
	public void testDeserializePlacemarkFromXML() throws Exception {
		String xml = UtilsForTesting.readTestData("placemark.xml");

		Placemark placemark = Placemark.fromXML(xml);
		Place place = placemark.getPlace();
		Person user = placemark.getUser();
		
		DateTime expectedCreatedAt = new DateTime(
				2008, 6, 10, 16, 36, 31, 0, DateTimeZone.forOffsetHours(-6)
		);
		
		//Placemark
		assertEquals("blee", placemark.getPlacemark());
		assertTrue(expectedCreatedAt.isEqual(placemark.getCreatedAt()));
		
		//Place
		assertEquals("356a192b7913b04c54574d18c28d46e6395428ab", place.getId());
		assertEquals("address", place.getScope());
		assertEquals("3850 Paseo del Prado St, Boulder, CO 80301, USA", place.getName());
		assertEquals("3850 Paseo Del Prado St, Boulder, CO 80301, USA", place.getDisplayLocation());
		assertEquals(-105.256712, place.getLongitude(), 0.000001);
		assertEquals(40.044001, place.getLatitude(), 0.000001);
		
		//Person
		assertNull(user.getFullname());
		assertEquals("firetoad", user.getLogin());
		assertEquals("/images/default_user_avatar_small.png", user.getSmallAvatarUrl());
		assertEquals("/images/default_user_avatar_smaller.png", user.getSmallerAvatarUrl());
		assertEquals("/images/default_user_avatar_tiny.png", user.getTinyAvatarUrl());
	}

	@Test
	public void testDeserializeNoteFromXML() throws Exception {
		String xml = UtilsForTesting.readTestData("note.xml");

		Note note = Note.fromXML(xml);
		Place place = note.getPlace();
		Person creator = note.getCreator();
		
		DateTime expectedCreatedAt = new DateTime(
				2008, 7, 1, 16, 57, 37, 0, DateTimeZone.UTC
		);
		
		//Note
		assertEquals("fe2ef495a1152561572949784c16bf23abb28057", note.getId());
		assertEquals("No para hasta conquistar! Vamos Espa–a!", note.getBody());
		assertEquals("9 days", note.getCreatedAtAsWords());
		assertTrue(note.isAbout());
		assertTrue(note.isPublic());
		assertTrue(expectedCreatedAt.isEqual(note.getCreatedAt()));
		
		//Place
		assertEquals("da4b9237bacccdf19c0760cab7aec4a8359010b0", place.getId());
		assertEquals("country", place.getScope());
		assertEquals("USA", place.getName());
		assertEquals("USA", place.getDisplayLocation());
		assertEquals(-95.712891, place.getLongitude(), 0.000001);
		assertEquals(37.090240, place.getLatitude(), 0.000001);
		
		//Person
		assertNull(creator.getFullname());
		assertEquals("FrankZappa", creator.getLogin());
		assertEquals("/images/default_user_avatar_small.png", creator.getSmallAvatarUrl());
		assertEquals("/images/default_user_avatar_smaller.png", creator.getSmallerAvatarUrl());
		assertEquals("/images/default_user_avatar_tiny.png", creator.getTinyAvatarUrl());
	}

	@Test
	public void testDeserializePlaceObjectFromPhotoXML() throws Exception {
		String xml = UtilsForTesting.readTestData("photo.xml");

		Photo photo = Photo.fromXML(xml);
		Place place = photo.getPlace();
		Person creator = photo.getCreator();
		
		DateTime expectedCreatedAt = new DateTime(
				2008, 7, 3, 19, 53, 58, 0, DateTimeZone.UTC
		);
		
		//Photo
		assertEquals("3a76426bffc90ffae044d5b29b10be6350a27397", photo.getId());
		assertEquals("El Ni–o", photo.getBody());
		assertEquals("7 days", photo.getCreatedAtAsWords());
		assertFalse(photo.isAbout());
		assertTrue(photo.isPublic());
		assertTrue(expectedCreatedAt.isEqual(photo.getCreatedAt()));
		
		//Place
		assertEquals("356a192b7913b04c54574d18c28d46e6395428ab", place.getId());
		assertEquals("address", place.getScope());
		assertEquals("Brightkite HQ", place.getName());
		assertEquals("2911 Walnut St, Denver, CO 80205, USA", place.getDisplayLocation());
		assertEquals(-104.982480, place.getLongitude(), 0.000001);
		assertEquals(39.762146, place.getLatitude(), 0.000001);
		
		//Person
		assertEquals("M. Collins", creator.getFullname());
		assertEquals("mcollins", creator.getLogin());
		assertEquals("/images/user/avatar/2292/me-small.png", creator.getSmallAvatarUrl());
		assertEquals("/images/user/avatar/2292/me-smaller.png", creator.getSmallerAvatarUrl());
		assertEquals("/images/user/avatar/2292/me-tiny.png", creator.getTinyAvatarUrl());
	}

	@Ignore
	public void testDeserializeCommentFromXML() throws Exception {

		String xml = UtilsForTesting.readTestData("comment.xml");
		Comment comment = Comment.fromXML(xml);
		DateTime expectedCreatedAt = new DateTime(
				2008, 11, 22, 2, 36, 1, 0, DateTimeZone.UTC
		);

		assertEquals("84", comment.getComment());
		assertEquals("3 days", comment.getCreatedAtAsWords());
		assertTrue(expectedCreatedAt.isEqual(comment.getCreatedAt()));
		assertEquals("Jim Bob", comment.getUser().getFullname());
	}

}
