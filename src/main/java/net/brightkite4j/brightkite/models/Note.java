package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class Note extends PlaceObject {
	
	@Override
	public boolean aNote() {
		return true;
	}

	@Override
	public boolean aPhoto() {
		return false;
	}
	
	public final static Note fromXML(String xml) {
		try {
			Note note = (Note)BrightkiteUtils.fromXML(xml, Note.class);
			return note;
		} catch (Exception e) {
			throw new DeserializationException("Could not deserialize Note.", e);
		}
	}

}
