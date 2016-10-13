<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml"><head><title>
	动态密码验证
</title><meta http-equiv="Content-Type" content="text/html; charset=utf-8"><meta name="viewport" content="target-densitydpi=device-dpi,width=750,user-scalable=no"><link rel="stylesheet" type="text/css" href="css/style.css"><link rel="stylesheet" type="text/css" href="css/public/css/index.min.css"><link rel="stylesheet" type="text/css" href="css/menu.css" media="all">
    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" type="text/css" href="css/dist/css/swiper.css"><link rel="stylesheet" type="text/css" href="css/dist/css/swiper-normal.css">
    <style>
        .popupMessage .layui-layer-content {
            border-radius: 10px;
            background-color: rgba(0,0,0,.5);
            text-align: center;
            color: #fff;
            padding: 30px 60px;
            font-size: 32px;
        }

        html {
            height:100%;
        }

        body {
            height:100%;
        }
        
        button {
            border: 0;
            outline: 0;
        }

        input {
            margin-top: 5px;
            height: 70px;
            font-size: 28px;
            border: 0;
            outline: 0;
            margin-left: 30px;
        }

        .webappLogin {
            position:relative;
            text-align: center;
            background-color: #fff;
            width: 750px;
            height: 100%;
        }

        .loginImage {
            padding-top: 120px;
            padding-bottom: 142px;
        }

        .login-inputphone {
            width: 388px;
            height: 90px;
            float:left;
            background-color: #fff;
            display:inline-block;
            border: 1px solid #ddd;
        }

        .login-inputphone input {
            float:left;
            width: 350px;
        }

        .login-inputSendcode {
            width: 240px;
            height: 90px;
            line-height: 90px;
            background-color: #fff; 
            float:left;
            font-size: 28px;
            color: #77c143;
            border: 1px solid #ddd;
            text-align:center;
        }


        .login-inputValidateCode {
            
            width: 630px;
            height: 90px;
            font-size: 28px;
            background-color: #fff;
            border: 1px solid #ddd;
        }

        .login-inputValidateCode input {
            float:left;
            width: 560px;
        }

        .login-button {
            margin-top: 60px;
            width: 630px;
            height: 88px;
            border-radius: 5px;
            background-color: #77c143;
            text-align:center;
            color: #fff;
            font-size: 40px;
            display:block;
            line-height: 88px;
        }

    </style>
<style type="text/css"></style><link rel="stylesheet" href="http://m.wanhuwai.com.cn/js/layer-v2.0/layer/skin/layer.css" id="layui_layer_skinlayercss"></head>
<body>
    <div id="main" class="webappLogin">
        <form method="post" action="./WebappLogin.aspx" id="form1">
<div class="aspNetHidden">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUJMjYyODI5OTU4ZGQxZK7VTsIAH+Xxzq6/5YwMBocThm1emi78yafQRx/X7A==">
</div>

<div class="aspNetHidden">

	<input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="B12BC5D1">
</div>
            <div class="loginImage">
                <img src="images/logo_icon.png">
            </div>
            <div style="padding-left:60px;">
                <div style="height:90px;">
                    <div class="login-inputphone">
                        <input id="txtPhoneNum" type="text" placeholder="请输入手机号码">
                    </div>
                    <a href="javascript:void(0)" class="login-inputSendcode">请输入动态密码</a>
                </div>
                <div class="login-inputValidateCode">
                    <input id="txtValidateCode" type="text" placeholder="请输入动态密码">
                </div>
                <button type="button" class="login-button" onclick="jsonAjaxPost()">登录</button>
            </div>
        </form>
            <div data-role="widget" data-widget="nav4" class="nav4">
            <nav>
                <div id="nav4_ul" class="nav_4">
                    <ul class="box">
                    
                        <li>
                            <a href="index.aspx" class=""><!-- <a href="javascript:;" class=""> -->
                                <span class="sp1">户外自由行定制</span>
                                <img src="images/activity0.png">
                            </a>
                        </li>
                        <li>
                            <a href="activity-main.aspx" class="">
                                <span class="sp2" style="color:#ff0000">立即报名</span>
                                <img style="left:50px" src="images/booknow_inactive.png">
                            </a>
                        </li>
                        <li>
                            <a href="player.aspx" class="">
                                <span class="sp3" style="color:#79be4b">我的订单</span>
                                <img src="images/user1.png">
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
            <div id="nav4_masklayer" class="masklayer_div on">
                &nbsp;
            </div>
            <script src="js/nav4.js"></script>
            <script type="text/javascript">
                nav4.bindClick(document.getElementById("nav4_ul").querySelectorAll("li>a"), document.getElementById("nav4_masklayer"));
            </script>
        </div>
    </div>

    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="js/layer-v2.0/layer/layer.js"></script>
    <script type="text/javascript" src="js/WhwUtil.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script type="text/javascript">  
           function jsonAjaxPost(){  
             var userNameObj=$("#txtPhoneNum").val();  
             var contentObj=$("#txtValidateCode").val(); 
             console.log(contentObj);
             $.ajax({  
               type:"post",//请求方式  
               url:"login?userName="+encodeURI(encodeURI(userNameObj))  
                   +"&content="+encodeURI(encodeURI(contentObj)),//发送请求地址  
               timeout:30000,//超时时间：30秒  
               dataType:"json",//设置返回数据的格式  
               //请求成功后的回调函数 data为json格式  
               success:function(data){  
                  alert(data.yourName+"你输入的内容:"+data.yourContent);  
              },  
              //请求出错的处理  
              error:function(){  
                        alert("请求出错");  
              }  
           });  
          }  
    </script>