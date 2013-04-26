package com.merced.system.renderkitresolver;

import org.springframework.stereotype.Service;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.model.User;

@Service
public class UserProviderImpl implements UserProvider{

	public User getCurrentUser() {
		return LiferayFacesContext.getInstance().getUser();
	}

}
