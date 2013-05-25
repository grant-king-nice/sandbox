package com.merced.components.poc.components;

import java.io.Serializable;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

@FacesComponent(value="nice.Component2")
public class POCComp2Component extends UIComponentBase implements Serializable{

	private static final long serialVersionUID = -2518293029422592060L;

	@Override
	public String getFamily() {
		return "nice.liferay.portal";
	}

}
