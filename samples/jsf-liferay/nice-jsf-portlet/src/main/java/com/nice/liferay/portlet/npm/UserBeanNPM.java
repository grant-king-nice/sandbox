package com.nice.liferay.portlet.npm;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
public class UserBeanNPM {

	private String title;
	private String group;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	
	public void save(){
		System.out.println("Save NPM data ----------------");
		System.out.println("title -> " + title);
		System.out.println("group -> " + group);
	}
	
	
	
}
