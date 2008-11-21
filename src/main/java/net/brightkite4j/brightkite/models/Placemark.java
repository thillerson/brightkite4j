package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.utils.BrightkiteUtils;
import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

public class Placemark {
	
	private String placemark;
	private Person user;
	private Place place;
	private DateTime createdAt;

	public String getPlacemark() {
		return placemark;
	}

	protected void setPlacemark(String placemark) {
		this.placemark = placemark;
	}

	public Person getUser() {
		return user;
	}

	protected void setUser(Person user) {
		this.user = user;
	}

	public Place getPlace() {
		return place;
	}

	protected void setPlace(Place place) {
		this.place = place;
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

	protected final static Placemark fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		Placemark placemark = new Placemark();
		if (jsonObject.has("placemark")) {
			placemark.setPlacemark(jsonObject.getString("placemark"));
		}
		if (jsonObject.has("user")) {
			placemark.setUser(Person.fromJSON(jsonObject.getJSONObject("user")));
		}
		if (jsonObject.has("place")) {
			placemark.setPlace(Place.fromJSON(jsonObject.getJSONObject("place")));
		}
		if (jsonObject.has("created_at")) {
			placemark.setCreatedAt(jsonObject.getString("created_at"));
		}
		
		return placemark;
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
