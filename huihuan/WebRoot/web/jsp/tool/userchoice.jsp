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

<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户选项</title>
</head>

<body>
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
     				url : "${pageContext.request.contextPath}/userChoiceAction_getSysPropotys",
     				cache : false,
     				success : function(data) {
     			      $("#defaultmenu").val(data.obj.defaultmenu);
     	              //$("#initialpage").val(data.obj.initialpage);
     	              if(data.obj.productcodecheck==1)
     	                document.getElementById("productcodecheck").checked=true;

     				}
     			});
        	  }
          }
          
          function submit(){
        	     var productcodecheck;
        	     var defaultmenu=$("#defaultmenu").val();
        	     if(document.getElementById("productcodecheck").checked){
        	    	 productcodecheck=1;
                 }    
          	     else{
          	    	productcodecheck=0;
          	     }
        	     //var initialpage=$("#initialpage").val();        	     
        	     var postParam = {
        				"defaultmenu" : defaultmenu,
        				"productcodecheck" : productcodecheck,
        				//"initialpage" : initialpage
        			};
        			$.getJSON('${pageContext.request.contextPath}/userChoiceAction_setSysPropoty',
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
        				url : "${pageContext.request.contextPath}/userChoiceAction_getSysPropotys",
        				cache : false,
        				success : function(data) {
        			      $("#defaultmenu").val(data.obj.defaultmenu);
        	              //$("#initialpage").val(data.obj.initialpage);
        	              if(data.obj.productcodecheck==1)
        	                document.getElementById("productcodecheck").checked=true;

        				}
        			});
</script>  
                <div class="row breadcrumb-row">
                    <ol class="breadcrumb">
                        <li><a href="#">工具</a></li>
                        <li class="active">用户选项</li>
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
                                                <li><span data-toggle="tab" data-target="#o1">常规</span></li>
                                                <li><span data-toggle="tab" data-target="#o2">常用软件</span></li>
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
                       <ui><a href="#" style="float: left">常规</a></ui>
                      </div>
                           <div class="panel choicely">
                            <div class="row-ly">
                                <div class="label-leftuser">
                                <label for="">默认菜单样式：</label>
                            </div>
                                <select name="" id="defaultmenu" class="form-control">
                                    <option value="0">列表</option>
                                    <option value="1">图标</option>
                                </select>
                            </div>
                            <div class="row-ly">
                                <div class="label-leftuser" style="padding-top:0px">
                                <label>产品编码编辑时需要审核:</label>   
                            </div>
                                <input type="checkbox" name="checkManagement" id="productcodecheck" value=""/> 
                            </div>
                            <div class="row-ly">
                                <div class="label-leftuser">
                                 <label for="initial" >起始功能页面：</label>
                             </div>
                                    <input type="text" class="form-control" id="initialpage" style="width:170px"></option>
                            </div>
                        </div>
                     </div>
                    

                     <div id="o2" class="div-o" >
                            <div class="choice-title">
                       <ui><a href="#" style="float: left">常用软件</a></ui>
                           </div>
                           <div class="panel choicely">
                            <div class="row-ly">

                                <label for="">WebOffice控件客户端：</label>
                                <a href="#">下载</a>
                            </div>
                          
                            <div class="row-ly">
                                 <label for="" >超大字符集：</label>
                                  <a href="#">下载</a> 
                            </div>
                        </div>
                     </div>
                 


                    <div id="o3" class="div-o" >
                       <div class="choice-title">
                       <ui><a href="#" style="float: left">其他</a></ui>
                       </div>
                           <div class="panel choicely">
                            <div class="row-ly">

                                <label for="">目前无选项</label>
                                
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
