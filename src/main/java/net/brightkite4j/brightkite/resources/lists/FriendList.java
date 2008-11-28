package net.brightkite4j.brightkite.resources.lists;

import java.util.ArrayList;
import java.util.List;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class FriendList {
	
	private List<Person> friends;
	
	public FriendList() {
		friends = new ArrayList<Person>();
	}
	
	public List<Person> getFriendList() {
		return friends;
	}
	
	public void addPerson(Person person) {
		friends.add(person);
	}
	
	public final static FriendList fromXML(String xml) {
		try {
			FriendList list = (FriendList)BrightkiteUtils.fromXML(xml, FriendList.class);
			return list;
		} catch (Exception e) {
			throw new DeserializationException("Cannot deserialize FriendList.", e);
		}
	}
	
}