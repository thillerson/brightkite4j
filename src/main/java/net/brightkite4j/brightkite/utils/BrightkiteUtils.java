package net.brightkite4j.brightkite.utils;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import net.sf.json.util.PropertyFilter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class BrightkiteUtils {

	//2008/11/19 15:32:51 +0000
	public final static DateTimeFormatter STD_DATE_TIME_FORMATTER = DateTimeFormat.forPattern("YYYY/MM/dd HH:mm:ss Z");

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
	public final static Object fromJSON(String jsonString, Class klazz) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Object bean = JSONObject.toBean(jsonObject, getJsonConfig(klazz));
		return bean;
	}
	
	@SuppressWarnings("unchecked")
	public final static JsonConfig getJsonConfig(Class klazz) {
		JsonConfig config = new JsonConfig();
		config.setRootClass(klazz);
		config.setJavaPropertyFilter( new PropertyFilter(){    
			public boolean apply( Object source, String name, Object value ) {    
				if( "object_type".equals( name ) ){    
					return true;    
				}    
					return false;    
				}    
		}); 
		config.setJavaIdentifierTransformer(new SnakeToCamelIdentifierTransformer());
		config.setPropertySetStrategy(new DateTimePropertySetStrategy());
		JSONUtils.getMorpherRegistry().registerMorpher(new DateTimeFromBrightkiteStringMorpher());
        return config;
	}
	
}
