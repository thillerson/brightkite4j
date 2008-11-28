package net.brightkite4j.brightkite.resources;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class Note extends PlaceObject {

	public static Note fromXML(String xml) {
		try {
			Note note = (Note)BrightkiteUtils.fromXML(xml, Note.class);
			return note;
		} catch (Exception e) {
			throw new DeserializationException("Could not deserialize Note.", e);
		}
	}

	@Override
	public boolean isANote() {
		return true;
	}

	@Override
	public boolean isAPhoto() {
		return false;
	}
	
}
