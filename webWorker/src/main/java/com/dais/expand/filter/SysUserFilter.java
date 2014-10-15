package com.dais.expand.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.dais.common.app.Constants;
import com.dais.service.UserService;

public class SysUserFilter extends PathMatchingFilter {
	public SysUserFilter() {
		System.out.println("初始化userfilter.....");
	}
	@Autowired
    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

/*        String username = (String)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, userService.findByUsername(username));*/
        return true;
    }
}
