package net.brightkite4j.brightkite.models;

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

	
}
