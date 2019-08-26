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
data["capdatamodel"] = {};
data.capdatamodel.refcode = "cap";
data.capdatamodel.searchurl = "/autoProduct/tolistdatarefin";
data.capdatamodel.addediturl= "/autoProduct/addedit";
data.capdatamodel.deleteurl = "/autoProduct/delete";
data.capdatamodel.sorturl = "/autoProduct/sort";
data.capdatamodel.batchediturl = "/autoProduct/editbatch";
data.capdatamodel.parentcomid = "";
data.capdatamodel.searchformid = "capdataform";
data.capdatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.capdatamodel.tablecomid = "captable";
data.capdatamodel.tableid = "captable";
data.capdatamodel.addhtmlpath = "autoProductedit.html";
data.capdatamodel.edithtmlpath = "autoProductedit.html";
data.capdatamodel.viewhtmlpath = "autoProductedit.html";
data.capdatamodel.reloadtablelistdata = function() {
	loadtablelistdata("cap", {"pageNum":(data.capdatamodel.pageinfo.pageNum),"pageSize":(data.capdatamodel.pageinfo.pageSize)});
};
loadtablelistdata("cap",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("cap",{});
checklistform("cap");
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

