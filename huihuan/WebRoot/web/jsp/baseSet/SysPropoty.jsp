<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/MyComponent/MyTable.js"></script>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>系统属性表</title>
</head>

<body>


	<div class="row breadcrumb-row">
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">基础设施</a></li>
			<li><a href="#">技术编码设置</a></li>
			<li class="active">产品编码</li>
		</ol>
	</div>

	<div class="row wrapper">
		<div class="col-md-12">
			<div class="row rawMaterial-row">
				<label for="keyword" class="w90">关键字：</label> <input type="text"
					class="form-control" id="keyWord">
				</option>
				<div class="row-section btn-section">
					<button onclick="search()" class="btn btn-default">查询</button>
					<button class="btn btn-default">打印</button>
				</div>
			</div>
		</div>
	</div>

	<div class="row wrapper">
		<div class="row button-row">
			<a onclick="addItem(sysPropotyTable)" class="btn-add"><span
				class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
		</div>
		
		<table id="sysPropotyTable" class="table table-striped">
			<thead>

				<tr>
					<th class="w60">序号</th>
					<th class="w100"><a id="mlCd">模块代码<span
						class="glyphicon glyphicon-arrow-down order-btn"
						aria-hidden="true"></th>
					<th class="w80"><a id="ky">系统属性键<span
						class="glyphicon glyphicon-arrow-down order-btn"
						aria-hidden="true"></th>
					<th class="w80"><a id="value">系统属性值<span
						class="glyphicon glyphicon-arrow-down order-btn"
						aria-hidden="true"></th>
					<th class="w60"><a id="rmk">备注</th>
					<th class="w100">操作</th>
				</tr>
				<tr id="selectTemplete" style="display:none">
					<input id="keyword" type="hidden" sourceId="keyword" />
					<td><span id="index"></span></td>
					<td><span id="mlCd"></span></td>
					<td><span id="ky"></span></td>
					<td><span id="value"></span></td>
					<td><span id="rmk"></span></td>
					<td><a id="rawMaterialViewButton" class="btn-operation"
						data-toggle="modal" title="查看"><span
							class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span> </a> <a
						id="rawMaterialEditButton" onclick="editItem(this)" class="btn-operation"
						data-toggle="modal" title="编辑"><span
							class="glyphicon glyphicon-edit" aria-hidden="true"></span> </a> <a
						onclick="deleteItem(this)" class="btn-operation" title="删除"><span
							class="glyphicon glyphicon-trash" aria-hidden="true"></span> </a></td>	
									
				</tr>	
				<!--点击增加按钮触发事件模版  -->
				<tr id="insertTemplete" style="display:none">
<!-- 						<input id="catagoryDetails" type="hidden"
							sourceName="catagoryDetailsSelect" /> -->
<!-- 						<td></td> -->
						<td width="60px"><span id="index"></span>
						</td>
						<td width="100px"><input id="mlCd" type="text" class="edit-input"  />
						</td>
						<td width="80px"><input id="ky" type="text" class="edit-input" />
						</td>
						<td width="80px"><input id="value" type="text" class="edit-input" />
						</td>
						<td width="60px"><input id="rmk" type="text" class="edit-input" />
						</td>
						<td width="100px"><a class="btn-operation" onclick="submitAdd(this)"><span
								class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
						</a> <a class="btn-operation" onclick="cancleAdd(this)"><span
								class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
						</a></td>
					</tr>	
					
				<!-- 点击修改按钮触发事件模版  -->							
				<tr id="editTemplete" style="display:none">
							<td><span id="index"></span></td>
							<td><input id="mlCd" type="text" class="form-control"></td>
							<td><input id="ky" type="text" class="form-control"></td>
							<td><input id="value" type="text" class="form-control"></td>
							<td><input id="rmk" type="text" class="form-control"></td>
							<td><a class="btn-operation" onclick="submitEdit(this)"><span
									class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
							</a> <a class="btn-operation" onclick="cancelEdit(this)"><span
									class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
							</a></td>
						</tr>			
			</thead>
			<tbody id="dataTbody">
			</tbody>
		</table>
		
		<div class="table-page" paging-table="sysPropotyTable" page-size="10">
		</div>

</body>
<script type="text/javascript">
	var postParam;
	var codelength;
	var codeindex;
	var isAdding = 0;
	
	function search() {
		var aoColumns = [ 
		{
			"mDataProp" : "index",
			"bSortable" : true
		},{
			"mDataProp" : "mlCd",
			"bSortable" : true
		}, {
			"mDataProp" : "ky",
			"bSortable" : true
		}, {
			"mDataProp" : "value",
			"bSortable" : true
		}, {
			"mDataProp" : "rmk",
			"bSortable" : true
		} ];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/sysPropotyAction_getSysPropotys",
			"get" : "${pageContext.request.contextPath}/sysPropotyAction_getSysPropotysDetails", 
			"add" : "${pageContext.request.contextPath}/sysPropotyAction_addSysPropotyItem", 
			"delete" : "${pageContext.request.contextPath}/sysPropotyAction_deleteSysPropotyItem",
			"edit" : "${pageContext.request.contextPath}/sysPropotyAction_editSysPropotyItem"
		};
		initTable("sysPropotyTable", aoColumns, ajaxSource);
	}
	

</script>
</html>
