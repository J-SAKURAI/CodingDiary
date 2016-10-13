   发<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/MyComponent/MySelect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/MyComponent/MyTable.js"></script>
        
        <script type="text/javascript">
            $(document).ready(function(){
                $(".display-btn").click(function () {
                    $(this).parent().parent().next().toggle();
                });
            });
        </script>
                <div class="row breadcrumb-row">
                    <ol class="breadcrumb">
                        <li><a href="#">首页</a></li>
                        <li><a href="#">基础设施</a></li>
                        <li><a href="#">技术标准设置</a></li>
                        <li class="active">产品配方</li>
                    </ol>
                </div>

                <ul class="nav nav-tabs tablist" role="tablist">
                    <li role="presentation" class="active"><a href="#product" aria-controls="home" role="tab" data-toggle="tab">产品配方</a></li>
                    <li role="presentation"><a href="#prefabricate" aria-controls="profile" role="tab" data-toggle="tab">预制品配方</a></li>
                </ul>

                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane tab-div active" id="product">
                        <div class="row wrapper">
		                    <div class="col-md-12">
		                        <div class="row rawMaterial-row" id="selectArea">                     
		                        </div>
		                        <div class="row pachkagingMaterial-row">
		                            <label for="status" class="w90">状态：</label>
		                            <select name="" id="status" class="form-control">
		                                <option value="0">有效</option>
		                                <option value="1">无效</option>
		                                <option value="2">审核中</option>
		                            </select> 
		                        </div>
		                        <div class="row rawMaterial-row">
		                            <label for="keyword" class="w90">关键字：</label>
		                            <input type="text" class="form-control" id="keyword"></option>
		                            <div class="row-section btn-section">
		                                <button onclick="search()" class="btn btn-default">查询</button>
		                                <button class="btn btn-default">打印</button>
		                            </div>              
		                        </div>
		                    </div>
                        </div>
                        <div class="row wrapper">
                             <table class="table table-striped rawMaterial-table">
                                <thead>
                                    <tr>
                                        <th>配方列表</th>
                                        <th >序号</th>
                                        <th > 编码
                                            <!-- <span class="glyphicon glyphicon-arrow-down order-btn" aria-hidden="true"> -->
                                        </th>
                                        <th >名称<!-- <span class="glyphicon glyphicon-arrow-down order-btn" aria-hidden="true"> --></th>
                                        <th >状态<!-- <span class="glyphicon glyphicon-arrow-down order-btn" aria-hidden="true"> --></th>
 
                                    </tr>
                                </thead>
                                <tbody id="productList">
                                   
                                </tbody>
                            </table> 

                            <!-- <div class="table-page"> 
                                <div class="table-page-left">
                                    Showing 1 to 0 of 0 rows
                                </div>
                                <div class="table-page-right">
                                    <nav>
                                        <ul class="pager float-right">
                                            <li>
                                                <select name="" id="" class="form-control">
                                                    <option value="">10</option>
                                                    <option value="">20</option>
                                                    <option value="">30</option>
                                                    <option value="">40</option>
                                                    <option value="">50</option>
                                                </select>
                                            </li>
                                            <li><a href="#"><<</a></li>
                                            <li><a href="#"><</a></li>
                                            <li><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">></a></li>
                                            <li><a href="#">>></a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>  -->
                            
                           	

		<div class="table-page" paging-table="productTable" page-size="10">
		</div>  
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane tab-div" id="prefabricate">
                        <div class="row wrapper">
                            <div class="col-md-12">
                                <div class="row pachkagingMaterial-row">
                                    <label for="" class="w90">原辅料分类：</label>
                                    <select name="" id="" class="form-control">
                                        <option value="">(全部)</option>
                                    </select>
                                </div>
                                <div class="row pachkagingMaterial-row">
                                    <label for="status" class="w90">状态：</label>
                                    <select name="" id="status" class="form-control">
                                        <option value="">有效</option>
                                        <option value="">无效</option>
                                    </select>  
                                    <label for="keyword" class="w90">关键字：</label>
                                    <input type="text" class="form-control" id="keyword"></option>  
                                    <div class="row-section btn-section">
                                        <button class="btn btn-default">查询</button>
                                        <button class="btn btn-default">预处理配方</button>
                                    </div>              
                                </div>
                            </div>
                        </div>
                        <div class="row wrapper">
                            <table class="table table-striped rawMaterial-table">
                                <thead>
                                    <tr>
                                        <th>配方列表</th>
                                        <th class="w60">序号</th>
                                        <th class="w100">
                                            编码
                                            <span class="glyphicon glyphicon-arrow-down order-btn" aria-hidden="true">
                                        </th>
                                        <th class="w100">名称<span class="glyphicon glyphicon-arrow-down order-btn" aria-hidden="true"></th>
                                        <th class="w60">状态<span class="glyphicon glyphicon-arrow-down order-btn" aria-hidden="true"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                           <a class="display-btn"><span class="glyphicon glyphicon-list-alt file-btn" aria-hidden="true"></span></a>
                                        </td>
                                        <td>1</td>
                                        <td>0000000000</td>
                                        <td>芦丁片 20mg</td>
                                        <td>有效</td>
                                        <td>非缓释剂</td>
                                        <td>内销</td>
                                        <td>自产</td>
                                        <td>片剂(压制片)</td>
                                        <td>维生素类</td>
                                    </tr>
                                    <tr class="extend-table-tr">
                                        <td colspan="10">
                                            <a href="#" class="btn-add" data-toggle="modal" data-target="#formula-tab"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
                                            <table class="table table-striped rawMaterial-table extend-table">
                                                <thead>
                                                    <tr>
                                                        <th class="w60">序号</th>
                                                        <th class="w120">配方号</th>
                                                        <th class="w100">审核状态</th>
                                                        <th class="w80">历史记录</th>
                                                        <th class="w80">是否在用</th>
                                                        <th class="w80">审批</th>
                                                        <th class="w120">操作</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>第一号配方</td>
                                                        <td>审核通过</td>
                                                        <td>
                                                        <a class="btn-operation" href="#" data-toggle="modal" data-target="#history"><span class="glyphicon glyphicon-file" aria-hidden="true"></span></a></td>
                                                        <td><button class="btn btn-default" disabled="disabled">配方在用</button></td>
                                                        <td><button class="btn btn-default" disabled="disabled">一级审批</button></td>
                                                        <td>
                                                            <a class="btn-operation" href="#" data-toggle="modal" data-target="#formula-tab"><span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span></a>
                                                            <a class="btn-operation" href="#" data-toggle="modal" data-target="#formula-tab"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                                            <a class="btn-operation" href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                                        </td> 
                                                    </tr>
                                                    <tr>
                                                        <td>2</td>
                                                        <td>第二号配方</td>
                                                        <td>审核通过</td>
                                                        <td>
                                                        <a class="btn-operation" href="#" data-toggle="modal" data-target="#history"><span class="glyphicon glyphicon-file" aria-hidden="true"></span></a></td>
                                                        <td><button class="btn btn-default">配方在用</button></td>
                                                        <td><button class="btn btn-default">一级审批</button></td>
                                                        <td>
                                                            <a class="btn-operation" href="#" data-toggle="modal" data-target="#formula-tab"><span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span></a>
                                                            <a class="btn-operation" href="#" data-toggle="modal" data-target="#formula-tab"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                                            <a class="btn-operation" href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                                        </td> 
                                                    </tr>
                                                </tbody>
                                            </table>                                        
                                        </td>
                                    </tr>
                                </tbody>
                            </table>

<!--                             <div class="table-page">
                                <div class="table-page-left">
                                    Showing 1 to 0 of 0 rows
                                </div>
                                <div class="table-page-right">
                                    <nav>
                                        <ul class="pager float-right">
                                            <li>
                                                <select name="" id="" class="form-control">
                                                    <option value="">10</option>
                                                    <option value="">20</option>
                                                    <option value="">30</option>
                                                    <option value="">40</option>
                                                    <option value="">50</option>
                                                </select>
                                            </li>
                                            <li><a href="#"><<</a></li>
                                            <li><a href="#"><</a></li>
                                            <li><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">></a></li>
                                            <li><a href="#">>></a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>    -->
                        </div>
                    </div>

                    <div class="modal fade" id="history" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-productSameName">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <div class="modal-body">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th class="w60">序号</th>
                                                <th class="w80">编辑人</th>
                                                <th class="w150">编辑时间</th>
                                                <th class="w80">审核人</th>
                                                <th class="w150">一级审核时间</th>
                                                <th class="w80">审核人</th>
                                                <th class="w150">二级审核时间</th>
                                                <th class="w60">浏览</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>XXX</td>
                                                <td>2004-12-24 10:11:08</td>
                                                <td>XXX</td>
                                                <td>2004-12-24 10:11:08</td>
                                                <td>XXX</td>
                                                <td>2004-12-24 10:11:08</td>
                                                <td>
                                                    <a class="btn-operation" href="#" data-toggle="modal" data-target="#check-history"><span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>1</td>
                                                <td>XXX</td>
                                                <td>2004-12-24 10:11:08</td>
                                                <td>XXX</td>
                                                <td>2004-12-24 10:11:08</td>
                                                <td>XXX</td>
                                                <td>2004-12-24 10:11:08</td>
                                                <td>
                                                    <a class="btn-operation" href="#" data-toggle="modal" data-target="#check-history"><span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span></a>
                                                </td>
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

                    <div class="modal fade" id="check-history" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-width-1000">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <div class="modal-body">
                                    <ul class="nav nav-tabs tablist" role="tablist">
                                        <li role="presentation" class="active"><a href="#checked" aria-controls="checked" role="tab" data-toggle="tab">审核通过的配方</a></li>
                                        <li role="presentation"><a href="#checking" aria-controls="checking" role="tab" data-toggle="tab">在编、待审的配方</a></li>
                                    </ul>

                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane tab-modal-div active" id="checked">
                                            <div class="wrapper">
                                                <label for="" class="w90">分组：</label>
                                                <select name="" id="groupselect" class="form-control w150">
                                                    <option value="">(全部)</option>
                                                </select> 
                                            </div> 
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th class="w60">序号</th>
                                                        <th class="w100">分组名称</th>
                                                        <th class="w80">编号</th>
                                                        <th class="w100">原辅料名称</th>
                                                        <th class="w80">模拟生产量</th>
                                                        <th class="w80">单位</th>
                                                        <th class="w100">原辅料配质量</th>
                                                        <th class="w100">原辅料单位</th>
                                                        <th class="w100">投料差异(±%)</th>
                                                        <th class="w100">增投比例</th>
                                                        <th class="w60">主药</th>
                                                        <th class="w60">不计入物料平衡</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>XXX</td>
                                                        <td>0114</td>
                                                        <td>玉米淀粉</td>
                                                        <td>10000</td>
                                                        <td>片</td>
                                                        <td>0.500</td>
                                                        <td>kg</td>
                                                        <td>    </td>
                                                        <td>    </td>
                                                        <td><input type="checkbox"></td>
                                                        <td><input type="checkbox"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>XXX</td>
                                                        <td>0114</td>
                                                        <td>玉米淀粉</td>
                                                        <td>10000</td>
                                                        <td>片</td>
                                                        <td>0.500</td>
                                                        <td>kg</td>
                                                        <td>    </td>
                                                        <td>    </td>
                                                        <td><input type="checkbox"></td>
                                                        <td><input type="checkbox"></td>
                                                    </tr>
                                                </tbody>
                                            </table> 
                                            <div class="modal-row">
                                                <label for="" class="formula-label">使用说明：</label>
                                                <textarea name="" id="" class="formula-textarea"></textarea>
                                                <label for="" class="formula-label">尾料量折算式：</label>
                                                <textarea name="" id="" class="formula-textarea"></textarea>
                                            </div>
                                        </div>
                                        <div role="tabpanel" class="tab-pane tab-modal-div" id="checking">
                                            <div class="wrapper">
                                                <label for="" class="w90">分组：</label>
                                                <select name="" id="" class="form-control w150">
                                                    <option value="">(全部)</option>
                                                </select> 
                                            </div> 
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th class="w60">序号</th>
                                                        <th class="w100">分组名称</th>
                                                        <!-- <th class="w80">编号</th> -->
                                                        <th class="w100">原辅料名称</th>
                                                        <th class="w80">模拟生产量</th>
                                                        <th class="w80">单位</th>
                                                        <th class="w100">原辅料配质量</th>
                                                        <th class="w100">原辅料单位</th>
                                                        <th class="w100">投料差异(±%)</th>
                                                        <th class="w100">增投比例</th>
                                                        <th class="w60">主药</th>
                                                        <th class="w60">不计入物料平衡</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>XXX</td>
                                                        <td>0114</td>
                                                        <td>玉米淀粉</td>
                                                        <td>10000</td>
                                                        <td>片</td>
                                                        <td>0.500</td>
                                                        <td>kg</td>
                                                        <td>    </td>
                                                        <td>    </td>
                                                        <td><input type="checkbox"></td>
                                                        <td><input type="checkbox"></td> 
                                                    </tr>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>XXX</td>
                                                        <td>0114</td>
                                                        <td>玉米淀粉</td>
                                                        <td>10000</td>
                                                        <td>片</td>
                                                        <td>0.500</td>
                                                        <td>kg</td>
                                                        <td>    </td>
                                                        <td>    </td>
                                                        <td><input type="checkbox"></td>
                                                        <td><input type="checkbox"></td>
                                                    </tr>
                                                </tbody>
                                            </table> 
                                            <div class="modal-row">
                                                <label for="" class="formula-label">使用说明：</label>
                                                <textarea name="" id="" class="formula-textarea"></textarea>
                                                <label for="" class="formula-label">尾料量折算式：</label>
                                                <textarea name="" id="" class="formula-textarea"></textarea>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="formula-tab" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-width-1000">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <div class="modal-body">
                                    <ul class="nav nav-tabs tablist" role="tablist">
                                        <li role="presentation" class="active"><a href="#basic" aria-controls="basic" role="tab" data-toggle="tab">基本信息</a></li>
                                        <li role="presentation"><a href="#weight" aria-controls="weight" role="tab" data-toggle="tab">称量信息</a></li>
                                    </ul>

                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane tab-modal-div active" id="basic">
                                            <div class="wrapper">
                                                <label for="" class="w90">分组：</label>
                                                <select name="" id="" class="form-control w150">
                                                    <option value="">(全部)</option>
                                                </select> 
                                            </div> 
                                            <a href="#" class="btn-add" data-toggle="modal" data-target="#add-item-tab"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th class="w60">序号</th>
                                                        <th class="w100">分组名称</th>
                                                        <th class="w100">原辅料名称</th>
                                                        <th class="w80">模拟生产量</th>
                                                        <th class="w80">单位</th>
                                                        <th class="w100">原辅料配质量</th>
                                                        <th class="w100">原辅料单位</th>
                                                        <th class="w100">投料差异(±%)</th>
                                                        <th class="w100">增投比例</th>
                                                        <th class="w60">主药</th>
                                                        <th class="w60">不计入物料平衡</th>
                                                        <th>操作</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="formuladetailsList">
                                                </tbody>
                                            </table> 
                                            <div class="modal-row">
                                                <label for="" class="formula-label">使用说明：</label>
                                                <textarea name="instruction" id="instruction" class="formula-textarea"></textarea>
                                                <label for="" class="formula-label">尾料量折算式：</label>
                                                <textarea name="convertion" id="" class="formula-textarea"></textarea>
                                                <input type="text" style="display:none;" id="formulaid" />
                                            </div>
                                            <div class="modal-row">
                                                <label for="" class="margin-left-20">尾料投入不控制：</label>
                                                <input id="" type="checkbox">
                                            </div>

                                        </div>
                                        <div role="tabpanel" class="tab-pane tab-modal-div" id="weight">暂时不开发
                                        </div>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <label for="">提交审核：</label>
                                    <input type="checkbox">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">确定
                                    </button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="add-item-tab" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-productSameName">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <div class="modal-body">
                                    <table class="table edit-table">
                                        <tr>
                                            <td>原辅料分类</td>
                                            <td colspan="3">
                                                <select name="" id="" class="w200">
                                                    <option value="">(01)维生素类原料</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="4">
                                                <div class="table-height">
                                                    <table class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th class="w60">编码</th>
                                                                <th class="w100">名称</th>
                                                                <th class="w100">单位</th>
                                                                <th class="w100">选中</th>
                                                            </tr>               
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>1</td>
                                                                <td>0000000000</td>
                                                                <td>维生素B1片</td>
                                                                <td><span class="glyphicon glyphicon-ok-circle file-btn" aria-hidden="true"></td>
                                                            </tr> 
                                                            <tr>
                                                                <td>1</td>
                                                                <td>0000000000</td>
                                                                <td>维生素B1片</td>
                                                                <td><span class="glyphicon glyphicon-ok-circle file-btn" aria-hidden="true"></td>
                                                            </tr> 
                                                            <tr>
                                                                <td>1</td>
                                                                <td>0000000000</td>
                                                                <td>维生素B1片</td>
                                                                <td><span class="glyphicon glyphicon-ok-circle file-btn" aria-hidden="true"></td>
                                                            </tr> 
                                                            <tr>
                                                                <td>1</td>
                                                                <td>0000000000</td>
                                                                <td>维生素B1片</td>
                                                                <td><span class="glyphicon glyphicon-ok-circle file-btn" aria-hidden="true"></td>
                                                            </tr> 
                                                            <tr>
                                                                <td>1</td>
                                                                <td>0000000000</td>
                                                                <td>维生素B1片</td>
                                                                <td><span class="glyphicon glyphicon-ok-circle file-btn" aria-hidden="true"></td>
                                                            </tr> 
                                                            <tr>
                                                                <td>1</td>
                                                                <td>0000000000</td>
                                                                <td>维生素B1片</td>
                                                                <td><span class="glyphicon glyphicon-ok-circle file-btn" aria-hidden="true"></td>
                                                            </tr> 
                                                            <tr>
                                                                <td>1</td>
                                                                <td>0000000000</td>
                                                                <td>维生素B1片</td>
                                                                <td><span class="glyphicon glyphicon-ok-circle file-btn" aria-hidden="true"></td>
                                                            </tr>                                                            
                                                        </tbody>
                                                    </table> 
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="w150">原辅料编码</td>
                                            <td class="w230">0101</td>
                                            <td class="w150">原辅料名称</td>
                                            <td class="w230">维生素A</td>
                                        </tr>
                                        <tr>
                                            <td>数量单位</td>
                                            <td>kg</td>
                                            <td>每单位转换系数</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>分组名称</td>
                                            <td>
                                                <select name="" id="" class="w60">
                                                    <option value="">kg</option>
                                                </select>
                                                <a class="btn-operation" onclick="openGroupTable()" class="glyphicon glyphicon-edit" aria-hidden="true"></a>
                                            </td>
                                            <td>模拟生产量<span class="red">*</span></td>
                                            <td><input type="text" class="w100">片</td>
                                        </tr>
                                        <tr>
                                            <td>原辅料配置量<span class="red">*</span></td>
                                            <td>
                                                <input type="text" class="w100">
                                                <select name="" id="" class="w60">
                                                    <option value="">kg</option>
                                                </select>
                                            </td>
                                            <td>掺入尾料增投量</td>
                                            <td>
                                                <input type="text" class="w100">
                                                <select name="" id="" class="w60">
                                                    <option value="">kg</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>投料差异(±%)</td>
                                            <td>
                                                <input type="text" class="w100">
                                                <label>启用<input type="checkbox"></label>
                                            </td>
                                            <td>增投比例</td>
                                            <td>
                                                <input type="text" class="w100">%
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>主要原料</td>
                                            <td><input type="checkbox"></td>
                                            <td>不计入物料平衡</td>
                                            <td><input type="checkbox"></td>
                                        </tr>
                                        <tr>   
                                            <td>含量补差公式</td>
                                            <td colspan="3">
                                                <textarea name="" id="" rows="2"></textarea>
                                                <a class="btn-operation" href="#" data-toggle="modal" data-target="#formula-edit"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                            </td>
                                        </tr>
                                    </table>  
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">确定
                                    </button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="edit-item-tab" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-productSameName">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <div class="modal-body">
                                    <table class="table edit-table">
                                        <tr>
                                            <td class="w150">原辅料编码</td>
                                            <td class="w230">0101</td>
                                            <td class="w150">原辅料名称</td>
                                            <td class="w230">维生素A</td>
                                        </tr>
                                        <tr>
                                            <td>数量单位</td>
                                            <td>kg</td>
                                            <td>每单位转换系数</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>分组名称</td>
                                            <td>
                                                <select name="" id="" class="w60">
                                                    <option value="">kg</option>
                                                </select>
                                                <a class="btn-operation" href="#" data-toggle="modal" data-target="#group-name"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                            </td>
                                            <td>模拟生产量<span class="red">*</span></td>
                                            <td><input type="text" class="w100">片</td>
                                        </tr>
                                        <tr>
                                            <td>原辅料配置量<span class="red">*</span></td>
                                            <td>
                                                <input type="text" class="w100">
                                                <select name="" id="" class="w60">
                                                    <option value="">kg</option>
                                                </select>
                                            </td>
                                            <td>掺入尾料增投量</td>
                                            <td>
                                                <input type="text" class="w100">
                                                <select name="" id="" class="w60">
                                                    <option value="">kg</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>投料差异(±%)</td>
                                            <td>
                                                <input type="text" class="w100">
                                                <label>启用<input type="checkbox"></label>
                                            </td>
                                            <td>增投比例</td>
                                            <td>
                                                <input type="text" class="w100">%
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>主要原料</td>
                                            <td><input type="checkbox"></td>
                                            <td>不计入物料平衡</td>
                                            <td><input type="checkbox"></td>
                                        </tr>
                                        <tr>   
                                            <td>含量补差公式</td>
                                            <td colspan="3">
                                                <textarea name="" id="" rows="2"></textarea>
                                                <a class="btn-operation" href="#" data-toggle="modal" data-target="#formula-edit"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                            </td>
                                        </tr>
                                    </table>  
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">确定
                                    </button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="group-name" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-normal">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <div class="modal-body">
                                    <a class="btn-add" onclick="addItem(groupTable)"><img src="../image/add.png" alt="增加" class="btn-img"></a>
                                    <table id="groupTable" class="table sort-table table-striped"
                                    	afterInsert="initgroupSelect" afterDalete="initgroupSelect"
                                    	afterEdit="initgroupSelect">
                                        <thead>
                                            <tr>
                                                <th>序号</th>
                                                <th>常用文本</th>
                                                <th>操作</th>
                                            </tr>
                                            <tr id="selectTemplete" style="display:none">
												<td><span id="index"></span>
												</td>
												<td><span id="name"></span>
												</td>
												<td><a class="btn-operation" onclick="editItem(this)"><span
														class="glyphicon glyphicon-edit" aria-hidden="true"></span>
												</a> <a class="btn-operation" onclick="deleteItem(this)"><span
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
                    
                    <div class="modal fade" id="formula-edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                                    <a class="formula-btn">小于</a>
                                                    <a class="formula-btn">小于等于</a>
                                                    <a class="formula-btn">大于</a>
                                                    <a class="formula-btn">大于等于</a>
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
        
<button id="showfomuladetails" style="DISPLAY:none" data-toggle="modal" data-target="#formula-tab" data-backdrop="false">
 </button>
 
 <button id="showfomulaitemdetails" style="DISPLAY:none" data-toggle="modal" data-target="#edit-item-tab" data-backdrop="false">
 </button>
<script type="text/javascript">
var postParam;
var codelength;
var codeindex;
var isAdding=0;
$(function(){
		postParam = {
			"type" : 1
		};
		//搜索项加载
		$.getJSON('${pageContext.request.contextPath}/catagoryAction_getCatagoriesAndDetails',postParam, function(data, status) {
			
			if(data.retcode=="0000"){
				var addHtml = "";
				var tmp  = "";
		
				$.each(data.obj, function(index, item) {		
					if (index%2==0)
					{	
						addHtml+="<label class='w90'>"+item.name+":</label>";
						addHtml+="<select name='catagoriesList' tid='"+item.id+"'id='catagoriesList"+item.id+"'class='form-control tool-select'>";
					}
					else{
						addHtml+="<label class='w90'>"+item.name+":</label>";
						addHtml+="<select name='catagoriesList' tid='"+item.id+"'id='catagoriesList"+item.id+"'class='form-control tool-select'>";
					}
						tmp="";
						tmp+="<option value=''>全部</option>";
						$.each(item.catagoryDetails,function(i,detail){;						
							tmp	+="<option value='"+detail.id+"' code='"+detail.code+"'>"
								+detail.name
								+"</option>";
						});					
					addHtml+=tmp;
					if (index%2==0)
					{	
						addHtml+="</select>";
					}
					else{
						addHtml+="</select>";
					}
				});
				$("#selectArea").empty().append(addHtml).trigger("create");
			}
		});
		//搜索项加载结束
});
</script>

<script type="text/javascript">
function edititem(itemid){
	var postParam={
	"formulaitemId":itemid
	};
	$.getJSON('${pageContext.request.contextPath}/productFormulaAction_getFormulaItem',postParam, function(data, status) {
/* 		console.log(data); */
		if (data.retcode=="0000"){
			console.log(data);
		}
		else{
			alert(data.errorMsg);
		}
	});
	$("#showfomulaitemdetails").click();
}
function deleteitem(itemid){
	var postParam={
	"formulaitemId":itemid
	};
	$.getJSON('${pageContext.request.contextPath}/productFormulaAction_deleteFormulaItem',postParam, function(data, status) {
		if (data.retcode=="0000"){
		}
		else{
			alert(data.errorMsg);
		}
	});
}
//分组下拉框
function initgroupselect(formulaid){
	var postParam={
	"formulaitemId":formulaid
	};

	$.getJSON('${pageContext.request.contextPath}/productFormulaAction_getFormulagroup',postParam, function(data, status) {
		console.log(data);
		if (data.retcode=="0000"){
			console.log(data);
		}
		else{
			alert(data.errorMsg);
		}
	});
	$("#groupselect");
}
function lookformula(formulaid){
/* initgroupselect(formulaid); */
var postParam = {
	"formulaId":formulaid
};
	$("#formulaid").val(formulaid);
	$.getJSON('${pageContext.request.contextPath}/productFormulaAction_getFormulasdetails',postParam, function(data, status) {
		if (data.retcode=="0000"){
			var addHtml="";
			$.each(data.obj.formulalist,function(index,item){
				addHtml+="<tr>";
				addHtml+="<td>"+index+1+"</td>";
				addHtml+="<td>"+item.formulaGroup+"</td>";
				addHtml+="<td>"+item.materials.name+"</td>";
				addHtml+="<td>"+item.mocProductQuantity+"</td>";
				addHtml+="<td>"+"个"+"</td>";
				addHtml+="<td>"+item.configQuantity+"</td>";
				addHtml+="<td>"+"kg"+"</td>";
				addHtml+="<td>"+item.differences+"</td>";
				addHtml+="<td>"+item.increaseProportion+"</td>";
				addHtml+="<td>"+item.isMain+"</td>";
				addHtml+="<td>"+item.isCalculateBalance+"</td>";
				addHtml+="<td>";
				addHtml+="<a class='btn-operation' href='#' data-toggle='modal' onclick='edititem("+item.id+")'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a>";
                addHtml+="<a class='btn-operation' href='#' onclick='deleteitem("+item.id+")'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></a>";
				addHtml+="</td>";
				addHtml+="</tr>";
			});
			$("#formuladetailsList").empty().append(addHtml).trigger("create");
		}
		else{
			alert(data.errorMsg);
		}
	});
	$("#showfomuladetails").click();
}
function editformula(formulaid){
	/* $("#showfomuladetails").click(); */
	lookformula(formulaid);
}
function delformula(formulaid)
{
	var postParam={
	"formulaId":formulaid
	};
	$.getJSON('${pageContext.request.contextPath}/productFormulaAction_deleteFormula',postParam, function(data, status) {
		if (data.retcode=="0000"){
		}
		else{
			alert(data.errorMsg);
		}
	});
}
function showtable(productid){
var postParam={
	"productId":productid
};
	$.getJSON('${pageContext.request.contextPath}/productFormulaAction_getFormulasList',postParam, function(data, status) {
		if (data.retcode=="0000"){
			var addHtml="";
			$.each(data.obj,function(index,item){
				addHtml+="<tr>";
				addHtml+="<td>"+index+1+"</td>";
				addHtml+="<td>"+item.code+"</td>";
				if (item.status==0)
					addHtml+="<td>"+"有效"+"</td>";
				if (item.status==1)
					addHtml+="<td>"+"无效"+"</td>";
				if (item.status==2)
					addHtml+="<td>"+"审核中"+"</td>";
				
				addHtml+="<td><a class='btn-operation' href='#' data-toggle='modal' data-target='#history'><span class='glyphicon glyphicon-file' aria-hidden='true'></span></a></td>";
				//addHtml+="<td>"+"<input type='checkbox'>" +"</td>";
				addHtml+="<td><button class='btn btn-default' disabled='disabled'>配方在用</button></td>";
                addHtml+="<td><button class='btn btn-default' disabled='disabled'>一级审批</button></td>";
                addHtml+="<td>";
                addHtml+="<a class='btn-operation' onclick='lookformula("+item.id+")' href='#' data-toggle='modal' ><span class='glyphicon glyphicon-zoom-in' aria-hidden='true'></span></a>";
               	addHtml+="<a class='btn-operation' onclick='editformula("+item.id+")' href='#' data-toggle='modal' ><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a>";
                addHtml+="<a class='btn-operation' onclick='delformula("+item.id+")' href='#'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></a>";
                addHtml+="</td>";
			});
			$("#formulalist"+productid).empty().append(addHtml).trigger("create");
		}
	});
	$("#product"+productid).parent().parent().next().toggle();
}
function cleanformulamodal(){
	console.log("clean");
	$("#formuladetailsList").html("");
	console.log($("#instruction").val());
	$("#instruction").html("");
	$("#convertion").html("");
	$("#formulaid").val("");
	
}
function addformula(){
	cleanformulamodal();
}
function saveformula(){
	var postParam={
		"formulaid" : $("#formulaid").val(),
		"instruction" :$("#instruction").val(),
		"convertion" : $("#convertion").val()
	}
	
	$.getJSON('${pageContext.request.contextPath}/productFormulaAction_saveFormula',postParam, function(data, status) {
		if (data.retcode=="0000"){
		}
	});
}
function search(){
	var catagoryDetails ="";
	var catagoriesList = $("select[name='catagoriesList']");
	$.each(catagoriesList,function(index,item){
		catagoryDetails+=$(item).val()+"&";
	});
	var postParam={
		"catagoryDetails":catagoryDetails,
		"queryPage":1,
		"pageSize":50,
		"keyword":$("#keyword").val(),
		"status":$("#status").val()
	};
	$.getJSON('${pageContext.request.contextPath}/productFormulaAction_getProductFormulaList',postParam, function(data,status) 
	{
	
	
	
		if(data.retcode=="0000"){
			var addHtml = "";
			console.log(data.obj);
			$.each(data.obj,function(index,item){
				addHtml+="<tr>";
				addHtml+="<td><a class='display-btn' id='product"+item.id+"' onclick='showtable("+item.id+")'><span class='glyphicon glyphicon-list-alt file-btn' aria-hidden='true'></a></td>";
				addHtml+="<td>"+index+1+"</td>";
				addHtml+="<td>"+item.code+"</td>";
				addHtml+="<td>"+item.name+"</td>";
								
				if (item.status==0)
					addHtml+="<td>"+"有效"+"</td>";
				else if (item.status==1)
					addHtml+="<td>"+"无效"+"</td>";
				else if (item.status==2)
					addHtml+="<td>"+"审核中"+"</td>";
				
				addHtml+=" <tr class='extend-table-tr' id='extend-table-tr'>";
				addHtml+="<td colspan='10' id='extend-table-td'>";
                addHtml+="<a href='#' onclick='addformula()' class='btn-add' data-toggle='modal' data-target='#formula-tab' data-backdrop='false'><span class='glyphicon glyphicon-plus' aria-hidden='true'></span></a>"
                addHtml+="<table class='table table-striped rawMaterial-table extend-table'>"
                addHtml+="<thead><tr><th class='w60'>序号</th><th class='w120'>配方号</th><th class='w100'>审核状态</th><th class='w80'>历史记录</th><th class='w80'>是否在用</th><th class='w80'>审批</th><th class='w120'>操作</th></tr></thead>";
                addHtml+="<tbody id='formulalist"+item.id+"'> </tbody></table></tr></td>";	
			});
			console.log(addHtml);
			$("#productList").html(addHtml);
			//$("#productList").empty().append(addHtml).trigger("create");
		}
		else{
			alert(data.errorMsg);
		}
	});
}


function openGroupTable(){
	initGroupTable();
}

function initGroupTable() {
		var aoColumns = [ {
			"mDataProp" : "name"
		} ];
		var ajaxSource = {
			"get" : "${pageContext.request.contextPath}/productFormulaAction_getGroup",
			"select" : "${pageContext.request.contextPath}/productFormulaAction_getGroups",
			"add" : "${pageContext.request.contextPath}/productFormulaAction_addGroup",
			"delete" : "${pageContext.request.contextPath}/productFormulaAction_deleteGroup",
			"edit" : "${pageContext.request.contextPath}/productFormulaAction_editGroup"
		};
		initTable("groupTable", aoColumns, ajaxSource);
	}
</script>
  </body>
</html>
