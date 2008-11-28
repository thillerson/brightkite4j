package net.brightkite4j.brightkite.resources.lists;

import java.util.ArrayList;
import java.util.List;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class PendingFriendList {

	private List<Person> friends;
	
	public PendingFriendList() {
		friends = new ArrayList<Person>();
	}
	
	public List<Person> getPendingFriendList() {
		return friends;
	}
	
	public void addPerson(Person person) {
		friends.add(person);
	}
	
	public final static PendingFriendList fromXML(String xml) {
		try {
			PendingFriendList list = (PendingFriendList)BrightkiteUtils.fromXML(xml, PendingFriendList.class);
			return list;
		} catch (Exception e) {
			throw new DeserializationException("Cannot deserialize PendingFriendList.", e);
		}
	}
}
