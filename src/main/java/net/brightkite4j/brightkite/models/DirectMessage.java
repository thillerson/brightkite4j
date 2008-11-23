package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class DirectMessage extends BrightkiteObject {
	
	public static final String UNREAD_STATUS = "unread";
	public static final String READ_STATUS = "read";
	
	private String body;
	private String status;
	private Person sender;
	private Person recipient;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Person getSender() {
		return sender;
	}

	public void setSender(Person sender) {
		this.sender = sender;
	}

	public Person getRecipient() {
		return recipient;
	}

	public void setRecipient(Person recipient) {
		this.recipient = recipient;
	}
	
	public void markAsRead() {
		status = READ_STATUS;
	}
	
	public void markAsUnread() {
		status = UNREAD_STATUS;
	}
	
	public boolean isRead() {
		return (status.equals(READ_STATUS));
	}

	public boolean isUnread() {
		return (status.equals(UNREAD_STATUS));
	}

	public final static DirectMessage fromXML(String xml) {
		try {
			return (DirectMessage)BrightkiteUtils.fromXML(xml, DirectMessage.class);
		} catch (Exception e) {
			throw new DeserializationException("Unable to deserialize direct message.", e);
		}
	}
	
}
