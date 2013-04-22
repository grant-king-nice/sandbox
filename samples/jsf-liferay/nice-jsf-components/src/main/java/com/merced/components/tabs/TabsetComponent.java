package com.merced.components.tabs;

import java.io.Serializable;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;


@ResourceDependencies({
	@ResourceDependency(library = "js", name = "jquery.tabify.js"),
	@ResourceDependency(library = "css", name = "tabify.css")
	})
@FacesComponent(value="nice.TabsetComponent")
public class TabsetComponent extends UIComponentBase implements Serializable{

	private static final long serialVersionUID = 6522985813486889022L;

	@Override
	public String getFamily() {
		return "nice.liferay.portal";
	}

}
