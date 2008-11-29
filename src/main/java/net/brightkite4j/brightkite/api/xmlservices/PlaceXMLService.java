package net.brightkite4j.brightkite.api.xmlservices;

import java.util.List;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.resources.Place;
import net.brightkite4j.brightkite.resources.PlaceObject;
import net.brightkite4j.brightkite.resources.lists.ObjectList;

public class PlaceXMLService {

	private HTTPService httpService;
	private final String singularURL = Brightkite.URL_BASE + "/place";
	// lolz!
	private final String plURLal = singularURL + "s";

	public PlaceXMLService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public Place getPlace(String id) {
		String url = plURLal + "/" + id + ".xml";
		String result = httpService.get(url);
		return Place.fromXML(result);
	}

	public List<PlaceObject> getPlaceObjectsAtPlace(Place place) {
		String url = plURLal + "/" + place.getId() + "/objects.xml";
		String result = httpService.get(url);
		ObjectList ol = ObjectList.fromXML(result);
		return ol.getPlaceObjectList();
	}
	
}
