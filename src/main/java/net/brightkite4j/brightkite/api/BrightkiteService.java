package net.brightkite4j.brightkite.api;

import net.brightkite4j.brightkite.resources.*;

public interface BrightkiteService {

	public void setCredentials(String username, String password);
	public void logout();
	public void getInvite(String email);

	public Person getMe();
	public Person[] getMyFriends();
	public Person[] getMyPendingFriends();
	public Placemark[] getMyPlacemarks();
	public DirectMessage[] getMySentDirectMessages();
	public DirectMessage[] getMyRecievedDirectMessages();
	public Block[] getMyBlocks();
	public void changeMySettings(Person person);

	public PlaceObject[] getFriendstream();
	public PlaceObject[] getNearbystream();
	public PlaceObject[] getMentions();
	public Comment[] getCommentstream();

	public Checkin checkin(Place place);
	public void deleteCheckin(Checkin checkin);

	public Friendship makeFriendship(Friendship friendship);
	public void breakFriendship(Friendship friendship);

	public DirectMessage dm(Person person);
	public DirectMessage directMessage(Person person);
	public void deleteDirectMessage(DirectMessage dm);

	public Block blockPerson(Person person);
	public void deleteBlock(Block block);

	public PlaceObject getPlaceObject(String id);
	public Note getNote(String id);
	public Photo getPhoto(String id);
	public Note leaveNote(Place place);
	public Photo leavePhoto(Place place);
	public void deletePlaceObject(PlaceObject placeObject);
	public PlaceObject[] searchObjects(String term);

	public Comment getComment(String id);
	public Comment[] getCommentsAboutPlaceObject(PlaceObject placeObject);
	public Comment leaveComment(PlaceObject placeObject);
	public Comment leaveComment(PlaceObject placeObject, boolean watch);
	public void deleteComment(Comment comment);

	public Person getPerson(String login);
	public Friendship getFriendshipForPerson(Person person);
	public Person[] searchPeople(String term);
	public Person[] getFriendsOfPerson(Person person);
	public Person[] getPendingFriendsOfPerson(Person person);
	public Note[] getNotesByPerson(Person person);
	public Photo[] getPhotosByPerson(Person person);
	public PlaceObject[] getPlaceObjectsByPerson(Person person);

	public Place getPlace(String id);
	public Place[] searchPlaces(String term);
	public PlaceObject[] getPlaceObjectsAtPlace(Place place);
	public Person[] getPeopleAtPlace(Place place);
	public Person[] getPeopleAtPlace(Place place, Integer radius);
	public Person[] getPeopleAtPlace(Place place, Integer radius, Integer hoursAgo);
	public Placemark[] getPlacemarksAtPlace(Place place);
	public Checkin[] getCheckinsAtPlace(Place place);
	
	public void setHttpService(HTTPService service);
	public HTTPService getHttpService();
	public MeXMLService getMeService();
	public void setMeService(MeXMLService meService);

  
}
