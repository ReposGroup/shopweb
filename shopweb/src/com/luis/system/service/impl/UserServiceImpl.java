package com.luis.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luis.system.dao.UserDao;
import com.luis.system.model.User;
import com.luis.system.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public void save(User user) {
		userDao.saveOrUpdate(user);
	}

	@Override
	public void deleteById(Integer id) {
		userDao.deleteById(id);
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.get(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.getAll();
	}
}
