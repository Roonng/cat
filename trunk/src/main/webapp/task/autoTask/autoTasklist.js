var pageinfo;//分页数据对象
//全局数据对象
var data = {};
	//产品编码编辑控件初始化脚本
	function ptypetolistdata(param){
	baselist("/autoProduct/tolistdata", param, "ptypetolistdata", "ptypeList", "ptype", "code", "name", function() {
	try{
	if (data.catdatamodel && data.catdatamodel.editformid && data.catdatavo) {
		$("#"+data.catdatamodel.editformid).initForm(data.catdatavo);
	}
	$("#ptype").chosen({allow_single_deselect: true});
	if(data.catdatavo && data.catdatavo.ptype){
		if(data.catdatavo.ptype.indexOf(",") != -1){
			var valusstr = data.catdatavo.ptype.split(",");
			var valusstrview = data.catdatavo.ptyperefview.split(",");
			for(var i = 0 ; i < valusstr.length ; i ++){
				$("#ptype").append("<option value='"+valusstr[i]+"'>"+valusstrview[i]+"</option>");
			}
			$("#ptype").val(valusstr);
			$("#ptype").trigger("liszt:updated");
		}else{
			if(data.catdatavo && data.catdatavo.ptype){
				$("#ptype").append("<option select value='"+data.catdatavo.ptype+"'>"+data.catdatavo.ptyperefview+"</option>");
				$("#ptype").val(data.catdatavo.ptype);
				$("#ptype").trigger("liszt:updated");
			}
		}
	}
	}catch(e){console.log(e);}
});
	}
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
	if(data.catdatavo && data.catdatavo.csiuiid){
		$("#csiuiid").val(data.catdatavo.csiuiid);
		$("#csiuiid").trigger("liszt:updated");
	}
	}catch(e){console.log(e);}
});
	}
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
	if(data.catdatavo && data.catdatavo.cstuiid){
		$("#cstuiid").val(data.catdatavo.cstuiid);
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
$("#catsearchbutton").on('click', function() {
	loadtablelistdata("cat", {"pageNum":(data.catdatamodel.pageinfo.pageNum),"pageSize":(data.catdatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["catdatamodel"] = {};
data.catdatamodel.refcode = "cat";
data.catdatamodel.searchurl = "/autoTask/tolistdatarefin";
data.catdatamodel.addediturl= "/autoTask/addedit";
data.catdatamodel.deleteurl = "/autoTask/delete";
data.catdatamodel.sorturl = "/autoTask/sort";
data.catdatamodel.batchediturl = "/autoTask/editbatch";
data.catdatamodel.parentcomid = "";
data.catdatamodel.searchformid = "catdataform";
data.catdatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.catdatamodel.tablecomid = "cattable";
data.catdatamodel.tableid = "cattable";
data.catdatamodel.addhtmlpath = "autoTaskedit.html";
data.catdatamodel.edithtmlpath = "autoTaskedit.html";
data.catdatamodel.viewhtmlpath = "autoTaskedit.html";
data.catdatamodel.reloadtablelistdata = function() {
	loadtablelistdata("cat", {"pageNum":(data.catdatamodel.pageinfo.pageNum),"pageSize":(data.catdatamodel.pageinfo.pageSize)});
};
loadtablelistdata("cat",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("cat",{});
checklistform("cat");
}catch(e){console.log(e);}
	
			
			
									ptypetolistdata({});
			
			
									csiuiidtolistdata({});
			
			
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

