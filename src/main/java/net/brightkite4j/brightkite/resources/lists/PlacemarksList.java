package net.brightkite4j.brightkite.resources.lists;

import java.util.ArrayList;
import java.util.List;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.resources.Placemark;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class PlacemarksList {

	private List<Placemark> placemarks;
	
	public PlacemarksList() {
		placemarks = new ArrayList<Placemark>();
	}
	
	public List<Placemark> getPlacemarkList() {
		return placemarks;
	}
	
	public void addPlacemark(Placemark placemark) {
		placemarks.add(placemark);
	}
	
	public final static PlacemarksList fromXML(String xml) {
		try {
			PlacemarksList list = (PlacemarksList)BrightkiteUtils.fromXML(xml, PlacemarksList.class);
			return list;
		} catch (Exception e) {
			throw new DeserializationException("Cannot deserialize PlacemarksList.", e);
		}
	}
}
