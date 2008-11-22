package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

public abstract class PlaceObject extends BrightkiteObject {

	private String body;
	private Person creator;
	private Place place;
	private boolean _public;
	private boolean about;

	public abstract boolean isNote();
	public abstract boolean isPhoto();
	
	public String getBody() {
		return body;
	}

	protected void setBody(String body) {
		this.body = body;
	}

	public Person getCreator() {
		return creator;
	}

	protected void setCreator(Person creator) {
		this.creator = creator;
	}

	public Place getPlace() {
		return place;
	}

	protected void setPlace(Place place) {
		this.place = place;
	}

	public boolean isPublic() {
		return _public;
	}

	protected void setPublic(boolean _public) {
		this._public = _public;
	}

	public boolean isAbout() {
		return about;
	}

	protected void setAbout(boolean about) {
		this.about = about;
	}

	protected static PlaceObject fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		PlaceObject placeObject;
		
		// cheez alert
		if (jsonObject.has("photo")) {
			placeObject = new Photo();

			Photo photo = (Photo)placeObject;
			photo.setPhoto(jsonObject.getString("photo"));
			
		} else {
			placeObject = new Note();
		}
		if (jsonObject.has("body")) {
			placeObject.setBody(jsonObject.getString("body"));
		}
		if (jsonObject.has("creator")) {
			placeObject.setCreator(Person.fromJSON(jsonObject.getJSONObject("creator")));
		}
		if (jsonObject.has("place")) {
			placeObject.setPlace(Place.fromJSON(jsonObject.getJSONObject("place")));
		}
		if (jsonObject.has("public")) {
			placeObject.setPublic(jsonObject.getBoolean("public"));
		}
		if (jsonObject.has("about")) {
			placeObject.setAbout(jsonObject.getBoolean("about"));
		}
		BrightkiteObject.finishDeserialization(jsonObject, placeObject);

		return placeObject;
	}
	
}
