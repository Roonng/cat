//全局数据对象
var data = {};

	//软件名称编辑控件初始化脚本
	function csiuiidtolistdata(param){
	baselist("/softInfo/tolistdata",param,
"csiuiidtolistdata","csiuiidList","csiuiid","uiid","title",function(){
if(data.csadatamodel && data.csadatamodel.editformid && data.csadatavo){
	$("#"+data.csadatamodel.editformid).initForm(data.csadatavo);
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
data["csadatamodel"] = {};
data.csadatamodel.refcode = "csa";
data.csadatamodel.searchurl = "/softAccount/tolistdatarefin";
data.csadatamodel.addediturl = "/softAccount/addedit";
data.csadatamodel.batchediturl = "/softAccount/editbatch";
data.csadatamodel.editformid = "csadataform";
data.csadatamodel.sumbitbuttonid = "csasumbitbutton";

$("#csasumbitbutton").click(function(e) {
	if ("disabled" == $("#csasumbitbutton").attr("disabled")) {
		return;
	}
	$("#csasumbitbutton").attr("disabled","disabled");
	if(woformvalidate("csa")){
		data.csadatavo = $("#csadataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.csadatavo = setdefaultvalue(data.csadatavo);
		}
		updatecom(data.csadatavo.hasOwnProperty("requesturl")?data.csadatavo.requesturl:data.csadatamodel.addediturl,data.csadatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.csadatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#csasumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("csa");
}catch(e){console.log(e);}
	
			
			
									csiuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/softAccount/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.csadatavo = response.data.list[0];
$("#"+data.csadatamodel.editformid).initForm(data.csadatavo);
					try{
if(data.csadatavo && data.csadatavo.csiuiid){
	$("#csiuiid").val(data.csadatavo.csiuiid);
dealrefnext("csa","csiuiid",data.csadatavo.csiuiid);
}
}catch(e){console.log(e);}
					
					
					
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.csadatavo);
			}
			}else{
						data.csadatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.csadatamodel.editformid).initForm(data.csadatavo);
						
						
						
						
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.csadatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.csadatamodel.editformid).initForm(data.csadatavo);
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
