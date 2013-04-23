package com.merced.components.grid.clientdata;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily = "nice.liferay.portal", rendererType = "com.nice.ClientDataSourceRenderer")
public class ClientDataSourceRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		writer.write("dataSource: {");
		writer.write("data: createRandomData(50),");
		writer.write("pageSize: 10");
		writer.write("}");
		
		
	}

}
