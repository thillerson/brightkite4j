package net.brightkite4j.brightkite.models;

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

	public final static Block fromJSON(String jsonString) {
		return (Block)BrightkiteUtils.fromJSON(jsonString, Block.class);
	}
	
}
