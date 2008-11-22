package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.utils.BrightkiteUtils;
import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

public abstract class BrightkiteObject {

	private String id;
	private DateTime createdAt;
	private String createdAtAsWords;
	
	public String getId() {
		return id;
	}
	
	protected void setId(String id) {
		this.id = id;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public void setCreatedAt(String timestamp) {
		this.createdAt = BrightkiteUtils.parseDateTimeFromString(timestamp);
	}
	
	public String getCreatedAtAsWords() {
		return createdAtAsWords;
	}
	public void setCreatedAtAsWords(String createdAtAsWords) {
		this.createdAtAsWords = createdAtAsWords;
	}
	
	public final static void finishDeserialization(JSONObject jsonObject, BrightkiteObject bk) {
		if (jsonObject.has("id")) {
			bk.setId(jsonObject.getString("id"));
		}
		if (jsonObject.has("created_at")) {
			bk.setCreatedAt(jsonObject.getString("created_at"));
		}
		if (jsonObject.has("created_at_as_words")) {
			bk.setCreatedAtAsWords(jsonObject.getString("created_at_as_words"));
		}
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
