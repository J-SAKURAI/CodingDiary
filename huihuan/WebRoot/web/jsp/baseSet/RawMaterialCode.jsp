<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/MyComponent/MySelect.js"></script>
<link
	href="${pageContext.request.contextPath}/web/css/jquery.datetimepicker.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/jquery.datetime.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/MyComponent/MyTable.js"></script>
<div style="width: 1024px">
	<div class="row breadcrumb-row">
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">基础设施</a></li>
			<li><a href="#">技术编码设置</a></li>
			<li class="active">原辅料编码</li>
		</ol>
	</div>

	<div class="row wrapper">
		<div class="col-md-12">
			<div class="row rawMaterial-row" id="selectArea" style="width: 800px;"></div>
			
		</div>
	</div>

	<div class="row wrapper">
		<div class="row button-row">
			<img onclick="add()" src="../image/add.png" alt="增加"
				class="btn-add btn-img"> <img onclick="search()"
				src="../image/refresh.png" alt="刷新" class="btn-add btn-img"> <input
				id="rawMaterialStatus" value="0" type="hidden" /> <img
				onclick="changeRawMaterialStatus()" src="../image/valid.png"
				alt="有效" class="btn-add btn-img" id="rawMaterial-switch"> <img
				src="../image/print.png" alt="打印" class="btn-add btn-img">
			<div class="btn-add">
				<input id="keyword" type="text"><span
					style="font-size: 10px">关键字</span>
			</div>
			<span style="margin-left: 15px;">原辅料</span>
		</div>

		<table id="rawMaterialTable" class="table table-striped" beforeSelect="beforeSelectRawMaterial">
			<thead>
				<tr>
					<th class="w60">序号</th>
					<th class="w100"><a id="code">原辅料编码</a>
					</th>
					<th class="w100"><a id="name">名称</a>
					</th>
					<th class="w80"><a id="quantityUnit1">数量单位</a>
					</th>
					<th class="w80"><a id="specialManageType">特殊管理</a>
					</th>
					<th class="w80"><a id="status">状态</a>
					</th>
					<th class="w60">历史记录</th>
					<th class="w100">操作</th>
				</tr>
				<tr id="selectTemplete" style="display:none">
					<input id="catagoryDetails" type="hidden" sourceName="rawMaterialList" />
					<input id="keyword" type="hidden" sourceId="keyword" />
					<input id="rawMaterialStatus" type="hidden" sourceId="rawMaterialStatus" />
					<td><span id="index"></span></td>
					<td><span id="code"></span></td>
					<td class="text-left"><span id="name"></span></td>
					<td><span id="quantityUnit1"></span></td>
					<td><myspan id="specialManageType"
							params='{"0":"否","1":"麻醉药品","2":"一类精神药品","3":"二类精神药品"}'></myspan></td>
					<td><myspan id="status" params='{"0":"有效","1":"无效","2":"审核中"}'></myspan></td>
					<td><span onclick="history()"
						class="glyphicon glyphicon-open-file file-btn" aria-hidden="true"
						data-toggle="modal" data-target="#history"></span>
					</td>
					<td>
					<a id="rawMaterialViewButton" class="btn-operation" 
						data-toggle="modal" title="查看"><span
							class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
					</a> 
					<a id="rawMaterialEditButton" class="btn-operation"
						data-toggle="modal" title="编辑"><span
							class="glyphicon glyphicon-edit" aria-hidden="true"></span>
					</a>
					<a onclick="deleteItem(this)" class="btn-operation" title="删除"><span
							class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					</a>
					<a id="rawMaterialCheckButton" class="btn-operation" title="审核" authUrl="materialsAction_checkMaterial"><span
							class="glyphicon glyphicon-thumbs-up" aria-hidden="‘true’"></span>
					</a>
					</td>
				</tr>
			</thead>
			<tbody id="dataTbody">
			</tbody>
		</table>

		<div class="table-page" paging-table="rawMaterialTable" page-size="10">
		</div>




		<span style="DISPLAY:none"> <!-- 按钮触发模态框 -->
			<button id="show" type="hidden" data-toggle="modal"
				data-target="#myModal" data-backdrop="false">开始演示模态框</button> </span>


		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"></div>
					<div class="modal-body">
						<table class="table edit-table">
							<form id="defaultForm">

								<!--                                         <tr>
                                            <td>原辅料分类</td>
                                            <td colspan="3">
                                                 <select name="rawMaterialList_modal" id="rawMaterialList_modal" onchange="changeCode_modal()">  
                                                </select>
                                            </td>
                                        </tr> -->
								<tr id="tmodal">
									<td class="w150" style='display:none'>中间体</td>
									<td class="w230" style='display:none'><label><input
											type="radio" name="isMiddle" value="0" /> 否</label> <label><input
											type="radio" name="isMiddle" value="1" /> 是</label>
									</td>
									<td class="w150">对应产品</td>
									<td class="w150"><input id="productName" type="text"
										class="w200" disabled="disabled"> <a
										style='display:none' class="btn-operation" href="#"
										data-toggle="modal" data-target="#raw-edit"><span
											class="glyphicon glyphicon-edit" aria-hidden="true"></span> </a>
										<a style='display:none' onclick="clearProduct()">清除</a> <input
										id="productId" type="hidden" />
									</td>
								</tr>
								<tr>
									<td>原辅料名称<span class="red">*</span></td>
									<td><input type="text" id="materialName"></td>
									<td>机器编码</td>
									<td><input id="machineCode" disabled="disabled"/></td>
								</tr>
								<tr>
									<td style='display:none'>分类编码</td>
									<td style='display:none'><input type="text"
										id="classificationcode" disabled="true"></td>
									<td style='display:none'>原辅料序数编码</td>
									<td style='display:none'><input type="text"
										id="materialCode" /></td>
								</tr>
								<tr>
									<td>原辅料编码</td>
									<td><input type="text" id='thecode' disabled="true" /></td>
								</tr>
								<tr>
									<td>自定义编码</td>
									<td><input type="text" id="userDefinedCode"></td>
									<td>曾用名</td>
									<td><input type="text" id="usedName"></td>
								</tr>
								<tr>
									<td class="form-group"><span>数量单位</span><span class="red">*</span>
									</td>
									<td><select id="quantityUnit1" name="quantityUnit1"
										onchange="changeQuantityUnit(this)" class="w60">
									</select> <a class="btn-operation" onclick="openUnitTable()"><span
											class="glyphicon glyphicon-edit" aria-hidden="true"></span> </a>
									</td>
									<td>转换系数</td>
									<td class="form-group"><input type="text" class="w40"
										id="preUnitCnvrsnFctr" name="preUnitCnvrsnFctr"> <select
										id="quantityUnit2" class="w40">
									</select> ＝ <input type="text" class="w40" id="unitCnvrsnFctr"
										name="unitCnvrsnFctr"> <select id="baseQuantityUnit"
										class="w40">
									</select> <a class="btn-operation" onclick="openBaseUnitTable()"><span
											class="glyphicon glyphicon-edit" aria-hidden="true"></span> </a>
									</td>
								</tr>
								<!--                                         <tr>
                                            <td>入库复称</td>
                                            <td>
                                                <label><input type="radio" name="isRepeatWeight" value="0"/> 否</label>
                                                <label><input type="radio" name="isRepeatWeight" value="1"/> 是</label>
                                            </td>
                                            <td>公差范围</td>
                                            <td>±<input type="text" class="w100" id="toleranceRange">％</td>
                                        </tr>
                                        <tr>
                                            <td>入库复称公式</td>
                                            <td colspan="3">
                                                <textarea name="" id="repeatWeightFormula" rows="2"></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>含量补差公式</td>
                                            <td colspan="3">
                                                <textarea name="" id="supplementFormula" rows="2"></textarea>
                                            </td>
                                        </tr> -->
								<tr>
									<td>特殊管理</td>
									<td colspan="3"><label><input type="radio"
											name="specialManageType" value="0" /> 否</label> <label><input
											type="radio" name="specialManageType" value="1" /> 毒麻药品</label> <label><input
											type="radio" name="specialManageType" value="2" /> 一类精神药品</label> <label><input
											type="radio" name="specialManageType" value="3" /> 二类精神药品</label>
									</td>
								</tr>
								<!--                                         <tr>
                                            <td>最小库存量</td>
                                            <td><input type="text" id="minInventory"></td>
                                            <td>最大库存量</td>
                                            <td><input type="text" id="maxInventory"></td>
                                        </tr> -->
								<tr>
									<td>存储条件</td>
									<td colspan="3"><input type="text" id="storageCondition">
									</td>
								</tr>
								<tr>
									<td>有效期管理模式</td>
									<td colspan="3">
										<label>
											<input type="radio"
											onclick="check(1)" name="validityManageType" value="0" />
											来厂提供</label> 
											<label>
											<input type="radio" onclick="check(2)"
											name="validityManageType" value="1"/> 本厂自定</label>
									</td>
								</tr>

								<tr>
									<td id="validityPeriodTd">有效期（月）</td>
									<td><input type="text" id="validityPeriod"></td>
									<td>有效期预警(日)</td>
									<td><input type="text" id="warmingDay"></td>
								</tr>
								<tr>
									<td>照片</td>
									<td colspan="3"><label><input type="file" name=""
											value="0" /> </label>
									</td>
								</tr>
								<input type="reset" name="reset" style="display: none;" /> <input
									type="text" id="tid" style="display: none;" />
							</form>
						</table>
					</div>
					<div class="modal-footer">
						<button id="submit" onclick="submit()" isAdd="1" type="button"
							class="btn btn-default">确定</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

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
						afterInsert="initUnitSelect" afterDelete="initUnitSelect"
						afterEdit="initUnitSelect">
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
										class="glyphicon glyphicon-edit" aria-hidden="true"></span> </a> <a
									class="btn-operation" onclick="deleteItem(this)"><span
										class="glyphicon glyphicon-trash" aria-hidden="true"></span> </a>
								</td>
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
					<div id="productCatagoriesDiv" class="row raw-row"></div>
					<div class="row raw-row">
						<label for="keyword">关键字：</label> <input type="text"
							class="form-control" id="productKeyword">
						</option>
						<div class="row-section btn-section">
							<button onclick="searchProducts()" class="btn btn-default">查询</button>
						</div>
					</div>
					<table id="productTable" class="table table-striped">
						<thead>
							<tr>
								<th>序号</th>
								<th>产品编码</th>
								<th>产品名称</th>
							</tr>
							<tr id="selectTemplete" style="display:none"
								onclick="selectProduct(this)">
								<input id="catagoryDetails" type="hidden"
									sourceName="productCatagoryDetailsSelect" />
								<input id="keyword" type="hidden" sourceId="productKeyword" />
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
<script type="text/javascript">
	var postParam;
	var codelength;
	var codeindex;
	var isAdding = 0;
	var validityPeriodValue="";
	$(function() {
		/* 	$('#warmingDay').datetimepicker({
		 yearOffset : 0,
		 lang : 'ch',
		 timepicker : false,
		 format : 'd/m/Y',
		 formatDate : 'Y/m/d',
		 //minDate:'-1970/01/02', // yesterday is minimum date
		 //maxDate:'+1970/01/02' // and tommorow is maximum date calendar
		 }); */

		initSelect($("#myModal #quantityUnit1"),
				"${pageContext.request.contextPath}/unitAction_getUnits", null,
				2, null);
		postParam = {
			"type" : 2
		};
		$
				.getJSON(
						'${pageContext.request.contextPath}/catagoryAction_getCodesLength',
						postParam, function(data, status) {
							if (data.retcode == "0000") {
								codelength = data.obj.bitLength;
							} else {
								alert(data.errorMsg);
							}
						});
		$
				.getJSON(
						'${pageContext.request.contextPath}/catagoryAction_getCatagoriesAndDetails',
						postParam,
						function(data, status) {

							if (data.retcode == "0000") {
								var addHtml = "";
								var addHtml_ = "";
								var tmp = "";
								//显示层绑定控件

								$
										.each(
												data.obj,
												function(index, item) {
													if (index % 2 == 0) {
														addHtml += "<label class='w90 blueLabel'>"
																+ item.name
																+ ":</label>";
														addHtml += "<select name='rawMaterialList' tid='"+item.id+"'id='rawMaterialList"+item.id+"'class='form-control tool-select'>";
													} else {
														addHtml += "<label class='w90 blueLabel'>"
																+ item.name
																+ ":</label>";
														addHtml += "<select name='rawMaterialList' tid='"+item.id+"'id='rawMaterialList"+item.id+"'class='form-control tool-select'>";
													}

													addHtml_ += "<tr style='DISPLAY:none'><td>"
															+ item.name
															+ "</td><td colspan='3'>";
													addHtml_ += "<select name='rawMaterialList_modal' tid='"+item.id+"'id='rawMaterialList_modal"+item.id+"'>";
													tmp = "";
													tmp += "<option value=''>全部</option>";
													$
															.each(
																	item.catagoryDetails,
																	function(i,
																			detail) {
																		tmp += "<option value='"+detail.id+"' code='"+detail.code+"'>"
																				+ detail.name
																				+ "</option>";
																	});
													addHtml += tmp;
													addHtml_ += tmp;
													if (index % 2 == 0) {
														addHtml += "</select>";
													} else {
														addHtml += "</select>";
													}
													addHtml_ += "</select></td></tr>";
												});
								addHtml_ += "<tr><td>原辅料分类</td><td colspan='3'><input disabled='true' type='text' id='theselect'/></td></tr>";
								$("#selectArea").empty().append(addHtml)
										.trigger("create");
								$("#tmodal").before(addHtml_).trigger("create");
								makeselect(1);
							}
						});
		search();
	});
	
	function initUnitSelect(){
		initSelect($("#myModal #quantityUnit1"),
				"${pageContext.request.contextPath}/unitAction_getUnits", null,
				2, $("#myModal #quantityUnit1").val());
	}

	function search() {
		var aoColumns = [ {
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
			"mDataProp" : "specialManageType",
			"bSortable" : true
		}, {
			"mDataProp" : "status",
			"bSortable" : true
		} ];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/materialsAction_getMaterials",
			"delete" : "${pageContext.request.contextPath}/materialsAction_deleteMaterialDetail"
		};
		initTable("rawMaterialTable", aoColumns, ajaxSource);

	};

	function edit(tid,isView) {
		postParam = {
			Id : tid
		};

		$
				.getJSON(
						'${pageContext.request.contextPath}/materialsAction_getMaterialDetails',
						postParam,
						function(data, status) {
							if (data.retcode == "0000") {
								console.log(validityPeriodValue);
								$("#myModal #machineCode").val(data.obj.machineCode);
								$.each(data.obj.catagoryId, function(index,
										item) {
									$("select[name='rawMaterialList_modal']")
											.eq(index).val(item.id);
								});

								makeselect(2);
								//$("#rawMaterialList_modal").val(data.obj.)
								$(
										"input[name=isMiddle]:eq("
												+ data.obj.isMiddle + ")")
										.attr("checked", 'checked');
								$("#myModal #productName").val(data.obj.productId);
								$("#myModal #materialName").val(data.obj.name);
								$("#myModal #materialCode").val(data.obj.code);
								$("#myModal #materialCode").attr("disabled", true);
								$("#myModal #thecode").val(
										data.obj.catagoryCode + data.obj.code);
								$("#myModal #userDefinedCode").val(
										data.obj.userDefinedCode);
								$("#myModal #usedName").val(data.obj.usedName);

								$("#myModal #quantityUnit1").val(data.obj.quantityUnit1);
								changeQuantityUnit($("#myModal #quantityUnit1"));
								$("#myModal #preUnitCnvrsnFctr").val(
										data.obj.preUnitCnvrsnFctr);
								$("#myModal #quantityUnit2").val(data.obj.quantityUnit2);
								$("#myModal #unitCnvrsnFctr").val(
										data.obj.unitCnvrsnFctr);
								$("#myModal #baseQuantityUnit").val(
										data.obj.baseQuantityUnit);
								$("#myModal").find("input[name='specialManageType'][value='"+data.obj.specialManageType+"']")[0].checked = true;
								
								$("#myModal").find("input[name='validityManageType'][value='"+data.obj.validityManageType+"']")[0].checked = true;
								$("#myModal #validityPeriod").val(
										data.obj.validityPeriod);
								if(data.obj.validityManageType==1){
									check(2);
								}else{
									check(1);
								}
								$("#myModal #storageCondition").val(
										data.obj.storageCondition);
								$("#myModal #warmingDay").val(data.obj.warmingDay);
								$("#myModal #submit").attr("isAdd", "0");
								$("#tid").val(tid);
								$("#show").click();
							} else {
								alert(data.errorMsg);
							}
						});
		if(isView==1){
			$("#myModal #submit").attr('style',"display:none");
		}else{
			$("#myModal #submit").attr('style',"display:inline");
		}
	};
	function add() {
		isAdding = 1;
		var rawMaterialType = $("select[name='rawMaterialList']");
		var tmp = new Array();
		$.each(rawMaterialType, function(index, item) {
			tmp.push($(item).val());
		});
		postParam = {
			catagoryDetails : JSON.stringify(tmp)
		};
		$.ajax({
			type : "post",
			data:postParam,
			async: false,
			dataType : "json", //收受数据格式
			url : "${pageContext.request.contextPath}/materialsAction_getCurrentCode",
			cache : false,
			success : function(data) {
				if (data.retcode == "0000") {
					var code = (Array(codelength).join('0') + (Number(data.obj) + 1))
										.slice(-codelength);
					$("#materialCode").val(code);
				} else {
					alert(data.errorMsg);
				}
			}
		});
		makeselect(1);
		clearModal();
		isAdding = 0;
		$("#thecode").val(
				$("#classificationcode").val() + $("#materialCode").val());
		$("#thecode").attr("disabled", true);
		$.ajax({
			type : "post",
			dataType : "json", //收受数据格式
			url : "${pageContext.request.contextPath}/sysPropotyAction_getMachineCode",
			cache : false,
			success : function(data) {
				if (data.retcode == "0000") {
					$("#machineCode").val(data.obj);
				} else {
					alert(data.errorMsg);
				}
			}
		});
		$("#materialCode").attr("disabled", true);
		//$("#validityPeriod").attr("disabled", true);
		var code = $("#thecode").val();
		if (isNaN(code)) {
			alert("新增前，请选择原辅料种类！");
		} else {
			$("#show").click();
			$("#submit").attr("isAdd", "1");

		}
		$("#myModal #submit").attr('style',"display:inline");
	};

	function submit() {
		var rawMaterialType = $("select[name='rawMaterialList_modal']");
		var tmp = new Array();
		$.each(rawMaterialType, function(index, item) {
			tmp.push($(item).val());
		});
		var catagoryId = JSON.stringify(tmp);

		var catagoryCode = $("#myModal #classificationcode").val();
		var isMiddle = $("input[name='isMiddle']:checked").val();
		//var productId = $("#productId").val();
		var productId = "";
		var name = $("#myModal #materialName").val();
		if(name==null||name==""){
			alert("名称必须填写！");
			return null;
		}
		var code = $("#myModal #materialCode").val();
		var userDefinedCode = $("#myModal #userDefinedCode").val();
		var usedName = $("#myModal #usedName").val();

		var quantityUnit1 = $("#myModal #quantityUnit1").val();
		if(quantityUnit1==null||quantityUnit1==""){
			alert("数量单位必须填写！");
			return null;
		}
		var preUnitCnvrsnFctr = $("#myModal #preUnitCnvrsnFctr").val();
		var quantityUnit2 = $("#myModal #quantityUnit2").val();
		var unitCnvrsnFctr = $("#myModal #unitCnvrsnFctr").val();
		var baseQuantityUnit = $("#myModal #baseQuantityUnit").val();

		/* 	var toleranceRange = $("#toleranceRange").val();
		 var repeatWeightFormula = $("#repeatWeightFormula").val();
		 var supplementFormula = $("#supplementFormula").val(); */
		var specialManageType = $("input[name='specialManageType']:checked")
				.val();
		/* 	var minInventory = $("#minInventory").val();
		 var maxInventory = $("#maxInventory").val(); */
		var storageCondition = $("#myModal #storageCondition").val();
		var warmingDay = $("#myModal #warmingDay").val();
		var validityManageType=$("#myModal").find("input[name='validityManageType']:checked").val();
		//console.log(validityManageType); 
		var validityPeriod = $("#myModal #validityPeriod").val();
		if(validityManageType==1&&(validityPeriod==null||validityPeriod=="")){
			alert("有效期必须填写！");
			return null;
		}
		var machineCode=$("#myModal #machineCode").val();
		postParam = {
			code : code,
			catagoryCode : catagoryCode,
			catagoryId : catagoryId,
			isMiddle : isMiddle,
			productId : productId,
			name : name,
			userDefinedCode : userDefinedCode,
			usedName : usedName,
			quantityUnit1 : quantityUnit1,
			preUnitCnvrsnFctr : preUnitCnvrsnFctr,
			quantityUnit2 : quantityUnit2,
			unitCnvrsnFctr : unitCnvrsnFctr,
			baseQuantityUnit : baseQuantityUnit,
			specialManageType : specialManageType,
			storageCondition : storageCondition,
			warmingDay : warmingDay,
			validityManageType:validityManageType,
			validityPeriod : validityPeriod,
			machineCode : machineCode
		};
		var url;
		if ($("#submit").attr("isAdd") == "1") {
			url = '${pageContext.request.contextPath}/materialsAction_addMaterialDetail';
		} else {
			url = '${pageContext.request.contextPath}/materialsAction_updateMaterialDetail';
			postParam["Id"] = $("#tid").val();
		}

		$.ajax({
			type : "post",
			url : url,
			data : postParam,
			dataType : 'json',
			success : function(data) {
				if (data.retcode == "0000") {
					$("#myModal").modal("hide");
					search();
				} else {
					alert(data.errorMsg);
				}
			},

		});
	}

	function clearModal() {
		$("input[type=reset]").click();
		$("#materialName").val("");
		$("#machineCode").val("");
		$("#thecode").val("");
		$("#userDefinedCode").val("");
		$("#usedName").val("");
		$("#storageCondition").val("");
		$("#validityPeriod").val("");
		$("#warmingDay").val("");
		$("#validityPeriod").attr("disabled", false);
		$("#productId").val();
		$("#productName").val("");
		$("#myModal #quantityUnit1").val("");
		$("#preUnitCnvrsnFctr").val("");
		$("#quantityUnit2").val("");
		$("#unitCnvrsnFctr").val("");
		$("#baseQuantityUnit").val("");

		$("input[name=isMiddle]:eq(0)").attr("checked", 'checked');
		//$("input[name=specialManageType]:eq(0)").attr("checked", 'checked');
		$("#myModal").find("input[name='specialManageType'][value='0']")[0].checked = true;
		//$("input[name=validityManageType]:eq(1)").attr("checked", 'checked');
		$("#myModal").find("input[name='validityManageType'][value='1']")[0].checked = true;
		check(2);
		validityPeriodValue="";
	}
	function makeselect(tmp) {
		if (tmp == 1) {
			var L = $("select[name=rawMaterialList]");
			var tcode = "";
			var theselect = "";
			$.each(L, function(index, item) {
				var tid = $(item).attr("tid");
				$("#rawMaterialList_modal" + tid).val($(item).val());
				$("#rawMaterialList_modal" + tid).attr("disabled", true);
				var tmp = $(item).find("option");
				tmp.each(function(t, tt) {
					if ($(tt).attr("value") == $(item).val()) {
						tcode += $(tt).attr("code");
						theselect += $(tt).text() + "-";
					}
				});
			});
			$("#classificationcode").val(tcode);
			$("#theselect").val(theselect.substring(0, theselect.length - 1));
		} else {
			var L = $("select[name=rawMaterialList_modal]");
			var tcode = "";
			var theselect = "";
			$.each(L, function(index, item) {
				var tmp = $(item).find("option");

				tmp.each(function(t, tt) {
					if ($(tt).attr("value") == $(item).val()) {
						tcode += $(tt).attr("code");
						theselect += $(tt).text() + "-";
					}
				});
			});
			$("#classificationcode").val(tcode);
			$("#theselect").val(theselect.substring(0, theselect.length - 1));
		}
	}

	function changeQuantityUnit(obj) {
		initSelect(
				$("#myModal #quantityUnit2"),
				"${pageContext.request.contextPath}/unitAction_getQuantityUnit2ByQuantityUnit",
				{
					quantityUnitId : $(obj).val()
				}, 2, $(obj).val());
		initSelect(
				$("#myModal #baseQuantityUnit"),
				"${pageContext.request.contextPath}/unitAction_getBaseQuantityUnitByQuantityUnit",
				{
					quantityUnitId : $(obj).val()
				}, 2, null);
		if ($("#preUnitCnvrsnFctr").val() == null
				|| $("#preUnitCnvrsnFctr").val() == "") {
			$("#preUnitCnvrsnFctr").val(1);
		}
	}
	
	function changeRawMaterialStatus() {
		var curStatus = $("#rawMaterialStatus").val();
		if (curStatus == "0") {
			$("#rawMaterialStatus").val("1");
			$("#rawMaterial-switch").attr("src", "../image/invalid.png");
		} else if (curStatus == "1") {
			$("#rawMaterialStatus").val("2");
			$("#rawMaterial-switch").attr("src", "../image/checking.png");
		} else if (curStatus == "2") {
			$("#rawMaterialStatus").val("");
			$("#rawMaterial-switch").attr("src", "../image/all.png");
		} else if (curStatus == "") {
			$("#rawMaterialStatus").val("0");
			$("#rawMaterial-switch").attr("src", "../image/valid.png");
		}
	}
	
	function checkMaterial(id) {
		if (window.confirm('是否审核通过？')) {
		} else {
			return false;
		}
		$
				.ajax({
					type : "post",
					data : {
						"materialId" : id
					},
					dataType : "json", //收受数据格式
					url : "${pageContext.request.contextPath}/materialsAction_checkMaterial",
					cache : false,
					success : function(data) {
						if (data.retcode == "0000") {
							search();
						} else {
							alert(data.errorMsg);
						}
					}
				});
	}
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
	
	function beforeSelectRawMaterial(obj, item){
		$(obj).find("#rawMaterialViewButton").attr("onclick","edit("+item.id+",1)");
		$(obj).find("#rawMaterialEditButton").attr("onclick","edit("+item.id+")");
		$(obj).find("#rawMaterialCheckButton").attr("onclick","checkMaterial("+item.id+")");
		if (item.status != 2) {
			$(obj).find("#rawMaterialCheckButton").css("display", "none");
		}
	}
	/**************************单位表格的逻辑 开始**********************************/

	function check(type) {
		if (type == 1) {
			validityPeriodValue=$("#validityPeriod").val();
			$("#validityPeriod").val("");
			$("#validityPeriod").attr("disabled", true);
			$("#validityPeriodTd").html("有效期（月）");
		} else {
			if($("#validityPeriod").val()==""){
				$("#validityPeriod").val(validityPeriodValue);
			}
			$("#validityPeriod").attr("disabled", false);
			$("#validityPeriodTd").html("有效期（月）<span class='red'>*</span>");
		}
	}
	function searchProducts() {
		var aoColumns = [ {
			"mDataProp" : "code",
			"bSortable" : false
		}, {
			"mDataProp" : "name",
			"bSortable" : false
		} ];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/productAction_getProducts"
		};
		initTable("productTable", aoColumns, ajaxSource);
	}

	function selectProduct(obj) {
		$("#productId").val($(obj).find("#itemId").val());
		$("#productName").val($(obj).find("#name").html());
		$("#raw-edit").modal("hide");
	}

	function clearProduct() {
		$("#productId").val("");
		$("#productName").val("");
	}
</script>


