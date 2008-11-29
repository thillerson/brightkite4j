package net.brightkite4j.brightkite.resources;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

//FIXME: extract a common api for a placeobject
public class Checkin extends BrightkiteObject implements PlaceObject {
	
	private Place place;
	private Person creator;
	private boolean _public;
	private int commentsCount;
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Person getCreator() {
		return creator;
	}

	public void setCreator(Person creator) {
		this.creator = creator;
	}

	public boolean isPublic() {
		return _public;
	}

	public void setPublic(boolean _public) {
		this._public = _public;
	}
	
	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public boolean isACheckin() {
		return true;
	}

	public boolean isANote() {
		return false;
	}

	public boolean isAPhoto() {
		return false;
	}

	public final static Checkin fromXML(String xml) {
		try {
			Checkin checkin = (Checkin)BrightkiteUtils.fromXML(xml, Checkin.class);
			return checkin;
		} catch (Exception e) {
			throw new DeserializationException("Unable to deserialize Checkin.", e);
		}
	}

}
