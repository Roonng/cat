var pageinfo;//分页数据对象
//全局数据对象
var data = {};
	//推荐人名称编辑控件初始化脚本
	function recomidtolistdata(param){
	data.recomidselect2 = initsourcecode_select2("recomid","推荐人名称","/userInfo/tolistdataor","uiid","name,mobile");
	}

/**
 * 页面准备OK自动执行
 */
jQuery(document).ready(function() {
	if($("#alertinfo") && $("#alertinfo").html() != ""){$("#alertinfo").parent().show();}//业务提示不为空，显示业务提示信息面板
	
	
	
		//查询按钮编辑控件初始化脚本
		try{
$("#cuisearchbutton").on('click', function() {
	loadtablelistdata("cui", {"pageNum":(data.cuidatamodel.pageinfo.pageNum),"pageSize":(data.cuidatamodel.pageinfo.pageSize)});
});
}catch(e){console.log(e);}
		//列表数据表格控件编辑控件初始化脚本
		try{
data["cuidatamodel"] = {};
data.cuidatamodel.refcode = "cui";
data.cuidatamodel.searchurl = "/userInfo/tolistdatarefin";
data.cuidatamodel.addediturl= "/userInfo/addedit";
data.cuidatamodel.deleteurl = "/userInfo/delete";
data.cuidatamodel.sorturl = "/userInfo/sort";
data.cuidatamodel.batchediturl = "/userInfo/editbatch";
data.cuidatamodel.parentcomid = "";
data.cuidatamodel.searchformid = "cuidataform";
data.cuidatamodel.pageinfo = {"pageNum":"1","pageSize":"15"};
data.cuidatamodel.tablecomid = "cuitable";
data.cuidatamodel.tableid = "cuitable";
data.cuidatamodel.addhtmlpath = "userInfoedit.html";
data.cuidatamodel.edithtmlpath = "userInfoedit.html";
data.cuidatamodel.viewhtmlpath = "userInfoedit.html";
data.cuidatamodel.reloadtablelistdata = function() {
	loadtablelistdata("cui", {"pageNum":(data.cuidatamodel.pageinfo.pageNum),"pageSize":(data.cuidatamodel.pageinfo.pageSize)});
};
loadtablelistdata("cui",{"pageNum":"1","pageSize":"15"});//初始数据加载
loadtableinit("cui",{});
checklistform("cui");
}catch(e){console.log(e);}
	
			
			
									recomidtolistdata({});
	
	
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

