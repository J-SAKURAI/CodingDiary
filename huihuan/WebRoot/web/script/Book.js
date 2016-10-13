
function RefreshDiscountInfo (orderCount, equipmentBuyList, doSuccess) {

    $('.book-submit').attr("disabled", "disabled");
    $('.book-submit').css("background-color", "#cccccc");
    var target = event.target;

    $.ajax({
        type: "post",
        url: "/Api/api.ashx?type=discount",
        dataType: "json",
        data: {
                orderCount: orderCount,
                equipmentBuyList: JSON.stringify(equipmentBuyList),
                phoneNum: $("input[name='MyPhone']").val(),
                openId: $("input[name='hidOpenid']").val(),
                singlePrice: $("input[name='price']").val(),
                discountTypeId: $("input[name='hidDiscountTypeId']").val(),
                isUserCustoming: $("input[name='hidIsUserCustoming']").val(),
                inputValidateCode: $('#inputValidateCode').val(),
                needValidateCode: target.id == 'inputValidateCode'
            },
        error: function (a, b, c) {
            alert(c);

            $('.book-submit').removeAttr('disabled')
            $('.book-submit').css("background-color", "#77c043");
        },
        success: function (json) {

            if (json)
            {
                $(".discount-book-info ul").remove();
                $(".discount-book-info").append(json.InfoHtml);

                $("span[id='spanCurrentPrice']").html(json.ActualOrderPrice);
                $("span[id='spanOriginalTotalPrice']").html(json.OriginalOrderPrice);
                $("span[id='spanSavedMoney']").html(json.SavedMoney);
            }

            doSuccess(target);

            $('.book-submit').removeAttr('disabled')
            $('.book-submit').css("background-color", "#77c043");
        }
    });
}

var JoinActive = {
    AddPlayer: function () {

        if ($(".discount-book-info").length > 0) {

            var orderCount = $(".book-player").length + 1;
            var equipmentBuyList = EQUIPMENT_ID ? [{ equipmentId: EQUIPMENT_ID, equipmentAmount: $(".equip-count").text() }] : [];
            RefreshDiscountInfo(orderCount, equipmentBuyList, function () {

                var template = $("#BookTemplate").html();
                $("#bookPlayer").append(template);

                if ($(".book-player").length == 2 && '<%=hasNewmemberDiscount%>' == 'True') {
                    layer.confirm('', {
                        skin: 'layui-layer-demo',
                        title: false,
                        closeBtn: 0,
                        btn: ['特惠规则', '知道了'], // 按钮
                        content: '<div><div style="font-weight:bold;line-height:100px;height:100px;padding-top:16px;font-size:32px;color:#000;text-align:center;">提醒</div><div style="color:#666;line-height:48px;height:126px;font-size:28px;text-align:center;">"新人优惠" 仅限一人报名。<br/>建议您将活动分享给朋友，分别报名。</div></div>'
                    }, function () {
                        layer.closeAll(); //关闭所有层
                        $.get('DisDetailDesc.html', {}, function (data, textStatus) {
                            layer.open({
                                type: 1,
                                shadeClose: true,
                                title: false,
                                shade: 0.8,
                                area: ['590px', '87%'],
                                content: data
                            });
                        });
                    }, function () {
                        layer.closeAll(); //关闭所有层
                    });
                }
            });
        }
        else {
            var template = $("#BookTemplate").html();
            $("#bookPlayer").append(template);

            var count = $(".book-player").length;

            $("span[id='spanCurrentPrice']").html(count * $("input[name='price']").val());
            $("span[id='spanOriginalTotalPrice']").html(count * $("input[name='price']").val());
            $("span[id='spanSavedMoney']").html(0);
        }

        return false;
    },
    DeletePlayer: function (obj) {

        if ($(".discount-book-info").length > 0) {

            var orderCount = $(".book-player").length - 1;
            var equipmentBuyList = EQUIPMENT_ID ? [{ equipmentId: EQUIPMENT_ID, equipmentAmount: $(".equip-count").text() }] : [];
            RefreshDiscountInfo(orderCount, equipmentBuyList, function (obj) {
                $(obj).parent().remove();
            });
        }
        else {
            $(obj).parent().remove();

            var count = $(".book-player").length;

            $("span[id='spanCurrentPrice']").html(count * $("input[name='price']").val());
            $("span[id='spanOriginalTotalPrice']").html(count * $("input[name='price']").val());
            $("span[id='spanSavedMoney']").html(0);
        }

        return false;
    },
    Submit: function () {
        var isValid = true;
        var msg = "";
        $(".book-player").each(function () {
            if ($(this).find("input[name='FullName']").val() == "") {
                isValid = false;
            }
            if ($(this).find("input[name='IDNum']").val() == "") {
                isValid = false;
            }
        });
        if (!isValid) {
            showMessage("请输入玩家的真实姓名和电话号码");
            return false;
        }
        if ($("input[name='MyFullName']").val() == "") {
            showMessage("请输入您的真实姓名");
            $("input[name='MyFullName']").focus();
            return false;
        }
        if ($("input[name='MyPhone']").val() == "") {
            showMessage("请输入您的身份证号码");
            $("input[name='MyPhone']").focus();
            return false;
        }
        $(".book-next").attr("disabled", "disabled");
        
        var postData = $("form[id='BookInfo']").serializeArray();
        var equipmentBuyList = EQUIPMENT_ID ? [{ equipmentId: EQUIPMENT_ID, equipmentAmount: $(".equip-count").text() }] : [];
        postData.push({ name: "equipmentBuyList", value: JSON.stringify(equipmentBuyList) });
        $.ajax({
            type: "post",
            url: "/Api/api.ashx?type=order",
            dataType: "json",
            data: postData,
            error: function (a, b, c) { alert(c); },
            success: function (json) {
                $(".book-next").removeAttr("disabled");
                if (json.result == 1) {
                    location.href = json.url;
                } else if (json.result == 2) {
                    layer.confirm('', {
                        skin: 'layui-layer-demo',
                        title: false,
                        closeBtn: 0,
                        btn: ['取消', '登录'], // 按钮
                        content: '<p>您还没有登录</p>'
                    }, function () {
                        layer.closeAll(); //关闭所有层
                    }, function () {
                        location.href = "WeiXinLogin.aspx";
                    });
                }
                else {
                    showMessage(json.message);
                }
            }
        });
        return false;
    },
    MinusEquipment: MinusEquipment,
    AddEquipment: AddEquipment,
    ShowEquipmentDetail: ShowEquipmentDetail
}

function MinusEquipment() {
    var equipmentAmount = parseInt($(".equip-count").text());
    if (equipmentAmount <= 0) {
        equipmentAmount = 0;
    } else {
        equipmentAmount = equipmentAmount - 1;
    }
    var orderCount = $(".book-player").length;
    var equipmentBuyList = [{ equipmentId: EQUIPMENT_ID, equipmentAmount: equipmentAmount }];
    RefreshDiscountInfo(orderCount, equipmentBuyList, function () {
        $(".equip-count").text(equipmentAmount);
    });
};

function AddEquipment() {
    var equipmentAmount = parseInt($(".equip-count").text());
    equipmentAmount = equipmentAmount + 1;
    if (equipmentAmount <= 0) {
        equipmentAmount = 1;
    }
    var orderCount = $(".book-player").length;
    var equipmentBuyList = [{ equipmentId: EQUIPMENT_ID, equipmentAmount: equipmentAmount }];
    RefreshDiscountInfo(orderCount, equipmentBuyList, function () {
        $(".equip-count").text(equipmentAmount);
    });
};

function ShowEquipmentDetail() {
    $(".show-equipment-detail").hide();
    $(".hide-equipment-detail").show();
    $(".equipement-pic").show();
}

//初始化装备
$(".equip-count").text("0");
var EQUIPMENT_ID = $("input[name='equipmentId']").val();
$(".equip-price").text("￥" + $("input[name='equipmentPrice']").val());
$(".equipment-name").text($("input[name='equipmentName']").val());
$(".equipment-info-content").text($("input[name='equipmentInfo']").val());

$('#inputValidateCode').on('keyup', function () {
    if ($('#inputValidateCode').val().length == 6) {

        var orderCount = $(".book-player").length;
        var equipmentCount = $(".equip-count").text();
        var equipmentBuyList = EQUIPMENT_ID ? [{ equipmentId: EQUIPMENT_ID, equipmentAmount: $(".equip-count").text() }] : [];
        RefreshDiscountInfo(orderCount, equipmentBuyList, function () { });
    }
});



$('#order-discount-detail').on('click', function () {
    $.get('DisDetailDesc.html', {}, function (data, textStatus) {
        layer.open({
            type: 1,
            shadeClose: true,
            title: false,
            shade: 0.8,
            area: ['590px', '87%'],
            content: data
        });
    });
});

$(".equipment-pic").on("click", function () {
    var picPath = $("input[name='equipmentPicPath']").val();
    layer.open({
        type: 1, shadeClose: true, title: false, closeBtn: false, scrollbar: false, shade: 0.8, area: ['auto', 'auto'],
        content: '<div style="width:636px; height:980px; overflow: hidden;position: relative;padding-top: 15px;">' +
                    '<img style="width:636px;" id="red-packet" src="' + picPath + '\" />' +
                    '<img style="position:absolute;right:20px;top:20px;" src="images/btn_close_black.png" id="eq-pic-close-btn" />' +
                '</div>',
        success: function (layero, index) {
            $("#eq-pic-close-btn").on("click", function () {
                layer.closeAll();
            })
        }
    });
})