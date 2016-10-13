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
                <strong>农家信息表</strong>
            </td>
            </tr>
            <tr>
                        <td>
                <a class="btn btn-primary" onclick="printExcelForPeasantFamilies()">导出Excel</a>
                <a type="hidden" href="" id="printExcelForPeasantFamilies" download="农家信息.xls"><span id="printExcelForPeasantFamiliesSpan"></span></a>
                <a class="btn btn-primary" onclick="addItem(peasants)">新增</a>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<table class="table" id="peasants">
    <thead>
    <tr>
    	<td>序号</td>
        <td>联系人</td>
        <td>电话</td>
        <td>地址</td>
        <td>农家名称</td>
        <td>住宿费用</td>
        <td>吃饭费用</td>
        <td>其他备注</td>
    </tr>
    <tr id="selectTemplete" style="display:none">
						<td><span id="index"></span></td>
						<td><span id="linkmanName"></span></td>
						<td><span id="phoneNum"></span></td>
						<td><span id="address"></span></td>
						<td><span id="name"></span></td>
						<td><span id="liveFee"></span></td>
						<td><span id="eatFee"></span></td>
						<td><span id="others"></span></td>
						<td><a onclick="editItem(this)" class="btn btn-primary">修改</a>
           					<a onclick="deleteItem(this)" class="btn btn-primary">删除</a>
           					<a id="peasantspeciala" href="" class="btn btn-primary">查看使用情况</a>
           					</td>										
					</tr>
					<tr id="insertTemplete" style="display:none">
    					<td><span id="index"></span></td>
    					<td><input id="linkmanName" type="text" class="form-control"></td>
    					<td><input id="phoneNum" type="text" class="form-control"></td>
						<td><input id="address" type="text" class="form-control"></td>
						<td><input id="name" type="text" class="form-control"></td>
    					<td><input id="liveFee" type="text" class="form-control"></td>
    					<td><input id="eatFee" type="text" class="form-control"></td>
						<td><input id="others" type="text" class="form-control"></td>  
       					<td><a class="btn btn-primary" onclick="submitAdd(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancleAdd(this)">取消</a>
       					</td>	
    				</tr>
                                						
					<tr id="editTemplete" style="display:none">
						<td><span id="index"></span></td>
						<td><input id="linkmanName" type="text" class="form-control"></td>
    					<td><input id="phoneNum" type="text" class="form-control"></td>
						<td><input id="address" type="text" class="form-control"></td>
						<td><input id="name" type="text" class="form-control"></td>
    					<td><input id="liveFee" type="text" class="form-control"></td>
    					<td><input id="eatFee" type="text" class="form-control"></td>
						<td><input id="others" type="text" class="form-control"></td>  
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
			"mDataProp" : "linkmanName",
			"bSortable" : true
		}, {
			"mDataProp" : "phoneNum",
			"bSortable" : true
		}, {
			"mDataProp" : "address",
			"bSortable" : true
		}, {
			"mDataProp" : "name",
			"bSortable" : true
		},{
			"mDataProp" : "liveFee",
			"bSortable" : true
		}, {
			"mDataProp" : "eatFee",
			"bSortable" : true
		}, {
			"mDataProp" : "others",
			"bSortable" : true
		}];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/peasantOperationAction_getPeasantFamilies",
			"get" : "${pageContext.request.contextPath}/peasantOperationAction_getPeasantFamilyDetail",
			"add" : "${pageContext.request.contextPath}/peasantOperationAction_addPeasantFamily", 
			"delete" : "${pageContext.request.contextPath}/peasantOperationAction_deletePeasantFamily",
			"edit" : "${pageContext.request.contextPath}/peasantOperationAction_editPeasantFamily"
		};
		initTable("peasants", aoColumns, ajaxSource);
});

function printExcelForPeasantFamilies(){
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/peasantOperationAction_printExcelForPeasantFamilies",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		$("#printExcelForPeasantFamilies").attr("href","../../download/"+data.obj);	
        		$("#printExcelForPeasantFamiliesSpan").trigger("click");	
        	}
        	else{
        		alert(data.errorMsg);
        	}
            
        }
    });
}
</script>

</body></html>
