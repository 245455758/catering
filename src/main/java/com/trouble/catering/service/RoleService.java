package com.trouble.catering.service;

import java.util.List;
import java.util.Set;

import com.trouble.catering.pojo.Role;

public interface RoleService {
	
	public Set getRights(int roleId) ;
	
	public List<Role> findAll();
	
	public List<Role> findAllIdAndDesc();
	
	public int addRole(Role role);
	
	public int updateRole(Role role);
	
	public int deleteByKey(int key);

}
