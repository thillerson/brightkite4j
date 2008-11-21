package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.utils.BrightkiteUtils;
import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

public class DirectMessage {
	
	private String body;
	private String status;
	private Person sender;
	private Person recipient;
	private DateTime createdAt;
	private String createdAtAsWords;

	public String getBody() {
		return body;
	}

	protected void setBody(String body) {
		this.body = body;
	}

	public String getStatus() {
		return status;
	}

	protected void setStatus(String status) {
		this.status = status;
	}

	public Person getSender() {
		return sender;
	}

	protected void setSender(Person sender) {
		this.sender = sender;
	}

	public Person getRecipient() {
		return recipient;
	}

	protected void setRecipient(Person recipient) {
		this.recipient = recipient;
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

	protected final static DirectMessage fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		DirectMessage directMessage = new DirectMessage();
		if (jsonObject.has("body")) {
			directMessage.setBody(jsonObject.getString("body"));
		}
		if (jsonObject.has("status")) {
			directMessage.setStatus(jsonObject.getString("status"));
		}
		if (jsonObject.has("sender")) {
			directMessage.setSender(Person.fromJSON(jsonObject.getJSONObject("sender")));
		}
		if (jsonObject.has("recipient")) {
			directMessage.setRecipient(Person.fromJSON(jsonObject.getJSONObject("recipient")));
		}
		if (jsonObject.has("created_at")) {
			directMessage.setCreatedAt(jsonObject.getString("created_at"));
		}
		if (jsonObject.has("created_at_as_words")) {
			directMessage.setCreatedAtAsWords(jsonObject.getString("created_at_as_words"));
		}

		return directMessage;
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
