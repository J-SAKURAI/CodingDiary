<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/script/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/script/BootSideMenu.js"></script>        
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/fonts/glyphicons-halflings-regular.eot">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/fonts/glyphicons-halflings-regular.svg">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/fonts/glyphicons-halflings-regular.ttf">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/fonts/glyphicons-halflings-regular.woff">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/fonts/glyphicons-halflings-regular.woff2">
    <link href="${pageContext.request.contextPath}/web/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/web/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/web/css/site.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/web/css/style.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/web/css/color.css" rel="stylesheet" type="text/css">

    <script type="text/javascript">
    $(document).ready(function(){
        $(".display-btn").click(function () {
            $(this).parent().parent().next().toggle();
        });
    });
    </script>

    <title>产品配方</title>
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
            <img src="${pageContext.request.contextPath}/web/image/logo.jpg" alt="logo" class="logo">
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
                       <li><a href="#"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span> 企业基本信息设置</a></li>
                       <li><a href="#"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span> 系统分级设置</a></li>
                       <li><a href="#"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span> 技术编码设置</a></li>
                       <li class="sub-li"><a href="#">分类编码设置</a></li>
                       <li class="sub-li"><a href="#">编码设置</a></li>
                       <li><a href="#"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span> 技术标准设置</a></li>
                       <li class="sub-li"><a href="#">技质标准选项</a></li>
                       <li class="sub-li"><a href="#">产品配方</a></li>
                       <li class="sub-li"><a href="#">包装材料配套</a></li>
                       <li class="sub-li"><a href="#">工艺标准设置</a></li>
                       <li class="sub-li"><a href="#">原辅材料检验标准设置</a></li>
                       <li class="sub-li"><a href="#">包装材料检验标准设置</a></li>
                       <li class="sub-li"><a href="#">产品检验标准设置</a></li>
                   </ul>
               </div>
           </div>
       </div>


       <div class="main-right" id="main-right">
        <img src="${pageContext.request.contextPath}/web/image/HideToolBar.png" alt="隐藏目录" id="hideTool">
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
            <li role="presentation" onclick="search()"><a href="#prefabricate" aria-controls="profile" role="tab" data-toggle="tab" >预制品配方</a></li>
        </ul>

        <div class="tab-content">
            <div role="tabpanel" class="tab-pane tab-div active" id="product">
                <div class="row wrapper">
                    <div class="col-md-12">
                        <div class="row pachkagingMaterial-row" >
                            <label for="" class="w90">产品种类：</label>
                            <select name="" id="" class="form-control">
                                <option value="">(全部)</option>
                            </select>  
                            <label for="" class="w90">销售类别：</label>
                            <select name="" id="" class="form-control">
                                <option value="">(全部)</option>
                            </select>
                            <label for="" class="w90">生产性质：</label>
                            <select name="" id="" class="form-control">
                                <option value="">(全部)</option>
                            </select>
                        </div>
                        <div class="row pachkagingMaterial-row">
                            <label for="" class="w90">产品剂型：</label>
                            <select name="" id="" class="form-control">
                                <option value="">(全部)</option>
                            </select>  
                            <label for="" class="w90">药理类别：</label>
                            <select name="" id="" class="form-control">
                                <option value="">(00)维生素类</option>
                            </select>                
                        </div>
                        <div class="row pachkagingMaterial-row">
                            <label for="status" class="w90">状态：</label>
                            <select name="" class="form-control">
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
                                    <th class="w80">产品种</th>
                                    <th class="w100">销售类</th>
                                    <th class="w60">生产性</th>
                                    <th class="w100">产品剂</th>
                                    <th class="w100">药理类</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <a class="display-btn"><span class="glyphicon glyphicon-list-alt file-btn" aria-hidden="true"></a>
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
                                <tr class="extend-table-tr" id="extend-table-tr">
                                    <td colspan="10" id="extend-table-td">
                                        <a href="#" class="btn-add" data-toggle="modal" data-target="#formula-tab" data-backdrop="false"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
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
                                        <tr>
                                            <td>
                                                <a class="display-btn"><span class="glyphicon glyphicon-list-alt file-btn" aria-hidden="true"></a>
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
                                        <tr class="extend-table-tr" id="extend-table-tr">
                                            <td colspan="10" id="extend-table-td">
                                                <a href="#" class="btn-add" data-toggle="modal" data-target="#formula-tab" data-backdrop="false"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
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
                                                <tr>
                                                    <td>
                                                        <a class="display-btn"><span class="glyphicon glyphicon-list-alt file-btn" aria-hidden="true"></a>
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
                                                <tr class="extend-table-tr" id="extend-table-tr">
                                                    <td colspan="10" id="extend-table-td">
                                                        <a href="#" class="btn-add" data-toggle="modal" data-target="#formula-tab" data-backdrop="false"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
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

                                                <div class="table-page">
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
                                                </div>   
                                            </div>
                                        </div>
                                        <div role="tabpanel" class="tab-pane tab-div" id="prefabricate">
                                            <div class="row wrapper">
                                                <div class="col-md-12">
                                                    <div class="row pachkagingMaterial-row" id="selectArea">
                                                        <label for="" class="w90">原辅料分类：</label>
                                                        <select name="" id="" class="form-control">
                                                            <option value="">(全部)</option>
                                                        </select>
                                                    </div>
                                                    <div class="row pachkagingMaterial-row">
                                                        <label for="status" class="w90">状态：</label>
                                                        <select name="" id="status1" class="form-control">
                                                            <option value="有效">有效</option>
                                                            <option value="无效">无效</option>
                                                            <option value="审核中">审核中</option>                                 
                                                            
                                                        </select>  
                                                        <label for="keyword" class="w90">关键字：</label>
                                                        <input type="text" class="form-control" id="keyword"></option>  
                                                        <div class="row-section btn-section">
                                                            <button class="btn btn-default" onclick="search()">查询</button>
                                                            <button class="btn btn-default">预处理配方</button>
                                                        </div>              
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row wrapper">
                                                <table class="table table-striped rawMaterial-table">
                                                    <thead id="materialthead">
                                                        <tr>
                                                            <th>配方列表</th>
                                                            <th class="w60">序号</th>
                                                            <th class="w100">
                                                                编码
                                                                <span class="glyphicon glyphicon-arrow-down order-btn" aria-hidden="true">
                                                                </th>
                                                                <th class="w100">名称<span class="glyphicon glyphicon-arrow-down order-btn" aria-hidden="true"></th>
                                                                <th class="w60">状态<span class="glyphicon glyphicon-arrow-down order-btn" aria-hidden="true"></th>
                                                                <th class="w80">产品种</th>
                                                                <th class="w100">销售类</th>
                                                                <th class="w60">生产性</th>
                                                                <th class="w100">产品剂</th>
                                                                <th class="w100">药理类</th>
                                                            </tr>
                                                        </thead> 
                                                        <tbody id="materialDetailsTbody">
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

                                                        <div class="table-page">
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
                                                        </div>   
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
                                                                            <label for="" class="w90">产品种类：</label>
                                                                            <select name="" id="" class="form-control w150">
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
                                                                        <label for="" class="w90">产品种类：</label>
                                                                        <select name="" id="" class="form-control w150">
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
                                                            </div>

                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                                                        <label for="" class="w90">产品种类：</label>
                                                                        <select name="" id="" class="form-control w150">
                                                                            <option value="">(全部)</option>
                                                                        </select> 
                                                                    </div> 
                                                                    <a href="#" class="btn-add" data-toggle="modal" data-target="#add-item-tab"><span class="glyphicon glyphicon-plus" aria-hidden="true" onclick="search1()"></span></a>
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
                                                                                <th>操作</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody id="editInfo">
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
                                                                                <td>
                                                                                    <a class="btn-operation" href="#" data-toggle="modal" data-target="#edit-item-tab"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                                                                    <a class="btn-operation" href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>  
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
                                                                                    <td>
                                                                                        <a class="btn-operation" href="#" data-toggle="modal" data-target="#edit-item-tab"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                                                                        <a class="btn-operation" href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>  
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table> 
                                                                            <div class="modal-row">
                                                                                <label for="" class="formula-label">使用说明：</label>
                                                                                <textarea name="" id="" class="formula-textarea"></textarea>
                                                                                <label for="" class="formula-label">尾料量折算式：</label>
                                                                                <textarea name="" id="" class="formula-textarea"></textarea>
                                                                            </div>
                                                                            <div class="modal-row">
                                                                                <label for="" class="margin-left-20">尾料投入不控制：</label>
                                                                                <input type="checkbox">
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

                                          
                                          
                                          
                                             <div class="modal fade" id="view" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                                                        <tbody id="viewInfo">
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
                                                                            <div class="modal-row" id="differ">
                                                                                <label for="" class="margin-left-20">尾料投入不控制：</label>
                                                                                <input type="checkbox">
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
                                                                        <label for="" class="w90">产品种类：</label>
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
                                                                                <th>操作</th>
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
                                                                                <td>
                                                                                    <a class="btn-operation" href="#" data-toggle="modal" data-target="#edit-item-tab"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                                                                    <a class="btn-operation" href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>  
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
                                                                                    <td>
                                                                                        <a class="btn-operation" href="#" data-toggle="modal" data-target="#edit-item-tab"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                                                                        <a class="btn-operation" href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>  
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table> 
                                                                            <div class="modal-row">
                                                                                <label for="" class="formula-label">使用说明：</label>
                                                                                <textarea name="" id="" class="formula-textarea"></textarea>
                                                                                <label for="" class="formula-label">尾料量折算式：</label>
                                                                                <textarea name="" id="" class="formula-textarea"></textarea>
                                                                            </div>
                                                                            <div class="modal-row">
                                                                                <label for="" class="margin-left-20">尾料投入不控制：</label>
                                                                                <input type="checkbox">
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
                                                                        <!-- <tr>
                                                                            <td>原辅料分类</td>
                                                                            <td colspan="3">
                                                                                <select name="" id="" class="w200">
                                                                                    <option value="">(01)维生素类原料</option>
                                                                                </select>
                                                                            </td>
                                                                        </tr> -->
                                                                        <tr id="tmodal">
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
                                                                                        <tbody id="materialDetails1Tbody">
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
                                                                        <tr id="materialInfo1">
                                                                            <td class="w150">原辅料编码</td>
                                                                            <td class="w230">0101</td>
                                                                            <td class="w150">原辅料名称</td>
                                                                            <td class="w230">维生素A</td>
                                                                        </tr>
                                                                        <tr id="materialInfo2">
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
                                                                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="addItem()">确定
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
                                                                    <a href="#" class="btn-add"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
                                                                    <table class="table sort-table table-striped">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>序号</th>
                                                                                <th>常用文本</th>
                                                                                <th>操作</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <tr>
                                                                                <td>1</td>
                                                                                <td>0.042</td>
                                                                                <td>
                                                                                    <a class="btn-operation"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                                                                                    <a class="btn-operation"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>2</td>
                                                                                <td>包装工序</td>
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

                                    </body>
                                    </html>


       <script type="text/javascript">
                                    $(function(){
                                     postParam = {
                                       "type" : 2
                                   };

                                   $.getJSON('${pageContext.request.contextPath}/catagoryAction_getCatagoriesAndDetails',postParam, function(data, status) {

                                      if(data.retcode=="0000"){
                                       var addHtml = "";
                                       var addHtml_ ="";
                                       var addtable="";
			addtable +="<tr><th>配方列表</th>"     //显示表头
            +"<th class='w60'>序号</th>"
            +"<th class='w100'>编码<span class='glyphicon glyphicon-arrow-down order-btn' aria-hidden='true'></th>"
            +"<th class='w100'>名称<span class='glyphicon glyphicon-arrow-down order-btn' aria-hidden='true'></th>"
            +"<th class='w60'>状态<span class='glyphicon glyphicon-arrow-down order-btn' aria-hidden='true'></th>";
            var tmp  = "";
			//显示层绑定控件

			$.each(data.obj, function(index, item) {
				addtable+="<th class='w80'>"+item.name+"</th>";
				if (index%2==0)
				{	
					addHtml+="<tr><td><label class='w90'>"+item.name+"</label></td>";
					addHtml+="<td><select name='rawMaterialList' tid='"+item.id+"'id='rawMaterialList"+item.id+"'class='form-control tool-select' onchange='search()'>";
					addHtml_+="<tr><td>"+item.name+"</td><td>";
					addHtml_+="<select name='rawMaterialList1' id='rawMaterialList_m"+item.id+"'class='w200' onchange='search1()'>";	
				}
				else{
					addHtml+="<td><label class='w90'>"+item.name+"</label></td>";
					addHtml+="<td><select name='rawMaterialList' tid='"+item.id+"'id='rawMaterialList"+item.id+"'class='form-control tool-select' onchange='search()'>";
					addHtml_+="<td>"+item.name+"</td><td>";
					addHtml_+="<select name='rawMaterialList1' id='rawMaterialList_m"+item.id+"' class='w200' onchange='search1()'>";	
				}
				
 			
				/* addHtml_ +="<tr><td>"+item.name+"</td><td colspan='3'>";
				addHtml_ +="<select name='rawMaterialList_modal' tid='"+item.id+"'id='rawMaterialList_modal"+item.id+"' class='w200'>";	 */				
             tmp="";
             tmp+="<option value=''>全部</option>";
             $.each(item.catagoryDetails,function(i,detail){;						
              tmp+="<option value='"+detail.id+"' code='"+detail.code+"'>"
              +detail.name
              +"</option>";
          });					
             addHtml+=tmp;
             addHtml_+=tmp;
             if (index%2==0)
             {	
                 addHtml+="</select>";
                 addHtml_+="</select></td>";
             }
             else{
                 addHtml+="</select></tr>";
                 addHtml_+="</select></td></tr>";
             }
/*              addHtml_+="</select></td></tr>";
 */         });

$("#selectArea").empty().append(addHtml).trigger("create");
 $("#tmodal").before(addHtml_).trigger("create");
 $("#materialthead").empty().append(addtable).trigger("create");
makeselect();
}
});

});

                                    
 //子页面里面的搜索                                   
function search1(){
	 var rawMaterialType1 = $("select[name='rawMaterialList1']"); 
	 var tmp = new Array();

	 $.each(rawMaterialType1,function(index,item)
			 {
			   tmp.push($(item).val());
			});
			 postParam = {
			  queryPage : 1,
			  pageSize : 50,
			  catagoryDetails : JSON.stringify(tmp),
			};
			$.ajaxSettings.async = false; 
			$.getJSON('${pageContext.request.contextPath}/materialsAction_getMaterials',postParam, function(data, status) {
				   if(data.retcode=="0000"){
								//codeindex = data.obj.totalSize;
								codeindex = data.obj.totalSize;
								var addHtml = "";
								//显示层绑定控件
								if (data.obj.totalSize==0)
								{
									/* if (isAdding==0) alert("查询结果为空"); */
								}
								$.each(data.obj.list, function(index, item) {
										
				                 addHtml+="<tr>"
				                        +"<td>"+item.code+"</td>"
				                        +"<td>"+item.name+"</td>"
				                        +"<td>"+item.quantityUnit1+"</td>"
				                        + "<td><span class='glyphicon glyphicon-ok-circle file-btn' aria-hidden='true' onclick='selected("+item.id+")'></td>";
								});
				   
				     
					$("#materialDetails1Tbody").empty().append(addHtml).trigger("create");
				   }

				   
				   else{
					    alert(data.errorMsg);
				   }
			});	
}
 
 
var temp1="";
function selected(id){
	temp1=id;
	postParam = {
			  id : id
			};
	$.getJSON('${pageContext.request.contextPath}/materialsAction_getMaterialById',postParam, function(data, status) {
		   if(data.retcode=="0000"){
			   var addHtml = "";
			   addHtml+="<td class='w150'>原辅料编码</td>"
			          +"<td class='w230' id='code1'>"+data.obj.catagoryCode+data.obj.code+"</td>"
			          +"<td class='w150'>原辅料名称</td>"
			          +"<td class='w230' id='name1'>"+data.obj.name+"</td>";
			   $("#materialInfo1").empty().append(addHtml).trigger("create");
			   
			   var addHtml_ = "";
			   addHtml_+="<td>数量单位</td>"
			           +"<td id='unit1'>"+data.obj.quantityUnit1+"</td>"
			           +"<td>每单位转换系数</td>"
			           +"<td id='unitCnvrsnFctr1'>"+data.obj.unitCnvrsnFctr+"</td>";
			   $("#materialInfo2").empty().append(addHtml_).trigger("create");

			   


			   
			   
			   
		   }
		   else{
			   alert(data.errorMsg); 
		   }
	});
	
	
}


function makeselect()
{
 var L = $("select[name=rawMaterialList]");
 var tcode="";
 var theselect="";
 $.each(L,function(index,item){
  var tid = $(item).attr("tid");
  $("#rawMaterialList_modal"+tid).val($(item).val());
  $("#rawMaterialList_modal"+tid).attr("disabled",true);
  var tmp = $(item).find("option");

  tmp.each(function(t,tt){
   if ($(tt).attr("value")==$(item).val())
   {
    tcode+=$(tt).attr("code");
    theselect+=$(tt).text();
}
});
});
 $("#classificationcode").val(tcode);
 $("#theselect").val(theselect);
}


function search()
{

 var rawMaterialType = $("select[name='rawMaterialList']"); 
 var status = $("#status1").val();
 
 if(status=="有效")
	 status=0;
 if(status=="无效")
	 status=1;
 if(status=="审核中")
	 status=2;
 
	 
 var keyword = $("#keyword").val();
 var tmp = new Array();
 $.each(rawMaterialType,function(index,item)
 {
   tmp.push($(item).val());
});
 postParam = {
  queryPage : 1,
  pageSize : 50,
  catagoryDetails : JSON.stringify(tmp),
  status : status,
  keyword : keyword
};
$.ajaxSettings.async = false; 


$.getJSON('${pageContext.request.contextPath}/materialsAction_getMaterials',postParam, function(data, status) {
   if(data.retcode=="0000"){
				//codeindex = data.obj.totalSize;
				codeindex = data.obj.totalSize;
				var addHtml = "";
				//显示层绑定控件
				if (data.obj.totalSize==0)
				{
					/* if (isAdding==0) alert("查询结果为空"); */
				}
				$.each(data.obj.list, function(index, item) {
					var t="";
					if (item.status=="1") t="无效";
					if (item.status=="0") t="有效";
					if (item.status=="2") t="审核中";
					var tt="";
					if (item.specialManageType=="0") tt="否";
					if (item.specialManageType=="1") tt="麻醉药品";
					if (item.specialManageType=="2") tt="一类精神药品";
					if (item.specialManageType=="3") tt="二类精神药品";		
                 addHtml+="<tr>"
                 +"<td><a onclick='selftoggle("+item.id+")' id='ttt"+item.id+"' class='display-btn' ><span class='glyphicon glyphicon-list-alt file-btn'  aria-hidden='true'></span></a></td>"
                 +"<td>"+(index+1)+"</td>"
                 +"<td>"+item.code+"</td>"
                 +"<td>"+item.name+"</td>"
                 +"<td>"+t+"</td>"; 
                 
                
                 postparam = {
                	id : item.id
                 };
                 
                 
     		 	$.getJSON('${pageContext.request.contextPath}/materialsAction_getMaterialsCatagories',postparam, function(data, status) {	
     		 		
     		 		
     		 		if(data.retcode=="0000"){
     		 			$.each(data.obj, function(index, item) {
    		 				addHtml+="<td>"+item.name+"</td>";
     		 		});
     		 		}
     		 		
     		 	});

                 
                  
				addHtml+="</tr>";
				
				
				       
				   addHtml+="<tr class='extend-table-tr'><td colspan='10'>"
                       +"<a href='#' class='btn-add' data-toggle='modal' data-target='#formula-tab'>"
                       +"<span class='glyphicon glyphicon-plus' aria-hidden='true'></span></a>"
                       +"<table class='table table-striped rawMaterial-table extend-table'>"
                       +"<thead><tr><th class='w60'>序号</th><th class='w120'>配方号</th><th class='w100'>审核状态</th>"
                       +"<th class='w80'>历史记录</th><th class='w80'>是否在用</th><th class='w80'>审批</th>"
                       +"<th class='w120'>操作</th></tr></thead>";
                   
                   addHtml+="<tbody><tr>";
                   
                   
                   postParam = {
                		
                		   materialId:item.id
                   };
                	   
                   
                   
                $.getJSON('${pageContext.request.contextPath}/preFormulasAction_getPreFormulasList',postParam, function(data, status) {
                		   if(data.retcode=="0000"){
                       
                			   $.each(data.obj, function(index, item) {
                				   
                				   var t="";
               					   if (item.checkStatus=="0") t="审核通过";
               					   if (item.checkStatus=="1") t="在编";
               					   var tt="";
               					   if (item.status=="0") tt="在用";
               					   if (item.status=="1") tt="不在用";
               					  
           		 				addHtml+="<td>"+(index+1)+"</td>"
           	                           +"<td>"+item.code+"</td>"
           	                           +"<td>"+t+"</td>"
           	                           +"<td><a class='btn-operation' href='#' data-toggle='modal' data-target='#history'>"
           	                           +"<span class='glyphicon glyphicon-file' aria-hidden='true'></span></a></td>"
                                       +"<td><button class='btn btn-default' disabled='disabled'>配方在用</button></td>"
                                       +"<td><button class='btn btn-default' disabled='disabled'>一级审批</button></td>"
                                       +"<td><a class='btn-operation' href='#' data-toggle='modal' onclick='view("+item.id+")' data-target='#view'>"
                                       +"<span class='glyphicon glyphicon-zoom-in' aria-hidden='true'></span></a>"
                                       +"<a class='btn-operation' href='#' data-toggle='modal' onclick='edit("+item.id+")' data-target='#edit'>"
                                       +"<span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a>"
                                       +"<a class='btn-operation' href='#'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></a></td></tr>"; 
           	                          
            		 		});
                			   addHtml+="</tbody></table></td></tr>";
                		   }
                		  
                		   
                       
                        
				   }); 
				});
   
				
				$("#materialDetailsTbody").empty().append(addHtml).trigger("create");
 				$("#materialCode").val(tmp);
				makeselect();
/* 			});
 */   
}
			else{
				alert(data.errorMsg);
			}
		});

};


function selftoggle(id){
	$("#ttt"+id).parent().parent().next().toggle();
	
	}
	

function view(tid){
	postParam = {
			preformulaId: tid	
	};
	
	 $.getJSON('${pageContext.request.contextPath}/preFormulasAction_getPreFormulasMaterials',postParam, function(data, status) {
		   if(data.retcode=="0000"){
			   var addHtml = "";
			   
			   $.each(data.obj, function(index, item) {
				 
				   addHtml+= "<tr><td>"+(index+1)+"</td>"
	                       +"<td>"+item.formulaGroup+"</td>"
	                       +"<td>"+item.code+"</td>"
	                       +"<td>"+item.materialsName+"</td>"
	                       +"<td>"+item.mocProductQuantity+"</td>"
	                       +"<td>"+item.unit+"</td>"
	                       +"<td>"+item.configQuantity+"</td>"
	                       +"<td>"+item.unit+"</td>"
	                       +"<td>"+item.differences+"</td>"
	                       +"<td>"+item.increaseProportion+"</td>"
	                       

	                       if (item.isMain=="1") addHtml+="<td><input type='checkbox' checked=true></td>";
	                       else addHtml+="<td><input type='checkbox'></td>";

						   if (item.isCalculateBalance=="1") addHtml+="<td><input type='checkbox' checked=true></td></tr>"
	                       else addHtml+="<td><input type='checkbox'></td></tr>";
	                       
	        			   
	                    		   
	                       
	                          
			   });
			   
			

			   $("#viewInfo").empty().append(addHtml).trigger("create");
			   
			      
	
	
	       }
		   else{
			   alert(data.errorMsg);
		   }
			   
		   });
}



function edit(tid){
	postParam = {
			preformulaId: tid	
	};
	
	 $.getJSON('${pageContext.request.contextPath}/preFormulasAction_getPreFormulasMaterials',postParam, function(data, status) {
		   if(data.retcode=="0000"){
			   var addHtml = "";
			   
			   $.each(data.obj, function(index, item) {
				 
				   addHtml+= "<tr><td>"+(index+1)+"</td>"
	                       +"<td>"+item.formulaGroup+"</td>"
	                       +"<td>"+item.code+"</td>"
	                       +"<td>"+item.materialsName+"</td>"
	                       +"<td>"+item.mocProductQuantity+"</td>"
	                       +"<td>"+item.unit+"</td>"
	                       +"<td>"+item.configQuantity+"</td>"
	                       +"<td>"+item.unit+"</td>"
	                       +"<td>"+item.differences+"</td>"
	                       +"<td>"+item.increaseProportion+"</td>"
	                       

	                       if (item.isMain=="1") addHtml+="<td><input type='checkbox' checked=true></td>";
	                       else addHtml+="<td><input type='checkbox'></td>";

						   if (item.isCalculateBalance=="1") addHtml+="<td><input type='checkbox' checked=true></td>";
	                       else addHtml+="<td><input type='checkbox'></td>";
	                       
	                       
	                       addHtml+="<td><a class='btn-operation' href='#' data-toggle='modal' data-target='#edit-item-tab'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a>"
	                              +"<a class='btn-operation' href='#'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></a></td></tr>";  

	                    	  
	                    		   
	                       
	                          
			   });
			   
			

			   $("#editInfo").empty().append(addHtml).trigger("create");
			   
			      
	
	
	       }
		   else{
			   alert(data.errorMsg);
		   }
			   
		   });
}



function addItem(){
	$.ajax({
		type : "post",
		url:url,
		data : postParam,
        dataType:'json',
		success : function(data)
		{
			if(data.retcode=="0000"){
				search();
			}
		else{
				alert(data.errorMsg);
			} 					
		},

});
	
	
	
	
	
}



</script>




