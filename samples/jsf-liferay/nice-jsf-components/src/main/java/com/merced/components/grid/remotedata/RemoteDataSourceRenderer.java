package com.merced.components.grid.remotedata;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

import com.merced.components.grid.GridColumn;
import com.merced.components.grid.GridComponent;

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
		renderFields(context, remoteDataSourceComponent);
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

	
	private void renderFields(FacesContext context, RemoteDataSourceComponent remoteDataSourceComponent) throws IOException{
		ResponseWriter writer = context.getResponseWriter();
		GridComponent gridComponent = (GridComponent)remoteDataSourceComponent.getParent();
		List<GridColumn> columns = gridComponent.getColumns();
		
		writer.write("        fields: {");
		for(int count  =0; count<columns.size(); count++){
			if(count>0){
				writer.write(",");
			}
			writer.write(columns.get(count).getField()+": { type: \""+columns.get(count).getType()+"\" }");
		}
		writer.write("        }");
	}
	
	
}

