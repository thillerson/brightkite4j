package test;

import static junit.framework.Assert.*;

import org.junit.Test;

import net.brightkite4j.brightkite.resources.PlaceObjectFilter;
import net.brightkite4j.brightkite.utils.SnakeCaseNameMapper;

public class TestUtils {
	
	@Test
	public void testSnakeCaseNameMapper() {
		SnakeCaseNameMapper mapper = new SnakeCaseNameMapper();
		String element = "Foo";
		assertEquals("foo", mapper.mapTypeToElementName(element));
		element = "FooBar";
		assertEquals("foo_bar", mapper.mapTypeToElementName(element));
		element = "FooBarBaz";
		assertEquals("foo_bar_baz", mapper.mapTypeToElementName(element));
		element = "justAJavaProperty";
		assertEquals("just_a_java_property", mapper.mapTypeToElementName(element));
	}
	
	@Test
	public void testPlaceObjectFilter() {
//		PlaceObjectFilter filter = new PlaceObjectFilter();
//		filter.setFilter(PlaceObjectFilter.NOTES | PlaceObjectFilter.PHOTOS);
//		assertEquals("?filters=notes,photos", filter.toString());
	}
	
}
