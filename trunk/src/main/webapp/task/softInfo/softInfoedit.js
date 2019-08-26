//全局数据对象
var data = {};


/**
 * 页面准备OK自动执行
 */
jQuery(document).ready(function() {
	if($("#alertinfo") && $("#alertinfo").html() != ""){$("#alertinfo").parent().show();}//业务提示不为空，显示业务提示信息面板
	
		//编辑form控件，带数据项权限控制编辑控件初始化脚本
		try{
data["csidatamodel"] = {};
data.csidatamodel.refcode = "csi";
data.csidatamodel.searchurl = "/softInfo/tolistdatarefin";
data.csidatamodel.addediturl = "/softInfo/addedit";
data.csidatamodel.batchediturl = "/softInfo/editbatch";
data.csidatamodel.editformid = "csidataform";
data.csidatamodel.sumbitbuttonid = "csisumbitbutton";

$("#csisumbitbutton").click(function(e) {
	if ("disabled" == $("#csisumbitbutton").attr("disabled")) {
		return;
	}
	$("#csisumbitbutton").attr("disabled","disabled");
	if(woformvalidate("csi")){
		data.csidatavo = $("#csidataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.csidatavo = setdefaultvalue(data.csidatavo);
		}
		updatecom(data.csidatavo.hasOwnProperty("requesturl")?data.csidatavo.requesturl:data.csidatamodel.addediturl,data.csidatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.csidatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#csisumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("csi");
}catch(e){console.log(e);}
	
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/softInfo/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.csidatavo = response.data.list[0];
$("#"+data.csidatamodel.editformid).initForm(data.csidatavo);
					
					
					
					
					$("input:radio[name='state'][value="+data.csidatavo.state+"]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.csidatavo);
			}
			}else{
						data.csidatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.csidatamodel.editformid).initForm(data.csidatavo);
						
						
						
						
						$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.csidatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.csidatamodel.editformid).initForm(data.csidatavo);$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
