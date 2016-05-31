package com.luis.system.service;

import java.util.List;

import com.luis.system.model.User;


public interface UserService {
	public void save(User user);//保存
	
	public void deleteById(Integer id);//删除
	
	public User getUserById(Integer id);//根据iD查询
	
	public List<User> findAll();//查询所有
}
