package com.trouble.catering.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trouble.catering.mapper.ResourceMapper;
import com.trouble.catering.mapper.RoleMapper;
import com.trouble.catering.pojo.Resource;
import com.trouble.catering.pojo.Role;
import com.trouble.catering.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public Set getRights(int roleId) {
		String[] rights = roleMapper.selectRightsById(roleId).split(";");
		Set set = new HashSet();
		for (String string : rights) {
			set.add(string);
		}
		return set;
	}

	@Override
	public List<Role> findAll() {
		List<Role> roles = roleMapper.selectAllRoles();
		Map map = new HashMap();
		saveRights(map);
		String[] rights = null;
		StringBuffer s = null;
		for (Role role : roles) {
			s = new StringBuffer();
			String rights2 = role.getRights();
			if(rights2!=null) {
				rights =rights2.split(";");
				for (String string : rights) {
					s.append(","+map.get(string));
				}
				role.setRights(s.toString().substring(1));
			}else {
				role.setRights("");
			}
		}
		return roles;
	}
	
	private void saveRights(Map map) {
		List<Resource> resources = resourceMapper.selectAllIdAndName();
		for (Resource resource : resources) {
			if(resource!=null) {
				map.put(resource.getsId(), resource.getName());
			}
		}
	}

	@Override
	public int addRole(Role role) {
		return roleMapper.insert(role);
	}

	@Override
	public int updateRole(Role role) {
		return roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public int deleteByKey(int key) {
		return roleMapper.deleteByPrimaryKey(key);
	}

}
