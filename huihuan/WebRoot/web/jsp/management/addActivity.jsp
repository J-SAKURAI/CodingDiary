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
    <meta name="description" content="高校户外联盟">

    <link rel="shortcut icon" href="favicon.ico" >
    <script src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/content.min.js-v=1.0.0.js" ></script>
    <script src="${pageContext.request.contextPath}/web/script/bootstrap-table.min.js" ></script>
    <script src="${pageContext.request.contextPath}/web/script/bootstrap-table-mobile.min.js" ></script>
    <script src="${pageContext.request.contextPath}/web/script/bootstrap-table-zh-CN.min.js" ></script>
    <script src="${pageContext.request.contextPath}/web/script/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/messages_zh.min.js"></script>
    
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/dist/css/wangEditor.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/dist/js/wangEditor.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/plupload/plupload.full.min.js"></script>

    <script src="${pageContext.request.contextPath}/web/script/summernote.min.js"></script>
    <script src="${pageContext.request.contextPath}/web/script/summernote-zh-CN.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/script/jquery.datetimepicker.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/management_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/bootstrap.min.css-v=3.3.6.css">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/style.min.css-v=4.1.0.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/bootstrap-table.css">
    
    <link href="${pageContext.request.contextPath}/web/css/jquery.datetimepicker.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/web/jquery-Upload/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
  	<script src="${pageContext.request.contextPath}/web/jquery-Upload/js/fileinput.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/web/jquery-Upload/js/fileinput_locale_zh.js" type="text/javascript"></script>
  	<link href="${pageContext.request.contextPath}/web/css/uploadfile.css" rel="stylesheet" type="text/css" /> 
	<style>
	.form-group {
		margin-bottom: 10px;
	}
	</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="ibox float-e-margins">
            <div class="ibox-content">
                <div class="row row-lg">
                    <div class="col-sm-2"><a class="btn btn-primary" href="${pageContext.request.contextPath}/web/jsp/management/activities.jsp">返回</a></div>
                    <div class="col-sm-12">

                        <div class="ibox float-e-margins">
                            
                            <div class="ibox-content">
                                <div class="form-horizontal m-t" id="formid">
     
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">主图：</label>
                                        <div class="col-sm-10">
                                            <input id="main_pic" type="file" name="image">
                                            <span class="help-block m-b-none"><i class="fa fa-info-circle"></i>用于显示的图片1，最大10MB，支持jpg/gif</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">标题：</label>
                                        <div class="col-sm-10">
                                            <input id="title" class="form-control" type="text">
                                            <span class="help-block m-b-none"><i class="fa fa-info-circle"></i>活动标题，用于显示</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">活动开始日期：</label>
                                        <div class="col-sm-10">
                                            <input id="start_time" type="text" class="datetimepicker" onfocus="this.blur()" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">活动结束日期：</label>
                                        <div class="col-sm-10">
                                            <input id="end_time" type="text" class="datetimepicker" onfocus="this.blur()" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">报名截止时间：</label>
                                        <div class="col-sm-10">
                                            <input id="sign_up_end_time" type="text" class="datetimepicker1" onfocus="this.blur()" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">上车地点：</label>
                                        <div class="col-sm-10">
                                            <input id="meeting_place" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                            <span class="help-block m-b-none"><i class="fa fa-info-circle"></i>格式：xx/xx/xx（若为空则默认不需要上车地点）</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">集合时间：</label>
                                        <div class="col-sm-10">
                                            <input id="meeting_time" type="text" class="datetimepicker2" onfocus="this.blur()" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                    	<label class="col-sm-2 control-label">是否显示学校：</label>
                                    	<div class="col-sm-10">
                                    	<select id="display-school">
                                    		<option value="1">是</option>
                                    		<option value="0">否</option>
                                    	</select>
                                    	</div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">市场价格：</label>
                                        <div class="col-sm-10">
                                            <input id="original_price" name="c_total_amount" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">实际价格：</label>
                                        <div class="col-sm-10">
                                            <input id="off_price" name="c_actual_amount" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">目的地：</label>
                                        <div class="col-sm-10">
                                            <input id="destination" name="c_total_amount" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">费用构成：</label>
                                        <div class="col-sm-10">
                                            <input id="cost_component" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">活动种类：</label>
                                        <div class="col-sm-10" id="type">
                                        	<a class='fa fa-plus' onclick="add(this)"></a>
                                            
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">确定出行人数：</label>
                                        <div class="col-sm-10">
                                            <input id="out_people" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">最大报名人数：</label>
                                        <div class="col-sm-10">
                                            <input id="max_people" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">参与人数：</label>
                                        <div class="col-sm-10">
                                            <input id="attendance" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-sm-2 control-label">描述1：</label>
                                        <div class="col-sm-10">
                                            <input id="description1" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>                                   
                                    </div>
                                     <div class="form-group">
                                        <label class="col-sm-2 control-label">描述2：</label>
                                        <div class="col-sm-10">
                                            <input id="description2" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-sm-2 control-label">描述3：</label>
                                        <div class="col-sm-10">
                                            <input id="description3" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">标签1：</label>
                                        <div class="col-sm-10">
                                            <input id="tag1" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">标签2：</label>
                                        <div class="col-sm-10">
                                            <input id="tag2" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">标签3：</label>
                                        <div class="col-sm-10">
                                            <input id="tag3" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">活动装备：</label>
                                        <div class="col-sm-10" id="equipment">
                                            <a class='fa fa-plus' onclick="add(this)"></a>
                                            
                                        </div>
                                        
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">奖励选项：</label>
                                        <div class="col-sm-10" id="reward">
                                            <a class='fa fa-plus' onclick="add(this)"></a>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">活动领队：</label>
                                        <div class="col-sm-10" id="leader">
                                           <a class='fa fa-plus' onclick="add(this)"></a>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">农家选择：</label>
                                        <div class="col-sm-10" id="peasant">
                                            <a class='fa fa-plus' onclick="add(this)"></a>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">车辆选择：</label>
                                        <div class="col-sm-10" id="car">
                                            <a class='fa fa-plus' onclick="add(this)"></a>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">目的地：</label>
                                        <div class="col-sm-8">
                                            <div id="editor1" name="image" style="height:400px"></div>
                                            <input id="note0input" type="hidden" name="c_intro" value="$activityInfo->intro">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">详细行程：</label>
                                        <div class="col-sm-8">
                                            <div id="editor2" name="image" style="height:400px"></div>
                                            <input id="note0input" type="hidden" name="c_intro" value="$activityInfo->intro">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">推荐装备：</label>
                                        <div class="col-sm-8">
                                            <div id="editor3" name="image" style="height:400px"></div>
                                            <input id="note0input" type="hidden" name="c_intro" value="$activityInfo->intro">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">预定须知：</label>
                                        <div class="col-sm-8">
                                            <div id="editor4" name="image" style="height:400px"></div>
                                            <input id="note0input" type="hidden" name="c_intro" value="$activityInfo->intro">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-8 col-sm-offset-3">
                                            <button id="submitid" onclick="addActivity()">提交</button><!--type="submit"--><!--class="btn btn-primary"  -->
                                        </div>
                                    </div>
                                    <input type="hidden" id="currentsummerid"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2">&nbsp;</div>
                </div>
            </div>
        </div>
    </div>
    
    

    <script>
var editor1=new wangEditor('editor1'),editor2=new wangEditor('editor2'),editor3=new wangEditor('editor3'),editor4=new wangEditor('editor4');
$(document).ready(function() {
	
	
	/******************初始化主图上传控件******************/
	$("#main_pic").fileinput({
            'showCaption':true,
			'showUpload':false,
			'showRemove':true,
			'showPreview':false,
			'fileActionSettings':{ uploadIcon: '',uploadClass: style='VISIBILITY: hidden',},
			'previewFileType':'any',
			'allowedPreviewTypes':'text',
			'previewTemplates':'text',
			'maxFileCount':1, 
			'language': 'zh', //设置语言
			'uploadExtraData':{"is_main_pic":"1"},
            'uploadUrl':"${pageContext.request.contextPath}/activityOperationAction_execute", //上传的地址                   
            'allowedFileExtensions': ['jpg','gif'],//接收的文件后缀 
            'dropZoneEnabled': false,//是否显示拖拽区域 
            'enctype':'multipart/form-data', //表示允许同时上传的最大文件个数
            'uploadAsync':true,
            'initialPreviewShowDelete':true,
	 });	
	 /******************初始化主图上传控件结束******************/

	/******************初始化时间选择器******************/
	$('.datetimepicker').datetimepicker({
		yearOffset:0,
    	lang:'ch',
    	timepicker:false,
    	format:'Y/m/d',
    	formatDate:'d/m/Y'
	});	
	$('.datetimepicker1').datetimepicker({
		step: 5,
		lang:'ch'
	});
	$('.datetimepicker2').datetimepicker({
		step: 5,
		lang:'ch'
	});
	/******************初始化时间选择器结束******************/
	
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
        editor1.config.menus=['source','|','bold','underline','italic','strikethrough','eraser','forecolor','bgcolor','|','quote',
        'fontfamily','fontsize','head','unorderlist','orderlist','alignleft','aligncenter','alignright','|','link','unlink','table','emotion',
        '|','img','insertcode','|','undo','redo','fullscreen'];
		editor1.config.customUpload = true;  // 配置自定义上传
        editor1.config.customUploadInit = uploadInit;  // 配置上传事件
        editor1.create();
        editor2.config.menus=['source','|','bold','underline','italic','strikethrough','eraser','forecolor','bgcolor','|','quote',
        'fontfamily','fontsize','head','unorderlist','orderlist','alignleft','aligncenter','alignright','|','link','unlink','table','emotion',
        '|','img','insertcode','|','undo','redo','fullscreen'];
        editor2.config.customUpload = true;  // 配置自定义上传
        editor2.config.customUploadInit = uploadInit;  // 配置上传事件
        editor2.create();
        editor3.config.menus=['source','|','bold','underline','italic','strikethrough','eraser','forecolor','bgcolor','|','quote',
        'fontfamily','fontsize','head','unorderlist','orderlist','alignleft','aligncenter','alignright','|','link','unlink','table','emotion',
        '|','img','insertcode','|','undo','redo','fullscreen'];
        editor3.config.customUpload = true;  // 配置自定义上传
        editor3.config.customUploadInit = uploadInit;  // 配置上传事件
        editor3.create();
        editor4.config.menus=['source','|','bold','underline','italic','strikethrough','eraser','forecolor','bgcolor','|','quote',
        'fontfamily','fontsize','head','unorderlist','orderlist','alignleft','aligncenter','alignright','|','link','unlink','table','emotion',
        '|','img','insertcode','|','undo','redo','fullscreen'];
        editor4.config.customUpload = true;  // 配置自定义上传
        editor4.config.customUploadInit = uploadInit;  // 配置上传事件
        editor4.create();
        
        editor1.$editorContainer.css('z-index', 20);
        editor2.$editorContainer.css('z-index', 15);
        editor3.$editorContainer.css('z-index', 5);
        editor4.$editorContainer.css('z-index', 1);
  });
    /******************初始化富文本编辑器结束******************/
    
    

           /* $("#submitid").click(function(){
                var note0 = $('.summernote').summernote('code');
                var note0encode = htmlEncode(note0);
                var html= htmlDecode(note0encode);
                //$('#note0input').val(note0);
                
                console.log(html);
                $("#formid").validate();
               //     $("#formid").submit();
            });*/
            
    function addActivity(){
    	var title=$("#title").val();
    	var start_time=$("#start_time").val();
    	var end_time=$("#end_time").val();
    	var sign_up_end_time=$("#sign_up_end_time").val();
    	var meeting_time=$("#meeting_time").val();
    	var meeting_places=$("#meeting_place").val();
    	var original_price=$("#original_price").val();
    	var off_price=$("#off_price").val();
    	var destination=$("#destination").val();	
    	var cost_component=$("#cost_component").val();
    	var max_people=$("#max_people").val();
    	var out_people=$("#out_people").val();
    	var attendance=$("#attendance").val();
    	var display_school=$("#display-school").val();
    	
    	var myDate = new Date();
    	var signupdate = new Date(Date.parse(sign_up_end_time));
    	if(signupdate<myDate){
    		alert("报名截止日期必须晚于当前时间，否则活动无法显示！");
    		return;
    	}
    	
        var html1= editor1.$txt.html();;
        var pre_html1=html1;
        
        var html2= editor2.$txt.html();;
        var pre_html2=html2;
        
        var html3= editor3.$txt.html();;
        var pre_html3=html3;
        
        var html4= editor4.$txt.html();;
        var pre_html4=html4;
        
        var description1=$("#description1").val();
        var description2=$("#description2").val();
        var description3=$("#description3").val();
        var tag1=$("#tag1").val();
        var tag2=$("#tag2").val();
        var tag3=$("#tag3").val();
        
    	var types=[];
    	$.each($("select[name='type']"), function(index, item) {
    				console.log($(item).val());
					types[index]=$(item).val();
		});
    	var equipments=[];
    	$.each($("select[name='equipment']"), function(index, item) {
					equipments[index]=$(item).val();
		});
    	var rewards=[];
    	$.each($("select[name='reward']"), function(index, item) {
					rewards[index]=$(item).val();
		});
    	var leaders=[];
    	$.each($("select[name='leader']"), function(index, item) {
					leaders[index]=$(item).val();
		});
    	var peasants=[];
    	$.each($("select[name='peasant']"), function(index, item) {
					peasants[index]=$(item).val();
		});
    	var cars=[];
    	$.each($("select[name='car']"), function(index, item) {
					cars[index]=$(item).val();
		});
		//对获得的富文本代码进行修改	
        /*var new_html="<div class='wrap-content' style='font-size: 24px; margin-top: 0px;'>";
        new_html+="<div class='content-slide about' style=\"height: auto; font-family: Arial,'Microsoft YaHei'; color: #999;\">";
        new_html+="<a name='des' class='point'></a>";
        html=html.replace("<p>目的地</p>",new_html);
        html=html.replace("<p>详细行程</p>","</div><div class='content-slide content-new trip' style=\"height: auto; font-family:Arial, 'Microsoft YaHei'; color: #999;\"><a name='drive' class='point'></a>");
        html=html.replace("<p>推荐装备</p>","</div><div class='content-slide content-new equip' style=\"height: auto; font-family: Arial,'Microsoft YaHei'; color: #999;\"><a name='equip' class='point'></a>");
        html=html.replace("<p>预定须知</p>","</div><div class='content-slide content-new book' style=\"height: auto; font-family: Arial, 'Microsoft YaHei'; color: #999;\"><a name='book' class='point'></a>");
        html=html.replace(/<p><img/g, "<img");
        html=html.replace(/<p><br><\/p>/g, "<br>");
        html=html.replace(/<p>/g, "<br>");
        html=html.replace(/<\/p>/g, "");
        html=html.replace(/<\/a><br>/g, "</a>");
        html+="</div></div>";*/
		var data = new FormData();
		data.append("image", $("#main_pic")[0].files[0]);
		data.append("title", title);
		data.append("start_time", start_time);
		data.append("end_time", end_time);
		data.append("sign_up_end_time", sign_up_end_time);
		data.append("meeting_time", meeting_time);
		data.append("meeting_places", meeting_places);
		data.append("original_price", original_price);
		data.append("off_price", off_price);
		data.append("destination", destination);
		data.append("cost_component", cost_component);
		data.append("types", types);
		data.append("description1", description1);
		data.append("description2", description2);
		data.append("description3", description3);
		data.append("tag1", tag1);
		data.append("tag2", tag2);
		data.append("tag3", tag3);
		data.append("max_people", max_people);
		data.append("out_people", out_people);
		data.append("display_school", display_school);
		data.append("attendance", attendance);
		data.append("equipments", equipments);
		data.append("rewards", rewards);
		data.append("leaders", leaders);
		data.append("peasants", peasants);
		data.append("cars", cars);
		data.append("content1", html1);
		data.append("content2", html2);
		data.append("content3", html3);
		data.append("content4", html4);
		data.append("pre_html1", pre_html1);
		data.append("pre_html2", pre_html2);
		data.append("pre_html3", pre_html3);
		data.append("pre_html4", pre_html4);
		
		$.ajax({
        type: "post",
        async: true,
        traditional: true,
        dataType: "json",
        //收受数据格式
        data: data,
        url: "${pageContext.request.contextPath}/activityOperationAction_addActivity",
        cache: false,
        processData: false,
    	contentType: false,
        success: function(data) {
            if(data.retcode=="0000"){
        		alert("添加成功！");
        		window.location.href="${pageContext.request.contextPath}/web/jsp/management/activities.jsp";
        	}
        	else{
        		alert(errorMsg);
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
        
function add(obj){
	var type=$(obj).closest("div").attr("id");
	var url="";
	if(type=="equipment"){
		url="Equipments";
	}
	if(type=="reward"){
		url="Rewards";
	}
	if(type=="peasant"){
		url="PeasantFamilies";
	}
	if(type=="leader"){
		url="Leaders";
	}
	if(type=="car"){
		url="Cars";
	}
	$(obj).remove();
	if(type=="type"){
		var html="<select name='type'><option value='0'>请选择</option>";                          
        html+="<option value='1'>轻装（农家）</option><option value='2'>重装（露营）</option>"; 
        html+="<option value='3'>水线</option><option value='4'>长线</option>";
        html+="<option value='5'>技术路线</option><option value='6'>单日活动</option>";
        html+="<option value='7'>市内活动</option><option value='8'>初体验</option>";
        html+="<option value='9'>特价</option></select><a class='fa fa-remove' onclick='removeItem(this)'></a><a class='fa fa-plus' onclick='add(this)'></a>";
        $("#type").append(html);
        return;
	}
	$.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/activityOperationAction_get"+url,
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){
            	var html="<select name='"+type+"'><option value='0'>请选择</option>";
        		$.each(data.obj,function(index, item) {
        			if(type=="car"){
        				html+="<option value="+item.id+">"+item.linkmanName+"~"+item.carType+"</option>";
        			}
        			else{
        				html+="<option value="+item.id+">"+item.name+"</option>"; 
        			}        			                                			
        		});
        		html+="</select><a class='fa fa-remove' onclick='removeItem(this)'></a><a class='fa fa-plus' onclick='add(this)'></a>";
        		$("#"+type).append(html);
        	}
        	else{
        		showMessage(data.errorMsg);
        	}
        }
    });
}

function removeItem(obj){
	$(obj).prev().remove();
	$(obj).remove();
}


/******************初始化下拉框******************/
/*	//奖励
	$.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/activityOperationAction_getRewards",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){
            	var html="<select name='reward'><option value='0'>请选择</option>";
        		$.each(data.obj,function(index, item) {
        			html+="<option value="+item.id+">"+item.name+"</option>";                                 			
        		});
        		html+="</select>";
        		$("#reward").append(html);
        	}
        	else{
        		showMessage(data.errorMsg);
        	}
        }
    });
    
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/activityOperationAction_getPeasantFamilies",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){
            	var html="<select name='peasant'><option value='0'>请选择</option>";
        		$.each(data.obj,function(index, item) {
        			html+="<option value="+item.id+">"+item.linkmanName+"</option>";                                 			
        		});
        		$("#peasant").append(html);
        	}
        	else{
        		showMessage(data.errorMsg);
        	}
        }
    });
    
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/activityOperationAction_getEquipments",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){
            	var html="<select name='equipment'><option value='0'>请选择</option>";
        		$.each(data.obj,function(index, item) {
        			html+="<option value="+item.id+">"+item.name+"</option>";                                 			
        		});
        		$("#equipment").append(html);
        	}
        	else{
        		showMessage(data.errorMsg);
        	}
        }
    });
    
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/activityOperationAction_getLeaders",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){
            	var html="<select name='leader'><option value='0'>请选择</option>";
        		$.each(data.obj,function(index, item) {
        			html+="<option value="+item.id+">"+item.name+"</option>";                                 			
        		});
        		$("#leader").append(html);
        	}
        	else{
        		showMessage(data.errorMsg);
        	}
        }
    });
    
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        //收受数据格式
        url: "${pageContext.request.contextPath}/activityOperationAction_getCars",
        cache: false,
        success: function(data) {
            if(data.retcode=="0000"){
            	var html="<select name='car'><option value='0'>请选择</option>";
        		$.each(data.obj,function(index, item) {
        			html+="<option value="+item.id+">"+item.licenseNum+"</option>";                                 			
        		});
        		$("#car").append(html);
        	}
        	else{
        		showMessage(data.errorMsg);
        	}
        }
    });*/
	/******************初始化下拉框结束******************/
    </script>
</body>
</html>

