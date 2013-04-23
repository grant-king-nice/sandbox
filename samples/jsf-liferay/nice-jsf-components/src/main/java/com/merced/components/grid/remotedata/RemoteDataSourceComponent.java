package com.merced.components.grid.remotedata;

import java.io.Serializable;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

import com.merced.components.grid.DataProvider;

@FacesComponent(value = "nice.RemoteDataSourceComponent")
public class RemoteDataSourceComponent extends UIComponentBase implements Serializable {

	private static final long serialVersionUID = 2694366393705651062L;

	enum PropertyKeys {
		service,serverPaging,fallback;
	}
	
	
	@Override
	public String getFamily() {
		return "nice.liferay.portal";
	}

	public String getService() {
		return (String) getStateHelper().eval(PropertyKeys.service, null);
	}

	public void setService(String service) {
		getStateHelper().put(PropertyKeys.service, service);
	}
	
	
	public Boolean getServerPaging() {
		return (Boolean) getStateHelper().eval(PropertyKeys.serverPaging, false);
	}

	public void setServerPaging(Boolean serverPaging) {
		getStateHelper().put(PropertyKeys.serverPaging, serverPaging);
	}
	
	public DataProvider<?> getFallback() {
		return (DataProvider<?>) getStateHelper().eval(PropertyKeys.fallback, null);
	}

	public void setFallback(DataProvider<?> fallback) {
		getStateHelper().put(PropertyKeys.fallback, fallback);
	}
	
	
	
}
