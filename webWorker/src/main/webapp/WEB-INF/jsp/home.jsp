<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./../../common/jsp/common.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试项目</title>
</head>
<body>
    <div class="easyui-layout"  data-options="fit:true">
        <div data-options="region:'north',href:'layout/north'" style="height:50px"></div>
        <div data-options="region:'south',split:true,href:'layout/south'" style="height:20px;"></div>
        <div data-options="region:'east',split:true,collapsed:true" title="East" style="width:180px;">
            <ul class="easyui-tree" data-options="animate:true,dnd:true"></ul>
        </div>
        <div data-options="region:'west',split:true,href:'layout/west'" title="West" style="width:200px;"></div>
        <div data-options="region:'center',title:'Main Title',iconCls:'icon-ok',href:'layout/center'"></div>
    </div>
</body>
</html>