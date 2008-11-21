package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Place {
	
	private String id;
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

	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

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

	protected final static Place fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		Place person = new Place();
		if (jsonObject.has("id")) {
			person.setId(jsonObject.getString("id"));
		}
		if (jsonObject.has("name")) {
			person.setName(jsonObject.getString("name"));
		}
		if (jsonObject.has("displayLocation")) {
			person.setDisplayLocation(jsonObject.getString("displayLocation"));
		}
		if (jsonObject.has("scope")) {
			person.setScope(jsonObject.getString("scope"));
		}
		if (jsonObject.has("street")) {
			person.setStreet(jsonObject.getString("street"));
		}
		if (jsonObject.has("street2")) {
			person.setStreet2(jsonObject.getString("street2"));
		}
		if (jsonObject.has("city")) {
			person.setCity(jsonObject.getString("city"));
		}
		if (jsonObject.has("state")) {
			person.setState(jsonObject.getString("state"));
		}
		if (jsonObject.has("zip")) {
			person.setZip(jsonObject.getString("zip"));
		}
		if (jsonObject.has("country")) {
			person.setCountry(jsonObject.getString("country"));
		}
		if (jsonObject.has("latitude")) {
			person.setLatitude(jsonObject.getDouble("latitude"));
		}
		if (jsonObject.has("longitude")) {
			person.setLongitude(jsonObject.getDouble("longitude"));
		}
		
		return person;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
