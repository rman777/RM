package com.material.dao;

import java.util.List;
import java.util.Map;

import com.material.model.Role;

public interface RoleDaoI {

	public int addRole(Role role);
	public List<Map<String, Object>> getAllRoleData();
	public int updateRoleData(Role role);
	public List<Role> getRoleDetails(int role_id);
}
