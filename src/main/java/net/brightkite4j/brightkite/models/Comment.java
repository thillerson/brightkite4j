package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class Comment extends BrightkiteObject {
	
	private Person user;
	private String comment;
	
	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public final static Comment fromXML(String xml) {
		try {
			Comment comment = (Comment)BrightkiteUtils.fromXML(xml, Comment.class);
			return comment;
		} catch (Exception e) {
			throw new DeserializationException("Could not deserialize Comment.", e);
		}
	}

}
