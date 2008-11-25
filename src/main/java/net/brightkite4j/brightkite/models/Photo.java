package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class Photo extends Note {
	
	private String photo;
	
	@Override
	public boolean isAPhoto() {
		return false;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public final static Photo fromXML(String xml) {
		try {
			Photo photo = (Photo)BrightkiteUtils.fromXML(xml, Photo.class);
			return photo;
		} catch (Exception e) {
			throw new DeserializationException("Could not deserialize Photo.", e);
		}
	}

}
