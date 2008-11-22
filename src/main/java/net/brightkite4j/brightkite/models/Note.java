package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

public class Note extends PlaceObject {
	
	public final static Note fromJSON(String jsonObject) {
		return fromJSON(JSONObject.fromObject(jsonObject));
	}
	
	public final static Note fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		
		return (Note)PlaceObject.fromJSON(jsonObject);
	}

	@Override
	public boolean isNote() {
		return true;
	}

	@Override
	public boolean isPhoto() {
		return false;
	}


}
