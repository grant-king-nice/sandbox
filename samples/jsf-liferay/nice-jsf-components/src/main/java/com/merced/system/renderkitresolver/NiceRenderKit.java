package com.merced.system.renderkitresolver;

import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.render.ClientBehaviorRenderer;
import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitFactory;
import javax.faces.render.Renderer;

import com.sun.faces.renderkit.RenderKitImpl;

public class NiceRenderKit extends RenderKitImpl {
	private RenderKit wrapped;

	public Renderer getRenderer(String family, String rendererType) {
		Renderer renderer = super.getRenderer(family, rendererType);
		if (renderer != null) {
			return renderer;
		}
		return getWrapped().getRenderer(family, rendererType);
	}

	public ClientBehaviorRenderer getClientBehaviorRenderer(String behaviorRendererType) {
		return getWrapped().getClientBehaviorRenderer(behaviorRendererType);
	}

	private RenderKit getWrapped() {
		if (wrapped == null) {
			RenderKitFactory factory = (RenderKitFactory) FactoryFinder.getFactory(FactoryFinder.RENDER_KIT_FACTORY);
			wrapped = factory.getRenderKit(FacesContext.getCurrentInstance(), "HTML_BASIC");
		}
		return wrapped;
	}
}
