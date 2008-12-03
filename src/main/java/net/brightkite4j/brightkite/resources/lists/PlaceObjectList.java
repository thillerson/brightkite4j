package net.brightkite4j.brightkite.resources.lists;

import java.util.ArrayList;
import java.util.List;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.resources.Checkin;
import net.brightkite4j.brightkite.resources.Note;
import net.brightkite4j.brightkite.resources.Photo;
import net.brightkite4j.brightkite.resources.PlaceObject;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class PlaceObjectList {

	private List<PlaceObject> placeObjects;
	private List<Note> notes;
	private List<Photo> photos;
	private List<Checkin> checkins;
	
	public PlaceObjectList() {
		placeObjects = new ArrayList<PlaceObject>();
		notes = new ArrayList<Note>();
		photos = new ArrayList<Photo>();
		checkins = new ArrayList<Checkin>();
	}
	
	public List<PlaceObject> getPlaceObjectList() {
		return placeObjects;
	}

	public List<Note> getNoteList() {
		return notes;
	}
	
	public List<Photo> getPhotoList() {
		return photos;
	}
	
	public List<Checkin> getCheckinList() {
		return checkins;
	}
	
	public void addNote(Note note) {
		placeObjects.add(note);
		notes.add(note);
	}
	
	public void addPhoto(Photo photo) {
		placeObjects.add(photo);
		photos.add(photo);
	}
	
	public void addCheckin(Checkin checkin) {
		placeObjects.add(checkin);
		checkins.add(checkin);
	}
	
	public final static PlaceObjectList fromXML(String xml) {
		try {
			PlaceObjectList person = (PlaceObjectList)BrightkiteUtils.fromXML(xml, PlaceObjectList.class);
			return person;
		} catch (Exception e) {
			throw new DeserializationException("Cannot deserialize ObjectList.", e);
		}
	}
	
}
