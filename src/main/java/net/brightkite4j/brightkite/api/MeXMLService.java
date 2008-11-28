package net.brightkite4j.brightkite.api;

import java.util.List;

import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.resources.PlaceObject;
import net.brightkite4j.brightkite.resources.Stream;

public class MeXMLService {

	private HTTPService httpService;
	private final String urlFormat = "http://brightkite.com/me";

	public MeXMLService(HTTPService httpService) {
		this.httpService = httpService;
	}

	protected Person getMe() {
		String response = httpService.get(urlFormat + ".xml");
		Person person = Person.fromXML(response);
		return person;
	}

	protected HTTPService getHttpService() {
		return httpService;
	}

	protected void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
	}

	protected List<PlaceObject> getFriendstream() {
		String response = httpService.get(urlFormat + "/friendstream.xml");
		Stream stream = Stream.fromXML(response);
		return stream.getPlaceObjects();
	}

}
