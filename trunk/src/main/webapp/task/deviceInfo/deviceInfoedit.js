//全局数据对象
var data = {};


/**
 * 页面准备OK自动执行
 */
jQuery(document).ready(function() {
	if($("#alertinfo") && $("#alertinfo").html() != ""){$("#alertinfo").parent().show();}//业务提示不为空，显示业务提示信息面板
	
		//编辑form控件，带数据项权限控制编辑控件初始化脚本
		try{
data["cdidatamodel"] = {};
data.cdidatamodel.refcode = "cdi";
data.cdidatamodel.searchurl = "/deviceInfo/tolistdatarefin";
data.cdidatamodel.addediturl = "/deviceInfo/addedit";
data.cdidatamodel.batchediturl = "/deviceInfo/editbatch";
data.cdidatamodel.editformid = "cdidataform";
data.cdidatamodel.sumbitbuttonid = "cdisumbitbutton";

$("#cdisumbitbutton").click(function(e) {
	if ("disabled" == $("#cdisumbitbutton").attr("disabled")) {
		return;
	}
	$("#cdisumbitbutton").attr("disabled","disabled");
	if(woformvalidate("cdi")){
		data.cdidatavo = $("#cdidataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.cdidatavo = setdefaultvalue(data.cdidatavo);
		}
		updatecom(data.cdidatavo.hasOwnProperty("requesturl")?data.cdidatavo.requesturl:data.cdidatamodel.addediturl,data.cdidatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.cdidatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#cdisumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("cdi");
}catch(e){console.log(e);}
	
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/deviceInfo/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.cdidatavo = response.data.list[0];
$("#"+data.cdidatamodel.editformid).initForm(data.cdidatavo);
					
					
					
					
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.cdidatavo);
			}
			}else{
						data.cdidatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cdidatamodel.editformid).initForm(data.cdidatavo);
						
						
						
						
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.cdidatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cdidatamodel.editformid).initForm(data.cdidatavo);
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
