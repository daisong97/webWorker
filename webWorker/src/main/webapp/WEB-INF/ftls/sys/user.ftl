<#include "../commons/common.ftl"/>
<div id="cc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'查询条件',split:true" style="height:100px;">
    	<table>
    		<tr>
    			<td></td>
    			<td></td>
    			<td></td>
    			<td></td>
    		</tr>
    	</table>
    </div>
    <div  data-options="region:'center'"  style="padding:0px;">
    	<table id="userGrid" class="easyui-datagrid" title="用户列表" data-options="rownumbers:true,singleSelect:true,fit:true,toolbar:toolbar,url:'listUsers'">
	        <thead>
	            <tr>
	                <th data-options="field:'id',width:80,checkbox:true"></th>
	                <th data-options="field:'name',width:100,align:'center'">姓名</th>
	                <th data-options="field:'loginName',width:80,align:'center'">登录名</th>
	                <th data-options="field:'password',width:80,align:'center'">密码</th>
	            </tr>
	        </thead>
   	 	</table>
	</div>
	 <script type="text/javascript">
        var toolbar = [{
            text:'新增',
            iconCls:'icon-add',
            handler:function(){
            	dais.openDialog("userDlg","userFrm");
            }
        },{
            text:'修改',
            iconCls:'icon-edit',
            handler:function(){
            	dais.openDialog("userDlg","userFrm","userGrid");
			}
        },'-',{
            text:'删除',
            iconCls:'icon-remove',
            handler:function(){alert('ok');
            	var a= [];
            	a['aaa']='aaaaaax';
            	dais.test(a);
            	
            	alert(a['aaa']);
            	//dais.show("标题","小心");
            	//dais.alert();
			}
        }];
      	$(function(){
      		 $("#userDlg").dialog({toolbar:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:function(){
                    	dais.submit("userFrm","userGrid");
                    }
                },'-',{
                    text:'关闭',
                    iconCls:'icon-no',
                    handler:function(){
                      	dais.openDialog("userDlg");
                    }
                }]});
      	});
    </script>
    
    <div id="userDlg" class="easyui-dialog" title="用户管理" style="width:600px;height:400px;padding:10px"
            data-options="closed:true">
        <form action="user.update" id="userFrm"  method="post">
	        <table>
	        	<tr>
	        		<td>用户名:</td>
	        		<td>
	        			<input id="name" name="name" class="easyui-validatebox" data-options="required:true">
	        			<input name="id" id="userId" type="hidden" />
	        		</td>
	        		
	        		<td>用户名:</td>
	        		<td>
	        			<input id="loginName" name="loginName" class="easyui-validatebox" data-options="required:true">
	        		</td>
	        	</tr>
	        	<tr>
	        		<td>密码:</td>
	        		<td colspan="2">
	        			<input id="password" type="password" name="password" class="easyui-validatebox" data-options="required:true">
	        		</td>
	        	</tr>
	        </table>
        </form>
    </div>
</div>