//全局数据对象
var data = {};

	//用户名称编辑控件初始化脚本
	function cuiuiidtolistdata(param){
	data.cuiuiidselect2 = initsourcecode_select2("cuiuiid","用户名称","/userInfo/tolistdataor","uiid","name");
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
	if(data.ctrldatavo && data.ctrldatavo.catuiid){
		$("#catuiid").val(data.ctrldatavo.catuiid);
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
	
		//编辑form控件，带数据项权限控制编辑控件初始化脚本
		try{
data["ctrldatamodel"] = {};
data.ctrldatamodel.refcode = "ctrl";
data.ctrldatamodel.searchurl = "/taskRunLog/tolistdatarefin";
data.ctrldatamodel.addediturl = "/taskRunLog/addedit";
data.ctrldatamodel.batchediturl = "/taskRunLog/editbatch";
data.ctrldatamodel.editformid = "ctrldataform";
data.ctrldatamodel.sumbitbuttonid = "ctrlsumbitbutton";

$("#ctrlsumbitbutton").click(function(e) {
	if ("disabled" == $("#ctrlsumbitbutton").attr("disabled")) {
		return;
	}
	$("#ctrlsumbitbutton").attr("disabled","disabled");
	if(woformvalidate("ctrl")){
		data.ctrldatavo = $("#ctrldataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.ctrldatavo = setdefaultvalue(data.ctrldatavo);
		}
		updatecom(data.ctrldatavo.hasOwnProperty("requesturl")?data.ctrldatavo.requesturl:data.ctrldatamodel.addediturl,data.ctrldatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.ctrldatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#ctrlsumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("ctrl");
}catch(e){console.log(e);}
		//执行开始时间编辑控件初始化脚本
		try{
$('#starttime').datetimepicker({
  format: "yyyy-mm-dd hh:ii:ss",
  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
});
}catch(e){console.log(e);}
		//执行结束时间编辑控件初始化脚本
		try{
$('#endtime').datetimepicker({
  format: "yyyy-mm-dd hh:ii:ss",
  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
});
}catch(e){console.log(e);}
	
			
			
									cuiuiidtolistdata({});
			
			
									catuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/taskRunLog/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.ctrldatavo = response.data.list[0];
$("#"+data.ctrldatamodel.editformid).initForm(data.ctrldatavo);
					setvaluecode_select2("cuiuiid","uiid","name",data.ctrldatavo);
					try{
if(data.ctrldatavo && data.ctrldatavo.catuiid){
	if(!(data.catuiidList && data.catuiidList.length > 0)){
		$("#catuiid").append("<option value='"+data.ctrldatavo.catuiid+"'>"+data.ctrldatavo.catuiidrefview+"</option>");
	}
	$("#catuiid").val(data.ctrldatavo.catuiid);
dealrefnext("ctrl","catuiid",data.ctrldatavo.catuiid);
	$("#catuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					
					
					
					$("input:radio[name='state'][value="+data.ctrldatavo.state+"]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
					
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.ctrldatavo);
			}
			}else{
						data.ctrldatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.ctrldatamodel.editformid).initForm(data.ctrldatavo);
						
						
						
						
						
						$("input:radio[name='state'][value=1]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
						
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.ctrldatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.ctrldatamodel.editformid).initForm(data.ctrldatavo);$("input:radio[name='state'][value=1]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
