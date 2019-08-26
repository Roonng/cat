//全局数据对象
var data = {};

	//用户角色编码编辑控件初始化脚本
	function menuroletolistdata(param){
	initselect2_inputtags_url("/wo/run/getroles","menurole","用户角色编码","uiid","title",{},function(select2obj){
try {
	data.select2menurole = select2obj;
		data.select2menurole.val(eval("[\""+ 
				((data.cuidatavo && data.cuidatavo.menurole) ? data.cuidatavo.menurole: "").replace(new RegExp(",","g"),"\",\"")+ "\"]")
		).trigger("change");
	} catch (e) {console.log(e);}
});
	}

/**
 * 页面准备OK自动执行
 */
jQuery(document).ready(function() {
	if($("#alertinfo") && $("#alertinfo").html() != ""){$("#alertinfo").parent().show();}//业务提示不为空，显示业务提示信息面板
	
		//编辑form控件，带数据项权限控制编辑控件初始化脚本
		try{
data["cuidatamodel"] = {};
data.cuidatamodel.refcode = "cui";
data.cuidatamodel.searchurl = "/userInfo/tolistdatarefin";
data.cuidatamodel.addediturl = "/userInfo/addedit";
data.cuidatamodel.batchediturl = "/userInfo/editbatch";
data.cuidatamodel.editformid = "cuidataform";
data.cuidatamodel.sumbitbuttonid = "cuisumbitbutton";

$("#cuisumbitbutton").click(function(e) {
	if ("disabled" == $("#cuisumbitbutton").attr("disabled")) {
		return;
	}
	$("#cuisumbitbutton").attr("disabled","disabled");
	if(woformvalidate("cui")){
		data.cuidatavo = $("#cuidataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.cuidatavo = setdefaultvalue(data.cuidatavo);
		}
		updatecom(data.cuidatavo.hasOwnProperty("requesturl")?data.cuidatavo.requesturl:data.cuidatamodel.addediturl,data.cuidatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.cuidatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#cuisumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("cui");
}catch(e){console.log(e);}
		//注册时间编辑控件初始化脚本
		try{
$('#starttime').datetimepicker({
  format: "yyyy-mm-dd hh:ii:ss",
  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
});
}catch(e){console.log(e);}
	
			
			
									menuroletolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/userInfo/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.cuidatavo = response.data.list[0];
$("#"+data.cuidatamodel.editformid).initForm(data.cuidatavo);
					
					
					
					
					
					$("input:radio[name='debugrole'][value="+data.cuidatavo.debugrole+"]").attr("checked",true);
$("input:radio[name='debugrole'][checked]").parent().addClass("checked");
					$("input:radio[name='autorole'][value="+data.cuidatavo.autorole+"]").attr("checked",true);
$("input:radio[name='autorole'][checked]").parent().addClass("checked");
					(data.select2name && data.select2name != undefined)?data.select2menurole.val(eval("[\""+((data.cuidatavo && data.cuidatavo.menurole)?data.cuidatavo.menurole:"").replace(new RegExp(",","g"),"\",\"")+"\"]")).trigger("change"):"";

					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.cuidatavo);
			}
			}else{
						data.cuidatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cuidatamodel.editformid).initForm(data.cuidatavo);
						
						
						
						
						
						$("input:radio[name='debugrole'][value=0]").attr("checked",true);
$("input:radio[name='debugrole'][checked]").parent().addClass("checked");
						$("input:radio[name='autorole'][value=0]").attr("checked",true);
$("input:radio[name='autorole'][checked]").parent().addClass("checked");
						(data.select2menurole && data.select2menurole != undefined)?data.select2menurole.val([]).trigger("change"):"";
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.cuidatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cuidatamodel.editformid).initForm(data.cuidatavo);$("input:radio[name='debugrole'][value=0]").attr("checked",true);
$("input:radio[name='debugrole'][checked]").parent().addClass("checked");$("input:radio[name='autorole'][value=0]").attr("checked",true);
$("input:radio[name='autorole'][checked]").parent().addClass("checked");(data.select2menurole && data.select2menurole != undefined)?data.select2menurole.val([]).trigger("change"):"";
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
