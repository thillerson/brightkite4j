package test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class UtilsForTesting {
	
	private static String TEST_DATA_DIR = "src/test/data/";
	private static int MAX_TEST_DATA_FILE_SIZE = 16384;

	public static String readTestData(String fileName) throws IOException {
		return readFromFile(new File(TEST_DATA_DIR, fileName));
	}

	private static String readFromFile(File file) throws IOException {
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
