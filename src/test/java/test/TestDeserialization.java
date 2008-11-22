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
		
		System.out.println(testCheckin);
		DateTime createdAt = testCheckin.getCreatedAt();
		
		DateTime expectedCreatedAt = new DateTime(
				2008, 6, 10, 22, 46, 15, 0, DateTimeZone.UTC
		);

		assertEquals("da4b9237bacccdf19c0760cab7aec4a8359010b0", testCheckin.getId());
		assertTrue(testCheckin.isPublic());
		assertEquals("29 days", testCheckin.getCreatedAtAsWords());
		assertTrue(expectedCreatedAt.isEqual(createdAt));
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
