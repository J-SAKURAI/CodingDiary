<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml"><head><title>
	活动详情
</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="target-densitydpi=device-dpi,width=750,user-scalable=no">
   
	<script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/stickUp.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/script/layer.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/layer.css" id="layui_layer_skinlayercss">
    <!-- CheckBox style 1 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/checkbox.css">
    
    <!-- CheckBox style 2 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/index.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/tab.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/style.css?v=20160527">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/custom.css">
    <link href="${pageContext.request.contextPath}/web/css/swiper.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/web/script/swiper.min.js"></script>
    
    <script src="${pageContext.request.contextPath}/web/script/jquery.cookie.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/maintainscroll.jquery.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/WhwUtil.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/redPacket.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/jweixin-1.0.0.js"></script>

    

    <style>
        body {
            /*background: #eee;
        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
        color:#000;
        margin: 0;
        padding: 0;*/
        }
        html * {
            max-height: 9999999px;
        }
        /*更改过的代码*/
        img {
        	margin-bottom:10px;
        }
        .swiper-container {
            width: 100%;
            height: 150px;
            margin: 10px auto;
        }

        .swiper-container1 {
            width: 100%;
            height: auto;
            background: #fff;
        }

        .swiper-slide {
            /*font-size: 18px;
            color: none;*/
        }

        .space-set {
            font-size: 24px !important;
            color: #999 !important;
            word-spacing: 1px;
            letter-spacing: 8px;
            margin-left: 0 !important;
        }

        .content-slide {
            padding: 20px 50px 20px 50px;
        }

        .btn-confirm {
            position: fixed;
            width: 690px;
            /* height: 70px; */
            margin-left: 30px;
            text-align: center;
            bottom: 0;
            z-index: 9999;
            /* background-color: #6cb83b; */
            margin-bottom: 20px;
            border-radius: 10px;
            /* padding-top: 18px; */
            /*background:#ff0000;*/
            color: #fff;
            border: 0px;
            padding: 20px;
            /*width:100%;*/
        }
        /*.content-new p{
            text-indent: 2em;
            margin: 0;
            -webkit-margin-before: 10px;
            -webkit-margin-after: 10px;
        }*/
        .content-slide {
        }

        .warp-nav{
            border-bottom: 1px solid #ccc;
        }


        .order-pintuan {
            width: 690px;
            background-color: #fff;
            margin:0 auto;
            padding: 0 30px;
        }
        .order-pintuan ul{
            font-size: 24px;
        }
        .order-pintuan ul li{
            position:relative;
            width: 650px;
            height:88px;
            line-height: 88px;
            /*padding: 0 30px 0 70px;*/
            padding: 0 0 0 40px;
            color: #666666;
            border-bottom: 1px solid #ddd;
            font-size:28px;
            font-family: Arial,'Microsoft YaHei';
        }
        .act-discount{
            
        }
        .act-discount-price{
            font-size:40px;
            font-weight: bold;
            float:right;
            color:#ff0000;
            font-family: Arial,'Microsoft YaHei';
        }
        .act-pintuan-related{
            width: 650px;
            /*margin-left: 40px;*/
            background-color: #fff;
        }
        .act-pintuan-related ul li{
            position:relative;
            font-size: 24px;
            height: 88px;
            line-height: 88px;
            color: #666;
            border-bottom: 1px solid #ddd;
            font-family: Arial,'Microsoft YaHei';
        }
        .pintuan-date{
            padding: 6px;
            color: #fff;
            font-size: 24px;
            background-color: #77c143;
            border-radius: 3px;
            font-family:Arial,'Microsoft YaHei';
        }
        .pintuan-stat-date {
                font-size: 24px;
                color: white;
                background-color: #77c143;
                padding: 6px;
                border-radius: 3px;
        }

        .pintuan-price-tag{
            position:absolute;
            font-size: 20px;
            /*float: right;*/
            right:18px;
            top:-1px;
            color:#999;
            font-family: Arial,'Microsoft YaHei';
            /*margin-left:8px;*/
            /*padding-top:5px;*/
        }
        .pintuan-pirce{
            position:absolute;
            font-size:28px;
            font-weight: bold;
            right:41px;
            color:#ff3333;
            font-family:Arial;
        }
        .act-related-more{
            float:right;
            margin-left:8px;
            padding-top: 34px;
        }
        .imgp{
            position:absolute;
            top:28px;
            left:1px;
        }
        .pnum{
            /*position:absolute;
            left:70px;*/
        }


        .book-next-customise{
            padding:20px;
            margin: 0 auto;
        }

        .act-related{
            background:url(../image/common_icon.png) no-repeat left;
        }

    </style>


<style type="text/css" id="MEIQIA-ICON-STYLE">.MEIQIA-ICON { background-size: 40px auto !important; background-repeat: no-repeat !important; background-image: url("http://static.meiqia.com/dist/images/icon-mq.png?v=55wwd1f72fnwxw29") !important; } @media only screen and (-webkit-min-device-pixel-ratio: 2), only screen and (min--moz-device-pixel-ratio: 2), only screen and (-o-min-device-pixel-ratio: 2/1), only screen and (min-device-pixel-ratio: 2) { .MEIQIA-ICON { background-image: url("http://static.meiqia.com/dist/images/icon-mq@2x.png?v=55wwd1f72fnwxw29") !important; } } .MEIQIA-ICON-CHAT1 { background-position: 0 0 !important; } .MEIQIA-ICON-CHAT2 { background-position: 0 -20px !important; } .MEIQIA-ICON-CHAT3 { background-position: 0 -40px !important; } .MEIQIA-ICON-CHAT4 { background-position: 0 -60px !important; } .MEIQIA-ICON-CHAT5 { background-position: 0 -80px !important; } .MEIQIA-ICON-CHAT6 { background-position: 0 -100px !important; } .MEIQIA-ICON-CHAT7 { background-position: 0 -120px !important; } .MEIQIA-ICON-CHAT8 { background-position: 0 -140px !important; } .MEIQIA-ICON-CHAT9 { background-position: 0 -160px !important; } .MEIQIA-ICON-CHAT10 { background-position: 0 -180px !important; } .MEIQIA-ICON-CHAT11 { background-position: 0 -200px !important; } .MEIQIA-ICON-CHAT12 { background-position: 0 -220px !important; } .MEIQIA-ICON-TICKET1 { background-position: -20px 0 !important; } .MEIQIA-ICON-TICKET2 { background-position: -20px -20px !important; } .MEIQIA-ICON-TICKET3 { background-position: -20px -40px !important; } .MEIQIA-ICON-TICKET4 { background-position: -20px -60px !important; } .MEIQIA-ICON-TICKET5 { background-position: -20px -80px !important; } .MEIQIA-ICON-TICKET6 { background-position: -20px -100px !important; } .MEIQIA-ICON-TICKET7 { background-position: -20px -120px !important; } .MEIQIA-ICON-TICKET8 { background-position: -20px -140px !important; } .MEIQIA-ICON-TICKET9 { background-position: -20px -160px !important; } .MEIQIA-ICON-TICKET10 { background-position: -20px -180px !important; } .MEIQIA-ICON-TICKET11 { background-position: -20px -200px !important; } .MEIQIA-ICON-TICKET12 { background-position: -20px -220px !important; } </style><style type="text/css" id="MEIQIA-PANEL-STYLE">#MEIQIA-PANEL-HOLDER { position: fixed; bottom: 0;  right: 60px;  z-index: -1; width: 320px; height: 480px; padding: 0; margin: 0; overflow: hidden; visibility: hidden; background-color: transparent; box-shadow: 0 0 20px 0 rgba(0, 0, 0, .15); border: 1px solid #eee\0; *border: 1px solid #eee; } #MEIQIA-IFRAME { position: absolute; top: 0; right: 0; bottom: 0; left: 0; display: none; width: 100%; height: 100%; border: 0; padding: 0; margin: 0; float: none; background: none; }</style><style type="text/css" id="MEIQIA-INVITE-STYLE">#MEIQIA-INVITE, #MEIQIA-INVITE div, #MEIQIA-INVITE span { float: none; width: auto; height: auto; padding: 0; margin: 0; border: 0; background: none; } #MEIQIA-INVITE { position: fixed; z-index: 2147483639; display: none; width: 340px; height: 130px; margin-bottom: 64px; border: 1px solid #f7f7f7; border-radius: 4px; box-shadow: 0 0 14px 0 rgba(0, 0, 0, .16); text-align: left; cursor: pointer; color: #000; line-height: 1.428571429; background-color: #fff; } #MEIQIA-INVITE #MEIQIA-INVITE-ARROW1, #MEIQIA-INVITE #MEIQIA-INVITE-ARROW2 { position: absolute; font-size: 0; line-height: 0; } #MEIQIA-INVITE #MEIQIA-INVITE-ARROW1 { z-index: 2; } #MEIQIA-INVITE #MEIQIA-INVITE-ARROW2 { z-index: 1; }   #MEIQIA-INVITE { right: 60px; bottom: 0; } #MEIQIA-INVITE #MEIQIA-INVITE-ARROW1 { right: 12px; bottom: -8px; border-top: 8px solid #fff; border-right: 7px solid transparent; border-left: 7px solid transparent; } #MEIQIA-INVITE #MEIQIA-INVITE-ARROW2 { right: 11px; bottom: -10px; border-top: 9px solid #f7f7f7; border-right: 8px solid transparent; border-left: 8px solid transparent; }     #MEIQIA-INVITE #MEIQIA-INVITE-CLOSE { position: absolute; right: -20px; top: -20px; width: 40px; height: 40px; cursor: pointer;  background-position: 0 -260px;  } #MEIQIA-INVITE #MEIQIA-INVITE-CLOSE:hover {  background-position: 0 -300px;  } #MEIQIA-INVITE #MEIQIA-INVITE-INSIDE { width: 300px; height: 44px; margin: 46px 20px 0; text-align: left; font-size: 14px; line-height: 22px; overflow: hidden; color: #000; word-break: break-all; } </style></head>
<body>
    <div id="main">           
            <div class="customized-avater" style="height: 422px; position: relative">
                <img id="main_pic" src="" class="img-des-item" style="width: inherit;height:422px;">
                <ul class="activitycustomize-worddialog" id="description">                
                </ul>
                <img style="position:absolute;width:136px;height:77px;left: 30px;top: 0;" src="${pageContext.request.contextPath}/web/image/activityTheme/theme.png">
            </div>
            <div class="cus-confirm-info">
                
                
                
            </div>
            <div id="title-div" class="order-customized" style="height: auto;padding-bottom: 20px; min-height: 180px;">
                <div class="order-title">
                <h2 id="title"></h2>                    
                </div>
               <div class="act-item-type" style="padding-right: 125px; margin-bottom: 10px;margin-top:30px;" id="tags">                    
                </div>
                <div class="cus-item-fee-detail activity-detail" id="price">
                </div>                 
            </div>
            <div class="order-news" id="text">
                
            </div>
            
            
            
            <div class="cus-item-discount">
            <div class="discount-customized-info">
            <ul id="reward">
            
            </ul>
            </div>
            </div>
            <div id="info-div" class="order-customized" style="-webkit-text-size-adjust: 100%;">
                <div class="order-customized-info-header">
                    <h2>活动信息</h2>
                </div>
                <div class="order-customized-info">
                    <ul class="order-customized-info-1" id="info">
                        
                    </ul>
                </div>
            </div>

            <div class="leader-recruiment-intro" id="leader-div">
                <div class="leader-intro-header" style="background: url(${pageContext.request.contextPath}/web/image/leader/icon_player.png) no-repeat left;">
                    <h2>活动领队</h2>
                </div>
                <div class="leader-intro-content">
                    <ul class="des-item-details customized-player-list" style="padding-top: 18px;" id="leaders">                       
                                <li class="leader">
                                    <div style="position:relative">
                                        <img src="" class="img-customeized-player" style="width: 71px; height: 71px;">
                                    </div>
                                </li>                   
                    </ul>


                </div>
            </div>
            
            <div class="leader-recruiment-intro" id="user-div">
                <div class="leader-intro-header" style="background: url(../image/leader/icon_player.png) no-repeat left;">
                    <h2 id="num">已参加的伙伴（6人）</h2>
                </div>
                <div class="leader-intro-content">
                    <ul class="des-item-details customized-player-list" style="padding-top: 18px;" id="user">           
                    </ul>


                </div>
            </div>
            
            <div id="pintuanListRelated" class="leader-recruiment-intro">
                <div class="leader-intro-header act-related">
                    <h2>近期活动推荐</h2>
                </div>
                <div class="leader-intro-content act-pintuan-related">
                    <ul id="more_activities">                    
                    </ul>
                </div>
            </div>

            <!-- 
            <div class="wrap" id="content">
                <div class="wrap-nav stuckMenu" style="position: relative;">
                    <a data-name="about">目的地</a>
                    <a data-name="trip">详细行程</a>
                    <a data-name="equip">推荐装备</a>
                    <a data-name="book">预定须知</a>
                </div>
                
            </div>
            
            <div class="wrap-content" style="font-size: 24px; margin-top: 0px;">
            	 <div id="about" class="content-slide about" style="height: auto; font-family: Arial,'Microsoft YaHei'; color: #999;"></div>
                  <div id="trip" class="content-slide content-new trip" style="height: auto; font-family:Arial, 'Microsoft YaHei'; color: #999;"> </div>
                  <div id="equip" class="content-slide content-new equip" style="height: auto; font-family: Arial,'Microsoft YaHei'; color: #999;"></div>
                  <div id="book" class="content-slide content-new book" style="height: auto; font-family: Arial, 'Microsoft YaHei'; color: #999;"></div>  
            </div>      -->
            
            <div class="block-container trail-detail">
            <div class="table-style trail-detail-title wrap-nav stuckMenu" style="position: relative;">
                <div class="table-cell active" data-target="feature">目的地</div>
                <div class="table-cell" data-target="timeline">详细行程</div>
                <div class="table-cell" data-target="book-notice">推荐装备</div>                
                <div class="table-cell" data-target="free-trail">预定须知</div>
                    
            </div>
           	<div class="wrap-content" style="margin-top: 0px;margin-bottom:110px">
                
                <div class="trail-detail-content feature" data-source="feature" id="destination">
                </div>
                    
                <div class="trail-detail-content hide" data-source="timeline" id="timeline">
                    
                </div>
                <div class="trail-detail-content book-notice hide" data-source="book-notice" id="recommendation">
        
                </div>
                <div class="trail-detail-content worry-list hide" data-source="free-trail" id="book-notice">
                </div>
            </div>        
                
            <a href="${pageContext.request.contextPath}/web/jsp/main.jsp" style="display:block; width:100px; height:100px; position: fixed; top: 246px; margin-left:620px; z-index: 9999;">
                <img src="${pageContext.request.contextPath}/web/image/index/more_activity.png" alt="返回定制活动首页" style="margin: 0; padding: 0; border: none;">
            </a>
            <div class="bottom-btns">
                <div class="customer-service-container">                   
        			<div class="customer-service-activity">
           	 			<a href="tel:021-37697991">
                		<div class="customer-service-tel">
                    	<div class="tel-activity"></div>
                    	<div class="customer-service-text">客服电话</div>
                		</div>
            			</a>
            		<div class="customer-service-chat">
            			<a href="https://static.meiqia.com/dist/standalone.html?eid=27557">
                		<div class="chat-icon online-activity"></div>
                		<div class="customer-service-text">在线客服</div>
                		</a>     
            		</div>
            		<div class="clear"></div>
        			</div>
        		</div>
                <div id="canNotBookTextContainer" class="redirect-to-order-btn"></div>
            </div>
        
<div style="display:none">        
<div class="detail-discount" style="-webkit-overflow-scrolling: touch; color:#666">
    <div style="margin-top: 20px;margin-bottom:20px; text-align:center; line-height:40px; font-size:40px; color:#333" id="for-append">特惠规则</div>
    <div style=" overflow:hidden; margin-top:40px; width:500px;" id="basic-div">
        <div style="float:left; width:180px; display:inline-block;">
            <span style="display:inline-block;" id="type">礼</span>
            <span style="font-weight: bold; display:inline; font-size:24px; color: #000; margin-left:5px;" id="name">[健游礼包]</span>
        </div><div style="float:right; width:320px; margin-top: 4px; color:#666; line-height:36px;" id="content">赠送价值¥388健游礼包</div>
    </div>
    <div style="overflow:hidden;  margin-top: 10px; line-height:36px;" id="detail-div">
        <div style="float: left; color:#666; width:110px; margin-right:10px; text-align:center;">使用说明:</div>
        <div style="width:500px;" id="description">
            报名参与活动即可享有。
        </div>
    </div>
    
</div>
</div>
<div style="display:none" id="more">
<div style="color:red;margin-top: 20px;">***** 以上优惠，在支付时自动减免！ *****</div>
    <div style="margin-top: 20px; color:#333;">注：</div>
    <div>每个户外徒步活动可参与用户有上限（受当地资源等限制），以付款时间为准，超出上限的用户，全额退款。</div>
    <div>本活动所有解释权归高校户外联盟所有。</div>
    </div>
<script type="text/javascript">
var url=window.location.href;
$(function() {
    // dom加载完毕 
    var html;
	var id = request("id");
	id=id.split("#")[0];
	var meeting_place="";
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"id": id
        },
        url: "${pageContext.request.contextPath}/activityDetailAction_getActivityDetail",
        cache: false,
        success: function(data) {       	
        	if(data.retcode=="0000"){
        			var title=data.obj.activity.title;
                    var picRoute=data.obj.activity.mainPicRoute;
        			$.ajax({
        				type: "post",
        				async: true,
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
                						title: title,
                						desc: title,
                						link: url,
                						imgUrl: 'http://www.outdoor78.com/huihuan'+picRoute,
                						success: function () {
                    						showMessage("分享成功！");
                						},
                						cancel: function () { 
                							showMessage("您已取消分享！");
    									}
            					});
            					wx.onMenuShareTimeline({
                					title: title,
                					link: url,
                					imgUrl: 'http://www.outdoor78.com/huihuan'+picRoute,
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
               				window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2e250c455494c1f8&redirect_uri=http%3a%2f%2fwww.outdoor78.com%2fhuihuan%2floginAction_getUserInfo&response_type=code&scope=snsapi_userinfo&state="+url+"#wechat_redirect";              
            			}  
        			}
    				});
        			time = data.obj.activity.startTime.substring(5, 7) + "/" + data.obj.activity.startTime.substring(8, 10)+ "-" +  data.obj.activity.endTime.substring(5, 7) + "/" + data.obj.activity.endTime.substring(8, 10);
        			if(data.obj.meetingPlaces.length>0){
        				var meeting_places="";
        				for (var i = 0; i < data.obj.meetingPlaces.length; i++) {
        					meeting_places+=data.obj.meetingPlaces[i].placeName+"/";
        				}
        				meeting_places=meeting_places.substring(0, meeting_places.length-1);
        				$("#info").append("<li>活动时间 :<span>"+time+"</span></li><li> 目  的  地 :<span>"+data.obj.activity.destination+"</span></li><li>集合时间 :<span>"+data.obj.activity.meetingTime.substring(0, 10) + " " +data.obj.activity.meetingTime.substring(11, 16) +"</span></li><li>集合地点 :<span>"+meeting_places+"</span></li><li>费用构成 :<span>"+data.obj.activity.costComponent+"</span></li>");
        			}
        			else{
        				$("#info").append("<li>活动时间 :<span>"+time+"</span></li><li> 目  的  地 :<span>"+data.obj.activity.destination+"</span></li><li>集合时间 :<span>"+data.obj.activity.meetingTime.substring(0, 10) + " " +data.obj.activity.meetingTime.substring(11, 16) +"</span></li><li>费用构成 :<span>"+data.obj.activity.costComponent+"</span></li>");
        			}
        			$("#main_pic").attr("src","${pageContext.request.contextPath}"+data.obj.activity.mainPicRoute);
                	$("#title").html(data.obj.activity.title);
                	$("#about").append(data.obj.activity.content1);
                	$("#trip").append(data.obj.activity.content2);
                	$("#equip").append(data.obj.activity.content3);
                	$("#book").append(data.obj.activity.content4);
                	$("#description").append("<li><div></div><div>"+data.obj.activity.description1+"</div><div></div></li><li><div></div><div>"+data.obj.activity.description2+"</div><div></div></li><li><div></div><div>"+data.obj.activity.description3+"</div><div></div></li>")
                	
                	$("#tags").append("<span style='margin-bottom: 5px;margin-right:5px;'>"+data.obj.activity.tag1+"</span>");
                	$("#tags").append("<span style='margin-bottom: 5px;margin-right:5px;'>"+data.obj.activity.tag2+"</span>");
                	$("#tags").append("<span style='margin-bottom: 5px;margin-right:5px;'>"+data.obj.activity.tag3+"</span>");
                	$("#price").append("<h2><span class='fee-red'>¥</span>"+data.obj.activity.offPrice+"</h2><span class='sale-red market-price'>市场价: ¥"+data.obj.activity.originalPrice+"</span>");
                	$("#text").append("<h2>"+data.obj.text+"</h2>");              	
                	meeting_time=data.obj.activity.meetingTime;
                	if(data.obj.rewards.length!=0){
                		$("#text").after("<div style='position: relative'><div id='order-discount-detail' class='show-discount-detail' style='display:inline-block;'>特惠规则</div></div>");
                	}
                	$.each(data.obj.rewards,function(index, item) {
                		if(item.color=='0'){
                			$("#reward").append("<li><span style='background: #009f95;'>"+item.type+"</span><span style='font-weight: bold;'>["+item.name+"]</span><span style='color: #666666;'>"+item.content+"</span></li>");
                		}
                		else if(item.color=='1'){
                			$("#reward").append("<li><span style='background: #fe7000;'>"+item.type+"</span><span style='font-weight: bold;'>["+item.name+"]</span><span style='color: #666666;'>"+item.content+"</span></li>");
                		}
                		else{
                			$("#reward").append("<li><span style='background: #6cb83b;'>"+item.type+"</span><span style='font-weight: bold;'>["+item.name+"]</span><span style='color: #666666;'>"+item.content+"</span></li>");
                		}
                		
                	});               	
                	//显示优惠详情
                	$('#order-discount-detail').on('click', function () {
                		var html=$(".detail-discount").prop("outerHTML");
                		var html1=$("#basic-div").prop("outerHTML");
                		var html2=$("#detail-div").prop("outerHTML");
                		var total=jQuery(html);                		
                		total.find("#basic-div").remove();
                		total.find("#detail-div").remove();
                		$.each(data.obj.rewards,function(index, item) {
                			var basic_div=jQuery(html1);
                			var detail_div=jQuery(html2);
                			basic_div.find("#type").html(item.type);
                			if(item.color=='0'){
                				basic_div.find("#type").css('background','#009f95');
                			}
                			else if(item.color=='1'){
                				basic_div.find("#type").css('background','#fe7000');
                			}
                			else{
                				basic_div.find("#type").css('background','#6cb83b');
                			}
                			basic_div.find("#name").html("["+item.name+"]");
                			basic_div.find("#content").html(item.content);
                			detail_div.find("#description").html(item.description);
                			total.append(basic_div);
                			total.append(detail_div);
                		});
                		total.append($("#more").html());
                		var total_html=total.prop("outerHTML"); 
    					layer.closeAll();
        				layer.open({
         					type: 1,
         					shadeClose: true,
         					title: false,
         					shade: 0.8,
         					area: ['590px', '87%'],
         					content: total_html,
         					offset:['7%'],
         					/*success: function (layero, index) {
        						layero.css("top", (100));
        					}*/
     					});
    				});
                	var html=$(".leader").prop("outerHTML");
                	$(".leader").remove();
        			$.each(data.obj.leaders,function(index, item) {
        				var createObj=jQuery(html);
        				createObj.find("img").attr("src","${pageContext.request.contextPath}"+item.headPicRoute);
                		createObj.append("<input type='hidden' id='itemId' value='"+item.id+"'/>");
                		$("#leaders").append(createObj);               	
                	});       
                	//显示领队详情
					$(".leader").on("click", function () {
						var leader_id=$(this).closest("li").find("#itemId").val();
    					layer.closeAll(); //关闭所有层
    					$.ajax({
        					type: "post",
        					async: true,
        					dataType: "json",
        					//收受数据格式
        					data: {"itemId":leader_id},
        					url: "${pageContext.request.contextPath}/leaderOperationAction_getLeaderDetailInfo",
        					cache: false,
        					success: function(data) {
        						if(data.retcode=="0000"){
        							layer.open({
         								type: 1,
         								shadeClose: true,
         								title: false,
         								shade: 0.8,
         								area: ['590px', '87%'],
         								content: data.obj,
         								offset:['7%'],
         								/*success: function (layero, index) {
        									layero.css("top", (100));
        								}*/
     								});
        						}
        						else{
        							showMessage(data.errorMsg);
        						}
        					}
    					});         				
					});
					var total_people=0;  
					var c=Math.floor(Math.random()*16)+1;       		
                	if(data.obj.participtors.length!=0){             		
                		$.each(data.obj.participtors,function(index, item) {
                			if(item[0]=='none'){
                				if(c!=16){
                					c=c+1;
                				}
                				else{
                					c=1;
                				}
                				$("#user").append("<li><div style='position:relative'><img src='${pageContext.request.contextPath}/web/image/HeadPics/"+c+".jpg' class='img-customeized-player' style='width: 71px; height: 71px;'><div class='customized-player-count'><div style='font-family:Arial;font-weight:bold;display:inline-block;'>"+item[1]+" </div>人</div></div></li>");
                			}
                			else{        				
                				$("#user").append("<li><div style='position:relative'><img src='"+item[0].headPicRoute+"' class='img-customeized-player' style='width: 71px; height: 71px;'><div class='customized-player-count'><div style='font-family:Arial;font-weight:bold;display:inline-block;'>"+item[1]+" </div>人</div></div></li>");
                			}
                			total_people=total_people+item[1];
                		});
                	}      
                	$("#num").html("已参加的伙伴     "+total_people+"人");         	
                	
                	if(data.obj.activity.maxPeople<=total_people){
                		$("#canNotBookTextContainer").css('background-color','#ccc');
                		$("#canNotBookTextContainer").append("<a onclick='cantgo()' id='canBookText'>报名已截止</a>");
                	}
                	else{
                		$("#canNotBookTextContainer").append("<a href='../jsp/orderSubmit.jsp?id="+id+"' id='canBookText'>我也要去</a>");
                	}         
                	
                	$("#destination").html(data.obj.activity.preHtml1); 
                	$("#timeline").html(data.obj.activity.preHtml2); 
                	$("#recommendation").html(data.obj.activity.preHtml3); 
                	$("#book-notice").html(data.obj.activity.preHtml4);     		
        	}
        	else{
        		showMessage(data.errorMsg);
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
        data: {
        	"id": id
        },
        url: "${pageContext.request.contextPath}/activityDetailAction_getSimilarActivities",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		$.each(data.obj,function(index, item) {
        			html="<a href='../jsp/singleActivity.jsp?id="+item.id+"'><li>";
        			if(item.title.length>=23){
        				html+=item.title.substring(0,23)+"  ...<span id='rptActRealted_showPinTuan_0' class='pintuan-date' style='display:none;'></span>";
        			}
                	else{
                		html+=item.title+"<span id='rptActRealted_showPinTuan_0' class='pintuan-date' style='display:none;'></span>";
                	}
                    html+="<div class='act-related-more'><img src='../image/ico_more.png'></div>";
                    html+="<span class='pintuan-price-tag'>起</span><span class='pintuan-pirce'>¥"+item.offPrice;
                    html+="</span></li></a>";
        			$("#more_activities").append(html);
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
});

function cantgo(){
	showMessage("该活动已达到报名人数上限！");
	return;
}

function request(paras){   
        var url = location.href;   
        var paraString = url.substring(url.indexOf("?")+1,url.length).split("&");   
        var paraObj = {}   
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

//固定导航栏，并在点击时移到相应位置
		jQuery(function ($) {
            $(document).ready(function () {
                //enabling stickUp on the '.navbar-wrapper' class
                $('.wrap-nav').stickUp();
            });
            $(".wrap-nav div").bind("click", function () {
                $(".trail-detail-title div").removeClass("active");
                $(event.target).addClass("active");
                $(".trail-detail-content").addClass("hide");
                var targetId = $(event.target).attr("data-target");
                $(".trail-detail-content[data-source='" + targetId + "']").removeClass("hide");
                var scrollHeight = $(".customized-avater").outerHeight() + 20 + $("#title-div").outerHeight() + $(".order-news").outerHeight() ;
                scrollHeight += $(".cus-item-discount").outerHeight() +20+ $("#info-div").outerHeight() +20+ $("#leader-div").outerHeight() + 20;
                scrollHeight += $("#user-div").outerHeight() +20+ $("#pintuanListRelated").outerHeight() + 20;
                $("html,body").animate({ scrollTop: scrollHeight }, 0);

            });
        });

    (function(m, ei, q, i, a, j, s) {
        m[a] = m[a] || function() {
            (m[a].a = m[a].a || []).push(arguments)
        };
        j = ei.createElement(q),
            s = ei.getElementsByTagName(q)[0];
        j.async = true;
        j.charset = 'UTF-8';
        j.src = i + '?v=' + new Date().getUTCDate();
        s.parentNode.insertBefore(j, s);
    })(window, document, 'script', '//static.meiqia.com/dist/meiqia.js', '_MEIQIA');
    _MEIQIA('entId', 18477);

    _MEIQIA('allSet', allSetCallback);

    var withoutBtn = 'True';
    if (withoutBtn == "True") {
        _MEIQIA('withoutBtn', true);
    }

    function allSetCallback(servability) {
        setMetaData();
        updateOnlineStatus(servability);
    }

    function setMetaData() {
        var nickName = "";
        if (nickName) {
            _MEIQIA._SENDMETADATA({ name: nickName, "用户ID": '0' });
        }
    }

    function updateOnlineStatus(servability) {
        var pageType = "activity-detail";
        if (pageType == "home") {
            $(".customer-service-index").on("click", function () { showChatWindow(); });
        } else if (pageType == "player") {
            $(".customer-service-player").on("click", function () { showChatWindow(); });
        } else if (pageType == "activity-detail") {
            $(".customer-service-chat").on("click", function () { showChatWindow(); });
        } else if (pageType == "order-detail") {
            $(".customer-service-order .chat-order-container").on("click", function () { showChatWindow(); });
        }
    }

    function isIOSWechat() {
        var isWechat = 'False';
        var isIOS = /iPad|iPhone|iPod/.test(navigator.userAgent) && !window.MSStream;
        if (isIOS && isWechat == "True") {
            return true;
        } else {
            return false;
        }
    }

    function showChatWindow() {
        if (isIOSWechat()) {
            window.open("/CustomerService.aspx");
        } else {
            _MEIQIA._SHOWPANEL();
        }
    }
</script>
<script src="${pageContext.request.contextPath}/web/script/jquery.cookie.js"></script><script src="${pageContext.request.contextPath}/web/script/maintainscroll.jquery.js"></script>
<script src="${pageContext.request.contextPath}/web/script/WhwUtil.js"></script><span style="display:none;" id="whwAppId">wx94cf6054b27fafa5</span><div id="shareArrows" style="background: url(../image/share_icon.png) no-repeat !important; position:absolute; top:20px; right:30px; z-index:19891999; width:63px; height:83px; display:none;"></div>
<div id="double-single-arrow" style="background: url(../image/redPacket/single-double.png) no-repeat !important; position:absolute; top:0px; right:10px; z-index:19891999; width:67px; height:503px; display:none;"></div>
<div id="already-arrow" style="background: url(../image/redPacket/8.8_already.png) no-repeat !important; position:absolute; top:0px;right: 10px; z-index:19891999; width:73px; height:620px; display:none;"></div>
<script src="${pageContext.request.contextPath}/web/script/redPacket.js"></script></form>
    </div>

<div id="MEIQIA-PANEL-HOLDER"><iframe id="MEIQIA-IFRAME" src="http://eco-api.meiqia.com/dist/desktop-fiesta.html?55wwd1f72fnwxw29" frameborder="0" scrolling="no" allowtransparency="true"></iframe> </div>
<div id="MEIQIA-INVITE"><span id="MEIQIA-INVITE-CLOSE" class="MEIQIA-ICON"></span> 
<div id="MEIQIA-INVITE-INSIDE">您好，当前有专业客服人员在线，让我们来帮助您吧。</div> 
<span id="MEIQIA-INVITE-ARROW1"></span> <span id="MEIQIA-INVITE-ARROW2"></span></div></body></html>
