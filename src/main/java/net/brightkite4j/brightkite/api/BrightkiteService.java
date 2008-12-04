package net.brightkite4j.brightkite.api;

import java.util.List;

import net.brightkite4j.brightkite.resources.*;

public interface BrightkiteService {

	public void setCredentials(String username, String password);
	public void logout();
	public void getInvite(String email);
	

	public Person getMe();
	public List<Person> getMyFriends();
	public List<Person> getMyPendingFriends();
	public List<Placemark> getMyPlacemarks();
	public List<DirectMessage> getMySentDirectMessages();
	public List<DirectMessage> getMyReceivedDirectMessages();
	public List<Person> getMyBlockedPeople();
	public void changeMySettings(Person person);

	public List<PlaceObject> getUniverseFeed();
	public List<PlaceObject> getFriendstream();
	public List<PlaceObject> getNearbystream();
	public List<PlaceObject> getMentions();
	public List<Comment> getCommentstream();

	public Checkin checkin(Place place);
	public void deleteCheckin(Checkin checkin);

	public Friendship makeFriendship(Friendship friendship);
	public Friendship updateFriendship(Friendship friendship);
	public void breakFriendship(Friendship friendship);

	public void nudge(Person person);
	public void directMessage(Person person, String message);

	public void blockPerson(Person person);
	public void unblockPerson(Person person);

	public Note getNote(String id);
	public Photo getPhoto(String id);
	public Checkin getCheckin(String id);
	public Note leaveNote(Place place, String body);
	public Photo leavePhoto(Place place, Photo newPhoto);
	public void deleteNote(Note note);
	public void deletePhoto(Photo photo);
	public List<PlaceObject> searchObjects(String term);

	public List<Comment> getCommentsAboutPlaceObject(PlaceObject placeObject);
	public Comment leaveComment(PlaceObject placeObject, String comment);
	public Comment leaveComment(PlaceObject placeObject, String comment, boolean watch);

	public Person getPerson(String login);
	public Friendship getFriendshipForPerson(Person person);
	public List<Person> searchPeople(String term);
	public List<Person> getFriendsOfPerson(Person person);
	public List<Person> getPendingFriendsOfPerson(Person person);
	public List<Note> getNotesByPerson(Person person);
	public List<Photo> getPhotosByPerson(Person person);
	public List<Checkin> getCheckinsByPerson(Person person);
	public List<PlaceObject> getPlaceObjectsByPerson(Person person);
	public List<PlaceObject> getPlaceObjectsByPerson(Person person, PlaceObjectFilter filter);

	public Place getPlace(String id);
	public List<Place> searchPlaces(String term);
	public List<Note> getNotesAtPlace(Place place);
	public List<Photo> getPhotosAtPlace(Place place);
	public List<Checkin> getCheckinsAtPlace(Place place);
	public List<PlaceObject> getPlaceObjectsAtPlace(Place place);
	public List<PlaceObject> getPlaceObjectsAtPlace(Place place, PlaceObjectFilter filter);
	public List<Person> getPeopleAtPlace(Place place);
	public List<Person> getPeopleAtPlace(Place place, Integer radius);
	public List<Person> getPeopleAtPlace(Place place, Integer radius, Integer hoursAgo);
	public List<Placemark> getPlacemarksAtPlace(Place place);
	
	public void setHttpService(HTTPService service);
	public HTTPService getHttpService();
  
}
