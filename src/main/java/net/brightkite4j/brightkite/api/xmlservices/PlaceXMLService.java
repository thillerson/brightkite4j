package net.brightkite4j.brightkite.api.xmlservices;

import java.util.List;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.api.Parameter;
import net.brightkite4j.brightkite.resources.Checkin;
import net.brightkite4j.brightkite.resources.Place;
import net.brightkite4j.brightkite.resources.PlaceObjectFilter;
import net.brightkite4j.brightkite.resources.lists.ObjectList;

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

}
