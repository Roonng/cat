//全局数据对象
var data = {};

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
	if(data.caaldatavo && data.caaldatavo.catuiid){
		$("#catuiid").val(data.caaldatavo.catuiid);
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
	if(data.caaldatavo && data.caaldatavo.cuiuiid){
		$("#cuiuiid").val(data.caaldatavo.cuiuiid);
		$("#cuiuiid").trigger("liszt:updated");
	}
	}catch(e){console.log(e);}
});
	}
	//内部主题设置编辑控件初始化脚本
	function catuiid2tolistdata(param){
	updatecom("/autoTask/tolistdata",param,function(response){//树形数据下拉
	try{
	$("#catuiid2").empty();
	$("#catuiid2").append("<option value=''>请选择</option>");
	data.catuiid2List = response.data.list;
	var treedata = transData(response.data.list,"uiid","","child");
	$.each(treedata, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#catuiid2").append("<optgroup label=\"" + n["title"] + "\"></optgroup>");
			loudmoreoption(n,n.child,"catuiid2","uiid","title");
		}else{
			$("#catuiid2").append("<option value='" + n["uiid"] + "'>"+ getloudmoreoption(n,"title") + "</option>");
		}
	});
	$("#catuiid2").chosen({allow_single_deselect: true});
	if(data.caaldatavo && data.caaldatavo.catuiid2){
		$("#catuiid2").val(data.caaldatavo.catuiid2);
		$("#catuiid2").trigger("liszt:updated");
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
data["caaldatamodel"] = {};
data.caaldatamodel.refcode = "caal";
data.caaldatamodel.searchurl = "/autoAnswerLog/tolistdatarefin";
data.caaldatamodel.addediturl = "/autoAnswerLog/addedit";
data.caaldatamodel.batchediturl = "/autoAnswerLog/editbatch";
data.caaldatamodel.editformid = "caaldataform";
data.caaldatamodel.sumbitbuttonid = "caalsumbitbutton";

$("#caalsumbitbutton").click(function(e) {
	if ("disabled" == $("#caalsumbitbutton").attr("disabled")) {
		return;
	}
	$("#caalsumbitbutton").attr("disabled","disabled");
	if(woformvalidate("caal")){
		data.caaldatavo = $("#caaldataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.caaldatavo = setdefaultvalue(data.caaldatavo);
		}
		updatecom(data.caaldatavo.hasOwnProperty("requesturl")?data.caaldatavo.requesturl:data.caaldatamodel.addediturl,data.caaldatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.caaldatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#caalsumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("caal");
}catch(e){console.log(e);}
		//采集时间编辑控件初始化脚本
		try{
$('#addtime').datetimepicker({
  format: "yyyy-mm-dd hh:ii:ss",
  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
});
}catch(e){console.log(e);}
	
			
			
									catuiidtolistdata({});
			
			
									cuiuiidtolistdata({});
			
			
									catuiid2tolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/autoAnswerLog/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.caaldatavo = response.data.list[0];
$("#"+data.caaldatamodel.editformid).initForm(data.caaldatavo);
					try{
if(data.caaldatavo && data.caaldatavo.catuiid){
	if(!(data.catuiidList && data.catuiidList.length > 0)){
		$("#catuiid").append("<option value='"+data.caaldatavo.catuiid+"'>"+data.caaldatavo.catuiidrefview+"</option>");
	}
	$("#catuiid").val(data.caaldatavo.catuiid);
dealrefnext("caal","catuiid",data.caaldatavo.catuiid);
	$("#catuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					try{
if(data.caaldatavo && data.caaldatavo.cuiuiid){
	if(!(data.cuiuiidList && data.cuiuiidList.length > 0)){
		$("#cuiuiid").append("<option value='"+data.caaldatavo.cuiuiid+"'>"+data.caaldatavo.cuiuiidrefview+"</option>");
	}
	$("#cuiuiid").val(data.caaldatavo.cuiuiid);
dealrefnext("caal","cuiuiid",data.caaldatavo.cuiuiid);
	$("#cuiuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					
					
					
					
					$("input:radio[name='ctype'][value="+data.caaldatavo.ctype+"]").attr("checked",true);
$("input:radio[name='ctype'][checked]").parent().addClass("checked");
					$("input:radio[name='ifok'][value="+data.caaldatavo.ifok+"]").attr("checked",true);
$("input:radio[name='ifok'][checked]").parent().addClass("checked");
					$("input:radio[name='ifstand'][value="+data.caaldatavo.ifstand+"]").attr("checked",true);
$("input:radio[name='ifstand'][checked]").parent().addClass("checked");
					
					
					
					try{
if(data.caaldatavo && data.caaldatavo.catuiid2){
	if(!(data.catuiid2List && data.catuiid2List.length > 0)){
		$("#catuiid2").append("<option value='"+data.caaldatavo.catuiid2+"'>"+data.caaldatavo.catuiid2refview+"</option>");
	}
	$("#catuiid2").val(data.caaldatavo.catuiid2);
dealrefnext("caal","catuiid2",data.caaldatavo.catuiid2);
	$("#catuiid2").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.caaldatavo);
			}
			}else{
						data.caaldatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.caaldatamodel.editformid).initForm(data.caaldatavo);
						
						
						
						
						
						
						$("input:radio[name='ctype'][value=0]").attr("checked",true);
$("input:radio[name='ctype'][checked]").parent().addClass("checked");
						$("input:radio[name='ifok'][value=0]").attr("checked",true);
$("input:radio[name='ifok'][checked]").parent().addClass("checked");
						$("input:radio[name='ifstand'][value=0]").attr("checked",true);
$("input:radio[name='ifstand'][checked]").parent().addClass("checked");
						
						
						
						
						
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.caaldatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.caaldatamodel.editformid).initForm(data.caaldatavo);$("input:radio[name='ctype'][value=0]").attr("checked",true);
$("input:radio[name='ctype'][checked]").parent().addClass("checked");$("input:radio[name='ifok'][value=0]").attr("checked",true);
$("input:radio[name='ifok'][checked]").parent().addClass("checked");$("input:radio[name='ifstand'][value=0]").attr("checked",true);
$("input:radio[name='ifstand'][checked]").parent().addClass("checked");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
