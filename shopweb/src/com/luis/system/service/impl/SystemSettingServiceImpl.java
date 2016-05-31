package com.luis.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luis.system.dao.SystemSettingDao;
import com.luis.system.model.SystemSetting;
import com.luis.system.service.SystemSettingService;

@Service
@Transactional
public class SystemSettingServiceImpl implements SystemSettingService {
	
	@Autowired
	private SystemSettingDao systemSettingDao;
	@Override
	public void save(SystemSetting sytemSetting) {
		systemSettingDao.save(sytemSetting);
	}

	@Override
	public void deleteById(Integer id) {
		systemSettingDao.delete(id);
	}

	@Override
	public SystemSetting getById(Integer id) {
		return systemSettingDao.get(id);
	}

	@Override
	public List<SystemSetting> findAll() {
		return systemSettingDao.getAll();
	}

}
