<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

  <link href="${pageContext.request.contextPath}/web/jquery-Upload/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
  <script src="${pageContext.request.contextPath}/web/jquery-Upload/js/fileinput.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/web/jquery-Upload/js/fileinput_locale_zh.js" type="text/javascript"></script>
  <link href="${pageContext.request.contextPath}/web/css/uploadfile.css" rel="stylesheet" type="text/css" /> 

<div class="main-left" id="main-left">
<div class="upload-div">
<h4>请填写你要接收结果的邮箱：</h4>
<input id="mailaddress" type="text" class="form-control">
<button type="button" class="btn" id ="mailaddress" onclick="saveMailAddress()">保存</button>
<h4>请选择要上传的文件：</h4>
	<input id="photoUrl" type="file" name="image">
</div>
</div>
     

<div class="main-right" id="main-right">
    
    <div id="div-rigth">
    </div>
</div>
<script type="text/javascript">

$(function(){
        // dom加载完毕
        $.ajax({
			type : "post",
			async:false,
			dataType : "json", //收受数据格式
			url : "${pageContext.request.contextPath}/multiSearchAction_getMailAddress",
			cache : false,
			success : function(data) {
		      $("#mailaddress").val(data.obj);
			 }
		  });
    
});
$(document).ready(
     
      function() {
					 // $(document).attr("title","职员信息");
		  var mailaddress=$("#mailaddress").val();
          $("#photoUrl").fileinput({
            'showCaption':true,
			'showUpload':true,
			'showRemove':true,
			'showPreview':false,
			'fileActionSettings':{ uploadIcon: '',uploadClass: style='VISIBILITY: hidden',},
			'previewFileType':'any',
			'allowedPreviewTypes':'text',
			'previewTemplates':'text',
			'maxFileCount':1, 
			'language': 'zh', //设置语言
			'uploadExtraData':{"mailaddress":mailaddress},
            'uploadUrl':"${pageContext.request.contextPath}/multiSearchAction_uploadFile", //上传的地址                   
            'allowedFileExtensions': ['txt'],//接收的文件后缀 
            'dropZoneEnabled': false,//是否显示拖拽区域 
            'enctype':'multipart/form-data', //表示允许同时上传的最大文件个数
            'uploadAsync':true,
            'initialPreviewShowDelete':true,
	 });	
	 });
	 
function saveMailAddress(){
    var mailaddress=$("#mailaddress").val();
    var postParam = {
			  "mailaddress" : mailaddress,	      
    };
    $.getJSON('${pageContext.request.contextPath}/multiSearchAction_saveMailAddress',
						postParam, function(data) {	
						    if (data.retcode == "0000") {
							    alert("保存成功！"); 
						    }else{
							    alert(data.errorMsg);
						    }
		  });
		  		 
}
 </script>