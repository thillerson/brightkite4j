package net.brightkite4j.brightkite.api.xmlservices;

import java.util.List;

import net.brightkite4j.brightkite.api.Brightkite;
import net.brightkite4j.brightkite.api.HTTPService;
import net.brightkite4j.brightkite.api.Parameter;
import net.brightkite4j.brightkite.resources.Checkin;
import net.brightkite4j.brightkite.resources.Comment;
import net.brightkite4j.brightkite.resources.Note;
import net.brightkite4j.brightkite.resources.Photo;
import net.brightkite4j.brightkite.resources.PlaceObject;
import net.brightkite4j.brightkite.resources.PlaceObjectFilter;
import net.brightkite4j.brightkite.resources.lists.CommentList;
import net.brightkite4j.brightkite.resources.lists.PlaceObjectList;

public class PlaceObjectXMLService {

	private HTTPService httpService;
	private final String placeObjectsBaseUrl = Brightkite.URL_BASE + "/objects";

	public PlaceObjectXMLService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public void setHttpService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public List<PlaceObject> getPlaceObjects(PlaceObjectFilter filter) {
		String url = placeObjectsBaseUrl + ".xml";
		Parameter[] filters = null;
		if (null != filter) {
			Parameter filterParam = new Parameter("filters", filter.toString());
			filters = new Parameter[]{filterParam};
		}
		String result = httpService.get(url, filters);
		PlaceObjectList list = PlaceObjectList.fromXML(result);
		return list.getPlaceObjectList();
	}
	
	public Note getNote(String id) {
		String result = getPlaceObjectXML(id);
		Note note = Note.fromXML(result);
		return note;
	}

	public Photo getPhoto(String id) {
		String result = getPlaceObjectXML(id);
		Photo photo = Photo.fromXML(result);
		return photo;
	}

	public Checkin getCheckin(String id) {
		String result = getPlaceObjectXML(id);
		Checkin checkin = Checkin.fromXML(result);
		return checkin;
	}

	public void deletePlaceObject(PlaceObject placeObject) {
		String url = placeObjectsBaseUrl + "/" + placeObject.getId() + ".xml";
		httpService.delete(url);
	}
	
	public List<Comment> getCommentsAboutPlaceObject(PlaceObject placeObject) {
		String url = placeObjectsBaseUrl + "/" + placeObject.getId() + "/comments.xml";
		return CommentList.fromXML(httpService.get(url), "comments").getCommentList();
	}

	public Comment leaveComment(PlaceObject placeObject, String comment, boolean watch) {
		String url = placeObjectsBaseUrl + "/" + placeObject.getId() + "/comments.xml";
		Parameter commentParam = new Parameter("comment[comment]", comment);
		Parameter watchParam = new Parameter("watch_item", watch);
		Parameter[] params = new Parameter[]{ commentParam, watchParam };
		return Comment.fromXML(httpService.post(url, params));
	}

	private String getPlaceObjectXML(String id) {
		String url = placeObjectsBaseUrl + "/" + id + ".xml";
		return httpService.get(url);
	}

}
