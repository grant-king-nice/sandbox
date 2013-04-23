package com.nice.liferay.portlet.userlist;

import java.util.List;

import com.merced.components.grid.DataProvider;

public interface FakeUserDataService extends DataProvider<SampleUser>{

	
	List<SampleUser> getFakeUserList(int take, int skip);
	
}
