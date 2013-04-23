package com.merced.components.grid.remotedata;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily = "nice.liferay.portal", rendererType = "com.nice.RemoteDataSourceRenderer")
public class RemoteDataSourceRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		RemoteDataSourceComponent remoteDataSourceComponent = (RemoteDataSourceComponent)component;
		
		writer.write("dataSource: {");
		writer.write("transport: { ");
		writer.write("read: { url: \""+remoteDataSourceComponent.getService()+"\", dataType: \"json\"}");
		writer.write("},");
		
		writer.write("schema: {");
		writer.write("    model: {");
		writer.write("        fields: {");
		writer.write("            firstName: { type: \"string\" },");
		writer.write("            lastName: { type: \"string\" },");
		writer.write("            city: { type: \"string\" },");
		writer.write("            title: { type: \"string\" },");
		writer.write("            age: { type: \"number\" }");
		writer.write("        }");
		writer.write("    },");
		writer.write(" data: \"data\",");
		writer.write(" total: \"total\"");
		writer.write("},");

		
		writer.write("pageSize: 10,");
		writer.write("serverPaging: "+remoteDataSourceComponent.getServerPaging()+",");
		writer.write("serverFiltering: false,");
		writer.write("serverSorting: false");

		writer.write("}");
		
	}

}

