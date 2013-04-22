package com.merced.components.grid;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily = "nice.liferay.portal", rendererType = "com.nice.GridRenderer")
public class GridRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		GridComponent gridComponent = (GridComponent)component;
		
		ResponseWriter writer = context.getResponseWriter();
		
		writer.startElement("div", null);
		writer.writeAttribute("id", "example", null);
		writer.writeAttribute("class", "k-content", null);
		
		
		writer.startElement("div", null);
		writer.writeAttribute("id", "clientsDb", null);
		
		writer.startElement("div", null);
		writer.writeAttribute("id", "grid", null);
		writer.writeAttribute("style", "height: 380px", null);
		
		
		writer.endElement("div");
		writer.endElement("div");
		
		writeScript(writer, gridComponent);
		
		writer.endElement("div");
		
	}


	private void writeScript(ResponseWriter writer, GridComponent component) throws IOException {
		writer.startElement("script", null);
		
		writer.write("$(document).ready(function() {");
		writer.write("$(\"#grid\").kendoGrid({");
		writer.write("dataSource: {");
		writer.write("data: createRandomData(50),");
		writer.write("pageSize: 10");
		writer.write("},");
		writer.write("groupable: "+component.getGroupable()+",");
		writer.write("sortable: "+component.getSortable()+",");
		writer.write("pageable: {");
		writer.write(" refresh: true,");
		writer.write(" pageSizes: true");
		writer.write("},");
		
		writer.write("columns: [");
		List<GridColumn> columns = component.getColumns();
		
		for(int count = 0; count< columns.size(); count++){
			if(count > 0){
				writer.write(",");
			}
			writer.write("{ field:\""+columns.get(count).getField()+"\",");
			writer.write(" width:\""+columns.get(count).getWidth()+"\", ");
			if(columns.get(count).getTemplate()!=null){
				writer.write(" template:'"+columns.get(count).getTemplate()+"', ");
			}
			writer.write(" title:\""+columns.get(count).getTitle()+"\"}");
		}
		
		writer.write("] }); });");
		writer.endElement("script");
	}
	
	
	
}
