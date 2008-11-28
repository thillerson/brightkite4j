package net.brightkite4j.brightkite.resources.lists;

import java.util.ArrayList;
import java.util.List;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.resources.Note;
import net.brightkite4j.brightkite.resources.Photo;
import net.brightkite4j.brightkite.resources.PlaceObject;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class ObjectList {

	private List<PlaceObject> placeObjects;
	private List<Note> notes;
	private List<Photo> photos;
	
	public ObjectList() {
		placeObjects = new ArrayList<PlaceObject>();
		notes = new ArrayList<Note>();
		photos = new ArrayList<Photo>();
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
	
	public void addNote(Note note) {
		placeObjects.add(note);
		notes.add(note);
	}
	
	public void addPhoto(Photo photo) {
		placeObjects.add(photo);
		photos.add(photo);
	}
	
	public final static ObjectList fromXML(String xml) {
		try {
			ObjectList person = (ObjectList)BrightkiteUtils.fromXML(xml, ObjectList.class);
			return person;
		} catch (Exception e) {
			throw new DeserializationException("Cannot deserialize ObjectList.", e);
		}
	}
	
}
