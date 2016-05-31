<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>『网上商城』后台管理</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/css/main.css"/>
    <script type="text/javascript" src="<%=basePath %>/js/libs/modernizr.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/libs/jquery-1.6.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/libs/menu.js"></script>
</head>
<body>
<div class="sidebar-wrap">
	<div class="sidebar-title">
		<font style=" font-style: italic"><i class="icon-font">&#xe053;</i>菜单</font>
	</div>
	<div class="sidebar-content">
		<ul class="sidebar-list">
			<li>
				<a href="#" class="icon"><i class="icon-font">&#xe003;</i>常用操作</a>
				<ul class="sub-menu main">
					<li><a href="system/design.jsp" target="mainFrame"><i class="icon-font">&#xe008;</i>作品管理</a></li>
					<li><a href="system/design.jsp" target="mainFrame"><i class="icon-font">&#xe005;</i>博文管理</a></li>
					<li><a href="system/design.jsp" target="mainFrame"><i class="icon-font">&#xe006;</i>分类管理</a></li>
					<li><a href="system/design.jsp" target="mainFrame"><i class="icon-font">&#xe004;</i>留言管理</a></li>
					<li><a href="system/design.jsp" target="mainFrame"><i class="icon-font">&#xe012;</i>评论管理</a></li>
				</ul>
			</li>
			<li>
				<a href="#" class="icon"><i class="icon-font">&#xe018;</i>系统管理</a>
				<ul class="sub-menu">
					<li><a href="system/system.jsp" target="mainFrame"><i class="icon-font">&#xe017;</i>系统设置</a></li>
					<li><a href="system/system.jsp" target="mainFrame"><i class="icon-font">&#xe021;</i>系统安全</a></li>
					<li><a href="system/system.jsp" target="mainFrame"><i class="icon-font">&#xe037;</i>清理缓存</a></li>
					<li><a href="system/system.jsp" target="mainFrame"><i class="icon-font">&#xe046;</i>数据备份</a></li>
					<li><a href="system/system.jsp" target="mainFrame"><i class="icon-font">&#xe045;</i>数据还原</a></li>
				</ul>
			</li>
			<li>
				<a href="#" class="icon"><i class="icon-font">&#xe014;</i>用户管理</a>
				<ul class="sub-menu">
					<li><a href="${pageContext.request.contextPath}/userAdmin_findAll.action" target="mainFrame"><i class="icon-font">&#xe006;</i>用户列表</a></li>
					<li><a href="${pageContext.request.contextPath}/userAdmin_addPage.action" target="mainFrame"><i class="icon-font">&#xe026;</i>添加用户</a></li>
				</ul>
			</li>
			<li>
				<a href="#" class="icon"><i class="icon-font">&#xe050;</i>产品管理</a>
				<ul class="sub-menu">
					<li><a href="${pageContext.request.contextPath}/productAdmin_findAll.action" target="mainFrame"><i class="icon-font">&#xe006;</i>产品列表</a></li>
					<li><a href="${pageContext.request.contextPath}/productAdmin_addPage.action" target="mainFrame"><i class="icon-font">&#xe026;</i>添加产品</a></li>
				</ul>
			</li>
			<li>
				<a href="#" class="icon"><i class="icon-font">&#xe055;</i>分类管理</a>
				<ul class="sub-menu">
					<li><a href="${pageContext.request.contextPath}/categoryAdmin_findAll.action" target="mainFrame"><i class="icon-font">&#xe006;</i>分类列表</a></li>
					<li><a href="${pageContext.request.contextPath}/categoryAdmin_addPage.action" target="mainFrame"><i class="icon-font">&#xe026;</i>添加分类</a></li>
				</ul>
			</li>
			<li>
				<a href="#" class="icon"><i class="icon-font">&#xe051;</i>订单管理</a>
				<ul class="sub-menu">
					<li><a href="system/orders.jsp" target="mainFrame"><i class="icon-font">&#xe006;</i>订单列表</a></li>
					<li><a href="system/orders.jsp" target="mainFrame"><i class="icon-font">&#xe026;</i>添加订单</a></li>
				</ul>
			</li>
		</ul>
	</div>
</div>
</body>
</html>
