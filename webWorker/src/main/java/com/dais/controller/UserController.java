package com.dais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dais.common.app.Constants;
import com.dais.domain.User;
import com.dais.ext.AcceptedParam;
import com.dais.ext.Msg;
import com.dais.ext.Pageable;
import com.dais.service.UserService;

/**
 * 用户controller
 * @author dais
 *
 */
@Controller
public class UserController extends BaseController{
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@ResponseBody
	@RequestMapping("sys/listUsers")
	public Pageable listUser(AcceptedParam acceptedParam){
		return userService.paging("from User", acceptedParam, null);
	}
	@ResponseBody
	@RequestMapping("sys/user.save")
	public Msg saveUser(User user){
		Msg msg=new Msg();
		try {
			userService.save(user);
			msg.setMsgInfo("保存成功!");
			msg.setStatus(Constants.STATUS_SUCESS);
		} catch (Exception e) {
			msg.setStatus(Constants.STATUS_FAIL);
			msg.setMsgInfo("保存失败!");
			throw new RuntimeException(e);
		}
		
		return msg;
	}
	@ResponseBody
	@RequestMapping("sys/user.update")
	public Msg updateUser(User user){
		Msg msg=new Msg();
		try {
			userService.update(user);
			msg.setMsgInfo("修改成功!");
			msg.setStatus(Constants.STATUS_SUCESS);
		} catch (Exception e) {
			msg.setStatus(Constants.STATUS_FAIL);
			msg.setMsgInfo("修改失败!");
			throw new RuntimeException(e);
		}
		
		return msg;
	}
	@ResponseBody
	@RequestMapping("sys/user.delete")
	public Msg deleteUser(Integer [] ids){
		Msg msg=new Msg();
		try {
			userService.delete(ids);
			msg.setMsgInfo("删除成功!");
			msg.setStatus(Constants.STATUS_SUCESS);
		} catch (Exception e) {
			msg.setStatus(Constants.STATUS_FAIL);
			msg.setMsgInfo("删除失败!");
			throw new RuntimeException(e);
		}
		
		return msg;
	}
}
