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
  $(document).ready(function(){
          $(".tree-node").click(function (e) {
                    var target = $(this).index(".tree-node");
                    $(".target-body").children("div[id^='o']").hide();
                    $("#o"+target).show();
                });
        });
        
   function cancel(){
     if(confirm("确认取消？")){
       var target = $(this).index(".tree-node");
       $(".target-body").children("div[id^='o']").hide();
       $("#_easyui_tree_2").attr("class", "tree-node");
       $("#_easyui_tree_3").attr("class", "tree-node");
       $("#_easyui_tree_4").attr("class", "tree-node");
       $.ajax({
			type : "post",
			async:false,
			dataType : "json", //收受数据格式
			url : "${pageContext.request.contextPath}/manageToolAction_getSysPropotys",
			cache : false,
			success : function(data) {
		      $("#minlength").val(data.obj.pwdminlength);
              $("#validday").val(data.obj.pwdvalidday);
              $("#maxcount").val(data.obj.pwderrormaxcount);
              $("#minintensity").val(data.obj.pwdminintensity);
              if(data.obj.displayidentycode==1)
                document.getElementById("displayidentycode").checked=true;

			  }
		  });
	   }
   }
   
   function submit(){
     var pwdminlength=$("#minlength").val();
     var pwdvalidday=$("#validday").val();
     var pwderrormaxcount=$("#maxcount").val();
     var pwdminintensity=$("#minintensity").val();
     if(document.getElementById("displayidentycode").checked)
       displayidentycode=1;
     else
       displayidentycode=0;
     var postParam = {
			"pwdminlength" : pwdminlength,
			"pwdvalidday" : pwdvalidday,
			"pwderrormaxcount" : pwderrormaxcount,
			"pwdminintensity" : pwdminintensity,
			"displayidentycode" : displayidentycode
		};
		$.getJSON('${pageContext.request.contextPath}/manageToolAction_setSysPropotys',
						postParam, function(data) {
						if (data.retcode == "0000") {
							alert("修改成功！");
						  }else{
							alert(data.errorMsg);
						  }	});
   }
		$.ajax({
			type : "post",
			async:false,
			dataType : "json", //收受数据格式
			url : "${pageContext.request.contextPath}/manageToolAction_getSysPropotys",
			cache : false,
			success : function(data) {
		      $("#minlength").val(data.obj.pwdminlength);
              $("#validday").val(data.obj.pwdvalidday);
              $("#maxcount").val(data.obj.pwderrormaxcount);
              $("#minintensity").val(data.obj.pwdminintensity);
              if(data.obj.displayidentycode==1)
                document.getElementById("displayidentycode").checked=true;

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
                        <li class="active">管理员工具</li>
                    </ol>
                </div>

                <div class="userchoice">
                    <div class="containerly">
                 <div class="panel panel-left">

                   <div class="option-object">
                    <div class="panel-body">

                       <ul class="easyui-tree" id="subtabsxly">
                          <li>
                                 <span>用户选项</span>
                                          <ul>
                                                <li><span data-toggle="tab" data-target="#o1">系统维护</span></li>
                                                <li><span data-toggle="tab" data-target="#o2">安全</span></li>
                                                <li><span data-toggle="tab" data-target="#o3">其他</span></li>
                                          </ul>  
                                     </li>
                               </ul> 
                          
                        </div>
                    </div>   
                </div>   
          </div>

                 <div class="option-target ">
                      <div class="panel panel-right target-body">

                     <div id="o1" class="div-o">
                       <div class="choice-title">
                       <ui><a href="#" style="float: left">系统维护</a></ui>
                      </div>
                           <div class="panel choicely" style="padding-bottom:20px">
                           <div class="row-ly1" >
                                <div class=" text-center" style="float:left">
                                <button class="btn btn-default">清空缓存文件夹</button>
                                </div>
                            </div>

                            <div class="row-ly2" style="margin-bottom:14px">
                                <div class="text-center" style="float:left">
                                <button class="btn btn-default" style="width:148px">系统环境检测</button>
                                </div>
                            </div>
                            
                           </div>
                    </div>



                     <div id="o2" class="div-o" >
                             <div class="choice-title">
                       <ui><a href="#" style="float: left">安全</a></ui>
                   </div>
                           <div class="panel choicely">

                            <div class="row-ly">
                                <div class="label-left">
                                 <label for="minlength" >密码最小长度：</label>
                             </div>
                                    <input type="text" class="form-control" id="minlength"></option>
                            </div>
                            <div class="row-ly">
                                 <label for="validday" >密码有限期（天）：</label>
                                    <input type="text" class="form-control" id="validday"></option>
                            </div>
                             <div class="row-ly">
                                 <label for="maxcount" >密码错误最大次数：</label>
                                    <input type="text" class="form-control" id="maxcount"></option>
                            </div>

                            <div class="row-ly">
                                <div class="label-left" >
                                <label for="">密码最低复杂度：</label>
                            </div>
                                <select name="" id="minintensity" class="form-control">
                                    <option value="1">弱</option>
                                    <option value="2">中</option>
                                    <option value="3">强</option>
                                </select>
                            </div>

                            <div class="row-ly">
                      
                                <label for="" >登录时显示验证码：</label>
                           
                                <input type="checkbox" name="checkManagement" id="displayidentycode" value=""/> 

                            </div>
                           
                        </div>
                    </div>
                 


                    <div id="o3" class="div-o" >
                       <div class="choice-title">
                       <ui><a href="#" style="float: left">其他</a></ui>
                   </div>
                           <div class="panel choicely">
                            <div class="row-ly">

                                <label for="">暂无其他选项</label>
                              
                            </div>
                            
                        </div>
                     </div>
              
            </div>
       </div>

                        <div class="button-section text-center" style="float:right">
                                <button class="btn btn-default" onclick="submit()">确定</button>
                                <button class="btn btn-default" onclick="cancel()">取消</button>
                            </div>
                 </div>
   


</body>
</html>
