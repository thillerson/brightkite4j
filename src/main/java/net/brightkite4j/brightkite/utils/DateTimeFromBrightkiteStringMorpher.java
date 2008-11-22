package net.brightkite4j.brightkite.utils;

import org.joda.time.DateTime;

import net.sf.ezmorph.MorphException;
import net.sf.ezmorph.ObjectMorpher;

public class DateTimeFromBrightkiteStringMorpher implements ObjectMorpher {

	public Object morph(Object value) {
		DateTime dt = null;
		try {
			String timeStamp = (String)value;
			dt = BrightkiteUtils.parseDateTimeFromString(timeStamp);
		} catch (Exception e) {
			throw new MorphException("Unable to morph to DateTime");
		}
		return dt;
	}

	@SuppressWarnings("unchecked")
	public Class morphsTo() {
		return DateTime.class;
	}

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return (clazz.equals(DateTime.class));
	}

}
