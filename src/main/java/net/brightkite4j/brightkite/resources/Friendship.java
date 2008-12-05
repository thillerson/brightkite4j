package net.brightkite4j.brightkite.resources;

import net.brightkite4j.brightkite.api.Parameter;
import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

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

	public void setUser(Person user) {
		this.user = user;
	}

	public Person getFriendable() {
		return friendable;
	}

	public void setFriendable(Person friendable) {
		this.friendable = friendable;
	}

	public boolean isTrusted() {
		return trusted;
	}

	public void setTrusted(boolean trusted) {
		this.trusted = trusted;
	}

	public boolean isCheckinStreamFeeding() {
		return checkinStreamFeeding;
	}

	public void setCheckinStreamFeeding(boolean checkinStreamFeeding) {
		this.checkinStreamFeeding = checkinStreamFeeding;
	}

	public boolean isCheckinSMSNotifications() {
		return checkinSMSNotifications;
	}

	public void setCheckinSMSNotifications(boolean checkinSMSNotifications) {
		this.checkinSMSNotifications = checkinSMSNotifications;
	}

	public boolean isCheckinEmailNotifications() {
		return checkinEmailNotifications;
	}

	public void setCheckinEmailNotifications(boolean checkinEmailNotifications) {
		this.checkinEmailNotifications = checkinEmailNotifications;
	}

	public boolean isPostStreamFeeding() {
		return postStreamFeeding;
	}

	public void setPostStreamFeeding(boolean postStreamFeeding) {
		this.postStreamFeeding = postStreamFeeding;
	}

	public boolean isPostSMSNotifications() {
		return postSMSNotifications;
	}

	public void setPostSMSNotifications(boolean postSMSNotifications) {
		this.postSMSNotifications = postSMSNotifications;
	}

	public boolean isPostEmailNotifications() {
		return postEmailNotifications;
	}

	public void setPostEmailNotifications(boolean postEmailNotifications) {
		this.postEmailNotifications = postEmailNotifications;
	}
	
	public Parameter[] toParams() {
		Parameter[] params = new Parameter[8];
		params[0] = new Parameter("friendship[trusted]", BrightkiteUtils.booleanToInt(trusted));
		params[1] = new Parameter("friendship[checkin_stream_feeding]", BrightkiteUtils.booleanToInt(checkinStreamFeeding));
		params[2] = new Parameter("friendship[checkin_sms_notifications]", BrightkiteUtils.booleanToInt(checkinSMSNotifications));
		params[3] = new Parameter("friendship[checkin_email_notifications]", BrightkiteUtils.booleanToInt(checkinEmailNotifications));
		params[4] = new Parameter("friendship[post_stream_feeding]", BrightkiteUtils.booleanToInt(postStreamFeeding));
		params[5] = new Parameter("friendship[post_sms_notifications]", BrightkiteUtils.booleanToInt(postSMSNotifications));
		params[6] = new Parameter("friendship[post_email_notifications]", BrightkiteUtils.booleanToInt(postEmailNotifications));
		params[6] = new Parameter("person_id", friendable.getLogin());
		return params;
	}
	
	public final static Friendship fromXML(String xml) {
		try {
			Friendship friendship = (Friendship)BrightkiteUtils.fromXML(xml, Friendship.class);
			return friendship;
		} catch (Exception e) {
			throw new DeserializationException("Unable to deserialize Friendship.", e);
		}
	}
	
	
	
}
