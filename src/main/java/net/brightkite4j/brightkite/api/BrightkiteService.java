package net.brightkite4j.brightkite.api;

import java.util.List;

import net.brightkite4j.brightkite.resources.*;

interface BrightkiteService {
	
  void login(String username, String password);
  void logout();
  void getInvite(String email);
  
  Person getMe();
  List<Person> getMyFriends();
  List<Person> getMyPendingFriends();
  List<Placemark> getMyPlacemarks();
  List<DirectMessage> getMySentDirectMessages();
  List<DirectMessage> getMyRecievedDirectMessages();
  List<Block> getMyBlocks();
  void changeMySettings(Person person);
  
  List<PlaceObject> getFriendstream();
  List<PlaceObject> getNearbystream();
  List<PlaceObject> getMentions();
  List<Comment> getCommentstream();
  
  Checkin checkin(Place place);
  void deleteCheckin(Checkin checkin);

  Friendship makeFriendship(Friendship friendship);
  void breakFriendship(Friendship friendship);
  
  DirectMessage dm(Person person);
  DirectMessage directMessage(Person person);
  void deleteDirectMessage(DirectMessage dm);
  
  Block blockPerson(Person person);
  void deleteBlock(Block block);
  
  PlaceObject getPlaceObject(String id);
  Note getNote(String id);
  Photo getPhoto(String id);
  Note leaveNote(Place place);
  Photo leavePhoto(Place place);
  void deletePlaceObject(PlaceObject placeObject);
  List<PlaceObject> searchObjects(String term);
  
  Comment getComment(String id);
  List<Comment> getCommentsAboutPlaceObject(PlaceObject placeObject);
  Comment leaveComment(PlaceObject placeObject);
  Comment leaveComment(PlaceObject placeObject, boolean watch);
  void deleteComment(Comment comment);
  
  Person getPerson(String login);
  Friendship getFriendshipForPerson(Person person);
  List<Person> searchPeople(String term);
  List<Person> getFriendsOfPerson(Person person);
  List<Person> getPendingFriendsOfPerson(Person person);
  List<Note> getNotesByPerson(Person person);
  List<Photo> getPhotosByPerson(Person person);
  List<PlaceObject> getPlaceObjectsByPerson(Person person);
  
  Place getPlace(String id);
  List<Place> searchPlaces(String term);
  List<PlaceObject> getPlaceObjectsAtPlace(Place place);
  List<Person> getPeopleAtPlace(Place place);
  List<Person> getPeopleAtPlace(Place place, Integer radius);
  List<Person> getPeopleAtPlace(Place place, Integer radius, Integer hoursAgo);
  List<Placemark> getPlacemarksAtPlace(Place place);
  List<Checkin> getCheckinsAtPlace(Place place);
  
}
