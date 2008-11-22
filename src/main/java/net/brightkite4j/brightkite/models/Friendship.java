package net.brightkite4j.brightkite.models;

public class Friendship extends BrightkiteObject {
	
	private Person user;
	private Person friendable;
	private boolean trusted;
	private boolean checkinStreamFeeding;
	private boolean checkinSMSNotifications;
	private boolean checkinEmailNotifications;
	private boolean postStreamFeeding;
	private boolean postSMSNotifications;
	private boolean postEmailNotifications;
	
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

}
