package com.nice.liferay.portlet.demo;

import org.springframework.stereotype.Component;

@Component
public class DemoTreeInfoBackingBean {
	
	
	private String treeName;
	private String treeDescription;
	
	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	public String getTreeDescription() {
		return treeDescription;
	}
	public void setTreeDescription(String treeDescription) {
		this.treeDescription = treeDescription;
	}
	
	
	public void saveTree(){
		System.out.println(treeName + " - "+ treeDescription);
	}
	
	
}
