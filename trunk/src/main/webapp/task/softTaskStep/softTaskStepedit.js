//全局数据对象
var data = {};

	//业务名称编辑控件初始化脚本
	function cstuiidtolistdata(param){
	updatecom("/softTask/tolistdata",param,function(response){//树形数据下拉
	try{
	$("#cstuiid").empty();
	$("#cstuiid").append("<option value=''>请选择</option>");
	data.cstuiidList = response.data.list;
	var treedata = transData(response.data.list,"uiid","","child");
	$.each(treedata, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#cstuiid").append("<optgroup label=\"" + n["title"] + "\"></optgroup>");
			loudmoreoption(n,n.child,"cstuiid","uiid","title");
		}else{
			$("#cstuiid").append("<option value='" + n["uiid"] + "'>"+ getloudmoreoption(n,"title") + "</option>");
		}
	});
	$("#cstuiid").chosen({allow_single_deselect: true});
	if(data.cstsdatavo && data.cstsdatavo.cstuiid){
		$("#cstuiid").val(data.cstsdatavo.cstuiid);
		$("#cstuiid").trigger("liszt:updated");
	}
	}catch(e){console.log(e);}
});
	}
	//上步骤名称编辑控件初始化脚本
	function precstsuiidtolistdata(param){
	updatecom("/softTaskStep/tolistdata",param,function(response){//树形数据下拉
	try{
	$("#precstsuiid").empty();
	$("#precstsuiid").append("<option value=''>请选择</option>");
	data.precstsuiidList = response.data.list;
	var treedata = transData(response.data.list,"uiid","","child");
	$.each(treedata, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#precstsuiid").append("<optgroup label=\"" + n["title"] + "\"></optgroup>");
			loudmoreoption(n,n.child,"precstsuiid","uiid","title");
		}else{
			$("#precstsuiid").append("<option value='" + n["uiid"] + "'>"+ getloudmoreoption(n,"title") + "</option>");
		}
	});
	$("#precstsuiid").chosen({allow_single_deselect: true});
	if(data.cstsdatavo && data.cstsdatavo.precstsuiid){
		$("#precstsuiid").val(data.cstsdatavo.precstsuiid);
		$("#precstsuiid").trigger("liszt:updated");
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
data["cstsdatamodel"] = {};
data.cstsdatamodel.refcode = "csts";
data.cstsdatamodel.searchurl = "/softTaskStep/tolistdatarefin";
data.cstsdatamodel.addediturl = "/softTaskStep/addedit";
data.cstsdatamodel.batchediturl = "/softTaskStep/editbatch";
data.cstsdatamodel.editformid = "cstsdataform";
data.cstsdatamodel.sumbitbuttonid = "cstssumbitbutton";

$("#cstssumbitbutton").click(function(e) {
	if ("disabled" == $("#cstssumbitbutton").attr("disabled")) {
		return;
	}
	$("#cstssumbitbutton").attr("disabled","disabled");
	if(woformvalidate("csts")){
		data.cstsdatavo = $("#cstsdataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.cstsdatavo = setdefaultvalue(data.cstsdatavo);
		}
		updatecom(data.cstsdatavo.hasOwnProperty("requesturl")?data.cstsdatavo.requesturl:data.cstsdatamodel.addediturl,data.cstsdatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.cstsdatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#cstssumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("csts");
}catch(e){console.log(e);}
	
			
			
									cstuiidtolistdata({});
			
			
									precstsuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/softTaskStep/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.cstsdatavo = response.data.list[0];
$("#"+data.cstsdatamodel.editformid).initForm(data.cstsdatavo);
					try{
if(data.cstsdatavo && data.cstsdatavo.cstuiid){
	if(!(data.cstuiidList && data.cstuiidList.length > 0)){
		$("#cstuiid").append("<option value='"+data.cstsdatavo.cstuiid+"'>"+data.cstsdatavo.cstuiidrefview+"</option>");
	}
	$("#cstuiid").val(data.cstsdatavo.cstuiid);
dealrefnext("csts","cstuiid",data.cstsdatavo.cstuiid);
	$("#cstuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					try{
if(data.cstsdatavo && data.cstsdatavo.precstsuiid){
	if(!(data.precstsuiidList && data.precstsuiidList.length > 0)){
		$("#precstsuiid").append("<option value='"+data.cstsdatavo.precstsuiid+"'>"+data.cstsdatavo.precstsuiidrefview+"</option>");
	}
	$("#precstsuiid").val(data.cstsdatavo.precstsuiid);
dealrefnext("csts","precstsuiid",data.cstsdatavo.precstsuiid);
	$("#precstsuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					
					$("input:radio[name='tasktype'][value="+data.cstsdatavo.tasktype+"]").attr("checked",true);
$("input:radio[name='tasktype'][checked]").parent().addClass("checked");
					$("input:radio[name='opetype'][value="+data.cstsdatavo.opetype+"]").attr("checked",true);
$("input:radio[name='opetype'][checked]").parent().addClass("checked");
					$("input:radio[name='clicktype'][value="+data.cstsdatavo.clicktype+"]").attr("checked",true);
$("input:radio[name='clicktype'][checked]").parent().addClass("checked");
					$("input:radio[name='agmodel'][value="+data.cstsdatavo.agmodel+"]").attr("checked",true);
$("input:radio[name='agmodel'][checked]").parent().addClass("checked");
					
					
					$("input:radio[name='pagemodel'][value="+data.cstsdatavo.pagemodel+"]").attr("checked",true);
$("input:radio[name='pagemodel'][checked]").parent().addClass("checked");
					
					$("input:radio[name='state'][value="+data.cstsdatavo.state+"]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
					$("input:radio[name='submitdata'][value="+data.cstsdatavo.submitdata+"]").attr("checked",true);
$("input:radio[name='submitdata'][checked]").parent().addClass("checked");
					
					
					$("input:radio[name='ingoresta'][value="+data.cstsdatavo.ingoresta+"]").attr("checked",true);
$("input:radio[name='ingoresta'][checked]").parent().addClass("checked");
					
					$("input:radio[name='moveto'][value="+data.cstsdatavo.moveto+"]").attr("checked",true);
$("input:radio[name='moveto'][checked]").parent().addClass("checked");
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.cstsdatavo);
			}
			}else{
						data.cstsdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cstsdatamodel.editformid).initForm(data.cstsdatavo);
						
						
						
						$("input:radio[name='tasktype'][value=]").attr("checked",true);
$("input:radio[name='tasktype'][checked]").parent().addClass("checked");
						$("input:radio[name='opetype'][value=]").attr("checked",true);
$("input:radio[name='opetype'][checked]").parent().addClass("checked");
						$("input:radio[name='clicktype'][value=1]").attr("checked",true);
$("input:radio[name='clicktype'][checked]").parent().addClass("checked");
						$("input:radio[name='agmodel'][value=0]").attr("checked",true);
$("input:radio[name='agmodel'][checked]").parent().addClass("checked");
						
						
						$("input:radio[name='pagemodel'][value=1]").attr("checked",true);
$("input:radio[name='pagemodel'][checked]").parent().addClass("checked");
						
						$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
						$("input:radio[name='submitdata'][value=0]").attr("checked",true);
$("input:radio[name='submitdata'][checked]").parent().addClass("checked");
						
						
						$("input:radio[name='ingoresta'][value=]").attr("checked",true);
$("input:radio[name='ingoresta'][checked]").parent().addClass("checked");
						
						$("input:radio[name='moveto'][value=5]").attr("checked",true);
$("input:radio[name='moveto'][checked]").parent().addClass("checked");
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.cstsdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cstsdatamodel.editformid).initForm(data.cstsdatavo);$("input:radio[name='tasktype'][value=]").attr("checked",true);
$("input:radio[name='tasktype'][checked]").parent().addClass("checked");$("input:radio[name='opetype'][value=]").attr("checked",true);
$("input:radio[name='opetype'][checked]").parent().addClass("checked");$("input:radio[name='clicktype'][value=1]").attr("checked",true);
$("input:radio[name='clicktype'][checked]").parent().addClass("checked");$("input:radio[name='agmodel'][value=0]").attr("checked",true);
$("input:radio[name='agmodel'][checked]").parent().addClass("checked");$("input:radio[name='pagemodel'][value=1]").attr("checked",true);
$("input:radio[name='pagemodel'][checked]").parent().addClass("checked");$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");$("input:radio[name='submitdata'][value=0]").attr("checked",true);
$("input:radio[name='submitdata'][checked]").parent().addClass("checked");$("input:radio[name='ingoresta'][value=]").attr("checked",true);
$("input:radio[name='ingoresta'][checked]").parent().addClass("checked");$("input:radio[name='moveto'][value=5]").attr("checked",true);
$("input:radio[name='moveto'][checked]").parent().addClass("checked");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
