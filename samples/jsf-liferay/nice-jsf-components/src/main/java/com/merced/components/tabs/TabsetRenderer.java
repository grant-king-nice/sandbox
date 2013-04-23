package com.merced.components.tabs;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@ResourceDependencies({
	@ResourceDependency(library = "js", name = "jquery.tabify.js"),
	@ResourceDependency(library = "css", name = "tabify.css")
	})
@FacesRenderer(componentFamily = "nice.liferay.portal", rendererType = "com.nice.TabsetRenderer")
public class TabsetRenderer  extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("div", null);
		writer.writeAttribute("id", "tabs", null);
		writer.startElement("ul", null);
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.endElement("ul");
		writer.endElement("div");
	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("ul", null);
		writer.writeAttribute("id", "menu", null);
		if (component.getChildCount() > 0) {
        	Iterator<UIComponent> kids = component.getChildren().iterator();
        	int count = 0;
        	while (kids.hasNext()) {
        		
        	    UIComponent kid = kids.next();
        	    if(kid instanceof TabComponent){
        	    	writer.startElement("li", null);
        	    	if(count == 0){
        	    		writer.writeAttribute("class", "active", null);
        	    	}
        	    	writer.startElement("a", null);
        	    	writer.writeAttribute("href", "#"+kid.getId(), null);
        	    	writer.write(((TabComponent)kid).getHeader());
        	    	writer.endElement("a");
        	    	writer.endElement("li");
        	    	count++;
        	    }
        	}
        }
		writer.endElement("ul");
		
		
		super.encodeChildren(context, component);
		
		writer.startElement("script", null);
		writer.write("$(document).ready(function () {");
		writer.write("$('#menu').tabify();");
		writer.write("});");
		writer.endElement("script");
	}

	@Override
	public boolean getRendersChildren() {
		return true;
	}

	
	
	
	
}
