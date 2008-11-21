package net.brightkite4j.brightkite.models;

import org.joda.time.DateTime;

import net.brightkite4j.brightkite.utils.BrightkiteUtils;
import net.sf.json.JSONObject;

public abstract class PlaceObject {

	private String id;
	private String body;
	private Person creator;
	private Place place;
	private boolean _public;
	private boolean about;
	private DateTime createdAt;
	private String createdAtAsWords;

	public abstract boolean isNote();
	public abstract boolean isPhoto();
	
	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

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

	public DateTime getCreatedAt() {
		return createdAt;
	}

	protected void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	protected void setCreatedAt(String createdAtString) {
		this.createdAt = BrightkiteUtils.parseDateTimeFromString(createdAtString);
	}

	public String getCreatedAtAsWords() {
		return createdAtAsWords;
	}

	protected void setCreatedAtAsWords(String createdAtAsWords) {
		this.createdAtAsWords = createdAtAsWords;
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
		if (jsonObject.has("id")) {
			placeObject.setId(jsonObject.getString("id"));
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
		if (jsonObject.has("created_at")) {
			placeObject.setCreatedAt(jsonObject.getString("created_at"));
		}
		if (jsonObject.has("created_at_as_words")) {
			placeObject.setCreatedAtAsWords(jsonObject.getString("created_at_as_words"));
		}

		return placeObject;
	}
	
}
