package net.brightkite4j.brightkite.api.xmlservices;

import java.util.List;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.resources.Comment;
import net.brightkite4j.brightkite.resources.DirectMessage;
import net.brightkite4j.brightkite.resources.Friendship;
import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.resources.PlaceObject;
import net.brightkite4j.brightkite.resources.Placemark;
import net.brightkite4j.brightkite.resources.lists.CommentList;
import net.brightkite4j.brightkite.resources.lists.DirectMessageList;
import net.brightkite4j.brightkite.resources.lists.FriendList;
import net.brightkite4j.brightkite.resources.lists.PlaceObjectList;
import net.brightkite4j.brightkite.resources.lists.PendingFriendList;
import net.brightkite4j.brightkite.resources.lists.PeopleList;
import net.brightkite4j.brightkite.resources.lists.PlacemarksList;

public class MeXMLService {

	private HTTPService httpService;
	private final String meURL = Brightkite.URL_BASE + "/me";

	public MeXMLService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public Person getMe() {
		String response = httpService.get(meURL + ".xml");
		Person person = Person.fromXML(response);
		return person;
	}

	public HTTPService getHttpService() {
		return httpService;
	}

	public void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public List<PlaceObject> getFriendstream() {
		String response = httpService.get(meURL + "/friendstream.xml");
		PlaceObjectList stream = PlaceObjectList.fromXML(response);
		return stream.getPlaceObjectList();
	}

	public List<PlaceObject> getNearbystream() {
		String response = httpService.get(meURL + "/nearbystream.xml");
		PlaceObjectList stream = PlaceObjectList.fromXML(response);
		return stream.getPlaceObjectList();
	}

	public List<PlaceObject> getMentionstream() {
		String response = httpService.get(meURL + "/mentionsstream.xml");
		PlaceObjectList stream = PlaceObjectList.fromXML(response);
		return stream.getPlaceObjectList();
	}

	public List<Comment> getCommentstream() {
		String response = httpService.get(meURL + "/commentsstream.xml");
		CommentList stream = CommentList.fromXML(response, "objects");
		return stream.getCommentList();
	}

	public List<Person> getMyFriends() {
		String response = httpService.get(meURL + "/friends.xml");
		FriendList stream = FriendList.fromXML(response);
		return stream.getFriendList();
	}

	public List<Person> getMyPendingFriends() {
		String response = httpService.get(meURL + "/pending_friends.xml");
		PendingFriendList stream = PendingFriendList.fromXML(response);
		return stream.getPendingFriendList();
	}

	public Friendship friend(Friendship friendship) {
		String url = meURL + "/friendship.xml";
		friendship = Friendship.fromXML(httpService.post(url, friendship.toParams()));
		return friendship;
	}

	public void unfriend(Person person) {
		Friendship f = new Friendship();
		f.setFriendable(person);
		String url = meURL + "/friendship.xml";
		httpService.delete(url, f.toParams());
	}

	public List<Person> getMyBlockedPeople() {
		String response = httpService.get(meURL + "/blocked_people.xml");
		PeopleList stream = PeopleList.fromXML(response);
		return stream.getPeopleList();
	}

	public List<Placemark> getMyPlacemarks() {
		String response = httpService.get(meURL + "/placemarks.xml");
		PlacemarksList stream = PlacemarksList.fromXML(response);
		return stream.getPlacemarkList();
	}

	public List<DirectMessage> getMySentDirectMessages() {
		String response = httpService.get(meURL + "/sent_messages.xml");
		DirectMessageList stream = DirectMessageList.fromXML(response);
		return stream.getDirectMessageList();
	}

	public List<DirectMessage> getMyReceivedDirectMessages() {
		String response = httpService.get(meURL + "/received_messages.xml");
		DirectMessageList stream = DirectMessageList.fromXML(response);
		return stream.getDirectMessageList();
	}
	
}
