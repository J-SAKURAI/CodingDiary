<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!-- saved from url=(0048)http://m.playoutdoor.com/components/profile.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml" class=" js flexbox flexboxlegacy canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>
	高校户外联盟
</title><meta name="format-detection" content="telephone=no"><meta name="viewport" content="target-densitydpi=device-dpi,width=750,user-scalable=no">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/swiper.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/weui.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/custom.css">
        <script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/script/layer.js"></script>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/layer.css" id="layui_layer_skinlayercss">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/style.css">
        <script src="${pageContext.request.contextPath}/web/script/swiper.min.js"></script>
        <script src="${pageContext.request.contextPath}/web/script/stickUp.min.js"></script>
        <script src="${pageContext.request.contextPath}/web/script/WhwUtil.js"></script>
        <script src="${pageContext.request.contextPath}/web/script/jweixin-1.0.0.js"></script>
    </head>
    <body>
            <div id="main-container">
                <div class="weui_mask hide"></div>
                
    <div class="profile-page">
        <div style="width:750px;height:200px;" class="block-container inner-padding profile-block">
            <div class="relative">
                <img class="avatar" id="headPic" src="">
                <div class="nickname" id="nickname"></div>

                <div><span style="margin-left:584px;margin-top:0px;" class="score"></span>
                <a style="margin-top:30px;" class="check-redpackets" href="${pageContext.request.contextPath}/web/jsp/scoreExchange.jsp">积分兑换</a>
                </div>
            </div>
        </div>
        <div id="orders">
        <div class="block-container inner-padding">
            <div class="my-order-text"></div>
        </div>
        
        <a id="detail">
            <div class="block-container inner-padding">      	
      			<div class="order-name"></div>                            
      			<div class="order-content">
           			<div id="order-id"></div>
           			<div id="meeting-time"></div>
           			<div class="left" id="price"></div>  
           			<div class="right" id="status"></div>
      		</div>
			</div>
        </a>
        </div>
        
<script>
var QZ,ZZ,SX,CX,JSLX,DRHD,SNHD,CTY;
$(function() {
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/activityOperationAction_updateOrder",
        cache: false,
        success: function(data) {
        	if(data.retcode!="0000"){
        		alert(data.errorMsg);
        	}          
        }
    });
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        
        url: "${pageContext.request.contextPath}/paymentAction_getOrderForUser",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		$("#my-order-text").html(data.obj.length);
        		var html=$("#detail").prop("outerHTML");
    			$("#detail").remove();
    			$(".my-order-text").html("我的订单（"+(data.obj.length-1)+"）");
    			$.each(data.obj,function(index, item) {
    				if(index==0){
    					$(".score").html("积分:"+item.score+"分");
    					$("#headPic").attr("src",item.headPicRoute);
    					$("#nickname").html(item.nickname);
    				}
    				else{
    					var createObj=jQuery(html);
        				//createObj.attr("href","${pageContext.request.contextPath}/web/jsp/payment.jsp?id="+item[0].id);
        				createObj.find(".order-name").html(item[1].title);
        				createObj.find("#order-id").html('订单号：NO'+item[0].id);
                		createObj.find("#meeting-time").html("出发时间："+item[1].meetingTime.substring(5, 7) + "/" +item[1].meetingTime.substring(8, 10)+" "+item[1].meetingTime.substring(11, 16));
                		//createObj.find("#meeting-place").html("集合地点："+item[1].meetingPlace); 
                		createObj.find("#price").html("价格：￥"+item[0].price);
                		createObj.find("#status").html("已支付");
                		$("#orders").append(createObj);  
                	}
        			             	
                });
        	}
        	else{
        		showMessage(data.errorMsg);
        	}
            
        }
    });
	
});

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
        <div class="shareArrows"></div>
        <div class="shareDiv weui_dialog_confirm">
            <div class="weui_mask"></div>
            <div class="weui_dialog shareDivInner">
                <div class="close-icon"></div>
                <div class="shareDiv-paySuccess">付款成功</div>
                <div style="margin: 0 30px; background-color: #fff; overflow: hidden; border-radius: 2px;">
                    <img style="float: left; margin: 10px 0px 10px 10px; width: 120px; height: 120px;" src="">
                    <div style="float: right; width: 440px; margin: 10px 20px; color: #333333; font-size: 28px; line-height: 36px;">
                        
                    </div>
                </div>
                <div style="margin: 40px 75px; font-size: 32px; color: #fff; line-height: 52px; text-align: center;">
                    就要去好玩的地方浪了，赶紧转发邀朋友一起！或者让他们嫉妒嫉妒~
                </div>
            </div>
        </div>
    </div>

    <script>
        if ("False" == "True") {

            $(".shareArrows").show();
            $(".shareDiv").show();

            //弹窗右上角关闭事件
            $(".close-icon").on("click", function () {
                $(".shareArrows").hide();
                $(".shareDiv").hide();
            });
        }
    </script>

            </div>
        </form>
        
        
    
    
     <script type="text/javascript">
         sessionStorage.setItem("LogPage", document.URL);
     </script>

<div class="sogoutip" style="z-index: 2147483645; visibility: hidden; display: none;"></div><div class="sogoubottom" id="sougou_bottom" style="display: none;"></div><div id="ext_stophi" style="z-index: 2147483647;"><div class="extnoticebg"></div><div class="extnotice"><!--<h2>关闭提示 <a href="http://m.playoutdoor.com/components/profile.aspx#" title="关闭提示" id="closenotice" class="closenotice">关闭</a></h2>--><p id="sogouconfirmtxt"></p>  <!--<a id="sogouconfirm" href="http://m.playoutdoor.com/components/profile.aspx#" class="extconfirm">确 认</a> <a id="sogoucancel" href="http://m.playoutdoor.com/components/profile.aspx#" class="extconfirm">取 消</a>--></div></div><div id="ext_overlay" class="ext_overlayBG" style="display: none; z-index: 2147483646;"></div><iframe class="sogou_sugg_feedbackquan" frameborder="0" scrolling="no" src="./玩户外－户外神器_files/yun6.html" style="border: none; display: none; z-index: 2147483645; background: transparent;"></iframe><script src="http://pb.sogou.com/pv.gif?hintbl=-1&uigs_productid=webext&type=ext_sugg&uigs_t=1469435087208&lt=308&ie=0&v=7400&y=5377BF462F6DACA4CB28EC41A6A1FD4D&query=%E7%8E%A9%E6%88%B7%E5%A4%96%EF%BC%8D%E6%88%B7%E5%A4%96%E7%A5%9E%E5%99%A8|http%3A%2F%2Fm.playoutdoor.com%2Fcomponents%2Fprofile.aspx"></script></body></html>