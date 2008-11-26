package net.brightkite4j.brightkite.resources;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class Photo extends BrightkiteObject {
	
	private String photo;
	private String body;
	private Person creator;
	private Place place;
	private boolean _public;
	private boolean about;
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Person getCreator() {
		return creator;
	}

	public void setCreator(Person creator) {
		this.creator = creator;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public boolean isPublic() {
		return _public;
	}

	public void setPublic(boolean _public) {
		this._public = _public;
	}

	public boolean isAbout() {
		return about;
	}

	public void setAbout(boolean about) {
		this.about = about;
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
