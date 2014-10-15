package com.dais.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dais.common.utils.SecurityManagerUtils;
import com.dais.common.utils.TestUtils;
import com.dais.domain.Menu;
import com.dais.service.MenuService;
import com.dais.service.PermissionsService;
import com.dais.service.UserService;

@Controller
public class MenuController extends BaseController{
	@Autowired MenuService menuService;
	
	@Autowired SessionFactory factory;
	
	@Autowired 
	PermissionsService permissionsService; 
	
	@RequestMapping("loadBaseMenu")
	@ResponseBody
	public List<?> loadMenu(){
		List<Menu> list=menuService.findByHql("from Menu menu where menu.type=1 ", new Object[]{});
		if(SecurityManagerUtils.isAdminRole()){
			Menu p=new Menu();
			p.setText("权限设置");
			p.setId(999999);
			p.setType(1);
			
			Set<Menu> children=new HashSet<Menu>();
			Menu c=new Menu();
			c.setText("权限编辑");
			c.setId(999999);
			c.setType(1);
			c.setUrl("sys/permission.ftl");
			children.add(c);
			p.setChildren(children);
			list.add(p);
		}else{
			for(Menu menu:list){
				//menu.getPermissions().getCode()
			}
		}
		function();
		return list;
	}
	private void function() {
		try{
			Set<String> s=permissionsService.listPermissions("admin");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
