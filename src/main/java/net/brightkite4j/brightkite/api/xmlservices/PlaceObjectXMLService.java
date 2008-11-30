package net.brightkite4j.brightkite.api.xmlservices;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.resources.Checkin;
import net.brightkite4j.brightkite.resources.Note;
import net.brightkite4j.brightkite.resources.Photo;

public class PlaceObjectXMLService {

	private HTTPService httpService;
	private final String placeObjectsBaseUrl = Brightkite.URL_BASE + "/objects";

	public PlaceObjectXMLService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public Note getNote(String id) {
		String result = getPlaceObjectXML(id);
		Note note = Note.fromXML(result);
		return note;
	}

	public Photo getPhoto(String id) {
		String result = getPlaceObjectXML(id);
		Photo photo = Photo.fromXML(result);
		return photo;
	}

	public Checkin getCheckin(String id) {
		String result = getPlaceObjectXML(id);
		Checkin checkin = Checkin.fromXML(result);
		return checkin;
	}

	public void deleteNote(Note note) {
		deletePlaceObject(note.getId());
	}
	
	public void deletePhoto(Photo photo) {
		deletePlaceObject(photo.getId());
	}
	
	public void deleteCheckin(Checkin checkin) {
		deletePlaceObject(checkin.getId());
	}
	
	private String getPlaceObjectXML(String id) {
		String url = placeObjectsBaseUrl + "/" + id + ".xml";
		return httpService.get(url);
	}
	
	private void deletePlaceObject(String id) {
		String url = placeObjectsBaseUrl + "/" + id + ".xml";
		httpService.delete(url);
	}

}
