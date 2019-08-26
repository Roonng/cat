var pageinfo;//分页数据对象
//全局数据对象
var data = {};
	//用户名称编辑控件初始化脚本
	function cuiuiidtolistdata(param){
	data.cuiuiidselect2 = initsourcecode_select2("cuiuiid","用户名称","/userInfo/tolistdataor","uiid","name");
	}
	//主题名称编辑控件初始化脚本
	function catuiidtolistdata(param){
	updatecom("/autoTask/tolistdata",param,function(response){//树形数据下拉
	try{
	$("#catuiid").empty();
	$("#catuiid").append("<option value=''>请选择</option>");
	data.catuiidList = response.data.list;
	var treedata = transData(response.data.list,"uiid","","child");
	$.each(treedata, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#catuiid").append("<optgroup label=\"" + n["title"] + "\"></optgroup>");
			loudmoreoption(n,n.child,"catuiid","uiid","title");
		}else{
			$("#catuiid").append("<option value='" + n["uiid"] + "'>"+ getloudmoreoption(n,"title") + "</option>");
		}
	});
	$("#catuiid").chosen({allow_single_deselect: true});
	if(data.ctrldatavo && data.ctrldatavo.catuiid){
		$("#catuiid").val(data.ctrldatavo.catuiid);
		$("#catuiid").trigger("liszt:updated");
	}
	}catch(e){console.log(e);}
});
	}

/**
 * 页面准备OK自动执行
 */
jQuery(document).ready(function() {
	if($("#alertinfo") && $("#alertinfo").html() != ""){$("#alertinfo").parent().show();}//业务提示不为空，显示业务提示信息面板
	
	
	
		//查询按钮编辑控件初始化脚本
		try{
$("#ctrlsearchbutton").on('click', function() {
	loadtablelistdata("ctrl", {"pageNum":(data.ctrldatamodel.pageinfo.pageNum),"pageSize":(data.ctrldatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["ctrldatamodel"] = {};
data.ctrldatamodel.refcode = "ctrl";
data.ctrldatamodel.searchurl = "/taskRunLog/tolistdatarefin";
data.ctrldatamodel.addediturl= "/taskRunLog/addedit";
data.ctrldatamodel.deleteurl = "/taskRunLog/delete";
data.ctrldatamodel.sorturl = "/taskRunLog/sort";
data.ctrldatamodel.batchediturl = "/taskRunLog/editbatch";
data.ctrldatamodel.parentcomid = "";
data.ctrldatamodel.searchformid = "ctrldataform";
data.ctrldatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.ctrldatamodel.tablecomid = "ctrltable";
data.ctrldatamodel.tableid = "ctrltable";
data.ctrldatamodel.addhtmlpath = "taskRunLogedit.html";
data.ctrldatamodel.edithtmlpath = "taskRunLogedit.html";
data.ctrldatamodel.viewhtmlpath = "taskRunLogedit.html";
data.ctrldatamodel.reloadtablelistdata = function() {
	loadtablelistdata("ctrl", {"pageNum":(data.ctrldatamodel.pageinfo.pageNum),"pageSize":(data.ctrldatamodel.pageinfo.pageSize)});
};
loadtablelistdata("ctrl",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("ctrl",{});
checklistform("ctrl");
}catch(e){console.log(e);}
	
			
			
									cuiuiidtolistdata({});
			
			
									catuiidtolistdata({});
	
	
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

