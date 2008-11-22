package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

public class Photo extends PlaceObject {
	
	private String photo;

	public String getPhoto() {
		return photo;
	}

	protected void setPhoto(String photo) {
		this.photo = photo;
	}

	public final static Photo fromJSON(String jsonObject) {
		return fromJSON(JSONObject.fromObject(jsonObject));
	}
	
	public final static Photo fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		return (Photo)PlaceObject.fromJSON(jsonObject);
	}
	
	@Override
	public boolean isNote() {
		return false;
	}

	@Override
	public boolean isPhoto() {
		return true;
	}

}
