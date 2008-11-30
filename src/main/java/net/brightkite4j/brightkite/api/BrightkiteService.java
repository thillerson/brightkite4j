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

	public List<PlaceObject> getFriendstream();
	public List<PlaceObject> getNearbystream();
	public List<PlaceObject> getMentions();
	public List<Comment> getCommentstream();

	public Checkin checkin(Place place);
	public void deleteCheckin(Checkin checkin);

	public Friendship makeFriendship(Friendship friendship);
	public void breakFriendship(Friendship friendship);

	public DirectMessage dm(Person person);
	public DirectMessage directMessage(Person person);
	public void deleteDirectMessage(DirectMessage dm);

	public Block blockPerson(Person person);
	public void deleteBlock(Block block);

	public Note getNote(String id);
	public Photo getPhoto(String id);
	public Checkin getCheckin(String id);
	public Note leaveNote(Place place, Note newNote);
	public Photo leavePhoto(Place place, Photo newPhoto);
	public void deleteNote(Note note);
	public void deletePhoto(Photo photo);
	public List<PlaceObject> searchObjects(String term);

	public Comment getComment(String id);
	public List<Comment> getCommentsAboutPlaceObject(PlaceObject placeObject);
	public Comment leaveComment(PlaceObject placeObject, Comment newComment);
	public Comment leaveComment(PlaceObject placeObject, Comment newComment, boolean watch);
	public void deleteComment(Comment comment);

	public Person getPerson(String login);
	public Friendship getFriendshipForPerson(Person person);
	public List<Person> searchPeople(String term);
	public List<Person> getFriendsOfPerson(Person person);
	public List<Person> getPendingFriendsOfPerson(Person person);
	public List<Note> getNotesByPerson(Person person);
	public List<Photo> getPhotosByPerson(Person person);
	public List<PlaceObject> getPlaceObjectsByPerson(Person person);

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
