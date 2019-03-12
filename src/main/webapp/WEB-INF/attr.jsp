<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spu商品属性维护</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
</head>
<body>


	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',split:true" style="height:50px">
			<div style="margin-left: 10px;">
		 		 一级分类：<select id="attr_class_1_select" onchange="get_attr_class2(this.value);" ><option>请选择</option></select>
				二级分类：
				<!-- <select id="attr_class_2_select" onchange="get_attr_list(this.value);"><option>请选择<option></select> -->
				<select id="attr_class_2_select" class="easyui-combobox" data-options="width:100" onchange="get_attr_list_json(this.value);"><option>请选择<option></select>
				
				<a href="javascript:goto_attr_add();">添加</a>
				
			</div>
			
	    </div>
	    <div data-options="region:'west',split:true" style="width:100px">
	              	
			<a href="#">查询</a><br>
			<a href="#">删除</a><br>
			<a href="#">编辑</a><br>
					
	    </div>
	    <div data-options="region:'center'">
			<div id="attrListInner" class="easyui-datagrid" style="width:800;">
			              	
			</div>
	    </div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
<script type="text/javascript">
	$(function() {
		/* $.getJSON("js/json/class_1.js", function(data) {
			$(data).each(
				function(i, json) {
					$("#attr_class_1_select").append("<option value="+json.id+">" + json.flmch1 + "</option>");
			});
		}); */
		
		$('#attr_class_1_select').combobox({
		    url:'js/json/class_1.js',
		    valueField:'id',
		    textField:'flmch1',
		    width:100,
		    onChange:function get_attr_class2() {
		    	var class_1_id = $(this).combobox("getValue");
				/* $.getJSON("js/json/class_2_"+class_1_id+".js", function(data) {
					$("#attr_class_2_select").empty();
					$(data).each(
							function(i, json) {$("#attr_class_2_select").append("<option value="+json.id+">" + json.flmch2 + "</option>");
					});
				}); */
		    	$('#attr_class_2_select').combobox({
		    	    url:'js/json/class_2_'+class_1_id+'.js',
		    	    valueField:'id',
		    	    textField:'flmch2',
		    	    onChange:function(){
		    	    	var class_2_id = $(this).combobox("getValue");
		    	    	get_attr_list_json(class_2_id);
		    	    }
		    	});
			}
		});
	});
	
	
	
	
	
	function goto_attr_add() {
		var class_id_2 = $('#attr_class_2_select').combobox("getValue");
		//window.location.href="goto_attr_add.do?flbh2="+class_id_2;
		add_tab("goto_attr_add.do?flbh2="+class_id_2,"添加属性");
	}
	
	function get_attr_list(class_2_id) {
		//AJAX
		$.post("get_attr_list.do",{flbh2:class_2_id},function(data){
			$("#attrListInner").html(data);
		});	
	}
	
	function get_attr_list_json(class_2_id){
		$('#attrListInner').datagrid({
		    url:'get_attr_list_json.do',
		    queryParams:{
		    	flbh2:class_2_id
		    } ,
		    columns:[[
		        {field:'id',title:'id',width:100},
		        {field:'shxm_mch',title:'属性名',width:100},
		        {field:'list_value',title:'属性值',width:300,
		        	formatter: function(value,row,index){
		        		var str = "";
						$(value).each(function(i,josn){
							str = str + josn.shxzh + josn.shxzh_mch + " ";
						});
						return str;
					}
		        },
		        {field:'chjshj',title:'创建时间',width:200,
		        	formatter: function(value,row,index){
		        		var time = new Date(value);
		        		var str = time.toLocaleString();
						return str;
					}
		        }
		    ]]
		});	
	}
</script>
	

</body>
</html>
















