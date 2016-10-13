<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>高校户外联盟</title>
    <meta name="keywords" content="高校户外联盟">
    <meta name="description" content="高校户外联盟">

    <link rel="shortcut icon" href="favicon.ico" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/bootstrap.min.css-v=3.3.6.css">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/style.min.css-v=4.1.0.css">

</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img alt="image" class="img-circle" src="../img/profile_small.jpg"  /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold" id="name">Lionel</strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <!--<li class="divider"></li>-->
                                <li><a href="login.html" >安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">H+
                        </div>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">活动管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/activities.jsp" >活动列表</a>
                            </li>
                            <!-- <li><a class="J_menuItem" href="/PCSignupMemberController/index/-2" >报名汇总表</a>
                            </li> -->
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/totalQuitInfo.jsp" >退出人员信息</a>
                            </li>                        
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/equipmentDelivery.jsp" >装备快递信息</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/goodDelivery.jsp" >兑换商品快递信息</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">活动相关信息管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/leader.jsp" >领队</a>
                            </li>
                       		<li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/car.jsp" >车辆</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/peasant.jsp" >农家</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/reward.jsp" >奖励</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/equipment.jsp" >装备</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/school.jsp" >学校</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/good.jsp" >兑换商品</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/banner.jsp" >Banner</a>
                            </li>
                        </ul>
                    </li>
                    <li id="user-set">
                        <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">系统用户设置</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath}/web/jsp/management/userManage.jsp" >用户管理</a>
                            </li>

                        </ul>
                    </li>

                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                        <!--<form role="search" class="navbar-form-custom" method="post" action="http://www.zi-han.net/theme/hplus/search_results.html">
                            <div class="form-group">
                                <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                            </div>
                        </form>-->
                    </div>
                </nav>
            </div>
            <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="index" class="active J_menuTab" data-id="">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="../PCLoginController/logout"  class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" frameborder="0" data-id="404" seamless></iframe>
            </div>
            <div class="footer">
                <!--<div class="pull-right">&copy; 2014-2015 <a href="javascript:if(confirm(%27http://www.zi-han.net/  \n\nThis file was not retrieved by Teleport Pro, because it is addressed on a domain or path outside the boundaries set for its Starting Address.  \n\nDo you want to open it from the server?%27))window.location=%27http://www.zi-han.net/%27"  target="_blank">zihan's blog</a>
                </div>-->
                <div class="pull-right">&copy; 高校户外联盟</div>
            </div>
        </div>
        <!--右侧部分结束-->
    </div>
    
    <script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/jquery.slimscroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/layer.min.js"></script>
   	<script src="${pageContext.request.contextPath}/web/script/hplus.min.js-v=4.1.0.js"></script>
    <script  type="text/javascript" src="${pageContext.request.contextPath}/web/script/contabs.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/pace.min.js"></script>
    
<script>
$(function() {
	$.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/userOperationAction_checkAuthority",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		$("#name").html(data.obj.name);
        		if(data.obj.authority!="1"){
        			$("#user-set").remove();
        		}
        	}
        	else{
        		alert(data.errorMsg);
        	}            
        },
        complete: function(xhr,status) {  
        	var sessionStatus = xhr.getResponseHeader('sessionstatus');  
        	if(sessionStatus == 'timeout') {  
            	alert("您还没有登陆");
               	window.location.href="${pageContext.request.contextPath}/web/jsp/management/login.jsp";
               	//window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf50f9348e644a495&redirect_uri=http%3a%2f%2fwww.shmlhw.com%2fhuihuan%2floginAction_getUserInfo&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";              
            }  
        }   
    });
});

</script>

</body>

</html>
