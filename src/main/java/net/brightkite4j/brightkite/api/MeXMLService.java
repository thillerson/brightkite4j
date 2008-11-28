package net.brightkite4j.brightkite.api;

import net.brightkite4j.brightkite.resources.Person;

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

}
