package com.merced.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.liferay.faces.portal.context.LiferayFacesContext;


@Component

public class CommentBackingBean {

	private String value;
	private List<CommentValue> comments = new ArrayList<CommentValue>();
	private LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
	
	public void addComment(){
		CommentValue comment = new CommentValue(liferayFacesContext.getUser().getFullName(), value);
		comments.add(comment);
	}

	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}

	public List<CommentValue> getComments() {
		return comments;
	}
	
}
