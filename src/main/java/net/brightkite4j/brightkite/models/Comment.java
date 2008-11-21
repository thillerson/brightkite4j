package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.utils.BrightkiteUtils;
import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

public class Comment {
	
	private PlaceObject placeObject;
	private Person user;
	private String comment;
	private DateTime createdAt;
	
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

	public DateTime getCreatedAt() {
		return createdAt;
	}

	protected void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	protected void setCreatedAt(String createdAtString) {
		this.createdAt = BrightkiteUtils.parseDateTimeFromString(createdAtString);
	}

	protected final static Comment fromJSON(JSONObject jsonObject) {
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
		if (jsonObject.has("created_at")) {
			comment.setCreatedAt(jsonObject.getString("created_at"));
		}

		return comment;
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
