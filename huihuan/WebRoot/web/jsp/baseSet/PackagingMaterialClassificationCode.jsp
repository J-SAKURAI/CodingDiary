<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
                <img src="../image/HideToolBar.png" alt="隐藏目录" id="hideTool">
                <div class="row breadcrumb-row">
                    <ol class="breadcrumb">
                        <li><a href="#">首页</a></li>
                        <li><a href="#">基础设施</a></li>
                        <li><a href="#">分类编码设置</a></li>
                        <li class="active">包装材料分类编码</li>
                    </ol>
                </div>
                
                <div class="row wrapper">
                    <div class="set-row">
                        <label for="">包装材料分类：</label>
                        <select name="catagorisSelect" id="catagorisSelect" onchange="selectCatagory(this.value)" class="form-control">
                        </select>
                    </div>
                </div>


                <div class="row wrapper sortcode-row">
                    <div class="row sortcode-info-row">
                        <label>编码的第<span id="catagoryBit"></span>位：</label><label id="catagoryExample"><span class="choose-red"></span></label>
                        <a class="btn-add" onclick="addCatagoryDetail()"><img src="../image/add.png" alt="增加" class="btn-img"></a>
                    </div>
                    <div class="row table-row">
                        <table class="table sort-table table-striped">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>分类编码</th>
                                    <th>分类名称</th>
                                    <th>操作</th>
                                </tr>
                           </thead>
                           <tbody id="catagoryDetailTbody">
                                
                           </tbody>
                        </table>
                    </div>

            </div>
        </div>
  </body>
</html>
<script type="text/javascript">

	var isInserting=0;
	var catagorys;
	var catagoryLength=0;
	
	$(function() {
		var postParam = {
			"type" : 3
		};
		$.getJSON('${pageContext.request.contextPath}/catagoryAction_getCatagories',postParam, function(data, status) {
			if(data.retcode=="0000"){
				catagorys=data.obj;
				var addHtml = "";
				//显示层绑定控件
				$.each(data.obj, function(index, item) {
					if(item.id!=null&&item.id!=""){
						addHtml+="<option value='"+item.id+"' rmk='"+item.rmk+"'>"+item.name+"</option>";
					}
				});
				$("#catagorisSelect").empty().append(addHtml).trigger("create");
				var catagoryId=$("#catagorisSelect option:selected").val();
				selectCatagory(catagoryId);
			}
		});
		
	})
	function selectCatagory(catagoryId){
		var catagoryBit="";
		var catagoryExample="";
		var bit=0;
		$.each(catagorys, function(index, item) {
			if(catagoryId==item.id){
				catagoryLength=0;
				for(i=0;i<item.length;i++){
					catagoryLength++;
					bit+=1;
					catagoryExample+="<span class='choose-red'>X</span>";
					if(i==item.length-1){
						catagoryBit+=bit;
					}else{
						catagoryBit+=bit+",";
					}
				}
			}else{
				bit+=item.length;
				for(i=0;i<item.length;i++){
					catagoryExample+="X";
				}
			}
		});
		$("#catagoryBit").text(catagoryBit);
		$("#catagoryExample").html(catagoryExample);
		var postParam = {
				"catagoryId" : catagoryId
			};
		$.getJSON('${pageContext.request.contextPath}/catagoryAction_getCatagoryDetails',postParam, function(data, status) {
			if(data.retcode=="0000"){
				var addHtml = "";
				//显示层绑定控件
				$.each(data.obj, function(index, item) {
					addHtml+="<tr id='tr"+item.id+"'>"+
					"<td>"+(index+1)+"</td>"+
					"<td id='catagoryCd"+item.id+"'>"+item.code+"</td>"+
					"<td id='name"+item.id+"' class='text-left'>"+item.name+"</td>"+
					"<td id='button"+item.id+"'>"+
					"<a class='btn-operation' onclick='editCatagoryDetail("+item.id+")'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a>";
					if(index==data.obj.length-1){
						addHtml+="<a class='btn-operation' onclick='deleteCatagoryDetail("+item.id+")'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></a>";
					}
					addHtml+="</td></tr>";
				});
				$("#catagoryDetailTbody").empty().append(addHtml).trigger("create");
				isInserting=0;
			}
		});
	}
	
	function addCatagoryDetail(){
		if(isInserting == 1){
			return false;
		}
		var addHtml="<tr>"+
					"<td>"+($("#catagoryDetailTbody tr").length+1)+"</td>"+
					"<td><input id='catagoryCd' type='text' class='form-control' value='"+((Array(catagoryLength).join('0') + $("#catagoryDetailTbody tr").length).slice(-catagoryLength))+"' disabled='disabled'></td>"+
					"<td><input id='thename' type='text' class='form-control'></td>"+
					"<td>"+
					"<a class='btn-operation' onclick='submitAdd()' title=’编辑‘><span class='glyphicon glyphicon-ok-circle' aria-hidden='true'></span></a>"+
					"<a class='btn-operation' onclick='cancleAdd(this)' title=’删除‘><span class='glyphicon glyphicon-remove-circle' aria-hidden='true'></span></a>"+
					"</td>"+
					"</tr>";
		$("#catagoryDetailTbody").append(addHtml);
		isInserting=1;
	}
	
	function cancleAdd(obj){
		$(obj).parent().parent().remove();
		isInserting=0;
	}
	
	function submitAdd(){
		var catagoryId=$("#catagorisSelect  option:selected").val();
		var postParam = {
			"catagoryId" : catagoryId,
			"catagoryCd" : $("#catagoryCd").val(),
			"name" : $("#thename").val()
		};
		if ($("#thename").val()=="")
		{
			alert("请输入分类名称");
			return;
		}
		else
		{
			$.ajax({
				type: "post",
				data:postParam,
				dataType:"json", //收受数据格式
				url:"${pageContext.request.contextPath}/catagoryAction_addCatagoryDetail",
				cache:false,
				success: function(data){
					if(data.retcode=="0000"){
						isInserting=0;
						selectCatagory(catagoryId);
					}
					else
					{
						alert(data.errorMsg);
					}
				}
			});
		}
	}
	
	function deleteCatagoryDetail(catagoryDetailId){
		var catagoryId=$("#catagorisSelect  option:selected").val();
		var postParam = {
			"catagoryDetailId" : catagoryDetailId
		};
		$.ajax({
			type: "post",
			data:postParam,
			dataType:"json", //收受数据格式
			url:"${pageContext.request.contextPath}/catagoryAction_deleteCatagoryDetail",
			cache:false,
			success: function(data){
				if(data.retcode=="0000"){
					isInserting=0;
					selectCatagory(catagoryId);
				}
				else
				{
					alert(data.errorMsg);
				}
			}
		});
	}
	
	function editCatagoryDetail(catagoryDetailId){
		var name=$("#name"+catagoryDetailId).text();
		addHtml="<input id='name"+catagoryDetailId+"' type='text' value='"+name+"' class='form-control'>";
		$("#name"+catagoryDetailId).empty().append(addHtml).trigger("create");
		addHtml="<a class='btn-operation' onclick='submitEdit("+catagoryDetailId+")'><span class='glyphicon glyphicon-ok-circle' aria-hidden='true'></span></a>"+
					"<a class='btn-operation' onclick='cancleEdit("+catagoryDetailId+")'><span class='glyphicon glyphicon-remove-circle' aria-hidden='true' ></span></a>";
		$("#button"+catagoryDetailId).empty().append(addHtml).trigger("create");
	}
	
	function cancleEdit(catagoryDetailId){
		var name=$("#name"+catagoryDetailId+" input").val();
		addHtml=name;
		$("#name"+catagoryDetailId).empty().append(addHtml).trigger("create");
		addHtml="<a class='btn-operation' onclick='editCatagoryDetail("+catagoryDetailId+")'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a>";
		var index = $("#tr"+catagoryDetailId).find("td")[0].innerText;
		if (index == $("#catagoryDetailTbody").find("tr").length)
		{
			
				addHtml+="<a class='btn-operation' onclick='deleteCatagoryDetail("+catagoryDetailId+")'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></a>";
		}
		$("#button"+catagoryDetailId).empty().append(addHtml).trigger("create");
	}
	
	function submitEdit(catagoryDetailId){

		var catagoryCd=$("#catagoryCd"+catagoryDetailId).contents().text()
		var name=$("#name"+catagoryDetailId+" input").val();
		if (name == ""){
			
			alert("请输入分类名称");
			return;
		}
		else{
			var postParam = {
				"catagoryDetailId" : catagoryDetailId,
				"catagoryCd" : catagoryCd,
				"name" : name
			};
			$.ajax({
				type: "post",
				data:postParam,
				dataType:"json", //收受数据格式
				url:"${pageContext.request.contextPath}/catagoryAction_editCatagoryDetail",
				cache:false,
				success: function(data){
					if(data.retcode=="0000"){
						cancleEdit(catagoryDetailId);
					}
					else
					{
						alert(data.errorMsg);
					}
				}
			});
		}
	}
</script>