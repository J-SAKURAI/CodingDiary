<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>高校户外联盟</title>
     <meta content="width=device-width, initial-scale=1.0,maximum-scale=1,user-scalable=yes" name="viewport" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/lib.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/mlv.css">
</head>
<body>
    <div class="container Lmlra Lposr">
        <div class="Cwrapper">
        	<div class="Cinn">
             <div class="payway inside">
               <div class="ways Lposr" style="color:#F45551;background: #f5f5f5;">
                   <p class="p01" align="center" style="color:#F45551;">微信授权失败或者过期，请重新登陆！</p>
               </div>
             </div>
            </div>
        </div>
         <!-- copyright -->
    <div class="copy">
        <p><i class="Cicon"></i>高校户外联盟</p>
    </div>
    </div>
   
</body>
</html>
