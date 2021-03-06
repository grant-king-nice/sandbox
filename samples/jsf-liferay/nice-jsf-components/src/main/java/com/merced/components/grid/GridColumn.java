package com.merced.components.grid;

import java.io.Serializable;

public class GridColumn implements Serializable{

	private static final long serialVersionUID = -6486764471630583797L;

	private String field;
	private long width;
	private String title;
	private String template;
	private String type;

	
	public GridColumn(String field, long width, String title, String template, String type) {
		this.field = field;
		this.width = width;
		this.title = title;
		this.template = template;
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getField() {
		return field;
	}
	public long getWidth() {
		return width;
	}
	public String getTitle() {
		return title;
	}

	public String getTemplate() {
		return template;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
