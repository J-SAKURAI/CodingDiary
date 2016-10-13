<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../script/BootSideMenu.js"></script>

<div class="main-left" id="main-left">
    <div class="panel panel-default panel-sub-tabs">
        <div class="panel-heading">
            <span class="panel-title">系统</span>
        </div>
        <div class="panel-body">
            <ul id="leftModulesUl" class="sub-tabs">
	        </ul>
        </div>
    </div>
</div>
        

<div class="main-right" id="main-right">
    <img src="../image/HideToolBar.png" alt="隐藏目录" id="hideTool">
    <div id="div-rigth">
    </div>
</div>

<script type="text/javascript">
	var addHtml="";
	$.ajax({
		type : "post",
		data:{"type":2,"pid":<%=request.getParameter("moduleId")%>},
		dataType : "json", //收受数据格式
		url : "${pageContext.request.contextPath}/moduleAction_getModulesByUserId",
		cache : false,
		success : function(data) {
			console.log(data);
			$.each(data.obj, function(index, item) {
				getUrls(item);
			});
			$("#leftModulesUl").html(addHtml);
		}
	});
	
	function getUrls(item){
		addHtml+="<li><a onclick='commonLoadPage(\"${pageContext.request.contextPath}/"+item.url+"\",\"div-rigth\")'>";
		if(item.children.length>0){
			addHtml+="<span class=\"glyphicon glyphicon-chevron-down\" aria-hidden=\"true\"></span>";
		}
		addHtml+=(item.name+"</a></li>");
		if(item.children.length>0){
			$.each(item.children, function(index1, item1) {
				getUrls(item1);
			});	
		}
	}
</script>