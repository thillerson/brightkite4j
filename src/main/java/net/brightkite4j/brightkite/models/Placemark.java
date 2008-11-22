package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

public class Placemark extends BrightkiteObject {
	
	private String placemark;
	private Person user;
	private Place place;

	public String getPlacemark() {
		return placemark;
	}

	protected void setPlacemark(String placemark) {
		this.placemark = placemark;
	}

	public Person getUser() {
		return user;
	}

	protected void setUser(Person user) {
		this.user = user;
	}

	public Place getPlace() {
		return place;
	}

	protected void setPlace(Place place) {
		this.place = place;
	}

	public final static Placemark fromJSON(String jsonObject) {
		return fromJSON(JSONObject.fromObject(jsonObject));
	}

	public final static Placemark fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		Placemark placemark = new Placemark();
		if (jsonObject.has("placemark")) {
			placemark.setPlacemark(jsonObject.getString("placemark"));
		}
		if (jsonObject.has("user")) {
			placemark.setUser(Person.fromJSON(jsonObject.getJSONObject("user")));
		}
		if (jsonObject.has("place")) {
			placemark.setPlace(Place.fromJSON(jsonObject.getJSONObject("place")));
		}
		BrightkiteObject.finishDeserialization(jsonObject, placemark);
		
		return placemark;
	}

}
