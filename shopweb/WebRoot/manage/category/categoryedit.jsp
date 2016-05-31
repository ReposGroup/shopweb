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
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="<%=basePath %>/admin/index.jsp" target="_parent">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="${pageContext.request.contextPath}/categoryAdmin_findAll.action">类别管理</a><span class="crumb-step">&gt;</span><span>添加类别</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/categoryAdmin_update.action" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <input type="hidden" name="categoryId" value="<s:property value="model.categoryId"/>" />
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>类别名称：</th>
                                <td>
                                    <input class="common-text required" id="cname" name="name" size="50" value="<s:property value="model.cname"/>" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>类别描述：</th>
                                <td><input class="common-text" name="cdesc" size="50" type="text" value="<s:property value="model.cdesc"/>"></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                   <input class="btn btn-primary btn6 mr10" value="确认" type="submit">
                                   <input class="btn btn-primary btn6 mr10" value="重置" type="reset">
                                   <input class="btn btn6" onClick="history.back(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
</html>