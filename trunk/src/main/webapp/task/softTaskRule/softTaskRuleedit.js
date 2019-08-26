//全局数据对象
var data = {};

	//步骤标题编辑控件初始化脚本
	function cstsuiidtolistdata(param){
	updatecom("/softTaskStep/tolistdata",param,function(response){//树形数据下拉
	try{
	$("#cstsuiid").empty();
	$("#cstsuiid").append("<option value=''>请选择</option>");
	data.cstsuiidList = response.data.list;
	var treedata = transData(response.data.list,"uiid","","child");
	$.each(treedata, function(i, n) {
		if(undefined != n.child && n.child.length != 0){
			$("#cstsuiid").append("<optgroup label=\"" + n["title"] + "\"></optgroup>");
			loudmoreoption(n,n.child,"cstsuiid","uiid","title");
		}else{
			$("#cstsuiid").append("<option value='" + n["uiid"] + "'>"+ getloudmoreoption(n,"title") + "</option>");
		}
	});
	$("#cstsuiid").chosen({allow_single_deselect: true});
	if(data.cstrdatavo && data.cstrdatavo.cstsuiid){
		$("#cstsuiid").val(data.cstrdatavo.cstsuiid);
		$("#cstsuiid").trigger("liszt:updated");
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
data["cstrdatamodel"] = {};
data.cstrdatamodel.refcode = "cstr";
data.cstrdatamodel.searchurl = "/softTaskRule/tolistdatarefin";
data.cstrdatamodel.addediturl = "/softTaskRule/addedit";
data.cstrdatamodel.batchediturl = "/softTaskRule/editbatch";
data.cstrdatamodel.editformid = "cstrdataform";
data.cstrdatamodel.sumbitbuttonid = "cstrsumbitbutton";

$("#cstrsumbitbutton").click(function(e) {
	if ("disabled" == $("#cstrsumbitbutton").attr("disabled")) {
		return;
	}
	$("#cstrsumbitbutton").attr("disabled","disabled");
	if(woformvalidate("cstr")){
		data.cstrdatavo = $("#cstrdataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.cstrdatavo = setdefaultvalue(data.cstrdatavo);
		}
		updatecom(data.cstrdatavo.hasOwnProperty("requesturl")?data.cstrdatavo.requesturl:data.cstrdatamodel.addediturl,data.cstrdatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.cstrdatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#cstrsumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("cstr");
}catch(e){console.log(e);}
	
			
			
									cstsuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/softTaskRule/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.cstrdatavo = response.data.list[0];
$("#"+data.cstrdatamodel.editformid).initForm(data.cstrdatavo);
					try{
if(data.cstrdatavo && data.cstrdatavo.cstsuiid){
	if(!(data.cstsuiidList && data.cstsuiidList.length > 0)){
		$("#cstsuiid").append("<option value='"+data.cstrdatavo.cstsuiid+"'>"+data.cstrdatavo.cstsuiidrefview+"</option>");
	}
	$("#cstsuiid").val(data.cstrdatavo.cstsuiid);
dealrefnext("cstr","cstsuiid",data.cstrdatavo.cstsuiid);
	$("#cstsuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					
					
					
					
					
					
					
					
					
					
					$("input:radio[name='state'][value="+data.cstrdatavo.state+"]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
					$("input:radio[name='locrel'][value="+data.cstrdatavo.locrel+"]").attr("checked",true);
$("input:radio[name='locrel'][checked]").parent().addClass("checked");
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.cstrdatavo);
			}
			}else{
						data.cstrdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cstrdatamodel.editformid).initForm(data.cstrdatavo);
						
						
						
						
						
						
						
						
						
						
						
						$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
						$("input:radio[name='locrel'][value=0]").attr("checked",true);
$("input:radio[name='locrel'][checked]").parent().addClass("checked");
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.cstrdatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cstrdatamodel.editformid).initForm(data.cstrdatavo);$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");$("input:radio[name='locrel'][value=0]").attr("checked",true);
$("input:radio[name='locrel'][checked]").parent().addClass("checked");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
