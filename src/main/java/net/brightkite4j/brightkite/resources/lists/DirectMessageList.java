package net.brightkite4j.brightkite.resources.lists;

import java.util.ArrayList;
import java.util.List;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.resources.DirectMessage;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class DirectMessageList {

	private List<DirectMessage> messages;
	
	public DirectMessageList() {
		messages = new ArrayList<DirectMessage>();
	}
	
	public List<DirectMessage> getDirectMessageList() {
		return messages;
	}
	
	public void addDirectMessage(DirectMessage message) {
		messages.add(message);
	}
	
	public final static DirectMessageList fromXML(String xml) {
		try {
			DirectMessageList list = (DirectMessageList)BrightkiteUtils.fromXML(xml, DirectMessageList.class);
			return list;
		} catch (Exception e) {
			throw new DeserializationException("Cannot deserialize DirectMessageList.", e);
		}
	}
}
