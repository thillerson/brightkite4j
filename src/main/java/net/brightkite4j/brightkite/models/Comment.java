package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

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

	public final static Comment fromJSON(String jsonString) {
		return fromJSON(JSONObject.fromObject(jsonString));
	}

	public final static Comment fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		Comment comment = new Comment();
		if (jsonObject.has("comment")) {
			comment.setComment(jsonObject.getString("comment"));
		}
		if (jsonObject.has("user")) {
			comment.setUser(Person.fromJSON(jsonObject.getJSONObject("user")));
		}
		if (jsonObject.has("place_object")) {
			comment.setPlaceObject(PlaceObject.fromJSON(jsonObject.getJSONObject("place_object")));
		}
		BrightkiteObject.finishDeserialization(jsonObject, comment);

		return comment;
	}

}
