package net.brightkite4j.brightkite.models;

import net.brightkite4j.brightkite.utils.BrightkiteUtils;
import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

public class Block {

	private String blocker;
	private String blockee;
	private DateTime createdAt;

	public String getBlocker() {
		return blocker;
	}

	protected void setBlocker(String blocker) {
		this.blocker = blocker;
	}

	public String getBlockee() {
		return blockee;
	}

	protected void setBlockee(String blockee) {
		this.blockee = blockee;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	protected void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	protected void setCreatedAt(String createdAtString) {
		setCreatedAt(BrightkiteUtils.parseDateTimeFromString(createdAtString));
	}
	
	public final static Block fromJSONString(String jsonString) {
		return fromJSON(JSONObject.fromObject(jsonString));
	}

	public final static Block fromJSON(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		Block block = new Block();
		if (jsonObject.has("created_at")) {
			block.setCreatedAt(jsonObject.getString("created_at"));
		}
		if (jsonObject.has("blocker")) {
			block.setBlocker(jsonObject.getString("blocker"));
		}
		if (jsonObject.has("blockee")) {
			block.setBlockee(jsonObject.getString("blockee"));
		}

		return block;
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
