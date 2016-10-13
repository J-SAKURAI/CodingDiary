<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/MyComponent/MySelect.js"></script>
<link
	href="${pageContext.request.contextPath}/web/css/jquery.datetimepicker.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/jquery.datetimepicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/MyComponent/MyTable.js"></script>
<div style="width: 1024px">
	<div class="row breadcrumb-row">
		<ol class="breadcrumb">
			<li><a href="#">首页</a>
			</li>
			<li><a href="#">基础设施</a>
			</li>
			<li><a href="#">技术编码设置</a>
			</li>
			<li class="active">包装材料编码</li>
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
				id="pacMaterialStatus" value="0" type="hidden" /> <img
				onclick="changePackagingMaterialStatus()" src="../image/valid.png"
				alt="有效" class="btn-add btn-img" id="packagingMaterial-switch"> <img
				src="../image/print.png" alt="打印" class="btn-add btn-img">
			<div class="btn-add">
				<input id="keyword" type="text"><span
					style="font-size: 10px">关键字</span>
			</div>
			<span style="margin-left: 15px;">包装材料</span>
		</div>

		<table id="rawMaterialTable" class="table table-striped" beforeSelect="beforeSelectPacMaterial">
			<thead>
				<tr>
					<th class="w60">序号</th>
					<th class="w100"><a id="code">包装材料编码</a>
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
					<input id="pacMaterialStatus" type="hidden" sourceId="pacMaterialStatus" />
					<td><span id="index"></span></td>
					<td><span id="code"></span></td>
					<td class="text-left"><span id="name"></span></td>
					<td><span id="quantityUnit1"></span></td>
					<td><myspan id="specialManageType"
							params='{"0":"否","1":"是"}'></myspan></td>
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
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-productSameName">
				<div class="modal-content">
					<div class="modal-header"></div>
					<div class="modal-body">
						<ul class="nav nav-tabs tablist" role="tablist">
							<li role="presentation" class="active"><a href="#basicInfo"
								aria-controls="home" role="tab" data-toggle="tab">基本信息</a>
							</li>
							<li role="presentation"><a href="#other"
								aria-controls="profile" role="tab" data-toggle="tab">其他</a>
							</li>
						</ul>
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="basicInfo">
								<table class="table edit-table">
									<form id="defaultForm">

										<tr id="tmodal">
											<td>包装材料名称<span class="red">*</span>
											</td>
											<td colspan="3"><input type="text"
												id="packagingMaterialname"></td>
										</tr>
										<tr style="DISPLAY:none">
											<td>包装材料序数编码</td>
											<td><input type="text" id="packagingMaterialcode">
											</td>
											<td>分类编码</td>
											<td><input type="text" id="classificationcode"
												disabled="true">
											</td>
										</tr>
										<tr>
											<td>包装材料编码</td>
											<td><input type='text' id='thecode' />
											</td>
											<td>机器编码</td>
											<td><input id="machineCode" disabled="disabled"/></td>
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
											<td class="form-group"><span>数量单位</span><span
												class="red">*</span>
											</td>
											<td><select id="quantityUnit1" name="quantityUnit1"
												onchange="changeQuantityUnit(this)" class="w60">
											</select> <a class="btn-operation" onclick="openUnitTable()"><span
													class="glyphicon glyphicon-edit" aria-hidden="true"></span>
											</a></td>
											<td>转换系数</td>
											<td class="form-group"><input type="text" class="w40"
												id="preUnitCnvrsnFctr" name="preUnitCnvrsnFctr"> <select
												id="quantityUnit2" class="w40">
											</select> ＝ <input type="text" class="w40" id="unitCnvrsnFctr"
												name="unitCnvrsnFctr"> <select id="baseQuantityUnit"
												class="w40">
											</select> <a class="btn-operation" onclick="openBaseUnitTable()"><span
													class="glyphicon glyphicon-edit" aria-hidden="true"></span>
											</a>
											</td>
										</tr>

										<!--                                                 <tr>
                                                    <td>入库复称</td>
                                                    <td>
                                                        <label><input type="radio" name="" value=""/> 是</label> 
                                                        <label><input type="radio" name="" value=""/> 否</label>
                                                    </td>
                                                    <td>公差范围</td>
                                                    <td>±<input type="text" class="w100">％</td>
                                                </tr>
                                                <tr>
                                                    <td>入库复称公式</td>
                                                    <td colspan="3">
                                                        <textarea id="repeatWeightFormula" name="repeatWeightFormula" id="" rows="2"></textarea>
                                                        <a class="btn-operation" href="#" data-toggle="modal" data-target="#formula-edit"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                                    </td>
                                                </tr> -->
										<tr>
											<td>特殊管理</td>
											<td colspan="3"><label><input type="radio"
													name="specialManageType" value="0" />否</label> <label><input
													type="radio" name="specialManageType" value="1" />是</label></td>
										</tr>
										<input type="reset" name="reset" style="display: none;" /> <input
											type="text" id="tid" style="display: none;" />
									</form>
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
								</table>
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button id="submit" onclick="submit()" isAdd="1" type="button"
							class="btn btn-default">确定</button>
						<button type="button" id="cancel" class="btn btn-default"
							data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
		</div>
		<!--                     <div class="modal fade" id="sub-edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-productSameName">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <div class="modal-body">
                                    <a href="#" class="btn-add"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
                                    <table class="table sort-table table-striped">
                                        <thead>
                                            <tr>
                                                <th>序号</th>
                                                <th>数量单位</th>
                                                <th>操作</th>
                                            </tr>
                                       </thead>
                                       <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>2只</td>
                                                <td>
                                                    <a class="btn-operation"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                                    <a class="btn-operation"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>350</td>
                                                <td>
                                                    <a class="btn-operation" href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                                    <a class="btn-operation" href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td><input type="text" class="table-input"></td>
                                                <td>
                                                    <a class="btn-operation" href="#"><span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span></a>
                                                    <a class="btn-operation" href="#"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span></a>
                                                </td>
                                            </tr>
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
 -->
		<!-- <div class="modal fade" id="formula-edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-productSameName">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <div class="modal-body">
                                    <table class="table formula-symbol-table">
                                        <tbody>
                                            <tr>
                                                <td class="w40">参数</td>
                                                <td class="w80"></td>
                                                <td>
                                                    <a class="formula-btn">入库件数</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td rowspan="4">算数</td>
                                                <td>算数符</td>
                                                <td>
                                                    <a class="formula-btn">加(x+y)</a>
                                                    <a class="formula-btn">减(x-y)</a>
                                                    <a class="formula-btn">乘(x*y)</a>
                                                    <a class="formula-btn">除(x/y)</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>比较</td>
                                                <td>
                                                    <a class="formula-btn">等于</a>
                                                    <a class="formula-btn">小于(x<y)</a>
                                                    <a class="formula-btn">小于等于(x<=y)</a>
                                                    <a class="formula-btn">大于(x>y)</a>
                                                    <a class="formula-btn">大于等于(x>=y)</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>控制结构</td>
                                                <td>
                                                    <a class="formula-btn">如果 if(x){y}</a>
                                                    <a class="formula-btn">如果 if(x){y} else{z}</a>
                                                    <a class="formula-btn">如果多行</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>布尔值</td>
                                                <td>
                                                    <a class="formula-btn">与 x&&y</a>
                                                    <a class="formula-btn">或 x||y</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td rowspan="2">算数</td>
                                                <td>数学</td>
                                                <td>
                                                    <a class="formula-btn">绝对值 abs(x)</a>
                                                    <a class="formula-btn">取整(四舍五入) round(x)</a>
                                                    <a class="formula-btn">取整(大于等于x的最小整数) ceil(x)</a>
                                                    <a class="formula-btn">取整(小于等于x的最小整数) floor(x)</a>
                                                    <a class="formula-btn">平方根 sqrt(x)</a>
                                                    <a class="formula-btn">正弦值 sin(x)</a>
                                                    <a class="formula-btn">余弦值 sin(x)</a>
                                                    <a class="formula-btn">圆周率 PI</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>字符串</td>
                                                <td>
                                                    <a class="formula-btn">大写toUpperCase</a>
                                                    <a class="formula-btn">小写toLowerCase</a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <table class="formula-table">
                                        <tbody>
                                            <tr>
                                                <td class="w500">公式定义：</td>
                                                <td class="w300">公式说明：</td>
                                            </tr>
                                            <tr>
                                                <td><textarea name="" id="" rows="6"></textarea></td>
                                                <td><textarea name="" id="" rows="6"></textarea></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <div class="row formula-result">
                                        <table class="formula-result-table">
                                            <tbody>
                                                <tr>
                                                    <td class="w80">入库件数</td>
                                                    <td class="w150"><input type="text"></td>
                                                    <td class="w80">入库件数</td>
                                                    <td class="w230"><input type="text"></td>
                                                </tr>
                                                <tr>
                                                    <td>入库件数</td>
                                                    <td><input type="text"></td>
                                                    <td>结果值</td>
                                                    <td><input type="text"></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <div class="formula-result-right">
                                            <td><button type="button" class="btn btn-default">验证</button></td>
                                            <td class="w60">结果:</td>
                                            <td class="w150">正确</td>
                                        </div>
                                    </div>
                                    
                                </div>
                                <div class="modal-footer">
									<button id="submit" onclick="submit()" isAdd="1" type="button" class="btn btn-default" data-dismiss="modal">确定</button>
						            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                </div>
                            </div>
                        </div>
                    </div>
 -->
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
									<td><span id="index"></span></td>
									<td><span id="name"></span></td>
									<td><a class="btn-operation" onclick="editItem(this)"><span
											class="glyphicon glyphicon-edit" aria-hidden="true"></span> </a>
										<a class="btn-operation" onclick="deleteItem(this)"><span
											class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</a>
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
									</a>
									</td>
								</tr>
								<tr id="editTemplete" style="display:none">
									<td><span id="index"></span></td>
									<td><input id="name" type="text" class="table-input">
									</td>
									<td><a class="btn-operation" onclick="submitEdit(this)"><span
											class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
									</a> <a class="btn-operation" onclick="cancelEdit(this)"><span
											class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
									</a>
									</td>
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



	<div class="modal fade" id="history" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-productSameName">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
				</div>
				<div class="modal-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="w60">序号</th>
								<th class="w80">操作人</th>
								<th class="w150">操作时间</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>XXX</td>
								<td>2004-12-24 10:11:08</td>
							</tr>
							<tr>
								<td>1</td>
								<td>XXX</td>
								<td>2004-12-24 10:11:08</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
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
	$(function() {
		$("#warmingDay").datetimepicker({
			yearOffset : 0,
			lang : 'ch',
			timepicker : false,
			format : 'd/m/Y',
			formatDate : 'Y/m/d',

		});
		initSelect($("#myModal #quantityUnit1"),
				"${pageContext.request.contextPath}/unitAction_getUnits", null,
				2, null);
		postParam = {
			"type" : 3
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
								addHtml_ += "<tr><td>包装材料分类</td><td colspan='3'><input disabled='true' type='text' id='theselect'/></td></tr>";
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
			"select" : "${pageContext.request.contextPath}/wrapperAction_getWrappers",
			"delete" : "${pageContext.request.contextPath}/wrapperAction_deleteWrapperDetail"
		};
		initTable("rawMaterialTable", aoColumns, ajaxSource);
	}
	
	function beforeSelectPacMaterial(obj, item){
		$(obj).find("#rawMaterialViewButton").attr("onclick","edit("+item.id+",1)");
		$(obj).find("#rawMaterialEditButton").attr("onclick","edit("+item.id+")");
		$(obj).find("#rawMaterialCheckButton").attr("onclick","checkPackagingMaterial("+item.id+")");
		if (item.status != 2) {
			$(obj).find("#rawMaterialCheckButton").css("display", "none");
		}
	}

	function edit(tid,isView) {
		postParam = {
			Id : tid
		};

		$
				.getJSON(
						'${pageContext.request.contextPath}/wrapperAction_getWrapperDetails',
						postParam,
						function(data, status) {
							if (data.retcode == "0000") {
								/* var tmp = (("0000000000000000" + data.obj.id)
										.substr(-8)).toString(); */

								$.each(data.obj.catagoryId, function(index,
										item) {
									$("select[name='rawMaterialList_modal']")
											.eq(index).val(item.id);
								});

								makeselect(2);

								$("#machineCode").val(data.obj.machineCode);
								$("#packagingMaterialcode").val(data.obj.code);
								$("#packagingMaterialcode").attr("disabled",
										true);
								$("#packagingMaterialname").val(data.obj.name);
								$("#thecode").val(
										data.obj.catagoryCode + data.obj.code);
								$("#thecode").attr("disabled", true);
								$("#userDefinedCode").val(
										data.obj.userDefinedCode);
								$("#usedName").val(data.obj.usedName);

								$("#myModal #quantityUnit1").val(data.obj.quantityUnit1);
								changeQuantityUnit($("#quantityUnit1"));
								$("#preUnitCnvrsnFctr").val(
										data.obj.preUnitCnvrsnFctr);
								$("#quantityUnit2").val(data.obj.quantityUnit2);
								$("#unitCnvrsnFctr").val(
										data.obj.unitCnvrsnFctr);
								$("#baseQuantityUnit").val(
										data.obj.baseQuantityUnit);

								$(
										"input[name=specialManageType]:eq("
												+ data.obj.specialManageType
												+ ")").attr("checked",
										'checked');

								$("#submit").attr("isAdd", "0");
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
			url : "${pageContext.request.contextPath}/wrapperAction_getCurrentCode",
			cache : false,
			success : function(data) {
				if (data.retcode == "0000") {
					var code = (Array(codelength).join('0') + (Number(data.obj) + 1))
										.slice(-codelength);
					console.log(code);
					$("#packagingMaterialcode").val(code);
				} else {
					alert(data.errorMsg);
				}
			}
		});
		makeselect(1);
		clearModal();
		isAdding = 0;
		$("#packagingMaterialcode").attr("disabled", true);
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
		$("#thecode").val(
				$("#classificationcode").val()
						+ $("#packagingMaterialcode").val());
		$("#thecode").attr("disabled", true);
		var code = $("#thecode").val();
		if (isNaN(code)) {
			alert("新增前，请选择包装材料种类！");
		} else {
			$("#submit").attr("isAdd", "1");
			$("#show").click();
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

		var catagoryCode = $("#classificationcode").val();

		var name = $("#packagingMaterialname").val();
		if(name==null||name==""){
			alert("名称必须填写！");
			return null;
		}
		var userDefinedCode = $("#userDefinedCode").val();
		var packagingMaterialcode = $("#packagingMaterialcode").val();
		var usedName = $("#usedName").val();

		var quantityUnit1 = $("#myModal #quantityUnit1").val();
		if(quantityUnit1==null||quantityUnit1==""){
			alert("数量单位必须填写！");
			return null;
		}
		var preUnitCnvrsnFctr = $("#preUnitCnvrsnFctr").val();
		var quantityUnit2 = $("#quantityUnit2").val();
		var unitCnvrsnFctr = $("#unitCnvrsnFctr").val();
		var baseQuantityUnit = $("#baseQuantityUnit").val();

		var specialManageType = $("input[name='specialManageType']:checked")
				.val();
		var machineCode=$("#machineCode").val();
		postParam = {

			catagoryCode : catagoryCode,
			catagoryId : catagoryId,
			code : packagingMaterialcode,
			name : name,
			userDefinedCode : userDefinedCode,
			usedName : usedName,
			quantityUnit1 : quantityUnit1,
			preUnitCnvrsnFctr : preUnitCnvrsnFctr,
			quantityUnit2 : quantityUnit2,
			unitCnvrsnFctr : unitCnvrsnFctr,
			baseQuantityUnit : baseQuantityUnit,
			specialManageType : specialManageType,
			machineCode : machineCode
		};
		var url;
		if ($("#submit").attr("isAdd") == "1") {
			url = '${pageContext.request.contextPath}/wrapperAction_addWrapperDetail';
		} else {
			url = '${pageContext.request.contextPath}/wrapperAction_updateWrapperDetail';
			postParam["Id"] = $("#tid").val();
		}

		$.ajax({
			type : "post",
			url : url,
			data : postParam,
			dataType : 'json',
			success : function(data) {
				if (data.retcode == "0000") {
					search();
					$("#cancel").click();
				} else {
					alert(data.errorMsg);
				}
			},

		});
	}

	function clearModal() {
		$("input[type=reset]").click();
		$("#thecode").val("");
		$("#packagingMaterialname").val("");
		$("#userDefinedCode").val("");
		$("#usedName").val("");
		$("#myModal #quantityUnit1").val("");
		$("#preUnitCnvrsnFctr").val("");
		$("#quantityUnit2").val("");
		$("#unitCnvrsnFctr").val("");
		$("#baseQuantityUnit").val("");
		$("input[name=specialManageType]:eq(0)").attr("checked", 'checked');

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
	
	function changePackagingMaterialStatus() {
		var curStatus = $("#pacMaterialStatus").val();
		if (curStatus == "0") {
			$("#pacMaterialStatus").val("1");
			$("#packagingMaterial-switch").attr("src", "../image/invalid.png");
		} else if (curStatus == "1") {
			$("#pacMaterialStatus").val("2");
			$("#packagingMaterial-switch").attr("src", "../image/checking.png");
		} else if (curStatus == "2") {
			$("#pacMaterialStatus").val("");
			$("#packagingMaterial-switch").attr("src", "../image/all.png");
		} else if (curStatus == "") {
			$("#pacMaterialStatus").val("0");
			$("#packagingMaterial-switch").attr("src", "../image/valid.png");
		}
	}
	
	function checkPackagingMaterial(id) {
		if (window.confirm('是否审核通过？')) {
		} else {
			return false;
		}
		$
				.ajax({
					type : "post",
					data : {
						"wrapperId" : id
					},
					dataType : "json", //收受数据格式
					url : "${pageContext.request.contextPath}/wrapperAction_checkWrapper",
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
	/**************************单位表格的逻辑 开始**********************************/
</script>
</html>
