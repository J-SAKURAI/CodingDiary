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
                <strong>学校信息表</strong>
            </td>
            </tr>
            <tr>
            <td>
                <a class="btn btn-primary" onclick="addItem(schools)">新增</a>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<table class="table" id="schools">
    <thead>
    <tr>
    	<td>序号</td>
        <td>学校名称</td>
    </tr>
    <tr id="selectTemplete" style="display:none">
						<td><span id="index"></span></td>
						<td><span id="schoolName"></span></td>
						<td><a onclick="editItem(this)" class="btn btn-primary">修改</a>
           					<a onclick="deleteItem(this)" class="btn btn-primary">删除</a>
           					</td>										
					</tr>
					<tr id="insertTemplete" style="display:none">
    					<td><span id="index"></span></td>
    					<td><input id="schoolName" type="text" class="form-control"></td>
       					<td><a class="btn btn-primary" onclick="submitAdd(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancleAdd(this)">取消</a>
       					</td>	
    				</tr>
                                						
					<tr id="editTemplete" style="display:none">
						<td><span id="index"></span></td>
						<td><input id="schoolName" type="text" class="form-control"></td>
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
		},{
			"mDataProp" : "index",
			"bSortable" : true
		},{
			"mDataProp" : "schoolName",
			"bSortable" : true
		}];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/schoolOperationAction_getSchools",
			"get" : "${pageContext.request.contextPath}/schoolOperationAction_getSchoolDetail",
			"add" : "${pageContext.request.contextPath}/schoolOperationAction_addSchool", 
			"delete" : "${pageContext.request.contextPath}/schoolOperationAction_deleteSchool",
			"edit" : "${pageContext.request.contextPath}/schoolOperationAction_editSchool"
		};
		initTable("schools", aoColumns, ajaxSource);
});
</script>

</body></html>
