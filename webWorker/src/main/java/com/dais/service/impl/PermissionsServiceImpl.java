package com.dais.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dais.domain.Permissions;
import com.dais.service.PermissionsService;
import com.dais.service.UserService;

@Service("permissionsService")
public class PermissionsServiceImpl  extends BaseServiceImpl<Permissions> implements PermissionsService {
	@Autowired
	UserService userService;
	public Set<String> listPermissions(String loginName) {
		Set<String> pers=new HashSet<String>();
		List<Permissions> permissions=super.findByHql("from Permissions per where per in (select pi.permissionItem from PermissionsGroup pi where pi in (select user.permissionsGroup from User as user where user.loginName=?))", new Object[]{loginName});
		for(Permissions permissions2:permissions){
			pers.add(permissions2.getName());
		}
		return pers;
	}


}
