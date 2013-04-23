package com.merced.components.grid.remotedata;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

import org.apache.commons.beanutils.BeanUtils;

import com.merced.components.grid.GridColumn;
import com.merced.components.grid.GridComponent;

@FacesRenderer(componentFamily = "nice.liferay.portal", rendererType = "com.nice.RemoteDataSourceRenderer", renderKitId="HTML_MOBILE")
public class RemoteDataSourceMobileRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		RemoteDataSourceComponent remoteDataSourceComponent = (RemoteDataSourceComponent)component;
		
		List<?> data = remoteDataSourceComponent.getFallback().getData();
		GridComponent gridComponent = (GridComponent)remoteDataSourceComponent.getParent();
		List<GridColumn> columns = gridComponent.getColumns();
		
		for(Object current:data){
			writer.startElement("tr", null);
	
			for(GridColumn column:columns){
				writer.startElement("td", null);
				writer.write(getColumnValue(current, column.getField()));
				writer.endElement("td");
			}
			
			writer.endElement("tr");
		}

	}

	private String getColumnValue(Object obj, String field){
		
		try {
			Object value = BeanUtils.getProperty(obj, field);
			if(value !=null){
				return value.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	
}

