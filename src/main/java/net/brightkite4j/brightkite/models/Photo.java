package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Photo extends PlaceObject {
	
	private String photo;

	public String getPhoto() {
		return photo;
	}

	protected void setPhoto(String photo) {
		this.photo = photo;
	}

	protected final static Photo fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		Photo photo = new Photo();
		
		if (jsonObject.has("photo")) {
			photo.setPhoto(jsonObject.getString("photo"));
		}

		return photo;
	}
	
	@Override
	public boolean isNote() {
		return false;
	}

	@Override
	public boolean isPhoto() {
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
