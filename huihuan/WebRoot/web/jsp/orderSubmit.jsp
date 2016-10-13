<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!-- saved from url=(0041)http://m.wanhuwai.com.cn/Book.aspx?id=547 -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>订单提交</title>
    
    <meta name="viewport" content="width=750, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/style.css">
    <style>
        .popupMessage .layui-layer-content {
            border-radius: 10px;
            background-color: rgba(0,0,0,.5);
            text-align: center;
            color: #fff;
            padding: 30px 60px;
            font-size: 32px;
        }
        /*拼团*/
        .pintuan-info{
            margin: 0 auto;
            width: 690px;
            padding:1px 30px;
            background-color:rgba(255,132,26,1);
            color: #fff;
        }
        .pintuan-info p{
            font-size: 28px;
            line-height: 40px;
            -webkit-margin-before: 15px;
            -webkit-margin-after: 15px;
        }
        
    </style>
    <script src="${pageContext.request.contextPath}/web/script/hm.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/script/layer.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/layer.css" id="layui_layer_skinlayercss">
    
</head>
<body>
    <div id="main">
        <input type="hidden" name="equipmentId" value="1">
        <input type="hidden" name="equipmentPrice" value="99">
        <input type="hidden" name="equipmentName" value="玩户外徒步运动保护舒适套装">
        <input type="hidden" name="equipmentPicPath" value="/images/equipment/eq1.jpg">
        <input type="hidden" name="equipmentInfo" value="登山杖1支，专业运动护膝2只。">
        <form method="post" action="http://m.wanhuwai.com.cn/Book.aspx?id=547" id="BookInfo">
<div class="aspNetHidden">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKLTI4MDc0NjY5OA9kFgJmD2QWBGYPFgIeB1Zpc2libGVoZAIBDxYCHwBnZGSP1tGto1aQMFPNCLjWVv0qEsPtEiGPpXmqSpOJfh6cqA==">
</div>

<div class="aspNetHidden">

	<input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="85FA239D">
	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEdAALLMSVlCZvf6dIPvIVvuI3uRiDseqg+vwtvFmqD6GD2xyxs+ExReoD7n/HF3plBNGTzBv5Suj9TfL24OfhuWN6N">
</div>

            

            <input type="hidden" name="active_id" value="547">
            <input type="hidden" name="hidOpenid" value="">
            <input type="hidden" name="hidDiscountTypeId" value="8">
            <input type="hidden" name="hidIsUserCustoming" value="False">
            <!--报名预订页 标题-->
            <div class="bookHeader">
                <div class="item-name-title">
                    <h2 id="title"></h2>
                    <input type="hidden" name="actName" value="7.16莫干山.轻装徒步.">
                    <input type="hidden" name="price" value="238">
                    
                </div>
            </div>

            <!--报名预订页 订单联系人-->
            <div class="bookPlayer" id="bookPlayer">
                <div class="book-player-title">
                    <h2>报名信息</h2>
                </div>
                <div class="book-player">
                    <div class="book-player-name">
                        <span>姓名</span>
                        <input type="text" class="frm-input-playername" value="" name="FullName" placeholder="请与证件一致">
                    </div>
                    <div class="book-player-nick_name">
                        <span>昵称</span>
                        <input type="text" class="frm-input-playernickname" value="" name="NickName" placeholder="非必填项">
                    </div>
                    <div class="book-player-pid">
                        <span>身份证号</span>
                        <input type="text" class="frm-input-playerpid" value="" name="IDNum" placeholder="用于购买保险">
                    </div>
                    <div class="book-player-phone">
                        <span>手机号</span>
                        <input type="text" class="frm-input-playerphone" value="" name="PhoneNum" placeholder="用于活动联络">
                        <!--  <a id="GetValudateCode">获取动态密码</a>
                    </div>
                    <div class="book-player-password">
                        <span>动态密码</span>
                        <input type="text" class="frm-input-playernickname" value="" id="Password" placeholder="请输入动态密码"> -->
                    </div>
                    <div class="book-player-university">
                    	<span>学校</span>
                    	<select id="university"  style="color:#999999">
                    		<option value="0">请选择</option>                          
                    	</select>
                    </div>
                    
                    <div class="book-player-pickupplace">
                    	<span>上车地点</span>
                    	<select id="pickupplace" name="pickupplace" style="color:#999999">
                    		<option value="0">请选择</option>                          
                    	</select>
                    </div>
                </div>
            </div>
            

            <div class="book-player-add">
                <i class="ico-add"></i>
                <a onclick="addParticipator()">添加玩家</a>
            </div>

            <!-- 装备 -->
            <div id="divEquipment" class="equipment-part">
                <div class="comfort-equipment">
                    <h2>可享受促销优惠套装</h2>
                </div>
                <div class="equipment-list">
                    <div class="equipment-info" style="position: relative;">
                        <span class="equipment-name" id="equipment-name"></span>
                        <span class="equipment-unit" style="font-size: 20px;color: #666666;position: absolute;right: 0;bottom: 0;">/份</span>
                        <span class="equip-price" id="equip-price" style="position: absolute;right: 28px;bottom: 0;"></span>
                        <span class="market-price" id="market-price" style="font-size: 20px;color: #666666;position: absolute;right: 100px;bottom: 0;"></span>
                        <span style="display: block;width: 55px;position: absolute;right: 100px;border-top: 2px solid;color: #666666;top: 41px;"></span>
                        <span class="market-price" style="font-size: 20px;color: #666666;position: absolute;right: 150px;bottom: 0;">市场价：</span>
                        <div style="clear:both;"></div>
                    </div>
                    <div class="equipment-buy">
                        <div class="equipment-brief">
                            <div class="equipment-info-content" id="equipment-info-content"></div>
                            <div class="equipment-pic">查看详情</div>
                        </div>
                        <div class="equipment-calculate">
                            <div class="calculate-equip-count minus" onclick="deleteEquipment(this)">
                                <div class="minus-equip-icon"></div>
                            </div>
                            <div class="equip-count" id="equip-count"></div>
                            <div class="calculate-equip-count add" onclick="addEquipment(this)">
                                <div class="add-equip-icon"></div>
                            </div>
                            <span class="show-equipment-detail" onclick="JoinActive.ShowEquipmentDetail();"></span>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="equipment-deliver" style="display:none">
                <div class="equipment-deliver-info">
                    <span style="width: 33.33%" data-target="location"><i style="float: left"></i><h2>购买装备领取方式</h2><i></i></span>
                    <div class="isAudit" name="isAudit" style="font-size: 20px;color: #999999;"> 
                    	<h3><input id="deliver_type" type="radio" name="identity" value="0" checked="checked">随活动上车领取 </h3>
                    	<h3><input type="radio" name="identity" value="1">快递到家</h3>
                    </div>
                        <div class="express-player" style="display:none">
                            <h2 >请填写快递信息：</h3>
                            <div class="express-player-name">
                                <span>姓名</span>
                                <input id="deliver_name" type="text" class="frm-input-expressname" value="" name="name" placeholder="收货人姓名" style="font-size:25px;">
                            </div>
                            <div class="express-player-phone">
                                <span>电话</span>
                                <input id="deliver_phone" type="text" class="frm-input-expressphone" value="" name="phone" placeholder="联系电话" style="font-size:25px;">
                            </div>
                            <div class="express-player-address">
                                <span>地址</span>
                                <input id="deliver_address" type="text" class="frm-input-expressaddress" value="" name="address" placeholder="邮寄地址" style="font-size:25px;">
                            </div>
                        </div>             	
            	</div>
            </div>


            <div class="book-discount"><div class="book-discount-title"><h2>已享优惠</h2>
            <div id="order-discount-detail" style="float:right; font-size: 24px; position:relative; height:28px; width:134px; color: #999; line-height:28px; display:inline-block; background: url(../image/question_flag.png) no-repeat right">特惠规则</div></div>
            <div class="discount-book-info"><ul id="reward">
            <ul></ul></ul></div></div>
            <div id="whwNotice" class="book-player-tip">
                <h3 style="font-size:20px!important;">身份信息仅用来购买户外专业保险，高校户外联盟承诺不会泄露玩家身份信息或用于其他用途。</h3>
                <h3 style="font-size:20px!important;">继续预定代表你已阅读并同意<span style="color: rgba(67, 118, 192, 0.86);">《预定须知》</span></h3>
            </div>

            <div style="position: fixed; bottom: 0; z-index: 9999; background:#fff; width:750px; height:110px; border-top: 1px solid #cccccc;">
                <div style="position: absolute;left:30px; top:10px; font-size:24px; color:#ff0000; font-weight:bold;margin-buttom:5px;">实际付款：￥<span style="font-size:40px;font-weight:bold;" id="spanCurrentPrice"></span></div>
                <div style="position: absolute;left:30px; bottom:0px; font-size:24px; color:#666666;width:300px;height:50px;"><span >可获积分：</span><span id="scores">0</span></div>
                <button type="button" class="book-submit" onclick="submitOrder()" style="background-color: rgb(119, 192, 67);">提交订单</button>
            </div>

        
<script src="${pageContext.request.contextPath}/web/script/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath}/web/script/maintainscroll.jquery.js"></script>
<script src="${pageContext.request.contextPath}/web/script/WhwUtil.js"></script>
<span style="display:none;" id="whwAppId">wx94cf6054b27fafa5</span>
<div id="shareArrows" style="background: url(${pageContext.request.contextPath}/web/image/share_icon.png) no-repeat !important; position:absolute; top:20px; right:30px; z-index:19891999; width:63px; height:83px; display:none;"></div>
<div id="double-single-arrow" style="background: url(${pageContext.request.contextPath}/web/image/redPacket/single-double.png) no-repeat !important; position:absolute; top:0px; right:10px; z-index:19891999; width:67px; height:503px; display:none;"></div>
<div id="already-arrow" style="background: url(${pageContext.request.contextPath}/web/image/redPacket/8.8_already.png) no-repeat !important; position:absolute; top:0px;right: 10px; z-index:19891999; width:73px; height:620px; display:none;"></div>
<script src="${pageContext.request.contextPath}/web/script/redPacket.js"></script></form>
    </div>
<div style="display:none">        
<div class="detail-discount" style="-webkit-overflow-scrolling: touch; color:#666">
    <div style="margin-top: 20px;margin-bottom:20px; text-align:center; line-height:40px; font-size:40px; color:#333" id="for-append">特惠规则</div>
    <div style=" overflow:hidden; margin-top:40px; width:500px;" id="basic-div">
        <div style="float:left; width:180px; display:inline-block;">
            <span style="background: #20b5f4; display:inline-block;" id="type">礼</span>
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
    
<script type="text/javascript">

/**********************初始化页面*************************/
var activity_price;
var whetherDisplaySchool=1,whetherDisplayMeetingPlace=1;
var id = request("id"); 
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
        url: "${pageContext.request.contextPath}/orderSubmitAction_initEquipments",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		var html=$(".equipment-list").prop("outerHTML");
        		$(".equipment-list").remove();
        		$.each(data.obj,function(index, item) {
        			var createObj=jQuery(html);
        			createObj.find("#equipment-name").html(item.name);
                	createObj.find("#equip-price").html("￥"+item.offPrice);
                	createObj.find("#market-price").html("￥"+item.originalPrice);
                	createObj.find("#equipment-info-content").html(item.content); 
                	createObj.find("#equip-count").html("0");
                	createObj.append("<input type='hidden' id='itemId' value='"+item.id+"'/>");
                	$("#divEquipment").append(createObj);               	
                });                		
                //显示装备详情
				$(".equipment-pic").on("click", function () {
					var equipment_id=$(this).closest(".equipment-list").find("#itemId").val();
    				layer.closeAll(); //关闭所有层
    				$.ajax({
        				type: "post",
        				async: true,
        				dataType: "json",
        				//收受数据格式
        				data: {"itemId":equipment_id},
        				url: "${pageContext.request.contextPath}/equipmentOperationAction_getEquipmentDetailInfo",
        				cache: false,
        				success: function(data) {
        					if(data.retcode=="0000"){
        						layer.open({
         							type: 1,
         							shadeClose: true,
         							title: false,
         							shade: 0.8,
         							area: ['590px', '87%'],
         							content: data.obj
     							});
        					}
        					else{
        						showMessage(data.errorMsg);
        					}
        				}
    				});         				
				});
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
                	$("#title").html(data.obj.activity.title);
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
                	if(data.obj.meetingPlaces.length>0){
                		whetherDisplayMeetingPlace=1;
                		$.each(data.obj.meetingPlaces,function(index, item) {
                			$("#pickupplace").append("<option value='"+item.id+"'>"+item.placeName+"</option>");
                		});
                	}
                	else{
                		whetherDisplayMeetingPlace=0;
                		$(".book-player-pickupplace").css("display","none");
                	}
                	if(data.obj.activity.whetherDisplaySchool==1){
                		whetherDisplaySchool=1;
                		$.each(data.obj.schools,function(index, item) {
                			$("#university").append("<option value='"+item.id+"'>"+item.schoolName+"</option>");
                		});
                	}
                	else{
                		whetherDisplaySchool=0;
                		$(".book-player-university").css("display","none");
                	}
                	
                	activity_price=data.obj.activity.offPrice;
                	$("#spanCurrentPrice").html(data.obj.activity.offPrice);
                	$("#scores").html(parseInt(data.obj.activity.offPrice));   		
                	$.each(data.obj.types,function(index, item) {
                		if(item.type=='特价'){
                			$("#scores").html('特价活动无积分'); 
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
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/orderSubmitAction_getUserInfo",
        cache: true,
        success: function(data) {
        	if(data.retcode=="0000"){
               	$(".frm-input-playername").val(data.obj.name);	
               	if(data.obj.nickname==null||data.obj.nickname==""){
               		$(".frm-input-playernickname").val(data.obj.wxNickname);
               	}
				else{
					$(".frm-input-playernickname").val(data.obj.nickname);
				}	
				$(".frm-input-playerpid").val(data.obj.idNum);
				$(".frm-input-playerphone").val(data.obj.phoneNum);		
				$("#university").val(data.obj.schoolId);	  		
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

//用于获得url中的参数
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

function getPrice(){
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/orderSubmitAction_getPrice",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
                $("#spanCurrentPrice").html(data.obj);
                $("#spanOriginalTotalPrice").html(data.obj);     		
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

/**********************人员增加删除*************************/
function addParticipator(){
    var select_code=$(".book-player-pickupplace").prop("outerHTML");
    var university_html=$(".book-player-university").prop("outerHTML");
    var html = "<div class='book-player'>";
    html += "<div class='book-player-name'><span>姓名</span><input type='text' class='frm-input-playername' name='FullName' placeholder='请与证件一致'></div>";
    html += "<div class='book-player-nick_name'><span>昵称</span><input type='text' class='frm-input-playernickname' name='NickName' placeholder='非必填项'></div>";
    html += "<div class='book-player-pid'><span>身份证号</span><input type='text' class='frm-input-playerpid' name='IDNum' placeholder='用于购买保险'></div>";
    html += "<div class='book-player-phone'><span>手机号</span><input type='text' class='frm-input-playerphone' name='PhoneNum' placeholder='用于活动联络'></div>";
    html += university_html;
    html += select_code;
    html += "<div class='player-del' onclick='deleteParticipator(this)'></div>";
    html += "</div>";
    $("#bookPlayer").append(html);
    var total_price=parseFloat(parseFloat($("#spanCurrentPrice").html()).toFixed(1));
	total_price=parseFloat((total_price+activity_price).toFixed(1));
	var par_num=$('.book-player').length;
	var score=parseInt(activity_price*par_num);
	$("#spanCurrentPrice").html(total_price);
	$("#scores").html(score);
	
    
}

function deleteParticipator(obj){
    $(obj).parent("div").remove();
    var total_price=parseFloat(parseFloat($("#spanCurrentPrice").html()).toFixed(1));
	total_price=parseFloat((total_price-activity_price).toFixed(1));
	var par_num=$('.book-player').length;
	var score=parseInt(activity_price*par_num);
	$("#spanCurrentPrice").html(total_price);
	$("#scores").html(score);
    
}
/**********************人员增加删除结束*************************/

/**********************装备增加删除*************************/
function addEquipment(obj){
	//var equipment_id=$(obj).closest(".equipment-list").find("#itemId").val();	      
	var num=parseInt($(obj).prev().html());
	num=num+1;
	$(obj).prev().html(num);
	var price=parseFloat(parseFloat($(obj).closest(".equipment-list").find("#equip-price").html().slice(1)).toFixed(1));
	var total_price=parseFloat(parseFloat($("#spanCurrentPrice").html()).toFixed(1));
	total_price=parseFloat((total_price+price).toFixed(1));
	$("#spanCurrentPrice").html(total_price);
	var total_count=0;
	$.each($('.equipment-list'),function(index, item) {        
    	total_count=total_count+parseInt($(item).find("#equip-count").html());	   	
    });  
    if(total_count!='0'){
    	$(".equipment-deliver").css('display','');
    }       
}

function deleteEquipment(obj){
	
	var num=parseInt($(obj).next().html());
	if(num==0){
		showMessage("装备数量不能少于0");
		return;
	}
	num=num-1;
	$(obj).next().html(num);
	var price=parseFloat(parseFloat($(obj).closest(".equipment-list").find("#equip-price").html().slice(1)).toFixed(1));
	var total_price=parseFloat(parseFloat($("#spanCurrentPrice").html()).toFixed(1));
	total_price=parseFloat((total_price-price).toFixed(1));
	$("#spanCurrentPrice").html(total_price);
	var total_count=0;
	$.each($('.equipment-list'),function(index, item) {        
    	total_count=total_count+parseInt($(item).find("#equip-count").html());	   	
    });  
    if(total_count=='0'){
    	$(".equipment-deliver").css('display','none');
    }
}

function getEquipmentNum(){
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/orderSubmitAction_getEquipmentNum",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
                $("#equip-count").html(data.obj);     		
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
/**********************装备增加删除结束*************************/

/**********************提交订单*************************/
function submitOrder(){
	var is_valid=0,is_user=0;
	var users=new Array();
	var equipment_id=new Array();
	var equipment_num=new Array();
	var name,nickname,id_num,phonenum,school,pickupplace;
	$.each($("#bookPlayer").find("input"),function(index, item) {
		if($(item).val()==""){			
			if($(item).attr("name")=="FullName"){
				is_valid=1;
				showMessage("请输入姓名");
				$(item).focus();
				return false;
			}
			if($(item).attr("name")=="IDNum"){
				is_valid=1;
				showMessage("请输入身份证号码");
				$(item).focus();
				return false;
			}
			if($(item).attr("name")=="PhoneNum"){
				is_valid=1;
				showMessage("请输入手机号码");
				$(item).focus();
				return false;
			}
		}
	});
	if(is_valid==1){
		return false;
	}
	
	if(whetherDisplaySchool==1){
		if($("#university").val()=="0"){
			is_valid=1;
			showMessage("请选择学校");
			$("#university").focus();
			return false;
		}
	}	
	if(is_valid==1){
		return false;
	}
	
	if(whetherDisplayMeetingPlace==1){
		$.each($("#bookPlayer").find("select"),function(index, item) {
			if($(item).val()=="0"&&$(item).attr("name")=="pickupplace"){
				is_valid=1;
				showMessage("请选择上车地点");
				$(item).focus();
				return false;
			}
		});
	}
	if(is_valid==1){
		return false;
	}
	
	var data={};
	if($("#deliver_type").prop("checked")==true){
		data.deliver_type=0;
	}
	else{
		data.deliver_type=1;
		$.each($(".express-player div input"),function(index, item) {
			if($(item).val()==""){
				is_valid=1;
				showMessage("请填写完整的快递信息");
				$(item).focus();
				return false;
			}
		});
		if(is_valid==1){
			return false;
		}
		data.deliver_name=$("#deliver_name").val();
		data.deliver_phone=$("#deliver_phone").val();
		data.deliver_address=$("#deliver_address").val();
	}
	$.each($("#bookPlayer").find(".book-player"),function(index, item) {
		var user=new Array();
		user[0]=$(item).find(".frm-input-playername").val();	
		user[1]=$(item).find(".frm-input-playernickname").val();	
		user[2]=$(item).find(".frm-input-playerpid").val();
		user[3]=$(item).find(".frm-input-playerphone").val();
		if(whetherDisplaySchool==1){
			user[4]=$(item).find("#university").val();
		}
		else{
			user[4]="-1";
		}	
		if(whetherDisplayMeetingPlace==1){
			user[5]=$(item).find("select[name='pickupplace']").val();
		}
		else{
			user[5]="-1";
		}
		users.push(user);		
	});
	
	$.each(users,function(index, item) {
		if(index==0){
			data.user=item;
		}
		else{
			data['participator'+index]=item;
		}
	});
	data.num=users.length;
	var count=0;
	$.each($(".equipment-list"),function(index, item) {
		data['equipment_id'+index]=$(item).find("#itemId").val();
		data['equipment_num'+index]=$(item).find("#equip-count").html();
		count++;		
	});		
	data.equipment_type_num=count;
	
	data.activity_id=id;
	$.ajax({
        	type: "post",
        	async: false,
        	dataType: "json",
        	//收受数据格式
        	traditional: true,
        	data: data,
        	url: "${pageContext.request.contextPath}/orderSubmitAction_submitOrder",
        	cache: false,
        	success: function(data) {
        		if(data.retcode=="0000"){
        			console.log(data.obj);
        			location.href ="${pageContext.request.contextPath}/web/jsp/payment.jsp?id="+data.obj;
                	//showMessage("订单提交成功！");	  		
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

/**********************提示信息*************************/

$('#whwNotice').on('click', function () {
    $.get('html/Notice.html', {}, function (data, textStatus) {
        layer.open({
            type: 1,
            shadeClose: true,
            title: false,
            shade: 0.8,
            area: ['630px', '90%'],
            content: data
        });
    });
});

$(".isAudit input").on('click', function () {
    if($("#deliver_type").prop("checked")==false){
    	$(".express-player").css("display","");
    }
    else{
    	$(".express-player").css("display","none");
    }
});




/**********************提示信息结束*************************/
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