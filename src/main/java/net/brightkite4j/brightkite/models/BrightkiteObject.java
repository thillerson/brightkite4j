package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.utils.BrightkiteUtils;

import org.apache.commons.betwixt.strategy.ClassNormalizer;
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
	
	public void setId(String id) {
		this.id = id;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getCreatedAtTimestamp() {
		return createdAt.toString();
	}
	
	public void setCreatedAtTimestamp(String timestamp) {
		this.createdAt = BrightkiteUtils.parseDateTimeFromString(timestamp);
	}
	
	public String getCreatedAtAsWords() {
		return createdAtAsWords;
	}
	public void setCreatedAtAsWords(String createdAtAsWords) {
		this.createdAtAsWords = createdAtAsWords;
	}
	
	public ClassNormalizer getNormalizerForClass() {
		return null;
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
