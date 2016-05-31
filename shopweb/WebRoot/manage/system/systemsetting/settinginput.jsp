<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<%@include file="/common/head.jspf" %>
  	<script type="text/javascript">
  		$(function(){
  			//iframe中的settingdg对象
  			var settingdg = parent.$("iframe").get(0).contentWindow.$("#settingdg");
  			//完成数据回显
  			var rows = settingdg.datagrid("getSelections");
  			if(rows.length == 1){
  				$("#settingForm").form('load',{
					systemCode:rows[0].systemCode,
					name:rows[0].name,
					www:rows[0].www,
					manageHttp:rows[0].manageHttp,
					title:rows[0].title,
					description:rows[0].description,
					keywords:rows[0].keywords,
					address:rows[0].address,
					tel:rows[0].tel,
					email:rows[0].email,
					qq:rows[0].qq,
					isopen:rows[0].isopen,
					icp:rows[0].icp,
					version:rows[0].version
				});
  			}
  			
  			$("input[name=Name]").validatebox({
  			required:true,
  			missingMessage:'请输入商品名称！'
  			});
  			$("#settingForm").form("disableValidation");
  			//注册button的事件
  			$("#btn").click(function(){
  				//开启验证
  				$("#settingForm").form("enableValidation");
  				//如果验证成功，则提交表单
  				if($("#settingForm").form("validate")){
  				//调用submit方法
  					$('#settingForm').form('submit', {
						url: 'system_setting!save.action',
						success: function(){
							//关闭当前窗体
							parent.$("#addupdate").window("close");
							//刷新页面,获取index.jsp-->iframe-->addupdate(docuent-->jquery-->easyui向上转型)
							//var settingdg = parent.$("iframe").contents().find("#settingdg").datagrid("reload");
							settingdg.datagrid("reload");
						}
					});
  				}
  			});
  		});
  	</script>
  </head>
  
  <body>
  <form id="settingForm" method="post">   
    <div>
        <label for="systemCode">系统代号:</label>
        <input class="easyui-validatebox" type="text" name="systemCode" data-options="required:true" />   
    </div>   
    <div>   
        <label for="name">网站名称:</label>   
        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />   
    </div>
    <div>   
        <label for="www">门户地址根http路径:</label>   
        <input class="easyui-validatebox" type="text" name="www" data-options="required:true" />   
    </div>
    <div>   
        <label for="manageHttp">后台地址根http路径:</label>   
        <input class="easyui-validatebox" type="text" name="manageHttp" data-options="required:true" />   
    </div>
    <div>   
        <label for="title">网站标题:</label>   
        <input class="easyui-validatebox" type="text" name="title" data-options="required:true" />   
    </div>
    <div>   
        <label for="description">网站的描述:</label>   
        <input class="easyui-validatebox" type="text" name="description" data-options="required:true" />   
    </div>
    <div>   
        <label for="keywords">网站的关键字:</label>   
        <input class="easyui-validatebox" type="text" name="keywords" data-options="required:true" />   
    </div>
    <div>   
        <label for="address">联系地址:</label>   
        <input class="easyui-validatebox" type="text" name="address" data-options="required:true" />   
    </div>
    <div>   
        <label for="tel">联系电话:</label>   
        <input class="easyui-validatebox" type="tel" name="tel" data-options="required:true" />   
    </div>
    <div>   
        <label for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>   
        <input class="easyui-validatebox" type="email" name="email" data-options="validType:'email'" />   
    </div>
    <div>   
        <label for="qq">QQ号码:</label>   
        <input class="easyui-validatebox" type="text" name="qq" data-options="required:true" />   
    </div>
    <div>   
        <label for=""isopen"">是否开放网站:</label>   
     	是<input class="easyui-validatebox" type="radio" name=""isopen"" checked="checked"/>
                    否<input class="easyui-validatebox" type="radio" name=""isopen"" data-options="required:true" />
    </div>
    <div>   
        <label for="icp">是否开放网站:</label>   
        <input class="easyui-validatebox" type="text" name="icp" data-options="required:true" />   
    </div>
    <div>   
        <label for="version">系统版本:</label>   
        <input class="easyui-validatebox" type="text" name="version"/>   
    </div>
     <div>   
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加用户</a>  
    </div>      
	</form> 
  </body>
</html>
