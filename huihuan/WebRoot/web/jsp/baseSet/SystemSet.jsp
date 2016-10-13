<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/web/script/jquery.easyui.min.js"></script>
        <link href="${pageContext.request.contextPath}/web/css/icon.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/web/css/easyui.css" rel="stylesheet" type="text/css">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>

<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>系统分级设置</title>
</head>
    <body>
<div class="row breadcrumb-row">
                    <ol class="breadcrumb">
                        <li><a href="#">首页</a></li>
                        <li><a href="#">基础设施</a></li>
                        <li><a href="#">技术编码设置</a></li>
                        <li class="active">产品编码</li>
                    </ol>
                </div>

                <div class="panel panel-default system-panel">
                    <div class="panel-heading">系统分级设置</div>
                    <div class="panel-body">
                        <div class="option-object">
                            <div class="panel panel-sm">
                                <div class="panel-heading">模块</div>
                                <div class="panel-body">
                                    <div class="easyui-panel easyui-system-panel">
                                        <ul class="easyui-tree" id="subtabsx">
                                            <li>
                                                <span>基础设置</span>
                                                <ul>
                                                    <li data-options="state:'closed'">
                                                        <span>技术编码设置</span>
                                                        <ul>
                                                            <li data-toggle="tab" data-target="#o1"><span>产品编码</span></li>
                                                            <li><span>原辅料编码</span></li>
                                                            <li><span>包装材料编码</span></li>
                                                        </ul>
                                                    </li>
                                                    <li><span data-toggle="tab" data-target="#o4">产品配方</span></li>
                                                    <li><span data-toggle="tab" data-target="#o5">包装材料配套</span></li>
                                                </ul>  
                                            </li>
                                            <li><span data-toggle="tab" data-target="#o6">人力资源</span></li>
                                        </ul> 
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="option-target">
                            <div class="panel panel-sm">
                                <div class="panel-heading">选项</div>
                                <div class="panel-body target-body">
                                    <div id="o2" class="div-o">
                                        <label><input type="checkbox"> 产品编码编辑时需要审核。</label><br/>
                                        <button class="btn btn-default">保存</button>
                                    </div>
                                    <div id="o3" class="div-o">
                                        <label><input type="checkbox"> 原辅料编码编辑时需要审核。</label><br/>
                                        <label><input type="checkbox"> 启用原辅料名称保密管理。</label>
                                    </div>
                                    <div id="o4" class="div-o">
                                        <label><input type="checkbox"> 包装材料编码编辑时需要审核。</label>
                                    </div>
                                    <div id="o5" class="div-o">
                                        投料差异(±%) ：<input type="text" id="feeddifference">
                                        <a href="#"><img src="${pageContext.request.contextPath}/web/image/refresh.png" alt="强制刷新" class="btn-img"></a><br/>
                                        <label><input type="checkbox" id="isFeedDifferenceControl"> 启用投料差异控制。</label>
                                        <a href="#"><img src="${pageContext.request.contextPath}/web/image/refresh.png" alt="强制刷新" class="btn-img"></a><br/><br/>
                                        <label><input type="checkbox" id="isEditRecipe1"> 产品配方编辑时需要<input type="text" value="一级审批" id="editRecipe1">。
                                        <a href="#"><img src="${pageContext.request.contextPath}/web/image/refresh.png" alt="强制刷新" class="btn-img"></a><br/></label><br/>
                                        <label><input type="checkbox" id="isEditRecipe2"> 产品配方编辑时需要<input type="text" value="二级审批" id="editRecipe2">。
                                        <a href="#"><img src="${pageContext.request.contextPath}/web/image/refresh.png" alt="强制刷新" class="btn-img"></a><br/></label>
                                  		<button class="btn btn-default" onclick="productSubmit()">保存</button>
                                    </div>
                                 
                                    <div id="o6" class="div-o">
                                        <label><input type="checkbox" id="isMaterialEditChecked"> 包装材料配套编辑时需要审核。</label><br/>
                                        <label><input type="checkbox" id="isPackingDefine1"> 包装规格自定义项1<input type="text" value="自定义项一" id="packingDefine1">。
                                        <a href="#"><img src="${pageContext.request.contextPath}/web/image/refresh.png" alt="强制刷新" class="btn-img"></a><br/></label><br/>
                                        <label><input type="checkbox" id="isPackingDefine2"> 包装规格自定义项2<input type="text" value="自定义项二" id="packingDefine2">。
                                        <a href="#"><img src="${pageContext.request.contextPath}/web/image/refresh.png" alt="强制刷新" class="btn-img"></a><br/></label>
                                    <button class="btn btn-default" onclick="packingSubmit()">保存</button>
                                    </div>
                                    <div id="o7" class="div-o">
                                        系统登录初始密码：<input type="text" value="123456" id="defaultPasswd"><br/>
                                        <label><input type="checkbox" id="isEmployeeECard"> 启用员工电子卡。
                                        <button class="btn btn-default" onclick="hrSubmit()">保存</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
        <script>
            $(document).ready(function(){
                $(".tree-node").click(function (e) {
                    var target = $(this).index(".tree-node");
                    $(".target-body").children("div[id^='o']").hide();
                    $("#o"+target).show();
                });
            })
            
           //产品配方页面保存信息
        	 function productSubmit(){
        	     var isFeedDifferenceControl;     	    
        	     var isEditRecipe1;
        	     var isEditRecipe2;
        	     var feeddifference=$("#feeddifference").val();
        	     var editRecipe1=$("#editRecipe1").val();
                 var editRecipe2=$("#editRecipe2").val();
        	               	             	     
        	     if(document.getElementById("isFeedDifferenceControl").checked){
        	    	 isFeedDifferenceControl=1;
                 }    
          	     else{
          	    	isFeedDifferenceControl=0;
          	     }
          	    if(document.getElementById("isEditRecipe1").checked){
        	    	 isEditRecipe1=1;
                 }    
          	     else{
          	    	isEditRecipe1=0;
          	     }
          	     if(document.getElementById("isEditRecipe2").checked){
        	    	 isEditRecipe2=1;
                 }    
          	     else{
          	    	isEditRecipe2=0;
          	     }
          	           	     
        	     var postParam = {
        				"isFeedDifferenceControl" : isFeedDifferenceControl,
        				"isEditRecipe1" : isEditRecipe1,
        				"isEditRecipe2" : isEditRecipe2,
        				"feeddifference" : feeddifference,      				
        				"editRecipe1" : editRecipe1,
        				"editRecipe2" : editRecipe2,
        			};
        							         							  
        		$.ajax({
        				type : "post",
        				dataType : "json", //收受数据格式
        				data:postParam,
        				url : "${pageContext.request.contextPath}/systemSetAction_setRecipeSysPropoty",
        				cache : false,
        				success : function(data) {
							if (data.retcode == "0000") {
        								alert("修改成功！");
        							  }else{
        								alert(data.errorMsg);
        							  };			
        				}
        			});
        	   }  
        	   
        	    //包装材料配套页面保存信息
        	 function packingSubmit(){
        	     var isMaterialEditChecked;     	    
        	     var isPackingDefine1;
        	     var isPackingDefine2;
        	     var packingDefine1=$("#packingDefine1").val();
        	     var packingDefine2=$("#packingDefine2").val();
        	               	             	     
        	     if(document.getElementById("isMaterialEditChecked").checked){
        	    	 isMaterialEditChecked=1;
                 }    
          	     else{
          	    	isMaterialEditChecked=0;
          	     }
          	    if(document.getElementById("isPackingDefine1").checked){
        	    	 isPackingDefine1=1;
                 }    
          	     else{
          	    	isPackingDefine1=0;
          	     }
          	     if(document.getElementById("isPackingDefine2").checked){
        	    	 isPackingDefine2=1;
                 }    
          	     else{
          	    	isPackingDefine2=0;
          	     }
          	           	     
        	     var postParam = {
        				"isMaterialEditChecked" : isMaterialEditChecked,
        				"isPackingDefine1" : isPackingDefine1,
        				"isPackingDefine2" : isPackingDefine2,
        				"packingDefine1" : packingDefine1,      				
        				"packingDefine2" : packingDefine2,
        			};
        							  
       $.ajax({
        				type : "post",
        				dataType : "json", //收受数据格式
        				data:postParam,
        				url : "${pageContext.request.contextPath}/systemSetAction_setProductSysPropoty",
        				cache : false,
        				success : function(data) {
							if (data.retcode == "0000") {
        								alert("修改成功！");
        							  }else{
        								alert(data.errorMsg);
        							  };			
        				}
        			});
        	   }      		
        	 //人力资源页面保存信息
        	 function hrSubmit(){   	    
        	     var isEmployeeECard;
        	     var defaultPasswd=$("#defaultPasswd").val();
        	               	             	     
        	     if(document.getElementById("isEmployeeECard").checked){
        	    	 isEmployeeECard=1;
                 }    
          	     else{
          	    	isEmployeeECard=0;
          	     }
          	    var postParam = {
        				"isEmployeeECard" : isEmployeeECard,
        				"defaultPasswd" : defaultPasswd,
        			};
        							  
        			$.ajax({
        				type : "post",
        				dataType : "json", //收受数据格式
        				data:postParam,
        				url : "${pageContext.request.contextPath}/systemSetAction_setHrSysPropoty",
        				cache : false,
        				success : function(data) {
							if (data.retcode == "0000") {
        								alert("修改成功！");
        							  }else{
        								alert(data.errorMsg);
        							  };			
        				}
        			});				  
        	   } 
        	        	  			
        	$.ajax({
        				type : "post",
        				async:false,
        				dataType : "json", //收受数据格式
        				url : "${pageContext.request.contextPath}/systemSetAction_getSysPropotys",
        				cache : false,
        				success : function(data) {
        			      console.log(data.obj.feeddifference);
        	               document.getElementById("feeddifference").setAttribute("value", data.obj.feeddifference);
        	               document.getElementById("editRecipe1").setAttribute("value", data.obj.editRecipe1);
        	               document.getElementById("editRecipe2").setAttribute("value", data.obj.editRecipe2);
        	               document.getElementById("packingDefine1").setAttribute("value", data.obj.packingDefine1);
        	               document.getElementById("packingDefine2").setAttribute("value", data.obj.packingDefine2);
        	               document.getElementById("defaultPasswd").setAttribute("value", data.obj.defaultPasswd);
        	               if(data.obj.isFeedDifferenceControl==1) document.getElementById("isFeedDifferenceControl").checked=true;
        	               if(data.obj.isEditRecipe1==1) document.getElementById("isEditRecipe1").checked=true;
        	               if(data.obj.isEditRecipe2==1) document.getElementById("isEditRecipe2").checked=true;
        	               if(data.obj.isMaterialEditChecked==1) document.getElementById("isMaterialEditChecked").checked=true;
        	               if(data.obj.isPackingDefine1==1) document.getElementById("isPackingDefine1").checked=true;
        	               if(data.obj.isPackingDefine2==1) document.getElementById("isPackingDefine2").checked=true;     	
        	               if(data.obj.isEmployeeECard==1) document.getElementById("isEmployeeECard").checked=true;    			
        				}
        			});
        </script>
    </body>
</html>