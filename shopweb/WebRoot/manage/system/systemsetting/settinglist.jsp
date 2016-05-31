<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<%@include file="/common/head.jspf" %>
  	<style type="text/css">
	.searchbox {
	  margin: -3;
	}
  	</style>
  	<script type="text/javascript">
  	$(function(){
  		$("#settingdg").datagrid({
  			//请求数据的URL地址
  			url:'system_setting!querydetail.action',
  			loadMsg:'请等待...',
  			rownumbers:true,//行号 
  			//queryParams:{type:''},
  			//指定id字段为标识字段,在更新或删除时，翻页时不会丢失数据
  			//idField:id,
  			//显示斑马线
  			striped:true,
  			//数据显示同行，默认为true
  			nowrap:true,
  			//自适应列，如果设置此属性，则不会出现水平滚动条，如果设置了冻结列，此项不用设置。
  			//fitColumns:true,
  			//单行显示，全选功能会失效
  			//singleSelect:true,
  			//设置分页
  			pagination:true,
  			pageSize:5,
  			pageList:[5,10,15],
  			//工具条(新增、补录、删除)
  			toolbar: [{
				iconCls: 'icon-add',
				text:'添加配置',
				handler: function(){
					//alert('添加配置');
					parent.$("#addupdate").window({
						title:'添加配置',
						width:500,
						height:600,
						content:'<iframe src="system_setting!input.action" frameborder="0" height="100%" width="100%"/>'
					});
				}
			},'-',{
				iconCls: 'icon-edit',
				text:'更新配置',
				handler: function(){
					//alert('更新按钮');
					//1.判断是否有选中行
					var rows = $("#settingdg").datagrid("getSelections");
					if(rows.length != 1){
					//弹出提示消息
						$.messager.show({
							title:'消息提示',
							msg:'一次只能更新一条记录！',
							timeout:2000,
							showType:'slide',
							style:{
								right:'',
								top:document.body.scrollTop+document.documentElement.scrollTop,
								bottom:''
							}
						});
					}else{
						//alert("更新配置");
						//1.弹出更新页面
						parent.$("#addupdate").window({
						title:'更新配置',
						width:500,
						height:600,
						content:'<iframe src="system_setting!input.action" frameborder="0" height="100%" width="100%"/>'
					});
					}
				}
			},'-',{
				iconCls: 'icon-remove',
				text:'删除配置',
				handler: function(){
					//alert('删除按钮');
					//1.判断是否有选中行
					var rows = $("#settingdg").datagrid("getSelections");
					//rows 返回被选中的行，没有的话，返回空数组。
					if(rows.length == 0){
						//弹出提示消息
						$.messager.show({
							title:'消息提示',
							msg:'至少选中一条记录',
							timeout:2000,
							showType:'slide',
							style:{
								right:'',
								top:document.body.scrollTop+document.documentElement.scrollTop,
								bottom:''
							}
						});
					}else{
					//提示是否确认删除
						$.messager.confirm('消息提示', '是否要删除选中的记录？', function(r){
							if (r){
							    // 1.获取被选中的记录，获取相应的id;
							    var ids = "";
							    for(var i=0;i<rows.length;i++){
							    	ids+=rows[i].id + ",";
							    }
							    // 2.拼接id的值
							    ids = ids.substring(0,ids.lastIndexOf(","));
							    $.post("system_setting!deleteById.action",{id:ids},function(result){
							    	//如果返回结果为true
							    	if(result== "true"){
							    		//取消选中所有行
							    		$("#settingdg").datagrid("uncheckAll");
							    		//alert("删除成功...");
							    		$("#settingdg").datagrid("reload");
							    	}else{
							    		$.messager.show({
											title:'消息提示',
											msg:'删除记录失败，请核查！',
											timeout:2000,
											showType:'slide',
											style:{
												right:'',
												top:document.body.scrollTop+document.documentElement.scrollTop,
												bottom:''
											}
										});
							    	}
							    },"text");
							}
						});
					}
				}
			},'-',{
				text:"<input id='search' name='search'/>"
			}],
  			
  			//冻结列
  			frozenColumns:[[
  				{field:'xyz',checkbox:true},
  				{field:'systemCode',title:'系统代号'}
  			]],
  			columns:[[
  				{field:'name',title:'网站名称'},
  				{field:'www',title:'门户地址根http路径'},
  				{field:'manageHttp',title:'后台地址根http路径'},
  				{field:'title',title:'网站标题'},
  				{field:'description',title:'网站的描述'},
  				{field:'keywords',title:'网站的关键字'},
  				{field:'address',title:'联系地址'},
  				{field:'tel',title:'联系电话'},
  				{field:'email',title:'邮箱'},
  				{field:'qq',title:'QQ号码'},
  				{field:'isopen',title:'是否开放网站'},
  				{field:'icp',title:'备案号'},
  				{field:'version',title:'系统版本'}
  			]]
  		});
  		//把普通的文本转化为搜索文本框
  		$('#search').searchbox({ 
  			//出发查询事件
			searcher:function(value,name){
			//获取当前查询的关键字，通过settingdg加载相应的信息
			//alert(value + "," + name);
			$("#settingdg").datagrid('load',{
				type:'value'
			});
		}, 
		prompt:'请输入...' 
		});
  	});
  	</script>
  </head>
  
  <body>
  	<table id="settingdg"></table>
  </body>
</html>
