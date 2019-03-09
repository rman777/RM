package com.material.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.material.dao.RoleDaoImpl;
import com.material.model.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleServiceI{

	@Autowired
	RoleDaoImpl roleDaoImpl;
	
	@Override
	public int addRole(Role role) {
		return roleDaoImpl.addRole(role);
	}

	@Override
	public List<Map<String, Object>> getAllRoleData() {
		return roleDaoImpl.getAllRoleData();
	}


	@Override
	public int updateRoleData(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> getRoleDetails(int role_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
