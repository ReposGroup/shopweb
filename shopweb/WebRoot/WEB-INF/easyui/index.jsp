<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<%@include file="/common/head.jspf" %>
  	<style type="text/css">
  		#menu{
  		width: 200px;
  		}
  		#menu ul{
  		list-style: none;
  		padding: 0px;
  		margin: 0px;
  		}
  		#menu ul li{
  		border-bottom: 1px solid #fff;
  		}
  		#menu ul li a{
  		display:block;
  		background-color: #008792;
  		color: #fff;
  		padding: 0px;
  		text-decoration: none;
  		font-size: 14px;
  		}
  		#menu ul li a:HOVER{
  		background-color: #00a6ac;
  		}
  		#topmenu{
  			width:100%;
  			height:100%;
  			background-color: #E8F1FF;
  		}
  	</style>
  	<script type="text/javascript">
  		$(function(){
  			$("a[title]").click(function(){
  				var text = $(this).text().substring(1);
  				var href = $(this).attr("title");
  				//1:判断当前是否有该tab,
  				if($("#tt").tabs("exists",text)){
  					//2:如果没有tab,则创建一个新的tab.否则切换到该tab.
  					$("#tt").tabs("select",text);
  				}else{
  					$("#tt").tabs("add",{
  						title:text,
  						closable:true,
  						//href:href
  						content:'<iframe src="'+href+'" frameborder="0" height="100%" width="100%"/>'
  					});
  				}
  			});
  		});
  	</script>
  </head>
  
<body class="easyui-layout">
    <div data-options="region:'north',title:'',split:true" style="height:45px;">
    	<div id="topmenu">
    		<div id="top"><font size="5px">欢迎来到易淘网站后台管理</font></div>
    	</div>
    </div>   
    <div data-options="region:'west',title:'系统菜单',split:true" style="width:200px">
    	<div id="menu" class="easyui-accordion" style="height:300px;width:200px"><!-- data-options="fit:true" --> 
		    <div title="常用操作">   
			    <ul>
			    	<li><a href="#" title="#"><i class="icon-font">&#xe008;</i>作品管理</a></li>
					<li><a href="#" title="#"><i class="icon-font">&#xe005;</i>博文管理</a></li>
					<li><a href="#" title="#"><i class="icon-font">&#xe006;</i>分类管理</a></li>
					<li><a href="#" title="#"><i class="icon-font">&#xe012;</i>评论管理</a></li>
			    	<li><a href="#" title="#"><i class="icon-font">&#xe004;</i>留言管理</a></li>
			    </ul>
		    </div><!--  data-options="iconCls:'icon-reload',selected:true" -->
		    <div title="系统管理">   
		        <ul>
			    	<li><a href="#" title="system_setting!list.action"><i class="icon-font">&#xe017;</i>系统设置</a></li>
					<li><a href="#" title="#"><i class="icon-font">&#xe021;</i>系统安全</a></li>
					<li><a href="#" title="#"><i class="icon-font">&#xe037;</i>清理缓存</a></li>
					<li><a href="#" title="#"><i class="icon-font">&#xe046;</i>数据备份</a></li>
					<li><a href="#" title="#"><i class="icon-font">&#xe045;</i>数据还原</a></li>
			    </ul>
		    </div>   
		    <div title="用户管理">   
		       <ul>
			    	<li><a href="#" title="user!list.action"><i class="icon-font">&#xe006;</i>用户列表</a></li>
					<li><a href="#" title="user!input.action"><i class="icon-font">&#xe026;</i>添加用户</a></li>
			    </ul>
		    </div>   
		    <div title="产品管理">   
		       <ul>
			    	<li><a href="#" title="product!list.action"><i class="icon-font">&#xe006;</i>产品列表</a></li>
					<li><a href="#" title="product!input.action"><i class="icon-font">&#xe026;</i>添加产品</a></li>
				
			    </ul>
		    </div>   
		    <div title="分类管理">   
		       <ul>
			    	<li><a href="#" title="#"><i class="icon-font">&#xe006;</i>分类列表</a></li>
					<li><a href="#" title="#"><i class="icon-font">&#xe026;</i>添加分类</a></li>
			    </ul>
		    </div>   
		    <div title="订单管理">   
		       <ul>
			    	<li><a href="#" title="#"><i class="icon-font">&#xe006;</i>订单列表</a></li>
					<li><a href="#" title="#"><i class="icon-font">&#xe026;</i>添加订单</a></li>
			    </ul>
		    </div>   
		</div>  
    </div>   
    <div data-options="region:'center',title:''" style="padding:2px;background:#E8F1FF;"><!-- #fff为白色 -->
    	<div id="tt" class="easyui-tabs" data-options="fit:true">   
		    <div title="系统缺省" style="padding:10px;">
		     	欢迎来到后台管理。
		    </div>   
		</div>  
    </div>   
    <div id="addupdate" data-options:"collapsible:false,minimizable:false,maximizable:false"/>
</body>  

</html>
