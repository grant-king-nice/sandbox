package com.merced.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class CommentBackingBean {

	private String value;
	
	private List<String> comments = new ArrayList<String>();
	
	
	public void addComment(){
		comments.add(value);
	}

	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getComments() {
		return comments;
	}
	
	
	
}
