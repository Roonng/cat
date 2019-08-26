var pageinfo;//分页数据对象
//全局数据对象
var data = {};
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
	if(data.caaldatavo && data.caaldatavo.catuiid){
		$("#catuiid").val(data.caaldatavo.catuiid);
		$("#catuiid").trigger("liszt:updated");
	}
	}catch(e){console.log(e);}
});
	}
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
	if(data.caaldatavo && data.caaldatavo.cuiuiid){
		$("#cuiuiid").val(data.caaldatavo.cuiuiid);
		$("#cuiuiid").trigger("liszt:updated");
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
$("#caalsearchbutton").on('click', function() {
	loadtablelistdata("caal", {"pageNum":(data.caaldatamodel.pageinfo.pageNum),"pageSize":(data.caaldatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["caaldatamodel"] = {};
data.caaldatamodel.refcode = "caal";
data.caaldatamodel.searchurl = "/autoAnswerLog/tolistdatarefin";
data.caaldatamodel.addediturl= "/autoAnswerLog/addedit";
data.caaldatamodel.deleteurl = "/autoAnswerLog/delete";
data.caaldatamodel.sorturl = "/autoAnswerLog/sort";
data.caaldatamodel.batchediturl = "/autoAnswerLog/editbatch";
data.caaldatamodel.parentcomid = "";
data.caaldatamodel.searchformid = "caaldataform";
data.caaldatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.caaldatamodel.tablecomid = "caaltable";
data.caaldatamodel.tableid = "caaltable";
data.caaldatamodel.addhtmlpath = "autoAnswerLogedit.html";
data.caaldatamodel.edithtmlpath = "autoAnswerLogedit.html";
data.caaldatamodel.viewhtmlpath = "autoAnswerLogedit.html";
data.caaldatamodel.reloadtablelistdata = function() {
	loadtablelistdata("caal", {"pageNum":(data.caaldatamodel.pageinfo.pageNum),"pageSize":(data.caaldatamodel.pageinfo.pageSize)});
};
loadtablelistdata("caal",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("caal",{});
checklistform("caal");
}catch(e){console.log(e);}
	
			
			
									catuiidtolistdata({});
			
			
									cuiuiidtolistdata({});
	
	
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

