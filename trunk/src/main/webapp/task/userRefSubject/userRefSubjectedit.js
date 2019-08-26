//全局数据对象
var data = {};

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
	if(data.cursdatavo && data.cursdatavo.cuiuiid){
		$("#cuiuiid").val(data.cursdatavo.cuiuiid);
		$("#cuiuiid").trigger("liszt:updated");
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
	if(data.cursdatavo && data.cursdatavo.catuiid){
		$("#catuiid").val(data.cursdatavo.catuiid);
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
data["cursdatamodel"] = {};
data.cursdatamodel.refcode = "curs";
data.cursdatamodel.searchurl = "/userRefSubject/tolistdatarefin";
data.cursdatamodel.addediturl = "/userRefSubject/addedit";
data.cursdatamodel.batchediturl = "/userRefSubject/editbatch";
data.cursdatamodel.editformid = "cursdataform";
data.cursdatamodel.sumbitbuttonid = "curssumbitbutton";

$("#curssumbitbutton").click(function(e) {
	if ("disabled" == $("#curssumbitbutton").attr("disabled")) {
		return;
	}
	$("#curssumbitbutton").attr("disabled","disabled");
	if(woformvalidate("curs")){
		data.cursdatavo = $("#cursdataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.cursdatavo = setdefaultvalue(data.cursdatavo);
		}
		updatecom(data.cursdatavo.hasOwnProperty("requesturl")?data.cursdatavo.requesturl:data.cursdatamodel.addediturl,data.cursdatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.cursdatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#curssumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("curs");
}catch(e){console.log(e);}
		//服务到期时间编辑控件初始化脚本
		try{
$('#endtime').datetimepicker({
  format: "yyyy-mm-dd hh:ii:ss",
  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
});
}catch(e){console.log(e);}
	
			
			
									cuiuiidtolistdata({});
			
			
									catuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/userRefSubject/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.cursdatavo = response.data.list[0];
$("#"+data.cursdatamodel.editformid).initForm(data.cursdatavo);
					try{
if(data.cursdatavo && data.cursdatavo.cuiuiid){
	if(!(data.cuiuiidList && data.cuiuiidList.length > 0)){
		$("#cuiuiid").append("<option value='"+data.cursdatavo.cuiuiid+"'>"+data.cursdatavo.cuiuiidrefview+"</option>");
	}
	$("#cuiuiid").val(data.cursdatavo.cuiuiid);
dealrefnext("curs","cuiuiid",data.cursdatavo.cuiuiid);
	$("#cuiuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					try{
if(data.cursdatavo && data.cursdatavo.catuiid){
	if(!(data.catuiidList && data.catuiidList.length > 0)){
		$("#catuiid").append("<option value='"+data.cursdatavo.catuiid+"'>"+data.cursdatavo.catuiidrefview+"</option>");
	}
	$("#catuiid").val(data.cursdatavo.catuiid);
dealrefnext("curs","catuiid",data.cursdatavo.catuiid);
	$("#catuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					$("input:radio[name='openstate'][value="+data.cursdatavo.openstate+"]").attr("checked",true);
$("input:radio[name='openstate'][checked]").parent().addClass("checked");
					
					$("input:radio[name='state'][value="+data.cursdatavo.state+"]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
					$("input:radio[name='starttype'][value="+data.cursdatavo.starttype+"]").attr("checked",true);
$("input:radio[name='starttype'][checked]").parent().addClass("checked");
					
					
					try{
$('#allowkey').tagsInput({width: 'auto','onAddTag': function () {}});
}catch(e){console.log(e);}
					try{
$('#delowkey').tagsInput({width: 'auto','onAddTag': function () {}});
}catch(e){console.log(e);}
					$("input:radio[name='answertype'][value="+data.cursdatavo.answertype+"]").attr("checked",true);
$("input:radio[name='answertype'][checked]").parent().addClass("checked");
					$("input:radio[name='advanchek'][value="+data.cursdatavo.advanchek+"]").attr("checked",true);
$("input:radio[name='advanchek'][checked]").parent().addClass("checked");
					$("input:radio[name='checkrepeat'][value="+data.cursdatavo.checkrepeat+"]").attr("checked",true);
$("input:radio[name='checkrepeat'][checked]").parent().addClass("checked");
					
					
					
					$("input:radio[name='repeatin'][value="+data.cursdatavo.repeatin+"]").attr("checked",true);
$("input:radio[name='repeatin'][checked]").parent().addClass("checked");
					
					$("input:radio[name='strongstart'][value="+data.cursdatavo.strongstart+"]").attr("checked",true);
$("input:radio[name='strongstart'][checked]").parent().addClass("checked");
					$("input:radio[name='strongend'][value="+data.cursdatavo.strongend+"]").attr("checked",true);
$("input:radio[name='strongend'][checked]").parent().addClass("checked");
					$("input:radio[name='runlevel'][value="+data.cursdatavo.runlevel+"]").attr("checked",true);
$("input:radio[name='runlevel'][checked]").parent().addClass("checked");
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.cursdatavo);
			}
			}else{
						data.cursdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cursdatamodel.editformid).initForm(data.cursdatavo);
						
						
						$("input:radio[name='openstate'][value=0]").attr("checked",true);
$("input:radio[name='openstate'][checked]").parent().addClass("checked");
						
						$("input:radio[name='state'][value=1]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
						$("input:radio[name='starttype'][value=2]").attr("checked",true);
$("input:radio[name='starttype'][checked]").parent().addClass("checked");
						
						
						$('#allowkey').tagsInput({width: 'auto','onAddTag': function () {}});
						$('#delowkey').tagsInput({width: 'auto','onAddTag': function () {}});
						$("input:radio[name='answertype'][value=1]").attr("checked",true);
$("input:radio[name='answertype'][checked]").parent().addClass("checked");
						$("input:radio[name='advanchek'][value=0]").attr("checked",true);
$("input:radio[name='advanchek'][checked]").parent().addClass("checked");
						$("input:radio[name='checkrepeat'][value=1]").attr("checked",true);
$("input:radio[name='checkrepeat'][checked]").parent().addClass("checked");
						
						
						
						$("input:radio[name='repeatin'][value=0]").attr("checked",true);
$("input:radio[name='repeatin'][checked]").parent().addClass("checked");
						
						$("input:radio[name='strongstart'][value=0]").attr("checked",true);
$("input:radio[name='strongstart'][checked]").parent().addClass("checked");
						$("input:radio[name='strongend'][value=0]").attr("checked",true);
$("input:radio[name='strongend'][checked]").parent().addClass("checked");
						$("input:radio[name='runlevel'][value=0]").attr("checked",true);
$("input:radio[name='runlevel'][checked]").parent().addClass("checked");
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.cursdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cursdatamodel.editformid).initForm(data.cursdatavo);$("input:radio[name='openstate'][value=0]").attr("checked",true);
$("input:radio[name='openstate'][checked]").parent().addClass("checked");$("input:radio[name='state'][value=1]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");$("input:radio[name='starttype'][value=2]").attr("checked",true);
$("input:radio[name='starttype'][checked]").parent().addClass("checked");$('#allowkey').tagsInput({width: 'auto','onAddTag': function () {}});$('#delowkey').tagsInput({width: 'auto','onAddTag': function () {}});$("input:radio[name='answertype'][value=1]").attr("checked",true);
$("input:radio[name='answertype'][checked]").parent().addClass("checked");$("input:radio[name='advanchek'][value=0]").attr("checked",true);
$("input:radio[name='advanchek'][checked]").parent().addClass("checked");$("input:radio[name='checkrepeat'][value=1]").attr("checked",true);
$("input:radio[name='checkrepeat'][checked]").parent().addClass("checked");$("input:radio[name='repeatin'][value=0]").attr("checked",true);
$("input:radio[name='repeatin'][checked]").parent().addClass("checked");$("input:radio[name='strongstart'][value=0]").attr("checked",true);
$("input:radio[name='strongstart'][checked]").parent().addClass("checked");$("input:radio[name='strongend'][value=0]").attr("checked",true);
$("input:radio[name='strongend'][checked]").parent().addClass("checked");$("input:radio[name='runlevel'][value=0]").attr("checked",true);
$("input:radio[name='runlevel'][checked]").parent().addClass("checked");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
