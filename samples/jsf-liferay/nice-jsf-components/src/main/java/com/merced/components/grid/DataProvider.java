package com.merced.components.grid;

import java.io.Serializable;
import java.util.List;

public interface DataProvider <T> extends Serializable{

	
	public List<T> getData();
	
	
}
