package net.brightkite4j.brightkite.models;

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

}
