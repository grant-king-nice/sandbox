package com.merced.components.liferay.dynamic;

import java.io.Serializable;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

@FacesComponent(value="nice.LiferayDynamicPortletComponent")
public class LiferayDynamicPortletComponent extends UIComponentBase implements Serializable{

	private static final long serialVersionUID = 7655251303488073995L;

	enum PropertyKeys {
		portletId;
	}
	
	public LiferayDynamicPortletComponent() {
		this.setRendererType("com.merced.RuleEntryComponent");
	}

	
	
	@Override
	public String getFamily() {
		return "nice.liferay.portal";
	}



	public String getPortletId() {
		 return (String) getStateHelper().eval(PropertyKeys.portletId, null);
	}



	public void setPortletId(String portletId) {
		 getStateHelper().put(PropertyKeys.portletId, portletId);
	}
	
	

	
	
}
