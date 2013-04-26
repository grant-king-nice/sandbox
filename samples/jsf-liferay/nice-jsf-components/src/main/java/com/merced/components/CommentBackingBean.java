package com.merced.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.merced.system.renderkitresolver.UserProvider;


@Component
public class CommentBackingBean {

	private String value;
	private List<CommentValue> comments = new ArrayList<CommentValue>();
	@Autowired
	private UserProvider userProvider;
	
	public void addComment(){
		CommentValue comment = new CommentValue(userProvider.getCurrentUser().getFullName(), value);
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
