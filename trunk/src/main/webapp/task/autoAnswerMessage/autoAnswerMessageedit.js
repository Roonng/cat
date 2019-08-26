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
	if(data.caamdatavo && data.caamdatavo.csiuiid){
		$("#csiuiid").val(data.caamdatavo.csiuiid);
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
	if(data.caamdatavo && data.caamdatavo.catuiid){
		$("#catuiid").val(data.caamdatavo.catuiid);
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
	if(data.caamdatavo && data.caamdatavo.cuiuiid){
		$("#cuiuiid").val(data.caamdatavo.cuiuiid);
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
	
		//编辑form控件，带数据项权限控制编辑控件初始化脚本
		try{
data["caamdatamodel"] = {};
data.caamdatamodel.refcode = "caam";
data.caamdatamodel.searchurl = "/autoAnswerMessage/tolistdatarefin";
data.caamdatamodel.addediturl = "/autoAnswerMessage/addedit";
data.caamdatamodel.batchediturl = "/autoAnswerMessage/editbatch";
data.caamdatamodel.editformid = "caamdataform";
data.caamdatamodel.sumbitbuttonid = "caamsumbitbutton";

$("#caamsumbitbutton").click(function(e) {
	if ("disabled" == $("#caamsumbitbutton").attr("disabled")) {
		return;
	}
	$("#caamsumbitbutton").attr("disabled","disabled");
	if(woformvalidate("caam")){
		data.caamdatavo = $("#caamdataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.caamdatavo = setdefaultvalue(data.caamdatavo);
		}
		updatecom(data.caamdatavo.hasOwnProperty("requesturl")?data.caamdatavo.requesturl:data.caamdatamodel.addediturl,data.caamdatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.caamdatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#caamsumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("caam");
}catch(e){console.log(e);}
		//生效开始时间编辑控件初始化脚本
		try{
$('#starttime').datetimepicker({
  format: "yyyy-mm-dd hh:ii:ss",
  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
});
}catch(e){console.log(e);}
		//生效结束时间编辑控件初始化脚本
		try{
$('#endtime').datetimepicker({
  format: "yyyy-mm-dd hh:ii:ss",
  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
});
}catch(e){console.log(e);}
	
			
			
									csiuiidtolistdata({});
			
			
									catuiidtolistdata({});
			
			
									cuiuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/autoAnswerMessage/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.caamdatavo = response.data.list[0];
$("#"+data.caamdatamodel.editformid).initForm(data.caamdatavo);
					try{
if(data.caamdatavo && data.caamdatavo.csiuiid){
	if(!(data.csiuiidList && data.csiuiidList.length > 0)){
		$("#csiuiid").append("<option value='"+data.caamdatavo.csiuiid+"'>"+data.caamdatavo.csiuiidrefview+"</option>");
	}
	$("#csiuiid").val(data.caamdatavo.csiuiid);
dealrefnext("caam","csiuiid",data.caamdatavo.csiuiid);
	$("#csiuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					try{
if(data.caamdatavo && data.caamdatavo.catuiid){
	if(!(data.catuiidList && data.catuiidList.length > 0)){
		$("#catuiid").append("<option value='"+data.caamdatavo.catuiid+"'>"+data.caamdatavo.catuiidrefview+"</option>");
	}
	$("#catuiid").val(data.caamdatavo.catuiid);
dealrefnext("caam","catuiid",data.caamdatavo.catuiid);
	$("#catuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					try{
if(data.caamdatavo && data.caamdatavo.cuiuiid){
	if(!(data.cuiuiidList && data.cuiuiidList.length > 0)){
		$("#cuiuiid").append("<option value='"+data.caamdatavo.cuiuiid+"'>"+data.caamdatavo.cuiuiidrefview+"</option>");
	}
	$("#cuiuiid").val(data.caamdatavo.cuiuiid);
dealrefnext("caam","cuiuiid",data.caamdatavo.cuiuiid);
	$("#cuiuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					
					$("input:radio[name='state'][value="+data.caamdatavo.state+"]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
					
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.caamdatavo);
			}
			}else{
						data.caamdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.caamdatamodel.editformid).initForm(data.caamdatavo);
						
						
						
						
						$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
						
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.caamdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.caamdatamodel.editformid).initForm(data.caamdatavo);$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
