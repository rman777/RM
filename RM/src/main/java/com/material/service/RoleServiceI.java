package com.material.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.material.model.Role;

@Service
@Transactional
public interface RoleServiceI {

	public int addRole(Role role);
	public List<Map<String, Object>> getAllRoleData();
	public int updateRoleData(Role role);
	public List<Role> getRoleDetails(int role_id);
}
