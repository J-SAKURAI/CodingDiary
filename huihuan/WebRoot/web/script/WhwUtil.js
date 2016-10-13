function getPar(par,url) {
    //获取当前URL
    var local_url;

    if(url)
        local_url = url;
    else
        local_url = document.location.href;

    //获取要取得的get参数位置
    var get = local_url.indexOf(par + "=");
    if (get == -1) {
        return false;
    }
    //截取字符串
    var get_par = local_url.slice(par.length + get + 1);
    //判断截取后的字符串是否还有其他get参数
    var nextPar = get_par.indexOf("&");
    if (nextPar != -1) {
        get_par = get_par.slice(0, nextPar);
    }
    return get_par;
}

function showMessage(message) {
    layer.open({
        type: 1,
        title: false,
        closeBtn: false,
        shadeClose: true,
        skin: 'popupMessage',
        time: 3000,
        content: message,
        offset:['40%'],
        success: function (layero, index) {
        	//layero.css("top", (340));
            layero.css("left", ($(window).width() - 600) / 2);
            layero.css("width", "600px");
            layero.css("border-radius", "10px");
            layero.css("background-color", "rgba(0,0,0,.5)");
        }
    });
}


function bindSendValidateCodeEvent(sendButtonSelector, phoneNumSelector, disableFuc, enableFuc) {
    $(sendButtonSelector).one('click', function () {

        var interValObj;
        var validateCounter = 0;
        var currentCallee = arguments.callee;

        disableFuc();

        $.ajax({
            type: "post",
            url: "/Api/api.ashx?type=SendValidateCode",
            dataType: "json",
            data: {
                MyPhone: $(phoneNumSelector).val(),
            },
            error: function (a, b, c) {
                alert(c);
                $(sendButtonSelector).one('click', currentCallee);
                enableFuc();
            },
            success: function (json) {
                if (json.result == 3) {
                    showMessage(json.message);
                    $(sendButtonSelector).one('click', currentCallee);
                    enableFuc();
                }
                else if (json.result == 0) {
                    showMessage(json.message);
                    validateCounter = 60;

                    interValObj = window.setInterval(function () {
                        if (validateCounter < 0) {
                            window.clearInterval(interValObj);//停止计时器
                            $(sendButtonSelector).text('获取动态密码')
                            $(sendButtonSelector).one('click', currentCallee);
                            enableFuc();
                        }
                        else {
                            $(sendButtonSelector).text('重新发送（' + validateCounter + '）')
                            validateCounter--;
                        }
                    }, 1000);
                }
            }
        })

        return false;
    });
}
