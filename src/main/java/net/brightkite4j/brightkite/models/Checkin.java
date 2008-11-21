package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.utils.BrightkiteUtils;
import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

public class Checkin {
	
	private String id;
	private Place place;
	private Person creator;
	private boolean _public;
	private DateTime createdAt;
	private String createdAtAsWords;
	
	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

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
	
	public final static Checkin fromJSONString(String jsonString) {
		return fromJSON(JSONObject.fromObject(jsonString));
	}

	public final static Checkin fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		Checkin checkin = new Checkin();
		if (jsonObject.has("id")) {
			checkin.setId(jsonObject.getString("id"));
		}
		if (jsonObject.has("place")) {
			checkin.setPlace(Place.fromJSON(jsonObject.getJSONObject("place")));
		}
		if (jsonObject.has("creator")) {
			checkin.setCreator(Person.fromJSON(jsonObject.getJSONObject("creator")));
		}
		if (jsonObject.has("public")) {
			checkin.setPublic(jsonObject.getBoolean("public"));
		}
		if (jsonObject.has("created_at")) {
			checkin.setCreatedAt(jsonObject.getString("created_at"));
		}
		if (jsonObject.has("created_at_as_words")) {
			checkin.setCreatedAtAsWords(jsonObject.getString("created_at_as_words"));
		}

		return checkin;
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
