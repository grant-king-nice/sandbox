package com.nice.liferay.portlet.simpson;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.merced.components.canvas.CanvasItem;

@Component
@Scope("session")
public class SimpsonCanvasModel {

	
	private List<CanvasItem> items;

	@PostConstruct
	private void init(){
		items = new ArrayList<CanvasItem>();
		items.add(new CanvasItem("simp1", "simp1.png"));
		items.add(new CanvasItem("simp2", "simp2.png"));
		items.add(new CanvasItem("simp3", "simp3.png"));
		items.add(new CanvasItem("simp4", "simp4.png"));
		items.add(new CanvasItem("simp5", "simp5.png"));
		
	}
	
	
	public List<CanvasItem> getItems() {
		return items;
	}

	public void setItems(List<CanvasItem> items) {
		this.items = items;
	}
	
	
	
	
	
	
}
