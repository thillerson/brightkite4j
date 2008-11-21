package net.brightkite4j.brightkite.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class BrightkiteUtils {

	//2008/11/19 15:32:51 +0000
	public final static DateTimeFormatter STD_DATE_TIME_FORMATTER = DateTimeFormat.forPattern("YYYY/MM/dd HH:mm:ss Z");

	public final static DateTime parseDateTimeFromString(String dateTimeString) {
		try {
			return STD_DATE_TIME_FORMATTER.parseDateTime(dateTimeString);
		} catch (IllegalArgumentException e) {
			System.err.println(String.format("Could not parse date string '%s'", dateTimeString));
			return null;
		}
	}

}
