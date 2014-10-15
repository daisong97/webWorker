package com.dais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dais.domain.Tree;
import com.dais.service.TreeService;

@Controller
public class TreeController extends BaseController{
	/*@Autowired*/ TreeService service;
	
	@RequestMapping("loadTree/{treeId}")
	public List<Tree> loadTree(@PathVariable(value="treeId") String treeId){
		Integer id=Integer.valueOf(treeId);
		//service.findByHql("from Tree whre", params);
		return null;
	}
}
