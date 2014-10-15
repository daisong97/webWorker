window["dais"];
dais.submit = function(frmId,gridId){
	$('#'+frmId).form('submit', {
	    onSubmit: function(){
	    	var isValid = $(this).form('validate');
			return isValid;
	    },
	    success:function(data){
	    	$(this).form("clear");
	    	$("#"+gridId).datagrid("reload");
	    }
	});
};
/**
 * arg0 对话框id
 * arg1 表单id
 * arg2 数据列表id
 * arg3 表单url
 */
dais.openDialog = function(){
	var dlg=$("#"+arguments[0]);
	var frm=null;
	var grid=null;
	var url=null;
	if(arguments.length>1&&arguments[1]!=null){
		frm=$("#"+arguments[1]);
	}
	if(arguments.length>2&&arguments[2]!=null){
		grid=$("#"+arguments[2]);
	}
	if(arguments.length>3&&arguments[3]!=null){
		url=arguments[3];
	}
	
	if(dlg.dialog("options").closed){
		dlg.dialog("open");
	}else{
		dlg.dialog("close");
	}
	if(frm!=null){
		frm.form("clear");
	}
	if(grid!=null){
		var select=grid.datagrid("getSelected");
		if(select!=null)
			frm.form('load',select);
	}
	if(url!=null){
		frm.attr("action",url);
	}
};

dais.test=function(){
	var args=arguments[0];
	alert(args['aaa']);
};
dais.show=function(title,msg){
	$.messager.show({
		title:title,
		msg:msg,
		timeout:5000,
		showType:'slide'
	});
};
dais.alert=function(title,msg,icon){
	if(!title)
		title="消息";
	if(!icon)
		icon="info";
	$.messager.alert(title,msg,icon);
};