package com.nice.liferay.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;


@Service
public class SecurityServiceImpl implements SecurityService{

	public User getLoggedInUser(HttpServletRequest request) {
		try {
			User user = PortalUtil.getUser(request);
			return user;
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isUserLoggedIn(HttpServletRequest request) {
		User user = this.getLoggedInUser(request);
		return user != null;
	}

}
