//全局数据对象
var data = {};

	//软件名称编辑控件初始化脚本
	function csiuiidtolistdata(param){
	updatecom("/softInfo/tolistdata",param,function(response){//树形数据下拉
	try{
	$("#csiuiid").empty();
	$("#csiuiid").append("<option value=''>请选择</option>");
	data.csiuiidList = response.data.list;
	var treedata = transData(response.data.list,"uiid","","child");
	$.each(treedata, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#csiuiid").append("<optgroup label=\"" + n["title"] + "\"></optgroup>");
			loudmoreoption(n,n.child,"csiuiid","uiid","title");
		}else{
			$("#csiuiid").append("<option value='" + n["uiid"] + "'>"+ getloudmoreoption(n,"title") + "</option>");
		}
	});
	$("#csiuiid").chosen({allow_single_deselect: true});
	if(data.cstdatavo && data.cstdatavo.csiuiid){
		$("#csiuiid").val(data.cstdatavo.csiuiid);
		$("#csiuiid").trigger("liszt:updated");
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
data["cstdatamodel"] = {};
data.cstdatamodel.refcode = "cst";
data.cstdatamodel.searchurl = "/softTask/tolistdatarefin";
data.cstdatamodel.addediturl = "/softTask/addedit";
data.cstdatamodel.batchediturl = "/softTask/editbatch";
data.cstdatamodel.editformid = "cstdataform";
data.cstdatamodel.sumbitbuttonid = "cstsumbitbutton";

$("#cstsumbitbutton").click(function(e) {
	if ("disabled" == $("#cstsumbitbutton").attr("disabled")) {
		return;
	}
	$("#cstsumbitbutton").attr("disabled","disabled");
	if(woformvalidate("cst")){
		data.cstdatavo = $("#cstdataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.cstdatavo = setdefaultvalue(data.cstdatavo);
		}
		updatecom(data.cstdatavo.hasOwnProperty("requesturl")?data.cstdatavo.requesturl:data.cstdatamodel.addediturl,data.cstdatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.cstdatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#cstsumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("cst");
}catch(e){console.log(e);}
	
			
			
									csiuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/softTask/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.cstdatavo = response.data.list[0];
$("#"+data.cstdatamodel.editformid).initForm(data.cstdatavo);
					try{
if(data.cstdatavo && data.cstdatavo.csiuiid){
	if(!(data.csiuiidList && data.csiuiidList.length > 0)){
		$("#csiuiid").append("<option value='"+data.cstdatavo.csiuiid+"'>"+data.cstdatavo.csiuiidrefview+"</option>");
	}
	$("#csiuiid").val(data.cstdatavo.csiuiid);
dealrefnext("cst","csiuiid",data.cstdatavo.csiuiid);
	$("#csiuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					
					
					
					try{
$('#versionstr').tagsInput({width: 'auto','onAddTag': function () {}});
}catch(e){console.log(e);}
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.cstdatavo);
			}
			}else{
						data.cstdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cstdatamodel.editformid).initForm(data.cstdatavo);
						
						
						
						
						$('#versionstr').tagsInput({width: 'auto','onAddTag': function () {}});
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.cstdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cstdatamodel.editformid).initForm(data.cstdatavo);$('#versionstr').tagsInput({width: 'auto','onAddTag': function () {}});
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
