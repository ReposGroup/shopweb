package com.luis.system.dao;

import org.springframework.stereotype.Repository;

import com.luis.base.dao.HibernateBaseDao;
import com.luis.system.model.User;

@Repository
public class UserDao extends HibernateBaseDao<User, Integer>{
	
}
