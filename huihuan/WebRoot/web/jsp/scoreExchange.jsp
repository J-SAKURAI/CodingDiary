<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!-- saved from url=(0023)https://h5.ele.me/gift/ -->
<html perf-error="complain/index" data-dpr="1" style="font-size: 54px;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><meta name="eleme-share">

        <meta name="eleme-share:title" content="饿了么积分商城，任性兑换不花钱">
        <meta name="eleme-share:description" content="叫外卖，上饿了么，免费好礼等你来拿">
        <meta name="eleme-share:image" content="https://fuss10.elemecdn.com/3/ca/80d890e2515fea76e46490a2c9455png.png">
    <meta charset="utf-8">
    <meta name="format-detection" content="telephone=no, email=no">
    <script src="./积分商城_files/flexible.js"></script><meta name="viewport" content="target-densitydpi=device-dpi,width=750,user-scalable=no">
    <link rel="stylesheet" href="https://npm.elemecdn.com/vue-swipe@0.2.5/dist/vue-swipe.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/style1.css">
	
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/layer.css" id="layui_layer_skinlayercss">
	<script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/layer.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/jweixin-1.0.0.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/swiper.min.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/WhwUtil.js"></script>
    <title>积分商城</title>
  </head>
  
  <body style="font-size: 12px;width:750px;margin: 0 auto;">
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="position:absolute;width:0;height:0;visibility:hidden"><defs><symbol viewBox="0 0 547 987" id="arrow-right"></symbol></defs></svg>
    <header> <header class="eleme-header" style="background:#77c043;height:60px;"> 
           <a href="javascript:"> <svg></svg> </a> <center><h3>积分商城</h3></center> <a href="https://h5.ele.me/gift/javascript"></a></header> </header>
  	<section class="clearfix point-mall" style="height:200px;"> 
  		<div class="swiper-container swiper-container-horizontal">
                <div id="main_pic" class="swiper-wrapper" style="transition-duration: 0ms; -webkit-transition-duration: 0ms; transform: translate3d(-7.13525390625px, 0px, 0px); -webkit-transform: translate3d(-7.13525390625px, 0px, 0px);">     
                </div>
                <!-- Add Pagination -->
                <div class="swiper-pagination swiper-pagination-clickable"><span class="swiper-pagination-bullet swiper-pagination-bullet-active"></span><span class="swiper-pagination-bullet"></span><span class="swiper-pagination-bullet"></span><span class="swiper-pagination-bullet"></span></div>
                <!-- Add Arrows -->
                <!-- <div class="swiper-button-next"></div>
		        <div class="swiper-button-prev"></div> -->
                </div>
  	</section>



   <section class="clearfix point-mall"> </section>
         <section class="gift-points" style="margin-bottom:20px;margin-top:20px;"> <div class="gift-points-left"> <a class="my-points"> <span class="my-points-text">我的积分</span> <span class="gift-points-num">3579</span> </a>   </div> <span class="my-points-text"><h2>兑换记录</h2></span> </section> 


    <section class="clearfix point-cate">  <div class="no-gift-draw-records" style="display: none;"></div> </section>
         <section> 
            <div class="gift-list-content clearfix" infinite-scroll-disabled="busy" infinite-scroll-distance="60" style=""> <!--fragment-start-->
            
            <div class="list-sublist" _v-9e1f23b2="" ubt-click="1202" ubt-data-sort_index="0"> 
            	<a class="list-sublist-content" _v-9e1f23b2=""> 
            		<p class="list-sublist-name" _v-9e1f23b2="">iPhone 6s Plus</p> 
            		<p class="list-sublist-subname" _v-9e1f23b2="">奖品价值5888元</p> 
            		<p class="list-sublist-points"_v-9e1f23b2=""> 
            			<span class="list-points-num" _v-9e1f23b2="">599</span> 
            			<span class="list-points-text" _v-9e1f23b2="">积分</span><!--v-if-->
            			<span class="listtype" _v-9e1f23b2="">兑换</span> 
            		</p>
					<div class="list-sublist-img" _v-9e1f23b2=""> 
						<img src="./积分商城_files/8838aa16b31e1898b584dfe847f49jpeg.jpeg" _v-9e1f23b2="">
					</div> 
				</a> 
			</div>
			
			</div>
			
           <div class="points-record-empty" style="display: none;"></div> 
           <p class="load-is-loading" style="display: none;">正在加载中...</p> 
           <p class="load-is-loading" style="display: none;"> 积分商城活动由饿了么提供，与Apple Inc无关 </p>
           </section> <div class="load-wrap load-transition" _v-65d5b5a7="" style="z-index: 8888; display: none;"> 
           <div class="loading-main" _v-65d5b5a7=""> 
           <div class="loading-icon" _v-65d5b5a7=""></div> 
           <div class="loading-bottom" _v-65d5b5a7=""></div> </div> </div> <div class="backtop-container" _v-4cf10976="">  </div>

<script>
$(function() {
	$.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/getActivitiesAction_getMainPic",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		$.each(data.obj,function(index, item) {
        			if(item.link!=null&&item.link!=''){
        				$("#main_pic").append("<div class='swiper-slide style='width: 750px; margin-right: 30px;''><a href='"+item.link+"'><img id='showInfo1' src='"+"${pageContext.request.contextPath}"+item.picRoute+"' style='height:202px;'></img><a></div>");
        			}
        			else{
        				$("#main_pic").append("<div class='swiper-slide style='width: 750px; margin-right: 30px;''><img id='showInfo1' src='"+"${pageContext.request.contextPath}"+item.picRoute+"' style='height:202px;'></img></div>");
        			}                	
                });
                //初始化图片滑动
    			var swiper = new Swiper('.swiper-container', {
                        pagination: '.swiper-pagination',
                        nextButton: '.swiper-button-next',
                        prevButton: '.swiper-button-prev',
                        paginationClickable: true,
                        spaceBetween: 30,
                        centeredSlides: true,
                        autoplay: 3500,
                        autoplayDisableOnInteraction: false
    			});
        	}     
        },
        complete: function(xhr,status) {  
        	var sessionStatus = xhr.getResponseHeader('sessionstatus');  
        	if(sessionStatus == 'timeout') {  
            	showMessage("您还没有登陆,请登陆");
               	window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2e250c455494c1f8&redirect_uri=http%3a%2f%2fwww.outdoor78.com%2fhuihuan%2floginAction_getUserInfo&response_type=code&scope=snsapi_userinfo&state="+url+"#wechat_redirect";              
            }  
        }
    });
    
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        
        url: "${pageContext.request.contextPath}/scoreExchangeAction_getGoods",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		var html=$(".list-sublist").prop("outerHTML");
               	$(".list-sublist").remove();
        		$.each(data.obj,function(index, item) {
        			var createObj=jQuery(html);
        			createObj.find(".list-sublist-name").html(item.name);
        			createObj.find(".list-sublist-subname").html(item.info);
        			createObj.find(".list-points-num").html(item.score);
        			createObj.find("img").attr("src","${pageContext.request.contextPath}"+item.picRoute);
                	createObj.append("<input type='hidden' id='itemId' value='"+item.id+"'/>");
                	$(".gift-list-content").append(createObj);               	
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
</body></html>