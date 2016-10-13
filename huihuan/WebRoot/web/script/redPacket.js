(function ($) {
    var OperateResult = { success: "Success", redirect: "Redirect", haveNotLogin: "HaveNotLogin", errorMessage: "ErrorMessage" };
    var RedPacketDispatchedStatus = { succeedDispatched: "SucceeDispatched", alreadyDispatched: "AlreadyDispatched", doubleDispatched: "DoubleDispatched", alreadyDispatchedDouble: "AlreadyDispatchedDouble" };
    var RedPacketGotStatus = { alreadyGotWechat: "AlreadyGotWechat", alreadyGotWebApp: "AlreadyGotWebApp", alreadyGotDouble: "AlreadyGotDouble", neverGot: "NeverGot", alreadyUsed: "AlreadyUsed", noUseable: "NoUseable" };
    var mainLayerBg = "images/redPacket/main-layer-bg.jpg";
    var layerContentBg = "images/redPacket/layer-content-bg.png";
    var layerContentLargeBg = "images/redPacket/layer-content-bg-large.png";
    var textBg = "images/redPacket/red-packet-text.png";

    var phoneAndCodeHtml = '<div style="width:683px; height:724px; overflow: hidden;position: relative;">' +
                            '<div id="red-packet-content">' +
                                '<div class="center-parent rp-title">' +
                                    '<div class="center-child">' +
                                        '<img src="images/redPacket/title.png"/>' +
                                    '</div>' +
                                '</div>' +
                                '<div class="rp-phone">' +
                                    '<div style="margin-top: 30px;">' +
                                        '<input type="text" id="red-packet-phoneNo" placeholder="输入手机号码"/>' +
                                    '</div>' +
                                    '<div id="getRedPacket" class="get-rp-btn">领取红包</div>' +
                                '</div>' +
                            '</div>' +
                            '<div class="center-parent rp-bottom">' +
                                '<div class="center-child">' +
                                    '<img src="images/redPacket/red-packet-text.png"/>' +
                                '</div>' +
                            '</div>' +
                            '<img id="red-packet" src="' + layerContentBg + '" />' +
                            '<div class="layer-close-btn rp-small-bg">' +
                                '<img id="red-packet-close-btn" src="images/btn_close_black.png" />' +
                            '</div>'
    '</div>';

    ////给activity-main.aspx和index.aspx中活动slider绑定事件
    //$(document).on('click', "#showInfo", function () {
    //    showRedPacketMainLayer();
    //});

    //$(".get-redpacket").on("click", function () {
    //    showRedPacketResultByStatus();
    //});

    //给关注户外按钮绑定事件
    $(".follow-whw").on("click", function () {
        layer.open({
            type: 1,
            shadeClose: true,
            title: false,
            closeBtn: false,
            scrollbar: false,
            shade: 0.8,
            area: ['610px', '680px'],
            content: '<div style="width:610px; height:680px; overflow: hidden;">' +
                        '<img src="../image/qrcode/qrcode-layer.jpg" />' +
                        '<div class="layer-close-btn">' +
                            '<img id="red-packet-close-btn" src="../image/qrcode/btn_close_black.png" />' +
                        '</div>' +
                     '</div>',
            success: function (layero, index) {
                $(".layer-close-btn").on('click', function () {
                    layer.closeAll();
                });
                $(".layui-layer-setwin").on('click', function () {
                    layer.closeAll();
                });
            }
        });
    });

    //if (fromWeChatLoginCallback()) {
    //    var statusInfo = { IsWeChatEnv: true, Status: getPar("redPacketStatus"), StartDate: getPar("startDate"), ExpiredDate: getPar("expiredDate") };
    //    showLayerByEnvAndRedPacketStatus(statusInfo);
    //} else {
    //    var showLayer = $.cookie("IsDisplayedSprintDiscountOverlay");
    //    if (!showLayer) {
    //        showRedPacketResultByStatus();
    //        updateCookie();
    //    }
    //}

    function fromWeChatLoginCallback() {
        return getPar("redPacketStatus");
    }

    function fromWeChatShareLink() {
        var from = getPar("from");
        return from && (from == "timeline" || from == "singlemessage" || from == "groupmessage");
    }

    function updateCookie() {
        var date = new Date();
        date.setDate(date.getDate() + 2);
        $.cookie("IsDisplayedSprintDiscountOverlay", true, { expires: date });
    };

    function showRedPacketMainLayer() {
        layer.open({
            type: 1, shadeClose: true, title: false, closeBtn: false, scrollbar: false, shade: 0.8, area: ['636px', '980px'],
            content: '<div style="width:636px; height:980px; overflow: hidden;position: relative;">' +
                        '<div id="dispatchRedPacket" style="position:absolute;width:450px;height:92px;left:94px;bottom:53px;"></div>' +
                        '<img id="red-packet" src="' + mainLayerBg + '\" />' +
                        '<div class="layer-close-btn ">' +
                            '<img src="images/btn_close2.png" />' +
                        '</div>' +
                    '</div>',
            success: function (layero, index) {
                bindDispatchEvent();
                bindCloseEventBySelector();
            }
        });
    };

    function bindCloseEventBySelector() {
        $(".layer-close-btn").on("click", function () {
            layer.closeAll();
        });
        $(".layui-layer-setwin").on("click", function () {
            layer.closeAll();
        });
    }

    function showWeChatNotDispatchedLayer() {
        layer.open({
            type: 1, shadeClose: true, title: false, closeBtn: false, scrollbar: false, shade: 0.8, area: ['683px', '724px'],
            content: phoneAndCodeHtml,
            success: function (layero, index) {
                layero.css("background-color", "transparent");
                layero.css("box-shadow", "0 0 0 transparent");
                bindCloseEventBySelector();
                $("#getRedPacket").on("click", function () {
                    var phone = $("#red-packet-phoneNo").val().trim();
                    if (phone.length == 0) {
                        showMessage("请输入手机号码");
                        return;
                    }
                    $.ajax({
                        type: "get",
                        url: "/Api/api.ashx?type=DispatchRedPacket&phone=" + phone,
                        dataType: "json",
                        success: function (response) {
                            var result = response.Result;
                            if (result == OperateResult.errorMessage) {
                                showMessage(response.Message);
                                return;
                            } else if (result == OperateResult.redirect) {
                                refirectToWeChatLogin();
                                return;
                            }
                            var status = response.Status;
                            response.Text = response.Price + "元";
                            if (status == RedPacketDispatchedStatus.succeedDispatched) {
                                showWeChatSucceedDispatchedLayer(response);
                            } else if (status == RedPacketDispatchedStatus.doubleDispatched) {
                                showWeChatDoubleDispatchedLayer(response);
                            } else if (status == RedPacketDispatchedStatus.alreadyDispatched) {
                                showWeChatAlreadyDispatchedLayer(response);
                            }
                        }
                    });
                });
            }
        });
    }

    function showWebappNotDispatchedLayer() {
        layer.open({
            type: 1, shadeClose: true, title: false, closeBtn: false, scrollbar: false, shade: 0.8, area: ['683px', '724px'],
            content: phoneAndCodeHtml,
            success: function (layero, index) {
                layero.css("background-color", "transparent");
                layero.css("box-shadow", "0 0 0 transparent");
                bindCloseEventBySelector();
                $("#getRedPacket").on("click", function () {
                    var phone = $("#red-packet-phoneNo").val().trim();
                    if (phone.length == 0) {
                        showMessage("请输入手机号码");
                        return;
                    }
                    $.ajax({
                        type: "get",
                        url: "/Api/api.ashx?type=DispatchRedPacket&phone=" + phone,
                        dataType: "json",
                        success: function (response) {
                            var result = response.Result;
                            if (result == OperateResult.errorMessage) {
                                showMessage(response.Message);
                                return;
                            }
                            var status = response.Status;
                            layer.closeAll();
                            if (status == RedPacketDispatchedStatus.succeedDispatched) {
                                response.Text = "恭喜你获得";
                                showWebappSucceedDispatchedLayer(response);
                            } else {
                                response.Text = "你已领取";
                                showWebappSucceedDispatchedLayer(response);
                            }
                        }
                    });
                });
            }
        });
    }

    function showRedPacketResultByStatus() {
        $.ajax({
            type: "get",
            url: "/Api/api.ashx?type=GetRedpacketGotStatus",
            dataType: "json",
            success: function (response) {
                layer.closeAll();
                if (response.HasLogin) {
                    //登陆了，后台领取红包返回红包领取情况
                    showLayerByEnvAndRedPacketStatus(response);
                } else {
                    //没有登陆
                    //1.微信环境则重定向到授权页面
                    //2.Webapp环境显示领取输入框layer
                    if (response.IsWeChatEnv) {
                        redirectToWeChatLogin();
                    } else {
                        showWebappNotDispatchedLayer();
                    }
                }
            }
        });
    }

    function bindDispatchEvent() {
        $("#dispatchRedPacket").on("click", function () {
            $.ajax({
                type: "get",
                url: "/Api/api.ashx?type=GetRedpacketGotStatus",
                dataType: "json",
                success: function (response) {
                    layer.closeAll();
                    if (response.HasLogin) {
                        //登陆了，后台领取红包返回红包领取情况
                        showLayerByEnvAndRedPacketStatus(response);
                    } else {
                        //没有登陆
                        //1.微信环境则重定向到授权页面
                        //2.Webapp环境显示领取输入框layer
                        if (response.IsWeChatEnv) {
                            redirectToWeChatLogin();
                        } else {
                            showWebappNotDispatchedLayer();
                        }
                    }
                }
            });
        })
    }

    function redirectToWeChatLogin() {
        $.cookie("redPacketPageUrl", location.href);
        var callbackUrl = "http://" + location.host + "/LoginCallback.aspx?needGetRedPacketInfo=true";
        var appId = $("#whwAppId").text();
        var wechatLoginUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appId
                           + "&redirect_uri=" + encodeURIComponent(callbackUrl) + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        location.href = wechatLoginUrl;
    }

    function showLayerByEnvAndRedPacketStatus(statusResponse) {
        var redPacketStatus = statusResponse.Status;
        if (statusResponse.IsWeChatEnv) {
            if (redPacketStatus == RedPacketGotStatus.neverGot ||
                redPacketStatus == RedPacketGotStatus.alreadyGotWebApp) {
                showWeChatNotDispatchedLayer(statusResponse);
            } else if (redPacketStatus == RedPacketGotStatus.alreadyGotWechat ||
                       redPacketStatus == RedPacketGotStatus.alreadyGotDouble ||
                       redPacketStatus == RedPacketGotStatus.alreadyUsed) {
                statusResponse.Text = "你已领取";
                showWeChatAlreadyDispatchedLayer(statusResponse);
            } else if (redPacketStatus == RedPacketGotStatus.noUseable) {
                dispatchAgainForWeChatUser();
            }
        } else {
            if (redPacketStatus == RedPacketGotStatus.neverGot || redPacketStatus == RedPacketGotStatus.noUseable) {
                dispatchForWebappCustomer();
            } else if (redPacketStatus == RedPacketGotStatus.alreadyGotWechat ||
                       redPacketStatus == RedPacketGotStatus.alreadyGotWebApp ||
                       redPacketStatus == RedPacketGotStatus.alreadyGotDouble ||
                       redPacketStatus == RedPacketGotStatus.alreadyUsed) {
                statusResponse.Text = "你已领取";
                showWebappSucceedDispatchedLayer(statusResponse);
            }
        }
    }

    function showWeChatAlreadyDispatchedLayer(statusResponse) {
        layer.closeAll();
        layer.open({
            type: 1, shadeClose: true, title: false, closeBtn: false, scrollbar: false, shade: 0.8, area: ['683px', '724px'],
            content: '<div style="width:683px; height:724px; overflow: hidden;position: relative;">' +
                        '<img id="red-packet" src="images/redPacket/alreay-got.png" />' +
                        '<div class="center-parent expired-date">' +
                            '<div class="center-child">' +
                                '有效期: ' + statusResponse.StartDate + "-" + statusResponse.ExpiredDate +
                            '</div>' +
                        '</div>' +
                        '<div class="layer-close-btn rp-small-bg">' +
                            '<img id="red-packet-close-btn" src="images/btn_close_black.png" />' +
                        '</div>' +
                    '</div>',
            success: function (layero, index) {
                $("#already-arrow").show();
                layero.css("background-color", "transparent");
                layero.css("box-shadow", "0 0 0 transparent");
                bindCloseEventBySelector();
            },
            end: function () {
                $("#already-arrow").hide();
            }
        });
    }

    function showWeChatSucceedDispatchedLayer(redPacketInfo) {
        layer.closeAll();
        window.scrollTo(0, 0);
        layer.open({
            type: 1, shadeClose: true, title: false, closeBtn: false, scrollbar: false, shade: 0.8, area: ['683px', '724px'],
            content: '<div style="width:683px; height:724px; overflow: hidden;position: relative;">' +
                        '<div class="rp-price-info">' +
                            '<div class="rp-price-info-inner-bg">' +
                                '<div class="inner-bg-price">' +
                                    '<span>' + redPacketInfo.Price + '</span>' +
                                    '<span class="rp-unit">元</span>' +
                                '</div>' +
                                '<div class="rp-dot">' +
                                    '<img src="images/redPacket/dot.png">' +
                                '</div>' +
                                '<div class="inner-bg-info">' +
                                    '<div class="inner-bg-text">' +
                                        '报名时自动减免' +
                                    '</div>' +
                                    '<div class="rp-date">' +
                                        '有效期：' + redPacketInfo.StartDate + '-' + redPacketInfo.ExpiredDate +
                                    '</div>' +
                                '</div>' +
                                '<div style="clear:both;"></div>' +
                            '</div>' +
                        '</div>' +
                        '<img id="red-packet" src="images/redPacket/succeed-got.png" />' +
                        '<div class="layer-close-btn rp-small-bg">' +
                            '<img id="red-packet-close-btn" src="images/btn_close_black.png" />' +
                        '</div>' +
                    '</div>',
            success: function (layero, index) {
                $("#double-single-arrow").show();
                layero.css("background-color", "transparent");
                layero.css("box-shadow", "0 0 0 transparent");
                bindCloseEventBySelector();
            },
            end: function () {
                $("#double-single-arrow").hide();
            }
        });
    }

    function showWeChatDoubleDispatchedLayer(redPacketInfo) {
        layer.closeAll();
        window.scrollTo(0, 0);
        layer.open({
            type: 1, shadeClose: true, title: false, closeBtn: false, scrollbar: false, shade: 0.8, area: ['683px', '724px'],
            content: '<div style="width:683px; height:724px; overflow: hidden;position: relative;">' +
                        '<div class="rp-price-info">' +
                            '<div class="rp-price-info-inner-bg">' +
                                '<div class="inner-bg-price">' +
                                    '<span>' + redPacketInfo.Price + '</span>' +
                                    '<span class="rp-unit">元</span>' +
                                '</div>' +
                                '<div class="rp-dot">' +
                                    '<img src="images/redPacket/dot.png">' +
                                '</div>' +
                                '<div class="inner-bg-info">' +
                                    '<div class="inner-bg-text">' +
                                        '报名时自动减免' +
                                    '</div>' +
                                    '<div class="rp-date">' +
                                        '有效期：' + redPacketInfo.StartDate + '-' + redPacketInfo.ExpiredDate +
                                    '</div>' +
                                '</div>' +
                                '<div style="clear:both;"></div>' +
                            '</div>' +
                        '</div>' +
                        '<img id="red-packet" src="images/redPacket/double-got.png" />' +
                        '<div class="layer-close-btn rp-small-bg">' +
                            '<img id="red-packet-close-btn" src="images/btn_close_black.png" />' +
                        '</div>' +
                    '</div>',
            success: function (layero, index) {
                $("#double-single-arrow").show();
                layero.css("background-color", "transparent");
                layero.css("box-shadow", "0 0 0 transparent");
                bindCloseEventBySelector();
            },
            end: function () {
                $("#double-single-arrow").hide();
            }
        });
    }

    function dispatchForWebappCustomer() {
        $.ajax({
            type: "get",
            url: "/Api/api.ashx?type=DispatchRedPacket",
            dataType: "json",
            success: function (response) {
                if (response.Status == RedPacketDispatchedStatus.succeedDispatched) {
                    response.Text = "恭喜你获得";
                } else {
                    response.Text = "你已领取";
                }
                showWebappSucceedDispatchedLayer(response);
            }
        });
    }

    function dispatchAgainForWeChatUser() {
        $.ajax({
            type: "get",
            url: "/Api/api.ashx?type=DispatchRedPacket&dispatchAgain=true",
            dataType: "json",
            success: function (response) {
                var result = response.Result;
                if (result == OperateResult.errorMessage) {
                    showMessage(response.Message);
                    return;
                } else if (result == OperateResult.redirect) {
                    refirectToWeChatLogin();
                    return;
                }
                var status = response.Status;
                if (status == RedPacketDispatchedStatus.succeedDispatched) {
                    showWeChatSucceedDispatchedLayer(response);
                } else if (status == RedPacketDispatchedStatus.doubleDispatched) {
                    showWeChatDoubleDispatchedLayer(response);
                } else if (status == RedPacketDispatchedStatus.alreadyDispatched) {
                    showWeChatAlreadyDispatchedLayer(response);
                }
            }
        });
    }

    function showWebappSucceedDispatchedLayer(redPacketInfo) {
        if (redPacketInfo.StartDate) {
            redPacketInfo.StartDate = redPacketInfo.StartDate.replace("-", ".");
        }
        if (redPacketInfo.ExpiredDate) {
            redPacketInfo.ExpiredDate = redPacketInfo.ExpiredDate.replace("-", ".");
        }
        layer.open({
            type: 1, shadeClose: true, title: false, closeBtn: false, scrollbar: false, shade: 0.8, area: ['683px', '1004px'],
            content: '<div style="width:683px; height:1004px; overflow: hidden;position: relative;">' +
                        '<div class="center-parent rp-result-info">' +
                            '<div class="center-child">' +
                                redPacketInfo.Text +
                            '</div>' +
                        '</div>' +
                        '<div class="center-parent rp-title">' +
                            '<div class="center-child">' +
                                '<img src="images/redPacket/title.png"/>' +
                            '</div>' +
                        '</div>' +
                        '<div class="rp-price-info" style="top:168px;">' +
                            '<div class="rp-price-info-inner-bg">' +
                                '<div class="inner-bg-price">' +
                                    '<span>' + redPacketInfo.Price + '</span>' +
                                    '<span class="rp-unit">元</span>' +
                                '</div>' +
                                '<div class="rp-dot">' +
                                    '<img src="images/redPacket/dot.png">' +
                                '</div>' +
                                '<div class="inner-bg-info">' +
                                    '<div class="inner-bg-text">' +
                                        '报名时自动减免' +
                                    '</div>' +
                                    '<div class="rp-date">' +
                                        '有效期：' + redPacketInfo.StartDate + '-' + redPacketInfo.ExpiredDate +
                                    '</div>' +
                                '</div>' +
                                '<div style="clear:both;"></div>' +
                            '</div>' +

                        '</div>' +
                        '<div class="rp-share">' +
                            '<img src="images/redPacket/share.png"/>' +
                        '</div>' +
                        '<div class="rp-how">' +
                            '<img src="images/redPacket/how.png"/>' +
                        '</div>' +
                        '<div class="rp-welcome">' +
                            '<img src="images/redPacket/red-packet-text.png"/>' +
                        '</div>' +
                        '<img id="red-packet" src="' + layerContentLargeBg + '" />' +
                        '<div class="layer-close-btn rp-small-bg">' +
                            '<img id="red-packet-close-btn" src="images/btn_close_black.png" />' +
                        '</div>' +
                    '</div>',
            success: function (layero, index) {
                layero.css("background-color", "transparent");
                layero.css("box-shadow", "0 0 0 transparent");
                bindCloseEventBySelector();
            }
        });
    };

    $("#checkRedPacket").on("click", function () {
        var redPacketInfo = JSON.parse($("#red-packet-info").text());
        var status = redPacketInfo.Status;
        redPacketInfo.IsWeChatEnv = redPacketInfo.IsWeChatEnv == "True" ? true : false;
        if (redPacketInfo.IsWeChatEnv) {
            if (status == RedPacketGotStatus.alreadyGotDouble) {
                showWeChatDoubleDispatchedLayer(redPacketInfo);
            } else if (status == RedPacketGotStatus.alreadyGotWechat) {
                showWeChatSucceedDispatchedLayer(redPacketInfo);
            }
        } else {
            redPacketInfo.Text = "你已领取";
            showWebappSucceedDispatchedLayer(redPacketInfo);
        }
    });

})(jQuery);
