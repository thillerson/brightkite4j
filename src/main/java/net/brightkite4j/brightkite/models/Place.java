package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

public class Place extends BrightkiteObject {
	
	private String name;
	private String displayLocation;
	private String scope;
	private String street;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private double latitude;
	private double longitude;

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public String getDisplayLocation() {
		return displayLocation;
	}

	protected void setDisplayLocation(String displayLocation) {
		this.displayLocation = displayLocation;
	}

	public String getScope() {
		return scope;
	}

	protected void setScope(String scope) {
		this.scope = scope;
	}

	public String getStreet() {
		return street;
	}

	protected void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	protected void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	protected void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	protected void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	protected void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	protected void setCountry(String country) {
		this.country = country;
	}

	public double getLatitude() {
		return latitude;
	}

	protected void setLatitude(double d) {
		this.latitude = d;
	}

	public double getLongitude() {
		return longitude;
	}

	protected void setLongitude(double d) {
		this.longitude = d;
	}

	public final static Place fromJSON(String jsonObject) {
		return fromJSON(JSONObject.fromObject(jsonObject));
	}

	public final static Place fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		Place place = new Place();
		if (jsonObject.has("name")) {
			place.setName(jsonObject.getString("name"));
		}
		if (jsonObject.has("display_location")) {
			place.setDisplayLocation(jsonObject.getString("display_location"));
		}
		if (jsonObject.has("scope")) {
			place.setScope(jsonObject.getString("scope"));
		}
		if (jsonObject.has("street")) {
			place.setStreet(jsonObject.getString("street"));
		}
		if (jsonObject.has("street2")) {
			place.setStreet2(jsonObject.getString("street2"));
		}
		if (jsonObject.has("city")) {
			place.setCity(jsonObject.getString("city"));
		}
		if (jsonObject.has("state")) {
			place.setState(jsonObject.getString("state"));
		}
		if (jsonObject.has("zip")) {
			place.setZip(jsonObject.getString("zip"));
		}
		if (jsonObject.has("country")) {
			place.setCountry(jsonObject.getString("country"));
		}
		if (jsonObject.has("latitude")) {
			place.setLatitude(jsonObject.getDouble("latitude"));
		}
		if (jsonObject.has("longitude")) {
			place.setLongitude(jsonObject.getDouble("longitude"));
		}
		BrightkiteObject.finishDeserialization(jsonObject, place);

		return place;
	}
}
