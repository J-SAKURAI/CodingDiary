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
                活动标题: <strong id="title"></strong>
            </td>
        </tr>
        <tr>
            <td>
            	<a class="btn btn-primary" href="${pageContext.request.contextPath}/web/jsp/management/activities.jsp">返回</a>
                <a class="btn btn-primary" onclick="printExcelForInsurance()">导出Excel（购买保险）</a>
                <a type="hidden" href="" id="ExcelForInsurance" download="报名详情.xls"><span id="ExcelForInsuranceSpan"></span></a>
                <a class="btn btn-primary" onclick="printExcelForLeader()">导出Excel（导游）</a>
                <a type="hidden" href="" id="ExcelForLeader" download="参与者信息.xls"><span id="ExcelForLeaderSpan"></span></a>
                <a class="btn btn-primary" onclick="addItem('sign-up-table')">添加报名</a>
            </td>
            <!--<td>
                人员状态:
            </td>
              <td>
                <select class="form-control" name="s_status">

                    <option value="-1" selected="">全部人员</option>
                    <option value="0">正常</option>
                    <option value="1">已退团</option>
                </select>
            </td>
            <td>
                身份证:
            </td>
            <td>
                <input class="form-control" name="s_userid" id="s_userid" value="">
            </td>
            <td>
                <button class="btn btn-primary">查询</button>
            </td>-->
        </tr>
        </tbody>
    </table>
</form>
<table class="table"  id="sign-up-table">
    <thead>
    <tr>
        <td>序号</td>
        <td>微信昵称</td>
        <td>参与者数量</td>
        <td>价格</td>
        <td>支付状态</td>
        <td>报名方式</td>
        <td>操作</td>
        <td>&nbsp;</td>

    </tr>
    <tr id="selectTemplete" style="display:none">
    	<input id="activity_id" name="activity_id" type="hidden" value="" />
		<td><span id="index"></span></td>
		<td><span id="wxNickname"></span></td>
		<td><span id="participatorsNum"></span></td>
		<td><span id="price"></span></td>
		<td><myspan id="hasPaied" params='{"0":"未支付","1":"已支付"}'></myspan></td>
		<td><myspan id="autoInsert" params='{"0":"在线支付","1":"手动添加"}'></myspan></td>
		<td><a onclick="showQuitInfo(this)" class="btn btn-primary" data-toggle="modal" >编辑参与者</a>
			<a onclick="showEquipmentInfo(this)" class="btn btn-primary" data-toggle="modal" >编辑装备</a>
			<a onclick="editItem(this)" class="btn btn-primary">修改订单</a>
           <a onclick="deleteItem(this)" class="btn btn-primary">删除订单</a></td>										
	</tr>
	<tr id="insertTemplete" style="display:none">
		<input id="activity_id" name="activity_id" type="hidden" value="" />
    	<td><span id="index"></span></td>
    	<td><span id="wxNickname"></span></td>
    	<td><span id="participatorsNum"></span></td>  
		<td><input id="price" type="text" class="form-control"></td>
		<td class=" "><select id="hasPaied" >
        	<option value="0">未支付</option>
        	<option value="1">已支付</option>
        </select></td>
        <td class=" "><select id="autoInsert" >
        	<option value="1">手动添加</option>      					
        </select></td>
       	<td><a class="btn btn-primary" onclick="submitAdd(this)">确认</a> 
       		<a class="btn btn-primary" onclick="cancleAdd(this)">取消</a>
       	</td>	
    </tr>
                                						
	<tr id="editTemplete" style="display:none">
		<td><span id="index"></span></td>
    	<td><span id="wxNickname"></span></td>
    	<td><span id="participatorsNum"></span></td>
		<td><input id="price" type="text" class="form-control"></td> 
		<td class=" "><select id="hasPaied" >
        	<option value="0">未支付</option>
        	<option value="1">已支付</option>
        </select></td>
        <td class=" "><select id="autoInsert" >
        	<option value="0">在线支付</option>
        	<option value="1">手动添加</option>      					
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

<!-- 模态框（Modal） -->
<div class="modal fade" id="quitModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="width:1000px;">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">参与者信息</h4>
         </div>
         <div class="modal-body" style="height:400px">
         	<a class="btn btn-primary" onclick="addItem('quit-table')">添加参与者</a>
         	<table class="table"  id="quit-table">
    			<thead>
    				<tr>
        				<td>序号</td>
        				<td>身份证</td>
        				<td>参与者姓名</td>
        				<td>昵称</td>
        				<td>联系电话</td>
        				<td>上车地点</td>
        				<td>学校</td>
        				<td>报名方式</td>
        				<td>操作</td>
        				<td>&nbsp;</td>
    				</tr>
    				<tr id="selectTemplete" style="display:none">
    					<input id="order_id" name="order_id" type="hidden" value="" />
						<td><span id="index"></span></td>
						<td><span id="idNum"></span></td>
						<td><span id="name"></span></td>
						<td><span id="nickname"></span></td>
						<td><span id="phoneNum"></span></td>
						<td><myspan id="autoInsert" params='{"0":"在线支付","1":"手动添加"}'></myspan></td>
						<td><a onclick="editItem(this)" class="btn btn-primary">修改信息</a>
           					<a onclick="myDeleteItem(this)" class="btn btn-primary">退团</a></td>										
					</tr>
					<tr id="insertTemplete" style="display:none">
						<input id="order_id" name="order_id" type="hidden" value="" />
    					<td><span id="index"></span></td>
    					<td><input id="idNum" type="text" class="form-control"></td>
    					<td><input id="name" type="text" class="form-control"></td>
    					<td><input id="nickname" type="text" class="form-control"></td>
						<td><input id="phoneNum" type="text" class="form-control"></td>  
        				<td class=" "><select id="autoInsert" >
        					<option value="1">手动添加</option>      					
        				</select></td>
       					<td><a class="btn btn-primary" onclick="submitAdd(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancleAdd(this)">取消</a>
       					</td>	
    				</tr>
                                						
					<tr id="editTemplete" style="display:none">
						<input id="order_id" name="order_id" type="hidden" value="" />
						<td><span id="index"></span></td>
						<td><input id="idNum" type="text" class="form-control"></td>
    					<td><input id="name" type="text" class="form-control"></td>
    					<td><input id="nickname" type="text" class="form-control"></td>
						<td><input id="phoneNum" type="text" class="form-control"></td>
						<td><myspan id="autoInsert" params='{"0":"在线支付","1":"手动添加"}'></myspan></td>
						<td><a class="btn btn-primary" onclick="submitEdit(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancelEdit(this)">取消</a>
       					</td>			
					</tr>	
    			</thead>
    			<tbody  id="dataTbody">       
    			</tbody>
			</table>	   
         </div>
         <div class="modal-footer">
         <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>            
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 模态框（Modal） -->
<div class="modal fade" id="equipmentModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="width:1000px;">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">装备信息</h4>
         </div>
         <div class="modal-body" style="height:400px">
         	<a class="btn btn-primary" onclick="addItem('equipment-table')">添加装备</a>
         	<table class="table"  id="equipment-table">
    			<thead>
    				<tr>
        				<td>序号</td>
        				<td>装备名称</td>
						<td>装备数量</td>
        				<td>操作</td>
        				<td>&nbsp;</td>
    				</tr>
    				<tr id="selectTemplete" style="display:none">
    					<input id="order_id" name="order_id" type="hidden" value="" />
						<td><span id="index"></span></td>
						<td><span id="num"></span></td>
						<td><a onclick="editItem(this)" class="btn btn-primary">修改</a>
           					<a onclick="deleteItem(this)" class="btn btn-primary">删除</a></td>										
					</tr>
					<tr id="insertTemplete" style="display:none">
						<input id="order_id" name="order_id" type="hidden" value="" />
    					<td><span id="index"></span></td>
    					<td><input id="num" type="text" class="form-control"></td>
       					<td><a class="btn btn-primary" onclick="submitAdd(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancleAdd(this)">取消</a>
       					</td>	
    				</tr>
                                						
					<tr id="editTemplete" style="display:none">
						<input id="order_id" name="order_id" type="hidden" value="" />
						<td><span id="index"></span></td>
    					<td><input id="num" type="text" class="form-control"></td>
						<td><a class="btn btn-primary" onclick="submitEdit(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancelEdit(this)">取消</a>
       					</td>			
					</tr>	
    			</thead>
    			<tbody  id="dataTbody">       
    			</tbody>
			</table>	   
         </div>
         <div class="modal-footer">
         <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>            
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script type="text/javascript">
var id = request("id");
$(function() {	
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/activityOperationAction_updateOrder",
        cache: false,
        success: function(data) {
        	if(data.retcode!="0000"){
        		alert(data.errorMsg);
        	}          
        }
    });
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"id": id
        },
        url: "${pageContext.request.contextPath}/activityDetailAction_getActivityDetail",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        			$("#title").text(data.obj.activity.title);
        	}
        	else{
        		alert(data.errorMsg);
        	}
            
        }
    });
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"activity_id": id
        },
        url: "${pageContext.request.contextPath}/activityOperationAction_getMeetingPlaces",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){
            	var html="<td><myspan id='pickupPlcaeId' params='{\"";
            	html+=""+"-1"+"\":\""+"无"+"\",\"";
        		$.each(data.obj,function(index, item) {
        			if(index!=(data.obj.length-1)){
        				html+=""+item.id+"\":\""+item.placeName+"\",\"";
        			}
        			else{
        				html+=item.id+"\":\""+item.placeName+"\"";
        			}        			       			
        		});
        		html+="}'></myspan></td>";
        		$("#quitModal").find("#selectTemplete").find("#phoneNum").closest("td").after(html);
        		html="<td><select id='pickupPlcaeId'>";
        		$.each(data.obj,function(index, item) {
        			html+="<option value='"+item.id+"'>"+item.placeName+"</option>";
        		});
        		html+="</select></td>";
        		$("#quitModal").find("#insertTemplete").find("#phoneNum").closest("td").after(html);
        		$("#quitModal").find("#editTemplete").find("#phoneNum").closest("td").after(html);
        				
        	}
        	else if(data.retcode=="0001"){
        		var html="<td><myspan id='pickupPlcaeId' params='{\"";
            	html+=""+"-1"+"\":\""+"无"+"\"";
        		html+="}'></myspan></td>";
        		$("#quitModal").find("#selectTemplete").find("#phoneNum").closest("td").after(html);
        	}
        	else{
        		alert(data.errorMsg);
        	}
        }
    });
    $.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/schoolOperationAction_getSchools",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){
            	var html="<td><myspan id='schoolId' params='{\"";
            	html+=""+"-1"+"\":\""+"无"+"\",\"";
        		$.each(data.obj,function(index, item) {
        			if(index!=(data.obj.length-1)){
        				html+=""+item.id+"\":\""+item.schoolName+"\",\"";
        			}
        			else{
        				html+=item.id+"\":\""+item.schoolName+"\"";
        			}        			       			
        		});
        		html+="}'></myspan></td>";
        		$("#quitModal").find("#selectTemplete").find("#pickupPlcaeId").closest("td").after(html);
        		html="<td><select id='schoolId'>";
        		$.each(data.obj,function(index, item) {
        			html+="<option value='"+item.id+"'>"+item.schoolName+"</option>";
        		});
        		html+="</select></td>";
        		$("#quitModal").find("#insertTemplete").find("#pickupPlcaeId").closest("td").after(html);
        		$("#quitModal").find("#editTemplete").find("#pickupPlcaeId").closest("td").after(html);
        				
        	}
        	else{
        		alert(data.errorMsg);
        	}
        }
    });
    $.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/equipmentOperationAction_getEquipments",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){
            	var html="<td><myspan id='equipmentId' params='{\"";
            	html+=""+"-1"+"\":\""+"无"+"\",\"";
        		$.each(data.obj,function(index, item) {
        			if(index!=(data.obj.length-1)){
        				html+=""+item.id+"\":\""+item.name+"\",\"";
        			}
        			else{
        				html+=item.id+"\":\""+item.name+"\"";
        			}        			       			
        		});
        		html+="}'></myspan></td>";
        		$("#equipmentModal").find("#selectTemplete").find("#index").closest("td").after(html);
        		html="<td><select id='equipmentId'>";
        		$.each(data.obj,function(index, item) {
        			html+="<option value='"+item.id+"'>"+item.name+"</option>";
        		});
        		html+="</select></td>";
        		$("#equipmentModal").find("#insertTemplete").find("#index").closest("td").after(html);
        		$("#equipmentModal").find("#editTemplete").find("#index").closest("td").after(html);
        				
        	}
        	else{
        		alert(data.errorMsg);
        	}
        }
    });
	//$("#selectTemplete").children("#activity_id").val(id);
	//$("#editTemplete").children("#activity_id").val(id);
	$("input[name='activity_id']").val(id);
    var aoColumns = [ 
        {
			"mDataProp" : "id",
			"bSortable" : true
		},{
			"mDataProp" : "activity_id",
			"bSortable" : true
		},{
			"mDataProp" : "index",
			"bSortable" : true
		},{
			"mDataProp" : "wxNickname",
			"bSortable" : true
		}, {
			"mDataProp" : "participatorsNum",
			"bSortable" : true
		},{
			"mDataProp" : "price",
			"bSortable" : true
		},{
			"mDataProp" : "hasPaied",
			"bSortable" : true
		}, {
			"mDataProp" : "hasQuit",
			"bSortable" : true
		}, {
			"mDataProp" : "autoInsert",
			"bSortable" : true
		} ];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/activityOperationAction_getOrders",
			"get" : "${pageContext.request.contextPath}/activityOperationAction_getOrderDetail",			
			"add" : "${pageContext.request.contextPath}/activityOperationAction_addOrder", 
			"edit" : "${pageContext.request.contextPath}/activityOperationAction_editOrder",
			"delete" : "${pageContext.request.contextPath}/activityOperationAction_deleteOrder",
		};
		initTable("sign-up-table", aoColumns, ajaxSource);
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

function showQuitInfo(obj){
	$("#quit-table").find("#dataTbody").empty();
	var order_id=$(obj).closest("tr").find("#itemId").val();
	$("input[name='order_id']").val(order_id);
	var aoColumns = [ 
        {
			"mDataProp" : "id",
			"bSortable" : true
		},{
			"mDataProp" : "order_id",
			"bSortable" : true
		},{
			"mDataProp" : "index",
			"bSortable" : true
		},{
			"mDataProp" : "idNum",
			"bSortable" : true
		}, {
			"mDataProp" : "name",
			"bSortable" : true
		}, {
			"mDataProp" : "nickname",
			"bSortable" : true
		}, {
			"mDataProp" : "phoneNum",
			"bSortable" : true
		}, {
			"mDataProp" : "pickupPlcaeId",
			"bSortable" : true
		}, {
			"mDataProp" : "schoolId",
			"bSortable" : true
		},{
			"mDataProp" : "hasQuit",
			"bSortable" : true
		},{
			"mDataProp" : "autoInsert",
			"bSortable" : true
		} ];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/activityOperationAction_getParticipators",
			"get" : "${pageContext.request.contextPath}/activityOperationAction_getParticipatorDetail",
			"add" : "${pageContext.request.contextPath}/activityOperationAction_addParticipator", 
			"delete" : "${pageContext.request.contextPath}/activityOperationAction_deleteParticipator",
			"edit" : "${pageContext.request.contextPath}/activityOperationAction_editParticipator"
		};
		initTable("quit-table", aoColumns, ajaxSource);
		$('#quitModal').modal('show');
}

function showEquipmentInfo(obj){
	$("#equipment-table").find("#dataTbody").empty();
	var order_id=$(obj).closest("tr").find("#itemId").val();
	$("input[name='order_id']").val(order_id);
	var aoColumns = [ 
        {
			"mDataProp" : "id",
			"bSortable" : true
		},{
			"mDataProp" : "order_id",
			"bSortable" : true
		},{
			"mDataProp" : "index",
			"bSortable" : true
		},{
			"mDataProp" : "equipmentId",
			"bSortable" : true
		}, {
			"mDataProp" : "num",
			"bSortable" : true
		}];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/equipmentOperationAction_getEquipmentsWithOrder",
			"get" : "${pageContext.request.contextPath}/equipmentOperationAction_getEquipmentDetailWithOrder",
			"add" : "${pageContext.request.contextPath}/equipmentOperationAction_addEquipmentWithOrder", 
			"delete" : "${pageContext.request.contextPath}/equipmentOperationAction_deleteEquipmentWithOrder",
			"edit" : "${pageContext.request.contextPath}/equipmentOperationAction_editEquipmentWithOrder"
		};
		initTable("equipment-table", aoColumns, ajaxSource);
		$('#equipmentModal').modal('show');
}

	
function printExcelForInsurance(){
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"activity_id": id
        },
        url: "${pageContext.request.contextPath}/activityOperationAction_printExcelForInsurance",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		$("#ExcelForInsurance").attr("href","../../download/"+data.obj);	
        		$("#ExcelForInsuranceSpan").trigger("click");
        	}
        	else{
        		alert(data.errorMsg);
        	}
            
        }
    });
}

function printExcelForLeader(){
	$.ajax({
        type: "post",
        async: false,
        dataType: "json",
        //收受数据格式
        data: {
        	"activity_id": id
        },
        url: "${pageContext.request.contextPath}/activityOperationAction_printExcelForLeader",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		$("#ExcelForLeader").attr("href","../../download/"+data.obj);	
        		$("#ExcelForLeaderSpan").trigger("click");	
        	}
        	else{
        		alert(data.errorMsg);
        	}
            
        }
    });
}
</script>

</body></html>