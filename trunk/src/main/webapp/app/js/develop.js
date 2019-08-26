/**
 * 运行模式
 */
var runmodel = "test";
/**
 * 附件服务地址
 */
var fileserver = "";

/**
 * Created by Administrator on 2f015/10/31.
 * 实现类似jsp中<%=basePath%>的功能，获取项目根目录有助于url的填写
 * 使用方法，用类似引用jQuery的方法引入本插件
 * 定义一个全局的变量，然后的ready方法内部掉用本方法，获得basePath
 */
function basePath() {
    //获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp
    var curWwwPath = window.location.href;
    //获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
    var pathName = window.location.pathname;
    if ("/" == pathName) {
        return curWwwPath;
    }
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8080
    var localhostPath = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/ems
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1)+"/";
    //获取项目的basePath   http://localhost:8080/ems/
    // var basePath = localhostPath + "/";
    var basePath = localhostPath + projectName;
    return basePath;
};

/**
 * 当前页面的主域名请求地址，页面全局参数
 */
var varbasePath = "";
$(document).ready(
    function () {
        varbasePath = basePath();
    });

/**
 * json格式列表数据转JSON树状结构数据，找不到指定上级的，一律为顶级数据类型
 * @param   {json}      json数据
 * @param   {String}    id属性字段名称
 * @param   {String}    父id属性字段名称
 * @param   {String}    children数据集合属性名称
 * @return  {Array}     数组
 */
function transData(a, idStr, pidStr, chindrenStr) {
    var r = [], hash = {}, id = idStr, pid = pidStr, children = chindrenStr, i = 0, j = 0, len = a.length;
    for (; i < len; i++) {
        hash[a[i][id]] = a[i];
    }
    for (; j < len; j++) {
        var aVal = a[j], hashVP = hash[aVal[pid]];
        if (hashVP) {
            !hashVP[children] && (hashVP[children] = []);
            hashVP[children].push(aVal);
        } else {
            r.push(aVal);
        }
    }
    return r;
}

/**
 * 从当前页面请求地址中获取指定参数的值，不存在返回null
 * @param name
 * @returns
 */
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

/**
 * 获取url中的参数，并返回一个对象
 * @param ingorekey
 * @returns {___anonymous1390_1391}
 */
function getRequestData(ingorekey) {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = {};
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            if (ingorekey.indexOf(strs[i].split("=")[0]) == -1)
                theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
        }
    }
    return theRequest;
};

/**
 * 数据库驼峰字段名称转变量名称，自动移除前缀
 * @param str
 * @returns
 */
function transformStr3(str) {
    var re = /_(\w)/g;
    if (str.indexOf("_") != -1) {
        str = str.substr(str.indexOf("_") + 1);
    }
    return str.replace(re, function ($0, $1) {
        return $1.toUpperCase();
    });
}


/**
 * 生成一个带参数的url
 * @param obj
 * @returns   a=a&b=b&c=c 前端不会带第一个&，请自助添加？或&
 */
function createUrl(obj) {
    var length = obj && obj.length,
        idx = 0;
    //var url = obj.url + '?';
    var url = '';
    for (var key in obj) {
        if (key != 'url' && obj[key] !== null) {
            url += (key + '=' + encodeURIComponent(obj[key]) + '&');
        }
    }
    return url.substring(0, url.lastIndexOf('&'));
}

/**
 * 获取指定字符串的长度
 * @param str
 * @returns
 */
var GetLength = function (str) {
    ///<summary>获得字符串实际长度，中文2，英文1</summary>
    ///<param name="str">要获得长度的字符串</param>
    var realLength = 0, len = str.length, charCode = -1;
    for (var i = 0; i < len; i++) {
        charCode = str.charCodeAt(i);
        if (charCode >= 0 && charCode <= 128) realLength += 1;
        else realLength += 2;
    }
    return realLength;
};

//js截取字符串，中英文都能用
//如果给定的字符串大于指定长度，截取指定长度返回，否者返回源字符串。
//字符串，长度

/**
 * js截取字符串，中英文都能用
 * @param str：需要截取的字符串
 * @param len: 需要截取的长度
 */
function cutstr(str, len) {
    var str_length = 0;
    var str_len = 0;
    str_cut = new String();
    str_len = str.length;
    for (var i = 0; i < str_len; i++) {
        a = str.charAt(i);
        str_length++;
        if (escape(a).length > 4) {
            //中文字符的长度经编码之后大于4
            str_length++;
        }
        str_cut = str_cut.concat(a);
        if (str_length >= len) {
            str_cut = str_cut.concat(".");
            return str_cut;
        }
    }
    //如果给定字符串小于指定长度，则返回源字符串；
    if (str_length < len) {
        return str;
    }
}


/**
 * 声明获取图片的方法
 * @param {Object} picUrl 图片的网络地址
 * @param {Object} defaultPic 默认图片
 * @param {Object} element 图片源元素
 */
function fetchImage(picUrl, defaultPic, element) {
    //将图片网络地址进行md5摘要。
    var filename = hex_md5(picUrl);
    element.setAttribute("src", defaultPic);
    //尝试加载本地图片
    plus.io.resolveLocalFileSystemURL("_downloads/" + filename, function (entry) {
        // 加载本地图片成功
        entry.file(function (file) {
            if (file.size == 0) {
                //console.log("2.1图片为空显示默认");
                element.setAttribute("src", defaultPic);
            } else {
                var path = plus.io.convertLocalFileSystemURL("_downloads/" + filename);
                //console.log("2.1加载本地图片"+path);
                element.setAttribute("src", path);
            }
        });
    }, function (e) {
        //加载本地图片失败，本地没有该图片，尝试从网络下载图片并保存本地，保存文件名为url摘要md5值
        var dtask = plus.downloader.createDownload(picUrl, {filename: filename}, function (d, status) {
            // 下载完成
            if (status == 200) {
                if (d.downloadedSize == 0) {
                    //console.log("2.2图片为空显示默认");
                    element.setAttribute("src", defaultPic);
                } else {
                    //console.log("2.2下载网络文件成功"+d.url);
                    element.setAttribute("src", d.url);
                }
            }
        });
        dtask.start();
    });
}


/**
 * 设置cookie，不支持中文
 * @param cname
 * @param cvalue
 * @param exdays
 */
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires + ";path=/";
}

/**
 * 获取cookie，不支持中文
 * @param cname
 * @returns
 */
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1);
        if (c.indexOf(name) != -1){
            var cstrs = c.split("=");
            if(cstrs[0] == cname){
                return cstrs[1];
            }
        }
    }
    return "";
}

/**
 * 设置cookie，支持中文
 * @param cname
 * @param cvalue
 * @param exdays
 */
function setCookiech(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + encodeURIComponent(cvalue) + "; " + expires + ";path=/";
}

/**
 * 获取cookie，支持中文
 * @param cname
 * @returns
 */
function getCookiech(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1);
        if (c.indexOf(name) != -1)
            return decodeURIComponent(c.substring(name.length, c.length));
    }
    return "";
}

//清除cookie
function clearCookie(name) {
    setCookie(name, "", -1);
}

function checkCookie() {
    var user = getCookie("username");
    if (user != "") {
        toast("Welcome again " + user);
    } else {
        user = prompt("请输入账号名称:", "");
        if (user != "" && user != null) {
            setCookie("username", user, 365);
        }
    }
}

//返回上一页并刷新
function gobackpage() {
    history.go(-1);
    location.reload();
}


/**
 * 设置属性对象缓存
 */
function setObjCookie(globalkey, key, value, time) {
    var globalvisibale = $.cookie(globalkey);
    if (globalvisibale && globalvisibale != "") {
        var globalvisibaleobj = JSON.parse(globalvisibale);
        globalvisibaleobj[key] = value;
        setCookiech(globalkey, JSON.stringify(globalvisibaleobj), time);
    } else {
        var globalvisibaleobj = {};
        globalvisibaleobj[key] = value;
        setCookiech(globalkey, JSON.stringify(globalvisibaleobj), time);
    }
}

/**
 * 获取当前缓存的对象
 */
function getObjCookie(globalkey) {
    var globalvisibale = $.cookie(globalkey);
    if (globalvisibale && globalvisibale != "") {
        return JSON.parse(globalvisibale);
    } else {
        return {};
    }
}

/**
 * 获取当前缓存对象中的指定key值
 */
function getvalueCookie(globalkey, key) {
    var globalvisibale = $.cookie(globalkey);
    if (globalvisibale && globalvisibale != "") {
        var globalobj = JSON.parse(globalvisibale);
        if (globalobj[key] && globalobj[key] != "") {
            return globalobj[key];
        }
    }
    return "";
}

/**
 * 数据公用更新函数
 * updatecombeforeextend：数据操作提交前扩展，返回当前data对象
 * updatecomafterextend：数据操作返回后扩展，返回当前data对象
 * data.ingorecookie：存在，系统将不会自动附加wspuiid参数；未传入将自动附加wspuiid参数；
 * @param action
 * @param data
 * @param func
 */
function updatecom(action, data, func) {
    if (typeof(updatecombeforeextend) != "undefined" && typeof(updatecombeforeextend) === "function") {
        data = updatecombeforeextend(action, data, func);
    }
    var globalvisibale = getObjCookie("globalvisibale");
    if(Object.keys){
        Object.keys(globalvisibale).forEach(function (key) {
            var globalingoreaction = getObjCookie("globalingore")[action];
            if (globalingoreaction && globalingoreaction != "") {
                if (globalingoreaction.indexOf(key) != -1) {
                } else {
                    data[key] = globalvisibale[key];
                }
            } else {
                data[key] = globalvisibale[key];
            }
        });
    }
    data.accesstocken = getCookie("accesstocken");
    // data.ptype = getCookie("ptype");
    return $.ajax({
        type: "POST",
        url: ((action.substr(0,7).toLowerCase() == "http://" || action.substr(0,7).toLowerCase() == "https://") ? action : (varbasePath + action)),
        datatype: "JSON",
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        beforeSend: function (xhr) {
            xhr.setRequestHeader('accesstocken', getCookie('accesstocken'));
        },
        data: data,
        success: function (response) {
            if (typeof(updatecomafterextend) != "undefined" && typeof(updatecomafterextend) === "function") {
                response = updatecomafterextend(action, response, func);
            }
            // if (response.error_code == 10000) {
                func(response);
            // } else {
            //     if(response.error && response.error != "" && response.error != "undefined"){
            //         if ("gotologin" == response.error) {
            //             if (window.parent) {
            //                 window.parent.location.href = "/login.jsp";
            //             } else {
            //                 window.location.href = "/login.jsp";
            //             }
            //         } else if ("gotoerror" == response.error) {
            //             if (window.parent) {
            //                 window.parent.location.href = "/500.html";
            //             } else {
            //                 window.location.href = "/500.html";
            //             }
            //         } else {
            //             alert("错误编码:" + response.error_code + " " + response.error);
            //         }
            //     }else{
            //         if (window.parent) {
            //             window.parent.location.href = "/login.jsp";
            //         } else {
            //             window.location.href = "/login.jsp";
            //         }
            //     }
            // }
        }
    });
}

/**
 * 校验手机号是否合法
 * @param inputid
 * @returns {Boolean}
 */
function checkmobile(inputid) {
    if ($.trim($('#inputid').val()).length == 0) {
        toast("手机号没有输入");
        //$('#'+inputid).focus();
        return false;
    } else {
        var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if (!myreg.test($("#" + inputid).val())) {
            toast("请输入有效的手机号码！");
            return false;
        }
    }
    return true;
}

/**
 * 控件倒计时程序
 * @param buttonid 控件id，仅支持botton控件
 * @param nums1 倒计时时长
 * @param text1 默认显示文本
 * @param text2 倒计时文本
 */
function caltime(buttonid, nums1, text1, text2, func) {
    var clock = '';
    var nums = nums1;
    if ("button" == $("#" + buttonid)[0].localName) {
        $("#" + buttonid).attr("disabled", "true"); //将按钮置为不可点击
        $("#" + buttonid).text(nums + text2);
        clock = setInterval(
            function () {
                nums--;
                if (nums > 0) {
                    $("#" + buttonid).text(nums + text2);
                } else {
                    clearInterval(clock); //清除js定时器
                    $("#" + buttonid).removeAttr("disabled");
                    $("#" + buttonid).text(text1);
                    nums = nums1; //重置时间
                }
            }
            , 1000); //一秒执行一次
    } else if ("a" == $("#" + buttonid)[0].localName) {//暂未支持，需调整测试1111111111111111111111
        $("#" + buttonid).attr("disabled", "true"); //将按钮置为不可点击
        $("#" + buttonid).text(nums + text2);
        clock = setInterval(
            function () {
                nums--;
                if (nums > 0) {
                    $("#" + buttonid).text(nums + text2);
                } else {
                    clearInterval(clock); //清除js定时器
                    $("#" + buttonid).removeAttr("disabled");
                    $("#" + buttonid).text(text1);
                    nums = nums1; //重置时间
                }
            }
            , 1000); //一秒执行一次
    } else {
        toast("未支持的类型");
    }
}

/**
 * 控件自动禁用计时器，控件操作后禁用，指定时长后恢复可重复点击
 * @param buttonid 控件id，支持button，a控件
 * @param nums1 禁用时长
 * @param text1 倒计时显示文本，空表示不显示倒计时，不显示新文本，还是显示原有默认文本
 * @param text2 倒计时结束后显示文本，空表示不显示新文本，还是显示原有默认文本
 * @param func 控件计时结束后再次绑定的函数，a控件再次绑定，button该参数无效
 * 1、<a>超链接移除onclick绑定时间，1秒后在绑定上；
 * 2、<a>超链接移除href属性，1秒后在加上；
 * 3、
 */
function disable1sec(buttonid, nums1, text1, text2, func) {
    var clock = '';
    var nums = nums1;
    if ("button" == $("#" + buttonid)[0].localName) {
        $("#" + buttonid).attr("disabled", "true"); //将按钮置为不可点击
        //$("#"+buttonid).text(nums + text2);//不重设按钮文本
        clock = setInterval(
            function () {
                nums--;
                if (nums > 0) {
                    //$("#"+buttonid).text(nums + text2);//不重设按钮文本
                } else {
                    clearInterval(clock); //清除js定时器
                    $("#" + buttonid).removeAttr("disabled");
                    //$("#"+buttonid).text(text1);//不重设按钮文本
                    nums = nums1; //重置时间
                }
            }
            , 1000); //一秒执行一次
    } else if ("a" == $("#" + buttonid)[0].localName) {
        $("#" + buttonid).off('click');
        //$("#"+buttonid).text(nums + text2);////不重设按钮文本
        clock = setInterval(
            function () {
                nums--;
                if (nums > 0) {
                    //$("#"+buttonid).text(nums + text2);//不重设按钮文本
                } else {
                    clearInterval(clock); //清除js定时器
                    $("#" + buttonid).on('click', function () {
                        func();
                    });
                    //$("#"+buttonid).text(text1);//不重设按钮文本
                    nums = nums1; //重置时间
                }
            }
            , 1000); //一秒执行一次
    } else {
        toast("未支持的类型");
    }
}

/**
 * 延时执行执行的函数程序
 * @param nums1 延时时长
 * @param func 延时后执行的程序（匿名函数体）
 */
function delayexe(nums1, func) {
    var clock = '';
    var nums = nums1;
    clock = setInterval(
        function () {
            nums--;
            if (nums > 0) {
                //继续等待
            } else {
                clearInterval(clock); //清除js定时
                nums = nums1; //重置时间
                func();
            }
        }
        , 1000); //一秒执行一次
}

/**
 * 判断服务器指定资源是否存在
 * @param filepath
 * @returns {Boolean}
 */
function IsExistsFile(url) {
    try {
        var xmlhttp;
        if (window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome,Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else { // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.open("get", url, false);
        xmlhttp.send();
        if (xmlhttp.status == "404") {
            return false;
        } else {
            return true;
        }
    } catch (e) {
        return false;
    }
}

// 动态加载js并且判断是否加载完成
function addExtendScript(jsfile, callback) {
    try {
        var head = document.getElementsByTagName('head')[0];
        var script = document.createElement('script');
        script.type = 'text/javascript';
        script.src = jsfile;
        head.appendChild(script);
        script.onload = script.onreadystatechange = function () {
            if (!this.readyState || this.readyState === "loaded" || this.readyState === "complete") {
                script.onload = script.onreadystatechange = null;
                if (callback && typeof(callback) == 'function') {
                    callback();// window[callback]();如果传递字符串过来
                    // 调用window['函数名']() 调用方法

                }
            }
        };
    } catch (e) {
        console.log(e);
    }
}


/**
 * 获取下拉控件的数据并初始化控件
 * @param url 数据获取请求的地址
 * @param param 数据请求的参数，json格式
 * @param funcname 本次操作的函数名称，便于系统自动实施回调
 * @param datalist 全局数据data中变量的名称
 * @param comid 当前控件的id值
 * @param dataid 控件中写入值的字段名称
 * @param datavalue 控件中显示值的字段名称
 */
function baselist(url, param, funcname, datalist, comid, dataid, datavalue, initcom) {
    try {
        /**
         * 数据获取前调用扩展方法，
         1、用户可以动态调整数据请求的参数及请求地址
         2、可以选择完全自定义该实现函数，忽略该默认方法执行，请在返回参数中传入quit=true
         */
        if ((typeof extendfunc != "undefined") && typeof(extendfunc) == "function") {//开始数据请求前调用扩展方法
            param.func = funcname;
            param.stage = "beforeajax";
            param = extendfunc(param);
            if (param.hasOwnProperty("quit")) {
                if (param.quit == "true" || param.quit == true) {
                    return;
                }
            }
        }
        if (param.hasOwnProperty("url")) {
            url = param.url;
            delete param.url;
        }
        updatecom(url, param, function (response) {
            data[datalist] = response.data.list;
            /**
             * 数据获取成功后渲染前调用扩展方法，用户可以选择自定义渲染，不执行默认渲染方法请在返回参数中传入quit=true
             */
            if ((typeof extendfunc != "undefined") && typeof(extendfunc) == "function") {//数据获取完毕调用扩展方法
                var dataparam = {};
                dataparam.func = funcname;
                dataparam.stage = "afterajax";
                dataparam = extendfunc(dataparam);
                if (dataparam.hasOwnProperty("quit")) {
                    if (dataparam.quit == "true" || dataparam.quit == true) {
                        return;
                    }
                }
            }
            var selectoptionsize = $("#" + comid + "" + " option").size();
            var tagtext = "";
            if (selectoptionsize > 0) {
                tagtext = $($("#" + comid + "")[0]).text();
            }
            $("#" + comid + "").empty();
            $("#" + comid + "").append("<option value=''>" + tagtext + "</option>");
            $.each(data[datalist], function (i, n) {
                if (datavalue.indexOf(",") != -1) {
                    var strtemp = datavalue.split(",");
                    var strtitle = "";
                    $.each(strtemp, function (s, z) {
                        if (strtitle != "") {
                            strtitle += ",";
                        }
                        strtitle += n[z];
                    });
                    $("#" + comid + "").append("<option value='" + n[transformStr3(dataid)] + "'>" + strtitle + "</option>");
                } else {
                    $("#" + comid + "").append("<option value='" + n[transformStr3(dataid)] + "'>" + n[transformStr3(datavalue)] + "</option>");
                }
            });
            if (data.datavo && data.datavo[comid]) {
                $("#" + comid + "").val(data.datavo[comid]);
            }
            if (initcom && (typeof initcom == "function")) {//控件初始化完毕回调
                initcom();
            }
            if ((typeof extendfunc != "undefined") && typeof(extendfunc) == "function") {//控件渲染结束后调用扩展方法，可调整控件的默认值
                var dataparam = {};
                dataparam.func = funcname;
                dataparam.stage = "finishview";
                dataparam = extendfunc(dataparam);
                if (dataparam.hasOwnProperty("quit")) {
                    if (dataparam.quit == "true" || dataparam.quit == true) {
                        return;
                    }
                }
            }
        });
    } catch (e) {
        console.log(e);
    }
}

/**
 * 初始化远程数据源多选下拉控件
 * @param url 数据获取请求的地址
 * @param comid 当前控件的id值
 * @param comlabel 当前控件的提示标签
 * @param dataid 控件中写入值的字段名称
 * @param datavalue 控件中显示值的字段名称
 * @param param 数据请求的参数，json格式
 * @param funcname 本次操作的函数名称，便于系统自动实施回调
 */
function initselect2_inputtags_url(url, comid, comlabel, dataid, datavalue, param, funcname) {
    try {
        $.ajax({
            type: "POST",
            url: varbasePath + url + "?1=1",
            datatype: "JSON",
            beforeSend: function (xhr) {
                xhr.setRequestHeader('accesstocken', getCookie('accesstocken'));
            },
            data: param,
            success: function (response) {
                if (response.error_code == "10000") {
                    var dataarray = [];
                    response.data.forEach(function (n, i) {
                        var dataobj = {};
                        dataobj.id = n[dataid];
                        dataobj.text = getinitselect2_inputtags_urltitle(n, datavalue);
                        dataarray.push(dataobj);
                    });
                    var select2obj = $('#' + comid).select2({
                        placeholder: '请选择' + comlabel,
                        tags: true,
                        multiple: true,
                        allowClear: true,
                        language: "zh-CN",
                        separator: ",",
                        data: dataarray
                    });
                    if (funcname && (typeof funcname == "function")) {//控件初始化完毕回调
                        funcname(select2obj);
                    }
                } else {
                    alert(response.error);
                }
            }
        });
    } catch (e) {
        console.log(e);
    }
}

function getinitselect2_inputtags_urltitle(n, title) {
    if (title.indexOf(",") != -1) {
        var titlevalue = "";
        var titles = title.split(",");
        titles.forEach(function (nn, tt) {
            if (titlevalue != "") {
                titlevalue += ",";
            }
            titlevalue += n[nn];
        });
    } else {
        return n[title];
    }
}


/**
 * 当前数据编辑表单的统一校验函数
 * @param refcode 当前校验数据form控件关联数据表的外键标识符
 * @param e 当前数据校验申请的控件
 * @returns
 */
function woformvalidate(refcode, e) {
    if (e && e != "") {//仅校验当前单个数据项
        var tagname = $(e).prop("tagName");
        if (tagname && tagname == "INPUT") {
            var elementtype = $(e).attr("type");
            if (elementtype && elementtype == "text") {
                return checkInputText(refcode, e);
            }
            if (elementtype && elementtype == "number") {
                return checkInputNumber(refcode, e);
            }
        } else if (tagname && tagname == "SELECT") {
            return checkSelect(refcode, e);
        }
    } else {
        //未传入具体控件，全盘数据项校验
        var checkanswer = true;
        var dataparam = data[refcode + "datamodel"];
        $("form[id=" + dataparam.editformid + "] input[wsfnotnull=notnull]").each(function (n, obj) {
            var checkelement = $(obj);
            var elementtype = checkelement.attr("type");
            if (elementtype && elementtype == "text") {
                var csuccess = checkInputText(refcode, checkelement);
                if (!csuccess) {
                    checkanswer = false;
                }
            }
            if (elementtype && elementtype == "number") {
                var csuccess = checkInputNumber(refcode, checkelement);
                if (!csuccess) {
                    checkanswer = false;
                }
            }
            if (elementtype && elementtype == "email") {

            }
        });
        $("form[id=" + dataparam.editformid + "] select[wsfnotnull=notnull]").each(function (n, obj) {
            var check1 = obj;
            var csuccess = checkSelect(refcode, check1);
            if (!csuccess) {
                checkanswer = false;
            }
        });
    }
    return checkanswer;
}

/**
 * 校验文本输入框，字符串输入控件
 * @param e
 * @returns
 */
function checkInputText(refcode, e) {
    var checkelement = $(e);
    var wsfmin = checkelement.attr("wsfmin");//控件最少输入长度
    var wsfmax = checkelement.attr("wsfmax");//文本输入框最大长度
    var notnull = checkelement.attr("wsfnotnull");//是否允许数据项为空
    var datalength = checkelement.val().length;
    if (wsfmin && wsfmin != "") {
        if (parseInt(wsfmin) > parseInt(datalength)) {
            return setanswer(refcode, checkelement, false, "内容长度最少" + wsfmin + "个字符，目前已输入长度：" + datalength + "个字符");
        } else {
            return setanswer(refcode, checkelement, true, "");
        }
    }
    if (wsfmax && wsfmax != "") {
        if (parseInt(wsfmax) < parseInt(datalength)) {
            return setanswer(refcode, checkelement, false, "内容长度最多" + wsfmax + "个字符，目前已输入长度：" + datalength + "个字符");
        } else {
            return setanswer(refcode, checkelement, true, "");
        }
    }
    if (notnull && notnull != "") {
        if (parseInt(datalength) == 0) {
            return setanswer(refcode, checkelement, false, "该项为必填项！");
        } else {
            return setanswer(refcode, checkelement, true, "");
        }
    }
    return setanswer(refcode, checkelement, true, "");
}

/**
 * 校验数值数据输入控件
 * @param e
 * @returns
 */
function checkInputNumber(refcode, e) {
    var checkelement = $(e);
    var wsfmin = checkelement.attr("wsfmin");
    var wsfmax = checkelement.attr("wsfmax");
    var datavalue = checkelement.val();
    if (wsfmin && wsfmin != "") {
        if (parseFloat(wsfmin) > parseFloat(datavalue)) {
            return setanswer(refcode, checkelement, false, "数据值不能小于" + wsfmin + "，目前录入数据为：" + datavalue + "");
        } else {
            return setanswer(refcode, checkelement, true, "");
        }
    }
    if (wsfmax && wsfmax != "") {
        if (parseFloat(wsfmax) < parseFloat(datavalue)) {
            return setanswer(refcode, checkelement, false, "数据值不能大于" + wsfmax + "，目前录入数据为：" + datavalue + "");
        } else {
            return setanswer(refcode, checkelement, true, "");
        }
    }
    return setanswer(refcode, checkelement, true, "");
}

/**
 * 校验下拉选择框
 * @param e
 * @returns
 */
function checkSelect(refcode, e) {
    var checkelement = $(e);
    if (checkelement.val()) {
        checkelement.parent().parent().removeClass("error");
        return setanswer(refcode, checkelement, true, "");
    } else {
        checkelement.parent().parent().addClass("error");
        return setanswer(refcode, checkelement, false, "请选择选项值");
    }
}

/**
 * 根据控件校验结果重置提交按钮
 * @param refcode 当前编辑form控件关联数据表的外键标识符
 * @param checkelement 当前校验的控件对象
 * @param success 当前校验的结果状态
 * @param eror 当前校验的结果的文字说明
 * @returns
 */
function setanswer(refcode, checkelement, success, eror) {
    if (success) {
        if (checkelement && checkelement != "") {
            checkelement.parent().parent().removeClass("error");
            $("#" + checkelement.attr("id") + "helpblock").html(eror);
        }
    } else {
        checkelement.parent().parent().addClass("error");
        $("#" + checkelement.attr("id") + "helpblock").html(eror);
    }
    var datamodel = data[refcode + "datamodel"];
    if (datamodel && datamodel.sumbitbuttonid) {
        if (success) {
            $("#" + datamodel.sumbitbuttonid).attr("disabled", "");
            $("#" + datamodel.sumbitbuttonid).attr("disabled", false);
            $("#" + datamodel.sumbitbuttonid).removeAttr("disabled");
        } else {
            $("#" + datamodel.sumbitbuttonid).attr("disabled", "disabled");
        }
    }
    return success;
}


/**
 * child数据加载
 * @param param
 */
function childtablelistdata(refcode) {
    var dataparam = data[refcode + "param"];
    var searchdata = {};
    searchdata[dataparam.refkey] = $("#" + dataparam.formid).find("#" + dataparam.refkey).val();
    updatecom(dataparam.searchurl, searchdata, function (response) {
        var fieldthlist = $("#" + dataparam.tablecomid).find("thead tr th");
        if (response.data.list.length != 0) {
            $("#" + dataparam.tablecomid).children("tbody").empty();
            $.each(response.data.list, function (i, n) {
                var tr = $("<tr></tr>");
                $.each(fieldthlist, function (ii, nn) {
                    var value = n[$(fieldthlist[ii]).attr("id")];
                    if (n[$(fieldthlist[ii]).attr("id") + "refview"]) {
                        value = n[$(fieldthlist[ii]).attr("id") + "refview"];
                    }
                    value = (undefined == value || null == value || "null" == value) ? "" : value;
                    if (ii < (fieldthlist.length - 1)) {
                        if (ii == 0) {
                            var th = $("<th class=\"drag\">" + value + "</th>");
                            $(tr).append(th);
                        } else {
                            var th = $("<th>" + value + "</th>");
                            $(tr).append(th);
                        }
                    } else {
                        var str = "<th>";
                        str = str + "<view id=\"" + dataparam.editbuttoncomid + "\" onclick=\"" + dataparam.editactionfuncname + "(this)\" data-value=\"" + value + "\" data-refcode=\"" + refcode + "\"  class=\"btn mini purple\"><i class=\"icon-edit\"></i> 编辑</view>";
                        str = str + "<view id=\"" + dataparam.deletebuttoncomid + "\" onclick=\"" + dataparam.deleteactionfuncname + "(this)\" data-value=\"" + value + "\" data-refcode=\"" + refcode + "\"  class=\"btn mini black\"><i class=\"icon-trash\"></i> 删除</view>";
                        str = str + "</th>";
                        $(tr).append(str);
                    }
                });
                $("#" + dataparam.tablecomid).children("tbody").append(tr);
            });
            /**
             * 存在排序就输出排序初始化
             */
            if (typeof childsortaction === "function") {
                childsortaction(refcode);
            }
        } else {
            $("#" + dataparam.tablecomid).children("tbody").empty();
            $("#" + dataparam.tablecomid).children("tbody").append("<tr><td colspan=\"" + fieldthlist.length + "\" class=\"highlight\" style=\"text-align: center;\">暂未设置详细数据</td></tr>");
        }
        var tablewidth = $("#" + dataparam.tablecomid).width();
        var avewidth = tablewidth / fieldthlist.length;
        $("#" + dataparam.tablecomid).find("thead tr th").width(avewidth + 1);

    });
}

/**
 * 弹出控件初始化及form重置
 */
function childinitform(refcode) {
    $("#" + data[refcode + "param"].formid)[0].reset();
    $("#" + data[refcode + "param"].formid).find("#uiid").val("");
    $("#" + data[refcode + "param"].dialogid).dialog({
        dialogClass: 'ui-dialog-green',
        autoOpen: false,
        resizable: true,
        modal: true
    });
    $("#" + refcode + "closeaction").on('click', function () {
        $("#" + data[refcode + "param"].dialogid).dialog("close");
    });
    $("div.ui-dialog-titlebar.ui-widget-header.ui-corner-all.ui-helper-clearfix").hide();
}

/**
 * 数据新增
 */
function childaddaction(e) {//数据新增
    //清除childform数据，并设置关联关系数据id
    var refcode = $(e).attr("data-refcode");
    var dataparam = data[refcode + "param"];
    var refkey = data[refcode + "param"].refkey;
    var refvalue = $("#" + data[refcode + "param"].formid).find("#" + refkey).val();
    childinitform(refcode);
    $("#" + dataparam.formid).find("#" + dataparam.refkey).val(refvalue);
    $("#" + data[refcode + "param"].dialogid).dialog("open");
    $('.ui-dialog button').blur();
}

/**
 * 数据编辑
 */
function childeditaction(e) {//数据编辑
    var refcode = $(e).attr("data-refcode");
    var dataparam = data[refcode + "param"];
    var refkey = data[refcode + "param"].refkey;
    var refvalue = $("#" + data[refcode + "param"].formid).find("#" + refkey).val();
    updatecom(dataparam.searchurl, {"uiid": $(e).attr("data-value")}, function (response) {
        if (response.data.list.length == 1) {
            childinitform(refcode);
            $("#" + dataparam.formid).find("#" + dataparam.refkey).val(refvalue);
            data.childdatavo = response.data.list[0];
            $("#" + dataparam.formid).initForm(data.childdatavo);
            if (typeof(childeditinitextend) != "undefined" && typeof(childeditinitextend) === "function") {
                childeditinitextend(data.datavo);
            }
            $("#" + dataparam.dialogid).dialog("open");
        } else {
            alert("编辑信息加载失败");
        }
    });
}

/**
 * 数据删除
 * @param e
 */
function childdeleteaction(e) {
    var refcode = $(e).attr("data-refcode");//获取当前外键关联编辑业务标识符
    if (confirm("确定删除选中数据？")) {
        updatecom(data[refcode + "param"].deleteurl, {"uiid": $(e).attr("data-value")}, function (response) {
            childtablelistdata(refcode);
        });
    }
}

/**
 * 数据排序
 * @param refcode 当前外键关联编辑业务标识符
 */
function childsortaction(refcode) {
    var dataparam = data[refcode + "param"];
    if (dataparam && dataparam.hasOwnProperty("sorturl") && dataparam.sorturl && dataparam.sorturl != "") {
        $("#" + refcode + "table").children("tbody").sortable({//开启数据排序
            opacity: .35,
            handle: ".drag",
            receive: function (event, ui) {
            },
            stop: function (event, ui) {
                var listids = "";
                $.each($("#" + refcode + "table").children("tbody").find(".drag"), function (i, n) {
                    listids += $(n).val() + ",";
                });
                if (listids.indexOf(",") != -1) updatecom(dataparam.sorturl, {"sort": listids}, function (response) {
                });
            }
        });
    }
}


/**
 * 加载列表数据
 * @param pageNum 当前显示的页数
 * @param pageSize 当前页加载的数据条数
 */
function loadtablelistdata(refcode, searchmap) {
    var datamodel = data[refcode + "datamodel"];
    var searchdata = $("#" + datamodel.searchformid).serializeJson();
    searchdata.pageNum = searchmap.pageNum;
    searchdata.pageSize = searchmap.pageSize;

    if (datamodel.hasOwnProperty("refkey")) {//存在refkey属性，说明当前数据表为从表，获取主表关系数据id作为查询参数提交到后台
        if (datamodel.refkey && datamodel.refkey != "") {
            searchdata[datamodel.refkey] = datamodel[datamodel.refkey];
        }
    }

    var delstate = $("#" + refcode + "setdelete");
    if (delstate && delstate.length > 0) {
        if (datamodel.showdelstate && datamodel.showdelstate == 1) {
            searchdata[delstate.attr("delfield")] = "1";
        } else {
            searchdata[delstate.attr("delfield")] = "0";
        }
    }

    if (typeof(loadtablelistdatabeforeextend) != "undefined" && typeof(loadtablelistdatabeforeextend) === "function") {
        searchdata = loadtablelistdatabeforeextend(datamodel, searchdata);
    }
    console.log("searchdata=====================================", searchdata);
    updatecom(datamodel.searchurl, searchdata, function (response) {
        if (typeof(loadtablelistdataafterextend) != "undefined" && typeof(loadtablelistdataafterextend) === "function") {
            response = loadtablelistdataafterextend(datamodel, response);
        }
        var fieldthlist = $("#" + datamodel.tableid).find("thead tr th");
        if ($("#" + datamodel.tableid).children("tbody").length == 0) {
            $("#" + datamodel.tableid).append("<tbody></tbody>");
        } else {
            $("#" + datamodel.tableid).children("tbody").empty();
        }
        refreshloadtablepagebar(datamodel, response.data);
        datamodel.pageinfo = response.data;
        $.each(response.data.list, function (i, n) {
            var tr = $("<tr></tr>");
            $.each(fieldthlist, function (ii, nn) {
                var value = n[$(fieldthlist[ii]).attr("id")];
                if (n[$(fieldthlist[ii]).attr("id") + "refview"]) {//+"refview"
                    value = n[$(fieldthlist[ii]).attr("id") + "refview"];//+"refview"
                }
                value = (undefined == value || null == value || "null" == value) ? "" : value;
                if (ii == 0) {
                    $(tr).append("<th class=\"drag\"><div class=\"checker\"><span><input type=\"checkbox\" class=\"group-checkable\" value=\"" + value + "\" " + "></span></div></th>");
                    //$(tr).append("<th class=\"drag\"><div class=\"checker\"><span><input type=\"checkbox\" class=\"group-checkable\" value=\""+value+"\" " + "></span></div></th>");
                } else {
                    var th = $("<th>" + value + "</th>");
                    $(tr).append(th);
                    if (ii > 2) {//添加移动端支持
                        $(th).addClass("hidden-480");
                    }
                }
            });
            $("#" + datamodel.tableid).children("tbody").append(tr);
            $(tr).on('click', function () {
            });
        });

        //增加表格行点击选中功能  checker  checked
        $("#" + datamodel.tableid + " tr").each(function () {
            $(this).children().click(function (e) {
                $(e.target).parent("tr").each(function () {
                    if ($(this).find(":checkbox").is(":checked")) {
                        $(this).find(":checkbox").attr("checked", false);
                        $(this).find(":checkbox").parent().removeClass("checked");
                    } else {
                        $(this).find(":checkbox").attr("checked", true);
                        $(this).find(":checkbox").parent().addClass("checked");
                    }
                });
                if (datamodel.hasOwnProperty("refkey")) {
                } else {
                    //主表点击，选中，刷新从表数据；关系数据传递逻辑：获取主表数据id，查找所有存在refkey属性的从表对象，并赋值当前主表数据id到从表的对象模型中；
                    var masteruiid;
                    var checkboxlist = $("#" + datamodel.tableid).find("input[type=checkbox]:checked");
                    if (checkboxlist.length == 1) {
                        masteruiid = $(checkboxlist[0]).val();
                    }
                    var searchslavedata = {};
                    if (masteruiid && masteruiid != "") {
                        searchslavedata.pageNum = 1;
                        searchslavedata.pageSize = 15;
                        jQuery.each(data, function (i, val) {//遍历对象全属性，查找属于当前主表从对象列表并遍历加载数据
                            if (val && val != "" && val.hasOwnProperty("refkey")) {
                                val[val.refkey] = masteruiid;
                                loadtablelistdata(val.refcode, searchslavedata);//加载从表数据
                            }
                        });
                    }
                }
            });
        });
    });
}

/**
 * 刷新分页工具栏
 * @param pagevo
 */
function refreshloadtablepagebar(datamodel, pagevo) {
    $("#" + datamodel.refcode + "startRow").html(pagevo.startRow);
    $("#" + datamodel.refcode + "endRow").html(pagevo.endRow);
    $("#" + datamodel.refcode + "pages").html(pagevo.pages);
    $("#" + datamodel.refcode + "total").html(pagevo.total);
    var pagebar = $("#" + datamodel.refcode + "pagebar");
    var ul = $("<ul></ul>");
    $(pagebar).empty();
    $(pagebar).append(ul);
    if (pagevo.pageNum == 1) {
        $(ul).append("<li class=\"first disabled\"><a href=\"javascript:;\"><span class=\"hidden-480\">首页</span></a></li>");
        $(ul).append("<li class=\"prev disabled\"><a href=\"javascript:;\"><span class=\"hidden-480\">上一页</span></a></li>");
    } else {
        $(ul).append("<li class=\"first\"><a href=\"javascript:;\"><span class=\"hidden-480\">首页</span></a></li>");
        $(ul).append("<li class=\"prev\"><a href=\"javascript:;\"><span class=\"hidden-480\">上一页</span></a></li>");
    }
    $.each(pagevo.navigatepageNums, function (i, n) {
        if ((pagevo.pageNum) == n) {
            $(ul).append("<li class=\"active\"><a href=\"javascript:;\">" + n + "</a></li>");
        } else {
            $(ul).append("<li><a href=\"javascript:;\">" + n + "</a></li>");
        }
    });
    if (pagevo.pageNum == pagevo.pages) {
        $(ul).append("<li class=\"next disabled\"><a href=\"javascript:;\"><span class=\"hidden-480\">下一页</span></a></li>");
        $(ul).append("<li class=\"last disabled\"><a href=\"javascript:;\"><span class=\"hidden-480\">末页</span></a></li>");
    } else {
        $(ul).append("<li class=\"next\"><a href=\"javascript:;\"><span class=\"hidden-480\">下一页</span></a></li>");
        $(ul).append("<li class=\"last\"><a href=\"javascript:;\"><span class=\"hidden-480\">末页</span></a></li>");
    }
    $("#" + datamodel.refcode + "pagebar").find("li").on('click', function () {//分页工具栏添加监听响应事件
        if ($(this).parent().children("li.active").children().text() == $(this).children().text()) {//点击当前页忽略
            return;
        }
        if ($(this).parent().children("li.active").children().text() == "1") {//第一页，点击上一页、首页忽略
            if ($(this).hasClass("first") || $(this).hasClass("prev"))
                return;
        }
        if ($(this).parent().children("li.active").children().text() == $("#" + datamodel.refcode + "pages").text()) {//末页点击下一页、末页忽略
            if ($(this).hasClass("next") || $(this).hasClass("last"))
                return;
        }
        var searchdata = {};
        if ($(this).hasClass("first")) {
            searchdata["pageNum"] = 1;
            searchdata["pageSize"] = datamodel.pageinfo.pageSize;
            loadtablelistdata(datamodel.refcode, searchdata);
            return;
        }
        ;
        if ($(this).hasClass("prev")) {
            searchdata["pageNum"] = (parseInt($(this).parent().children("li.active").children().text()) - 1);
            searchdata["pageSize"] = datamodel.pageinfo.pageSize;
            loadtablelistdata(datamodel.refcode, searchdata);
            return;
        }
        ;
        if ($(this).hasClass("next")) {
            searchdata["pageNum"] = (parseInt($(this).parent().children("li.active").children().text()) + 1);
            searchdata["pageSize"] = datamodel.pageinfo.pageSize;
            loadtablelistdata(datamodel.refcode, searchdata);
            return;
        }
        ;
        if ($(this).hasClass("last")) {
            searchdata["pageNum"] = $("#" + datamodel.refcode + "pages").text();
            searchdata["pageSize"] = datamodel.pageinfo.pageSize;
            loadtablelistdata(datamodel.refcode, searchdata);
            return;
        }
        ;
        searchdata["pageNum"] = $(this).children().text();
        searchdata["pageSize"] = datamodel.pageinfo.pageSize;
        loadtablelistdata(datamodel.refcode, searchdata);
    });
}

//页面常用按钮点击事件添加及控件初始化refreshloadtablepagebar
function loadtableinit(refcode, searchmap) {
    var datamodel = data[refcode + "datamodel"];
//	$("a.btn-block").on('click', function() {
//		var searchdata = {};
//		searchdata["pageNum"] = 1;
//		searchdata["pageSize"] = 15;
//		loadtablelistdata(refcode,searchdata);
//	});//数据查询按钮绑定

    $("#" + refcode + "new").on('click', function () {
        var connectdata = $("#" + datamodel.searchformid).serializeJson();
        if (datamodel.refkey && datamodel.refkey != "") {
            if (datamodel[datamodel.refkey] && datamodel[datamodel.refkey] != "") {
                connectdata[datamodel.refkey] = datamodel[datamodel.refkey];
            } else {
                alert("主信息未选择，请选择");
            }
        }
        window.open(datamodel.addhtmlpath + "?connectdata=" + encodeURIComponent(encodeURIComponent(JSON.stringify(connectdata))));
    });//数据新增

    $("button[delfield='delstate'][delvalue='0']").hide();//默认隐藏删除恢复按钮，连击页面标题5次以上即可开启删除数据恢复按钮的显示，同时仅显示删除数据；
    datamodel["pagecaptiontime"] = new Date().getTime();
    datamodel["pagecaptionnum"] = 0;
    $("#" + refcode + "pagecaption").on('click', function () {
        var clicktime = new Date().getTime();
        if ((clicktime - datamodel.pagecaptiontime) < 1000) {
            datamodel.pagecaptionnum = datamodel.pagecaptionnum + 1;
        }
        datamodel.pagecaptiontime = clicktime;
        if (datamodel.pagecaptionnum > 5) {
            datamodel["showdelstate"] = 1;
            $("button[delfield='delstate'][delvalue='0']").show();
        }
    });//数据新增

    $("#" + refcode + "edit").on('click', function () {//数据编辑
        var checkboxlist = $("#" + datamodel.tableid).find("input[type=checkbox]:checked");
        if (checkboxlist.length == 1) {
            window.open(datamodel.edithtmlpath + "?uiid=" + $(checkboxlist[0]).val());
        } else {
            alert("请选择一条数据行");
        }
    });
    $("#" + refcode + "delete").on('click', function () {//数据删除
        var checkboxlist = $("#" + datamodel.tableid).find("input[type=checkbox]:checked");
        var uiids = "";
        $.each(checkboxlist, function (i, n) {
            if (i != 0) {
                uiids += ",";
            }
            uiids += $(n).val();
        });
        if (checkboxlist.length > 0) {
            if (confirm("确定删除选中数据？")) {
                updatecom(datamodel.deleteurl, {"uiid": uiids}, function (response) {
                    var searchdata = {};
                    searchdata["pageNum"] = datamodel.pageinfo.pageNum;
                    searchdata["pageSize"] = datamodel.pageinfo.pageSize;
                    loadtablelistdata(refcode, searchdata);
                });
            }
        } else {
            alert("请至少选择一条数据行");
        }
    });
    $("#" + refcode + "view").on('click', function () {//数据查看
        var checkboxlist = $("#" + datamodel.tableid).find("input[type=checkbox]:checked");
        if (checkboxlist.length == 1) {
            window.open(datamodel.viewhtmlpath + "?uiid=" + $(checkboxlist[0]).val());
        } else {
            alert("请选择一条数据行");
        }
    });
    $("#" + refcode + "listbuttonsbar").find("button[id=" + refcode + "setstate]").click(function () {
        var field = $(this).attr("stafield");
        var value = $(this).attr("stavalue");
        var checkboxlist = $("#" + refcode + "table").find("input[type=checkbox]:checked");
        if (checkboxlist.length > 0) {
            var listids = "";
            $.each(checkboxlist, function (i, n) {
                if ("on" == $(n).val()) {
                } else {
                    listids += $(n).val() + ",";
                }
            });
            if (confirm("确定设置选中数据？")) {
                var obj = {};
                obj.uiid = listids;
                obj[field] = value;
                console.log(obj);
                updatecom(data[refcode + "datamodel"].batchediturl, obj, function (response) {
                    data[refcode + "datamodel"].reloadtablelistdata();
                });
            }
        } else {
            alert("请选择一条数据行");
        }


    });
    $("#" + refcode + "listbuttonsbar").find("button[id=" + refcode + "setdelete]").click(function () {
        var field = $(this).attr("delfield");
        var value = $(this).attr("delvalue");
        var checkboxlist = $("#" + refcode + "table").find("input[type=checkbox]:checked");
        if (checkboxlist.length > 0) {
            var listids = "";
            $.each(checkboxlist, function (i, n) {
                if ("on" == $(n).val()) {
                } else {
                    listids += $(n).val() + ",";
                }
            });
            if (confirm("确定设置选中数据？")) {
                var obj = {};
                obj.uiid = listids;
                obj[field] = value;
                console.log(obj);
                updatecom(data[refcode + "datamodel"].batchediturl, obj, function (response) {
                    data[refcode + "datamodel"].reloadtablelistdata();
                });
            }
        } else {
            alert("请选择一条数据行");
        }


    });

    if (datamodel.sorturl && datamodel.sorturl != "") {
        //需要判断当前业务是否存在排序
        $("#" + datamodel.tableid).children("tbody").sortable({//开启数据排序
            opacity: .35,
            handle: ".drag",
            receive: function (event, ui) {
            },
            stop: function (event, ui) {
                var listids = "";
                $.each($("#" + datamodel.tableid).children("tbody").find("input[type=checkbox]"), function (i, n) {
                    listids += $(n).val() + ",";
                });
                if (listids.indexOf(",") != -1) updatecom(datamodel.sorturl, {"sort": listids}, function (response) {
                });
            }
        });
    }

    $("#" + refcode + "reloadmore").on('click', function () {//监听加载更多
        var searchdata = {};
        searchdata["pageNum"] = datamodel.pageinfo.pageNum;
        searchdata["pageSize"] = ((parseInt($("#" + refcode + "endRow").text()) - parseInt($("#" + refcode + "startRow").text()) + 1) * 2);
        loadtablelistdata(refcode, searchdata);
    });
    loadrolefunc(refcode);
}

/**
 * 根据当前资源文件id，加载当前页面的功能权限，存在权限数据就开启权限校验，不存在就不加载页面权限信息
 */
function loadrolefunc(refcode) {
    var wssuiid = getmetacontent("wssuiid");
    var wsruiid = getCookie("wsruiid"+getCookie("wspuiid"));
    if (wssuiid && wssuiid != "" && wssuiid != "undefined" && wsruiid && wsruiid != "" && wsruiid != "undefined") {
        var obj = {};
        obj.wssuiid = wssuiid;
        obj.wsruiid = wsruiid;
        updatecom("/wo/run/getrolewssfunclist", obj, function (response) {
            console.log("根据当前资源文件id，加载当前页面的功能权限，存在权限数据就开启权限校验，不存在就不加载页面权限信息", response);
            if (response.error_code == 10000) {
                if (response.data && response.data.length != 0) {
                    var buttonlist = $("#" + refcode + "buttonbar").children();
                    for (var i = 0; i < buttonlist.length; i++) {
                        var button = $(buttonlist[i]);
                        var buttonid = button.attr("id");
                        var buttype = button.attr("buttype");
                        var butmodel = button.attr("butmodel");
                        var stavalue = button.attr("stavalue");
                        var delvalue = button.attr("delvalue");
                        var ifshow = false;
                        if (buttype && buttype != "") {
                            if ("but" == buttype) {
                                response.data.forEach(function (n, i) {
                                    if (n.tasktype == buttype && (refcode + n.funcname) == buttonid) {
                                        ifshow = true;
                                    }
                                });
                            } else if ("sta" == buttype) {
                                response.data.forEach(function (n, i) {
                                    if (n.tasktype == buttype && (refcode + n.funcname) == buttonid && n.extendvalue == stavalue) {
                                        ifshow = true;
                                    }
                                });
                            } else if ("del" == buttype) {
                                response.data.forEach(function (n, i) {
                                    if (n.tasktype == buttype && (refcode + n.funcname) == buttonid && n.extendvalue == delvalue) {
                                        ifshow = true;
                                    }
                                });
                            } else {
                            }
                        }
                        if (!ifshow) {
                            if ("2" == butmodel) {
                                //显示但禁用
                                button.attr('disabled', true);
                                button.removeClass('green');
                            }
                            if ("1" == butmodel) {
                                //直接隐藏模式
                                button.hide();
                            }
                        }
                    }
                }
            }
        });
    }
}

/**
 * 从当前html的meta数据中获取资源文件wssuiid信息
 * @returns
 */
function getmetacontent(metakey) {
    var metas = document.getElementsByTagName("meta")
    for (i = 0; i < metas.length; i++) {
        if (metas[i].getAttribute("name") == metakey) {
            return metas[i].getAttribute("content");
        }
    }
    return "";
}

/**
 * 校验当前编辑form显示数据，存在授权就校验授权；不存在就全部默认显示；
 * @param refcode
 */
function checkeditform(refcode) {
    var wssuiid = getmetacontent("wssuiid");
    var wsruiid = getCookie("wsruiid"+getCookie("wspuiid"));
    if (wssuiid && wssuiid != "" && wsruiid && wsruiid != "") {
        var obj = {};
        obj.wssuiid = wssuiid;
        obj.wsruiid = wsruiid;
        updatecom("/wo/run/getroleswssfield", obj, function (response) {
            if (response.error_code == 10000 && response.data) {
                var showfieldlist = [];
                if (response.data.length != 0) {
                    response.data.forEach(function (n) {
                        showfieldlist.push(n.wsfuiid);
                    });
                    var fieldlist = $("#" + refcode + "dataform").find("div.control-group");
                    for (var i = 0; i < fieldlist.length; i++) {
                        var button = $(fieldlist[i]);
                        var buttonid = button.attr("wsfid");
                        if (buttonid && buttonid != "" && showfieldlist.indexOf(buttonid) == -1) {
                            button.hide();
                        }
                    }
                }
            }
        });
    }
}

/**
 * 校验当前列表显示数据，存在授权就强制授权；不存在就全部默认显示；
 * @param refcode
 */
function checklistform(refcode) {
    var wssuiid = getmetacontent("wssuiid");
    var wsruiid = getCookie("wsruiid"+getCookie("wspuiid"));
    if (wssuiid && wssuiid != "" && wsruiid && wsruiid != "") {
        var obj = {};
        obj.wssuiid = wssuiid;
        obj.wsruiid = wsruiid;
        updatecom("/wo/run/getroleswssfield", obj, function (response) {
            if (response.error_code == 10000) {
                if (response.data && response.data.length != 0) {
                    var showfieldlist = [];
                    response.data.forEach(function (n) {
                        showfieldlist.push(n.wsfuiid);
                    });
                    var fieldlist = $("#" + refcode + "table").find("th");
                    for (var i = 0; i < fieldlist.length; i++) {
                        var button = $(fieldlist[i]);
                        var buttonid = button.attr("id");
                        if (buttonid && buttonid != "" && showfieldlist.indexOf(buttonid) == -1) {
                            $("#" + refcode + "table").find("tr").find('th:eq(' + i + ')').hide();
                            $("#" + refcode + "table").find("tr").find('td:eq(' + i + ')').hide();
                        }
                    }
                }
            }
        });
    }
}

/**
 * 列表数据全选全取消
 * @param e
 */
function loadtableselectall(refcode, e) {
    var datamodel = data[refcode + "datamodel"];
    $("#" + datamodel.tableid + " tr").each(function () {
        $(this).find(":checkbox").attr("checked", e.checked);
        if (e.checked) {
            $(this).find(":checkbox").parent().addClass("checked");
        } else {
            $(this).find(":checkbox").parent().removeClass("checked");
        }
    });
}


function formatRepo(repo) {
    if (repo.loading)
        return repo.text;
    var markup = "<div>" + repo.text + "</div>";
    return markup;
}


/**
 * 重设列表页面各元素高度，1.0版
 */
function resetlistpageheight() {
    var workspaceheight = $("div.container-fluid.mainworkspace", parent.document).height();
    $("body").height(workspaceheight);//设置list列表页面body高度
    $("div.page-container.row-fluid").height(workspaceheight);//设置多个布局div高度
    $("div.portlet.box.blue.calendar").height(workspaceheight);
    $("div.portlet.box.light-grey").height(workspaceheight);

    var portlettitleheight = $("div.portlet-title").outerHeight(true);//获取列表页面标题栏高度
    var portletbodyheight = workspaceheight - portlettitleheight;//计算列表页面内容部分高度

    $("div.portlet-body").height(portletbodyheight);//设置列表页面内容部分高度
    $("#dataform").parent().height(portletbodyheight);

    var formheight = $("#dataform").outerHeight(true);//获取页面查询条件内容高度
    var listpagetagheight = $("#listpagetag").outerHeight(true);//获取页面提示信息内容高度
    var listbuttonbarheight = $("#listbuttonsbar").parent().parent().outerHeight(true);//获取页面操作工具栏内容高度
    var listpagebarheight = $("#listpagingbar").parent().parent().outerHeight(true);//获取页面分页工具栏内容高度
    $("#listpagedata").parent().parent().height(portletbodyheight - formheight - listbuttonbarheight - listpagebarheight - 10 - listpagetagheight);//设置数据表格内容高度
    $("#listpagedata").height(portletbodyheight - formheight - listbuttonbarheight - listpagebarheight - 10 - listpagetagheight);
}

/**
 * 重设列表页面各元素高度，2.0版
 */
function resetlistpageheight2() {
    var workspaceheight = $("div.container-fluid.mainworkspace", parent.document).height();
    //console.log("list列表页面body高度"+workspaceheight);
    $("body").height(workspaceheight);//设置list列表页面body高度
    $("div.page-container.row-fluid").height(workspaceheight);//设置多个布局div高度
    $("div.portlet.box.blue.calendar").height(workspaceheight);
    $("div.portlet.box.light-grey").height(workspaceheight);
    //console.log("list列表页面body高度"+workspaceheight);

    var portlettitleheight = $("div.portlet-title").outerHeight(true);//获取列表页面标题栏高度
    //console.log("列表页面标题栏高度"+portlettitleheight);
    var portletbodyheight = workspaceheight - portlettitleheight;//计算列表页面内容部分高度
    //console.log("列表页面内容部分高度"+portletbodyheight);

    $("div.portlet-body").height(portletbodyheight);//设置列表页面内容部分高度
    $("form.form-horizontal").parent().height(portletbodyheight);

    var formheight = $("form.form-horizontal").outerHeight(true);//获取页面查询条件内容高度
    //console.log("页面查询条件内容高度"+formheight);
    var listpagetagheight = $("div.listpagetag").outerHeight(true);//获取页面提示信息内容高度
    listpagetagheight = listpagetagheight ? listpagetagheight : 0;
    //console.log("页面提示信息内容高度"+listpagetagheight);
    var listbuttonbarheight = $("div.operatebuttonbar").parent().parent().outerHeight(true);//获取页面操作工具栏内容高度
    listbuttonbarheight = listbuttonbarheight ? listbuttonbarheight : 0;
    //console.log("页面操作工具栏内容高度"+listbuttonbarheight);
    var listpagebarheight = $("div.listpagingbar").parent().parent().outerHeight(true);//获取页面分页工具栏内容高度
    //console.log("页面分页工具栏内容高度"+listpagebarheight);
    //console.log("数据表格内容高度"+(portletbodyheight-formheight-listbuttonbarheight-listpagebarheight-40-listpagetagheight));
    $("#listpagedata").parent().parent().height(portletbodyheight - formheight - listbuttonbarheight - listpagebarheight - 40 - listpagetagheight);//设置数据表格内容高度
    $("#listpagedata").height(portletbodyheight - formheight - listbuttonbarheight - listpagebarheight - 40 - listpagetagheight);
}

function resetlistpageheight3() {
    var workspaceheight = $("div.container-fluid.mainworkspace", parent.document).height();
    //console.log("list列表页面body高度"+workspaceheight);
    $("body").height(workspaceheight);//设置list列表页面body高度
    $("div.page-container.row-fluid").height(workspaceheight);//设置多个布局div高度
    $("div.portlet.box.blue.calendar").height(workspaceheight);
    $("div.portlet.box.light-grey").height(workspaceheight);
    //console.log("list列表页面body高度"+workspaceheight);

    var portlettitleheight = $("div.portlet-title").outerHeight(true);//获取列表页面标题栏高度
    //console.log("列表页面标题栏高度"+portlettitleheight);
    var portletbodyheight = workspaceheight - portlettitleheight;//计算列表页面内容部分高度
    //console.log("列表页面内容部分高度"+portletbodyheight);

    $("div.portlet-body").height(portletbodyheight);//设置列表页面内容部分高度
    $("form.form-horizontal").parent().height(portletbodyheight);

    var formheight = $("form.form-horizontal").outerHeight(true);//获取页面查询条件内容高度
    //console.log("页面查询条件内容高度"+formheight);
    var listpagetagheight = $("div.listpagetag").outerHeight(true);//获取页面提示信息内容高度
    listpagetagheight = listpagetagheight ? listpagetagheight : 0;
    //console.log("页面提示信息内容高度"+listpagetagheight);
    var listbuttonbarheight = $("div.operatebuttonbar").parent().parent().outerHeight(true);//获取页面操作工具栏内容高度
    listbuttonbarheight = listbuttonbarheight ? listbuttonbarheight : 0;
    //console.log("页面操作工具栏内容高度"+listbuttonbarheight);
    var listpagebarheight = $("div.listpagingbar").parent().parent().outerHeight(true);//获取页面分页工具栏内容高度
    //console.log("页面分页工具栏内容高度"+listpagebarheight);
    //console.log("数据表格内容高度"+(portletbodyheight-formheight-listbuttonbarheight-listpagebarheight-40-listpagetagheight));
    // $("#listpagedata").parent().parent().height(portletbodyheight-formheight-listbuttonbarheight-listpagebarheight-40-listpagetagheight);//设置数据表格内容高度
    $("#listpagedata").height(230);//设置数据表格内容高度
    $("#listpagedata").parent().height(230);//设置数据表格内容高度
    $("#listpagedata").parent().parent().height(230);//设置数据表格内容高度
    $("#listpagedata").parent().parent().parent().height(230 + formheight + listpagetagheight + listbuttonbarheight + listpagebarheight);//设置主数据表整个div高度
    //$("#listpagedata").height(portletbodyheight-formheight-listbuttonbarheight-listpagebarheight-40-listpagetagheight);
}

/**
 * 重设主从页面各元素高度，1.0版
 */
function resetlistpagemheight2() {
    var workspaceheight = $("div.container-fluid.mainworkspace", parent.document).height() - 500;
    $("body").height(workspaceheight);//设置list列表页面body高度
    $("div.page-container.row-fluid").height(workspaceheight);//设置多个布局div高度
    $("div.portlet.box.blue.calendar").height(workspaceheight);
    $("div.portlet.box.light-grey").height(workspaceheight);
    console.log("list列表页面body高度" + workspaceheight);

    var portlettitleheight = $("div.portlet-title").outerHeight(true);//获取列表页面标题栏高度
    console.log("列表页面标题栏高度" + portlettitleheight);
    var portletbodyheight = workspaceheight - portlettitleheight;//计算列表页面内容部分高度
    console.log("列表页面内容部分高度" + portletbodyheight);

    $("div.portlet-body").height(portletbodyheight);//设置列表页面内容部分高度

    $("form.form-horizontal").parent().height(portletbodyheight - 32);

    var formheight = $("form.form-horizontal").outerHeight(true);//获取页面查询条件内容高度
    console.log("页面查询条件内容高度" + formheight);
    var listpagetagheight = $("div.listpagetag").outerHeight(true);//获取页面提示信息内容高度
    console.log("页面提示信息内容高度" + listpagetagheight);
    var listbuttonbarheight = $("div.operatebuttonbar").parent().parent().outerHeight(true);//获取页面操作工具栏内容高度
    console.log("页面操作工具栏内容高度" + listbuttonbarheight);
    var listpagebarheight = $("div.listpagingbar").parent().parent().outerHeight(true);//获取页面分页工具栏内容高度
    console.log("页面分页工具栏内容高度" + listpagebarheight);
    $("#listpagedata").parent().parent().height(portletbodyheight - formheight - listbuttonbarheight - listpagebarheight - 10 - listpagetagheight);//设置数据表格内容高度
    $("#listpagedata").height(portletbodyheight - formheight - listbuttonbarheight - listpagebarheight - 10 - listpagetagheight);
}

/**
 * 获取函数名称
 */
function getFnName(callee) {
    var _callee = callee.toString().replace(/[\s\?]*/g, ""),
        comb = _callee.length >= 50 ? 50 : _callee.length;
    _callee = _callee.substring(0, comb);
    var name = _callee.match(/^function([^\(]+?)\(/);
    if (name && name[1]) {
        return name[1];
    }
    var caller = callee.caller,
        _caller = caller.toString().replace(/[\s\?]*/g, "");
    var last = _caller.indexOf(_callee),
        str = _caller.substring(last - 30, last);
    name = str.match(/var([^\=]+?)\=/);
    if (name && name[1]) {
        return name[1];
    }
    return "anonymous";
};

/**
 * js获取当前日期时间“yyyy-MM-dd HH:MM:SS”
 * @returns {String}
 */
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}

/**
 * 构建select2控件提交服务器请求参数
 * @param showtitle 条件筛选字段，多个字段之间通过逗号分隔
 * @param params select2原生事件响应返回参数，type=query；team=用户输入信息；
 * @returns {___anonymous37912_37913}
 */
function createselect2param(showtitle, params) {
    var searchobj = {};
    if (showtitle.indexOf(",") != -1) {
        var strtemp = showtitle.split(",");
        $.each(strtemp,
            function (s, z) {
                searchobj[z] = params.term;
            });
    } else {
        searchobj[showtitle] = params.term;
    }
    return searchobj;
}

/**
 * 构建select2控件添加选项返回的文本标签
 * @param showtitle 文本标签显示的字段列表，多个字段之间通过逗号分隔
 * @param datavo 当前处理的数据对象
 * @returns {String}
 */
function createselect2text(showtitle, datavo, comid) {
    var datatemptext = "";
    if (showtitle.indexOf(",") != -1) {
        var strtemp = showtitle.split(",");
        $.each(strtemp, function (s, z) {
            if (datatemptext != "") {
                datatemptext += ",";
            }
            datatemptext += datavo[(comid ? comid : "") + z];
        });
    } else {
        datatemptext = datavo[(comid ? comid : "") + showtitle];
    }
    return datatemptext;
}

/**
 * 初始化select2控件
 * @param comid 控件id
 * @param label 控件显示标签
 * @param url 动态数据请求来源地址
 * @param fieldkey 当前动态请求数据的主键或唯一识别标识符
 * @param showtitle 控件显示的数据项列表，多个之间通过逗号分隔
 */
function initsourcecode_select2(comid, label, url, fieldkey, showtitle) {
    if (!(url && url != "")) {
        console.log("select2控件初始化失败，未找到动态数据请求地址");
        return;
    }
    try {
        return $("#" + comid).select2({
            placeholder: "请选择" + (label ? label : ""),
            allowClear: true,
            ajax: {
                url: varbasePath + url,
                dataType: 'json',
                delay: 250,
                type: "POST",
                data: function (params) {
                    return createselect2param(showtitle, params);
                },
                processResults: function (data, params) {
                    var datalist = [];
                    for (var i = 0; i < data.data.list.length; i++) {
                        var datavo = data.data.list[i];
                        var datatemp = {};
                        datatemp.id = datavo[fieldkey];
                        datatemp.text = createselect2text(showtitle, datavo, "");
                        datalist.push(datatemp);
                    }
                    //params.page = params.page || 1;
                    return {
                        results: datalist
                        //pagination: {
                        //    more: (params.page * 10) < data.total_count
                        //}
                    };
                },
                cache: true
            },
            escapeMarkup: function (markup) {
                return markup;
            },
            minimumInputLength: 1,
            templateResult: formatRepo,
            templateSelection: formatRepo
        });
    } catch (e) {
        console.log(e);
    }
}

/**
 * select2控件赋值
 * @param comid 控件id
 * @param fieldkey 当前动态请求数据的主键或唯一识别标识符
 * @param showtitle 控件显示的数据项列表，多个之间通过逗号分隔
 * @param datavo 返回的数据对象
 */
function setvaluecode_select2(comid, fieldkey, showtitle, datavo) {
    try {
//		console.log(comid);//wspuiid
//		console.log(fieldkey);//uiid
//		console.log(showtitle);//title,name
//		console.log(datavo);
        if (datavo && datavo[comid]) {
            if (datavo[comid].indexOf(",") != -1) {
                var valusstr = datavo[comid].split(",");
//				var valusstrview = data.wssmdatavo.wspuiidrefview.split(",");
//				for(var i = 0 ; i < valusstr.length ; i ++){
//					$("#"+comid).append("<option value='"+valusstr[i]+"'>"+createselect2text(showtitle,datavo,comid)+"</option>");
//				}
                data[comid + "select2"].val(valusstr).trigger("change");
            } else {
                //$("#"+comid).append("<option select value='"+datavo[comid]+"'>"+createselect2text(showtitle,datavo,comid)+"</option>");
                data[comid + "select2"].val(datavo[comid]).trigger("change");
            }
        }
    } catch (e) {
        console.log(e);
    }
}

//递归分级获取分类数据
function loudmoreoption(current, childs, inputcomid, columnid, columntitle) {
    $.each(childs, function (i, n) {
        if (undefined != n.child && n.child.length != 0) {
            $("#" + inputcomid).append("<optgroup label=\"" + getloudmoreoption(n, columntitle) + "\"></optgroup>");
            loudmoreoption(n, n.child, inputcomid);
        } else {
            $("#" + inputcomid).append("<option value='" + n[columnid] + "'>" + getloudmoreoption(n, columntitle) + "</option>");
        }
    });
}

function getloudmoreoption(n, showtitle) {
    if (showtitle.indexOf(",") != -1) {
        var strtemp = showtitle.split(",");
        var strtitle = "";
        $.each(strtemp,
            function (s, z) {
                if (strtitle != "") {
                    strtitle += ",";
                }
                strtitle += n[z];
            });
        return strtitle;
    } else {
        return n[showtitle];
    }
}

/**
 * 序列号form表单为json对象
 */
(function ($) {
    $.fn.serializeJson = function () {
        var serializeObj = {};
        var array = this.serializeArray();
        $(array).each(function () {
            if (serializeObj[this.name]) {
                if (serializeObj[this.name]) {
                    serializeObj[this.name] += ",";
                    serializeObj[this.name] += this.value;
                } else {
                    serializeObj[this.name] = this.value;//处理输入框等单个对象
                }
            } else {
                serializeObj[this.name] = this.value;//处理当个对象
            }
        });
        var $radio = $('input[type=radio]', this);
        $.each($radio, function () {
            if (!serializeObj.hasOwnProperty(this.name)) {
                serializeObj[this.name] = "";
            }
            if (this.checked) {
                serializeObj[this.name] = this.value;
            }
        });
        var $checkbox = $('input[type=checkbox]', this);
        $.each($checkbox, function () {
            if ($(this).hasClass('toggle')) {
                serializeObj[this.name] = this.value;
            }
            else {
                if (!serializeObj.hasOwnProperty(this.name)) {
                    serializeObj[this.name] = "";
                }
                if (this.checked && serializeObj[this.name] != "") {
                    if (serializeObj[this.name] != "") {
                        if (serializeObj[this.name].indexOf(this.value) == -1) {
                            serializeObj[this.name] += ",";
                            serializeObj[this.name] += this.value;
                        }
                    } else {
                        serializeObj[this.name] = this.value;
                    }
                } else {
                }
            }
        });
//        alert(JSON.stringify(serializeObj));
        return serializeObj;
    };
})(jQuery);

/**
 * 下拉控件级联刷新，【触发源】控件值改变，触发被级联控件的下拉值刷新
 * @param tablecode
 * @param comid
 * @param value
 */
function dealrefnext(tablecode, comid, value) {
//	console.log(tablecode);
//	console.log(comid);
//	console.log(value);
//	console.log(tablecode+"refs");
//	console.log(data[tablecode+"refs"]);
    if (data[tablecode + "refs"] && data[tablecode + "refs"][comid]) {
//		console.log(value);
        data[tablecode + "refs"][comid].forEach(function (n, i) {
            var ss = n.split(":");//ss[0],ss[1],ss[2] wsmtuiid:wssuiid:wsmtuiid
            var paramobj = {};
            if (data[tablecode + "datamodel"]["refparam" + ss[1]]) {
                Object.assign(paramobj, data[tablecode + "datamodel"]["refparam" + ss[1]]);
            }
            var wsfrefparam = $("#" + ss[1]).attr("wsfrefparam");
            if (wsfrefparam && wsfrefparam != "") {
                var jsonobj = eval("(" + wsfrefparam + ")");//JSON.parse(wsfrefparam);
                for (var key in jsonobj) {
                    paramobj[key] = jsonobj[key];
                }
            }
            if (!data[tablecode + "datavo"]) {
                data[tablecode + "datavo"] = {};
            }
            data[tablecode + "datavo"][comid] = value;
            paramobj[ss[2]] = value;
            var func = eval(ss[1] + "tolistdata");
            func(paramobj);
        });
    }
}

/**
 * 动态添加关联数据选项到select控件中，适用关联数据默认不加载控件
 * @param formField
 * @param key
 * @param value
 * @param options
 */
function selectaddoption(formField, key, value, options) {
    if (options && options[key]) {
        if (options[key].indexOf(",") != -1) {
            var valusstr = options[key].split(",");
            for (var i = 0; i < valusstr.length; i++) {
                var optionvalue = valusstr[i];
                var optiontext = "";
                var refshow = formField.attr("wsfshowuiid");
                if (refshow && refshow != "") {
                    if (refshow.indexOf(",") != -1) {
                        var refshows = refshow.split(",");
                        var refstr = "";
                        refshows.forEach(function (n, ii) {
                            if (optiontext && optiontext != "") {
                                optiontext += ",";
                            }
                            optiontext += options[key + n].split(",")[i];
                        });
                    } else {
                        optiontext = options[key + refshow];
                    }
                } else {
                    optiontext = optionvalue;
                }
                if (optiontext && optiontext != "") {
                    $("#" + key).append("<option value='" + optionvalue + "'>" + optiontext + "</option>");
                }
            }
            try{
                data[key + "select2"].val(valusstr).trigger("change");
            }catch(e){
            }
        } else {
            var refshow = formField.attr("wsfshowuiid");
            if (refshow && refshow != "") {
                if (refshow.indexOf(",") != -1) {
                    var refshows = refshow.split(",");
                    var refstr = "";
                    refshows.forEach(function (n, i) {
                        if (refstr && refstr != "") {
                            refstr += ",";
                        }
                        refstr += options[key + n];
                    });
                    formField.append("<option value='" + value + "'>" + refstr + "</option>");
                } else {
                    formField.append("<option value='" + value + "'>" + options[key + refshow] + "</option>");
                }
            } else {
                formField.append("<option value='" + value + "'>" + value + "</option>");
            }
        }
    }
}

/**
 * json对象赋值到form对象
 */
(function ($) {
    $.fn.extend({
        initForm: function (options) {
            //默认参数  
            var defaults = {
                jsonValue: options,
                isDebug: true   //是否需要调试，这个用于开发阶段，发布阶段请将设置为false，默认为false,true将会把name value打印出来
            };
            //设置参数  
            var setting = defaults;
            var form = this;
            jsonValue = setting.jsonValue;
            //如果传入的json字符串，将转为json对象  
            if ($.type(setting.jsonValue) === "string") {
                jsonValue = $.parseJSON(jsonValue);
            }
            //如果传入的json对象为空，则不做任何操作  
            if (!$.isEmptyObject(jsonValue)) {
                var debugInfo = "";
                $.each(jsonValue, function (key, value) {
                    //是否开启调试，开启将会把name value打印出来  
                    if (setting.isDebug) {
                        //alert("name:"+key+"; value:"+value);  
                        debugInfo += "name:" + key + "; value:" + value + " || ";
                    }
                    var formField = form.find("[id='" + key + "']");
                    if ($.type(formField[0]) === "undefined") {
                        if (setting.isDebug) {
                            //alert("can not find name:["+key+"] in form!!!");    //没找到指定name的表单  
                        }
                    } else {
                        var fieldTagName = formField[0].tagName.toLowerCase();
                        if (fieldTagName == "input") {
//                            if(formField.attr("type") == "radio"){  
//                                $("input:radio[name='"+key+"'][value='"+value+"']").attr("checked","checked");  
//                            } else if(formField.attr("type") == "checkbox"){  
//                            	console.log(value);
////                            	if(value.indexOf(",")){
////                            		var valusstr[] = value.split(",");
////                            		$(value.split(",")).each(function(){
////                            			$("input:checkbox[name='"+key+"'][value='"+this+"']").attr("checked","checked"); 
////                                    });
////                            	}else{
////                            		$("input:checkbox[name='"+key+"'][value='"+value+"']").attr("checked","checked");  
////                            	}
//                            } else {  
                            formField.val(value);
//                            }  
                        } else if (fieldTagName == "select") {
//                        	console.log("控件類型："+fieldTagName);
//                        	console.log("控件對象：",formField);
//                        	console.log("控件值："+value);    //wsfshowuiid
//                        	console.log("form數據對象：",options);
//                        	console.log("關聯屬性："+$(formField).attr("wsfshowuiid"));
//                        	console.log("select option數量："+$("select[name="+key+"] option").size());
                            if (value && value != "") {
                                var optionobj = formField.find("option[value='" + value + "']");
                                if (optionobj.length == 0) {
                                    var optionlist = formField.find("option");
//                                	console.log("select option數量："+optionlist.length);
                                    if (optionlist.length == 0) {
                                        //完全不存在option，執行添加在默認選中
                                        selectaddoption(formField, key, value, options);
                                    } else if (optionlist.length == 1) {
                                        //判斷是否value為空，value為空就添加option并設置選中；不為空，就設置選中，不能選中就相當於清空選中；
                                        var firstvalue = formField.find("option:first").val();
                                        if (firstvalue && firstvalue != "") {
                                        } else {
                                            selectaddoption(formField, key, value, options);
                                        }
                                    } else {
                                        //已存在option選項
                                    }
                                } else {
                                }
                            } else {
                            }
                            formField.val(value);
                        } else if (fieldTagName == "textarea") {
                            //do something special  
                            formField.val(value);
                        } else {
                            formField.val(value);
                        }
                    }

                    var formFieldname = form.find("[name='" + key + "']");
                    if ($.type(formFieldname[0]) === "undefined") {
                        if (setting.isDebug) {
                            //alert("can not find name:["+key+"] in form!!!");    //没找到指定name的表单  
                        }
                    } else {
                        var fieldTagName = formFieldname[0].tagName.toLowerCase();
                        if (fieldTagName == "input") {
                            if (formFieldname.attr("type") == "radio") {
                                $("input:radio[name='" + key + "'][value='" + value + "']").attr("checked", "checked");
                                $("input:radio[name='" + key + "'][value='" + value + "']").parent().addClass("checked");
                            } else if (formFieldname.attr("type") == "checkbox") {
                                if (value && value.indexOf(",") != -1) {
                                    var valusstr = value.split(",");
                                    for (var i = 0; i < valusstr.length; i++) {
                                        $("input:checkbox[name='" + key + "'][value='" + valusstr[i] + "']").attr("checked", "checked");
                                        $("input:checkbox[name='" + key + "'][value='" + valusstr[i] + "']").parent().addClass("checked");
                                    }
                                } else {
                                    $("input:checkbox[name='" + key + "'][value='" + value + "']").attr("checked", "checked");
                                    $("input:checkbox[name='" + key + "'][value='" + value + "']").parent().addClass("checked");
                                }
                            }
                        }
                    }
                });
                if (setting.isDebug) {
                    //alert(debugInfo);  
                }
            }
            return form;    //返回对象，提供链式操作  
        }
    });
})(jQuery);

/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * eg:
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 */
Date.prototype.Format = function(fmt)
{
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
};

