package com.merced.components.poc.renderers;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.render.FacesRenderer;

@ResourceDependencies({
	@ResourceDependency(library = "js/poc", name = "kendo.web.min.js"),
	@ResourceDependency(library = "js/poc", name = "knockout-2.2.1.js"),
	@ResourceDependency(library = "js/poc", name = "knockout-kendo.min.js")
	})
@FacesRenderer(componentFamily = "nice.liferay.portal", rendererType = "com.nice.Comp2Renderer")
public class POCComp2Renderer extends BaseRenderer {


	@Override
	public String getRequireJSPath() {
		return "/delegate/requirejs/js/poc/components/com/ccih/example/component2/component";
	}
	
	
	
	
}




