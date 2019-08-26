var pageinfo;//分页数据对象
//全局数据对象
var data = {};
	//产品名称编辑控件初始化脚本
	function capuiidtolistdata(param){
	baselist("/autoProduct/tolistdata",param,
"capuiidtolistdata","capuiidList","capuiid","uiid","name,code",function(){
if(data.caprdatamodel && data.caprdatamodel.editformid && data.caprdatavo){
	$("#"+data.caprdatamodel.editformid).initForm(data.caprdatavo);
}
});
	}

/**
 * 页面准备OK自动执行
 */
jQuery(document).ready(function() {
	if($("#alertinfo") && $("#alertinfo").html() != ""){$("#alertinfo").parent().show();}//业务提示不为空，显示业务提示信息面板
	
	
	
		//查询按钮编辑控件初始化脚本
		try{
$("#caprsearchbutton").on('click', function() {
	loadtablelistdata("capr", {"pageNum":(data.caprdatamodel.pageinfo.pageNum),"pageSize":(data.caprdatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["caprdatamodel"] = {};
data.caprdatamodel.refcode = "capr";
data.caprdatamodel.searchurl = "/aProductRelease/tolistdatarefin";
data.caprdatamodel.addediturl= "/aProductRelease/addedit";
data.caprdatamodel.deleteurl = "/aProductRelease/delete";
data.caprdatamodel.sorturl = "/aProductRelease/sort";
data.caprdatamodel.batchediturl = "/aProductRelease/editbatch";
data.caprdatamodel.parentcomid = "";
data.caprdatamodel.searchformid = "caprdataform";
data.caprdatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.caprdatamodel.tablecomid = "caprtable";
data.caprdatamodel.tableid = "caprtable";
data.caprdatamodel.addhtmlpath = "aProductReleaseedit.html";
data.caprdatamodel.edithtmlpath = "aProductReleaseedit.html";
data.caprdatamodel.viewhtmlpath = "aProductReleaseedit.html";
data.caprdatamodel.reloadtablelistdata = function() {
	loadtablelistdata("capr", {"pageNum":(data.caprdatamodel.pageinfo.pageNum),"pageSize":(data.caprdatamodel.pageinfo.pageSize)});
};
loadtablelistdata("capr",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("capr",{});
checklistform("capr");
}catch(e){console.log(e);}
	
			
			
									capuiidtolistdata({});
	
	
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

