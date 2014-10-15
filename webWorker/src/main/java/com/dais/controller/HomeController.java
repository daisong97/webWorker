package com.dais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends BaseController {
	/**
	 * 主界面
	 * @return
	 */
	@RequestMapping("home")
	public String home(){
		return "home";
	}
	/**
	 * 布局
	 * @param direction
	 * @return
	 */
	@RequestMapping("layout/{direction}")
	public String layout(@PathVariable String direction){
		return "/layout/"+direction;
	}
}
