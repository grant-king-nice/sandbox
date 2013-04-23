package com.nice.liferay.security;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.model.User;

public interface SecurityService {

	User getLoggedInUser(HttpServletRequest request);
	
	boolean isUserLoggedIn(HttpServletRequest request);
	
}
