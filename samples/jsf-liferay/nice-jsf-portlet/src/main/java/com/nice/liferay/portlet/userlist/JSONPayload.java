package com.nice.liferay.portlet.userlist;

public class JSONPayload {

	private Object data;
	private int total;
	
	public JSONPayload(Object data, int total) {
		super();
		this.data = data;
		this.total = total;
	}
	public Object getData() {
		return data;
	}
	public int getTotal() {
		return total;
	}
	
	
	
}
