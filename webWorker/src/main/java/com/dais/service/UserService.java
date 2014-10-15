package com.dais.service;

import java.util.List;
import java.util.Map;

import com.dais.domain.User;


public interface UserService extends BaseService<User>{
	public List<User> listUser(Object[] obj);
}
