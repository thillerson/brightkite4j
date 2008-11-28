package net.brightkite4j.brightkite.exceptions;

public class ServiceException extends RuntimeException {

	public ServiceException(String string) {
		super(string);
	}

	public ServiceException(Exception e) {
		super(e);
	}
	
	public ServiceException(String s, Exception e) {
		super(s, e);
	}

	private static final long serialVersionUID = 4074955185196089194L;

}
