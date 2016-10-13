<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="../css/ll.css" rel="stylesheet" type="text/css">

<div class="main-left" id="main-left">
    <div class="panel panel-default panel-sub-tabs">
        <div class="panel-heading">
            <span class="panel-title">系统</span>
        </div>
        <div class="panel-body">
            <ul class="sub-tabs">
	            <li><a><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>工具</a></li>
	            <li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/tool/userchoice.jsp","div-rigth")'>用户选项</a></li>
	            <li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/tool/passwordmodify.jsp","div-rigth")'>密码修改</a></li>
	            <li class="sub-li">用户报修</li>
	            <li class="sub-li">日历</li>
	            <li class="sub-li"><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/tool/managetool.jsp","div-rigth")'>管理员工具</a></li>
	        </ul>
        </div>
    </div>
</div>
        

<div class="main-right" id="main-right">
    <img src="../image/HideToolBar.png" alt="隐藏目录" id="hideTool">
    <div id="div-rigth">
    </div>
</div>
