<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/toolly.css" rel="stylesheet" type="text/css">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">

   function submit(){
     var oldpwd=$("#oldpwd").val();
     var newpwd=$("#newpwd").val();
     var confirmpwd=$("#confirmpwd").val();
     var postParam = {
			"oldpwd" : oldpwd,
			"newpwd" : newpwd,
			"confirmpwd" : confirmpwd,
		};
		$.getJSON('${pageContext.request.contextPath}/pwdModifyAction_modifyPwd',
						postParam, function(data) {	
						  if (data.retcode == "0000") {
							alert("修改成功！");
						  }else{
							alert(data.errorMsg);
						  }
		});
   }     
   
   $.ajax({
			type : "post",
			async:false,
			dataType : "json", //收受数据格式
			url : "${pageContext.request.contextPath}/pwdModifyAction_getUserName",
			cache : false,
			success : function(data) {
			 console.log(data.obj);
		      $("#username").html(data.obj);
			}
		});    
</script>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户选项</title>
</head>

<body>
                <div class="row breadcrumb-row">
                     <ol class="breadcrumb">
                        <li><a href="#">工具</a></li>
                        <li class="active">密码修改</li>
                    </ol>
                </div>
                
                <div class="row wrapper">
                  
                    <div class="tab-content">
                        <div class="tab_content" id="RecognitionBook">

                            <table class="table edit-table">
                                  <tr>  
                 
                                         <th scope="col" style="background-color:#eeeeee;text-align:left">用户名：</th>  
                                         <th scope="col" style="background-color:#eeeeee;text-align:left" id="username">华东</th>  
                                 </tr>  
                                <tr>
                                    <td>原密码：</td>
                                    <td><input type="PassWord" style="width:50%" id="oldpwd"></td>
                    
                                </tr>
                                <tr>
                                    <td>新密码：</td>
                                    <td><input name="passwordly" type="PassWord" id="newpwd" style="width:50%" onKeyUp="CheckIntensity(this.value)">

                       <div class="table-ly">
                    <table border="0" cellpadding="0" cellspacing="0"> 
                    <tr align="center"> 
                    <td id="pwd_Weak" class="pwd pwd_c">&nbsp;</td> 
                    <td id="pwd_Medium" class="pwd pwd_c pwd_f">无</td> 
                    <td id="pwd_Strong" class="pwd pwd_c pwd_c_r">&nbsp;</td> 
                    </tr> 
                    </table>
                    </div>
                    </td>                       
                                </tr>
                                <tr>
                                    <td>确认新密码：</td>
                                    <td><input type="PassWord" style="width:50%" id="confirmpwd"></td>
                                
                                </tr>
                             
                            </table>
                            <div class="row">
                              
                                <div class=" btn-section-ly">
                                    <button class="btn btn-default" onclick="submit()">确定</button>
                                    
                                </div>
                                  <div class="edit-info-row-ly">
                                    <p style="font-size:12px">提示：密码可以由数字、字母、符号等三种类型字符组成。</p>
<p style="font-size:12px">当密码中含有其中任意一种类型，则密码的安全等级为低。(例如：123或abc)</p>
<p style="font-size:12px">当密码中含有其中任意两种类型，则密码的安全等级为中。(例如：123abc或abc456)</p>
<p style="font-size:12px">当密码中含有其中所有三种类型，则密码的安全等级为高。(例如：123abcd!*&)</p>
                                   
                                </div>
                            </div>
                        </div>
               
                        </div>
                    </div>


</body>
</html>
