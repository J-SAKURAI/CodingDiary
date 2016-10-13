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

<script type="text/javascript">
//<![CDATA[
var theForm = document.forms['Form1'];
if (!theForm) {
    theForm = document.Form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</script>

        <div id="main" style="height:800px;">
            <div class="order" id="order">
                <div class="order-pay-title">
                    <h2>订单信息</h2>
                </div>
                <div class="order-info" style="height:auto;">
                    <ul class="order-basic order-basic-noborder" style="width:650px">
                        <li>订单编号:<span id="id">NO20160709164412230</span></li>
                        <li>活动名称:<span id="title">7.23莫干山.轻装徒步.</span></li>
                        <li>订单总额:<span id="total_price">238</span></li>
                        <li>实际付款:<span class="color-red" style="font-size: 44px" id="price">¥238</span></li>
                    </ul>
                </div>
            </div>
            <div class="order" style="">
                <img style="float:left;" src="${pageContext.request.contextPath}/web/image/item.png">
                <div class="order-payway-title">
                    <h2>立即支付</h2>
                </div>
                <div class="order-payway-content-wechat">
                    <a id="AliPayButton" onclick="callpay()">
                        <img src="${pageContext.request.contextPath}/web/image/wechat_icon.png">
                        微信支付
                        <img class="arrow" src="${pageContext.request.contextPath}/web/image/arrowRight.png">
                    </a>
                    
                </div>
            </div>
        </div>
<script type="text/javascript">

/**********************初始化页面*************************/
var activity_price;
var id = request("id"); 
var order_id="",total_fee=0,body="";
$(function() {
    // dom加载完毕
    //showMessage("请输入您的身份证号码");
    
    $.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"id": id
        },
        url: "${pageContext.request.contextPath}/paymentAction_getOrder",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		var html=$(".order-info").prop("outerHTML");
    			$(".order-info").remove();
    			var createObj=jQuery(html);
    			order_id=data.obj.id;
    			total_fee=data.obj.price;
    			createObj.find("#id").html("NO"+data.obj.id);
    			createObj.find("#title").html(data.obj.title);
    			createObj.find("#total_price").html(data.obj.price);
    			createObj.find("#price").html(data.obj.price);
    			$("#order").append(createObj);
    			body="感谢您参与"+data.obj.title+"。";
        	} 
        	else{
        		showMessage(data.errorMsg);
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
});

function callpay(){
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"body": body,
        	"order_id": order_id,
        	"total_fee": total_fee
        },
        url: "${pageContext.request.contextPath}/paymentAction_payOrderAgain",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		WeixinJSBridge.invoke(
       				'getBrandWCPayRequest', {
           				"appId": data.obj.appId,     //公众号名称，由商户传入     
           				"timeStamp": data.obj.timeStamp,         //时间戳，自1970年以来的秒数     
           				"nonceStr" : data.obj.nonceStr, //随机串     
           				"package" : data.obj.packages,     
           				"signType" : data.obj.signType,         //微信签名方式：     
           				"paySign" : data.obj.sign //微信签名 
       				},
       				function(res){     
          				WeixinJSBridge.log(res.err_msg);
          				//alert(res.err_code + res.err_desc + res.err_msg);
	            			if(res.err_msg == "get_brand_wcpay_request:ok"){
	                			showMessage("微信支付成功!");
	                			$.ajax({
        							type: "post",
        							async: true,
        							dataType: "json",
        							//收受数据格式
        							data: {
        								"order_id": order_id
        							},
        							url: "${pageContext.request.contextPath}/paymentAction_setOrderStatusForSuccess",
        							cache: false,
        							success: function(data) {
            							if(data.retcode!="0000"){
            								showMessage(data.errorMsg);
        								}
        								else{
        									window.location.href="${pageContext.request.contextPath}/web/jsp/paySuccess.jsp?id="+order_id;
        								}
        							}
    							});
	                			
	            			}
	            			else if(res.err_msg == "get_brand_wcpay_request:cancel"){
	                			showMessage("您已取消支付!");
	            			}
	            			else{
	               				showMessage("支付失败!");
	            			}
       				}
   				); 
        	} 
        	else{
        		showMessage(data.errorMsg);
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
   
   
}

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
</script>

<script src="${pageContext.request.contextPath}/web/script/jweixin-1.0.0.js"></script>
    <script type="text/javascript">
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