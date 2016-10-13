<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>大学生户外活动社交神器！</title>
    
	<meta name="viewport" content="target-densitydpi=device-dpi,width=750,user-scalable=no">
	<script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/css/dist/js/swiper.min.js"></script>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/menu.css" media="all">
    <!-- CSS reset -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/dist/css/swiper.css">

    <!-- CheckBox style 1 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/checkbox.css">

    <!-- CheckBox style 2 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/index.min.css">

    <!-- Modernizr -->
    <script src="${pageContext.request.contextPath}/web/script/modernizr.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/script/layer.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/layer.css" id="layui_layer_skinlayercss">
    <!-- Resource style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/style.css">
    <style>
        .navbar-wrapper {
            height: 85px;
        }

        .nav-items {
            height: 85px;
        }

        .nav-items span {
            height: 75px;
            text-align: center;
            vertical-align: middle;
            padding-top: 23px;
        }

        .nav-items {
            font-size: 28px;
            color: #555;
            /*z-index: 9999;*/
        }

            .nav-items ul li {
                height: 85px;
                line-height: 85px;
            }

        .layui-layer-setwin {
            width: 39px !important;
            height: 39px !important;
        }

            .layui-layer-setwin a {
                width: 39px !important;
                height: 39px !important;
                margin-left: -10px !important;
                /*font-size: 12px;*/
                /*_overflow: hidden;*/
            }

        .layui-layer-ico {
            /*background*/
            background: url(../image/btn_close.png) no-repeat !important;
        }
    </style>
  </head>
  
  <body>

        <div id="main">
            <div style="width: 1px; height: 1px; overflow: hidden; display: none;">
                <img src="${pageContext.request.contextPath}/web/image/share1.jpg">
            </div>
            <div class="top">
                <!-- Swiper -->
                <div class="swiper-container swiper-container-horizontal">
                    <div id="main_pic" class="swiper-wrapper" style="transition-duration: 0ms; -webkit-transition-duration: 0ms; transform: translate3d(-7.13525390625px, 0px, 0px); -webkit-transform: translate3d(-7.13525390625px, 0px, 0px);">     
                    </div>
                    <!-- Add Pagination -->
                    <div class="swiper-pagination swiper-pagination-clickable"><span class="swiper-pagination-bullet swiper-pagination-bullet-active"></span><span class="swiper-pagination-bullet"></span><span class="swiper-pagination-bullet"></span><span class="swiper-pagination-bullet"></span></div>
                    <!-- Add Arrows -->
                    <!-- <div class="swiper-button-next"></div>
		        <div class="swiper-button-prev"></div> -->
                </div>

                <img src="${pageContext.request.contextPath}/web/image/common/logo.png" style="position: absolute; width: 100px; top: 16px; left: 16px; z-index: 9999;">
                
            </div>

            <div class="navbar-wrapper stuckMenu">
                <div class="nav-items">
                    <span style="width: 33.33%" data-target="sale" data-value="0" id="sale">特价<i></i></span>
                    <span style="width: 33.33%" data-target="sort" data-value="0" id="time">全年活动<i></i></span>
                    <span style="width: 33.33%" data-target="filter" data-value="0" id="select"><i style="float: left"></i>活动筛选</span>
                    <div style="clear: both"></div>
                    
                    <ul class="hide sale">
                        <li data-text="全部活动" data-value="0">全部活动</li>
                        
                        <li data-text="特价活动" data-value="1">特价活动</li>        
                    </ul>

					<ul class="hide sort" id="hide_sort">
						<li data-text="全年活动" data-value="0">全年活动</li>
                    </ul>
                    
                    <ul class="hide filter">
                        <li data-text="全部活动" data-value="0">全部活动</li>
                        
                                <li data-text="轻装（农家）" data-value="1">轻装（农家）</li>
                            
                                <li data-text="重装（露营）" data-value="2">重装（露营）</li>
                            
                                <li data-text="水线" data-value="3">水线</li>

                                <li data-text="长线" data-value="4">长线</li>
                            
                                <li data-text="技术路线" data-value="5">技术路线</li>

                                <li data-text="单日活动" data-value="6">单日活动</li>

                                <li data-text="市内活动" data-value="7">市内活动</li>

                                <li data-text="初体验" data-value="8">初体验</li>
                            
                    </ul>
                </div>
            </div>
            <!--luoxiaoyan-->
            <div class="cus-item-list" style="margin-bottom: 20px; margin-top: 0;" id="activities">
            <!-- -->    
            </div>
            <div data-role="widget" data-widget="nav4" class="nav4">
                <nav>
                    <div id="nav4_ul" class="nav_4">
                        <ul class="box">
                            
                            <li>
                                <a href="#" class="">
                                    <span>户外出行</span>
                                    <img src="${pageContext.request.contextPath}/web/image/mainBottomPic/bottomPic1.png">
                                </a>
                            </li>
                            <li>
                                <a href="#" class="">
                                    <span >装备商城</span>
                                    <img src="${pageContext.request.contextPath}/web/image/mainBottomPic/bottomPic2.png">
                                </a>
                            </li>
                            <li>
                                <a href="#" class="">
                                    <span >活动定制</span>
                                    <img src="${pageContext.request.contextPath}/web/image/mainBottomPic/bottomPic3.png">
                                </a>
                            </li>
                            <li>
                                <a href="userCenter.jsp" class="">
                                    <span >我的订单</span>
                                    <img src="${pageContext.request.contextPath}/web/image/mainBottomPic/bottomPic4.png">
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div id="nav4_masklayer" class="masklayer_div on">
                    &nbsp;
                </div>

            </div>
        </div>
    
<script src="${pageContext.request.contextPath}/web/script/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath}/web/script/maintainscroll.jquery.js"></script>
<script src="${pageContext.request.contextPath}/web/script/WhwUtil.js"></script>
<span style="display:none;" id="whwAppId">wx94cf6054b27fafa5</span>
<div id="shareArrows" style="background: url(../image/share_icon.png) no-repeat !important; position:absolute; top:20px; right:30px; z-index:19891999; width:63px; height:83px; display:none;"></div>
<div id="double-single-arrow" style="background: url(../image/redPacket/single-double.png) no-repeat !important; position:absolute; top:0px; right:10px; z-index:19891999; width:67px; height:503px; display:none;"></div>
<div id="already-arrow" style="background: url(../image/redPacket/8.8_already.png) no-repeat !important; position:absolute; top:0px;right: 10px; z-index:19891999; width:73px; height:620px; display:none;"></div>
<script src="${pageContext.request.contextPath}/web/script/redPacket.js"></script>
<script src="${pageContext.request.contextPath}/web/script/stickUp.min.js"></script>
<script src="${pageContext.request.contextPath}/web/script/main.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">  
var url=window.location.href;
/**********************页面初始化*************************/
 /*var obj = new WxLogin({
     id:"main", 
     appid: "wx2e250c455494c1f8", 
     scope: "snsapi_login", 
     redirect_uri: "http%3a%2f%2flocalhost%3a8080%2fmenglv%2fweb%2fjsp%2fmain.jsp",
     style: "white"
});*/
                   
$(function() {
    // dom加载完毕
    var today = new Date();
    var month = today.getMonth() + 1;
    for (var j = month; j <= 12; j++) {
        $("#hide_sort").append("<li data-text='" + j + "月' data-value='" + j + "'>" + j + "月</li>");
    }
    //$("[data-target='sort']").text(month+"月");
    //$("[data-target='sort']").attr("data-value", month);
    var type = "0";
    var is_sale = "0";
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
        				$("#main_pic").append("<div class='swiper-slide style='width: 750px; margin-right: 30px;''><a href='"+item.link+"'><img id='showInfo1' src='"+"${pageContext.request.contextPath}"+item.picRoute+"'></img><a></div>");
        			}
        			else{
        				$("#main_pic").append("<div class='swiper-slide style='width: 750px; margin-right: 30px;''><img id='showInfo1' src='"+"${pageContext.request.contextPath}"+item.picRoute+"'></img></div>");
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
        url: "${pageContext.request.contextPath}/getActivitiesAction_updateActivities",
        cache: false,
        success: function(data) {
        	if(data.retcode!="0000"){
        		showMessage(errorMsg);
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
    
    
    
    getActivities(month,type,is_sale); 

});
/**********************页面初始化结束*************************/

/**********************筛选实现*************************/
jQuery(function($) {
    $(document).ready(function() {
        //enabling stickUp on the '.navbar-wrapper' class
        $('.navbar-wrapper').stickUp();
    });

    $(".nav-items span").bind("click",function() {
        $(".nav-items span").removeClass("selected");
        $(this).addClass("selected");
        var target = $(this).attr("data-target");
        if($(".nav-items ul." + target).attr("class")==target){
        	$(".nav-items ul").addClass("hide");
        }
        else{
        	$(".nav-items ul").addClass("hide");
        	$(".nav-items ul." + target).removeClass("hide");
        }
        $("html,body").animate({"scrollTop": $(".navbar-wrapper").offset().top + 10},"1");
    }); 
    $(".nav-items ul li").bind("click",function() {
        var text = $(this).attr("data-text");
        var _v = $(this).attr("data-value");
        $(".nav-items span").removeClass("selected");
        $(".nav-items ul").addClass("hide");
        $("#sale").attr("data-value","0");
        $("#select").attr("data-value","0");
        $("#sale").html("特价");
        $("#select").html("活动筛选");
        var _class = $(this).parent().attr("class");
        var reg = /sale|sort|filter/;
        _class = _class.match(reg)[0];
        $("[data-target='" + _class + "']").text(text);
        $("[data-target='" + _class + "']").attr("data-value", _v);
        var month = $("[data-target='sort']").attr("data-value");
        var type = $("[data-target='filter']").attr("data-value");
        var is_sale = $("[data-target='sale']").attr("data-value");
        $(".cus-item-list").html("");
        getActivities(month,type,is_sale);
    });
});
/**********************筛选实现结束*************************/

/**********************函数实现*************************/
function getActivities(month,type,is_sale) {
	$("#activities").empty();
    var title, time, off_price, original_price,description1,description2,description3,new_type,id,main_pic_route;
    var tags = [];
    $.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"month": month,
            "type": type,
            "is_sale": is_sale
        },
        url: "${pageContext.request.contextPath}/getActivitiesAction_getActivities",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		if(data.obj.length==0){
        			getMore(month,type,is_sale);
        		}
        		$.each(data.obj,function(index, item) {      			
        			var status="";
                	title = item.title;
                	time = item.startTime.substring(5, 7) + "月" +item.startTime.substring(8, 10)+"日"+ "-" +item.endTime.substring(5, 7) + "月" +item.endTime.substring(8, 10)+"日";
                	off_price = item.offPrice;
                	original_price = item.originalPrice;
                	description1=item.description1;
                	description2=item.description2;
                	description3=item.description3;
                	new_type=item.type;
                	id=item.id;
                	main_pic_route="${pageContext.request.contextPath}"+item.mainPicRoute;
                	if(item.status=="0"){
                		status="预计成行";
                	}
                	else if(item.status=="1"){
                		status="确定出行";
                	}
                	else{
                		status="报名截止";
                	}
                	
                	
                	
                	var html = "<a href='../jsp/singleActivity.jsp?id="+id+"'>";
                	html += "<div class='cus-item' style='position: relative'><div class='cus-item-top'><img src='"+main_pic_route+"'>";
                	html += "<div class='cus-confirm-info'><span style='background-color: #6cb83b; padding: 10px 15px;'>"+status+"</span></div>";
                	html += "<div class='cus-time-bg'><div></div><div>" + time + "</div><div></div></div>";
                	html += "<ul class='activitymain-worddialog'><li><div></div><div>"+description1+"</div><div></div></li><li><div></div><div>"+description2+"</div><div></div></li><li><div></div><div>"+description3+"</div><div></div></li></ul>";
                	html += "<img style='position:absolute;width:136px;height:77px;left: 30px;top: 0;' src='../image/activityTheme/theme.png'>";
                	
                	/*html += "</div><div class='cus-item-bottom' style='min-height: 172px;''><div class='cus-item-main'><h2 class='cus-item-title' style='width: 600px;''>" + title + "</h2>";
                	html += "<ul class='cus-item-type' style='padding-right: 145px;''><li style='float:left;margin-right: 10px; margin-bottom: 0px;margin-top: 30px;'>" + item.tag1 + "</li>";
                	
                    html += "<li style='float:left;margin-right: 10px; margin-bottom: 0px;margin-top: 30px;'>" + item.tag2 + "</li>";
                    html += "<li style='float:left;margin-right: 10px; margin-bottom: 0px;margin-top: 30px;'>" + item.tag3 + "</li>";
                	html += "</ul></div><div class='cus-item-fee  customer-list'><h2><span class='fee-red'>¥</span>" + off_price + "</h2><span class='sale-red market-price'>" + original_price + "</span>";
                	html += "</div></div><div class='cus-item-totalcount'><div>已有<span>"+item.attendance+"</span>人去过这里</div></div></div></a>";*/
                	
                	html += "</div><div class='activity-customized' style='height: auto;min-height: 180px;'><div class='activity-title'>";
                	html += "<h2>" + title + "</h2></div>";
                	html += "<div class='activity-item-type' style='padding-right: 125px; margin-bottom: 10px;margin-top:30px;' id='tags'><span style='margin-bottom: 5px;margin-right:5px;'>"+item.tag1+"</span>";
                	html += "<span style='margin-bottom: 5px;margin-right:5px;'>"+item.tag2+"</span>";
                	html += "<span style='margin-bottom: 5px;margin-right:5px;'>"+item.tag3+"</span></div>";
                	html += "<div class='activity-item-fee-detail activity-detail' id='price'><h2><span class='fee-red'>¥</span>"+off_price+"</h2><span class='sale-red market-price'>市场价: ¥"+original_price+"</span></div>";
                
                	html += "<div class='activity-item-totalcount'><div>已有<span>"+item.attendance+"</span>人去过这里</div></div></div></div></a>";
                	$("#activities").append(html);
            	});
            	html = "<div style='text-align: center; height: 60px; padding-top: 5px;' class='more_des' id='next_page_holder'><span style='display: inline-block; width: 270px; text-align: center; height: 40px; line-height: 40px; font-size: 28px; cursor: pointer' class='des-more' id='next_page'>点击显示下一页</span></div>";
            	$("#activities").append(html);
            	$("#next_page").bind("click",function() {
            		getMore(month,type,is_sale);
    			});
        	}
        	else{
        		getMore(month,type,is_sale);
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
}

function getMore(month,type,is_sale){
    $("#next_page_holder").remove();
    month=month+1;
	var title, time, off_price, original_price,description1,description2,description3,new_type,id;
    var tags = [];
    $.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"month": month,
            "type": type,
            "is_sale": is_sale
        },
        url: "${pageContext.request.contextPath}/getActivitiesAction_getActivities",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){        			
        		$.each(data.obj,function(index, item) {
                	var status="";
                	title = item.title;
                	time = item.startTime.substring(5, 7) + "月" +item.startTime.substring(8, 10)+"日"+ "-" +item.endTime.substring(5, 7) + "月" +item.endTime.substring(8, 10)+"日";
                	off_price = item.offPrice;
                	original_price =  item.originalPrice;
                	description1=item.description1;
                	description2=item.description2;
                	description3=item.description3;
                	new_type=item.type;
                	id=item.id;
                	main_pic_route="${pageContext.request.contextPath}"+item.mainPicRoute;
                	if(item.status=="0"){
                		status="预计成行";
                	}
                	else if(item.status=="1"){
                		status="确定出行";
                	}
                	else{
                		status="报名截止";
                	}
                	
                	var html = "<a href='../jsp/singleActivity.jsp?id="+id+"'>";
                	html += "<div class='cus-item' style='position: relative'><div class='cus-item-top'><img src='"+main_pic_route+"'>";
                	html += "<div class='cus-confirm-info'><span style='background-color: #6cb83b; padding: 10px 15px;'>"+status+"</span></div>";
                	html += "<div class='cus-time-bg'><div></div><div>" + time + "</div><div></div></div>";
                	html += "<ul class='activitymain-worddialog'><li><div></div><div>"+description1+"</div><div></div></li><li><div></div><div>"+description2+"</div><div></div></li><li><div></div><div>"+description3+"</div><div></div></li></ul>";
                	html += "<img style='position:absolute;width:136px;height:77px;left: 30px;top: 0;' src='../image/activityTheme/theme.png'>";
                	
                	/*html += "</div><div class='cus-item-bottom' style='min-height: 172px;''><div class='cus-item-main'><h2 class='cus-item-title' style='width: 600px;''>" + title + "</h2>";
                	html += "<ul class='cus-item-type' style='padding-right: 145px;''><li style='float:left;margin-right: 10px; margin-bottom: 0px;margin-top: 30px;'>" + item.tag1 + "</li>";
                	
                    html += "<li style='float:left;margin-right: 10px; margin-bottom: 0px;margin-top: 30px;'>" + item.tag2 + "</li>";
                    html += "<li style='float:left;margin-right: 10px; margin-bottom: 0px;margin-top: 30px;'>" + item.tag3 + "</li>";
                	html += "</ul></div><div class='cus-item-fee  customer-list'><h2><span class='fee-red'>¥</span>" + off_price + "</h2><span class='sale-red market-price'>" + original_price + "</span>";
                	html += "</div></div><div class='cus-item-totalcount'><div>已有<span>"+item.attendance+"</span>人去过这里</div></div></div></a>";*/
                	
                	html += "</div><div class='activity-customized' style='height: auto;min-height: 180px;'><div class='activity-title'>";
                	html += "<h2>" + title + "</h2></div>";
                	html += "<div class='activity-item-type' style='padding-right: 125px; margin-bottom: 10px;margin-top:30px;' id='tags'><span style='margin-bottom: 5px;margin-right:5px;'>"+item.tag1+"</span>";
                	html += "<span style='margin-bottom: 5px;margin-right:5px;'>"+item.tag2+"</span>";
                	html += "<span style='margin-bottom: 5px;margin-right:5px;'>"+item.tag3+"</span></div>";
                	html += "<div class='activity-item-fee-detail activity-detail' id='price'><h2><span class='fee-red'>¥</span>"+off_price+"</h2><span class='sale-red market-price'>市场价: ¥"+original_price+"</span></div>";
                
                	html += "<div class='activity-item-totalcount'><div>已有<span>"+item.attendance+"</span>人去过这里</div></div></div></div></a>";
                	$("#activities").append(html);
            	});
            	html = "<div style='text-align: center; height: 60px; padding-top: 5px;' class='more_des' id='next_page_holder'><span style='display: inline-block; width: 100px; text-align: center; height: 50px; line-height: 50px;'>已显示全部</span></div>";
            	$("#activities").append(html);
            	/*$("#next_page").bind("click",function() {
            		getMore(month,type);
    			});*/
        	}
        	else{
        		html = "<div style='text-align: center; height: 60px; padding-top: 5px;' class='more_des' id='next_page_holder'><span style='display: inline-block; width: 100px; text-align: center; height: 50px; line-height: 50px;'>已显示全部</span></div>";
            	$("#activities").append(html);
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
        	"url": url
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
                		link: url,
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
                		link: url,
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
               	window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2e250c455494c1f8&redirect_uri=http%3a%2f%2fwww.outdoor78.com%2fhuihuan%2floginAction_getUserInfo&response_type=code&scope=snsapi_userinfo&state="+url+"#wechat_redirect";              
            }  
        }
    });  
    </script>
    
</body>
</html>
