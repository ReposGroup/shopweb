<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<%@include file="/common/head.jspf" %>
  	<script type="text/javascript">
  		$(function(){
  			//iframe中的productdg对象
  			var productdg = parent.$("iframe").get(0).contentWindow.$("#productdg");
  			//完成数据回显
  			var rows = productdg.datagrid("getSelections");
  			if(rows.length == 1){
  				$("#productForm").form('load',{
					id:rows[0].id,
					name:rows[0].name,
					introduce:rows[0].introduce,
					picture:rows[0].picture,
					price:rows[0].price,
					nowprice:rows[0].nowprice,
					searchKey:rows[0].searchKey,
					isnew:rows[0].isnew,
					remark:rows[0].remark,
					sale:rows[0].sale
				});
  			}
  			
  			$("input[name=Name]").validatebox({
  			required:true,
  			missingMessage:'请输入商品名称！'
  			});
  			$("#productForm").form("disableValidation");
  			//注册button的事件
  			$("#btn").click(function(){
  				//开启验证
  				$("#productForm").form("enableValidation");
  				//如果验证成功，则提交表单
  				if($("#productForm").form("validate")){
  				//调用submit方法
  					$('#productForm').form('submit', {
						url: 'product!save.action',
						success: function(){
							//关闭当前窗体
							parent.$("#addupdate").window("close");
							//刷新页面,获取index.jsp-->iframe-->addupdate(docuent-->jquery-->easyui向上转型)
							//var productdg = parent.$("iframe").contents().find("#productdg").datagrid("reload");
							productdg.datagrid("reload");
						}
					});
  				}
  			});
  		});
  	</script>
  </head>
  
  <body>
  <form id="productForm" method="post">   
    <div>   
        <label for="name">产品名称:</label>
        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />   
    </div>
    <div>   
        <label for="introduce">产品简介:</label>
        <input class="easyui-validatebox" type="text" name="introduce" data-options="required:true" />   
    </div>
    <div>   
        <label for=""price"">产品价格:</label>
        <input class="easyui-validatebox" type="text" name="price" data-options="required:true" />   
    </div>
    <div>   
        <label for=""nowPrice"">产品现价:</label>
        <input class="easyui-validatebox" type="text" name="nowPrice" data-options="required:true" />   
    </div>
    <div>   
        <label for=""searchKey"">搜索关键词:</label>
        <input class="easyui-validatebox" type="text" name="searchKey" data-options="required:true" />   
    </div>
    <div>   
        <label for=""file"">图片上传:</label>
        <input class="easyui-validatebox" type="file" name="file" data-options="required:true" />   
    </div>
    <div>   
        <label for="sale">是否特价:</label>   
             是<input class="easyui-validatebox" type="radio" name="sale" checked="checked"/>
             否<input class="easyui-validatebox" type="radio" name="sale" data-options="required:true" />
    </div>
    <div>   
        <label for="isnew">是否最新:</label>   
             是<input class="easyui-validatebox" type="radio" name="isnew" checked="checked"/>
             否<input class="easyui-validatebox" type="radio" name="isnew" data-options="required:true" />
    </div>
    <div>   
        <label for="remark">产品描述:</label>   
        <textarea name="remark" cols="40" rows="8"></textarea>  
    </div>
     <div>   
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加产品</a>  
    </div>      
	</form> 
  </body>
</html>
