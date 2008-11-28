package net.brightkite4j.brightkite.api;

import net.brightkite4j.brightkite.exceptions.ServiceException;
import net.brightkite4j.brightkite.resources.*;

public class Brightkite implements BrightkiteService {
	
	private static Brightkite instance;
	
	private HTTPService httpService;
	private MeXMLService meService;
	
	// You could use this for testing if you want
//	public static void main(String[] args) {
//		Brightkite bk = new Brightkite();
//		System.out.println(bk.getMe());
//	}

	public static Brightkite getInstance() {
		if (instance == null) {
			instance = new Brightkite();
		}
		return instance;
	}
	
	private Brightkite() {
		httpService = new SimpleHTTPService();
		meService = new MeXMLService(httpService);
	}
	
	public void setCredentials(String username, String password) {
		httpService.setCredentials(username, password);
	}
	
	public void logout() {
		httpService.clearCredentials();
	}
	
	public void getInvite(String email) {
		
	}

	public Person getMe() {
		authRequired();
		return meService.getMe();
	}
	
	public Person[] getMyFriends() {
		return null;
	}
	
	public Person[] getMyPendingFriends() {
		return null;
	}
	
	public Placemark[] getMyPlacemarks() {
		return null;
	}
	
	public DirectMessage[] getMySentDirectMessages() {
		return null;
	}
	
	public DirectMessage[] getMyRecievedDirectMessages() {
		return null;
	}
	
	public Block[] getMyBlocks() {
		return null;
	}
	
	public void changeMySettings(Person person) {
	}
	

	public PlaceObject[] getFriendstream() {
		return null;
	}
	
	public PlaceObject[] getNearbystream() {
		return null;
	}
	
	public PlaceObject[] getMentions() {
		return null;
	}
	
	public Comment[] getCommentstream() {
		return null;
	}
	

	public Checkin checkin(Place place) {
		return null;
	}
	
	public void deleteCheckin(Checkin checkin) {
	}
	

	public Friendship makeFriendship(Friendship friendship) {
		return null;
	}
	
	public void breakFriendship(Friendship friendship) {
	}
	

	public DirectMessage dm(Person person) {
		return null;
	}
	
	public DirectMessage directMessage(Person person) {
		return null;
	}
	
	public void deleteDirectMessage(DirectMessage dm) {
	}
	
	public Block blockPerson(Person person) {
		return null;
	}
	
	public void deleteBlock(Block block) {
	}
	

	public PlaceObject getPlaceObject(String id) {
		return null;
	}
	
	public Note getNote(String id) {
		return null;
	}
	
	public Photo getPhoto(String id) {
		return null;
	}
	
	public Note leaveNote(Place place) {
		return null;
	}
	
	public Photo leavePhoto(Place place) {
		return null;
	}
	
	public void deletePlaceObject(PlaceObject placeObject) {
	}
	
	public PlaceObject[] searchObjects(String term) {
		return null;
	}
	

	public Comment getComment(String id) {
		return null;
	}
	
	public Comment[] getCommentsAboutPlaceObject(PlaceObject placeObject) {
		return null;
	}
	
	public Comment leaveComment(PlaceObject placeObject) {
		return null;
	}
	
	public Comment leaveComment(PlaceObject placeObject, boolean watch) {
		return null;
	}
	
	public void deleteComment(Comment comment) {
	}
	

	public Person getPerson(String login) {
		return null;
	}
	
	public Friendship getFriendshipForPerson(Person person) {
		return null;
	}
	
	public Person[] searchPeople(String term) {
		return null;
	}
	
	public Person[] getFriendsOfPerson(Person person) {
		return null;
	}
	
	public Person[] getPendingFriendsOfPerson(Person person) {
		return null;
	}
	
	public Note[] getNotesByPerson(Person person) {
		return null;
	}
	
	public Photo[] getPhotosByPerson(Person person) {
		return null;
	}
	
	public PlaceObject[] getPlaceObjectsByPerson(Person person) {
		return null;
	}
	

	public Place getPlace(String id) {
		return null;
	}
	
	public Place[] searchPlaces(String term) {
		return null;
	}
	
	public PlaceObject[] getPlaceObjectsAtPlace(Place place) {
		return null;
	}
	
	public Person[] getPeopleAtPlace(Place place) {
		return null;
	}
	
	public Person[] getPeopleAtPlace(Place place, Integer radius) {
		return null;
	}
	
	public Person[] getPeopleAtPlace(Place place, Integer radius, Integer hoursAgo) {
		return null;
	}
	
	public Placemark[] getPlacemarksAtPlace(Place place) {
		return null;
	}
	
	public Checkin[] getCheckinsAtPlace(Place place) {
		return null;
	}

	public void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
		meService.setHttpService(httpService);
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

	private void authRequired() {
		if (! httpService.hasCredentials()) {
			throw new ServiceException("You must log in before performing this action");
		}
	}

}