<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!-- saved from url=(0048)http://m.wanhuwai.com.cn/Pay/jsapi/jsApiPay.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><meta name="viewport" content="target-densitydpi=device-dpi,width=750,user-scalable=no"><title>
	订单支付
</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/style.css">
	<script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/layer.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/layer.css" id="layui_layer_skinlayercss">
	<script src="${pageContext.request.contextPath}/web/script/WhwUtil.js"></script>
</head>
<body>

        <div id="main" style="height:800px;">
            <div class="order">
                <div class="order-pay-ok">
                        <label><img src="${pageContext.request.contextPath}/web/image/paySuccess.png" style="vertical-align:middle"></label>
                        <label style="font-size:25px" >支付成功</label>
                </div>
            </div>
            <div class="order">
                <div class="order-pay-money">
                <br>
                    <li style="font-size:25px;height:45px">实际付款<span class="color-red" style="font-size: 40px;padding-left:10px" id="price">¥238</span></li>
                </div>

            </div>
            <div class="order" style="">
                    <ul class="order-basic order-basic-noborder" style="width:650px">
                        <li>订单编号:<span id="order-id"></span></li>
                        <li>活动名称:<span id="title"></span></li>
                        <li>当前状态:<span id="status">支付成功</span></li>
                        <li>支付方式:<span>微信支付</span></li>
                    </ul>
                    </div>
                        <div class="order" style="">
                    <ul class="order-basic order-basic-noborder" style="width:650px">
                        <li>本次积分:<span id="score"></span></li>
                        <li>总积分:<span id="total-score"></span></li>
                    </ul>
            </div>
        </div>

<script>
var id = request("id"); 
$(function() {
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data:{"order_id":id},
        url: "${pageContext.request.contextPath}/paymentAction_getOrderForSuccess",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		$("#order-id").html("NO"+data.obj.order.id);
        		$("#title").html(data.obj.activity.title);
        		$("#price").html('¥'+data.obj.order.price);
        		if(data.obj.is_sale=='1'){
        			$("#score").html('特价活动无积分');
        		}
        		else{
        			$("#score").html(data.obj.order.price);
        		}
        		$("#total-score").html(data.obj.user.score);
        	}
        	else{
        		showMessage(data.errorMsg);
        	}
            
        }
    });
	
});

//用于获得url中的参数
function request(paras){   
        var url = location.href;   
        var paraString = url.substring(url.indexOf("?")+1,url.length).split("&");   
        var paraObj = {};
        for (i=0; j=paraString[i]; i++){   
            paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length);   
        }   
        var returnValue = paraObj[paras.toLowerCase()];   
        if(typeof(returnValue)=="undefined"){   
            return "";   
        }else{   
            return returnValue;   
        }   
}
$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"url": window.location.href
        },
        url: "${pageContext.request.contextPath}/wxShareAction_getShareInfo",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		wx.config({
            		debug: false,
            		appId: data.obj.appId,
            		timestamp: data.obj.timeStamp,
            		nonceStr: data.obj.nonceStr, 
            		signature: data.obj.signature,
            		jsApiList: ['onMenuShareTimeline', 'onMenuShareAppMessage']
        		});
        		wx.ready(function () {
            		wx.onMenuShareAppMessage({
                		title: '大学生户外活动、赛事神器！',
                		desc: '大学生户外活动、赛事神器！',
                		link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2e250c455494c1f8&redirect_uri=http%3a%2f%2fwww.outdoor78.com%2fhuihuan%2floginAction_getUserInfo&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect',
                		imgUrl: 'http://www.outdoor78.com/huihuan/web/image/share/share.jpg',
                		success: function () {
                    		showMessage("分享成功！");
                		},
                		cancel: function () { 
                			showMessage("您已取消分享！");
    					}
            		});

            		wx.onMenuShareTimeline({
                		title: '大学生户外活动、赛事神器！',
                		link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2e250c455494c1f8&redirect_uri=http%3a%2f%2fwww.outdoor78.com%2fhuihuan%2floginAction_getUserInfo&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect',
                		imgUrl: 'http://www.outdoor78.com/huihuan/web/image/share/share.jpg',
                		success: function () {
                    		showMessage("分享成功！");
                		},
                		cancel: function () { 
                			showMessage("您已取消分享！");
    					}
            		});
        		});
        	}            
        },
        complete: function(xhr,status) {  
        	var sessionStatus = xhr.getResponseHeader('sessionstatus');  
        	if(sessionStatus == 'timeout') {  
            	showMessage("您还没有登陆,请登陆");
               	window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2e250c455494c1f8&redirect_uri=http%3a%2f%2fwww.outdoor78.com%2fhuihuan%2floginAction_getUserInfo&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";              
            }  
        }
    });
</script>
</body></html>
