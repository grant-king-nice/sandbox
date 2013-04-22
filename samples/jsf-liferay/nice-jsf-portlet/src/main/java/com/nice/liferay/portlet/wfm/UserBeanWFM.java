package com.nice.liferay.portlet.wfm;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
public class UserBeanWFM {

	private String wfmCustomField1;
	private String wfmCustomField2;
	
	public String getWfmCustomField1() {
		return wfmCustomField1;
	}
	public void setWfmCustomField1(String wfmCustomField1) {
		this.wfmCustomField1 = wfmCustomField1;
	}
	public String getWfmCustomField2() {
		return wfmCustomField2;
	}
	public void setWfmCustomField2(String wfmCustomField2) {
		this.wfmCustomField2 = wfmCustomField2;
	}
	
	public void save(){
		System.out.println("Save WFM data ----------------");
		System.out.println("wfmCustomField1 -> " +wfmCustomField1);
		System.out.println("wfmCustomField2 -> " +wfmCustomField2);
	}
	
}
