package com.merced.components.tabs;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

import com.merced.components.RenderUtils;


@FacesRenderer(componentFamily = "nice.liferay.portal", rendererType = "com.nice.TabRenderer")
public class TabRenderer  extends Renderer {

	
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("div", null);
		writer.writeAttribute("class", "content", null);
		writer.writeAttribute("id",RenderUtils.getCleanComponentId(component.getId()) , null);
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.endElement("div");
	}


	
	
}
