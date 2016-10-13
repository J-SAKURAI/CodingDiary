<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		
    	<link rel="stylesheet" href="../../jqcool.net-bootstrapvalidator/dist/css/bootstrapValidator.css"/>
    	
    	<script type="text/javascript" src="../../jqcool.net-bootstrapvalidator/dist/js/bootstrapValidator.js"></script>
        <title>产品编码</title>
    </head>
<body>
            <div class="modal-dialog modal-productSameName">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <form id="defaultForm" method="post" class="form-horizontal">
                                <div class="modal-body">
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
                                                <label><input type="radio" name="midbody" value="1"/>是</label>
                                                <label><input type="radio" name="midbody" value="0" checked="checked"/> 否</label>
                                            </td>
                                            <td>对应原辅料</td>
                                            <td><input type="text"></td>
                                        </tr>
                                        <tr>
                                            <td>产品名称<span class="red">*</span></td>
                                            <td class="form-group">
							                        <input type="text" name="username" />
								               
								            </td>
                                            <td>规格<span class="red">*</span></td>
                                            <td><input type="text" id="specification"></td>
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
                                            <td>
                                            	<span>数量单位</span><span class="red">*</span>
                                                <select id="quantityUnit" class="w60">
                                                    <option value="">片</option>
                                                </select>
                                                <a class="btn-operation" href="#" data-toggle="modal" data-target="#sub-edit"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                            </td>
                                            <td>单位转换系数</td>
                                            <td><span>片</span>＝<input type="text" class="w60" id="unitCnvrsnFctr" >
                                                <select id="baseQuantityUnit" class="w60">
                                                    <option value="">片</option>
                                                </select>
                                                <a class="btn-operation" href="#" data-toggle="modal" data-target="#sub-edit"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
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
                                            <td><input type="text" id="validityPeriod"></td>
                                            <td>有效期预警(日)</td>
                                            <td><input type="text" id="warmingDay"></td>
                                        </tr>
                                        <tr>
                                            <td>成本核算方法</td>
                                            <td>
                                                <select id="">
                                                    <option value="">默认</option>
                                                </select>
                                            </td>
                                            <td>成本核算对象</td>
                                            <td>
                                                <select id="">
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
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-default btn-primary">确定
                                    </button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消
                                    </button>
                                </div>
                                </form>
                            </div>
                        </div>


</body>
</html>
<script type="text/javascript">
$(document).ready(function() {
    $('#defaultForm')
        .bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                username: {
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The username is required and can\'t be empty'
                        }
                    }
                }
            }
        })
        .on('success.form.bv', function(e) {
            // Prevent form submission
           /*  e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                alert(1);
            }, 'json'); */
        });
});
</script>