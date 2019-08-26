<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>运营云平台-登录</title>
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
	<link rel="stylesheet" type="text/css" href="media/css/login.css" />
	<script type="text/javascript">
        function login(loginAccount,loginPassword) {
            if(!(loginAccount && loginAccount != "" && loginAccount != "undefined")){
                loginAccount = $("#username").val();
                loginPassword = hex_md5($("#password").val());
            }
            updatecom("cat/login", {
                "loginAccount": loginAccount,
                "loginPassword": loginPassword
            }, function(response) {
                if(response.error_code == 10000){
                    var remmember = $("#remember").parent().hasClass("checked");
                    if(remmember){
                        myStorage.set("loginAccount",$("#username").val());
                        myStorage.set("loginPassword",hex_md5($("#password").val()));
                    }
					setCookie("cuiuiid",response.data.dhuuiid,10000);
                    myStorage.set("wspuiid",response.data.wspuiid);
                    myStorage.set("wsruiid"+response.data.wspuiid,response.data.wsruiid);
					window.location.href = "index.jsp";
                }else{
                    myStorage.remove("loginAccount");
                    myStorage.remove("loginPassword");
                    alert(response.error);
                }
            });
        }
        function register() {
            updatecom("develop/login", {"loginAccount":$("#username").val(),"loginPassword":hex_md5($("#password").val())}, function(response) {
                if(response.data && response.data.uiid && response.data.uiid != ""){
                    setCookie("wsuuiid",response.data.uiid,100);//当前登录用户uiid
                    setCookie("wspuiid",response.data.wspuiid,100);//默认项目uiid
                    setCookie("wsouiid",response.data.wsouiid,100);//公司uiid
                    setCookie("accesstoken",response.accesstoken,100);
                    setCookiech("username",response.data.name,10000);
                    window.location.href = "testStart.jsp";
                }else{
                    alert("登录信息不正确，请重新输入");
                }
            });
        }

        function gotoRegister (){
            document.getElementById('Login-form').style.display = 'none';
            document.getElementById('Register-form').style.display = 'block';
        }
        function gotologin (){
            document.getElementById('Login-form').style.display = 'block';
            document.getElementById('Register-form').style.display = 'none';
        }

        var num;
        var jiajia=0;
        function IdentifyingCode(){
            jiajia++;
            console.log(jiajia);
            if(jiajia==1){
                num =2;
            }else if(jiajia==2){
                num = 4;
            }else if(jiajia==3){
                num = 6;
            }
            if(!num){
                $("#identifyingCode").html("不可获取");
                $("#identifyingCode").removeAttr('onclick');
                return;
            }
            var name =setInterval(function(){
                $("#identifyingCode").html(num+"秒后可重新获取");
                num--;
                if(num == 0){
                    $("#identifyingCode").html('请重新获取');
                    clearInterval(name);
                };

            },1000);
        }
	</script>
</head>
<body class="login">
<div class="logo">
	<div><img src='media/image/logo1.png'></div>
</div>
<div class="content">
	<!-- 用户登录form -->
	<form class="form-vertical login-form" id="Login-form">
		<h3 class="form-title">登录</h3>
		<div class="alert alert-error hide">
			<button class="close" data-dismiss="alert"></button>
			<span>请输入账号密码.</span>
		</div>
		<div class="control-group">
			<input type="text" id="username" value="" placeholder="请输入登录账号">
		</div>
		<div class="control-group">
			<input type="password" id="password" name="password" placeholder="请输入密码">
		</div>
		<div class="control-group" style="display:none;">
			<input type="text" placeholder="请输入验证码" class="input_">
			<p class="identifying-code"  id="identifyingCode"   onclick ="IdentifyingCode();">获取验证码</p>
		</div>
		<div class="form-actions">
			<label class="checkbox"> <input type="checkbox" id="remember" name="remember" value="0" /> 记住登录信息 </label>
			<div class="_btn"><button onclick="login()" >登录</button></div>
			<p class="forget-password"><a>忘记密码</a></p>
			<p class="forget_password "><a>没有账号？</a><a class="register" id="register_"  onclick ="gotoRegister();">注册</a></p>
		</div>
	</form>
	<form class="form-vertical forget-form" action="">
		<h3 class="">忘记密码</h3>
		<p>请输入注册账号重设密码。</p>
		<div class="control-group">
			<div class="controls">
				<div class="input-icon left">
					<i class="icon-envelope"></i> <input class="m-wrap placeholder-no-fix" type="text" placeholder="Email" name="email" />
				</div>
			</div>
		</div>
		<div class="form-actions">
			<button type="button" id="back-btn" class="btn">
				<i class="m-icon-swapleft"></i> 后退
			</button>
			<button type="submit" class="btn green pull-right">
				提交 <i class="m-icon-swapright m-icon-white"></i>
			</button>
		</div>
	</form>


	<!-- 用户注册form -->
	<form class="form-vertical register-form" action=""  id="Register-form">
		<h3 class="">注册</h3>
		<div class="control-group">
			<input id="registerusername" name="registerusername" type="text"  placeholder="手机号">
		</div>
		<div class="control-group">
			<input type="text" placeholder="请输入验证码" class="identifyingCode">
			<p class="identifying-code">获取验证码</p>
		</div>
		<div class="control-group">
			<input type="text"  placeholder="请输入用户名">
		</div>
		<div class="control-group">
			<input type="password" id="registerpassword" name="registerpassword"  placeholder="请输入6-12位数字或字母密码">
		</div>
		<div class="control-group">
			<input type="password" id="confirmpassword" name="confirmpassword"  placeholder="确认密码">
		</div>
		<div class="form-actions">
			<div class="_btn"><button onclick="register()">注册</button></div>
			<p class="forget_password "><a>已有账号，</a><a class="register"  id="Login_"  onclick ="gotologin();">去登录</a></p>
		</div>
	</form>
</div>
<div class="copyright">2018 &copy; 湖南小柿信息科技有限公司.</div>
<script type="text/javascript" src="media/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="media/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="media/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="media/js/bootstrap.min.js"></script>
<script src="media/js/excanvas.min.js"></script>
<script src="media/js/respond.min.js"></script>
<script type="text/javascript" src="media/js/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="media/js/jquery.blockui.min.js"></script>
<script type="text/javascript" src="media/js/jquery.cookie.min.js"></script>
<script type="text/javascript" src="media/js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="media/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="media/js/app.js"></script>
<script type="text/javascript" src="media/js/md5.js"></script>
<script type="text/javascript" src="media/js/login.js"></script>
<script type="text/javascript" src="js/develop.js"></script>
<script type="text/javascript" src="js/myStorage.js"></script>
<script>
    jQuery(document).ready(function() {
        App.init();
        Login.init();
        if(myStorage.get("loginAccount") && myStorage.get("loginAccount") != "" && myStorage.get("loginAccount") != "undefined"){
            login(myStorage.get("loginAccount"),myStorage.get("loginPassword"));
        }
    });
    $(document).keydown(function (event) {
        if (event.keyCode == 13) {
            login();
        }
    });
</script>
</body>
</html>