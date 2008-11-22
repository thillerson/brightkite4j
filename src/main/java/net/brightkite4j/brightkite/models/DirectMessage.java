package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

public class DirectMessage extends BrightkiteObject {
	
	private String body;
	private String status;
	private Person sender;
	private Person recipient;

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

	public final static DirectMessage fromJSON(String jsonObject) {
		return fromJSON(JSONObject.fromObject(jsonObject));
	}
	
	public final static DirectMessage fromJSON(JSONObject jsonObject) {
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
		BrightkiteObject.finishDeserialization(jsonObject, directMessage);

		return directMessage;
	}
	
}
