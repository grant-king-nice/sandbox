package com.merced.components.liferay.dynamic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class JSFResponseWrapper extends HttpServletResponseWrapper{


	PrintWriterWrapepr wrapper;
	ByteArrayOutputStream stream = new ByteArrayOutputStream();
	FacesContext context;
	
	public JSFResponseWrapper(FacesContext context, HttpServletResponse response) {
		super(response);
		this.context = context;
	}


	@Override
	public PrintWriter getWriter() throws IOException {
		
		if(wrapper == null){
			wrapper = new PrintWriterWrapepr(stream);
		}
		return wrapper;
	}
	
	public void close(){
		
		wrapper.close();
		
		ResponseWriter writer = context.getResponseWriter();
		try {
			writer.write(stream.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public ByteArrayOutputStream getStream() {
		
		return stream;
	}
	
	
	
}
