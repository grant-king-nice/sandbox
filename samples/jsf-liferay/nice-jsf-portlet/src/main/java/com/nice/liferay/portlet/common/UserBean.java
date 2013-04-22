package com.nice.liferay.portlet.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
public class UserBean {

	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void save(){
		System.out.println("Save COMMON data ----------------");
		System.out.println("firstName -> " + firstName);
		System.out.println("lastName -> " + lastName);
	}
	
}
