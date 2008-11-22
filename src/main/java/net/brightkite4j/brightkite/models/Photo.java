package net.brightkite4j.brightkite.models;

public class Photo extends PlaceObject {
	
	private String photo;

	public String getPhoto() {
		return photo;
	}

	protected void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public boolean isNote() {
		return false;
	}

	@Override
	public boolean isPhoto() {
		return true;
	}

}
