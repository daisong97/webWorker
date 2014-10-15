package com.dais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公用controller 负责所有模块的跳转。
 * @author dais
 *
 */
@Controller
public class CommonsController extends BaseController{
	@RequestMapping("{module}/{name}.ftl")
	public String loadThisPage(
			@PathVariable(value="module") String module,
			@PathVariable(value="name") String name){
		return module+"/"+name;
	}
}
