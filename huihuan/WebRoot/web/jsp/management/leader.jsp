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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/dist/css/wangEditor.min.css">
	<script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/MyComponent/MyTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/dist/js/wangEditor.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/plupload/plupload.full.min.js"></script>
	<script src="${pageContext.request.contextPath}/web/script/bootstrap.min.js"></script>
	<link href="${pageContext.request.contextPath}/web/jquery-Upload/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
  	<script src="${pageContext.request.contextPath}/web/jquery-Upload/js/fileinput.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/web/jquery-Upload/js/fileinput_locale_zh.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/web/script/summernote.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/summernote-zh-CN.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">
    <style type="text/css">
        .container {
            width: 100%;
            height:350px;
            margin: 0 auto;
            position: relative;
        }
    </style>
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
                <strong>领队信息表</strong>
            </td>
            </tr>
            <tr>
                        <td>
                <a class="btn btn-primary" onclick="printExcelForLeaders()">导出Excel</a>
                <a type="hidden" href="" id="printExcelForLeaders" download="领队信息.xls"><span id="printExcelForLeadersSpan"></span></a>
                <a class="btn btn-primary" onclick="addItem(leaders)">新增</a>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<table class="table" id="leaders">
    <thead>
    <tr>
    	<td>序号</td>
        <td>姓名</td>
        <td>身份证号</td>
        <td>手机号</td>
        <td>头像</td>
        <td>操作</td>
    </tr>
    <tr id="selectTemplete" style="display:none">
						<td><span id="index"></span></td>
						<td><span id="name"></span></td>
						<td><span id="idNum"></span></td>
						<td><span id="phoneNum"></span></td>
						<td><img id="headPicRoute" src="" width="71px" height="71px"></img></td>
						<td><a onclick="setLeaderDetail(this)" class="btn btn-primary">设置详情</a>
						<a onclick="editItem(this)" class="btn btn-primary">修改</a>
           					<a onclick="deleteItem(this)" class="btn btn-primary">删除</a>
           					</td>										
					</tr>
					<tr id="insertTemplete" style="display:none">
    					<td><span id="index"></span></td>
    					<td><input id="name" type="text" class="form-control"></td>
    					<td><input id="idNum" type="text" class="form-control"></td>
						<td><input id="phoneNum" type="text" class="form-control"></td>
						<td><input id="headPicRoute" type="file" class="form-control"></td>
       					<td><a class="btn btn-primary" onclick="submitAddForFile(this)">确认</a> 
       						<a class="btn btn-primary" onclick="cancleAdd(this)">取消</a>
       					</td>	
    				</tr>
                                						
					<tr id="editTemplete" style="display:none">
						<td><span id="index"></span></td>
						<td><input id="name" type="text" class="form-control"></td>
    					<td><input id="idNum" type="text" class="form-control"></td>
						<td><input id="phoneNum" type="text" class="form-control"></td>
						<td><input id="headPicRoute" type="file" class="form-control"></td>
						<td><a class="btn btn-primary" onclick="submitEditForFile(this)">确认</a> 
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

<!-- 
<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">领队头像设置</h4>
         </div>
         <div class="modal-body">
         	<input id="leader_pic" type="file" name="image">
         </div>
         <div class="modal-footer">
         <button type="button" class="btn btn-primary" onclick="submitPic()">提交</button>
         <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>            
         </div>
      </div>
   </div>
</div>  -->

<!-- 模态框（Modal） -->
<div class="modal fade" id="leaderDetailModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="width:800px;">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">领队详情设置</h4>
         </div>
         <div class="modal-body" >
         	<div id="note0div" name="image" style="height:400px"></div>
         </div>
         <div class="modal-footer">
         <button type="button" class="btn btn-primary" onclick="submitDetail()">提交</button>
         <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>            
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
var id = request("id");
var editor = new wangEditor('note0div');
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
    /*$('.summernote').summernote({
        toolbar: 	[['style', ['bold', 'italic', 'underline', 'clear']], 
        			['font', ['strikethrough', 'superscript', 'subscript','fontname']], 
        			['fontsize', ['fontsize']], ['color', ['color']], 
        			['Insert', ['picture']], 
        			['para', ['ul', 'ol', 'paragraph']],  
        			['codeview', ['undo','redo','codeview']]],
        height: 250,
        lang: 'zh-CN',
        dialogsInBody: true,
        callbacks: {
        	onInit:function(){
        		$('.summernote').summernote('fontSize',18);
        		console.log('Summernote is launched');
        	},
            onImageUpload: function(files) {
                var $files = $(files);

                // 通过each方法遍历每一个file
                $files.each(function() {
                    var file = this;
                    // FormData，新的form表单封装，具体可百度，但其实用法很简单，如下
                    var data = new FormData();

                    // 将文件加入到file中，后端可获得到参数名为“file”
                    data.append("image", file);
                    // ajax上传
                    $.ajax({
                        data: data,
                        type: "POST",
                        dataType: "json",
                        async: false,
                        url: "${pageContext.request.contextPath}/activityOperationAction_execute",
                        cache: false,
                        contentType: false,
                        processData: false,
                        // 成功时调用方法，后端返回json数据
                        success: function(data) {                         
                            // 获取后台数据保存的图片完整路径
                            var imageUrl = "${pageContext.request.contextPath}"+data.obj;
                            console.log(imageUrl);
							// 插入到summernote
                            $('.summernote').summernote('insertImage', imageUrl,
                            function($image) {
                                // todo，后续可以对image对象增加新的css式样等等，这里默认
                             });
                        },
                    });
                });
            },
            onFocus: function() {
                //保存当前操作summerid
                $("#currentsummerid").val(this.id);
                //console.log('Editable area is focused:'+this.id);
            }
        }
    });*/
    
    /******************初始化富文本编辑器结束******************/
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
			"mDataProp" : "idNum",
			"bSortable" : true
		}, {
			"mDataProp" : "phoneNum",
			"bSortable" : true
		}, {
			"mDataProp" : "headPicRoute",
			"bSortable" : true
		}];
		var ajaxSource = {
			"select" : "${pageContext.request.contextPath}/leaderOperationAction_getLeaders",
			"get" : "${pageContext.request.contextPath}/leaderOperationAction_getLeaderDetail",
			"add" : "${pageContext.request.contextPath}/leaderOperationAction_addLeader", 
			"delete" : "${pageContext.request.contextPath}/leaderOperationAction_deleteLeader",
			"edit" : "${pageContext.request.contextPath}/leaderOperationAction_editLeader"
		};
		initTable("leaders", aoColumns, ajaxSource);
});

function request(paras){   
        var url = location.href;   
        var paraString = url.substring(url.indexOf("?")+1,url.length).split("&");   
        var paraObj = {};   
        for (i=0; j=paraString[i]; i++){   
            paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length);   
        }   
        var returnValue = paraObj[paras.toLowerCase()];   
        if(typeof(returnValue)=="undefined"){   
            return "";   
        }else{   
            return returnValue;   
        }   
}

function printExcelForLeaders(){
	$.ajax({
        type: "post",
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/leaderOperationAction_printExcelForLeaders",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		$("#printExcelForLeaders").attr("href","../../download/"+data.obj);	
        		$("#printExcelForLeadersSpan").trigger("click");	
        	}
        	else{
        		alert(data.errorMsg);
        	}
            
        }
    });
}

var leader_id="";
function setLeaderDetail(obj){
	$('#leaderDetailModal').modal('show');
	leader_id=$(obj).parents("tr").find("#itemId").val();
	$.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        data: {"itemId":leader_id},
        url: "${pageContext.request.contextPath}/leaderOperationAction_getLeaderDetail",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){            	
				// 初始化编辑器的内容
    			editor.$txt.html(data.obj.detailInfo);
        	}
        	else{
        		alert(data.errorMsg);
        	}
        }
    });
}

function submitDetail(){
	//var note0 = $('.summernote').summernote('code');
    //var note0encode = htmlEncode(note0);
    //var html= htmlDecode(note0encode);
    var html = editor.$txt.html();
    console.log(html);
    var postParams={"leader_id":leader_id,
    				"detailInfo":html};
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        data: postParams,
        url: "${pageContext.request.contextPath}/leaderOperationAction_editLeaderDetailInfo",
        cache: false,
        success: function(data) {
        	if(data.retcode=="0000"){
        		alert("提交成功！");	
        		$('#leaderDetailModal').modal('hide');
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
</script>

</body></html>
