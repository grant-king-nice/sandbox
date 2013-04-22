package com.merced.system.resourceresolver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextWrapper;

public class JarResourceContextFactoryFactory extends ExternalContextWrapper {

	private final ExternalContext wrapped;
	private static String RESOURCE_LOCATION = "META-INF/resources/";
	private List<String> knownNotInJarPaths = new ArrayList<String>();
	
	public JarResourceContextFactoryFactory(ExternalContext wrapped) {
		this.wrapped = wrapped;
	}
	
	@Override
	public ExternalContext getWrapped() {
		return wrapped;
	}

	@Override
	public URL getResource(String path) throws MalformedURLException {

		URL url = getWrapped().getResource(path);
		
		if(url == null){
			String modifiedPath = getResourceUrlPath(path);
			if(knownNotInJarPaths.contains(modifiedPath)){
				return null;
			}
			url = getClass().getClassLoader().getResource(modifiedPath);
			if(url == null){
				knownNotInJarPaths.add(modifiedPath);
			}
			return url;
		}else{
			return url;
		}
	}
	
	private String getResourceUrlPath(String rawPath){
		String modifiedPath = rawPath;
		if(modifiedPath.startsWith("/")){
			modifiedPath = modifiedPath.substring(1);
		}
		modifiedPath = RESOURCE_LOCATION + modifiedPath;
		return modifiedPath;
	}
	
	
}
