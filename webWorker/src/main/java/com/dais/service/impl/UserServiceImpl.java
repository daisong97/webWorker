package com.dais.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dais.domain.User;
import com.dais.service.UserService;

@Service("userService")
public class UserServiceImpl  extends BaseServiceImpl<User> implements UserService{

	
	public List<User> listUser(Object[] obj) {
		return super.findByHql("from User where loginName=?", obj);
	}

}
