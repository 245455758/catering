package com.trouble.catering.service;

import java.util.List;

import com.trouble.catering.pojo.User;

public interface UserService {
	/**
	 * 根据用户id查找用户
	 * @param id
	 * @return
	 */
	public User findUserById(int id);
	/**
	 * 用户登录服务类中的方法，用来进行username和password验证
	 * @param username
	 * @param password
	 * @return
	 */
	public User userLogin(String username,String password);
	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<User> findAll();

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser(int id);
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	/**
	 * 根据用户id查找密码
	 * @param id
	 * @return
	 */
	public String findPasswordById(int id);
	/**
	 * 审核用户
	 * @param id
	 * @return
	 */
	public int validateUser(int id);
}
