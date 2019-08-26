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
	
		//编辑form控件，带数据项权限控制编辑控件初始化脚本
		try{
data["casdatamodel"] = {};
data.casdatamodel.refcode = "cas";
data.casdatamodel.searchurl = "/autoSubject/tolistdatarefin";
data.casdatamodel.addediturl = "/autoSubject/addedit";
data.casdatamodel.batchediturl = "/autoSubject/editbatch";
data.casdatamodel.editformid = "casdataform";
data.casdatamodel.sumbitbuttonid = "cassumbitbutton";

$("#cassumbitbutton").click(function(e) {
	if ("disabled" == $("#cassumbitbutton").attr("disabled")) {
		return;
	}
	$("#cassumbitbutton").attr("disabled","disabled");
	if(woformvalidate("cas")){
		data.casdatavo = $("#casdataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.casdatavo = setdefaultvalue(data.casdatavo);
		}
		updatecom(data.casdatavo.hasOwnProperty("requesturl")?data.casdatavo.requesturl:data.casdatamodel.addediturl,data.casdatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.casdatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#cassumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("cas");
}catch(e){console.log(e);}
	
			
			
									csiuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/autoSubject/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.casdatavo = response.data.list[0];
$("#"+data.casdatamodel.editformid).initForm(data.casdatavo);
					
					try{
if(data.casdatavo && data.casdatavo.csiuiid){
	$("#csiuiid").val(data.casdatavo.csiuiid);
dealrefnext("cas","csiuiid",data.casdatavo.csiuiid);
}
}catch(e){console.log(e);}
					
					
					
					$("input:radio[name='state'][value="+data.casdatavo.state+"]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
					
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.casdatavo);
			}
			}else{
						data.casdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.casdatamodel.editformid).initForm(data.casdatavo);
						
						
						
						
						
						$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
						
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.casdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.casdatamodel.editformid).initForm(data.casdatavo);$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
