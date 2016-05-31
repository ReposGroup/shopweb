package com.luis.system.service;

import java.util.List;

import com.luis.system.model.SystemSetting;

public interface SystemSettingService {
	public void save(SystemSetting sytemSetting);//保存
	
	public void deleteById(Integer id);//删除
	
	public SystemSetting getById(Integer id);//根据iD查询
	
	public List<SystemSetting> findAll();//查询所有
}
