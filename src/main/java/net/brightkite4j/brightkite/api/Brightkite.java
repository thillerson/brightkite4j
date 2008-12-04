package net.brightkite4j.brightkite.api;

import java.util.List;

import net.brightkite4j.brightkite.api.xmlservices.MeXMLService;
import net.brightkite4j.brightkite.api.xmlservices.PersonXMLService;
import net.brightkite4j.brightkite.api.xmlservices.PlaceObjectXMLService;
import net.brightkite4j.brightkite.api.xmlservices.PlaceXMLService;
import net.brightkite4j.brightkite.exceptions.ServiceException;
import net.brightkite4j.brightkite.resources.*;

public class Brightkite implements BrightkiteService {
	
	public static final String URL_BASE = "http://brightkite.com";
	private static Brightkite instance;
	
	private HTTPService httpService;
	private MeXMLService meService;
	private PlaceXMLService placeService;
	private PlaceObjectXMLService placeObjectService;
	private PersonXMLService personService;
	
	// You could use this for testing if you want
	public static void main(String[] args) {
		Brightkite bk = new Brightkite();
		System.out.println(bk.getMyBlockedPeople());
	}

	public static Brightkite getInstance() {
		if (instance == null) {
			instance = new Brightkite();
		}
		return instance;
	}
	
	private Brightkite() {
		httpService = new SimpleHTTPService();
		meService = new MeXMLService(httpService);
		placeService = new PlaceXMLService(httpService);
		placeObjectService = new PlaceObjectXMLService(httpService);
		personService = new PersonXMLService(httpService);
	}
	
	public void setCredentials(String username, String password) {
		httpService.setCredentials(username, password);
	}
	
	public void logout() {
		httpService.clearCredentials();
	}
	
	public void getInvite(String email) {
		//TODO: implement?
	}

	public Person getMe() {
		authRequired();
		return meService.getMe();
	}
	
	public List<Person> getMyFriends() {
		authRequired();
		return meService.getMyFriends();
	}
	
	public List<Person> getMyPendingFriends() {
		authRequired();
		return meService.getMyPendingFriends();
	}
	
	public List<Placemark> getMyPlacemarks() {
		authRequired();
		return meService.getMyPlacemarks();
	}
	
	public List<DirectMessage> getMySentDirectMessages() {
		authRequired();
		return meService.getMySentDirectMessages();
	}
	
	public List<DirectMessage> getMyReceivedDirectMessages() {
		authRequired();
		return meService.getMyReceivedDirectMessages();
	}
	
	public List<Person> getMyBlockedPeople() {
		authRequired();
		return meService.getMyBlockedPeople();
	}
	
	public void changeMySettings(Person person) {
		//TODO: implement
	}

	public List<PlaceObject> getUniverseFeed() {
		return placeObjectService.getPlaceObjects(null);
	}
	
	public List<PlaceObject> getFriendstream() {
		authRequired();
		return meService.getFriendstream();
	}
	
	public List<PlaceObject> getNearbystream() {
		authRequired();
		return meService.getNearbystream();
	}
	
	public List<PlaceObject> getMentions() {
		authRequired();
		return meService.getMentionstream();
	}
	
	public List<Comment> getCommentstream() {
		authRequired();
		return meService.getCommentstream();
	}

	public Checkin checkin(Place place) {
		authRequired();
		return placeService.checkin(place);
	}
	
	public void deleteCheckin(Checkin checkin) {
		authRequired();
		placeObjectService.deletePlaceObject(checkin);
	}

	public Place getPlace(String id) {
		return placeService.getPlace(id);
	}
	
	public List<Place> searchPlaces(String term) {
		//TODO: implement
		//FIXME: Somehow need to be able to deserialize the results
		// which can be either wrapped in <places> or a single <place>
		// which will break betwixt's little brain
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Note> getNotesAtPlace(Place place) {
		return placeService.getPlaceObjectsAtPlace(place, PlaceObjectFilter.createFilter(PlaceObjectFilter.NOTES));
	}

	@SuppressWarnings("unchecked")
	public List<Photo> getPhotosAtPlace(Place place) {
		return placeService.getPlaceObjectsAtPlace(place, PlaceObjectFilter.createFilter(PlaceObjectFilter.PHOTOS));
	}

	@SuppressWarnings("unchecked")
	public List<Checkin> getCheckinsAtPlace(Place place) {
		return placeService.getPlaceObjectsAtPlace(place, PlaceObjectFilter.createFilter(PlaceObjectFilter.CHECKINS));
	}

	public List<PlaceObject> getPlaceObjectsAtPlace(Place place) {
		return getPlaceObjectsAtPlace(place, null);
	}
	
	@SuppressWarnings("unchecked")
	public List<PlaceObject> getPlaceObjectsAtPlace(Place place, PlaceObjectFilter filter) {
		return placeService.getPlaceObjectsAtPlace(place, filter);
	}

	public List<Person> getPeopleAtPlace(Place place) {
		return getPeopleAtPlace(place, null, null);
	}
	
	public List<Person> getPeopleAtPlace(Place place, Integer radius) {
		return getPeopleAtPlace(place, radius, null);
	}
	
	public List<Person> getPeopleAtPlace(Place place, Integer radius, Integer hoursAgo) {
		return placeService.getPeopleAtPlace(place, radius, hoursAgo);
	}
	
	public List<Placemark> getPlacemarksAtPlace(Place place) {
		authRequired();
		return placeService.getPlacemarksAtPlace(place);
	}
	
	public Friendship makeFriendship(Friendship friendship) {
		//TODO: implement 
		return null;
	}
	
	public Friendship updateFriendship(Friendship friendship) {
		//TODO: implement 
		return null;
	}
	
	public void breakFriendship(Friendship friendship) {
		//TODO: implement
	}
	
	public void nudge(Person person) {
		//TODO: implement??
	}
	
	public void directMessage(Person person, String message) {
		authRequired();
		personService.directMessage(person, message);
	}
	
	public Block blockPerson(Person person) {
		authRequired();
		return meService.blockPerson(person);
	}
	
	public void deleteBlock(Block block) {
		//TODO: implement
	}

	public Checkin getCheckin(String id) {
		authRequired();
		return placeObjectService.getCheckin(id);
	}
	
	public Note getNote(String id) {
		authRequired();
		return placeObjectService.getNote(id);
	}
	
	public Photo getPhoto(String id) {
		authRequired();
		return placeObjectService.getPhoto(id);
	}
	
	public Note leaveNote(Place place, String body) {
		authRequired();
		return placeService.leaveNote(place, body);
	}
	
	public Photo leavePhoto(Place place, Photo newPhoto) {
		//TODO: implement
		return null;
	}
	
	public void deleteNote(Note note) {
		authRequired();
		placeObjectService.deletePlaceObject(note);
	}
	
	public void deletePhoto(Photo photo) {
		authRequired();
		placeObjectService.deletePlaceObject(photo);
	}
	
	public List<PlaceObject> searchObjects(String term) {
		//TODO: implement
		return null;
	}
	

	public List<Comment> getCommentsAboutPlaceObject(PlaceObject placeObject) {
		authRequired();
		return placeObjectService.getCommentsAboutPlaceObject(placeObject);
	}
	
	public Comment leaveComment(PlaceObject placeObject, String comment) {
		return leaveComment(placeObject, comment, false);
	}
	
	public Comment leaveComment(PlaceObject placeObject, String comment, boolean watch) {
		authRequired();
		return placeObjectService.leaveComment(placeObject, comment, watch);
	}
	
	public Person getPerson(String login) {
		return personService.getPerson(login);
	}
	
	public Friendship getFriendshipForPerson(Person person) {
		authRequired();
		return personService.getMyFriendshipForPerson(person);
	}
	
	public List<Person> searchPeople(String term) {
		//TODO: implement
		return null;
	}
	
	public List<Person> getFriendsOfPerson(Person person) {
		return personService.getFriendsOfPerson(person);
	}
	
	public List<Person> getPendingFriendsOfPerson(Person person) {
		return personService.getPendingFriendsOfPerson(person);
	}
	
	@SuppressWarnings("unchecked")
	public List<Note> getNotesByPerson(Person person) {
		return personService.getPlaceObjectsByPerson(person, PlaceObjectFilter.createFilter(PlaceObjectFilter.NOTES));
	}
	
	@SuppressWarnings("unchecked")
	public List<Photo> getPhotosByPerson(Person person) {
		return personService.getPlaceObjectsByPerson(person, PlaceObjectFilter.createFilter(PlaceObjectFilter.PHOTOS));
	}
	
	@SuppressWarnings("unchecked")
	public List<Checkin> getCheckinsByPerson(Person person) {
		return personService.getPlaceObjectsByPerson(person, PlaceObjectFilter.createFilter(PlaceObjectFilter.CHECKINS));
	}
	
	public List<PlaceObject> getPlaceObjectsByPerson(Person person) {
		return getPlaceObjectsByPerson(person, null);
	}
	
	@SuppressWarnings("unchecked")
	public List<PlaceObject> getPlaceObjectsByPerson(Person person, PlaceObjectFilter filter) {
		return personService.getPlaceObjectsByPerson(person, filter);
	}
	
	public void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
		meService.setHttpService(httpService);
		placeService.setHttpService(httpService);
		placeObjectService.setHttpService(httpService);
		personService.setHttpService(httpService);
	}

	public HTTPService getHttpService() {
		return httpService;
	}

	public MeXMLService getMeService() {
		return meService;
	}

	public void setMeService(MeXMLService meService) {
		this.meService = meService;
	}

	public PlaceXMLService getPlaceService() {
		return placeService;
	}

	public void setPlaceService(PlaceXMLService placeService) {
		this.placeService = placeService;
	}

	public PlaceObjectXMLService getPlaceObjectService() {
		return placeObjectService;
	}

	public void setPlaceObjectService(PlaceObjectXMLService placeObjectService) {
		this.placeObjectService = placeObjectService;
	}

	public PersonXMLService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonXMLService personService) {
		this.personService = personService;
	}

	private void authRequired() {
		if (! httpService.hasCredentials()) {
			throw new ServiceException("You must log in before performing this action");
		}
	}

}