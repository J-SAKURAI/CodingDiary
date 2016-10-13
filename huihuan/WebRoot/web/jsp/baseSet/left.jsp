<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
        <script type="text/javascript" src="../script/BootSideMenu.js"></script>
        <link href="../css/ll.css" rel="stylesheet" type="text/css">    
<div class="main-left" id="main-left">
    <div class="panel panel-default panel-sub-tabs">
        <div class="panel-heading">
            <span class="panel-title">系统</span>
        </div>
        <div class="panel-body">
            <ul class="sub-tabs">
	            <li><a><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>技术编码设置</a></li>
	            <li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/classificationCodeSet.jsp","div-rigth")'>产品分类编码</a></li>
	            <li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/productManage.jsp","div-rigth")'>产品编码</a></li>
	            <li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/RawMaterialClassificationCode.jsp","div-rigth")'>原辅料分类编码</a></li>
	            <li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/RawMaterialCode.jsp","div-rigth")'>原辅料编码</a></li>
	            <li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/PackagingMaterialClassificationCode.jsp","div-rigth")'>包装材料分类编码</a></li>
	            <li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/PackagingMaterialCode.jsp","div-rigth")'>包装材料编码</a></li>
	            <li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/ProductFormula.jsp","div-rigth")'>产品配方</a></li>
            	<li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/ProductFormula1.jsp","div-rigth")'>预制品配方</a></li>
                <li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/const.jsp","div-rigth")'>常量表</a></li>
                <li class="sub-li active"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/SysPropoty.jsp","div-rigth")'>系统属性表</a></li>
           		 <li class="sub-li active"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/SystemSet.jsp","div-rigth")'>系统设置表</a></li>
            </ul>
        </div>
    </div>
</div>
        

<div class="main-right" id="main-right">
    <img src="../image/HideToolBar.png" alt="隐藏目录" id="hideTool">
    <div id="div-rigth">   
        <div class="row breadcrumb-row" style="width:1024px">
	       <ol class="breadcrumb">
		     <li><a>系统功能</a>
	      </ol>
        </div>   
        <div class="iconsdefault">
             <div class="iconsimage">
                 <div class="ic"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/classificationCodeSet.jsp","div-rigth")'><img src="../image/documents.png">产品分类编码</a></div>
                 <div class="ic"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/productManage.jsp","div-rigth")'><img src="../image/documents.png"/>产品编码</a></div>
                 <div class="ic"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/RawMaterialClassificationCode.jsp","div-rigth")'><img src="../image/documents.png"/>原辅料分类编码</a></div>
                 <div class="ic"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/RawMaterialCode.jsp","div-rigth")'><img src="../image/documents.png"/>原辅料编码</a></div>
                 <div class="ic"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/PackagingMaterialClassificationCode.jsp","div-rigth")'><img src="../image/documents.png"/>包装材料分类编码</a></div>
                 <div class="ic"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/PackagingMaterialCode.jsp","div-rigth")'><img src="../image/documents.png"/>包装材料编码</a></div>
                 <div class="ic"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/ProductFormula.jsp","div-rigth")'><img src="../image/documents.png"/>产品配方</a></div>
                 <div class="ic"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/ProductFormula1.jsp","div-rigth")'><img src="../image/documents.png"/>预制品配方</a></div>
                 <div class="ic"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/const.jsp","div-rigth")'><img src="../image/documents.png"/>常量表</a></div>
                 <div class="ic"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/baseSet/SysPropoty.jsp","div-rigth")'><img src="../image/documents.png"/>系统属性表</a></div>
             </div>
         </div>
     </div>
</div>

<script type="text/javascript">
 /*   var addHtml="<img src='../../image/Gear.png'/>";
   $("#icons").html(addHtml); */
</script>