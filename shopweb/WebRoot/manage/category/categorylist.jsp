<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
	<script type="text/javascript" language="javascript">
	function selectAll(){ 
		var a = document.getElementsByName('checked'); 
		var b = document.getElementById('checkAll').value; 
		for(var i =0;i<a.length;i++){ 
			if((a[i].type=='checkbox') && (b == "全选")){ 
				a[i].checked="checked"; 
				document.getElementById('checkAll').value = "全不选"; 
			}else{ 
				a[i].checked=""; 
				document.getElementById('checkAll').value = "全选"; 
			} 
			} 
		}
	</script> 
</head>
<body>
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="<%=basePath %>/admin/index.jsp" target="_parent">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">类别管理</span></div>
        </div>
       <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="${pageContext.request.contextPath}/categoryAdmin_addPage.action"><i class="icon-font"></i>新增类别</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><label><input id="checkAll" name="checkAll" type="checkbox" value="全选" onclick="selectAll()"/>全选</label></th>
                            <th>序号</th>
                            <th>ID</th>
                            <th>类别名称</th>
                            <th>描述</th>
                            <th>操作</th>
                        </tr>
                        <s:iterator var="cate" value="clist" status="status">
                        <tr>
                            <td class="tc"><input id="checked" name="checked" value="59" type="checkbox"></td>
                            <td>
                                <input name="ids[]" value="59" type="hidden">
                              <s:property value="#status.count"/>
                            </td>
                            <td><s:property value="#cate.categoryId"/></td>
                            <td title="衣服"><a target="mainFrame" href="#" title="衣服"><s:property value="#cate.cname"/></a></td>
                            <td><s:property value="#cate.cdesc"/></td>
                            <td>
                                <a class="link-update" href="${pageContext.request.contextPath}/categoryAdmin_edit.action?categoryId=<s:property value="#cate.categoryId"/>">修改</a>
                                <a class="link-del" href="${pageContext.request.contextPath}/categoryAdmin_delete.action?categoryId=<s:property value="#cate.categoryId"/>">删除</a>
                            </td>
                        </tr>
                        </s:iterator>	
                    </table>
                    <div class="list-page"> 3 条 1/1 页</div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>