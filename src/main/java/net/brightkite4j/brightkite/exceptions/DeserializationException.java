package net.brightkite4j.brightkite.exceptions;

public class DeserializationException extends RuntimeException {

	private static final long serialVersionUID = -7960215315186570936L;

	public DeserializationException(String string, Exception e) {
		super(string, e);
	}

}
