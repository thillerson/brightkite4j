package net.brightkite4j.brightkite.models;

import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Person {
	
	private String login;
	private String fullname;
	private String description;
	private String age;
	private String sex;
	private String website;
	private String smallAvatarUrl;
	private String smallerAvatarUrl;
	private String tinyAvatarUrl;

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

	protected final static Person fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		Person person = new Person();
		if (jsonObject.has("login")) {
			person.setLogin(jsonObject.getString("login"));
		}
		if (jsonObject.has("fullname")) {
			person.setFullname(jsonObject.getString("fullname"));
		}
		if (jsonObject.has("age")) {
			person.setAge(jsonObject.getString("age"));
		}
		if (jsonObject.has("sex")) {
			person.setSex(jsonObject.getString("sex"));
		}
		if (jsonObject.has("website")) {
			person.setWebsite(jsonObject.getString("website"));
		}
		if (jsonObject.has("small_avatar_url")) {
			person.setSmallAvatarUrl(jsonObject.getString("small_avatar_url"));
		}
		if (jsonObject.has("smaller_avatar_url")) {
			person.setSmallerAvatarUrl(jsonObject.getString("smaller_avatar_url"));
		}
		if (jsonObject.has("tiny_avatar_url")) {
			person.setTinyAvatarUrl(jsonObject.getString("tiny_avatar_url"));
		}
		
		return person;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
