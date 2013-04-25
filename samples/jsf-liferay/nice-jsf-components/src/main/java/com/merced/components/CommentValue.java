package com.merced.components;

import java.util.Date;

public class CommentValue {

	private Date date = new Date();
	private String name;
	private String value;
	
	public CommentValue(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public Date getDate() {
		return date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
	
}
