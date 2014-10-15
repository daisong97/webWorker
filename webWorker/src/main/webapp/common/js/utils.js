/**
 * 添加面板。
 * @param title
 * @param href
 * @param icon
 */
window["dais"]={};
var dais=window["dais"];
dais.addTab = function(title, href,icon){
	var tt = $('#centerTabs');
	if (tt.tabs('exists', title)){//如果tab已经存在,则选中并刷新该tab    	
        tt.tabs('select', title);
	} else {
		var content ;
    	if (href){
    		content= '<iframe scrolling="no" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';
    	} else {
	    	content = '未实现';
    	}
    	tt.tabs('add',{
	    	title:title,
	    	closable:true,
	    	content:content,
	    	iconCls:icon||'icon-tab'
    	});
	}
};
/**
高性能缓存map key只不能为只能为string,number
**/
function CacheMap(){
	this.size=0;
	this.entrys={};
}
/**
压入map
**/
CacheMap.prototype.put = function(key,value){
	
	if(typeof(key)=="string"||typeof(key)=="number"){
		var v=eval("this.entrys.$"+key);
		if(!v){
			this.size++;
		}
		eval("this.entrys.$"+key+"=value");
	}else{
		throw Error("key值只能为String或是number类型");
	}
};
/**
获取值
**/
CacheMap.prototype.get = function(key){
	return eval("this.entrys.$"+key);
};
/**
获取map 大小
**/
CacheMap.prototype.getSize = function(){
	return this.size;
};
/**
移除
**/
CacheMap.prototype.remove = function(key){
	eval("delete this.entrys.$"+key);
	this.size--;
};
/**
遍历 map
**/
CacheMap.prototype.each = function(fun){
	var i=0;
	for(var ele in this.entrys){
		var fi = ele.substr(1,ele.length);
		eval("fun(i,{'key':fi,'value':this.entrys."+ele+"})");
		//fun.call(fun,{'key':fi,'value':this.entrys."+ele+"});
		i++;
	}
};
/**
清空map
**/
CacheMap.prototype.clear = function(fun){
	eval("delete this.entrys");
	this.entrys={};
	this.size=0;
};
