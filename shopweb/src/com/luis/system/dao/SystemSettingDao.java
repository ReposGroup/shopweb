package com.luis.system.dao;

import org.springframework.stereotype.Repository;

import com.luis.base.dao.HibernateBaseDao;
import com.luis.system.model.SystemSetting;

@Repository
public class SystemSettingDao extends HibernateBaseDao<SystemSetting, Integer> {

}
