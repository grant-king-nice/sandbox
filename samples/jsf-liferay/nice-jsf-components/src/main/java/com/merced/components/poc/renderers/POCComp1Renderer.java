package com.merced.components.poc.renderers;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@ResourceDependencies({
	@ResourceDependency(library = "js/poc", name = "kendo.web.min.js"),
	@ResourceDependency(library = "js/poc", name = "knockout-2.2.1.js"),
	@ResourceDependency(library = "js/poc", name = "knockout-kendo.min.js"),
	@ResourceDependency(library = "css/poc", name = "bootstrap.min.css"),
	@ResourceDependency(library = "css/poc", name = "bootstrap-responsive.min.css"),
	@ResourceDependency(library = "css/poc", name = "kendo.common.min.css"),
	@ResourceDependency(library = "css/poc", name = "kendo.default.min.css"),
	@ResourceDependency(library = "css/poc", name = "kendo.dataviz.min.css"),
	@ResourceDependency(library = "css/poc", name = "sunburst.css"),
	@ResourceDependency(library = "css/poc", name = "app.css")
	})
@FacesRenderer(componentFamily = "nice.liferay.portal", rendererType = "com.nice.Comp1Renderer")
public class POCComp1Renderer extends Renderer {

	static private String requireJSPath = "/delegate/requirejs/js/poc/components/com/ccih/example/component1/component";
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("div", null);
		writer.writeAttribute("id", "component1", null);
		writer.writeAttribute("style", "border:3px solid black", null);
		writer.endElement("div");
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("script", null);
		writer.write("require(['"+requireJSPath+"'], function(module1ref){");
		writer.write("var parentContainer1 = $(\"#component1\");");
		writer.write("var comp1 = new module1ref();");
		writer.write("comp1.initialize() ;");
		writer.write("comp1.activate(parentContainer1);");
		writer.write("});");
		writer.endElement("script");
	}
	
	
}
