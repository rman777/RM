package com.material.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.material.model.Role;

@Repository
public class RoleDaoImpl implements RoleDaoI {
	
	@Autowired
	JdbcTemplate template;
	
	//Save Role Data
	private static final String SAVE_ROLE_DATA = "INSERT into role(role_type)VALUES(?)";
	
	//Get All User ROle Data
		private static final String GET_ALL_ROLE = "SELECT * from role where role_status='1'";

	@Override
	public int addRole(Role role) {
		return template.update(SAVE_ROLE_DATA,role.getRole_type());
	}

	@Override
	public List<Map<String, Object>> getAllRoleData() {
		List<Map<String, Object>> roleList =  template.queryForList(GET_ALL_ROLE);
		return roleList;
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
