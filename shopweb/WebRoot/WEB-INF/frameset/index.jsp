<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>『网上商城』后台管理</title>
</head>
<frameset rows="50px,*" frameborder="0" framespacing="100">
	<frame src="${pageContext.request.contextPath}/admin/head.jsp" frameborder="0" scrolling="no" noresize="noresize">
	<frameset cols="190px,*" >
		<frame src="${pageContext.request.contextPath}/admin/left.jsp" frameborder="0" scrolling="no" noresize="noresize">
		<frame src="${pageContext.request.contextPath}/admin/main.jsp" frameborder="1" scrolling="yes" noresize="noresize" name="mainFrame">
	</frameset>
</frameset>
</html>
