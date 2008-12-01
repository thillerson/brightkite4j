package net.brightkite4j.brightkite.api.xmlservices;

import java.util.List;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.api.Parameter;
import net.brightkite4j.brightkite.resources.Checkin;
import net.brightkite4j.brightkite.resources.Note;
import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.resources.Place;
import net.brightkite4j.brightkite.resources.PlaceObjectFilter;
import net.brightkite4j.brightkite.resources.Placemark;
import net.brightkite4j.brightkite.resources.lists.ObjectList;
import net.brightkite4j.brightkite.resources.lists.PeopleList;
import net.brightkite4j.brightkite.resources.lists.PlacemarksList;

public class PlaceXMLService {

	private HTTPService httpService;
	private final String placesBaseUrl = Brightkite.URL_BASE + "/places";

	public PlaceXMLService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public Place getPlace(String id) {
		String url = placesBaseUrl + "/" + id + ".xml";
		String result = httpService.get(url);
		return Place.fromXML(result);
	}

	@SuppressWarnings("unchecked")
	public List getPlaceObjectsAtPlace(Place place, PlaceObjectFilter filter) {
		String url = placesBaseUrl + "/" + place.getId() + "/objects.xml";
		Parameter[] filters = null;
		if (null != filter) {
			Parameter filterParam = new Parameter("filters", filter.toString());
			filters = new Parameter[]{filterParam};
		}
		String result = httpService.get(url, filters);
		ObjectList ol = ObjectList.fromXML(result);
		return ol.getPlaceObjectList();
	}

	public Checkin checkin(Place place) {
		String url = placesBaseUrl + "/" + place.getId() + "/checkins.xml";
		String result = httpService.post(url);
		Checkin checkin = Checkin.fromXML(result);
		return checkin;
	}

	public List<Person> getPeopleAtPlace(Place place) {
		String url = placesBaseUrl + "/" + place.getId() + "/people.xml";
		String result = httpService.get(url);
		PeopleList peopleList = PeopleList.fromXML(result);
		return peopleList.getPeopleList();
	}

	public List<Placemark> getPlacemarksAtPlace(Place place) {
		String url = placesBaseUrl + "/" + place.getId() + "/placemarks.xml";
		String result = httpService.get(url);
		PlacemarksList placemarkList = PlacemarksList.fromXML(result);
		return placemarkList.getPlacemarkList();
	}

	public Note leaveNote(Place place, String body) {
		String url = placesBaseUrl + "/" + place.getId() + "/notes.xml";
		Parameter noteParam = new Parameter("note[body]", body);
		Parameter[] params = new Parameter[]{ noteParam };
		String result = httpService.post(url, params);
		Note returnedNote = Note.fromXML(result);
		return returnedNote;
	}

}
