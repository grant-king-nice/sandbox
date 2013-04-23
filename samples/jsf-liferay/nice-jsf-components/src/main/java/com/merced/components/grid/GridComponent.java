package com.merced.components.grid;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;



@FacesComponent(value = "nice.GridComponent")
public class GridComponent extends UIComponentBase implements Serializable {

	private static final long serialVersionUID = -4242208929894578708L;

	enum PropertyKeys {
		columns, groupable, sortable;
	}

	@Override
	public String getFamily() {
		return "nice.liferay.portal";
	}

	@SuppressWarnings("unchecked")
	public List<GridColumn> getColumns() {
		 return (List<GridColumn>) getStateHelper().eval(PropertyKeys.columns, null);
	}

	public void setColumns(List<GridColumn> columns) {
		getStateHelper().put(PropertyKeys.columns, columns);
	}

	public Boolean getGroupable() {
		return (Boolean) getStateHelper().eval(PropertyKeys.groupable, true);
	}

	public void setGroupable(Boolean groupable) {
		getStateHelper().put(PropertyKeys.groupable, groupable);
	}

	public Boolean getSortable() {
		return (Boolean) getStateHelper().eval(PropertyKeys.sortable, true);
	}

	public void setSortable(Boolean sortable) {
		getStateHelper().put(PropertyKeys.sortable, sortable);
	}

}
