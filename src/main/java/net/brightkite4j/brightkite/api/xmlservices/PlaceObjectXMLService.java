package net.brightkite4j.brightkite.api.xmlservices;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.resources.Checkin;

public class PlaceObjectXMLService {

	private HTTPService httpService;
	private final String placeObjectsBaseUrl = Brightkite.URL_BASE + "/objects";

	public PlaceObjectXMLService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public void deleteCheckin(Checkin checkin) {
		deletePlaceObject(checkin.getId());
	}
	
	private void deletePlaceObject(String id) {
		String url = placeObjectsBaseUrl + "/" + id + ".xml";
		httpService.delete(url);
	}


}
