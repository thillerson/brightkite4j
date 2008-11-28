package net.brightkite4j.brightkite.resources.lists;

import java.util.ArrayList;
import java.util.List;

import net.brightkite4j.brightkite.exceptions.DeserializationException;
import net.brightkite4j.brightkite.resources.Comment;
import net.brightkite4j.brightkite.utils.BrightkiteUtils;

public class CommentList {
	private List<Comment> comments;
	
	public CommentList() {
		comments = new ArrayList<Comment>();
	}
	
	public List<Comment> getCommentList() {
		return comments;
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public final static CommentList fromXML(String xml) {
		try {
			CommentList list = (CommentList)BrightkiteUtils.fromXML(xml, CommentList.class);
			return list;
		} catch (Exception e) {
			throw new DeserializationException("Cannot deserialize CommentList.", e);
		}
	}
	
}