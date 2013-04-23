package com.nice.liferay.portlet.userlist;

public class SampleUser {

	
	private String firstName;
	private String lastName;
	private String city;
	private long age;
	private String title;
	
	public SampleUser(String firstName, String lastName, String city, String title,long age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.age = age;
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}

	public long getAge() {
		return age;
	}
	
	public String getTitle() {
		return title;
	}
	
}
