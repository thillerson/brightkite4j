package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import net.brightkite4j.brightkite.models.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class TestDeserialization {
	
	@Test
	public void testDeserializeBlockFromXML() throws Exception {
		String xml = readTestData("block.xml");

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
		String xml = readTestData("checkin.xml");

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
		assertEquals("", creator.getFullname());
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
	
	private String TEST_DATA_DIR = "src/test/data/";

	private int MAX_TEST_DATA_FILE_SIZE = 16384;

	private String readTestData(String fileName) throws IOException {
		return readFromFile(new File(TEST_DATA_DIR, fileName));
	}

	private String readFromFile(File file) throws IOException {
		Reader is = new FileReader(file);
		StringBuffer sb = new StringBuffer( );
		char[] b = new char[MAX_TEST_DATA_FILE_SIZE];
		int n;
		
		    // Read a block. If it gets any chars, append them.
		while ((n = is.read(b)) > 0) {
		    sb.append(b, 0, n);
		}
		
		// Only construct the String object once, here.
		return sb.toString( );
	}

}
