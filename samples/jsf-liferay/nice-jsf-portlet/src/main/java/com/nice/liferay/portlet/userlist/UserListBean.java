package com.nice.liferay.portlet.userlist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.merced.components.grid.GridColumn;

@Component
@Scope("session")
public class UserListBean {

	public List<GridColumn> getColumns() {

		List<GridColumn> columns = new ArrayList<GridColumn>();
		
		columns.add(new GridColumn("firstName", 90, "First Name", null, "string"));
		columns.add(new GridColumn("lastName", 90, "Last Name", null, "string"));
		columns.add(new GridColumn("city", 100, "City", null, "string"));
		columns.add(new GridColumn("title", 50, "Title", null, "string"));
		//columns.add(new GridColumn("BirthDate", 100, "Birth Date", "#= kendo.toString(BirthDate,\"dd MMMM yyyy\") #"));
		columns.add(new GridColumn("age", 50, "Age", null, "number"));
		
		return columns;
	}

}