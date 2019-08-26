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
	if(data.caadatavo && data.caadatavo.csiuiid){
		$("#csiuiid").val(data.caadatavo.csiuiid);
		$("#csiuiid").trigger("liszt:updated");
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
	if(data.caadatavo && data.caadatavo.catuiid){
		$("#catuiid").val(data.caadatavo.catuiid);
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
data["caadatamodel"] = {};
data.caadatamodel.refcode = "caa";
data.caadatamodel.searchurl = "/autoArticle/tolistdatarefin";
data.caadatamodel.addediturl = "/autoArticle/addedit";
data.caadatamodel.batchediturl = "/autoArticle/editbatch";
data.caadatamodel.editformid = "caadataform";
data.caadatamodel.sumbitbuttonid = "caasumbitbutton";

$("#caasumbitbutton").click(function(e) {
	if ("disabled" == $("#caasumbitbutton").attr("disabled")) {
		return;
	}
	$("#caasumbitbutton").attr("disabled","disabled");
	if(woformvalidate("caa")){
		data.caadatavo = $("#caadataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.caadatavo = setdefaultvalue(data.caadatavo);
		}
		updatecom(data.caadatavo.hasOwnProperty("requesturl")?data.caadatavo.requesturl:data.caadatamodel.addediturl,data.caadatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.caadatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#caasumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("caa");
}catch(e){console.log(e);}
		//生效开始时间编辑控件初始化脚本
		try{
$('#starttime').datetimepicker({
  format: "yyyy-mm-dd hh:ii:ss",
  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
});
}catch(e){console.log(e);}
		//生效结束时间编辑控件初始化脚本
		try{
$('#endtime').datetimepicker({
  format: "yyyy-mm-dd hh:ii:ss",
  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
});
}catch(e){console.log(e);}
	
			
			
									csiuiidtolistdata({});
			
			
									catuiidtolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/autoArticle/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.caadatavo = response.data.list[0];
$("#"+data.caadatamodel.editformid).initForm(data.caadatavo);
					try{
if(data.caadatavo && data.caadatavo.csiuiid){
	if(!(data.csiuiidList && data.csiuiidList.length > 0)){
		$("#csiuiid").append("<option value='"+data.caadatavo.csiuiid+"'>"+data.caadatavo.csiuiidrefview+"</option>");
	}
	$("#csiuiid").val(data.caadatavo.csiuiid);
dealrefnext("caa","csiuiid",data.caadatavo.csiuiid);
	$("#csiuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					try{
if(data.caadatavo && data.caadatavo.catuiid){
	if(!(data.catuiidList && data.catuiidList.length > 0)){
		$("#catuiid").append("<option value='"+data.caadatavo.catuiid+"'>"+data.caadatavo.catuiidrefview+"</option>");
	}
	$("#catuiid").val(data.caadatavo.catuiid);
dealrefnext("caa","catuiid",data.caadatavo.catuiid);
	$("#catuiid").trigger("liszt:updated");
}
}catch(e){console.log(e);}
					
					
					data.imgsfile = initeditfile("imgsfile","","","","","0","0",
"2000","2000",response.data.list[0].imgs,"1","https://wolv.oss-cn-beijing.aliyuncs.com/");
					data.vidiofile = initeditfile("vidiofile","","","","","0","0",
"2000","2000",response.data.list[0].vidio,"1","https://wolv.oss-cn-beijing.aliyuncs.com/");
					$("input:radio[name='state'][value="+data.caadatavo.state+"]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
					
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.caadatavo);
			}
			}else{
						data.caadatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.caadatamodel.editformid).initForm(data.caadatavo);
						
						
						
						
						data.imgsfile = initaddfile("imgsfile","","","","","0","0","2000","2000");
						data.vidiofile = initaddfile("vidiofile","","","","","0","0","2000","2000");
						$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
						
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.caadatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.caadatamodel.editformid).initForm(data.caadatavo);data.imgsfile = initaddfile("imgsfile","","","","","0","0","2000","2000");data.vidiofile = initaddfile("vidiofile","","","","","0","0","2000","2000");$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
