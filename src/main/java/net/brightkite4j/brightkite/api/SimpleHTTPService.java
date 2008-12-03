package net.brightkite4j.brightkite.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.brightkite4j.brightkite.exceptions.ServiceException;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class SimpleHTTPService implements HTTPService {
	
	private final AuthScope AUTH_SCOPE = new AuthScope("brightkite.com", 80, AuthScope.ANY_REALM);
	private Credentials credentials = null;
	private HttpConnectionManager manager = null;

	private HttpConnectionManager getHttpConnectionManager() {
		if (this.manager == null) {
			this.manager = new MultiThreadedHttpConnectionManager();
		}
		return this.manager;
	}

	protected void setHttpConnectionManager(HttpConnectionManager manager) {
		this.manager = manager;
	}

	/* (non-Javadoc)
	 * @see net.brightkite4j.brightkite.api.HTTPService#get(java.lang.String)
	 */
	public String get(String url) throws ServiceException {
		return get(url, null);
	}

	/* (non-Javadoc)
	 * @see net.brightkite4j.brightkite.api.HTTPService#get(java.lang.String, net.brightkite4j.brightkite.api.Parameter[])
	 */
	public String get(String url, Parameter[] parameters) throws ServiceException {
		return execute(new GetMethod(url), parameters);
	}

	/* (non-Javadoc)
	 * @see net.brightkite4j.brightkite.api.HTTPService#post(java.lang.String)
	 */
	public String post(String url) throws ServiceException {
		return post(url, null);
	}

	/* (non-Javadoc)
	 * @see net.brightkite4j.brightkite.api.HTTPService#post(java.lang.String, net.brightkite4j.brightkite.api.Parameter[])
	 */
	public String post(String url, Parameter[] parameters) throws ServiceException {
		return execute(new PostMethod(url), parameters);
	}

	public void delete(String url) throws ServiceException {
		execute(new DeleteMethod(url), null);
	}

	/* (non-Javadoc)
	 * @see net.brightkite4j.brightkite.api.HTTPService#setCredentials(java.lang.String, java.lang.String)
	 */
	public void setCredentials(String username, String password) {
		assert (username != null);
		assert (password != null);
		setCredentials(new UsernamePasswordCredentials(username, password));
	}

	private void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	/* (non-Javadoc)
	 * @see net.brightkite4j.brightkite.api.HTTPService#clearCredentials()
	 */
	public void clearCredentials() {
		this.credentials = null;
	}

	/* (non-Javadoc)
	 * @see net.brightkite4j.brightkite.api.HTTPService#hasCredentials()
	 */
	public boolean hasCredentials() {
		return credentials != null;
	}

	private Credentials getCredentials() {
		return this.credentials;
	}

	private NameValuePair[] toNameValuePairArray(Parameter[] in) {
		if (in == null) {
			return new NameValuePair[] {};
		}
		List<NameValuePair> out = new ArrayList<NameValuePair>();
		for (Parameter parameter : in) {
			if (null != parameter && parameter.hasName() && parameter.hasValue()) {
				out.add(new NameValuePair(parameter.getName(), parameter.getValue().toString()));
			}
		}
		return (NameValuePair[]) out.toArray(new NameValuePair[out.size()]);
	}

	private String execute(HttpMethod method, Parameter[] parameters) throws ServiceException {
		method.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		method.setQueryString(toNameValuePairArray(parameters));
		HttpClient httpClient = new HttpClient(getHttpConnectionManager());
		if (hasCredentials()) {
			httpClient.getState().setCredentials(AUTH_SCOPE, getCredentials());
			httpClient.getParams().setAuthenticationPreemptive(true);
		} else {
			httpClient.getParams().setAuthenticationPreemptive(false);
		}
		try {
			int statusCode = httpClient.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK && statusCode != HttpStatus.SC_CREATED) {
				String error = String.format("Expected a 200 OK or 201 Created. Received %d %s", statusCode, HttpStatus.getStatusText(statusCode));
				throw new ServiceException(error);
			}
			String responseBody = method.getResponseBodyAsString();
			if (responseBody == null) {
				throw new ServiceException("Expected response body, got null");
			}
			return responseBody;
		} catch (HttpException e) {
			throw new ServiceException(e);
		} catch (IOException e) {
			throw new ServiceException(e);
		} finally {
			method.releaseConnection();
		}
	}

}
