package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.CharBuffer;

import net.brightkite4j.brightkite.models.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import com.wutka.jox.JOXBeanInputStream;

public class TestDeserialization {
	
	@Test
	public void testDeserializeBlockFromXML() throws Exception {
		String blockXML = "<block>" +
				"<blocker>FrankZappa</blocker>" +
				"<blockee>batman</blockee>" +
				"<created_at type=\"datetime\">2008-07-10T20:08:35Z</created_at>" +
				"</block>";
        InputStream xmlReader = new ByteArrayInputStream(blockXML.getBytes());
        JOXBeanInputStream joxIn = new JOXBeanInputStream(xmlReader);
        Block testBlock = (Block)joxIn.readObject(Block.class);
        
        System.out.println(testBlock);
		DateTime createdAt = testBlock.getCreatedAt();
		
		DateTime expectedCreatedAt = new DateTime(
				2008, 7, 10, 20, 8, 35, 0, DateTimeZone.UTC
		);

		assertEquals("FrankZappa", testBlock.getBlocker());
		assertEquals("batman", testBlock.getBlockee());
		assertTrue(expectedCreatedAt.isEqual(createdAt));
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
