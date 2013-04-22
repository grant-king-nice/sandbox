package com.merced.system.resourceresolver;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextFactory;

public class JarResourceApplicationFactory extends ExternalContextFactory {
 
    private ExternalContextFactory parent;

    public JarResourceApplicationFactory(ExternalContextFactory parent) {
        this.parent = parent;
    }


    @Override
    public ExternalContextFactory getWrapped() {
         return parent;
    }

	@Override
	public ExternalContext getExternalContext(Object context, Object request, Object response) throws FacesException {
		 return new JarResourceContextFactoryFactory(getWrapped().getExternalContext(context, request, response));
	}

}
