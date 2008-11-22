package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class Block extends BrightkiteObject {

	private String blocker;
	private String blockee;

	public String getBlocker() {
		return blocker;
	}

	public void setBlocker(String blocker) {
		this.blocker = blocker;
	}

	public String getBlockee() {
		return blockee;
	}

	public void setBlockee(String blockee) {
		this.blockee = blockee;
	}
	
	public final static Block fromXML(String xml) {
		try {
			return (Block)BrightkiteUtils.fromXML(xml, Block.class);    
		} catch (Exception e) {
			throw new DeserializationException("Unable to deserialize Block from XML", e); 
		}
	}

}
