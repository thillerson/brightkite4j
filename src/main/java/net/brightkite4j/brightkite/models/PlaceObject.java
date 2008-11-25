package net.brightkite4j.brightkite.models;

public interface PlaceObject {
	
	public boolean isANote();
	public boolean isAPhoto();
	public String getBody();
	public void setBody(String body);
	public Person getCreator();
	public void setCreator(Person creator);
	public Place getPlace();
	public void setPlace(Place place);
	public boolean isPublic();
	public void setPublic(boolean _public);
	public boolean isAbout();
	public void setAbout(boolean about);

}
