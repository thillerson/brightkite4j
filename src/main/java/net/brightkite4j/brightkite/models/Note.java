package net.brightkite4j.brightkite.models;

public class Note extends PlaceObject {
	
	@Override
	public boolean isNote() {
		return true;
	}

	@Override
	public boolean isPhoto() {
		return false;
	}


}
