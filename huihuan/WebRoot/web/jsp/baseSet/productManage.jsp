<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/MyComponent/MyTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/MyComponent/MySelect.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/jqcool.net-bootstrapvalidator/dist/js/bootstrapValidator.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/bootstrap3-typeahead.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/web/jqcool.net-bootstrapvalidator/dist/css/bootstrapValidator.css" />
<link
	href="${pageContext.request.contextPath}/web/css/jquery.datetimepicker.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="../script/bootstrap3-typeahead.js"></script>
<style type="text/css">
.Mytable thead tr {
	display: block;
}

.Mytable thead tr th{
	line-height: 10px;
}

.Mytable tbody {
	display: block;
	height: 106px;
	overflow: auto;
}

.Mytable tbody tr td {
	/* font-size: 15px; */
	line-height: 20px;
	padding: 0 4px;
}
</style>
<div style="width: 1024px">
	<div class="row breadcrumb-row">
		<ol class="breadcrumb">
			<li><a href="#">首页</a>
			</li>
			<li><a href="#">基础设施</a>
			</li>
			<li><a href="#">技术编码设置</a>
			</li>
			<li class="active">产品编码</li>
		</ol>
	</div>

	<div class="row wrapper">
		<div id="catagoriesAndDetailsDiv" class="col-sm-4">
			<div id="productCatagoriesDiv" class="row name-row">
				<label class="w100 truncated blueLabel" id="catagoryDetailsName" style="line-height:25px"></label>&nbsp;
				<select style="higth: 55px;font-size: 13px;height: 28px;margin: 1px;"
					id="catagoryDetailsSelect" name="catagoryDetailsSelect"
					class="form-control w100" onchange="initSameCatagoryTable()">
					<option value="">(全部)</option>
				</select>
			</div>
		</div>
		<input id="sameCatagoryIds" type="hidden" />
		<div class="col-sm-8 same-name-table">
			<span>同名类别</span> <img onclick="addsameCatagoryTableItem()"
				src="../image/add.png" alt="增加" class="btn-add btn-img"> <img
				onclick="initSameCatagoryTable()" src="../image/refresh.png"
				alt="刷新" class="btn-add btn-img"> <img
				onclick="changeSameCatagoryStatus()" src="../image/valid.png"
				alt="有效" class="btn-add btn-img" id="sameCatagoryStatus-switch">
			<input id="sameCatagoryStatus" value="0" type="hidden" />
			<div class="btn-add">
				<input id="sameCatagoryKeyword" type="text"><span
					style="font-size: 10px">关键字</span>
			</div>
			<table id="sameCatagoryTable" class="table table-striped Mytable"
				beforeInsert="beforeInsertSameCatagory"
				afterEdit="initProductTable()">
				<thead>
					<tr>
						<th width="23x"><input id="headCheckbox" type="checkbox"
							afterChange="initProductTable" />
						</th>
						<th width="60px">序号</th>
						<th width="120px"><a id="code">编码</a></th>
						<th width="360px"><a id="name">名称</a></th>
						<th width="60px"><a id="status">状态</a></th>
						<th width="80px">操作</th>
					</tr>
					<tr id="selectTemplete" style="display:none"
						onclick="selectSamaCatagoryTr(this)">
						<input id="catagoryDetails" type="hidden"
							sourceName="catagoryDetailsSelect" />
						<input id="keyword" type="hidden" sourceId="sameCatagoryKeyword" />
						<input id="samaCatagoryStatus" type="hidden"
							sourceId="sameCatagoryStatus" />
						<td><input name="selectCheckbox" type="checkbox"
							onchange="selectSamaCatagory()" />
						</td>
						<td width="60px"><span id="index"></span>
						</td>
						<td width="120px"><span id="code"></span>
						</td>
						<td class="text-left" width="360px"><span id="name"></span>
						</td>
						<td width="60px"><myspan id="status"
								params='{"0":"有效","1":"无效"}'></myspan>
						</td>
						<td width="80px"><a class="btn-operation"
							onclick="editItem(this)"><span
								class="glyphicon glyphicon-edit" aria-hidden="true"></span> </a> <a
							id="deleteButton" class="btn-operation"
							onclick="deleteItem(this)"><span
								class="glyphicon glyphicon-trash" aria-hidden="true"></span> </a></td>
					</tr>
					<tr id="insertTemplete" style="display:none">
						<input id="catagoryDetails" type="hidden"
							sourceName="catagoryDetailsSelect" />
						<td></td>
						<td width="60px"><span id="index"></span>
						</td>
						<td width="120px"><input id="catagoryCode" type="text" class="edit-input"
							disabled="disabled" /><input id="code" type="hidden" />
						</td>
						<td width="360px"><input id="name" type="text" class="edit-input" />
						</td>
						<td width="60px"><select id="status">
								<option value="0">有效</option>
								<option value="1">无效</option>
						</select></td>
						<td width="80px"><a class="btn-operation" onclick="submitAdd(this)"><span
								class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
						</a> <a class="btn-operation" onclick="cancleAdd(this)"><span
								class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
						</a></td>
					</tr>
					<tr id="editTemplete" style="display:none">
						<th></th>
						<td><span id="index"></span>
						</td>
						<td><input id="code" type="text" class="edit-input"
							disabled="disabled" />
						</td>
						<td><input id="name" type="text" class="edit-input" />
						</td>
						<td><select id="status">
								<option value="0">有效</option>
								<option value="1">无效</option>
						</select></td>
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
		</div>
	</div>

	<div class="row wrapper">
		<div class="row button-row">
			<img onclick="addProductTableItem(this)" 
				src="../image/add.png" alt="增加" class="btn-add btn-img" authUrl="productAction_addProduct"> <img
				onclick="initProductTable()" src="../image/refresh.png" alt="刷新"
				class="btn-add btn-img"> <input id="productStatus" value="0"
				type="hidden" /> <img onclick="changeProductStatus()"
				src="../image/valid.png" alt="有效" class="btn-add btn-img"
				id="productStatus-switch"> <img src="../image/print.png"
				alt="打印" class="btn-add btn-img">
			<div class="btn-add">
				<input id="keyword" type="text"><span
					style="font-size: 10px">关键字</span>
			</div>
			<span style="margin-left: 15px;">产品</span>
		</div>

		<table id="productTable" class="table table-striped"
			beforeInsert="beforeInsertProduct" afterInsert="afterInsertProduct"
			beforeSelect="beforeSelectProduct" beforeEdit="beforeEditProduct" divId="edit">
			<thead>
				<tr>
					<th class="w60">序号</th>
					<th width="10%"><a id="code">产品编码</a></th>
					<th width="35%"><a id="name">名称</a></th>
					<th width="10%"><a id="quantityUnit1">数量单位</a></th>
					<th width="10%"><a id="specialManageType">特殊管理</a></th>
					<th width="6%"><a id="status">状态</a></th>
					<th width="8%">历史记录</th>
					<th width="14%">操作</th>
				</tr>
				<tr id="selectTemplete" style="display:none">
					<input id="catagoryDetails" type="hidden"
						sourceName="catagoryDetailsSelect" />
					<input id="sameCatagory" type="hidden" sourceId="sameCatagoryIds" />
					<input id="keyword" type="hidden" sourceId="keyword" />
					<input id="productStatus" type="hidden" sourceId="productStatus" />
					<td><span id="index"></span>
					</td>
					<td><span id="code"></span>
					</td>
					<td class="text-left"><span id="name"></span>
					</td>
					<td><span id="quantityUnit1"></span>
					</td>
					<td><myspan id="specialManageType"
							params='{"0":"否","1":"麻醉药品","2":"一类精神药品","3":"二类精神药品"}'></myspan>
					</td>
					<td><myspan id="status" params='{"0":"有效","1":"无效","2":"审核中"}'></myspan>
					</td>
					<td><span class="glyphicon glyphicon-open-file file-btn"
						aria-hidden="true" data-toggle="modal" data-target="#item-history" onclick="showHistory(this,'Products_Hsty','id,name,code,used_name','q,w,e,r','product_id',0)"></span>
					</td>
					<td>
					<a class="btn-operation" onclick="editItem(this,1)"
						data-target="#formula-tab" title="查看"><span
							class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
					</a> 
					<a class="btn-operation" onclick="editItem(this)"
						title="编辑"> <span class="glyphicon glyphicon-edit"
							aria-hidden="true"></span> </a> <a class="btn-operation"
						onclick="deleteItem(this)" title="删除"> <span
							class="glyphicon glyphicon-trash" aria-hidden="true"></span> </a> <a
						id="checkProductButton" class="btn-operation"
						onclick="checkProduct(this)" title="审核"
						authUrl="productAction_check"> <span
							class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
					</a>
					</td>
				</tr>
			</thead>
			<tbody id="dataTbody">
			</tbody>
		</table>

		<div class="table-page" paging-table="productTable" page-size="10">
		</div>

		<div class="modal fade" id="edit" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			tableid="productTable">
			<input id="sameCatagoryId" type="hidden" />
			<div class="modal-dialog modal-productSameName">
				<div class="modal-content">
					<div class="modal-header"></div>
					<form id="defaultForm" method="post" class="form-horizontal">
						<div class="modal-body">
							<ul class="nav nav-tabs tablist" role="tablist">
								<li role="presentation" class="active"><a href="#basicInfo"
									aria-controls="home" role="tab" data-toggle="tab">基本信息</a>
								</li>
								<li role="presentation"><a href="#other"
									aria-controls="profile" role="tab" data-toggle="tab">其他&nbsp;&nbsp;</a>
								</li>
							</ul>
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane active" id="basicInfo">
									<table class="table edit-table" style="margin: 8px;width: 98%;">
										<tr>
											<td class="w150">同名类别名</td>
											<td class="w230"><span id="sameCatagoryName"></span>
											</td>
											<td class="w150">同名类别编码</td>
											<td class="w230"><span id="sameCatagoryCode"></span>
											</td>
										</tr>
										<tr>
											<td>兼做原辅料</td>
											<td colspan="3"><input id="materialName" type="text"
												class="w200" disabled="disabled"> <a
												class="btn-operation" href="#" data-toggle="modal"
												data-target="#raw-edit"><span
													class="glyphicon glyphicon-edit" aria-hidden="true"></span>
											</a> <a onclick="clearMaterial()">清除</a> <input id="materialId"
												type="hidden" />
											</td>
										</tr>
										<tr>
											<td>产品名称<span class="red">*</span>
											</td>
											<td class="form-group"><input type="text" id="name"
												name="name" disabled="disabled">
											</td>
											<td>规格</td>
											<td><input type="text" id="specification"
												onblur="setProductName(this)">
											</td>
										</tr>
										<tr>
											<td>产品编码</td>
											<td><span id="catagoryCode"></span><input id="code"
												type="hidden" />
											</td>
											<td>机器编码</td>
											<td><input id="machineCode" disabled="disabled"/>
											</td>
										</tr>
										<tr>
											<td>自定义编码</td>
											<td><input type="text" id="userDefinedCode">
											</td>
											<td>曾用名</td>
											<td><input type="text" id="usedName">
											</td>
										</tr>
										<tr>
											<td>产品代号</td>
											<td><input type="text" id="codeName">
											</td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td><span>生产倍数</span> <select id="productUnit"
												defultValue="个" class="w60">
													<option value="万">万</option>
													<option value="千">千</option>
													<option value="百">百</option>
													<option value="十">十</option>
													<option value="个" selected="selected">个</option>
													<option value="K">K</option>
											</select></td>
											<td class="form-group"><span>数量单位</span><span
												class="red">*</span> <select id="quantityUnit1"
												name="quantityUnit1" onchange="changeQuantityUnit(this)"
												class="w60">
											</select> <a class="btn-operation" onclick="openUnitTable()"><span
													class="glyphicon glyphicon-edit" aria-hidden="true"></span>
											</a></td>
											<td>单位转换系数</td>
											<td class="form-group"><input type="text" class="w40"
												id="preUnitCnvrsnFctr" name="preUnitCnvrsnFctr"> <select
												id="quantityUnit2" class="w40">
											</select> ＝ <input type="text" class="w40" id="unitCnvrsnFctr"
												name="unitCnvrsnFctr"> <select id="baseQuantityUnit"
												class="w40">
											</select> <a class="btn-operation" onclick="openBaseUnitTable()"><span
													class="glyphicon glyphicon-edit" aria-hidden="true"></span>
											</a></td>
										</tr>
										<tr>
											<td>批准文号</td>
											<td><input type="text" id="approvalNumber">
											</td>
											<td>批准文号有效期至</td>
											<td><input id="approvalNumberValidDate" class="info"
												type="text" />
											</td>
										</tr>
										<tr>
											<td>特殊管理</td>
											<td colspan="3"><label><input type="radio"
													name="specialManageType" value="0" checked="checked" /> 否</label>
												<label><input type="radio" name="specialManageType"
													value="1" /> 麻醉药品</label> <label><input type="radio"
													name="specialManageType" value="2" /> 一类精神药品</label> <label><input
													type="radio" name="specialManageType" value="3" /> 二类精神药品</label>
											</td>
										</tr>
										<tr>
											<td>存储条件</td>
											<td colspan="3"><input type="text" id="storageCondition">
											</td>
										</tr>
										<tr>
											<td>有效期(月)<span class="red">*</span>
											</td>
											<td class="form-group"><input type="text"
												id="validityPeriod" name="validityPeriod">
											</td>
											<td>有效期预警(日)</td>
											<td class="form-group"><input type="text"
												id="warmingDay" name="warmingDay">
											</td>
										</tr>
									</table>
								</div>
								<div role="tabpanel" class="tab-pane" id="other">
									<table class="table edit-table">
										<tr>
											<td>成本核算方法</td>
											<td><select name="" id="">
													<option value="">默认</option>
											</select></td>
											<td>成本核算对象</td>
											<td><select name="" id="">
													<option value="">默认</option>
											</select></td>
										</tr>
										<tr>
											<td>是否销售</td>
											<td><input type="checkbox">
											</td>
											<td>是否检验</td>
											<td><input type="checkbox">
											</td>
										</tr>
										<tr>
											<td>是否检验批准</td>
											<td><input type="checkbox">
											</td>
											<td>是否放行</td>
											<td><input type="checkbox">
											</td>
										</tr>
									</table>
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-default" viewType="hidden">确定</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="modal fade" id="sub-edit" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-productSameName">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
					</div>
					<div class="modal-body">
						<a class="btn-add" onclick="addItem(unitTable)"><img
							src="../image/add.png" alt="增加" class="btn-img"> </a>
						<table id="unitTable" class="table sort-table table-striped"
							afterInsert="refreshUnitSelect" afterDelete="refreshUnitSelect"
							afterEdit="refreshUnitSelect">
							<thead>
								<tr>
									<th>序号</th>
									<th>单位名称</th>
									<th>操作</th>
								</tr>
								<tr id="selectTemplete" style="display:none">
									<td><span id="index"></span>
									</td>
									<td><span id="name"></span>
									</td>
									<td><a class="btn-operation" onclick="editItem(this)"><span
											class="glyphicon glyphicon-edit" aria-hidden="true"></span> </a>
										<a class="btn-operation" onclick="deleteItem(this)"><span
											class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</a></td>
								</tr>
								<tr id="insertTemplete" style="display:none">
									<td></td>
									<td><input id="name" type="text" class="table-input">
									</td>
									<td><a class="btn-operation" onclick="submitAdd(this)"><span
											class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
									</a> <a class="btn-operation" onclick="cancleAdd(this)"><span
											class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
									</a></td>
								</tr>
								<tr id="editTemplete" style="display:none">
									<td><span id="index"></span>
									</td>
									<td><input id="name" type="text" class="table-input">
									</td>
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
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">确定
						</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="raw-edit" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-normal">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
					</div>
					<div class="modal-body">
						<div id="materialCatagoriesDiv" class="row raw-row"></div>
						<div class="row raw-row">
							<label for="keyword">关键字：</label> <input type="text"
								class="form-control" id="materialKeyword">
							</option>
							<div class="row-section btn-section">
								<button onclick="searchMaterials()" class="btn btn-default">查询</button>
							</div>
						</div>
						<table id="materialTable" class="table table-striped">
							<thead>
								<tr>
									<th>序号</th>
									<th>原辅料编码</th>
									<th>原辅料名称</th>
								</tr>
								<tr id="selectTemplete" style="display:none"
									onclick="selectMaterial(this)">
									<input id="catagoryDetails" type="hidden"
										sourceName="materialCatagoryDetailsSelect" />
									<input id="keyword" type="hidden" sourceId="materialKeyword" />
									<input id="status" type="hidden" value="0" />
									<td><span id="index"></span></td>
									<td><span id="code"></span></td>
									<td><span id="name"></span></td>
								</tr>
							</thead>
							<tbody id="dataTbody">
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">确定
						</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<script type="text/javascript">
    var history_no;
	var sameCatagoryLength = 0;
	var catagoryCode = "";
	$(function() {
		initProductCatagories();
		initSameCatagoryTable();
		initSelect($("#edit #quantityUnit1"),
				"${pageContext.request.contextPath}/unitAction_getUnits", null,
				2, null);
		$('#approvalNumberValidDate').datetimepicker({
			yearOffset : 0,
			lang : 'ch',
			timepicker : false,
			format : 'Y-m-d',
			formatDate : 'Y-m-d'
		});
		initMaterialCatagories();
	});
	/**************************分类类别和同名类别表格的逻辑 开始**********************************/
	function initProductCatagories() {
		var sHtml = $("#productCatagoriesDiv").prop("outerHTML");
		$("#catagoriesAndDetailsDiv").html("");
		$
				.ajax({
					type : "post",
					dataType : "json", //收受数据格式
					url : "${pageContext.request.contextPath}/catagoryAction_getCatagoriesAndDetails?type=1",
					cache : false,
					success : function(data) {
						if (data.retcode == "0000") {

							$
									.each(
											data.obj,
											function(index, item) {
												var createObj = jQuery(sHtml);
												$(createObj)
														.find(
																"#catagoryDetailsSelect")
														.attr("catagoryId",
																item.id);
												$(createObj).find(
														"#catagoryDetailsName")
														.html(item.name);
												$(createObj).find(
														"#catagoryDetailsName")
														.attr("title",
																item.name);
												$
														.each(
																item.catagoryDetails,
																function(
																		index1,
																		item1) {
																	var createOption = jQuery("<option value='"+item1.id+"' code='"+item1.code+"'>"
																			+ item1.name
																			+ "</option>");
																	$(createObj)
																			.find(
																					"#catagoryDetailsSelect")
																			.append(
																					createOption);
																});
												$("#catagoriesAndDetailsDiv")
														.append(createObj);
											});
						}
					}
				});
	}

	function initSameCatagoryTable() {
		var aoColumns = [ {
			"mDataProp" : "code",
			"bSortable" : true,
			"defaultSort":true
		}, {
			"mDataProp" : "name",
			"bSortable" : true
		}, {
			"mDataProp" : "status",
			"bSortable" : true
		} ];
		var ajaxSource = {
			"get" : "${pageContext.request.contextPath}/sameCatagoryAction_getSameCatagory",
			"select" : "${pageContext.request.contextPath}/sameCatagoryAction_getSameCatagories",
			"add" : "${pageContext.request.contextPath}/sameCatagoryAction_addSameCatagory",
			"delete" : "${pageContext.request.contextPath}/sameCatagoryAction_deleteSameCatagory",
			"edit" : "${pageContext.request.contextPath}/sameCatagoryAction_editSameCatagory"
		};
		initTable("sameCatagoryTable", aoColumns, ajaxSource);
		$("#sameCatagoryIds").val("");
		getSameCatagoryLength();
	}

	function addsameCatagoryTableItem() {
		var isAdd = true;
		var msg = "以下分类类别未选择：";
		catagoryCode = "";
		$.each($("#catagoriesAndDetailsDiv").find("div"),
				function(index, item) {
					if ($(item).find("#catagoryDetailsSelect").val() == "") {
						msg += "\n -"
								+ $(item).find("#catagoryDetailsName").html();
						isAdd = false;
					}
					catagoryCode += $(item).find("#catagoryDetailsSelect")
							.find("option:selected").attr("code");
				});
		if (isAdd) {
			addItem(sameCatagoryTable);
			return;
		}
		alert(msg);
	}

	function getSameCatagoryLength() {
		$
				.ajax({
					type : "post",
					dataType : "json", //收受数据格式
					url : "${pageContext.request.contextPath}/sameCatagoryAction_getSameCatagoryLength",
					cache : false,
					success : function(data) {
						if (data.retcode == "0000") {
							sameCatagoryLength = Number(data.obj);
						}
					}
				});
	}

	function beforeInsertSameCatagory(createObj) {

		var preCode = $(createObj).prev().find("#code").html();
		if (preCode != null) {
			preCode = preCode.substring(preCode.length - sameCatagoryLength,
					preCode.length);
			var code = (Array(sameCatagoryLength).join('0') + (Number(preCode) + 1))
					.slice(-sameCatagoryLength);
			$(createObj).find("#code").val(code);
			$(createObj).find("#catagoryCode").val(catagoryCode + code);
		} else {
			var code = (Array(sameCatagoryLength).join('0') + 0)
					.slice(-sameCatagoryLength);
			$(createObj).find("#code").val(code);
			$(createObj).find("#catagoryCode").val(catagoryCode + code);
		}
	}

	function selectSamaCatagoryTr(target) {
		$(target).find("input[name='selectCheckbox']").click();
	}

	function selectSamaCatagory() {
		initProductTable();
	}

	function changeSameCatagoryStatus() {
		var curStatus = $("#sameCatagoryStatus").val();
		if (curStatus == "0") {
			$("#sameCatagoryStatus").val("1");
			$("#sameCatagoryStatus-switch").attr("src", "../image/invalid.png");
		} else if (curStatus == "1") {
			$("#sameCatagoryStatus").val("");
			$("#sameCatagoryStatus-switch").attr("src", "../image/all.png");
		} else if (curStatus == "") {
			$("#sameCatagoryStatus").val("0");
			$("#sameCatagoryStatus-switch").attr("src", "../image/valid.png");
		}
	}
	/**************************分类类别和同名类别表格的逻辑 结束**********************************/

	/**************************产品表格的逻辑 开始**********************************/

	var productLength = 0;
	var preProductCode = "";
	function initProductTable() {
		var aoColumns = [ {
			"mDataProp" : "sameCatagoryName"
		}, {
			"mDataProp" : "sameCatagoryCode"
		}, {
			"mDataProp" : "materialName"
		}, {
			"mDataProp" : "materialId"
		}, {
			"mDataProp" : "catagoryCode"
		}, {
			"mDataProp" : "code",
			"bSortable" : true,
			"defaultSort":true
		}, {
			"mDataProp" : "name",
			"bSortable" : true
		}, {
			"mDataProp" : "quantityUnit1",
			"bSortable" : true
		}, {
			"mDataProp" : "quantityUnit2"
		}, {
			"mDataProp" : "specialManageType",
			"bSortable" : true
		}, {
			"mDataProp" : "status",
			"bSortable" : true
		}, {
			"mDataProp" : "isMiddle"
		}, {
			"mDataProp" : "specification"
		}, {
			"mDataProp" : "machineCode"
		}, {
			"mDataProp" : "userDefinedCode"
		}, {
			"mDataProp" : "usedName"
		}, {
			"mDataProp" : "codeName"
		}, {
			"mDataProp" : "productUnit"
		}, {
			"mDataProp" : "preUnitCnvrsnFctr"
		}, {
			"mDataProp" : "unitCnvrsnFctr"
		}, {
			"mDataProp" : "baseQuantityUnit"
		}, {
			"mDataProp" : "approvalNumber"
		}, {
			"mDataProp" : "approvalNumberValidDate"
		}, {
			"mDataProp" : "storageCondition"
		}, {
			"mDataProp" : "validityPeriod"
		}, {
			"mDataProp" : "warmingDay"
		} ];
		var ajaxSource = {
			"get" : "${pageContext.request.contextPath}/productAction_getProduct",
			"select" : "${pageContext.request.contextPath}/productAction_getProducts",
			"add" : "${pageContext.request.contextPath}/productAction_addProduct",
			"delete" : "${pageContext.request.contextPath}/productAction_deleteProduct",
			"edit" : "${pageContext.request.contextPath}/productAction_editProduct"
		};
		var sameCatagoryIds = new Array();
		$.each($("input[name='selectCheckbox']"), function(index, item) {
			//console.log(item.checked);
			var status = $(item).prop("checked");
			if (status == true) {
				var id = $(item).parents("tr").find("#itemId").val();
				sameCatagoryIds[index] = id;
			}
		});
		console.log(JSON.stringify(sameCatagoryIds));
		$("#sameCatagoryIds").val(JSON.stringify(sameCatagoryIds));
		initTable("productTable", aoColumns, ajaxSource);
	}

	function addProductTableItem(obj) {
		var selectCount = 0;
		var sameCatagoryId = "";
		$.each($("#sameCatagoryTable #dataTbody input[name='selectCheckbox']"),
				function(index, item) {
					if ($(item).prop("checked") == true) {
						selectCount++;
						sameCatagoryId = $(item).parents("tr").find("#itemId")
								.val();
					}
				});
		if (selectCount != 1) {
			alert("必须选中一个同名类别才能增加产品！");
		} else {
			$
					.ajax({
						type : "post",
						data : {
							"sameCatagoryId" : sameCatagoryId
						},
						dataType : "json", //收受数据格式
						url : "${pageContext.request.contextPath}/productAction_isAbleAddProduct",
						cache : false,
						success : function(data) {
							if (data.retcode == "0000") {
								addItem(productTable);
							} else {
								alert(data.errorMsg);
							}
						}
					});
		}
	}

	function beforeSelectProduct(obj, item) {
		if (item.status != 2) {
			$(obj).find("#checkProductButton").css("display", "none");
		}
	}

	function beforeInsertProduct(div) {
		$
				.each(
						$("#sameCatagoryTable #dataTbody input[name='selectCheckbox']"),
						function(index, item) {
							if ($(item).prop("checked") == true) {
								var smcode = $(item).parents("tr")
										.find("#code").html();
								var smname = $(item).parents("tr")
										.find("#name").html();
								var smid = $(item).parents("tr")
										.find("#itemId").val();
								$(div).find("#sameCatagoryId").val(smid);
								$(div).find("#sameCatagoryCode").html(smcode);
								$(div).find("#sameCatagoryName").html(smname);
								$(div).find("#name").val(smname);
								getProductLengthAndPreCode(div, smid, smcode);
							}
						});
		$.ajax({
			type : "post",
			dataType : "json", //收受数据格式
			url : "${pageContext.request.contextPath}/sysPropotyAction_getMachineCode",
			cache : false,
			success : function(data) {
				if (data.retcode == "0000") {
					$("#edit #machineCode").val(data.obj);
				} else {
					alert(data.errorMsg);
				}
			}
		});
	}

	function afterInsertProduct() {
		$("#defaultForm").bootstrapValidator('resetForm', true);
	}
	
	function beforeEditProduct(div,dataItem) {
		$("#quantityUnit1").val(dataItem.quantityUnit1);
		changeQuantityUnit($("#quantityUnit1"));
	}

	function getProductLengthAndPreCode(div, smid, smcode) {
		$
				.ajax({
					type : "post",
					data : {
						"sameCatagoryId" : smid
					},
					dataType : "json", //收受数据格式
					url : "${pageContext.request.contextPath}/productAction_getProductLengthAndPreCode",
					cache : false,
					success : function(data) {
						if (data.retcode == "0000") {
							productLength = Number(data.obj.productLength);
							preProductCode = data.obj.preProductCode + "";
							if (preProductCode != "") {
								var code = (Array(productLength).join('0') + (Number(preProductCode) + 1))
										.slice(-productLength);
								$(div).find("#code").val(code);
								$(div).find("#catagoryCode")
										.html(smcode + code);
							} else {
								var code = (Array(productLength).join('0') + 0)
										.slice(-productLength);
								$(div).find("#code").val(code);
								$(div).find("#catagoryCode")
										.html(smcode + code);
							}
						}
					}
				});
	}

	function setProductName(obj) {
		var name = $("#edit").find("#sameCatagoryName").html();
		$("#edit").find("#name").val(name + " " + $(obj).val());
	}

	function refreshUnitSelect() {
		initSelect($("#edit #quantityUnit1"),
				"${pageContext.request.contextPath}/unitAction_getUnits", null,
				2, $("#edit #quantityUnit1").val());
		changeQuantityUnit($("#edit #quantityUnit1"));
	}

	function changeQuantityUnit(obj) {
		initSelect(
				$("#edit #quantityUnit2"),
				"${pageContext.request.contextPath}/unitAction_getQuantityUnit2ByQuantityUnit",
				{
					quantityUnitId : $(obj).val()
				}, 2, $(obj).val());
		initSelect(
				$("#edit #baseQuantityUnit"),
				"${pageContext.request.contextPath}/unitAction_getBaseQuantityUnitByQuantityUnit",
				{
					quantityUnitId : $(obj).val()
				}, 2, null);
		if ($("#preUnitCnvrsnFctr").val() == null
				|| $("#preUnitCnvrsnFctr").val() == "") {
			$("#preUnitCnvrsnFctr").val(1);
		}
	}

	function initMaterialCatagories() {
		$("#materialCatagoriesDiv").html("");
		$
				.ajax({
					type : "post",
					dataType : "json", //收受数据格式
					url : "${pageContext.request.contextPath}/catagoryAction_getCatagoriesAndDetails?type=2",
					cache : false,
					success : function(data) {
						if (data.retcode == "0000") {
							var addHtml;
							$
									.each(
											data.obj,
											function(index, item) {
												addHtml = "";
												addHtml += "<label>"
														+ item.name
														+ ":</label>";
												addHtml += "<select name='materialCatagoryDetailsSelect' class='form-control'>";
												addHtml += "<option value=''>(全部)</option>";
												$
														.each(
																item.catagoryDetails,
																function(
																		index1,
																		item1) {
																	addHtml += "<option value='"+item1.id+"'>"
																			+ item1.name
																			+ "</option>";
																});
												addHtml += "</select>";
												$("#materialCatagoriesDiv")
														.append(addHtml);
											});
						}
					}
				});
	}

	function searchMaterials() {
		var aoColumns = [ {
			"mDataProp" : "code",
			"bSortable" : false
		}, {
			"mDataProp" : "name",
			"bSortable" : false
		} ];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/materialsAction_getMaterials"
		};
		initTable("materialTable", aoColumns, ajaxSource);
	}

	function selectMaterial(obj) {
		$("#edit #materialId").val($(obj).find("#itemId").val());
		$("#edit #materialName").val($(obj).find("#name").html());
		//console.log($("#edit #materialId").val());
		//console.log($("#edit #materialName").val());
		$("#raw-edit").modal("hide");
	}

	function clearMaterial() {
		$("#edit #materialId").val("");
		$("#edit #materialName").val("");
	}

	function changeProductStatus() {
		var curStatus = $("#productStatus").val();
		if (curStatus == "0") {
			$("#productStatus").val("1");
			$("#productStatus-switch").attr("src", "../image/invalid.png");
		} else if (curStatus == "1") {
			$("#productStatus").val("2");
			$("#productStatus-switch").attr("src", "../image/checking.png");
		} else if (curStatus == "2") {
			$("#productStatus").val("");
			$("#productStatus-switch").attr("src", "../image/all.png");
		} else if (curStatus == "") {
			$("#productStatus").val("0");
			$("#productStatus-switch").attr("src", "../image/valid.png");
		}
	}

	function checkProduct(obj) {
		var productId = $(obj).parents("tr").find("#itemId").val();
		if (window.confirm('是否审核通过？')) {
		} else {
			return false;
		}
		$
				.ajax({
					type : "post",
					data : {
						"productId" : productId
					},
					dataType : "json", //收受数据格式
					url : "${pageContext.request.contextPath}/productAction_checkProduct",
					cache : false,
					success : function(data) {
						if (data.retcode == "0000") {
							initProductTable();
						} else {
							alert(data.errorMsg);
						}
					}
				});
	}
	/**************************产品表格的逻辑 结束**********************************/

	/**************************单位表格的逻辑 开始**********************************/
	function openUnitTable() {
		initUnitTable();
		$("#sub-edit").modal("show");
	}

	function openBaseUnitTable() {
		initUnitTable();
		$("#sub-edit").modal("show");
	}
	function initUnitTable() {
		var aoColumns = [ {
			"mDataProp" : "name"
		} ];
		var ajaxSource = {
			"get" : "${pageContext.request.contextPath}/unitAction_getUnit",
			"select" : "${pageContext.request.contextPath}/unitAction_getUnits?type=4",
			"add" : "${pageContext.request.contextPath}/unitAction_addUnit",
			"delete" : "${pageContext.request.contextPath}/unitAction_deleteUnit",
			"edit" : "${pageContext.request.contextPath}/unitAction_editUnit"
		};
		initTable("unitTable", aoColumns, ajaxSource);
	}
	/**************************单位表格的逻辑 结束**********************************/

	$(document)
			.ready(
					function() {
						$('#defaultForm')
								.bootstrapValidator(
										{
											excluded : [ ':disabled' ],
											feedbackIcons : {
												valid : 'glyphicon glyphicon-ok',
												invalid : 'glyphicon glyphicon-remove',
												validating : 'glyphicon glyphicon-refresh'
											},
											fields : {
												name : {
													message : 'The username is not valid',
													validators : {
														notEmpty : {
															message : '产品名必填！'
														}
													}
												},
												quantityUnit1 : {
													message : 'The username is not valid',
													validators : {
														notEmpty : {
															message : '数量单位必填！'
														}
													}
												},
												validityPeriod : {
													message : 'The username is not valid',
													validators : {
														notEmpty : {
															message : '有效期必填！'
														},
														regexp : {
															regexp : /^\+?[1-9][0-9]*$/,
															message : '有效期必须为正整数！'
														}
													}
												},
												warmingDay : {
													message : 'The username is not valid',
													validators : {
														regexp : {
															regexp : /^\+?[1-9][0-9]*$/,
															message : '预警天数必须为正整数！'
														}
													}
												},
												preUnitCnvrsnFctr : {
													message : 'The username is not valid',
													validators : {
														regexp : {
															regexp : /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/,
															message : '系数必须为正数！'
														}
													}
												},
												unitCnvrsnFctr : {
													message : 'The username is not valid',
													validators : {
														regexp : {
															regexp : /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/,
															message : '系数必须为正数！'
														}
													}
												}
											}
										}).on(
										'success.form.bv',
										function(e) {
											e.preventDefault();
											submitAdd(null, 'edit');
											$(e.target).bootstrapValidator(
													'disableSubmitButtons',
													false) // Enable the submit buttons
										});
					});
					
</script>