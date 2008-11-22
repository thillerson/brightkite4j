package net.brightkite4j.brightkite.models;

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

}
