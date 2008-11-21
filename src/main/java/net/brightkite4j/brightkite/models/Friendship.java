package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.utils.BrightkiteUtils;
import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

public class Friendship {
	
	private Person user;
	private Person friendable;
	private boolean trusted;
	private boolean checkinStreamFeeding;
	private boolean checkinSMSNotifications;
	private boolean checkinEmailNotifications;
	private boolean postStreamFeeding;
	private boolean postSMSNotifications;
	private boolean postEmailNotifications;
	private DateTime createdAt;
	
	public Person getUser() {
		return user;
	}

	protected void setUser(Person user) {
		this.user = user;
	}

	public Person getFriendable() {
		return friendable;
	}

	protected void setFriendable(Person friendable) {
		this.friendable = friendable;
	}

	public boolean isTrusted() {
		return trusted;
	}

	protected void setTrusted(boolean trusted) {
		this.trusted = trusted;
	}

	public boolean isCheckinStreamFeeding() {
		return checkinStreamFeeding;
	}

	protected void setCheckinStreamFeeding(boolean checkinStreamFeeding) {
		this.checkinStreamFeeding = checkinStreamFeeding;
	}

	public boolean isCheckinSMSNotifications() {
		return checkinSMSNotifications;
	}

	protected void setCheckinSMSNotifications(boolean checkinSMSNotifications) {
		this.checkinSMSNotifications = checkinSMSNotifications;
	}

	public boolean isCheckinEmailNotifications() {
		return checkinEmailNotifications;
	}

	protected void setCheckinEmailNotifications(boolean checkinEmailNotifications) {
		this.checkinEmailNotifications = checkinEmailNotifications;
	}

	public boolean isPostStreamFeeding() {
		return postStreamFeeding;
	}

	protected void setPostStreamFeeding(boolean postStreamFeeding) {
		this.postStreamFeeding = postStreamFeeding;
	}

	public boolean isPostSMSNotifications() {
		return postSMSNotifications;
	}

	protected void setPostSMSNotifications(boolean postSMSNotifications) {
		this.postSMSNotifications = postSMSNotifications;
	}

	public boolean isPostEmailNotifications() {
		return postEmailNotifications;
	}

	protected void setPostEmailNotifications(boolean postEmailNotifications) {
		this.postEmailNotifications = postEmailNotifications;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	protected void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	protected void setCreatedAt(String createdAtString) {
		this.createdAt = BrightkiteUtils.parseDateTimeFromString(createdAtString);
	}
	
	protected final static Friendship fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		Friendship friendship = new Friendship();
		if (jsonObject.has("user")) {
			friendship.setUser(Person.fromJSON(jsonObject.getJSONObject("user")));
		}
		if (jsonObject.has("friendable")) {
			friendship.setFriendable(Person.fromJSON(jsonObject.getJSONObject("friendable")));
		}
		if (jsonObject.has("trusted")) {
			friendship.setTrusted(jsonObject.getBoolean("trusted"));
		}
		if (jsonObject.has("checkinStreamFeeding")) {
			friendship.setCheckinStreamFeeding(jsonObject.getBoolean("checkinStreamFeeding"));
		}
		if (jsonObject.has("checkinSMSNotifications")) {
			friendship.setCheckinSMSNotifications(jsonObject.getBoolean("checkinSMSNotifications"));
		}
		if (jsonObject.has("checkinEmailNotifications")) {
			friendship.setCheckinEmailNotifications(jsonObject.getBoolean("checkinEmailNotifications"));
		}
		if (jsonObject.has("postStreamFeeding")) {
			friendship.setPostStreamFeeding(jsonObject.getBoolean("postStreamFeeding"));
		}
		if (jsonObject.has("postSMSNotifications")) {
			friendship.setPostSMSNotifications(jsonObject.getBoolean("postSMSNotifications"));
		}
		if (jsonObject.has("postEmailNotifications")) {
			friendship.setPostEmailNotifications(jsonObject.getBoolean("postEmailNotifications"));
		}
		if (jsonObject.has("created_at")) {
			friendship.setCreatedAt(jsonObject.getString("created_at"));
		}
		
		return friendship;
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
