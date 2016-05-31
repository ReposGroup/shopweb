package com.luis.system.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luis.base.action.CrudModelActionSupport;
import com.luis.base.util.Struts2Utils;
import com.luis.system.model.User;
import com.luis.system.service.UserService;
@Controller
@Results( { @Result(name = "CrudModelActionSupport.RELOAD", location = "",type="chain",params={
		"method","querydetail"}),
	@Result(name = "list", location = "/manage/system/user/userlist.jsp") ,
	@Result(name = "input", location = "/manage/system/user/userinput.jsp"),
	@Result(name = "view", location = "/manage/system/user/userview.jsp")})  
public class UserAction extends CrudModelActionSupport<User>{
	
	private static final long serialVersionUID = -3150665490941910179L;
	@Autowired
	private UserService userService;
	
	public void querydetail() throws IOException{
		List<User> userlist = userService.findAll();
		int total = userlist.size();
		JSONObject json = new JSONObject();
		Map<String, Object> property = new HashMap<String, Object>();
		if(userlist!=null && userlist.size()>=0){
			property.put("rows", userlist);
		}
		property.put("total", total);
		json.putAll(property);
		Struts2Utils.getResponse().setCharacterEncoding("UTF-8");
		Struts2Utils.getResponse().getWriter().print(json.toString());
	}
	public void deleteById() throws IOException{
		if(id != null){
			userService.deleteById(id);
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
		userService.save(entity);
		return "list";
	}
	@Override
	public String delete() throws Exception {
		return null;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id != null){
			entity = (User)this.userService.getUserById(id);
		}else{
			entity = new User();
		}
	}
}
