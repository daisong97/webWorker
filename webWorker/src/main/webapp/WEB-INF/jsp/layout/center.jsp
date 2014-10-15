<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="easyui-tabs"  id="centerTabs" data-options="fit:true,border:false,tools:'#tab-tools'">
	<script type="text/javascript">
		$('#centerTabs').tabs({
			onContextMenu:function(e, title,index){
				e.preventDefault();
				 $('#mm').menu('show', {
	                    left: e.pageX,
	                    top: e.pageY
	             });
			},
			onClose:function(title,index){
				
			},
			onAdd:function(title,index){
				
			}
		});
		$('#mmBtn').menu({
		    onClick:function(item){
		    	var tabs=$('#centerTabs');
		    	if(item.id=='flush'){
		    		var tab = tabs.tabs("getSelected");
		    		$(tab).panel('refresh');
		    	}else if(item.id=='closeAll'){
		    		var tab = tabs.tabs("getSelected");
		            if (tab){
		            	if($(tab).get(0).id=='home')
		            		return ;
		                var index = tabs.tabs('getTabIndex', tab);
		                tabs.tabs('close', index);
		            }
		    	}else if(item.id=='loginOut'){
		    		$.post("loginOut");
		    		location.reload() ;
		    	}
		    }
		});
	</script>
	<div title="首页" style="padding: 10px" id="home">
		<script type="text/javascript">
	
		</script>
	</div>
</div> 
<div id="tab-tools" style="padding:0px;border:1px solid #ddd;height: 22px;">
    <a href="#" class="easyui-menubutton" data-options="menu:'#mmBtn',iconCls:'icon-help'">Help</a>
</div>
   <div id="mmBtn" class="easyui-menu" style="width:120px;">
        <div id="flush" data-options="iconCls:'icon-reload'">刷新窗口</div>
        <div id="closeAll" data-options="iconCls:'icon-cancel'">关闭窗口</div>
        <div id="loginOut" data-options="iconCls:'icon-undo'">注销用户</div>
   </div>
    
</body>
</html>