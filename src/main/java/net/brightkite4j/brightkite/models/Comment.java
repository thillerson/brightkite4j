package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

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
	
	public final static Comment fromXML(String xml) {
		try {
			Comment comment = (Comment)BrightkiteUtils.fromXML(xml, Comment.class);
			return comment;
		} catch (Exception e) {
			throw new DeserializationException("Could not deserialize Comment.", e);
		}
	}

}
