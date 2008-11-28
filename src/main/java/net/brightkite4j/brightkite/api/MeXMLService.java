package net.brightkite4j.brightkite.api;

import java.util.List;

import net.brightkite4j.brightkite.resources.Comment;
import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.resources.PlaceObject;
import net.brightkite4j.brightkite.resources.Stream;

public class MeXMLService {

	private HTTPService httpService;
	private final String meURL = Brightkite.URL_BASE + "/me";

	public MeXMLService(HTTPService httpService) {
		this.httpService = httpService;
	}

	protected Person getMe() {
		String response = httpService.get(meURL + ".xml");
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
		String response = httpService.get(meURL + "/friendstream.xml");
		Stream stream = Stream.fromXML(response);
		return stream.getPlaceObjects();
	}

	protected List<PlaceObject> getNearbystream() {
		String response = httpService.get(meURL + "/nearbystream.xml");
		Stream stream = Stream.fromXML(response);
		return stream.getPlaceObjects();
	}

	protected List<PlaceObject> getMentionstream() {
		String response = httpService.get(meURL + "/mentionsstream.xml");
		Stream stream = Stream.fromXML(response);
		return stream.getPlaceObjects();
	}

	protected List<Comment> getCommentstream() {
		String response = httpService.get(meURL + "/commentsstream.xml");
		Stream stream = Stream.fromXML(response);
		return stream.getCommentStream();
	}

}
