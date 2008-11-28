package net.brightkite4j.brightkite.resources;

import java.util.ArrayList;
import java.util.List;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class Stream {

	private List<PlaceObject> placeObjects;
	private List<Note> notes;
	private List<Photo> photos;
	
	public Stream() {
		placeObjects = new ArrayList<PlaceObject>();
		notes = new ArrayList<Note>();
		photos = new ArrayList<Photo>();
	}
	
	public List<PlaceObject> getPlaceObjects() {
		return placeObjects;
	}

	public List<Note> getNoteStream() {
		return notes;
	}
	
	public List<Photo> getPhotoStream() {
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
	
	public final static Stream fromXML(String xml) {
		try {
			Stream person = (Stream)BrightkiteUtils.fromXML(xml, Stream.class);
			return person;
		} catch (Exception e) {
			throw new DeserializationException("Cannot deserialize Stream.", e);
		}
	}
	
}
