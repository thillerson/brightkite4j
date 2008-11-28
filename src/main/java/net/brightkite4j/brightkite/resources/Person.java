package net.brightkite4j.brightkite.resources;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

import org.joda.time.DateTime;

public class Person extends BrightkiteObject {
	
	private String login;
	private String fullname;
	private String description;
	private String age;
	private String sex;
	private String website;
	private String smallAvatarUrl;
	private String smallerAvatarUrl;
	private String tinyAvatarUrl;
	private Place place;
	private DateTime lastCheckedIn;
	private String lastCheckedInAsWords;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getSmallAvatarUrl() {
		return smallAvatarUrl;
	}

	public void setSmallAvatarUrl(String smallAvatarUrl) {
		this.smallAvatarUrl = smallAvatarUrl;
	}

	public String getSmallerAvatarUrl() {
		return smallerAvatarUrl;
	}

	public void setSmallerAvatarUrl(String smallerAvatarUrl) {
		this.smallerAvatarUrl = smallerAvatarUrl;
	}

	public String getTinyAvatarUrl() {
		return tinyAvatarUrl;
	}

	public void setTinyAvatarUrl(String tinyAvatarUrl) {
		this.tinyAvatarUrl = tinyAvatarUrl;
	}

	public DateTime getLastCheckedIn() {
		return lastCheckedIn;
	}

	public void setLastCheckedIn(DateTime lastCheckedIn) {
		this.lastCheckedIn = lastCheckedIn;
	}

	public String getLastCheckedInTimestamp() {
		return lastCheckedIn.toString();
	}
	
	public void setLastCheckedInTimestamp(String lastCheckedInString) {
		this.lastCheckedIn = BrightkiteUtils.parseDateTimeFromString(lastCheckedInString);
	}
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public void setLastCheckedInAsWords(String s) {
		lastCheckedInAsWords = s;
	}

	public String getLastCheckedInAsWords() {
		return lastCheckedInAsWords;
	}

	public final static Person fromXML(String xml) {
		try {
			Person person = (Person)BrightkiteUtils.fromXML(xml, Person.class);
			return person;
		} catch (Exception e) {
			throw new DeserializationException("Cannot deserialize Person.", e);
		}
	}

}
