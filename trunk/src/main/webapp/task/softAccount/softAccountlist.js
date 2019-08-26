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
data["csadatamodel"] = {};
data.csadatamodel.refcode = "csa";
data.csadatamodel.searchurl = "/softAccount/tolistdatarefin";
data.csadatamodel.addediturl= "/softAccount/addedit";
data.csadatamodel.deleteurl = "/softAccount/delete";
data.csadatamodel.sorturl = "/softAccount/sort";
data.csadatamodel.batchediturl = "/softAccount/editbatch";
data.csadatamodel.parentcomid = "";
data.csadatamodel.searchformid = "csadataform";
data.csadatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.csadatamodel.tablecomid = "csatable";
data.csadatamodel.tableid = "csatable";
data.csadatamodel.addhtmlpath = "softAccountedit.html";
data.csadatamodel.edithtmlpath = "softAccountedit.html";
data.csadatamodel.viewhtmlpath = "softAccountedit.html";
data.csadatamodel.reloadtablelistdata = function() {
	loadtablelistdata("csa", {"pageNum":(data.csadatamodel.pageinfo.pageNum),"pageSize":(data.csadatamodel.pageinfo.pageSize)});
};
loadtablelistdata("csa",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("csa",{});
checklistform("csa");
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

