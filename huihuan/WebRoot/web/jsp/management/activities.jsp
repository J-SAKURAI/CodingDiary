<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>高校户外联盟</title>
    <meta name="keywords" content="高校户外联盟">
    <meta name="description" content="高校户外联盟-户外社交神器！">

    <link rel="shortcut icon" href="favicon.ico" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/management_style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/font-awesome.min.css-v=4.4.0.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/style.min.css-v=4.1.0.css">

</head>
<body class="gray-bg  pace-done mini-navbar"><div class="pace  pace-inactive"><div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
  <div class="pace-progress-inner"></div>
</div>
<div class="pace-activity"></div></div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12">
    <table class="table">
        <tbody>
        <tr>
        	
            <td style="text-align:right">
                <label>活动状态</label>
            </td>
            <td style="width:10%">
                <select id="status" class="form-control">
                	<option value="4" selected="">未结束</option>
                	<option value="0">预计出行</option>
                    <option value="1">确定出行</option>   
                    <option value="2">报名已满</option>                 
                    <option value="3">结束</option>
                    <option value="-1" >全部</option>
                </select>
            </td>
            <td>
                <button class="btn btn-primary" onclick="search()">查询</button>
            </td>
            <td>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/web/jsp/management/addActivity.jsp">添加活动</a>
            </td>
            <td style="width:75%">
            </td>
        </tr>
        </tbody>
    </table>
<table class="table">
    <thead>
    <tr>
        <td>标号</td>
        <td>活动标题</td>
        <td>活动时间</td>
        <td>目的地</td>
        <td>截止报名日期</td>
        <td>最大报名人数</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody id="data-body">
    
    </tbody>
</table>
    <script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/content.min.js-v=1.0.0.js" ></script>
    <script src="${pageContext.request.contextPath}/web/script/bootstrap-table.min.js" ></script>
    <script src="${pageContext.request.contextPath}/web/script/bootstrap-table-mobile.min.js" ></script>
    <script src="${pageContext.request.contextPath}/web/script/bootstrap-table-zh-CN.min.js" ></script>
    <script>
$(function() {
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/getActivitiesAction_updateActivities",
        cache: false,
        success: function(data) {
        	if(data.retcode!="0000"){
        		alert(errorMsg);
        	}     
        }
    });
	var status=$("#status").val();    
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        data: {
        	"status": status
        },
        url: "${pageContext.request.contextPath}/activityOperationAction_getActivities",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){
        		$.each(data.obj,function(index, item) {
        			var html="<tr><td id='id'>"+item.id+"</td>";
        			html+="<td>"+item.title+"</td>";
        			html+="<td>"+item.startTime.substring(5, 7) + "/" +item.startTime.substring(8, 10)+ "-" +  item.endTime.substring(5, 7) + "/" + item.endTime.substring(8, 10)+"</td>";
        			html+="<td>"+item.destination+"</td>";
        			html+="<td>"+item.signUpEndTime.substring(5, 7) + "/" +item.signUpEndTime.substring(8, 10)+" "+item.signUpEndTime.substring(11, 16)+"</td>";
        			html+="<td>"+item.maxPeople+"</td>";
        			html+="<td><a class='btn btn-primary' href='${pageContext.request.contextPath}/web/jsp/management/participator.jsp?id="+item.id+"'>查看报名</a>";
        			html+="<a class='btn btn-primary' href='${pageContext.request.contextPath}/web/jsp/management/editActivity.jsp?id="+item.id+"'>修改活动</a>";
            		html+="<a class='btn btn-primary' href='${pageContext.request.contextPath}/web/jsp/management/quitPeople.jsp?id="+item.id+"'>删除人员</a>";
            		html+="<a class='btn btn-primary' onclick='deleteActivity(this)'>删除活动</a></td></tr>";
        			$("#data-body").append(html);
        		});
        	}
        	else{
        		showMessage(data.errorMsg);
        	}
        }
    });
});

function search(){
	$("#data-body").empty();
	var status=$("#status").val();    
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        data: {
        	"status": status
        },
        url: "${pageContext.request.contextPath}/activityOperationAction_getActivities",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){
        		$.each(data.obj,function(index, item) {
        			var html="<tr><td id='id'>"+item.id+"</td>";
        			html+="<td>"+item.title+"</td>";
        			html+="<td>"+item.startTime.substring(5, 7) + "/" +item.startTime.substring(8, 10)+ "-" +  item.endTime.substring(5, 7) + "/" + item.endTime.substring(8, 10)+"</td>";
        			html+="<td>"+item.destination+"</td>";
        			html+="<td>"+item.meetingPlaces+"</td>";
        			html+="<td>"+item.costComponent+"</td>";
        			html+="<td>"+item.signUpEndTime+"</td>";
        			html+="<td>"+item.maxPeople+"</td>";
        			html+="<td><a class='btn btn-primary' href='${pageContext.request.contextPath}/web/jsp/management/signUpDetail.jsp?id="+item.id+"'>查看订单</a>";
        			html+="<a class='btn btn-primary' href='${pageContext.request.contextPath}/web/jsp/management/editActivity.jsp?id="+item.id+"'>修改活动</a>";
            		html+="<a class='btn btn-primary' href='${pageContext.request.contextPath}/web/jsp/management/quitPeople.jsp?id="+item.id+"'>删除人员</a>";
            		html+="<a class='btn btn-primary' onclick='deleteActivity(this)'>删除活动</a></td></tr>";
        			$("#data-body").append(html);
        		});
        	}
        	else{
        		alert(data.errorMsg);
        	}
        }
    });
}

function deleteActivity(obj){
	var activity_id=$(obj).closest("tr").find("#id").html();
	if(confirm('你确定要删除吗?')){
		$.ajax({
        	type: "post",
        	async: true,
        	dataType: "json",
        	//收受数据格式
        	data: {
        		"id": activity_id
        	},
        	url: "${pageContext.request.contextPath}/activityOperationAction_deleteActivity",
        	cache: false,
        	success: function(data) {
            	if(data.retcode=="0000"){
        			alert("删除成功！");
        			search();
        		}
        		else{
        			alert(data.errorMsg);
        		}
        	}
    	});
	}
	else{
		return;
	}
	
}

    </script>




</body>

</html>
