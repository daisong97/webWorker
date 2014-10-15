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
    <script type="text/javascript">
    	function dosubmit(){
    		fromId.submit();
    		//$('#fromId').get(0).submit();
    		//document.getElementById().submit();
	    	/* $('#fromId').form('submit', {
	    		    onSubmit: function(){
	    		        // do some check
	    		        // return false to prevent submit;
	    		    },
	    		    success:function(data){
	    		        alert(data)
	    		    }
	    	}); */
    	}
    </script>
</head>
<body>
<form id="fromId"  action="${ctx}/app/doLogin" method="post">
	<input name="username"/>
	<input name="password"/>
	<input type="button" value="t" onclick="dosubmit()"/>
</form>
</body>
</html>