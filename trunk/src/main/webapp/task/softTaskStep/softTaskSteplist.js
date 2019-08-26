var pageinfo;//分页数据对象
//全局数据对象
var data = {};
	//业务名称编辑控件初始化脚本
	function cstuiidtolistdata(param){
	updatecom("/softTask/tolistdata",param,function(response){//树形数据下拉
	try{
	$("#cstuiid").empty();
	$("#cstuiid").append("<option value=''>请选择</option>");
	data.cstuiidList = response.data.list;
	var treedata = transData(response.data.list,"uiid","","child");
	$.each(treedata, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#cstuiid").append("<optgroup label=\"" + n["title"] + "\"></optgroup>");
			loudmoreoption(n,n.child,"cstuiid","uiid","title");
		}else{
			$("#cstuiid").append("<option value='" + n["uiid"] + "'>"+ getloudmoreoption(n,"title") + "</option>");
		}
	});
	$("#cstuiid").chosen({allow_single_deselect: true});
	if(data.cstsdatavo && data.cstsdatavo.cstuiid){
		$("#cstuiid").val(data.cstsdatavo.cstuiid);
		$("#cstuiid").trigger("liszt:updated");
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
$("#cstssearchbutton").on('click', function() {
	loadtablelistdata("csts", {"pageNum":(data.cstsdatamodel.pageinfo.pageNum),"pageSize":(data.cstsdatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["cstsdatamodel"] = {};
data.cstsdatamodel.refcode = "csts";
data.cstsdatamodel.searchurl = "/softTaskStep/tolistdatarefin";
data.cstsdatamodel.addediturl= "/softTaskStep/addedit";
data.cstsdatamodel.deleteurl = "/softTaskStep/delete";
data.cstsdatamodel.sorturl = "/softTaskStep/sort";
data.cstsdatamodel.batchediturl = "/softTaskStep/editbatch";
data.cstsdatamodel.parentcomid = "";
data.cstsdatamodel.searchformid = "cstsdataform";
data.cstsdatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.cstsdatamodel.tablecomid = "cststable";
data.cstsdatamodel.tableid = "cststable";
data.cstsdatamodel.addhtmlpath = "softTaskStepedit.html";
data.cstsdatamodel.edithtmlpath = "softTaskStepedit.html";
data.cstsdatamodel.viewhtmlpath = "softTaskStepedit.html";
data.cstsdatamodel.reloadtablelistdata = function() {
	loadtablelistdata("csts", {"pageNum":(data.cstsdatamodel.pageinfo.pageNum),"pageSize":(data.cstsdatamodel.pageinfo.pageSize)});
};
loadtablelistdata("csts",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("csts",{});
checklistform("csts");
}catch(e){console.log(e);}
	
			
			
									cstuiidtolistdata({});
	
	
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

