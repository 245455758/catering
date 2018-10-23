package com.trouble.catering.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trouble.catering.mapper.RoleMapper;
import com.trouble.catering.pojo.Role;
import com.trouble.catering.pojo.RoleExample;
import com.trouble.catering.pojo.RoleExample.Criteria;
import com.trouble.catering.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public Set getRights(int roleId) {
		String[] rights = roleMapper.selectRightsById(roleId).split(";");
		Set set = new HashSet();
		for (String string : rights) {
			set.add(string);
		}
		return set;
	}

}
