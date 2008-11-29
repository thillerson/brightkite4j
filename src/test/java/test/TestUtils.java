package test;

import static junit.framework.Assert.*;

import org.junit.Test;

import net.brightkite4j.brightkite.resources.PlaceObjectFilter;

public class TestUtils {

	@Test
	public void testPlaceObjectFilter() {
		PlaceObjectFilter filter = new PlaceObjectFilter();
		assertEquals("", filter.toString());
		assertFalse(filter.filterSet());

		filter = PlaceObjectFilter.createFilter(PlaceObjectFilter.NOTES);
		assertTrue(filter.filterSet());
		assertEquals("?filter=notes", filter.toString());

		filter = PlaceObjectFilter.createFilter(PlaceObjectFilter.PHOTOS);
		assertTrue(filter.filterSet());
		assertEquals("?filter=photos", filter.toString());

		filter = PlaceObjectFilter.createFilter(PlaceObjectFilter.CHECKINS);
		assertTrue(filter.filterSet());
		assertEquals("?filter=checkins", filter.toString());

		filter = PlaceObjectFilter.createFilter(PlaceObjectFilter.CHECKINS | PlaceObjectFilter.NOTES);
		assertTrue(filter.filterSet());
		assertEquals("?filter=notes,checkins", filter.toString());

		filter = PlaceObjectFilter.createFilter(PlaceObjectFilter.CHECKINS | PlaceObjectFilter.PHOTOS);
		assertTrue(filter.filterSet());
		assertEquals("?filter=photos,checkins", filter.toString());

		filter = PlaceObjectFilter.createFilter(PlaceObjectFilter.NOTES | PlaceObjectFilter.PHOTOS);
		assertTrue(filter.filterSet());
		assertEquals("?filter=notes,photos", filter.toString());

		filter = PlaceObjectFilter.createFilter(PlaceObjectFilter.NOTES | PlaceObjectFilter.PHOTOS | PlaceObjectFilter.CHECKINS);
		assertTrue(filter.filterSet());
		assertEquals("?filter=notes,photos,checkins", filter.toString());
	}

}
