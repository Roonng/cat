var pageinfo;//分页数据对象
//全局数据对象
var data = {};
	//软件名称编辑控件初始化脚本
	function csiuiidtolistdata(param){
	updatecom("/softInfo/tolistdata",param,function(response){//树形数据下拉
	try{
	$("#csiuiid").empty();
	$("#csiuiid").append("<option value=''>请选择</option>");
	data.csiuiidList = response.data.list;
	var treedata = transData(response.data.list,"uiid","","child");
	$.each(treedata, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#csiuiid").append("<optgroup label=\"" + n["title"] + "\"></optgroup>");
			loudmoreoption(n,n.child,"csiuiid","uiid","title");
		}else{
			$("#csiuiid").append("<option value='" + n["uiid"] + "'>"+ getloudmoreoption(n,"title") + "</option>");
		}
	});
	$("#csiuiid").chosen({allow_single_deselect: true});
	if(data.cstdatavo && data.cstdatavo.csiuiid){
		$("#csiuiid").val(data.cstdatavo.csiuiid);
		$("#csiuiid").trigger("liszt:updated");
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
$("#cstsearchbutton").on('click', function() {
	loadtablelistdata("cst", {"pageNum":(data.cstdatamodel.pageinfo.pageNum),"pageSize":(data.cstdatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["cstdatamodel"] = {};
data.cstdatamodel.refcode = "cst";
data.cstdatamodel.searchurl = "/softTask/tolistdatarefin";
data.cstdatamodel.addediturl= "/softTask/addedit";
data.cstdatamodel.deleteurl = "/softTask/delete";
data.cstdatamodel.sorturl = "/softTask/sort";
data.cstdatamodel.batchediturl = "/softTask/editbatch";
data.cstdatamodel.parentcomid = "";
data.cstdatamodel.searchformid = "cstdataform";
data.cstdatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.cstdatamodel.tablecomid = "csttable";
data.cstdatamodel.tableid = "csttable";
data.cstdatamodel.addhtmlpath = "softTaskedit.html";
data.cstdatamodel.edithtmlpath = "softTaskedit.html";
data.cstdatamodel.viewhtmlpath = "softTaskedit.html";
data.cstdatamodel.reloadtablelistdata = function() {
	loadtablelistdata("cst", {"pageNum":(data.cstdatamodel.pageinfo.pageNum),"pageSize":(data.cstdatamodel.pageinfo.pageSize)});
};
loadtablelistdata("cst",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("cst",{});
checklistform("cst");
}catch(e){console.log(e);}
	
			
			
									csiuiidtolistdata({});
	
	
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

