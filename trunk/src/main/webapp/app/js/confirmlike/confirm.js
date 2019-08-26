{
    $("body").append("<div class=\"conf\" style=\"display: none\">\n" +
        "        <div class=\"prompt-con\" style=\"display: none\">\n" +
        "            <div class=\"msg-con\"></div>\n" +
        "            <div class=\"ok-con\" onclick=\"ok()\">确定</div>\n" +
        "            <div class=\"no-con\" onclick=\"no()\">取消</div>\n" +
        "        </div>\n" +
        "    </div>");
}
var conf = $(".conf");
var prompt_con = $(".prompt-con");

function confirmLike(info) {
    conf.attr("style","display:block");
    prompt_con.attr("style","display:block");
    $(".msg-con").html(info);

    $('body').css({
        "overflow-x":"hidden",
        "overflow-y":"hidden"
    });
    screenWidth = $(window).width();
    //获取页面高度
    screenHeight = $(window).height();
    //计算left值
    tcleft = (screenWidth-310)/2;
    //计算top值
    tctop = (screenHeight-350)/2;
    //获取滚轮高度
    scrollTop = $(document).scrollTop();
    //弹窗的位置样式改变
    prompt_con.css({'top':tctop+scrollTop});
    conf.css({'height':screenHeight+scrollTop});
}


function no(){
    $('body').css({
        "overflow-x":"auto",
        "overflow-y":"auto"
    });
    conf.attr("style","display:none");
    prompt_con.attr("style","display:none");
}

