package net.brightkite4j.brightkite.resources;

import java.util.ArrayList;
import java.util.List;

public class PlaceObjectFilter {

	public static final int NOTES = 1;
	public static final int PHOTOS = 10;
	public static final int CHECKINS = 100;
	
	private int mask = 0;
	
	public static PlaceObjectFilter createFilter(int i) {
		PlaceObjectFilter filter = new PlaceObjectFilter();
		return filter.setFilter(i);
	}
	
	public PlaceObjectFilter setFilter(int i) {
		mask |= i;
		return this;
	}
	
	public boolean filterSet() {
		return (mask != 0);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		List<String> filters = new ArrayList<String>();
		if ((mask & NOTES) != 0) {
			filters.add("notes");
		}
		if ((mask & PHOTOS) != 0) {
			filters.add("photos");
		}
		if ((mask & CHECKINS) != 0) {
			filters.add("checkins");
		}
		for (int i=0; i < filters.size(); i++) {
			sb.append(filters.get(i));
			if (i < filters.size() - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
}
