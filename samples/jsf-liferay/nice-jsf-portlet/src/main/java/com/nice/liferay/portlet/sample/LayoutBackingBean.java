package com.nice.liferay.portlet.sample;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortletKeys;


@Service
@Scope("request")
public class LayoutBackingBean {
	
	private LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
	
	public void addPages(){
		
		System.out.println("this is hit");
//		long parent = addLayout("parentTest"+System.currentTimeMillis(), 11);
//		addChildren(parent, 5, true);
	}

	
	private void addChildren(long parent, int number, boolean addChildren){
		
		for(int count = 0; count<number; count++){
			long parent2 = addLayout("child_"+count+"_"+System.currentTimeMillis(), parent);
			if(addChildren){
				addChildren(parent2, 5, false);
			}
		}

		
	}
	
	
	
	private long addLayout(String name, long parent){
		

		ServiceContext serviceContext = new ServiceContext();

		Layout layout;
		try {
			layout = LayoutLocalServiceUtil.addLayout(
					liferayFacesContext.getUserId(), 10621, true,
					parent, name,
					StringPool.BLANK, StringPool.BLANK,
					LayoutConstants.TYPE_PORTLET, false, "/"+name,
					serviceContext);

		addResources(layout, PortletKeys.DOCKBAR);
return layout.getLayoutId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	protected void addResources(Layout layout, String portletId)
			throws Exception {

		String rootPortletId = PortletConstants.getRootPortletId(portletId);

		String portletPrimaryKey = PortletPermissionUtil.getPrimaryKey(
				layout.getPlid(), portletId);

		ResourceLocalServiceUtil.addResources(layout.getCompanyId(),
				layout.getGroupId(), 0, rootPortletId, portletPrimaryKey, true,
				true, true);
	}
	
}
