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
                <div class="col-sm-12">
    <table class="table">
        <tbody>
        <tr>
         <td style="width:10%">
                <select id="status" class="form-control">
                	<option value="-1">全部</option>
                	<option value="0" selected="">未寄出</option>
                    <option value="1">已寄出</option>                    
                </select>
            </td>
            <td>
                <button class="btn btn-primary" onclick="search()">查询</button>
            </td>   
        </tr>
        </tbody>
    </table>
<table class="table" id="deliveryInfo">
    <thead>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>手机号</td>
        <td>地址</td>
        <td>快递公司</td>
        <td>快递号码</td>
        <td>是否寄出</td>

    </tr>
    <tr id="selectTemplete" style="display:none">
    	<input id="has_out" name="has_out" type="hidden" sourceId="status" value="" />
		<td><span id="index"></span></td>
		<td><span id="deliverName"></span></td>
		<td><span id="deliverPhone"></span></td>
		<td><span id="deliverAddress"></span></td>
		<td><span id="deliverCompany"></span></td>
		<td><span id="deliverNum"></span></td>
		<td><myspan id="hasOut" params='{"0":"未寄出","1":"已寄出"}'></myspan></td>
		<td><a onclick="editItem(this)" class="btn btn-primary">修改</a>
           	</td>										
	</tr>
	<tr id="insertTemplete" style="display:none">
    	<td><span id="index"></span></td>
    	<td><input id="deliverName" ></span></td>
    	<td><input id="deliverPhone" ></span></td>
		<td><input id="deliverAddress" ></span></td>  
		<td><input id="deliverCompany" type="text" class="form-control"></td>
		<td><input id="deliverNum" type="text" class="form-control"></td>
		<td class=" "><select id="hasOut" >
        	<option value="0">未寄出</option>
        	<option value="1">已寄出</option>
        </select></td>
       	<td><a class="btn btn-primary" onclick="submitAdd(this)">确认</a> 
       		<a class="btn btn-primary" onclick="cancleAdd(this)">取消</a>
       	</td>	
    </tr>
                                						
	<tr id="editTemplete" style="display:none">
		<td><span id="index"></span></td>
    	<td><span id="deliverName" ></span></td>
    	<td><span id="deliverPhone" ></span></td>
		<td><span id="deliverAddress" ></span></td>  
		<td><input id="deliverCompany" type="text" class="form-control"></td>
		<td><input id="deliverNum" type="text" class="form-control"></td>
		<td class=" "><select id="hasOut" >
        	<option value="0">未寄出</option>
        	<option value="1">已寄出</option>
        </select></td>
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
    search();
});

function search(){
	$("#dataTbody").empty();
	var aoColumns = [ 
        {
			"mDataProp" : "id",
			"bSortable" : true
		},{
			"mDataProp" : "has_out",
			"bSortable" : true
		},{
			"mDataProp" : "index",
			"bSortable" : true
		},{
			"mDataProp" : "deliverName",
			"bSortable" : true
		}, {
			"mDataProp" : "deliverPhone",
			"bSortable" : true
		}, {
			"mDataProp" : "deliverAddress",
			"bSortable" : true
		}, {
			"mDataProp" : "deliverCompany",
			"bSortable" : true
		},{
			"mDataProp" : "deliverNum",
			"bSortable" : true
		}, {
			"mDataProp" : "hasOut",
			"bSortable" : true
		} ];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/activityOperationAction_getDeliveryInfos",
			"get" : "${pageContext.request.contextPath}/activityOperationAction_getDeliveryInfoDetail", 
			"edit" : "${pageContext.request.contextPath}/activityOperationAction_editDeliveryInfoDetail",
		};
		initTable("deliveryInfo", aoColumns, ajaxSource);
}

</script>

</body></html>