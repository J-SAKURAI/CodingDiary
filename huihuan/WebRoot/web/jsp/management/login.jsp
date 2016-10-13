<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>高校户外联盟</title>
    <meta name="keywords" content="高校户外联盟">
    <meta name="description" content="高校户外联盟">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/font-awesome.min.css-v=4.4.0.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/style.min.css-v=4.1.0.css">
	<script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/bootstrap.min.js"></script>

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInUp">
        <div class="row">
            <div class="col-sm-3">&nbsp;</div>
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-6 b-r">
                                <h3 class="m-t-none m-b">登录</h3>
                                <p>欢迎登录高校户外联盟</p>
                                                              
                                    <div class="form-group">
                                        <label>用户名</label>
                                        <input id="name" name="c_name" placeholder="请输入用户名" minlength="2" maxlength="10" type="text" class="form-control" required="" aria-required="true">
                                    </div>
                                    <div class="form-group">
                                        <label>密码</label>
                                        <input id="pwd" name="c_pwd" placeholder="请输入密码" minlength="2" maxlength="20" type="password" class="form-control" required="" aria-required="true">
                                    </div>
                                    <div>
                                        <button class="btn btn-sm btn-primary pull-right m-t-n-xs" id="submitid" onclick="login()"><strong>登 录</strong>
                                        </button>
                                    </div>
            
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">&nbsp;</div>
        </div>
    </div>
<script>
function login(){
	var name=$("#name").val();
	var pwd=$("#pwd").val();
	if(name==""||pwd==""){
		alert("请输入完整登陆信息");
		return;
	}
	$.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        data: {
        	"name": name,
        	"pwd": pwd
        },
        url: "${pageContext.request.contextPath}/loginAction_login",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		window.location.href="${pageContext.request.contextPath}/web/jsp/management/main.jsp";
        	}
        	else{
        		alert(data.errorMsg);
        	}
            
        }
    });
}

</script>
</body>
</html>
