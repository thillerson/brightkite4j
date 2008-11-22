package net.brightkite4j.brightkite.models;

public abstract class PlaceObject extends BrightkiteObject {

	private String body;
	private Person creator;
	private Place place;
	private boolean _public;
	private boolean about;

	public abstract boolean isNote();
	public abstract boolean isPhoto();
	
	public String getBody() {
		return body;
	}

	protected void setBody(String body) {
		this.body = body;
	}

	public Person getCreator() {
		return creator;
	}

	protected void setCreator(Person creator) {
		this.creator = creator;
	}

	public Place getPlace() {
		return place;
	}

	protected void setPlace(Place place) {
		this.place = place;
	}

	public boolean isPublic() {
		return _public;
	}

	protected void setPublic(boolean _public) {
		this._public = _public;
	}

	public boolean isAbout() {
		return about;
	}

	protected void setAbout(boolean about) {
		this.about = about;
	}
	
}
