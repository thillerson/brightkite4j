package net.brightkite4j.brightkite.utils;

import java.beans.IntrospectionException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import net.brightkite4j.brightkite.models.Note;
import net.brightkite4j.brightkite.models.Photo;

import org.apache.commons.betwixt.io.BeanReader;
import org.apache.commons.betwixt.io.read.BeanCreationChain;
import org.apache.commons.betwixt.io.read.BeanCreationList;
import org.apache.commons.betwixt.strategy.ListedClassNormalizer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.xml.sax.SAXException;

public class BrightkiteUtils {

	//2008-07-10T20:08:35Z
	public final static DateTimeFormatter STD_DATE_TIME_FORMATTER = ISODateTimeFormat.dateTimeParser();

	public final static DateTime parseDateTimeFromString(String dateTimeString) {
		try {
			if (dateTimeString == null) {
				return null;
			}
			return STD_DATE_TIME_FORMATTER.parseDateTime(dateTimeString);
		} catch (IllegalArgumentException e) {
			System.err.println(String.format("Could not parse date string '%s'", dateTimeString));
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public final static Object fromXML(String xml, Class clazz) throws IntrospectionException, IOException, SAXException {
		InputStream blockXML = new ByteArrayInputStream(xml.getBytes());
		BeanReader beanReader = new BeanReader();
		BeanCreationList chain = BeanCreationList.createStandardChain();
		chain.insertBeanCreator(1, new PlaceObjectBeanCreator());
		beanReader.registerBeanClass(clazz);
		beanReader.getReadConfiguration().setBeanCreationChain(chain);
		Object bean = beanReader.parse(blockXML);
		return bean;
	}
	
}
