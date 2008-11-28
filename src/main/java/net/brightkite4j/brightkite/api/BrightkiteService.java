package net.brightkite4j.brightkite.api;

import net.brightkite4j.brightkite.resources.*;

interface BrightkiteService {

  boolean login(String username, String password);
  void logout();
  void getInvite(String email);
  
  Person getMe();
  Person[] getMyFriends();
  Person[] getMyPendingFriends();
  Placemark[] getMyPlacemarks();
  DirectMessage[] getMySentDirectMessages();
  DirectMessage[] getMyRecievedDirectMessages();
  Block[] getMyBlocks();
  void changeMySettings(Person person);
  
  PlaceObject[] getFriendstream();
  PlaceObject[] getNearbystream();
  PlaceObject[] getMentions();
  Comment[] getCommentstream();
  
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
  PlaceObject[] searchObjects(String term);
  
  Comment getComment(String id);
  Comment[] getCommentsAboutPlaceObject(PlaceObject placeObject);
  Comment leaveComment(PlaceObject placeObject);
  Comment leaveComment(PlaceObject placeObject, boolean watch);
  void deleteComment(Comment comment);
  
  Person getPerson(String login);
  Friendship getFriendshipForPerson(Person person);
  Person[] searchPeople(String term);
  Person[] getFriendsOfPerson(Person person);
  Person[] getPendingFriendsOfPerson(Person person);
  Note[] getNotesByPerson(Person person);
  Photo[] getPhotosByPerson(Person person);
  PlaceObject[] getPlaceObjectsByPerson(Person person);
  
  Place getPlace(String id);
  Place[] searchPlaces(String term);
  PlaceObject[] getPlaceObjectsAtPlace(Place place);
  Person[] getPeopleAtPlace(Place place);
  Person[] getPeopleAtPlace(Place place, Integer radius);
  Person[] getPeopleAtPlace(Place place, Integer radius, Integer hoursAgo);
  Placemark[] getPlacemarksAtPlace(Place place);
  Checkin[] getCheckinsAtPlace(Place place);
  
}
