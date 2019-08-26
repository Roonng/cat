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
data["cdidatamodel"] = {};
data.cdidatamodel.refcode = "cdi";
data.cdidatamodel.searchurl = "/deviceInfo/tolistdatarefin";
data.cdidatamodel.addediturl= "/deviceInfo/addedit";
data.cdidatamodel.deleteurl = "/deviceInfo/delete";
data.cdidatamodel.sorturl = "/deviceInfo/sort";
data.cdidatamodel.batchediturl = "/deviceInfo/editbatch";
data.cdidatamodel.parentcomid = "";
data.cdidatamodel.searchformid = "cdidataform";
data.cdidatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.cdidatamodel.tablecomid = "cditable";
data.cdidatamodel.tableid = "cditable";
data.cdidatamodel.addhtmlpath = "deviceInfoedit.html";
data.cdidatamodel.edithtmlpath = "deviceInfoedit.html";
data.cdidatamodel.viewhtmlpath = "deviceInfoedit.html";
data.cdidatamodel.reloadtablelistdata = function() {
	loadtablelistdata("cdi", {"pageNum":(data.cdidatamodel.pageinfo.pageNum),"pageSize":(data.cdidatamodel.pageinfo.pageSize)});
};
loadtablelistdata("cdi",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("cdi",{});
checklistform("cdi");
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

