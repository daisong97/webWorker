<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>spring4+spring mvc+hibernate4</title>
    <link href="${ctx}/common/css/alogin.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/common/js/jquery-1.8.3.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${ctx}/common/js/jquery.easyui.min.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${ctx}/common/js/login.js" charset="UTF-8" type="text/javascript"></script>
     <script type="text/javascript">
	    $(function(){
	    	/* $.post("getRememberMeUserName", function(data){
	    		  alert("Data Loaded: " + data);
	    	});	 */ 
	    }); 
     </script>
    <%
		String isCaptchaDisplay=session.getAttribute("isCaptcha")==null?"none":"block";
	%>
</head>
<body>
    <form id="loginFrm" action="${ctx}/app/doLogin" method="post">
	    <div class="Main">
	        <ul>
	            <li class="top"></li>
	            <li class="top2"></li>
	            <li class="topA"></li>
	            <li class="topB">
		            <span>
		            	<img src="${ctx}/common/img/login/logo.gif" alt="" style="" />
		            </span>
	            </li>
	            <li class="topC"></li>
	            <li class="topD">
	                <ul class="login">
	                    <li>
	                    	<span class="left">用户名：</span> 
	                    	<span style="left">
	                        	<input id="username" name="username" type="text" maxlength="15" class="txt" />  
	                    	</span>
	                    </li>
	                    <li>
	                    	<span class="left">密 码：</span>
	                    	<span style="left">
	                       		<input id="password" name="password" type="password" maxlength="15" class="txt" />  
	                    	</span>
	                    </li>
	                   	 <li id="captcha" style="display: <%=isCaptchaDisplay %>;">
		                    <span class="left">验证码：</span>
		                    <span style="left">
		                    	<input id="captcha_text" name="captcha" type="text" maxlength="6" class="txtCode" />  
		                    </span>
		                    <span style="left">
		                       	<img src="../kaptcha.jpg" id = "captchaImg" alt="" style="vertical-align: middle;"/>
		                       	<img src="../common/img/arrow_rotate_clockwise.png" style="vertical-align: middle;" onclick="flushCaptcha();"/>
		                    </span>
	                    </li>
	                    
	                    <li>
	                    	<span class="left">记住我：</span>
	                        <input id="rememberMe" type="checkbox" checked="checked"/>
	                    </li>
	                    
	                </ul>
	            </li>
	            <li class="topE"></li>
	            <li class="middle_A"></li>
	            <li class="middle_B"></li>
	            <li class="middle_C">
	            <span class="btn">
	                <img alt="" id="doLgnBtn" src="${ctx}/common/img/login/btnlogin.gif" />
	            </span>
	            </li>
	            <li class="middle_D"></li>
	            <li class="bottom_A"></li>
	            <li class="bottom_B">
	            	dais copyright@
	            </li>
	        </ul>
	    </div>
    </form>
    <input type="hidden" id="isloginOut" value="false"/>
</body>
</html>
