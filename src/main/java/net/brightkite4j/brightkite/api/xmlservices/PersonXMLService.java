package net.brightkite4j.brightkite.api.xmlservices;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.api.Parameter;
import net.brightkite4j.brightkite.resources.Person;

public class PersonXMLService {

	private HTTPService httpService;
	private final String peopleURL = Brightkite.URL_BASE + "/people";

	public PersonXMLService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public void directMessage(Person person, String message) {
		String url = peopleURL + "/" + person.getLogin() + "/received_messages.xml";
		Parameter messageParam = new Parameter("message[body]", message);
		Parameter[] params = new Parameter[]{ messageParam };
		httpService.post(url, params);
	}

	public Person getPerson(String login) {
		String url = peopleURL + "/" + login + ".xml";
		String result = httpService.get(url);
		return Person.fromXML(result);
	}

}
