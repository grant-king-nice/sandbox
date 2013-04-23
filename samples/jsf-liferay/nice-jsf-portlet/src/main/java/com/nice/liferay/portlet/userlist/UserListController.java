package com.nice.liferay.portlet.userlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nice.liferay.security.SecurityService;

@Controller
@RequestMapping("/userlist")
public class UserListController {

	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody JSONPayload getUsers(HttpServletRequest request, @RequestParam("page") int page,  @RequestParam("pageSize") int pageSize,  @RequestParam("take") int take,  @RequestParam("skip") int skip) {
		
		
		if(!securityService.isUserLoggedIn(request)){
			return null;
		}
	
		return new JSONPayload(getFakeUserList(take, skip), 200);
	}
	
	private List<SampleUser> getFakeUserList(int take, int skip){
		List<SampleUser> list = new ArrayList<SampleUser>();
		for(int count = skip; count<skip+take; count++){
			list.add(new SampleUser("first_"+count, "last_"+count, "city_"+count, "title_"+count ,count));
		}
		return list;
	}
	
	
}
