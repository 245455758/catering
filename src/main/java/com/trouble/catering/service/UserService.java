package com.trouble.catering.service;

import com.trouble.catering.pojo.User;

public interface UserService {
	
	public User findUserById(int id);
	
	public User userLogin(String username,String password);

}
