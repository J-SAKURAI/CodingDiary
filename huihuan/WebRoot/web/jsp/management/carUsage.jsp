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
                <strong id="title">车辆使用情况</strong>
            </td>
            </tr>
            <tr>
                        <td>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/web/jsp/management/car.jsp">返回</a>
                <a class="btn btn-primary" onclick="printExcelForCarUsage()">导出Excel</a>
                <a type="hidden" href="" id="printExcelForCarUsage" download="车辆使用情况.xls"><span id="printExcelForCarUsageSpan"></span></a>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<table class="table" id="carUsage">
    <thead>
    <tr>
    	<td>序号</td>
        <td>活动标题</td>
        <td>活动开始时间</td>
        <td>活动结束时间</td>
    </tr>
    <tr id="selectTemplete" style="display:none">
    	<input id="car_id" name="car_id" type="hidden" value="" />
		<td><span id="index"></span></td>
		<td><span id="title"></span></td>
		<td><span id="startTime"></span></td>
		<td><span id="endTime"></span></td>
	</tr>
    </thead>
    <tbody id="dataTbody">
    </tbody>
</table>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
var id = request("id");
$(function() {		
	$("#car_id").val(id);
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"itemId": id
        },
        url: "${pageContext.request.contextPath}/carOperationAction_getCarDetail",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        			$("#title").text(data.obj.licenseNum+"的使用情况");
        	}
        	else{
        		alert(data.errorMsg);
        	}
            
        }
    });
    var aoColumns = [ 
        {
			"mDataProp" : "id",
			"bSortable" : true
		},{
			"mDataProp" : "car_id",
			"bSortable" : true
		},{
			"mDataProp" : "index",
			"bSortable" : true
		},{
			"mDataProp" : "title",
			"bSortable" : true
		}, {
			"mDataProp" : "startTime",
			"bSortable" : true
		}, {
			"mDataProp" : "endTime",
			"bSortable" : true
		}];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/carOperationAction_getCarUsage",
		};
		initTable("carUsage", aoColumns, ajaxSource);
});

function request(paras){   
        var url = location.href;   
        var paraString = url.substring(url.indexOf("?")+1,url.length).split("&");   
        var paraObj = {};   
        for (i=0; j=paraString[i]; i++){   
            paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length);   
        }   
        var returnValue = paraObj[paras.toLowerCase()];   
        if(typeof(returnValue)=="undefined"){   
            return "";   
        }else{   
            return returnValue;   
        }   
}

function printExcelForCarUsage(){
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"car_id": id
        },
        url: "${pageContext.request.contextPath}/carOperationAction_printExcelForCarUsage",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		$("#printExcelForCarUsage").attr("href","../../download/"+data.obj);	
        		$("#printExcelForCarUsageSpan").trigger("click");
        	}
        	else{
        		alert(data.errorMsg);
        	}
            
        }
    });
}

</script>

</body></html>
