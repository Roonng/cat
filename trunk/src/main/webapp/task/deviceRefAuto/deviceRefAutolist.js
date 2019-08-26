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
data["cdradatamodel"] = {};
data.cdradatamodel.refcode = "cdra";
data.cdradatamodel.searchurl = "/deviceRefAuto/tolistdatarefin";
data.cdradatamodel.addediturl= "/deviceRefAuto/addedit";
data.cdradatamodel.deleteurl = "/deviceRefAuto/delete";
data.cdradatamodel.sorturl = "/deviceRefAuto/sort";
data.cdradatamodel.batchediturl = "/deviceRefAuto/editbatch";
data.cdradatamodel.parentcomid = "";
data.cdradatamodel.searchformid = "cdradataform";
data.cdradatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.cdradatamodel.tablecomid = "cdratable";
data.cdradatamodel.tableid = "cdratable";
data.cdradatamodel.addhtmlpath = "deviceRefAutoedit.html";
data.cdradatamodel.edithtmlpath = "deviceRefAutoedit.html";
data.cdradatamodel.viewhtmlpath = "deviceRefAutoedit.html";
data.cdradatamodel.reloadtablelistdata = function() {
	loadtablelistdata("cdra", {"pageNum":(data.cdradatamodel.pageinfo.pageNum),"pageSize":(data.cdradatamodel.pageinfo.pageSize)});
};
loadtablelistdata("cdra",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("cdra",{});
checklistform("cdra");
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

