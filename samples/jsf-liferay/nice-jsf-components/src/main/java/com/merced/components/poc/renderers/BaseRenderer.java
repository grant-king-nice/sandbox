package com.merced.components.poc.renderers;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

abstract public class BaseRenderer extends Renderer {

	
	public abstract String getRequireJSPath();
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("div", null);
		writer.writeAttribute("id", component.getId(), null);
		writer.writeAttribute("style", "border:3px solid black", null);
		writer.endElement("div");
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("script", null);
		writer.write("require(['"+getRequireJSPath()+"'], function(module1ref){");
		writer.write("var parentContainer2 = $(\"#"+component.getId()+"\");");
		writer.write("var comp2 = new module1ref();");
		writer.write("comp2.initialize() ;");
		writer.write("comp2.activate(parentContainer2);");
		writer.write("});");
		writer.endElement("script");
	}
	
	
}
