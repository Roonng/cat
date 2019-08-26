{
    $("body").append("<div class=\"outside\">\n" +
        "    <div class=\"prompt\" style=\"display: none\">\n" +
        "        <div class=\"msg\"></div>\n" +
        "        <div class=\"ok\" onclick=\"ret()\">确定</div>\n" +
        "    </div>\n" +
        "</div>");
}

function ret() {
    $('body').css({
        "overflow-x":"auto",
        "overflow-y":"auto"
    });
    $(".prompt").attr("style","display:none");
    $(".outside").attr("style","display:none");
}

function tip(info) {
    $('body').css({
        "overflow-x":"hidden",
        "overflow-y":"hidden"
    });
    var prompt = $(".prompt");
    var msg = $(".msg");
    var out = $(".outside");
    prompt.attr("style","display:block");
    out.attr("style","display:block");
    msg.html(info);

    screenWidth = $(window).width();
    //获取页面高度
    screenHeight = $(window).height();
    //计算left值
    tcleft = (screenWidth-300)/2;
    //计算top值
    tctop = (screenHeight-350)/2;
    //获取滚轮高度
    scrollTop = $(document).scrollTop();
    //弹窗的位置样式改变
    $('.prompt').css({'top':tctop+scrollTop});
    $('.outside').css({'height':screenHeight+scrollTop});

}







