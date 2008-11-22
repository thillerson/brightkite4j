package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

public class Checkin extends BrightkiteObject {
	
	private Place place;
	private Person creator;
	private boolean _public;
	
	public Place getPlace() {
		return place;
	}

	protected void setPlace(Place place) {
		this.place = place;
	}

	public Person getCreator() {
		return creator;
	}

	protected void setCreator(Person creator) {
		this.creator = creator;
	}

	public boolean isPublic() {
		return _public;
	}

	protected void setPublic(boolean _public) {
		this._public = _public;
	}

	public final static Checkin fromJSON(String jsonString) {
		return fromJSON(JSONObject.fromObject(jsonString));
	}

	public final static Checkin fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		Checkin checkin = new Checkin();
		if (jsonObject.has("place")) {
			checkin.setPlace(Place.fromJSON(jsonObject.getJSONObject("place")));
		}
		if (jsonObject.has("creator")) {
			checkin.setCreator(Person.fromJSON(jsonObject.getJSONObject("creator")));
		}
		if (jsonObject.has("public")) {
			checkin.setPublic(jsonObject.getBoolean("public"));
		}
		BrightkiteObject.finishDeserialization(jsonObject, checkin);
		return checkin;
	}

}
