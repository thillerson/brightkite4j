package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Note extends PlaceObject {
	
	protected final static Note fromJSON(JSONObject jsonObject) {
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
