//全局数据对象
var data = {};


/**
 * 页面准备OK自动执行
 */
jQuery(document).ready(function() {
	if($("#alertinfo") && $("#alertinfo").html() != ""){$("#alertinfo").parent().show();}//业务提示不为空，显示业务提示信息面板
	
		//编辑form控件，带数据项权限控制编辑控件初始化脚本
		try{
data["capdatamodel"] = {};
data.capdatamodel.refcode = "cap";
data.capdatamodel.searchurl = "/autoProduct/tolistdatarefin";
data.capdatamodel.addediturl = "/autoProduct/addedit";
data.capdatamodel.batchediturl = "/autoProduct/editbatch";
data.capdatamodel.editformid = "capdataform";
data.capdatamodel.sumbitbuttonid = "capsumbitbutton";

$("#capsumbitbutton").click(function(e) {
	if ("disabled" == $("#capsumbitbutton").attr("disabled")) {
		return;
	}
	$("#capsumbitbutton").attr("disabled","disabled");
	if(woformvalidate("cap")){
		data.capdatavo = $("#capdataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.capdatavo = setdefaultvalue(data.capdatavo);
		}
		updatecom(data.capdatavo.hasOwnProperty("requesturl")?data.capdatavo.requesturl:data.capdatamodel.addediturl,data.capdatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.capdatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#capsumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("cap");
}catch(e){console.log(e);}
	
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/autoProduct/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.capdatavo = response.data.list[0];
$("#"+data.capdatamodel.editformid).initForm(data.capdatavo);
					
					
					data.logoimgfile = initeditfile("logoimgfile","","","","","0","0",
"2000","2000",response.data.list[0].logoimg,"1","https://wolv.oss-cn-beijing.aliyuncs.com/");
					$("input:radio[name='publicsta'][value="+data.capdatavo.publicsta+"]").attr("checked",true);
$("input:radio[name='publicsta'][checked]").parent().addClass("checked");
					
					
					data.downloadcodefile = initeditfile("downloadcodefile","","","","","0","0",
"2000","2000",response.data.list[0].downloadcode,"1","https://wolv.oss-cn-beijing.aliyuncs.com/");
					
					data.shortcodefile = initeditfile("shortcodefile","","","","","0","0",
"2000","2000",response.data.list[0].shortcode,"1","https://wolv.oss-cn-beijing.aliyuncs.com/");
					
					
					data.vidiourlfile = initeditfile("vidiourlfile","","","","","0","0",
"2000","2000",response.data.list[0].vidiourl,"1","https://wolv.oss-cn-beijing.aliyuncs.com/");
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.capdatavo);
			}
			}else{
						data.capdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.capdatamodel.editformid).initForm(data.capdatavo);
						
						
						data.logoimgfile = initaddfile("logoimgfile","","","","","0","0","2000","2000");
						$("input:radio[name='publicsta'][value=1]").attr("checked",true);
$("input:radio[name='publicsta'][checked]").parent().addClass("checked");
						
						
						data.downloadcodefile = initaddfile("downloadcodefile","","","","","0","0","2000","2000");
						
						data.shortcodefile = initaddfile("shortcodefile","","","","","0","0","2000","2000");
						
						
						data.vidiourlfile = initaddfile("vidiourlfile","","","","","0","0","2000","2000");
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.capdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.capdatamodel.editformid).initForm(data.capdatavo);data.logoimgfile = initaddfile("logoimgfile","","","","","0","0","2000","2000");$("input:radio[name='publicsta'][value=1]").attr("checked",true);
$("input:radio[name='publicsta'][checked]").parent().addClass("checked");data.downloadcodefile = initaddfile("downloadcodefile","","","","","0","0","2000","2000");data.shortcodefile = initaddfile("shortcodefile","","","","","0","0","2000","2000");data.vidiourlfile = initaddfile("vidiourlfile","","","","","0","0","2000","2000");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
