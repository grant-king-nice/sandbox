package com.nice.liferay.portlet.userlist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("fakeUserDataService")
public class FakeUserDataServiceImpl implements FakeUserDataService{


	private static final long serialVersionUID = -273407384771083507L;

	public List<SampleUser> getData() {
		return getFakeUserList(200,0);
	}

	
	public List<SampleUser> getFakeUserList(int take, int skip){
		List<SampleUser> list = new ArrayList<SampleUser>();
		for(int count = skip; count<skip+take; count++){
			list.add(new SampleUser("first_"+count, "last_"+count, "city_"+count, "title_"+count ,count));
		}
		return list;
	}
	
	
}
