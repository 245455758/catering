package com.trouble.catering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trouble.catering.mapper.UserMapper;
import com.trouble.catering.pojo.User;
import com.trouble.catering.pojo.UserExample;
import com.trouble.catering.pojo.UserExample.Criteria;
import com.trouble.catering.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User userLogin(String username, String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<User> users = userMapper.selectByExample(example);
		if(users!=null&&users.size()>0) {
			return users.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<User> findAll() {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsvalidateEqualTo(1);
		return userMapper.selectByExample(example );
	}

	@Override
	public int addUser(User user) {
		return userMapper.insert(user);
	}
	
	public int deleteUser(int id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public String findPasswordById(int id) {
		return userMapper.selectPasswordById(id);
	}

}
