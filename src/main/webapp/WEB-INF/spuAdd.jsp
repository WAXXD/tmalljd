<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>SPU商品添加</title>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
	function click_image(index) {
		$("#file_" + index).click();

	}

	function replace_image(index) {
		var blob_image = $("#file_" + index)[0].files[0];
		var url = window.URL.createObjectURL(blob_image);
		$("#image_" + index).attr("src", url);
		
		var length = $(":file").length;
		if((length == (index+1)) && length < 5){
			add_image(index);
		}
	}

	function add_image(index) {
		var a = '<div id="d_' + (index + 1) + '" style="float:left;margin-left: 10px;border:2px red solid;" ">';
		var b = '<input id="file_'
				+ (index + 1)
				+ '" type="file" name="files" style="display: none;" onchange="replace_image('
				+ (index + 1) + ');">'
		var c = '<img id="image_'
				+ (index + 1)
				+ '" onclick="click_image('
				+ (index + 1)
				+ ')" style="cursor: pointer;" src="image/upload_hover.png" width="80px" height="80px"/>';
		var d = '</div>';
		$("#d_" + index).after(a + b + c + d);
	}
</script>
</head>
<body>
	SPU添加信息${spu.flbh1}|${spu.flbh2}|${spu.pp_id}
	<hr>
	<form action="spu_add.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="flbh1" value="${spu.flbh1}" /> <input
			type="hidden" name="flbh2" value="${spu.flbh2}" /> <input
			type="hidden" name="pp_id" value="${spu.pp_id}" /> 商品名称：<input
			name="shp_mch" type="text" /><br> 商品描述：
		<textarea name="shp_msh" rows="10" cols="50"></textarea>
		<br> 商品图片：<br><br>
		<div id="d_0" style="float: left;margin-left: 10px;">
			<input id="file_0" type="file" name="files" style="display:none;"
				onchange="replace_image(0);"> 
				<img id="image_0" onclick="click_image(0)" style="cursor: pointer;border:1px red solid;" 
				src="image/upload_hover.png" height="80px" width="80px"  />
		</div>
		<br><br><br><br>
		<input type="submit" value="提交" />

	</form>
</body>
</html>