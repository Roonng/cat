var pageinfo;//分页数据对象
//全局数据对象
var data = {};
	//软件名称编辑控件初始化脚本
	function csiuiidtolistdata(param){
	baselist("/softInfo/tolistdata",param,
"csiuiidtolistdata","csiuiidList","csiuiid","uiid","title",function(){
if(data.casdatamodel && data.casdatamodel.editformid && data.casdatavo){
	$("#"+data.casdatamodel.editformid).initForm(data.casdatavo);
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
$("#cassearchbutton").on('click', function() {
	loadtablelistdata("cas", {"pageNum":(data.casdatamodel.pageinfo.pageNum),"pageSize":(data.casdatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["casdatamodel"] = {};
data.casdatamodel.refcode = "cas";
data.casdatamodel.searchurl = "/autoSubject/tolistdatarefin";
data.casdatamodel.addediturl= "/autoSubject/addedit";
data.casdatamodel.deleteurl = "/autoSubject/delete";
data.casdatamodel.sorturl = "/autoSubject/sort";
data.casdatamodel.batchediturl = "/autoSubject/editbatch";
data.casdatamodel.parentcomid = "";
data.casdatamodel.searchformid = "casdataform";
data.casdatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.casdatamodel.tablecomid = "castable";
data.casdatamodel.tableid = "castable";
data.casdatamodel.addhtmlpath = "autoSubjectedit.html";
data.casdatamodel.edithtmlpath = "autoSubjectedit.html";
data.casdatamodel.viewhtmlpath = "autoSubjectedit.html";
data.casdatamodel.reloadtablelistdata = function() {
	loadtablelistdata("cas", {"pageNum":(data.casdatamodel.pageinfo.pageNum),"pageSize":(data.casdatamodel.pageinfo.pageSize)});
};
loadtablelistdata("cas",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("cas",{});
checklistform("cas");
}catch(e){console.log(e);}
	
			
			
									csiuiidtolistdata({});
	
	
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

