//全局数据对象
var data = {};

	//设备名称编辑控件初始化脚本
	function cdiuiidtolistdata(param){
	baselist("/deviceInfo/tolistdata",param,
"cdiuiidtolistdata","cdiuiidList","cdiuiid","uiid","title",function(){
if(data.cdradatamodel && data.cdradatamodel.editformid && data.cdradatavo){
	$("#"+data.cdradatamodel.editformid).initForm(data.cdradatavo);
}
});
	}
	//自动化业务编辑控件初始化脚本
	function catuiidtolistdata(param){
	baselist("/autoTask/tolistdata",param,
"catuiidtolistdata","catuiidList","catuiid","uiid","title",function(){
if(data.cdradatamodel && data.cdradatamodel.editformid && data.cdradatavo){
	$("#"+data.cdradatamodel.editformid).initForm(data.cdradatavo);
}
});
	}

/**
 * 页面准备OK自动执行
 */
jQuery(document).ready(function() {
	if($("#alertinfo") && $("#alertinfo").html() != ""){$("#alertinfo").parent().show();}//业务提示不为空，显示业务提示信息面板
	
		//编辑form控件，带数据项权限控制编辑控件初始化脚本
		try{
data["cdradatamodel"] = {};
data.cdradatamodel.refcode = "cdra";
data.cdradatamodel.searchurl = "/deviceRefAuto/tolistdatarefin";
data.cdradatamodel.addediturl = "/deviceRefAuto/addedit";
data.cdradatamodel.batchediturl = "/deviceRefAuto/editbatch";
data.cdradatamodel.editformid = "cdradataform";
data.cdradatamodel.sumbitbuttonid = "cdrasumbitbutton";

$("#cdrasumbitbutton").click(function(e) {
	if ("disabled" == $("#cdrasumbitbutton").attr("disabled")) {
		return;
	}
	$("#cdrasumbitbutton").attr("disabled","disabled");
	if(woformvalidate("cdra")){
		data.cdradatavo = $("#cdradataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.cdradatavo = setdefaultvalue(data.cdradatavo);
		}
		updatecom(data.cdradatavo.hasOwnProperty("requesturl")?data.cdradatavo.requesturl:data.cdradatamodel.addediturl,data.cdradatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.cdradatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#cdrasumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("cdra");
}catch(e){console.log(e);}
	
			
			
									cdiuiidtolistdata({});
			
			
									catuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/deviceRefAuto/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.cdradatavo = response.data.list[0];
$("#"+data.cdradatamodel.editformid).initForm(data.cdradatavo);
					try{
if(data.cdradatavo && data.cdradatavo.cdiuiid){
	$("#cdiuiid").val(data.cdradatavo.cdiuiid);
dealrefnext("cdra","cdiuiid",data.cdradatavo.cdiuiid);
}
}catch(e){console.log(e);}
					try{
if(data.cdradatavo && data.cdradatavo.catuiid){
	$("#catuiid").val(data.cdradatavo.catuiid);
dealrefnext("cdra","catuiid",data.cdradatavo.catuiid);
}
}catch(e){console.log(e);}
					
					
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.cdradatavo);
			}
			}else{
						data.cdradatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cdradatamodel.editformid).initForm(data.cdradatavo);
						
						
						
						
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.cdradatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cdradatamodel.editformid).initForm(data.cdradatavo);
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
