package net.brightkite4j.brightkite.api.xmlservices;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.resources.Place;

public class PlaceXMLService {

	private HTTPService httpService;
	private final String singularURL = Brightkite.URL_BASE + "/place";
	// lolz!
	private final String plURLal = singularURL + "s";

	public PlaceXMLService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public Place getPlace(String id) {
		String url = plURLal + "/" + id + ".xml";
		String result = httpService.get(url);
		return Place.fromXML(result);
	}

	public void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
	}
	
}
