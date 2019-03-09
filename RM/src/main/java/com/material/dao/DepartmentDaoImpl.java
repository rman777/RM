package com.material.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.material.model.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDaoI {

	
	@Autowired
	JdbcTemplate template;
	
	//Save Department Data
	private static final String SAVE_DEPARTMENT = "INSERT into department(dept_name)VALUES(?)";
	//Get All Department Data
	private static final String GET_ALL_DEPARTMENT = "SELECT * from department where dept_status='1'";
	
	@Override
	public int addDepartment(Department dept) {
		return template.update(SAVE_DEPARTMENT,dept.getDept_name());
	}

	@Override
	public List<Map<String, Object>> getAllDepartment() {
		List<Map<String, Object>> deptList =  template.queryForList(GET_ALL_DEPARTMENT);
		return deptList;
	}


	@Override
	public int updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Department> getDepartmentDetails(int dept_id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
