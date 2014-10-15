package com.dais.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dais.domain.Menu;
import com.dais.service.MenuService;

@Service("menuService")
@Transactional
public class MenuServiceImpl  extends BaseServiceImpl<Menu> implements MenuService{
	
/*	@Override
	public Menu find(Serializable id) {
		return super.find(id);
	}*/

}
