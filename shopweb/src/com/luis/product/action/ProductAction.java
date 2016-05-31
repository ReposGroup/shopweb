package com.luis.product.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.luis.base.action.CrudModelActionSupport;
import com.luis.base.util.Struts2Utils;
import com.luis.product.model.Product;
import com.luis.product.service.ProductService;
import com.luis.system.model.User;
@Controller
@Results( { @Result(name = "CrudModelActionSupport.RELOAD", location = "",type="chain",params={
		"method","querydetail"}),
	@Result(name = "list", location = "/manage/product/productlist.jsp") ,
	@Result(name = "input", location = "/manage/product/productinput.jsp"),
	@Result(name = "view", location = "/manage/product/productview.jsp")})  
public class ProductAction extends CrudModelActionSupport<Product>{
	
	@Autowired
	private ProductService productService;
	
	public void querydetail() throws IOException{
		List<Product> personlist = productService.findAll();
		int total = personlist.size();
		JSONObject json = new JSONObject();
		Map<String, Object> property = new HashMap<String, Object>();
		if(personlist!=null && personlist.size()>=0){
			property.put("rows", personlist);
		}
		property.put("total", total);
		json.putAll(property);
		Struts2Utils.getResponse().setCharacterEncoding("UTF-8");
		Struts2Utils.getResponse().getWriter().print(json.toString());
	}
	public void deleteById() throws IOException{
		if(id != null){
			productService.deleteById(id);
			Struts2Utils.getResponse().getWriter().print("true");
		}
	}
	public String list(){
		return "list";
	}
	@Override
	public String input() throws Exception {
		return "input";
	}
	@Override
	public String view() throws Exception {
		return "view";
	}
	@Override
	public String approve() throws Exception {
		return "approve";
	}
	@Override
	public String save() throws Exception {
		productService.save(entity);
		return "list";
	}
	@Override
	public String delete() throws Exception {
		return null;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id != null){
			entity = (Product)this.productService.getById(id);
		}else{
			entity = new Product();
		}
	}
}
