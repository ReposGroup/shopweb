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
         <div class="crumb-list"><i class="icon-font">&#xe06b;</i>
		 	<span>欢迎使用『网上商城后台管理』，建系的首选工具。</span>
		 </div>
     </div>
     <div class="result-wrap">
         <div class="result-title">
             <h1>快捷操作</h1>
         </div>
         <div class="result-content">
             <div class="short-wrap">
                 <a href="#"><i class="icon-font">&#xe001;</i>新增作品</a>
                 <a href="#"><i class="icon-font">&#xe005;</i>新增商场</a>
                 <a href="#"><i class="icon-font">&#xe048;</i>新增作品分类</a>
                 <a href="#"><i class="icon-font">&#xe041;</i>新增商场分类</a>
                 <a href="#"><i class="icon-font">&#xe01e;</i>作品评论</a>
             </div>
         </div>
     </div>
     <div class="result-wrap">
         <div class="result-title">
             <h1>系统基本信息</h1>
         </div>
         <div class="result-content">
             <ul class="sys-info-list">
                 <li>
                     <label class="res-lab">操作系统</label><span class="res-info">WINNT</span>
                 </li>
                 <li>
                     <label class="res-lab">运行环境</label><span class="res-info">Apache/2.2.21 (Win64) PHP/5.3.10</span>
                 </li>
                 <li>
                     <label class="res-lab">PHP运行方式</label><span class="res-info">apache2handler</span>
                 </li>
                 <li>
                     <label class="res-lab">静静设计-版本</label><span class="res-info">v-0.1</span>
                 </li>
                 <li>
                     <label class="res-lab">上传附件限制</label><span class="res-info">2M</span>
                 </li>
                 <li>
                     <label class="res-lab">北京时间</label><span class="res-info">2015年10月1日 08:08:08</span>
                 </li>
                 <li>
                     <label class="res-lab">服务器域名/IP</label><span class="res-info">localhost [ 127.0.0.1 ]</span>
                 </li>
                 <li>
                     <label class="res-lab">Host</label><span class="res-info">127.0.0.1</span>
                 </li>
             </ul>
         </div>
     </div>
     <div class="result-wrap">
         <div class="result-title">
             <h1>使用帮助</h1>
         </div>
         <div class="result-content">
             <ul class="sys-info-list">
                 <li>
                     <label class="res-lab">官方交流网站：</label><span class="res-info"><a href="http://www.baidu.com" title="" target="_blank">ambow.isme</a></span>
                 </li>
                 <li>
                     <label class="res-lab">官方交流QQ群：</label><span class="res-info"><a class="qq-link" target="_blank" href="http://shang.qq.com/wpa/qunwpa?idkey=4ba39c297a33fa548de56a257f6128c7c9e3dd14473e4c86557d93f2197c33e8"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="JS-前端开发" title="JS-前端开发"></a></span>
                 </li>
             </ul>
         </div>
     </div>
</div>
</body>
</html>
