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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/font-awesome.min.css-v=4.4.0.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/style.min.css-v=4.1.0.css">
	<script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/MyComponent/MyTable.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/bootstrap.min.js"></script>
	<link href="${pageContext.request.contextPath}/web/jquery-Upload/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
  	<script src="${pageContext.request.contextPath}/web/jquery-Upload/js/fileinput.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/web/jquery-Upload/js/fileinput_locale_zh.js" type="text/javascript"></script>
</head>
<body class="gray-bg  pace-done mini-navbar"><div class="pace  pace-inactive"><div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
  <div class="pace-progress-inner"></div>
</div>
<div class="pace-activity"></div></div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12"><form method="post" action="17.html" id="frmSearch">
    <table class="table">
        <tbody>
        <tr>
            <td colspan="6">
                <strong>退出人员信息表</strong>
            </td>
            </tr>
            <tr>
                        <td>
                
            </td>
        </tr>
        </tbody>
    </table>
</form>
<table class="table" id="quitPeople">
    <thead>
    <tr>
    	<td>序号</td>
    	<td>活动标题</td>
        <td>姓名</td>
        <td>身份证号</td>
        <td>手机号</td>
        <td>是否已退款</td>
        <td>退出原因</td>
        <td>操作</td>
    </tr>
    <tr id="selectTemplete" style="display:none">
		<td><span id="index"></span></td>
		<td><span id="title"></span></td>
		<td><span id="name"></span></td>
		<td><span id="idNum"></span></td>
		<td><span id="phoneNum"></span></td>
		<td><myspan id="status" params='{"1":"未退款","2":"已退款"}'></myspan></td>
		<td><span id="quitReason"></span></td>	
		<td><a onclick="editItem(this)" class="btn btn-primary">修改</a></td>									
	</tr>
	<tr id="editTemplete" style="display:none">
		<td><span id="index"></span></td>
		<td><span id="title"></span></td>
		<td><span id="name"></span></td>
		<td><span id="idNum"></span></td>
		<td><span id="phoneNum"></span></td> 
		<td><myspan id="status" params='{"1":"未退款","2":"已退款"}'></myspan></td>
        <td><input id="quitReason" type="text" class="form-control"></td> 
		<td><a class="btn btn-primary" onclick="submitEdit(this)">确认</a> 
       		<a class="btn btn-primary" onclick="cancelEdit(this)">取消</a>
       	</td>			
	</tr>	
    			</thead>
    			<tbody  id="dataTbody">       
    			</tbody>
			</table>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
$(function() {	
    var aoColumns = [ 
        {
			"mDataProp" : "id",
			"bSortable" : true
		},
		{
			"mDataProp" : "title",
			"bSortable" : true
		},{
			"mDataProp" : "index",
			"bSortable" : true
		},{
			"mDataProp" : "name",
			"bSortable" : true
		}, {
			"mDataProp" : "idNum",
			"bSortable" : true
		}, {
			"mDataProp" : "phoneNum",
			"bSortable" : true
		},{
			"mDataProp" : "status",
			"bSortable" : true
		},{
			"mDataProp" : "quitReason",
			"bSortable" : true
		}];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/activityOperationAction_getAllQuitParticipators",
			"get" : "${pageContext.request.contextPath}/activityOperationAction_getQuitParticipatorDetail",
			"edit" : "${pageContext.request.contextPath}/activityOperationAction_editQuitParticipator"
		};
		initTable("quitPeople", aoColumns, ajaxSource);
});


</script>

</body></html>
