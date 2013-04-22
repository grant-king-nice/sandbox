package com.merced.components.canvas;

public class CanvasItem {

	
	private String itemName;
	private String image;
	

	
	public CanvasItem(String itemName, String image) {
		super();
		this.itemName = itemName;
		this.image = image;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
