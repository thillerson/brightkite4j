package net.brightkite4j.brightkite.api.xmlservices;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.resources.Checkin;

public class CheckinXMLService {

	private HTTPService httpService;
	private final String baseUrl = Brightkite.URL_BASE + "/checkins";

	public CheckinXMLService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public void deleteCheckin(Checkin checkin) {
		String url = baseUrl + "/" + checkin.getId() + ".xml";
		httpService.delete(url);
	}
	
}
