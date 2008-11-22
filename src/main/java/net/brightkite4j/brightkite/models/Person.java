package net.brightkite4j.brightkite.models;

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
	private DateTime lastCheckedIn;

	public String getLogin() {
		return login;
	}

	protected void setLogin(String login) {
		this.login = login;
	}

	public String getFullname() {
		return fullname;
	}

	protected void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDescription() {
		return description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	public String getAge() {
		return age;
	}

	protected void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	protected void setSex(String sex) {
		this.sex = sex;
	}

	public String getWebsite() {
		return website;
	}

	protected void setWebsite(String website) {
		this.website = website;
	}

	public String getSmallAvatarUrl() {
		return smallAvatarUrl;
	}

	protected void setSmallAvatarUrl(String smallAvatarUrl) {
		this.smallAvatarUrl = smallAvatarUrl;
	}

	public String getSmallerAvatarUrl() {
		return smallerAvatarUrl;
	}

	protected void setSmallerAvatarUrl(String smallerAvatarUrl) {
		this.smallerAvatarUrl = smallerAvatarUrl;
	}

	public String getTinyAvatarUrl() {
		return tinyAvatarUrl;
	}

	protected void setTinyAvatarUrl(String tinyAvatarUrl) {
		this.tinyAvatarUrl = tinyAvatarUrl;
	}

	public DateTime getLastCheckedIn() {
		return lastCheckedIn;
	}

	public void setLastCheckedIn(DateTime lastCheckedIn) {
		this.lastCheckedIn = lastCheckedIn;
	}

	public void setLastCheckedIn(String lastCheckedInString) {
		this.lastCheckedIn = BrightkiteUtils.parseDateTimeFromString(lastCheckedInString);
	}

}
