package com.dais.controller;

import java.awt.Menu;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dais.domain.Tree;
import com.dais.service.TreeService;

@Controller
public class TestController extends BaseController{
	/*@Autowired*/ TreeService treeService;
	
	@RequestMapping("test")
//	@ResponseBody
	public String find(){
	/*	Menu u=menuService.find(new Integer(1));
		System.out.println(u.getParent().getMenuName());
		System.out.println(u.getMenuName());*/
		/*List<Tree> list=treeService.findByHql("from Tree where id=?", new Object[]{1});
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		for(Tree menu: list){
			//System.out.println(menu.getMenuName()+" "+menu.getChilds().size());
		}*/
		return "";
	}
}
