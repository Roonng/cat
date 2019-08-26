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
	if(data.caadatavo && data.caadatavo.csiuiid){
		$("#csiuiid").val(data.caadatavo.csiuiid);
		$("#csiuiid").trigger("liszt:updated");
	}
	}catch(e){console.log(e);}
});
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
	if(data.caadatavo && data.caadatavo.catuiid){
		$("#catuiid").val(data.caadatavo.catuiid);
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
$("#caasearchbutton").on('click', function() {
	loadtablelistdata("caa", {"pageNum":(data.caadatamodel.pageinfo.pageNum),"pageSize":(data.caadatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["caadatamodel"] = {};
data.caadatamodel.refcode = "caa";
data.caadatamodel.searchurl = "/autoArticle/tolistdatarefin";
data.caadatamodel.addediturl= "/autoArticle/addedit";
data.caadatamodel.deleteurl = "/autoArticle/delete";
data.caadatamodel.sorturl = "/autoArticle/sort";
data.caadatamodel.batchediturl = "/autoArticle/editbatch";
data.caadatamodel.parentcomid = "";
data.caadatamodel.searchformid = "caadataform";
data.caadatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.caadatamodel.tablecomid = "caatable";
data.caadatamodel.tableid = "caatable";
data.caadatamodel.addhtmlpath = "autoArticleedit.html";
data.caadatamodel.edithtmlpath = "autoArticleedit.html";
data.caadatamodel.viewhtmlpath = "autoArticleedit.html";
data.caadatamodel.reloadtablelistdata = function() {
	loadtablelistdata("caa", {"pageNum":(data.caadatamodel.pageinfo.pageNum),"pageSize":(data.caadatamodel.pageinfo.pageSize)});
};
loadtablelistdata("caa",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("caa",{});
checklistform("caa");
}catch(e){console.log(e);}
	
			
			
									csiuiidtolistdata({});
			
			
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

