package net.brightkite4j.brightkite.resources.lists;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.betwixt.io.BeanReader;
import org.xml.sax.InputSource;

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
	
	public final static CommentList fromXML(String xml, String rootElement) {
		try {
			String config = "<?xml version='1.0' encoding='UTF-8' ?>" +
								"<info primitiveTypes='element'>" +
								"<element name='" + rootElement + "'>" +
									"<element name='comment' property='comment' updater='addComment' />" +
									"<addDefaults />" +
								"</element>" +
							"</info>";
			BeanReader reader = new BeanReader();
			reader.registerBeanClass(new InputSource(new StringReader(config)), CommentList.class);
			CommentList list = (CommentList)BrightkiteUtils.fromXML(xml, reader);
			return list;
		} catch (Exception e) {
			throw new DeserializationException("Cannot deserialize CommentList.", e);
		}
	}
	
}