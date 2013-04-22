package com.merced.components.tabs;

import java.io.Serializable;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

@FacesComponent(value="nice.TabComponent")
public class TabComponent extends UIComponentBase implements Serializable{


	private static final long serialVersionUID = -8345357908389653696L;

	enum PropertyKeys {
		header;
	}
	
	@Override
	public String getFamily() {
		return "nice.liferay.portal";
	}
	
	
	public String getHeader() {
		 return (String) getStateHelper().eval(PropertyKeys.header, null);
	}



	public void setHeader(String header) {
		 getStateHelper().put(PropertyKeys.header, header);
	}
	
	
	
}
