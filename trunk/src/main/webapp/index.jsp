<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js" style="overflow: hidden;">
<head>
	<meta charset="utf-8" />
	<title>运营云平台</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="media/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="media/css/bootstrap-responsive.min.css" />
	<link rel="stylesheet" type="text/css" href="media/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="media/css/style-metro.css" />
	<link rel="stylesheet" type="text/css" href="media/css/style.css" />
	<link rel="stylesheet" type="text/css" href="media/css/style-responsive.css" />
	<link rel="stylesheet" type="text/css" href="media/css/default.css" id="style_color" />
	<link rel="stylesheet" type="text/css" href="media/css/uniform.default.css" />
	<link rel="stylesheet" type="text/css" href="media/css/jquery.gritter.css" />
	<link rel="stylesheet" type="text/css" href="media/css/daterangepicker.css" />
	<link rel="stylesheet" type="text/css" href="media/css/fullcalendar.css" />
	<link rel="stylesheet" type="text/css" href="media/css/jqvmap.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="media/css/jquery.easy-pie-chart.css" media="screen" />
</head>
<body class="page-header-fixed">
<div class="header navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="brand" href="javascript:void(0);" target="_blank">
				<img src="media/image/logo1.png" alt="logo" class="logo_" />
			</a>
			<div class="title_">
				<ul class="title-one">
					<li onclick="javascript:window.open('http://market.xiaoshikuaidi.net/');">
						<i class='icon-cogs' style='float:left;margin-top: 3px;margin-left: 18px;color:white;'></i>营销系统
					</li>
					<li onclick="javascript:window.open('http://pay.xiaoshikuaidi.net/');">
						<i class='icon-jpy' style='float:left;margin-top: 3px;margin-left: 18px;color:white;'></i>支付系统
					</li>
				</ul>
				<ul class="nav pull-right">
					<li class="dropdown" id="header_notification_bar">
						<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-warning-sign"></i> <span class="badge">0</span> </a>
						<ul class="dropdown-menu extended notification">
							<li><p>你有0条通知消息</p></li>
							<li class="external"><a href="javascript:void(0);">查看全部通知消息<i class="m-icon-swapright"></i></a></li>
						</ul>
					</li>
					<li class="dropdown" id="header_inbox_bar">
						<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-envelope"></i><span id="header_inbox_content_newcount" class="badge">0</span> </a>
						<ul id="header_inbox_content" class="dropdown-menu extended inbox">
							<li id="header_inbox_content_top" style="width: 533px;position:absolute;top:0;"><p> 你有<span id="header_inbox_content_count">0</span>条新信息</p></li>
							<li id="header_inbox_content_footer" class="external" style="width: 226px;height:243px;position:absolute;top:40px;"><a href="javascript:void(0);">查看全部信息<i class="m-icon-swapright"></i></a></li>
						</ul>
					</li>
					<li class="dropdown" id="header_task_bar">
						<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-tasks"></i> <span class="badge">0</span> </a>
						<ul class="dropdown-menu extended tasks">
							<li><p>你有0项代办事项</p></li>
							<li class="external"><a href="javascript:void(0);">查看全部代办事项<i class="m-icon-swapright"></i> </a></li>
						</ul>
					</li>
					<select id="projectuiid" onblur="resetcurrentproject(this)" style="margin-right:10px;margin-top:6px;">
						<option value="">未获取到公司信息</option>
					</select>
					<li class="dropdown user">
						<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"> <img alt="" src=""/><span id="username" class="username">加载中</span> <i class="icon-angle-down"></i> </a>
						<ul class="dropdown-menu">
							<li><a href="javascript:void(0);"><i class="icon-user"></i>我的业绩</a></li>
							<li><a href="javascript:void(0);"><i class="icon-calendar"></i>我的日程表</a></li>
							<li><a href="javascript:void(0);"><i class="icon-envelope"></i>我的收信箱（0）</a></li>
							<li><a href="javascript:void(0);"><i class="icon-tasks"></i>我的任务</a></li>
							<li class="divider"></li>
							<li><a href="javascript:void(0);"><i class="icon-lock"></i>锁屏</a></li>
							<li><a href="javascript:goout();"><i class="icon-key"></i>退出</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<a href="javascript:void(0);" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse"> <img src="../media/image/menu-toggler.png" alt="" /> </a>
		</div>
	</div>
</div>
<div class="page-container">
	<div class="page-sidebar nav-collapse collapse" style="overflow-y: auto;">
		<ul class="page-sidebar-menu" id="indexmenulist"></ul>
	</div>
	<div class="page-content">
		<div id="portlet-config" class="modal hide">
			<div class="modal-header">
				<button data-dismiss="modal" class="close" type="button"></button>
				<h3>Widget Settings</h3>
			</div>
			<div class="modal-body">Widget settings form goes here</div>
		</div>
		<div class="container-fluid mainworkspace" style="height: 700px;padding-right: 0px;padding-left: 0px;">
			<div id="dashboard" style="width:100%;height:100%;">
				<iframe id="targetframe" src="/media/welcome.html" style="width:100%;height:100%;border-width: 0px;"></iframe>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="media/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="media/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="media/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="media/js/bootstrap.min.js"></script>
<script type="text/javascript" src="media/js/excanvas.min.js"></script>
<script type="text/javascript" src="media/js/respond.min.js"></script>
<script type="text/javascript" src="media/js/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="media/js/jquery.blockui.min.js"></script>
<script type="text/javascript" src="media/js/jquery.cookie.min.js"></script>
<script type="text/javascript" src="media/js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="media/js/jquery.vmap.js"></script>
<script type="text/javascript" src="media/js/jquery.vmap.russia.js"></script>
<script type="text/javascript" src="media/js/jquery.vmap.world.js"></script>
<script type="text/javascript" src="media/js/jquery.vmap.europe.js"></script>
<script type="text/javascript" src="media/js/jquery.vmap.germany.js"></script>
<script type="text/javascript" src="media/js/jquery.vmap.usa.js"></script>
<script type="text/javascript" src="media/js/jquery.vmap.sampledata.js"></script>
<script type="text/javascript" src="media/js/jquery.flot.js"></script>
<script type="text/javascript" src="media/js/jquery.flot.resize.js"></script>
<script type="text/javascript" src="media/js/jquery.pulsate.min.js"></script>
<script type="text/javascript" src="media/js/date.js"></script>
<script type="text/javascript" src="media/js/daterangepicker.js"></script>
<script type="text/javascript" src="media/js/jquery.gritter.js"></script>
<script type="text/javascript" src="media/js/fullcalendar.min.js"></script>
<script type="text/javascript" src="media/js/jquery.easy-pie-chart.js"></script>
<script type="text/javascript" src="media/js/jquery.sparkline.min.js"></script>
<script type="text/javascript" src="media/js/app.js"></script>
<script type="text/javascript" src="media/js/index.js"></script>
<script type="text/javascript" src="js/jquery.serializejson.js"></script>
<script type="text/javascript" src="js/develop.js"></script>
<script type="text/javascript" src="js/socket.js"></script>
<script type="text/javascript" src="js/myStorage.js"></script>
<script>
    /**
     * 获取首页菜单列表
     */
    function getindex1menugroup() {
        var searchobj = {};
        var wsruiid = myStorage.get("wsruiid"+myStorage.get("wspuiid"));
        if(wsruiid && wsruiid != "" && wsruiid !="undefined"){
            searchobj.stype = "2";
            searchobj.rolesuiid = wsruiid;
        }else{
            searchobj.stype = "1";
        }
        updatecom("/wo/run/getmenus",searchobj,function(response) {
            console.log(response);
            if (response.error_code == "10000") {
                $("#indexmenulist").empty();
                var _menuschildlink = $('\
											<li>\
												<form class="sidebar-search">\
													<div class="sidebar-toggler hidden-phone"></div>\
													<div class="input-box">\
														<a href="javascript:;" class="remove"></a> <input type="text" placeholder="搜索..." /> <input type="button" class="submit" value=" " />\
													</div>\
												</form>\
											</li>\
											<li class="start active "><a href="javascript:settargetframe(this,\'\');"> <i class="icon-home"></i> <span class="title">管理驾驶舱</span> <span class="selected"></span> </a></li>\
											');
                $("#indexmenulist").append(_menuschildlink);
                showstarmenu(response.data);
                var json = transData(response.data, "uiid", "parentId", "children");
                showall(json);
                App.init();
                Index.init();
                if (getCookie("currentmenulink"+getCookie("wspuiid")) != "" && getCookie("currentmenulink"+getCookie("wspuiid")) != undefined && getCookie("currentmenulink"+getCookie("wspuiid")) != "undefined") {
                    document.getElementById("targetframe").src = getCookie("currentmenulink");
                    $("#" + getCookie("currentmenuuiid"+getCookie("wspuiid"))).css('background-color', 'green');
                    $("#" + getCookie("currentmenuuiid"+getCookie("wspuiid"))).parent().parent().css('display', 'block');
                    $("#" + getCookie("currentmenuuiid"+getCookie("wspuiid"))).parent().parent().parent().addClass("open");
                }
            } else {
                //location.href = "/login.jsp";
            }
        });
    }

    /**
     * 获取当前用户授权的全部项目列表
     */
    function getProjectList() {
        updatecom("wo/run/searchlist/getPaySystemInfo", {"puuiid" : getCookie("puuiid")
        }, function(response) {
            if(response.error_code == 10000){
                $("#projectuiid").empty();
                response.data.forEach(function(n, i) {
                    $("#projectuiid").append("<option value=\""+n.pcauiid+"\">" + n.pcaname + "</option>");
                });
                $("#projectuiid").val(getCookie("pcauiid"));
            }else{
                console.log("获取当前用户授权的全部项目列表失败");
            }
        });
    }
    /**
     * 重设当前操作的项目id
     */
    function resetcurrentproject(element) {
        var pcauiid = $(element).val();
        setCookie("pcauiid", pcauiid, 10000);//默认项目uiid
        setObjCookie("globalvisibale","pcauiid",pcauiid,10000);
    }

    /**
     * 菜单链接跳转
     * @param targetlink 目标菜单
     */
    function settargetframe(currentmenudiv, targetuiid, targetlink) {
        if (targetlink == "" || targetlink == "null") {
        } else {
            document.getElementById("targetframe").src = varbasePath + targetlink;
            {
                $("#" + getCookie("currentmenuuiid"+getCookie("wspuiid"))).removeAttr("style");
                if($("#" + getCookie("currentmenuuiid"+getCookie("wspuiid"))).parent().parent().attr("id") != "indexmenulist"){
                    $("#" + getCookie("currentmenuuiid"+getCookie("wspuiid"))).parent().parent().css('display', 'none');
                    $("#" + getCookie("currentmenuuiid"+getCookie("wspuiid"))).parent().parent().parent().removeClass("open");
                }
            }
            setCookie("currentmenuuiid"+getCookie("wspuiid"), targetuiid, 1);
            setCookie("currentmenulink"+getCookie("wspuiid"), targetlink, 1);

            $("#" + getCookie("currentmenuuiid"+getCookie("wspuiid"))).css('background-color','green');
            $("#" + getCookie("currentmenuuiid"+getCookie("wspuiid"))).parent().parent().css('display', 'block');
            $("#" + getCookie("currentmenuuiid"+getCookie("wspuiid"))).parent().parent().parent().addClass("open");

            $("#targetframe").load(
                function() {
                    document.title = $('#targetframe').contents().attr("title");
                });
        }
    }
    /**
     *  输出当前用户收藏的菜单
     */
    function showstarmenu(menulist) {
        menulist.forEach(function(n, i) {
            if (n.self && n.self == "1") {
                var _menuschildlink = $("<li ><i class='"+n.wsfeuiid+"' style='float:left;margin-top: 9px;margin-left: 18px;color:#999;;''></i><a id='"
                    + n.uiid
                    + "' href='javascript:settargetframe($(this).index(),\""
                    + n.uiid
                    + "\",\""
                    + n.link
                    + "\");'>"
                    + n.title
                    + " </a><span onclick=\"removestar('"
                    + n.uiid
                    + "')\" class=\"icon-star _xingxing\" style='float:right;margin-right:14px;margin-top: -21px;color: #e6e6e6;font-size: 14px;'></span></li>");
                $("#indexmenulist").append(_menuschildlink);
            }
        });
    }
    /**
     *  移除收藏的菜单
     */
    function removestar(menuuiid) {
        updatecom("sysSelfMenuSet/deletea", {
            "wsuuiid" : getCookie("wsuuiid"),
            "wsmuiid" : menuuiid
        }, function(response) {
            if (response.error_code == 10000) {
                getindex1menugroup();
            }
        });
    }
    /**
     *  添加收藏的菜单
     */
    function addstar(menuuiid) {
        updatecom("sysSelfMenuSet/save", {
            "wsuuiid" : getCookie("wsuuiid"),
            "wsmuiid" : menuuiid
        }, function(response) {
            if (response.error_code == 10000) {
                getindex1menugroup();
            }
        });
    }

    /**
     * 通过json对象构建nestable树
     */
    function showall(menu_list) {
        for ( var menu in menu_list) {
            if (menu_list[menu].children != undefined) {
                var $_menus = $("<li class=\"\"></li>");
                var $_menuslink = $("<a href=\"javascript:;\"></a>");
                $_menuslink.append("<i class=\"icon-cogs\"></i> ");
                $_menuslink
                    .append("<span id='"+menu_list[menu].uiid+"' class=\"title\">"
                        + menu_list[menu].title + "</span>");
                $_menuslink.append("<span class=\"arrow \"></span>");
                $_menus.append($_menuslink);
                var $_menuschilds = $("<ul class=\"sub-menu\"></ul>");
                for ( var children in menu_list[menu].children) {//menu_list[menu].children[children].link
                    if (!(menu_list[menu].children[children].self && menu_list[menu].children[children].self == "1")) {
                        var _menuschildlink = $("<li ><i class='icon-cogs' style='float:left;margin-top: 9px;margin-left: 18px;color:#999;;''></i><a id='"
                            + menu_list[menu].children[children].uiid
                            + "' href='javascript:settargetframe($(this).index(),\""
                            + menu_list[menu].children[children].uiid
                            + "\",\""
                            + menu_list[menu].children[children].link
                            + "\");'>"
                            + menu_list[menu].children[children].title
                            + " </a><span onclick=\""
                            + ((menu_list[menu].children[children].self && menu_list[menu].children[children].self == "1") ? "removestar"
                                : "addstar")
                            + "('"
                            + menu_list[menu].children[children].uiid
                            + "')\" class=\""
                            + ((menu_list[menu].children[children].self && menu_list[menu].children[children].self == "1") ? "icon-star"
                                : "icon-star-empty")
                            + " _xingxing\" style='float:right;margin-right:14px;margin-top: -21px;color: #e6e6e6;font-size: 14px;'></span></li>");
                        $_menuschilds.append(_menuschildlink);
                    }
                }
                $_menus.append($_menuschilds);
                $("#indexmenulist").append($_menus);
            } else {
                if (!(menu_list[menu].self && menu_list[menu].self == "1")) {
                    var $_menu = $("<li class=\"\"><a id='"
                        + menu_list[menu].uiid
                        + "' href=\"javascript:settargetframe($(this).index(),'"
                        + menu_list[menu].uiid
                        + "','"
                        + menu_list[menu].link
                        + "');\"><i class=\"icon-bar-chart\"></i><span class=\"title\">"
                        + menu_list[menu].title + "</span></a></li>");
                    //<span onclick=\"collectmenu('"+menu_list[menu].uiid+"')\"><i class=\"icon-star-empty\"></i></span>
                    $("#indexmenulist").append($_menu);
                }
            }
        }
    }

    function collectmenu(wsmuiid) {
        updatecom("sysSelfMenuSet/save", {
            "wsmuiid" : wsmuiid,
            "wsuuiid" : getCookiech("wsuuiid")
        }, function(response) {
            console.log(response);
        });
    }

    /**
     * 调整当前页面各元素宽度、高度
     */
    function resizeindex() {
        //console.log("整个页面高度"+window.innerHeight);
        var height_header = $("div.header.navbar.navbar-inverse.navbar-fixed-top").outerHeight(true);//页面顶部信息栏高度
        //console.log("页面顶部信息栏高度"+height_header);
        var bodyheight = window.innerHeight - height_header;//整个页面内容高度，body高度-顶部信息栏高度
        //console.log("整个页面内容高度，body高度-顶部信息栏高度"+bodyheight);
        //var height_divfooter = $("div.footer").outerHeight(true);//页面底部版权版本信息高度
        //console.log("页面底部版权版本信息高度"+height_divfooter);
        var divcontainerheight = bodyheight - 0;//嵌套页面高度
        //console.log("嵌套页面高度"+divcontainerheight);
        document.getElementsByTagName('body')[0].style.height = bodyheight + 'px';
        $("div.page-container").height(divcontainerheight);
        $("div.page-sidebar.nav-collapse.collapse").height(
            divcontainerheight);
        $("div.page-content").height(divcontainerheight);
        $("div.container-fluid.mainworkspace").height(divcontainerheight);
    }

    /**
     * 用户退出，清除cookie，跳转到登陆首页
     */
    function goout(){
        clearCookie("puuiid");//当前登录用户uiid
        clearCookie("pcauiid");//默认项目uiid
        clearCookie("puname");
        clearCookie("pcaname");
        clearCookie("accesstocken");
        clearCookie("globalvisibale");
        window.location.href = "login.jsp";
    }

    jQuery(document).ready(function() {
        resizeindex();
        $("#username").html(getCookiech("puname"));
        getindex1menugroup();
        // getProjectList();
    });
    $(window).resize(function() {
        resizeindex();
    });
</script>
</body>
</html>