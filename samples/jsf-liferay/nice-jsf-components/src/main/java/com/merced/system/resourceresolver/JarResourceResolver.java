package com.merced.system.resourceresolver;

import java.io.IOException;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;
import javax.faces.context.FacesContext;

public class JarResourceResolver extends ResourceHandlerWrapper {

	private ResourceHandler wrapped;

	public JarResourceResolver(ResourceHandler wrapped) {

		this.wrapped = wrapped;

	}

	@Override
	public ResourceHandler getWrapped() {

		return this.wrapped;

	}

	@Override
	public Resource createResource(String resourceName, String libraryName, String contentType) {
		return wrapped.createResource(resourceName, libraryName, contentType);
	}

	@Override
	public Resource createResource(String resourceName, String libraryName) {
		return wrapped.createResource(resourceName, libraryName);
	}

	@Override
	public Resource createResource(String resourceName) {
		return wrapped.createResource(resourceName);
	}

	@Override
	public void handleResourceRequest(FacesContext context) throws IOException {
		wrapped.handleResourceRequest(context);
	}

	
	

}