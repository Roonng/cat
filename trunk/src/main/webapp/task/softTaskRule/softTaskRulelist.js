var pageinfo;//分页数据对象
//全局数据对象
var data = {};
	//步骤标题编辑控件初始化脚本
	function cstsuiidtolistdata(param){
	updatecom("/softTaskStep/tolistdata",param,function(response){//树形数据下拉
	try{
	$("#cstsuiid").empty();
	$("#cstsuiid").append("<option value=''>请选择</option>");
	data.cstsuiidList = response.data.list;
	var treedata = transData(response.data.list,"uiid","","child");
	$.each(treedata, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#cstsuiid").append("<optgroup label=\"" + n["title"] + "\"></optgroup>");
			loudmoreoption(n,n.child,"cstsuiid","uiid","title");
		}else{
			$("#cstsuiid").append("<option value='" + n["uiid"] + "'>"+ getloudmoreoption(n,"title") + "</option>");
		}
	});
	$("#cstsuiid").chosen({allow_single_deselect: true});
	if(data.cstrdatavo && data.cstrdatavo.cstsuiid){
		$("#cstsuiid").val(data.cstrdatavo.cstsuiid);
		$("#cstsuiid").trigger("liszt:updated");
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
$("#cstrsearchbutton").on('click', function() {
	loadtablelistdata("cstr", {"pageNum":(data.cstrdatamodel.pageinfo.pageNum),"pageSize":(data.cstrdatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["cstrdatamodel"] = {};
data.cstrdatamodel.refcode = "cstr";
data.cstrdatamodel.searchurl = "/softTaskRule/tolistdatarefin";
data.cstrdatamodel.addediturl= "/softTaskRule/addedit";
data.cstrdatamodel.deleteurl = "/softTaskRule/delete";
data.cstrdatamodel.sorturl = "/softTaskRule/sort";
data.cstrdatamodel.batchediturl = "/softTaskRule/editbatch";
data.cstrdatamodel.parentcomid = "";
data.cstrdatamodel.searchformid = "cstrdataform";
data.cstrdatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.cstrdatamodel.tablecomid = "cstrtable";
data.cstrdatamodel.tableid = "cstrtable";
data.cstrdatamodel.addhtmlpath = "softTaskRuleedit.html";
data.cstrdatamodel.edithtmlpath = "softTaskRuleedit.html";
data.cstrdatamodel.viewhtmlpath = "softTaskRuleedit.html";
data.cstrdatamodel.reloadtablelistdata = function() {
	loadtablelistdata("cstr", {"pageNum":(data.cstrdatamodel.pageinfo.pageNum),"pageSize":(data.cstrdatamodel.pageinfo.pageSize)});
};
loadtablelistdata("cstr",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("cstr",{});
checklistform("cstr");
}catch(e){console.log(e);}
	
			
			
									cstsuiidtolistdata({});
	
	
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

