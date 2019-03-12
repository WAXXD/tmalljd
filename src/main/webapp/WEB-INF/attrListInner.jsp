<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>属性列表内嵌页</title>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>


</head>
<body>

	<c:forEach items="${list_attr }" var="attr">
		${attr.shxm_mch }: 
		<c:if test="${not empty attr.list_value}">
			<c:forEach items="${attr.list_value }" var="val">
				${val.shxzh }${val.shxzh_mch }
			</c:forEach>
			<br>
		</c:if>
	</c:forEach>
</body>
</html>