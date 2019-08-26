//全局数据对象
var data = {};

	//产品名称编辑控件初始化脚本
	function capuiidtolistdata(param){
	baselist("/autoProduct/tolistdata",param,
"capuiidtolistdata","capuiidList","capuiid","uiid","name,code",function(){
if(data.caprdatamodel && data.caprdatamodel.editformid && data.caprdatavo){
	$("#"+data.caprdatamodel.editformid).initForm(data.caprdatavo);
}
});
	}
	//发布人编辑控件初始化脚本
	function cuiuiidtolistdata(param){
	updatecom("/userInfo/tolistdata",param,function(response){//树形数据下拉
	try{
	$("#cuiuiid").empty();
	$("#cuiuiid").append("<option value=''>请选择</option>");
	data.cuiuiidList = response.data.list;
	var treedata = transData(response.data.list,"uiid","","child");
	$.each(treedata, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#cuiuiid").append("<optgroup label=\"" + n["name,mobile"] + "\"></optgroup>");
			loudmoreoption(n,n.child,"cuiuiid","uiid","name,mobile");
		}else{
			$("#cuiuiid").append("<option value='" + n["uiid"] + "'>"+ getloudmoreoption(n,"name,mobile") + "</option>");
		}
	});
	$("#cuiuiid").chosen({allow_single_deselect: true});
	if(data.caprdatavo && data.caprdatavo.cuiuiid){
		$("#cuiuiid").val(data.caprdatavo.cuiuiid);
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
data["caprdatamodel"] = {};
data.caprdatamodel.refcode = "capr";
data.caprdatamodel.searchurl = "/aProductRelease/tolistdatarefin";
data.caprdatamodel.addediturl = "/aProductRelease/addedit";
data.caprdatamodel.batchediturl = "/aProductRelease/editbatch";
data.caprdatamodel.editformid = "caprdataform";
data.caprdatamodel.sumbitbuttonid = "caprsumbitbutton";

$("#caprsumbitbutton").click(function(e) {
	if ("disabled" == $("#caprsumbitbutton").attr("disabled")) {
		return;
	}
	$("#caprsumbitbutton").attr("disabled","disabled");
	if(woformvalidate("capr")){
		data.caprdatavo = $("#caprdataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.caprdatavo = setdefaultvalue(data.caprdatavo);
		}
		updatecom(data.caprdatavo.hasOwnProperty("requesturl")?data.caprdatavo.requesturl:data.caprdatamodel.addediturl,data.caprdatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.caprdatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#caprsumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("capr");
}catch(e){console.log(e);}
		//发布时间编辑控件初始化脚本
		try{
$('#releasetime').datetimepicker({
  format: "yyyy-mm-dd hh:ii:ss",
  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
});
}catch(e){console.log(e);}
		//生效时间编辑控件初始化脚本
		try{
$('#activitytime').datetimepicker({
  format: "yyyy-mm-dd hh:ii:ss",
  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
});
}catch(e){console.log(e);}
	
			
			
									capuiidtolistdata({});
			
			
									cuiuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/aProductRelease/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.caprdatavo = response.data.list[0];
$("#"+data.caprdatamodel.editformid).initForm(data.caprdatavo);
					try{
if(data.caprdatavo && data.caprdatavo.capuiid){
	$("#capuiid").val(data.caprdatavo.capuiid);
dealrefnext("capr","capuiid",data.caprdatavo.capuiid);
}
}catch(e){console.log(e);}
					try{
if(data.caprdatavo && data.caprdatavo.cuiuiid){
	if(!(data.cuiuiidList && data.cuiuiidList.length > 0)){
		$("#cuiuiid").append("<option value='"+data.caprdatavo.cuiuiid+"'>"+data.caprdatavo.cuiuiidrefview+"</option>");
	}
	$("#cuiuiid").val(data.caprdatavo.cuiuiid);
dealrefnext("capr","cuiuiid",data.caprdatavo.cuiuiid);
	$("#cuiuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					
					$("input:radio[name='state'][value="+data.caprdatavo.state+"]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
					
					data.downurlfile = initeditfile("downurlfile","","","","","0","0",
"2000","2000",response.data.list[0].downurl,"1","https://wolv.oss-cn-beijing.aliyuncs.com/");
					
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.caprdatavo);
			}
			}else{
						data.caprdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.caprdatamodel.editformid).initForm(data.caprdatavo);
						
						
						
						$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
						
						data.downurlfile = initaddfile("downurlfile","","","","","0","0","2000","2000");
						
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.caprdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.caprdatamodel.editformid).initForm(data.caprdatavo);$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");data.downurlfile = initaddfile("downurlfile","","","","","0","0","2000","2000");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
