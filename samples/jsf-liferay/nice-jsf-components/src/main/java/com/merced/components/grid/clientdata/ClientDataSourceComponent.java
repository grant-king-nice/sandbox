package com.merced.components.grid.clientdata;

import java.io.Serializable;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;


@FacesComponent(value = "nice.ClientDataSourceComponent")
public class ClientDataSourceComponent extends UIComponentBase implements Serializable {

	private static final long serialVersionUID = -2131675033901770721L;

	@Override
	public String getFamily() {
		return "nice.liferay.portal";
	}

}
