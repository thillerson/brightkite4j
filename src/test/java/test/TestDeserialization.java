package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.brightkite4j.brightkite.models.*;
import net.sf.json.JSONObject;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class TestDeserialization {
	
	@Test
	// By the by, I hate everything to do with Java regexes.
	// Ruby: "object_type".gsub(/_([a-z])/) { |s| $1.upcase }
	public void testStringReplacement() {
		String s = "object_type";
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile("_([a-z])");
		Matcher m = p.matcher(s);
		while (m.find()) {
			m.appendReplacement(sb, m.group().replace("_", "").toUpperCase());
		}
		m.appendTail(sb);
		assertEquals("objectType", sb.toString());
	}
	
	@Test
	public void testDeserializeBlockFromJSON() throws Exception {
		String blockJSON = readTestData("block.json");
		Block testBlock = Block.fromJSON(blockJSON);
		
//		DateTime createdAt = testBlock.getCreatedAt();
//		
//		DateTime expectedCreatedAt = new DateTime(
//				2008, 7, 10, 20, 8, 35, 0, DateTimeZone.UTC
//		);
//
//		assertEquals("FrankZappa", testBlock.getBlocker());
//		assertEquals("batman", testBlock.getBlockee());
//		assertNull(testBlock.getCreatedAt());
//		assertTrue(expectedCreatedAt.isEqual(createdAt));
	}
	
	@Test
	public void testDeserializeCheckinFromJSON() throws Exception {
		String checkinJSON = readTestData("checkin.json");
		Checkin testCheckin = Checkin.fromJSON(checkinJSON);
		
		DateTime createdAt = testCheckin.getCreatedAt();
		Person creator = testCheckin.getCreator();
		Place place = testCheckin.getPlace();
		
		DateTime expectedCreatedAt = new DateTime(
				2008, 6, 10, 22, 46, 15, 0, DateTimeZone.UTC
		);

		// Checkin
		assertTrue(testCheckin.isPublic());
		assertEquals("29 days", testCheckin.getCreatedAtAsWords());
		assertEquals("da4b9237bacccdf19c0760cab7aec4a8359010b0", testCheckin.getId());
		assertTrue(expectedCreatedAt.isEqual(createdAt));
		
		// Person
		assertEquals("", creator.getFullname());
		assertEquals("firetoad", creator.getLogin());
		assertEquals("/images/default_user_avatar_small.png", creator.getSmallAvatarUrl());
		assertEquals("/images/default_user_avatar_smaller.png", creator.getSmallerAvatarUrl());
		assertEquals("/images/default_user_avatar_tiny.png", creator.getTinyAvatarUrl());

		// Place
		assertEquals("address", place.getScope());
		assertEquals("3850 Paseo del Prado St, Boulder, CO 80301, USA", place.getName());
		assertEquals("3850 Paseo Del Prado St, Boulder, CO 80301, USA", place.getDisplayLocation());
		assertEquals("356a192b7913b04c54574d18c28d46e6395428ab", place.getId());
		assertEquals(-105.256712, place.getLongitude(), .000001);
		assertEquals(40.044001, place.getLatitude(), .000001);
	}

	@Test
	public void testDeserializeCommentFromJSON() throws Exception {
		String commentJSON = readTestData("comment.json");
		Comment comment = Comment.fromJSON(commentJSON);
		
		Person user = comment.getUser();
		assertTrue(comment.getPlaceObject().isNote());
		Note note = (Note)comment.getPlaceObject();

		DateTime commentCreatedAt = comment.getCreatedAt();
		DateTime noteCreatedAt = note.getCreatedAt();
		DateTime userLastCheckedIn = user.getLastCheckedIn();

		DateTime expectedCommentCreatedAt = new DateTime(
				2008, 6, 12, 21, 59, 27, 0, DateTimeZone.UTC
		);
		DateTime expectedNoteCreatedAt = new DateTime(
				2008, 6, 12, 18, 45, 18, 0, DateTimeZone.UTC
		);
		DateTime expectedUserLastCheckedIn = new DateTime(
				2008, 7, 8, 20, 19, 59, 0, DateTimeZone.UTC
		);
		
		// Comment
		assertEquals("wooo comment!", comment.getComment());
//		assertTrue(expectedCommentCreatedAt.isEqual(commentCreatedAt));
		
		// Person
		assertEquals("", user.getFullname());
		assertEquals("firetoad", user.getLogin());
		assertNull(user.getAge());
		assertEquals("", user.getWebsite());
		assertEquals("GA:LEIR{JBGes[R*h30rheasOLFhESrtuhw2rt9hwet9q3784ht[q934hrtq[kehs;rf;ghkj[or239203h", user.getDescription());
		assertEquals("male", user.getSex());
		assertEquals("/images/default_user_avatar_small.png", user.getSmallAvatarUrl());
		assertEquals("/images/default_user_avatar_smaller.png", user.getSmallerAvatarUrl());
		assertEquals("/images/default_user_avatar_tiny.png", user.getTinyAvatarUrl());
		assertTrue(expectedUserLastCheckedIn.isEqual(userLastCheckedIn));

		// Note
		assertEquals("a new note", note.getBody());
		assertEquals("28 days", note.getCreatedAtAsWords());
		assertEquals("7719a1c782a1ba91c031a682a0a2f8658209adbf", note.getId());
		assertTrue(note.isPublic());
		assertTrue(note.isAbout());
		assertTrue(noteCreatedAt.isEqual(expectedNoteCreatedAt));

//		assertEquals(-105.256712, note.getLongitude(), .000001);
//		assertEquals(40.044001, note.getLatitude(), .000001);
	}

	private String TEST_DATA_DIR = "src/test/data/";

	private int MAX_TEST_DATA_FILE_SIZE = 16384;

	private String readTestData(String fileName) throws IOException {
		return readFromFile(new File(TEST_DATA_DIR, fileName));
	}

	private String readFromFile(File file) throws IOException {
		Reader reader = new FileReader(file);
		CharBuffer charBuffer = CharBuffer.allocate(MAX_TEST_DATA_FILE_SIZE);
		reader.read(charBuffer);
		charBuffer.position(0);
		return charBuffer.toString();
	}

}
