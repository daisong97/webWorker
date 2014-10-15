<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	 $("#mainMenu").accordion({
		onSelect:function(title,index){
			
		}
	});
	$.post("loadBaseMenu", function(data){
		for(var i=0;i<data.length;i++){
			if(data[i].type==1){
				var html="<ul class='easyui-tree' id ='tree_"+data[i].id+"' data-options=\"animate:true\"></ul>";
				var isSelected=data[i].state=='open'?true:false;
				var tree=$(html).tree({data:data[i].children});
				var text = data[i].text;
			/* 	var url =data[i].url;
				var iconCls=data[i].iconCls; */
				
				$("#mainMenu").accordion('add', {
		 			title: text,
		 			content: tree.tree({
		 				onClick: function(node){
		 					if(tree.tree('isLeaf', node.target)){
		 						dais.addTab(node.text,node.url,node.iconCls);
		 					}
		 				}
		 			}),
		 			selected: isSelected
		 		});	
			}
		}
	}); 
});
</script>
<div class="easyui-accordion" id="mainMenu" data-options="fit:true,border:false">
 	<!-- <div title="Title1xxx" style="padding: 0px;">
	</div>
	<div title="Title2" data-options="selected:true" style="padding: 10px;">
		content2</div>
	<div title="Title3" style="padding: 10px">content3</div>  -->
</div>
</body>