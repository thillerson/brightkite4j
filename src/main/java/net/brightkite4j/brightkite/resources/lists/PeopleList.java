package net.brightkite4j.brightkite.resources.lists;

import java.util.ArrayList;
import java.util.List;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.resources.Person;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class PeopleList {

	private List<Person> people;
	
	public PeopleList() {
		people = new ArrayList<Person>();
	}
	
	public List<Person> getPeopleList() {
		return people;
	}
	
	public void addPerson(Person person) {
		people.add(person);
	}
	
	public final static PeopleList fromXML(String xml) {
		try {
			PeopleList list = (PeopleList)BrightkiteUtils.fromXML(xml, PeopleList.class);
			return list;
		} catch (Exception e) {
			throw new DeserializationException("Cannot deserialize PeopleList.", e);
		}
	}
}
