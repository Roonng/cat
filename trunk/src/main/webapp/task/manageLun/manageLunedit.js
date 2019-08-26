//全局数据对象
var data = {};

	//产品编码编辑控件初始化脚本
	function ptypetolistdata(param){
	try{
data.select2ptype = $('#ptype').select2({
	placeholder : '请选择产品编码',
	tags : true,
	multiple : true,
	allowClear : true,
	language: "zh-CN",
	separator:",",
	data : []
});
}catch(e){console.log(e);}
	}

/**
 * 页面准备OK自动执行
 */
jQuery(document).ready(function() {
	if($("#alertinfo") && $("#alertinfo").html() != ""){$("#alertinfo").parent().show();}//业务提示不为空，显示业务提示信息面板
	
		//编辑form控件，带数据项权限控制编辑控件初始化脚本
		try{
data["cmldatamodel"] = {};
data.cmldatamodel.refcode = "cml";
data.cmldatamodel.searchurl = "/manageLun/tolistdatarefin";
data.cmldatamodel.addediturl = "/manageLun/addedit";
data.cmldatamodel.batchediturl = "/manageLun/editbatch";
data.cmldatamodel.editformid = "cmldataform";
data.cmldatamodel.sumbitbuttonid = "cmlsumbitbutton";

$("#cmlsumbitbutton").click(function(e) {
	if ("disabled" == $("#cmlsumbitbutton").attr("disabled")) {
		return;
	}
	$("#cmlsumbitbutton").attr("disabled","disabled");
	if(woformvalidate("cml")){
		data.cmldatavo = $("#cmldataform").serializeJson();
		if(typeof setdefaultvalue === "function"){
			data.cmldatavo = setdefaultvalue(data.cmldatavo);
		}
		updatecom(data.cmldatavo.hasOwnProperty("requesturl")?data.cmldatavo.requesturl:data.cmldatamodel.addediturl,data.cmldatavo,function(response){
			if(response.error_code && response.error_code == 10000){
				try{
				window.opener.top.frames['targetframe'].contentWindow.data.cmldatamodel.reloadtablelistdata();
				}catch(e1){console.log(e1);}
				window.close();
			}else{
				$("#cmlsumbitbutton").removeAttr("disabled");
				alert(response.error);
			}
		});
	}
});
checkeditform("cml");
}catch(e){console.log(e);}
	
			
			
									ptypetolistdata({});
	
	
	if(GetQueryString("uiid") != undefined && GetQueryString("uiid") != ""){
		updatecom("/manageLun/tolistdatarefin",{"uiid":GetQueryString("uiid")},function(response){
			if(response.data.list.length == 1){
					data.cmldatavo = response.data.list[0];
$("#"+data.cmldatamodel.editformid).initForm(data.cmldatavo);
					try{
data.select2ptype.val(eval("[\""+((data.cmldatavo && data.cmldatavo.ptype)?data.cmldatavo.ptype:"").replace(new RegExp(",","g"),"\",\"")+"\"]")).trigger("change");
}catch(e){console.log(e);}
					
					
					data.imgsfile = initeditfile("imgsfile","","","","","0","0",
"2000","2000",response.data.list[0].imgs,"1","https://wolv.oss-cn-beijing.aliyuncs.com/");
					data.vidiosfile = initeditfile("vidiosfile","","","","","0","0",
"2000","2000",response.data.list[0].vidios,"1","https://wolv.oss-cn-beijing.aliyuncs.com/");
					
					
					
					$("input:radio[name='state'][value="+data.cmldatavo.state+"]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
					
					
					
					
					
					
					
					
					
			if(typeof(editinitextend) != "undefined" && typeof(editinitextend) === "function"){
				editinitextend(data.cmldatavo);
			}
			}else{
						data.cmldatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cmldatamodel.editformid).initForm(data.cmldatavo);
						data.select2ptype.val([]).trigger("change");
						
						
						data.imgsfile = initaddfile("imgsfile","","","","","0","0","2000","2000");
						data.vidiosfile = initaddfile("vidiosfile","","","","","0","0","2000","2000");
						
						
						
						$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
						
						
						
						
						
						
						
						
						
				if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
					addinitextend();
				}
			}
		});
	}else{
		data.cmldatavo = JSON.parse(decodeURIComponent(GetQueryString("connectdata")));
$("#"+data.cmldatamodel.editformid).initForm(data.cmldatavo);data.select2ptype.val([]).trigger("change");data.imgsfile = initaddfile("imgsfile","","","","","0","0","2000","2000");data.vidiosfile = initaddfile("vidiosfile","","","","","0","0","2000","2000");$("input:radio[name='state'][value=0]").attr("checked",true);
$("input:radio[name='state'][checked]").parent().addClass("checked");
		if(typeof(addinitextend) != "undefined" && typeof(addinitextend) === "function"){
			addinitextend();
		}
	}
});
