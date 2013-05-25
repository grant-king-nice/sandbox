package com.nice.liferay.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequireJS extends HttpServlet {

	private static final long serialVersionUID = -3995146258176757269L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String url = req.getRequestURI();
		
		url = url.replace("/delegate/requirejs/", "");
		resp.setContentType(getContentType(url));

		url = "META-INF/resources/"+url;
		if(!url.endsWith(".js") && !url.endsWith(".css") && !url.endsWith(".html")){
			url = url+".js";
		}
		
		InputStream is = getClass().getClassLoader().getResourceAsStream(url);

		stream(is, resp.getOutputStream());
		resp.flushBuffer();
		resp.getOutputStream().close();
	}

	
	private String getContentType(String url){
		if(url.endsWith(".html")){
			return "text/html";
		}else if(url.endsWith(".css")){
			return "text/css";
		}
		
		return "text/javascript";
	}
	
	
	public long stream(InputStream input, OutputStream output)
			throws IOException {
		ReadableByteChannel inputChannel = null;
		WritableByteChannel outputChannel = null;

		try {
			inputChannel = Channels.newChannel(input);
			outputChannel = Channels.newChannel(output);
			ByteBuffer buffer = ByteBuffer.allocate(10240);
			long size = 0;

			while (inputChannel.read(buffer) != -1) {
				buffer.flip();
				size += outputChannel.write(buffer);
				buffer.clear();
			}

			return size;
		} finally {
			if (inputChannel != null)
				try {
					inputChannel.close();
				} catch (IOException ignore) {
				}
		}
	}

}
