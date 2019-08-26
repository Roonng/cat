var pageinfo;//分页数据对象
//全局数据对象
var data = {};

/**
 * 页面准备OK自动执行
 */
jQuery(document).ready(function() {
	if($("#alertinfo") && $("#alertinfo").html() != ""){$("#alertinfo").parent().show();}//业务提示不为空，显示业务提示信息面板
	
	
	
		//列表数据表格控件编辑控件初始化脚本
		try{
data["cmldatamodel"] = {};
data.cmldatamodel.refcode = "cml";
data.cmldatamodel.searchurl = "/manageLun/tolistdatarefin";
data.cmldatamodel.addediturl= "/manageLun/addedit";
data.cmldatamodel.deleteurl = "/manageLun/delete";
data.cmldatamodel.sorturl = "/manageLun/sort";
data.cmldatamodel.batchediturl = "/manageLun/editbatch";
data.cmldatamodel.parentcomid = "";
data.cmldatamodel.searchformid = "cmldataform";
data.cmldatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.cmldatamodel.tablecomid = "cmltable";
data.cmldatamodel.tableid = "cmltable";
data.cmldatamodel.addhtmlpath = "manageLunedit.html";
data.cmldatamodel.edithtmlpath = "manageLunedit.html";
data.cmldatamodel.viewhtmlpath = "manageLunedit.html";
data.cmldatamodel.reloadtablelistdata = function() {
	loadtablelistdata("cml", {"pageNum":(data.cmldatamodel.pageinfo.pageNum),"pageSize":(data.cmldatamodel.pageinfo.pageSize)});
};
loadtablelistdata("cml",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("cml",{});
checklistform("cml");
}catch(e){console.log(e);}
	
	
	
});
//递归分级获取分类数据
function loudmoreoption(current,childs,inputcomid,columnid,columntitle){
	$.each(childs, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#"+inputcomid).append("<optgroup label=\"" + getloudmoreoption(n,columntitle) + "\"></optgroup>");
			loudmoreoption(n,n.child,inputcomid);
		}else{
			$("#"+inputcomid).append("<option value='" + n[columnid] + "'>" + getloudmoreoption(n,columntitle) + "</option>");
		}
	});
}
function getloudmoreoption(n,showtitle){
	if(showtitle.indexOf(",") != -1){
		var strtemp = showtitle.split(",");
		var strtitle = "";
		$.each(strtemp,
				function(s, z) {
					if(strtitle != ""){strtitle+=",";}
					strtitle += n[z];
				});
		return strtitle;
	}else{
		return n[showtitle];
	}
}

