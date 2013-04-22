package com.merced.components.liferay.dynamic;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.layoutconfiguration.util.RuntimePortletUtil;

@FacesRenderer(componentFamily = "nice.liferay.portal", rendererType = "com.nice.LiferayDynamicPortletComponent")
public class LiferayDynamicPortletRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		LiferayDynamicPortletComponent portletComp = (LiferayDynamicPortletComponent)component;
		doTag(context, portletComp.getPortletId());
		
	}


	@Override
	public void encodeEnd(FacesContext context, UIComponent component)
			throws IOException {
	}
	
	private void doTag(FacesContext context, String portletId) {

		PortletRequest portletRequest = (PortletRequest) context.getExternalContext().getRequest();
		HttpServletRequest request = PortalUtil.getHttpServletRequest(portletRequest);
		request = PortalUtil.getOriginalServletRequest(request);
		
		RenderRequest renderRequest = null;

		if ((portletRequest != null) && (portletRequest instanceof RenderRequest)) {

			renderRequest = (RenderRequest) portletRequest;
		}
		Object porletResponseCheck = portletRequest.getAttribute("javax.portlet.response");
		
		if(!(porletResponseCheck instanceof RenderResponse)){
			return;
		}
		
		RenderResponse portletResponse =  (RenderResponse)porletResponseCheck;
		JSFResponseWrapper response = new  JSFResponseWrapper(context, PortalUtil.getHttpServletResponse(portletResponse));
		
		RenderResponse renderResponse = null;

		if ((portletResponse != null)
				&& (portletResponse instanceof RenderResponse)) {

			renderResponse = (RenderResponse) portletResponse;
		}

		
		try {
			request.setAttribute(WebKeys.RENDER_PORTLET_RESOURCE, Boolean.TRUE);

			ServletContext servletContext = request.getServletContext();
			
			try {
				RuntimePortletUtil.processPortlet(servletContext, request, response, renderRequest, renderResponse, portletId, "", true);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Set<String> runtimePortletIds = (Set<String>)request.getAttribute(WebKeys.RUNTIME_PORTLET_IDS);

			if (runtimePortletIds == null) {
				runtimePortletIds = new HashSet<String>();
			}

			runtimePortletIds.add(portletId);
			response.close();
			request.setAttribute(WebKeys.RUNTIME_PORTLET_IDS, runtimePortletIds);
		}
		finally {
			request.removeAttribute(WebKeys.RENDER_PORTLET_RESOURCE);
		}
	}


	@Override
	public void encodeChildren(FacesContext context, UIComponent component)
			throws IOException {
		// TODO Auto-generated method stub
		super.encodeChildren(context, component);
	}


	@Override
	public boolean getRendersChildren() {
		// TODO Auto-generated method stub
		return super.getRendersChildren();
	}



	
	
	
	
	
	
}
