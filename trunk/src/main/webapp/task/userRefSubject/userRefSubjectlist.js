var pageinfo;//分页数据对象
//全局数据对象
var data = {};
	//用户名称编辑控件初始化脚本
	function cuiuiidtolistdata(param){
	updatecom("/userInfo/tolistdata",param,function(response){//树形数据下拉
	try{
	$("#cuiuiid").empty();
	$("#cuiuiid").append("<option value=''>请选择</option>");
	data.cuiuiidList = response.data.list;
	var treedata = transData(response.data.list,"uiid","","child");
	$.each(treedata, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#cuiuiid").append("<optgroup label=\"" + n["name"] + "\"></optgroup>");
			loudmoreoption(n,n.child,"cuiuiid","uiid","name");
		}else{
			$("#cuiuiid").append("<option value='" + n["uiid"] + "'>"+ getloudmoreoption(n,"name") + "</option>");
		}
	});
	$("#cuiuiid").chosen({allow_single_deselect: true});
	if(data.cursdatavo && data.cursdatavo.cuiuiid){
		$("#cuiuiid").val(data.cursdatavo.cuiuiid);
		$("#cuiuiid").trigger("liszt:updated");
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
	if(data.cursdatavo && data.cursdatavo.catuiid){
		$("#catuiid").val(data.cursdatavo.catuiid);
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
$("#curssearchbutton").on('click', function() {
	loadtablelistdata("curs", {"pageNum":(data.cursdatamodel.pageinfo.pageNum),"pageSize":(data.cursdatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["cursdatamodel"] = {};
data.cursdatamodel.refcode = "curs";
data.cursdatamodel.searchurl = "/userRefSubject/tolistdatarefin";
data.cursdatamodel.addediturl= "/userRefSubject/addedit";
data.cursdatamodel.deleteurl = "/userRefSubject/delete";
data.cursdatamodel.sorturl = "/userRefSubject/sort";
data.cursdatamodel.batchediturl = "/userRefSubject/editbatch";
data.cursdatamodel.parentcomid = "";
data.cursdatamodel.searchformid = "cursdataform";
data.cursdatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.cursdatamodel.tablecomid = "curstable";
data.cursdatamodel.tableid = "curstable";
data.cursdatamodel.addhtmlpath = "userRefSubjectedit.html";
data.cursdatamodel.edithtmlpath = "userRefSubjectedit.html";
data.cursdatamodel.viewhtmlpath = "userRefSubjectedit.html";
data.cursdatamodel.reloadtablelistdata = function() {
	loadtablelistdata("curs", {"pageNum":(data.cursdatamodel.pageinfo.pageNum),"pageSize":(data.cursdatamodel.pageinfo.pageSize)});
};
loadtablelistdata("curs",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("curs",{});
checklistform("curs");
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

