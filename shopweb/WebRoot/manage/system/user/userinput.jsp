<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<%@include file="/common/head.jspf" %>
  	<script type="text/javascript">
  		$(function(){
  			//iframe中的userdg对象
  			var userdg = parent.$("iframe").get(0).contentWindow.$("#userdg");
  			//完成数据回显
  			var rows = userdg.datagrid("getSelections");
  			if(rows.length == 1){
  				$("#userForm").form('load',{
					userName:rows[0].userName,
					passWord:rows[0].passWord,
					nickName:rows[0].nickName,
					email:rows[0].email,
					status:rows[0].status,
					roleId:rows[0].roleId
				});
  			}
  			
  			$("input[name=Name]").validatebox({
  			required:true,
  			missingMessage:'请输入商品名称！'
  			});
  			$("#userForm").form("disableValidation");
  			//注册button的事件
  			$("#btn").click(function(){
  				//开启验证
  				$("#userForm").form("enableValidation");
  				//如果验证成功，则提交表单
  				if($("#userForm").form("validate")){
  				//调用submit方法
  					$('#userForm').form('submit', {
						url: 'user!save.action',
						success: function(){
							//关闭当前窗体
							parent.$("#addupdate").window("close");
							//刷新页面,获取index.jsp-->iframe-->addupdate(docuent-->jquery-->easyui向上转型)
							//var userdg = parent.$("iframe").contents().find("#userdg").datagrid("reload");
							userdg.datagrid("reload");
						}
					});
  				}
  			});
  		});
  	</script>
  </head>
  
  <body>
  <form id="userForm" method="post">   
    <div>   
        <label for="userName"><s:text name="label_userName"></s:text>:</label>
        <input class="easyui-validatebox" type="text" name="userName" data-options="required:true" />   
    </div>   
    <div>   
        <label for="nickName">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</label>   
        <input class="easyui-validatebox" type="text" name="nickName" data-options="required:true" />   
    </div>
    <div>   
        <label for="passWord">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>   
        <input class="easyui-validatebox" type="password" name="passWord" data-options="required:true" />   
    </div>
    <div>   
        <label for="status">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:</label>   
             启用<input class="easyui-validatebox" type="radio" name="status" checked="checked"/>
             禁用<input class="easyui-validatebox" type="radio" name="status" data-options="required:true" />
    </div>
    <div>   
        <label for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>   
        <input class="easyui-validatebox" type="email" name="email" data-options="validType:'email'" />   
    </div>
    <div>   
        <label for="role">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色:</label>   
        <input class="easyui-validatebox" type="text" name="roleId"/>   
    </div>
     <div>   
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加用户</a>  
    </div>      
	</form> 
  </body>
</html>
