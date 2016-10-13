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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/dist/css/wangEditor.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/dist/js/wangEditor.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/plupload/plupload.full.min.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/summernote.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/summernote-zh-CN.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">
</head>
<body class="gray-bg  pace-done mini-navbar"><div class="pace  pace-inactive"><div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
  <div class="pace-progress-inner"></div>
</div>
<div class="pace-activity"></div></div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12"><form method="post" action="17.html" id="frmSearch">
    <table class="table">
        <tbody>
        <tr>
            <td colspan="6">
                <strong>装备信息表</strong>
            </td>
            </tr>
            <tr>
                        <td>
                <a class="btn btn-primary" onclick="addItem(equipments)">新增</a>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<table class="table" id="equipments">
    <thead>
    <tr>
    	<td>序号</td>
        <td>装备名称</td>
        <td>原价</td>
        <td>折扣价</td>
        <td>装备包含</td>
    </tr>
    <tr id="selectTemplete" style="display:none">
						<td><span id="index"></span></td>
						<td><span id="name"></span></td>
						<td><span id="originalPrice"></span></td>
						<td><span id="offPrice"></span></td>
						<td><span id="content"></span></td>
						<td><a  onclick="editDetail(this)" class="btn btn-primary">编辑装备详情</a>
							<a onclick="editItem(this)" class="btn btn-primary">修改</a>
           					<a onclick="deleteItem(this)" class="btn btn-primary">删除</a>
           					
           					</td>										
					</tr>
					<tr id="insertTemplete" style="display:none">
    					<td><span id="index"></span></td>
    					<td><input id="name" type="text" class="form-control"></td>
    					<td><input id="originalPrice" type="text" class="form-control"></td>
						<td><input id="offPrice" type="text" class="form-control"></td>
						<td><input id="content" type="text" class="form-control"></td>
       					<td><a class="btn btn-primary" onclick="submitAdd(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancleAdd(this)">取消</a>
       					</td>	
    				</tr>
                                						
					<tr id="editTemplete" style="display:none">
						<td><span id="index"></span></td>
						<td><input id="name" type="text" class="form-control"></td>
    					<td><input id="originalPrice" type="text" class="form-control"></td>
						<td><input id="offPrice" type="text" class="form-control"></td>
						<td><input id="content" type="text" class="form-control"></td>
						<td><a class="btn btn-primary" onclick="submitEdit(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancelEdit(this)">取消</a>
       					</td>			
					</tr>	
    			</thead>
    			<tbody  id="dataTbody">       
    			</tbody>
			</table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="detailInfo" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="width:800px;">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">装备详情</h4>
         </div>
         <div class="modal-body">
         	<div id="note0div" name="image" style="height:400px"></div>	
         </div>
         <div class="modal-footer">        
         <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
         <button type="button" class="btn btn-primary" onclick="submitDetail()">提交</button>           
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
var editor = new wangEditor('note0div');
$(function() {	
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
		}, {
			"mDataProp" : "originalPrice",
			"bSortable" : true
		}, {
			"mDataProp" : "offPrice",
			"bSortable" : true
		}, {
			"mDataProp" : "content",
			"bSortable" : true
		}];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/equipmentOperationAction_getEquipments",
			"get" : "${pageContext.request.contextPath}/equipmentOperationAction_getEquipmentDetail",
			"add" : "${pageContext.request.contextPath}/equipmentOperationAction_addEquipment", 
			"delete" : "${pageContext.request.contextPath}/equipmentOperationAction_deleteEquipment",
			"edit" : "${pageContext.request.contextPath}/equipmentOperationAction_editEquipment"
		};
		initTable("equipments", aoColumns, ajaxSource);
});

var itemId="";
function editDetail(obj){
	$('#detailInfo').modal('show');
	itemId=$(obj).parents("tr").find("#itemId").val();	
	$.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        data: {"itemId":itemId},
        url: "${pageContext.request.contextPath}/equipmentOperationAction_getEquipmentDetail",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){            	
				editor.$txt.html(data.obj.detailInfo);
        	}
        	else{
        		alert(data.errorMsg);
        	}
        }
    });
}

function submitDetail(){
	var html = editor.$txt.html();
    var postParams={"itemId":itemId,
    				"detailInfo":html};
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        data: postParams,
        url: "${pageContext.request.contextPath}/equipmentOperationAction_editEquipmentDetailInfo",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		alert("提交成功！");	
        		$('#detailInfo').modal('hide');
        	}
        	else{
        		alert(data.errorMsg);
        	}
            
        }
    });
}

//Html编码获取Html转义实体
function htmlEncode(value){
   	return $('<div/>').text(value).html();
}
//Html解码获取Html实体
function htmlDecode(value){
    return $('<div/>').html(value).text();
}

/******************初始化富文本编辑器******************/
     function printLog(title, info) {
            window.console && console.log(title, info);
        }

        // 配置上传
        function uploadInit () {
            var editor = this;
            var btnId = editor.customUploadBtnId;
            var containerId = editor.customUploadContainerId;

            //实例化一个上传对象
            var uploader = new plupload.Uploader({
                browse_button: btnId,
                url: '${pageContext.request.contextPath}/activityOperationAction_execute',
                file_data_name : 'image',
                filters: {
                    mime_types: [
                        //只允许上传图片文件 （注意，extensions中，逗号后面不要加空格）
                        { title: "图片文件", extensions: "jpg,gif,png,bmp" }
                    ]
                }
            });

            //存储所有图片的url地址
            var urls = [];

            //初始化
            uploader.init();

            //绑定文件添加到队列的事件
            uploader.bind('FilesAdded', function (uploader, files) {
                //显示添加进来的文件名
                $.each(files, function(key, value){
                    printLog('添加文件' + value.name);
                });

                // 文件添加之后，开始执行上传
                uploader.start();
            });

            //单个文件上传之后
            uploader.bind('FileUploaded', function (uploader, file, responseObject) {
                //注意，要从服务器返回图片的url地址，否则上传的图片无法显示在编辑器中
                var json = $.parseJSON(responseObject.response);
                var url = '${pageContext.request.contextPath}' + json.obj;
                console.log(url);
                //先将url地址存储来，待所有图片都上传完了，再统一处理
                urls.push(url);

                printLog('一个图片上传完成，返回的url是' + url);
            });

            //全部文件上传时候
            uploader.bind('UploadComplete', function (uploader, files) {
                printLog('所有图片上传完成');

                // 用 try catch 兼容IE低版本的异常情况
                try {
                    //打印出所有图片的url地址
                    $.each(urls, function (key, value) {
                        printLog('即将插入图片' + value);
                        
                        // 插入到编辑器中
                        editor.command(null, 'insertHtml', '<img src="' + value + '" style="max-width:100%;"/>');
                    });
                } catch (ex) {
                    // 此处可不写代码
                } finally {
                    //清空url数组
                    urls = [];

                    // 隐藏进度条
                    editor.hideUploadProgress();
                }
            });

            // 上传进度条
            uploader.bind('UploadProgress', function (uploader, file) {
                // 显示进度条
                editor.showUploadProgress(file.percent);
            });
        }

        // 创建编辑器
        editor.config.menus=['source','|','bold','underline','italic','strikethrough','eraser','forecolor','bgcolor','|','quote',
        'fontfamily','fontsize','head','unorderlist','orderlist','alignleft','aligncenter','alignright','|','link','unlink','table','emotion',
        '|','img','insertcode','|','undo','redo','fullscreen'];
        
        editor.config.customUpload = true;  // 配置自定义上传
        editor.config.customUploadInit = uploadInit;  // 配置上传事件
        editor.create();
    /******************初始化富文本编辑器结束******************/
</script>

</body></html>
