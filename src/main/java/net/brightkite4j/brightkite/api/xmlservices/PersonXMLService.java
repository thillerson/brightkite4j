package net.brightkite4j.brightkite.api.xmlservices;

import java.util.List;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.api.Parameter;
import net.brightkite4j.brightkite.exceptions.ServiceException;
import net.brightkite4j.brightkite.resources.Friendship;
import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.resources.PlaceObjectFilter;
import net.brightkite4j.brightkite.resources.lists.FriendList;
import net.brightkite4j.brightkite.resources.lists.PlaceObjectList;
import net.brightkite4j.brightkite.resources.lists.PendingFriendList;

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
	
	public Friendship getMyFriendshipForPerson(Person person) {
		String response = httpService.get(peopleURL + "/" + person.getLogin() + "/friendship.xml");
		Friendship friendship = Friendship.fromXML(response);
		return friendship;
	}

	public List<Person> getFriendsOfPerson(Person person) {
		String response = httpService.get(peopleURL + "/" + person.getLogin() + "/friends.xml");
		FriendList list = FriendList.fromXML(response);
		return list.getFriendList();
	}

	public List<Person> getPendingFriendsOfPerson(Person person) {
		String response = httpService.get(peopleURL + "/" + person.getLogin() + "/pending_friends.xml");
		PendingFriendList list = PendingFriendList.fromXML(response);
		return list.getPendingFriendList();
	}

	@SuppressWarnings("unchecked")
	public List getPlaceObjectsByPerson(Person person, PlaceObjectFilter filter) {
		String url = peopleURL + "/" + person.getLogin() + "/objects.xml";
		Parameter[] filters = null;
		if (null != filter) {
			Parameter filterParam = new Parameter("filters", filter.toString());
			filters = new Parameter[]{filterParam};
		}
		String result = httpService.get(url, filters);
		PlaceObjectList ol = PlaceObjectList.fromXML(result);
		return ol.getPlaceObjectList();
	}

	public void blockPerson(Person person) {
		try {
			httpService.post(peopleURL + "/" + person.getLogin() + "/block");
		} catch(ServiceException e) {
			//TODO: HAX!!! have to find out how to create a block with the xml service. This catches the 
			// redirect from the html service version.
		}
	}
	
	public void unblockPerson(Person person) {
		httpService.delete(peopleURL + "/" + person.getLogin() + "/block.xml");
	}

	public void nudge(Person person) {
		String url = peopleURL + "/" + person.getLogin() + "/nudges.xml";
		Parameter nudgeParam = new Parameter("nudge[sender_id]", null);
		Parameter[] params = new Parameter[]{nudgeParam};
		httpService.post(url, params);
	}
	
}
