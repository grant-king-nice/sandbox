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
		
		columns.add(new GridColumn("FirstName", 90, "First Name", null));
		columns.add(new GridColumn("LastName", 90, "Last Name", null));
		columns.add(new GridColumn("City", 100, "City", null));
		columns.add(new GridColumn("Title", 50, "Title", null));
		columns.add(new GridColumn("BirthDate", 100, "Birth Date", "#= kendo.toString(BirthDate,\"dd MMMM yyyy\") #"));
		columns.add(new GridColumn("Age", 50, "Age", null));
		
		return columns;
	}

}