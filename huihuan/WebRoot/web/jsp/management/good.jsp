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
	<link href="${pageContext.request.contextPath}/web/jquery-Upload/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
  	<script src="${pageContext.request.contextPath}/web/jquery-Upload/js/fileinput.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/web/jquery-Upload/js/fileinput_locale_zh.js" type="text/javascript"></script>
</head>
<body class="gray-bg  pace-done mini-navbar"><div class="pace  pace-inactive"><div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
  <div class="pace-progress-inner"></div>
</div>
<div class="pace-activity"></div></div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12">
<table class="table">
    <tbody>
        <tr>
            <td colspan="6">
                <strong>兑换商品表</strong>
            </td>
        </tr>
        <tr>
            <td>
            	<a class="btn btn-primary" onclick="setBanner()">设置页面滚动图片</a>
                <a class="btn btn-primary" onclick="addItem(goods)">新增</a>
            </td>
        </tr>
    </tbody>
</table>
<table class="table" id="goods">
    <thead>
    <tr>
    	<td>序号</td>
        <td>商品名称</td>
        <td>商品介绍</td>
        <td>所需积分</td>
        <td>商品图片</td>
        <td>操作</td>
    </tr>
    <tr id="selectTemplete" style="display:none">
						<td><span id="index"></span></td>
						<td><span id="name"></span></td>
						<td><span id="info"></span></td>
						<td><span id="score"></span></td>
						<td><img id="picRoute" src="" width="200px" height="100px"></td>
						<td>
						<a onclick="editItem(this)" class="btn btn-primary">修改</a>
           					<a onclick="deleteItem(this)" class="btn btn-primary">删除</a>
           					</td>										
					<input id="orderPropoty" type="hidden"><input id="orderType" type="hidden"></tr>
					<tr id="insertTemplete" style="display:none">
    					<td><span id="index"></span></td>
    					<td><input id="name" type="text" class="form-control"></td>
    					<td><input id="info" type="text" class="form-control"></td>
    					<td><input id="score" type="text" class="form-control"></td>
    					<td><input id="picRoute" type="file" class="form-control"></td>
       					<td><a class="btn btn-primary" onclick="submitAddForFile(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancleAdd(this)">取消</a>
       					</td>	
    				</tr>
                                						
					<tr id="editTemplete" style="display:none">
						<td><span id="index"></span></td><td><input id="name" type="text" class="form-control"></td>
    					<td><input id="info" type="text" class="form-control"></td>
    					<td><input id="score" type="text" class="form-control"></td>
    					<td><input id="picRoute" type="file" class="form-control"></td>
						<td><a class="btn btn-primary" onclick="submitEditForFile(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancelEdit(this)">取消</a>
       					</td>			
					</tr>	
    			</thead>
    			<tbody id="dataTbody">
				</tbody>
			</table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="leaderDetailModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="width:800px;">
      <div class="modal-content">
         <div class="modal-header" style="border-bottom: 0px solid #e5e5e5">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">页面滚动图片设置</h4>
         </div>
         <div class="modal-body" style="padding: 0px 30px 30px;">
          <table class="table">
        <tbody>
            <tr>
                        <td>
                <a class="btn btn-primary" onclick="addItem(banners)">新增</a>
            </td>
        </tr>
        </tbody>
    </table>
    
         	<table class="table" id="banners">
    <thead>
    <tr>
    	<td>序号</td>
        <td>显示顺序</td>
        <td>链接</td>
        <td>图片</td>
        <td>操作</td>
    </tr>
    <tr id="selectTemplete" style="display:none">
						<td><span id="index"></span></td>
						<td><span id="sequence"></span></td>
						<td><span id="link"></span></td>
						<td><img id="picRoute" src="" width="200px" height="100px"></img></td>
						<td>
						<a onclick="editItem(this)" class="btn btn-primary">修改</a>
           					<a onclick="deleteItem(this)" class="btn btn-primary">删除</a>
           					</td>										
					</tr>
					<tr id="insertTemplete" style="display:none">
    					<td><span id="index"></span></td>
    					<td><input id="sequence" type="text" class="form-control"></td>
    					<td><input id="link" type="text" class="form-control"></td>
    					<td><input id="picRoute" type="file" class="form-control"></td>
       					<td><a class="btn btn-primary" onclick="submitAddForFile(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancleAdd(this)">取消</a>
       					</td>	
    				</tr>
                                						
					<tr id="editTemplete" style="display:none">
						<td><span id="index"></span></td>
						<td><input id="sequence" type="text" class="form-control"></td>
						<td><input id="link" type="text" class="form-control"></td>
    					<td><input id="picRoute" type="file" class="form-control"></td>
						<td><a class="btn btn-primary" onclick="submitEditForFile(this)">确认</a> 
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
$(function() {	
	/******************初始化主图上传控件******************/
	$("#leader_pic").fileinput({
            language: 'zh', //设置语言
            uploadUrl: "/FileUpload/Upload", //上传的地址
            allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀,
            enctype: 'multipart/form-data',
            showUpload: false, //是否显示上传按钮
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            'fileActionSettings':{ uploadIcon: '',uploadClass: style='VISIBILITY: hidden',},
	 });	
	 /******************初始化主图上传控件结束******************/
    var aoColumns = [ 
        {
			"mDataProp" : "id",
			"bSortable" : true
		},{
			"mDataProp" : "index",
			"bSortable" : true
		},{
			"mDataProp" : "name",
			"bSortable" : true
		},{
			"mDataProp" : "info",
			"bSortable" : true
		},{
			"mDataProp" : "score",
			"bSortable" : true
		}, {
			"mDataProp" : "picRoute",
			"bSortable" : true
		}];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/goodOperationAction_getGoods",
			"get" : "${pageContext.request.contextPath}/goodOperationAction_getGoodDetail",
			"add" : "${pageContext.request.contextPath}/goodOperationAction_addGood", 
			"delete" : "${pageContext.request.contextPath}/goodOperationAction_deleteGood",
			"edit" : "${pageContext.request.contextPath}/goodOperationAction_editGood"
		};
		initTable("goods", aoColumns, ajaxSource);
});

function setBanner(obj){
	$('#leaderDetailModal').modal('show');
	var aoColumns = [ 
        {
			"mDataProp" : "id",
			"bSortable" : true
		},{
			"mDataProp" : "index",
			"bSortable" : true
		},{
			"mDataProp" : "sequence",
			"bSortable" : true
		},{
			"mDataProp" : "link",
			"bSortable" : true
		}, {
			"mDataProp" : "picRoute",
			"bSortable" : true
		}];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/goodOperationAction_getBanners",
			"get" : "${pageContext.request.contextPath}/goodOperationAction_getBannerDetail",
			"add" : "${pageContext.request.contextPath}/goodOperationAction_addBanner", 
			"delete" : "${pageContext.request.contextPath}/goodOperationAction_deleteBanner",
			"edit" : "${pageContext.request.contextPath}/goodOperationAction_editBanner"
		};
		initTable("banners", aoColumns, ajaxSource);
}

</script>

</body></html>
