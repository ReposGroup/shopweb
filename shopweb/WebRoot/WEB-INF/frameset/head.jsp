<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.jsp">首页</a></li>
                <li><a href="index.jsp" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
			    <span>Hi,您好~</span>
			    <s:if test="#session.admin == null">
                <li><a href="login.jsp" target="_blank">登陆</a></li>
                <li><a href="#">热门话题</a></li>
                <li><a href="#">生活服务</a></li>
                <li><a href="${pageContext.request.contextPath }/adminUser_quit.action" target="mainFrame"></a></li>
                </s:if>
                <s:else>
                <li><a href="#"><s:property value="#session.admin.userName"/></a></li>
                <li><a href="#">会员中心</a></li>
                <li><a href="#">修改密码</a></li>
                <li><a href="${pageContext.request.contextPath }/adminUser_exit.action" target="ablank">退出</a></li>
                </s:else>
            </ul>
        </div>
    </div>
</div>
</body>
</html>