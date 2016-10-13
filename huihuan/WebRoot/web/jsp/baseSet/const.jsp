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
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/MyComponent/MyTable.js"></script>
<title>常量表</title>

<script type="text/javascript">
	function search() {
		var aoColumns = [ {
			"mDataProp" : "index",
			"bSortable" : true
		}, {
			"mDataProp" : "id",
			"bSortable" : true
		}, {
			"mDataProp" : "mlCd",
			"bSortable" : true
		}, {
			"mDataProp" : "type",
			"bSortable" : true
		}, {
			"mDataProp" : "ky",
			"bSortable" : true
		}, {
			"mDataProp" : "value",
			"bSortable" : true
		}, {
			"mDataProp" : "ordr",
			"bSortable" : true
		}, {
			"mDataProp" : "rmk",
			"bSortable" : true
		} ];
		var ajaxSource = {
			"get" : "${pageContext.request.contextPath}/constAction_getConst",
			"select" : "${pageContext.request.contextPath}/constAction_searchConsts",
			"add" : "${pageContext.request.contextPath}/constAction_addConst",
			"delete" : "${pageContext.request.contextPath}/constAction_deleteConst",
			"edit" : "${pageContext.request.contextPath}/constAction_editConst"
		};
		initTable("constTable", aoColumns, ajaxSource);
	}
</script>

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
			<a onclick="addItem(constTable)" class="btn-add"><span
				class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
		</div>

		<table id="constTable" class="table table-striped">
			<thead>
				<tr>
					<th class="w60">序号</th>
					<th class="w100"><a id="id">主码</a></th>
					<th class="w100"><a id="mlCd">模块代码</a></th>
					<th class="w100"><a id="type">模块类型</a><span
						class="glyphicon glyphicon-arrow-down order-btn"
						aria-hidden="true"></th>
					<th class="w80"><a id="ky">常量键</a><span
						class="glyphicon glyphicon-arrow-down order-btn"
						aria-hidden="true"></th>
					<th class="w80"><a id="value">常量值</a><span
						class="glyphicon glyphicon-arrow-down order-btn"
						aria-hidden="true"></th>
					<th class="w80"><a id="ordr">排序</a><span
						class="glyphicon glyphicon-arrow-down order-btn"
						aria-hidden="true"></th>
					<th class="w60"><a id="rmk">备注</a></th>
					<th class="w100">操作</th>
				</tr>
				<tr id="selectTemplete" style="display:none">
					<input id="keyword" type="hidden" sourceId="keyWord" />
					<td><span id="index"></span></td>
					<td><span id="id"></span></td>
					<td class="text-left"><span id="mlCd"> </span></td>
					<td><span id="type"></span></td>
					<td><span id="ky"></span></td>
					<td><span id="value"></span></td>
					<td><span id="ordr"></span></td>
					<td><span id="rmk"></span></td>
					
					<td><a id="rawMaterialViewButton" class="btn-operation"
						data-toggle="modal" title="查看"><span
							class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span> </a> 
						<a id="constEditButton" class="btn-operation" onclick="editItem(this)" data-toggle="modal" title="编辑">
						<span class="glyphicon glyphicon-edit" aria-hidden="true"></span> </a>
						<a onclick="deleteItem(this)" class="btn-operation" title="删除">
						<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> </a>
						</td>
					</tr>
					<tr id="insertTemplete" style="display:none">
							<td><span id="index"></span></td>
							<td><input id="id" type="text" value="" class="form-control" disabled="disabled"></td>
							<td><input id="mlCd" type="text" value="" class="form-control"></td>
							<td><input id="type" type="text" value="" class="form-control"></td>
							<td><input id="ky" type="text" value="" class="form-control"></td>
							<td><input id="value" type="text" value="" class="form-control"></td>
							<td><input id="ordr" type="text" value="" class="form-control"></td>
							<td><input id="rmk" type="text" value="" class="form-control"></td>
							<td><a class="btn-operation" onclick="submitAdd(this)"><span
									class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
							</a> <a class="btn-operation" onclick="cancleAdd(this)"><span
									class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
							</a></td>
						</tr>
						<tr id="editTemplete" style="display:none">
							<td><span id="index"></span></td>
							<td><input id="id" type="text" value="" class="form-control" disabled="disabled"></td>
							<td><input id="mlCd" type="text" value="" class="form-control"></td>
							<td><input id="type" type="text" value="" class="form-control"></td>
							<td><input id="ky" type="text" value="" class="form-control"></td>
							<td><input id="value" type="text" value="" class="form-control"></td>
							<td><input id="ordr" type="text" value="" class="form-control"></td>
							<td><input id="rmk" type="text" value="" class="form-control"></td>
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

				<div class="table-page" paging-table="constTable" page-size="10">
		</div>



	</div>




</body>
</html>
