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
	
		//编辑form控件，带数据项权限控制编辑控件初始化脚本
		try{
data["catdatamodel"] = {};
data.catdatamodel.refcode = "cat";
data.catdatamodel.searchurl = "/autoTask/tolistdatarefin";
data.catdatamodel.addediturl = "/autoTask/addedit";
data.catdatamodel.batchediturl = "/autoTask/editbatch";
data.catdatamodel.editformid = "catdataform";
data.catdatamodel.sumbitbuttonid = "catsumbitbutton";

$("#catsumbitbutton").click(function(e) {
	if ("disabled" == $("#catsumbitbutton").attr("disabled")) {
		return;
	}
	$("#catsumbitbutton").attr("disabled","disabled");
	if(woformvalidate("cat")){
		data.catdatavo = $("#catdataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.catdatavo = setdefaultvalue(data.catdatavo);
		}
		updatecom(data.catdatavo.hasOwnProperty("requesturl")?data.catdatavo.requesturl:data.catdatamodel.addediturl,data.catdatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.catdatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#catsumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("cat");
}catch(e){console.log(e);}
	
			
			
									ptypetolistdata({});
			
			
									csiuiidtolistdata({});
			
			
									cstuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/autoTask/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.catdatavo = response.data.list[0];
$("#"+data.catdatamodel.editformid).initForm(data.catdatavo);
					try{
if(data.catdatavo && data.catdatavo.ptype){
	if(data.catdatavo.ptype.indexOf(",") != -1){
		var valusstr = data.catdatavo.ptype.split(",");
		if(!(data.ptypeList && data.ptypeList.length > 0)){
			var valusstrview = data.catdatavo.ptyperefview.split(",");
			for(var i = 0 ; i < valusstr.length ; i ++){
				$("#ptype").append("<option value='"+valusstr[i]+"'>"+valusstrview[i]+"</option>");
			}
		}
		$("#ptype").val(valusstr);
		$("#ptype").trigger("liszt:updated");
	}else{
		if(!(data.ptypeList && data.ptypeList.length > 0)){
			$("#ptype").append("<option select value='"+data.catdatavo.ptype+"'>"+data.catdatavo.ptyperefview+"</option>");
		}
		if(data.catdatavo && data.catdatavo.ptype){
			$("#ptype").val(data.catdatavo.ptype);
			$("#ptype").trigger("liszt:updated");
		}
	}
}
}catch(e){console.log(e);}
					try{
if(data.catdatavo && data.catdatavo.csiuiid){
	if(!(data.csiuiidList && data.csiuiidList.length > 0)){
		$("#csiuiid").append("<option value='"+data.catdatavo.csiuiid+"'>"+data.catdatavo.csiuiidrefview+"</option>");
	}
	$("#csiuiid").val(data.catdatavo.csiuiid);
dealrefnext("cat","csiuiid",data.catdatavo.csiuiid);
	$("#csiuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					try{
if(data.catdatavo && data.catdatavo.cstuiid){
	if(!(data.cstuiidList && data.cstuiidList.length > 0)){
		$("#cstuiid").append("<option value='"+data.catdatavo.cstuiid+"'>"+data.catdatavo.cstuiidrefview+"</option>");
	}
	$("#cstuiid").val(data.catdatavo.cstuiid);
dealrefnext("cat","cstuiid",data.catdatavo.cstuiid);
	$("#cstuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					
					
					
					$("input:radio[name='ifcache'][value="+data.catdatavo.ifcache+"]").attr("checked",true);
$("input:radio[name='ifcache'][checked]").parent().addClass("checked");
					
					
					
					$("input:radio[name='state'][value="+data.catdatavo.state+"]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.catdatavo);
			}
			}else{
						data.catdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.catdatamodel.editformid).initForm(data.catdatavo);
						
						
						
						
						
						
						$("input:radio[name='ifcache'][value=0]").attr("checked",true);
$("input:radio[name='ifcache'][checked]").parent().addClass("checked");
						
						
						
						$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.catdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.catdatamodel.editformid).initForm(data.catdatavo);$("input:radio[name='ifcache'][value=0]").attr("checked",true);
$("input:radio[name='ifcache'][checked]").parent().addClass("checked");$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
