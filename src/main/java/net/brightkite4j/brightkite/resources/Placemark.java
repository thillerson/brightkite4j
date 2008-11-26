package net.brightkite4j.brightkite.resources;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class Placemark extends BrightkiteObject {
	
	private String placemark;
	private Person user;
	private Place place;

	public String getPlacemark() {
		return placemark;
	}

	public void setPlacemark(String placemark) {
		this.placemark = placemark;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	public final static Placemark fromXML(String xml) {
		try {
			Placemark placemark = (Placemark)BrightkiteUtils.fromXML(xml, Placemark.class);
			return placemark;
		} catch (Exception e) {
			throw new DeserializationException("Could not deserialize Placemark.", e);
		}
	}

}
