package net.brightkite4j.brightkite.resources;

public abstract class PlaceObject extends BrightkiteObject {

	private String body;
	private Person creator;
	private Place place;
	private boolean _public;
	private boolean about;
	
	public abstract boolean isANote();
	public abstract boolean isAPhoto();
	
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
	
}
