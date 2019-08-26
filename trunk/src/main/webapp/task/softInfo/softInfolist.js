var pageinfo;//分页数据对象
//全局数据对象
var data = {};

/**
 * 页面准备OK自动执行
 */
jQuery(document).ready(function() {
	if($("#alertinfo") && $("#alertinfo").html() != ""){$("#alertinfo").parent().show();}//业务提示不为空，显示业务提示信息面板
	
	
	
		//查询按钮编辑控件初始化脚本
		try{
$("#csisearchbutton").on('click', function() {
	loadtablelistdata("csi", {"pageNum":(data.csidatamodel.pageinfo.pageNum),"pageSize":(data.csidatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["csidatamodel"] = {};
data.csidatamodel.refcode = "csi";
data.csidatamodel.searchurl = "/softInfo/tolistdatarefin";
data.csidatamodel.addediturl= "/softInfo/addedit";
data.csidatamodel.deleteurl = "/softInfo/delete";
data.csidatamodel.sorturl = "/softInfo/sort";
data.csidatamodel.batchediturl = "/softInfo/editbatch";
data.csidatamodel.parentcomid = "";
data.csidatamodel.searchformid = "csidataform";
data.csidatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.csidatamodel.tablecomid = "csitable";
data.csidatamodel.tableid = "csitable";
data.csidatamodel.addhtmlpath = "softInfoedit.html";
data.csidatamodel.edithtmlpath = "softInfoedit.html";
data.csidatamodel.viewhtmlpath = "softInfoedit.html";
data.csidatamodel.reloadtablelistdata = function() {
	loadtablelistdata("csi", {"pageNum":(data.csidatamodel.pageinfo.pageNum),"pageSize":(data.csidatamodel.pageinfo.pageSize)});
};
loadtablelistdata("csi",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("csi",{});
checklistform("csi");
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

