package com.merced.system.renderkitresolver;

import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.util.PortalUtil;

public class DynamicRenderKitViewHandler extends ViewHandlerWrapper {

	private ViewHandler wrapped;

	public DynamicRenderKitViewHandler(ViewHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ViewHandler getWrapped() {
		return wrapped;
	}

	@Override
	public String calculateRenderKitId(FacesContext context) {

		PortletRequest request = (PortletRequest) context.getExternalContext().getRequest();

		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
		String agent = httpRequest.getHeader("user-agent");

		if (agent.contains("Chrome")) {
			return "HTML_MOBILE";
		}

		return getWrapped().calculateRenderKitId(context);
	}

}
