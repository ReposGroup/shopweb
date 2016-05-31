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

import com.luis.base.action.CrudModelActionSupport;
import com.luis.base.util.Struts2Utils;
import com.luis.system.model.SystemSetting;
import com.luis.system.service.SystemSettingService;

@Controller
@Results( { @Result(name = "CrudModelActionSupport.RELOAD", location = "",type="chain",params={
		"method","querydetail"}),
	@Result(name = "list", location = "/manage/system/systemsetting/settinglist.jsp") ,
	@Result(name = "input", location = "/manage/system/systemsetting/settinginput.jsp"),
	@Result(name = "view", location = "/manage/system/systemsetting/settingview.jsp")})  
public class SystemSettingAction extends CrudModelActionSupport<SystemSetting> {

	private static final long serialVersionUID = -2947509135147595944L;
	@Autowired
	private SystemSettingService systemSettingService;
	
	public void querydetail() throws IOException{
		List<SystemSetting> settinglist = systemSettingService.findAll();
		int total = settinglist.size();
		JSONObject json = new JSONObject();
		Map<String, Object> property = new HashMap<String, Object>();
		if(settinglist!=null && settinglist.size()>=0){
			property.put("rows", settinglist);
		}
		property.put("total", total);
		json.putAll(property);
		Struts2Utils.getResponse().setCharacterEncoding("UTF-8");
		Struts2Utils.getResponse().getWriter().print(json.toString());
	}
	public void deleteById() throws IOException{
		if(id != null){
			systemSettingService.deleteById(id);
			Struts2Utils.getResponse().getWriter().print("true");
		}
	}
	@Override
	public String list() throws Exception {
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
		systemSettingService.save(entity);
		return "list";
	}
	@Override
	public String delete() throws Exception {
		return null;
	}
	@Override
	protected void prepareModel() throws Exception {
		if(id != null){
			entity = (SystemSetting)this.systemSettingService.getById(id);
		}else{
			entity = new SystemSetting();
		}
	}
}
