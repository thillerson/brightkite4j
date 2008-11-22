package net.brightkite4j.brightkite.models;

public class Comment extends BrightkiteObject {
	
	private PlaceObject placeObject;
	private Person user;
	private String comment;
	
	public PlaceObject getPlaceObject() {
		return placeObject;
	}

	protected void setPlaceObject(PlaceObject placeObject) {
		this.placeObject = placeObject;
	}

	public Person getUser() {
		return user;
	}

	protected void setUser(Person user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	protected void setComment(String comment) {
		this.comment = comment;
	}

}
