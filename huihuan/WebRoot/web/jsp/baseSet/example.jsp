<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="../../script/jquery.min.js"></script>
        <script type="text/javascript" src="../../script/bootstrap.min.js"></script>
        <script type="text/javascript" src="../../script/BootSideMenu.js"></script>
        <link rel="stylesheet" href="../../fonts/glyphicons-halflings-regular.eot">
        <link rel="stylesheet" href="../../fonts/glyphicons-halflings-regular.svg">
        <link rel="stylesheet" href="../../fonts/glyphicons-halflings-regular.ttf">
        <link rel="stylesheet" href="../../fonts/glyphicons-halflings-regular.woff">
        <link rel="stylesheet" href="../../fonts/glyphicons-halflings-regular.woff2">
        <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="../../css/site.css" rel="stylesheet" type="text/css">
        <link href="../../css/style.css" rel="stylesheet" type="text/css">
        <link href="../../css/color.css" rel="stylesheet" type="text/css">
        
		<script type="text/javascript" src="../../script/MyComponent/MyTable.js"></script>
		<script type="text/javascript" src="../../script/MyComponent/MySelect.js"></script>
		
    	<link rel="stylesheet" href="../../jqcool.net-bootstrapvalidator/dist/css/bootstrapValidator.css"/>
    	
    	<script type="text/javascript" src="../../jqcool.net-bootstrapvalidator/dist/js/bootstrapValidator.js"></script>
        <title>产品编码</title>
    </head>
    <body>

        <div class="header" id="header">
            <div class="header-info text-right">
                <a href=""><span class="glyphicon glyphicon-user" aria-hidden="true"></span>管理员</a>
                <a href=""><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>信息</a>
                <a href=""><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>帮助</a>
                <a href=""><span class="glyphicon glyphicon-off" aria-hidden="true"></span>退出</a>
            </div>
            <div class="header-title">
                <img src="../../image/logo.jpg" alt="logo" class="logo">
                <h2>汇环医药生产经营管理系统</h2>
            </div>
            <div class="header-nav">
                <ul class="nav nav-tabs">
                    <li><a href="#">底层管理</a></li>
                    <li class="active"><a href="#">基础设施</a></li>
                    <li><a href="#">人力资源</a></li>
                    <li><a href="#">企业运行计划</a></li>
                    <li><a href="#">采购管理</a></li>
                    <li><a href="#">仓储管理</a></li>
                    <li><a href="#">车间管理</a></li>
                    <li><a href="#">质量管理</a></li>
                    <li><a href="#">销售管理</a></li>
                    <li><a href="#">财务管理</a></li>
                    <li><a href="#">设备管理</a></li>
                    <li><a href="#">权限管理</a></li>
                </ul>
            </div>
        </div>

        <div class="main">
            <div class="main-left" id="main-left">
                <div class="panel panel-default panel-sub-tabs">
                    <div class="panel-heading">
                        <span class="panel-title">基础设施</span>
                    </div>
                    <div class="panel-body">
                        <ul class="sub-tabs">
                           <li><a href="#"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span> 技术编码设置</a></li>
                           <li class="sub-li"><a href="#">分类编码设置</a></li>
                           <li><a href="#"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span> 系统分级设置</a></li>
                           <li class="sub-li"><a href="#">编码设置</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        

            <div class="main-right" id="main-right">
                <img src="../../image/HideToolBar.png" alt="隐藏目录" id="hideTool">

                <div class="row wrapper">
                    <div class="set-row">
                        <div class="row-section">
                            <label for="keyword">关键字：</label>
                            <input type="text" class="form-control" id="keyword">
                        </div>
                        <div class="row-section">
                            <label for="status">状态：</label>
                            <select id="productStatus" class="form-control">
                                <option value="">全部</option>
                                <option value="0">有效</option>
                                <option value="1">无效</option>
                                <option value="2">审核中</option>
                            </select>
                        </div>
                        <div class="row-section">
                            <button onclick="initProductTable()" class="btn btn-default">查询</button>
                            <button class="btn btn-default">打印</button>
                        </div>
                    </div>
                </div>

                <div class="row wrapper">
                    <div class="row button-row">
                        <a class="btn-add"  onclick="addProductTableItem(this)" target="edit"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
                    </div>
                    
                    <table id="productTable" class="table table-striped" beforeInsert="beforeInsertProduct">
                        <thead>
                            <tr>
                                <th class="w60">序号</th>
                                <th class="w100">产品编码</th>
                                <th class="w100">名称</th>
                                <th class="w80">数量单位</th>
                                <th class="w80">特殊管理</th>
                                <th class="w80">状态</th>
                                <th class="w60">历史记录</th>
                                <th class="w100">操作</th>
                            </tr>
                            <tr id="selectTemplete" style="display:none">
								<input id="keyword" type="hidden" sourceId="keyword"/>
								<input id="productStatus" type="hidden" sourceId="productStatus"/>
                                <td><span id="index"></span></td>
                                <td><span id="code"></span></td>
                                <td><span id="name"></span></td>
                                <td><span id="quantityUnit"></span></td>
                                <td><myspan id="specialManageType" params='{"0":"否","1":"麻醉药品","2":"一类精神药品","3":"二类精神药品"}'></myspan></td>
                                <td><myspan id="status" params='{"0":"有效","1":"无效","2":"审核中"}'></myspan></td>
                                <td><span class="glyphicon glyphicon-open-file file-btn" aria-hidden="true"></td>
                                <td>
                                    <a class="btn-operation" onclick="editItem(this,'edit')"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                    <a class="btn-operation" onclick="deleteItem(this)"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                        </thead>
                        <tbody id="dataTbody">
                        </tbody>
                    </table>

                    <div class="table-page" paging-table="productTable" page-size="10">
                    </div>

                    <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" tableid="productTable">
                    	<input id="sameCatagoryId" type="hidden"/>
                        <div class="modal-dialog modal-productSameName">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <form id="defaultForm" method="post" class="form-horizontal">
	                                <div class="modal-body">
	                                	<ul class="nav nav-tabs tablist" role="tablist">
	                                        <li role="presentation" class="active"><a href="#basicInfo" aria-controls="home" role="tab" data-toggle="tab">基本信息</a></li>
	                                        <li role="presentation"><a href="#other" aria-controls="profile" role="tab" data-toggle="tab">其他&nbsp;&nbsp;</a></li>
	                                    </ul>
	                                    <div class="tab-content">
	                                        <div role="tabpanel" class="tab-pane active" id="basicInfo">
												<table class="table edit-table">
			                                        <tr>
			                                            <td class="w150">同名类别名</td>
			                                            <td class="w230"><span id="sameCatagoryName"></span></td>
			                                            <td class="w150">同名类别编码</td>
			                                            <td class="w230"><span id="sameCatagoryCode"></span></td>
			                                        </tr>
			                                        <tr>
			                                            <td>中间体</td>
			                                            <td>
			                                                <label><input type="radio" name="isMiddle" value="1"/>是</label>
			                                                <label><input type="radio" name="isMiddle" value="0" checked="checked"/> 否</label>
			                                            </td>
			                                            <td>对应原辅料</td>
			                                            <td><input type="text"></td>
			                                        </tr>
			                                        <tr>
			                                            <td>产品名称<span class="red">*</span></td>
			                                            <td class="form-group"><input type="text" id="name" name="name" disabled="disabled"></td>
			                                            <td>规格<span class="red">*</span></td>
			                                            <td class="form-group"><input type="text" id="specification" name="specification" onblur="setProductName(this)"></td>
			                                        </tr>
			                                        <tr>
			                                            <td>分类编码</td>
			                                            <td><span id="catagoryCode"></span><input id="code" type="hidden"/></td>
			                                            <td>机器编码</td>
			                                            <td><span id="machineCode"></span></td>
			                                        </tr>
			                                        <tr>
			                                            <td>自定义编码</td>
			                                            <td><input type="text" id="userDefinedCode"></td>
			                                            <td>曾用名</td>
			                                            <td><input type="text" id="usedName"></td>
			                                        </tr>
			                                        <tr>
			                                            <td>产品代号</td>
			                                            <td><input type="text" id="codeName"></td>
			                                            <td></td>
			                                            <td></td>
			                                        </tr>
			                                        <tr>
			                                            <td>
			                                            	<span>生产倍数</span>
			                                            	<select id="productUnit" class="w60">
			                                                    <option value="万">万</option>
			                                                    <option value="千">千</option>
			                                                    <option value="百">百</option>
			                                                    <option value="十">十</option>
			                                                    <option value="个">个</option>
			                                                    <option value="K">K</option>
			                                                </select>
			                                            </td>
			                                            <td class="form-group">
			                                            	<span>数量单位</span><span class="red">*</span>
			                                                <select id="quantityUnit" name="quantityUnit" onchange="changeQuantityUnit(this)" class="w60">
			                                                </select>
			                                                <a class="btn-operation" onclick="openUnitTable()"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
			                                            </td>
			                                            <td>单位转换系数</td>
			                                            <td><span id="quantityUnitName"></span>＝<input type="text" class="w60" id="unitCnvrsnFctr" >
			                                                <select id="baseQuantityUnit" class="w60">
			                                                    <option value="">克</option>
			                                                </select>
			                                                <a class="btn-operation" onclick="openBaseUnitTable()"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
			                                            </td>
			                                        </tr>
			                                        <tr>
			                                            <td>批准文号</td>
			                                            <td><input type="text" id="approvalNumber"></td>
			                                            <td>批准文号有效期至</td>
			                                            <td><input type="text" id="approvalNumberValidDate"></td>
			                                        </tr>
			                                        <tr>
			                                            <td>特殊管理</td>
			                                            <td colspan="3">
			                                                <label><input type="radio" name="specialManageType" value="0" checked="checked"/> 否</label>
			                                                <label><input type="radio" name="specialManageType" value="1"/> 麻醉药品</label>
			                                                <label><input type="radio" name="specialManageType" value="2"/> 一类精神药品</label>
			                                                <label><input type="radio" name="specialManageType" value="3"/> 二类精神药品</label>
			                                            </td>
			                                        </tr> 
			                                        <tr>
			                                            <td>存储条件</td>
			                                            <td colspan="3"><input type="text" id="storageCondition"></td>
			                                        </tr> 
			                                        <tr>
			                                            <td>有效期(月)<span class="red">*</span></td>
			                                            <td class="form-group"><input type="text" id="validityPeriod" name="validityPeriod"></td>
			                                            <td>有效期预警(日)</td>
			                                            <td><input type="text" id="warmingDay"></td>
			                                        </tr>
			                                    </table>
	                                        </div>
	                                        <div role="tabpanel" class="tab-pane" id="other">
												<table class="table edit-table">
	                                                <tr>
	                                                    <td>成本核算方法</td>
	                                                    <td>
	                                                        <select name="" id="">
	                                                            <option value="">默认</option>
	                                                        </select>
	                                                    </td>
	                                                    <td>成本核算对象</td>
	                                                    <td>
	                                                        <select name="" id="">
	                                                            <option value="">默认</option>
	                                                        </select>
	                                                    </td>
	                                                </tr>
	                                                <tr>
	                                                    <td>是否销售</td>
	                                                    <td><input type="checkbox"></td>
	                                                    <td>是否检验</td>
	                                                    <td><input type="checkbox"></td>
	                                                </tr>
	                                                <tr>
	                                                    <td>是否检验批准</td>
	                                                    <td><input type="checkbox"></td>
	                                                    <td>是否放行</td>
	                                                    <td><input type="checkbox"></td>
	                                                </tr>
	                                            </table>
	                                        </div>
	                                    </div>
	                                    
	                                </div>
	                                <div class="modal-footer">
	                                    <button type="submit" class="btn btn-default">确定
	                                    </button>
	                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消
	                                    </button>
	                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    
                    <div class="modal fade" id="sub-edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-productSameName">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <div class="modal-body">
                                    <a class="btn-add" onclick="addItem(unitTable)"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
                                    <input type="hidden" id="unitType"/>
                                    <table id="unitTable" class="table sort-table table-striped" afterInsert="initUnitSelect" afterDelete="initUnitSelect" afterEdit="initUnitSelect">
                                        <thead>
                                            <tr>
                                                <th>序号</th>
                                                <th>数量单位</th>
                                                <th>操作</th>
                                            </tr>
                                            <tr id="selectTemplete" style="display:none">
												<input id="type" type="hidden" sourceId="unitType"/>
												<input id="mlCd" type="hidden" value="1"/>
                                                <td><span id="index"></span></td>
                                                <td><span id="value"></span></td>
                                                <td>
                                                    <a class="btn-operation" onclick="editItem(this)"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                                    <a class="btn-operation" onclick="deleteItem(this)"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                                </td>
                                            </tr>
                                            <tr id="insertTemplete" style="display:none">
												<input id="type" type="hidden" sourceId="unitType"/>
												<input id="mlCd" type="hidden" value="1"/>
                                                <td></td>
                                                <td><input id="value" type="text" class="table-input"></td>
                                                <td>
                                                    <a class="btn-operation" onclick="submitAdd(this)" ><span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span></a>
                                                    <a class="btn-operation" onclick="cancleAdd(this)"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span></a>
                                                </td>
                                            </tr>
                                            <tr id="editTemplete" style="display:none">
                                                <td><span id="index"></span></td>
                                                <td><input id="value" type="text" class="table-input"></td>
                                                <td>
                                                    <a class="btn-operation" onclick="submitEdit(this)"><span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span></a>
                                                    <a class="btn-operation" onclick="cancelEdit(this)"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span></a>
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
            </div>
        </div>
    </body>
</html>


<script type="text/javascript">
	var sameCatagoryLength=0;
	var catagoryCode="";
	$(function() {
		initUnitSelect();
	});
	/**************************产品表格的逻辑 开始**********************************/
	
	var productLength=0;
	var preProductCode="";
	function initProductTable(){
		var aoColumns =[
	            	{ "mDataProp":"sameCatagoryName"},
	            	{ "mDataProp":"sameCatagoryCode"},
	            	{ "mDataProp":"catagoryCode"},
	            	{ "mDataProp":"code"},
	            	{ "mDataProp":"name"},
	            	{ "mDataProp":"quantityUnit"},
	            	{ "mDataProp":"specialManageType"},
	            	{ "mDataProp":"status"},
	            	{ "mDataProp":"isMiddle"},
	            	{ "mDataProp":"specification"},
	            	{ "mDataProp":"machineCode"},
	            	{ "mDataProp":"userDefinedCode"},
	            	{ "mDataProp":"usedName"},
	            	{ "mDataProp":"codeName"},
	            	{ "mDataProp":"productUnit"},
	            	{ "mDataProp":"unitCnvrsnFctr"},
	            	{ "mDataProp":"baseQuantityUnit"},
	            	{ "mDataProp":"approvalNumber"},
	            	{ "mDataProp":"approvalNumberValidDate"},
	            	{ "mDataProp":"storageCondition"},
	            	{ "mDataProp":"validityPeriod"},
	            	{ "mDataProp":"warmingDay"}
	    		 ];
		var ajaxSource = {
			"get" : "${pageContext.request.contextPath}/productAction_getProduct",
			"select" : "${pageContext.request.contextPath}/productAction_getProducts",
			"add" : "${pageContext.request.contextPath}/productAction_addProduct",
			"delete" : "${pageContext.request.contextPath}/productAction_deleteProduct",
			"edit" : "${pageContext.request.contextPath}/productAction_editProduct"
		};
		var sameCatagoryIds=new Array();
		$.each($("input[name='selectCheckbox']"), function(index, item) {
			var status=$(item).prop("checked");
			if(status==true){
				var id=$(item).parents("tr").find("#itemId").val();
				sameCatagoryIds[index]=id;
			}
		});
		$("#sameCatagoryIds").val(JSON.stringify(sameCatagoryIds));
		initTable("productTable",aoColumns,ajaxSource);
	}
	
	function addProductTableItem(obj){
		var selectCount=0;
		$.each($("#sameCatagoryTable #dataTbody input[name='selectCheckbox']"), function(index, item) {
			if($(item).prop("checked")==true){
				selectCount++;
			}
		});
		if(selectCount!=1){
			alert("必须选中一个同名类别才能增加产品！");
		}else{
			addItem(productTable,$(obj).attr('target'));
		}
	}
	
	function beforeInsertProduct(div){
		$.each($("#sameCatagoryTable #dataTbody input[name='selectCheckbox']"), function(index, item) {
			if($(item).prop("checked")==true){
				var smcode=$(item).parents("tr").find("#code").html();
				var smname=$(item).parents("tr").find("#name").html();
				var smid=$(item).parents("tr").find("#itemId").val();
				$(div).find("#sameCatagoryId").val(smid);
				$(div).find("#sameCatagoryCode").html(smcode);
				$(div).find("#sameCatagoryName").html(smname);
				$(div).find("#name").val(smname);
				getProductLengthAndPreCode(div,smid,smcode);
			}
		});
	}
	
	function getProductLengthAndPreCode(div,smid,smcode){
		$.ajax({
			type: "post",
			data:{"sameCatagoryId":smid},
			dataType:"json", //收受数据格式
			url:"${pageContext.request.contextPath}/productAction_getProductLengthAndPreCode",
			cache:false,
			success: function(data){
				if(data.retcode=="0000"){
					productLength=Number(data.obj.productLength);
					preProductCode=data.obj.preProductCode+"";
					if(preProductCode!=""){
						var code=(Array(productLength).join('0') + (Number(preProductCode)+1)).slice(-productLength);
						$(div).find("#code").val(code);
						$(div).find("#catagoryCode").html(smcode+code);
					}else{
						var code=(Array(productLength).join('0') + 0).slice(-productLength);
						$(div).find("#code").val(code);
						$(div).find("#catagoryCode").html(smcode+code);
					}
				}
			}
		});
	}
	
	function setProductName(obj){
		var name=$("#edit").find("#sameCatagoryName").html();
		$("#edit").find("#name").val(name+" "+$(obj).val());
	}
	
	function initUnitSelect(){
		initSelect(
			$("#edit #quantityUnit"),
			"${pageContext.request.contextPath}/constAction_getUnits",
			{"type":"QUANTITY_UNIT"},
			2,
			null
		);
		initSelect(
			$("#edit #baseQuantityUnit"),
			"${pageContext.request.contextPath}/constAction_getUnits",
			{"type":"BASE_QUANTITY_UNIT"},
			2,
			null
		);
	}
	
	function changeQuantityUnit(obj){
		$("#quantityUnitName").html($(obj).val());
	}
	/**************************产品表格的逻辑 结束**********************************/
	
	
	/**************************单位表格的逻辑 开始**********************************/
	function openUnitTable(){
		$("#unitType").val("QUANTITY_UNIT");
		initUnitTable();
		$("#sub-edit").modal("show");
	}
	
	function openBaseUnitTable(){
		$("#unitType").val("BASE_QUANTITY_UNIT");
		initUnitTable();
		$("#sub-edit").modal("show");
	}
	
	function initUnitTable(){
		var aoColumns =[
	            	{ "mDataProp":"value"}, 							//级名称
	            	{ "mDataProp":"type"}
	    		 ];
		var ajaxSource = {
			"get" : "${pageContext.request.contextPath}/constAction_getConst",
			"select" : "${pageContext.request.contextPath}/constAction_getConsts",
			"add" : "${pageContext.request.contextPath}/constAction_addConst",
			"delete" : "${pageContext.request.contextPath}/constAction_deleteConst",
			"edit" : "${pageContext.request.contextPath}/constAction_editConst"
		};
		initTable("unitTable",aoColumns,ajaxSource);
	}
	/**************************单位表格的逻辑 开始**********************************/
	
	
	$(document).ready(function() {
	    $('#defaultForm')
	        .bootstrapValidator({
	            excluded: [':disabled'],
	            feedbackIcons: {
	                valid: 'glyphicon glyphicon-ok',
	                invalid: 'glyphicon glyphicon-remove',
	                validating: 'glyphicon glyphicon-refresh'
	            },
	            fields: {
	                name: {
	                    message: 'The username is not valid',
	                    validators: {
	                        notEmpty: {
	                            message: '产品名必填！'
	                        }
	                    }
	                },
	                specification: {
	                    message: 'The username is not valid',
	                    validators: {
	                        notEmpty: {
	                            message: '产品规格必填！'
	                        }
	                    }
	                },
	                quantityUnit: {
	                    message: 'The username is not valid',
	                    validators: {
	                        notEmpty: {
	                            message: '数量单位必填！'
	                        }
	                    }
	                },
	                validityPeriod: {
	                    message: 'The username is not valid',
	                    validators: {
	                        notEmpty: {
	                            message: '有效期必填！'
	                        },regexp: {
	                            regexp: /^\+?[1-9][0-9]*$/,
	                            message: '有效期必须为正整数！'
	                        }
	                    }
	                }
	            }
	        })
	        .on('success.form.bv', function(e) {
	        	e.preventDefault();
	            submitAdd(null,'edit');
	            $(e.target)
                .bootstrapValidator('disableSubmitButtons', false)  // Enable the submit buttons
                .bootstrapValidator('resetForm', true);             // Reset the form
	        });
	});
</script>