package net.brightkite4j.brightkite.api;

import net.brightkite4j.brightkite.exceptions.ServiceException;

public interface HTTPService {

	public abstract String get(String url) throws ServiceException;

	public abstract String get(String url, Parameter[] parameters) throws ServiceException;

	public abstract String post(String url) throws ServiceException;

	public abstract String post(String url, Parameter[] parameters) throws ServiceException;

	public abstract void delete(String url) throws ServiceException;
	
	public abstract void delete(String url, Parameter[] parameters) throws ServiceException;
	
	public abstract void setCredentials(String username, String password);

	public abstract void clearCredentials();

	public abstract boolean hasCredentials();


}