package net.brightkite4j.brightkite.resources;

public interface PlaceObject{
	
	public String getId();
	public void setId(String id);

	public boolean isANote();
	public boolean isAPhoto();
	public boolean isACheckin();
	
}
