package com.merced.components.grid;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily = "nice.liferay.portal", rendererType = "com.nice.GridRenderer", renderKitId="HTML_MOBILE")
public class GridMobileRenderer extends Renderer {

	
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("table", null);
		writer.writeAttribute("border", "1", null);
		writer.writeAttribute("style", "width:100%", null);
		GridComponent gridComponent = (GridComponent)component;
		List<GridColumn> columns = gridComponent.getColumns();
		
		for(GridColumn column:columns){
			writer.startElement("th", null);
			writer.write(column.getTitle());
			writer.endElement("th");
		}
		
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.endElement("table");
	}
	
	
}
