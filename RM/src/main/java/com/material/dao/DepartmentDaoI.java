package com.material.dao;

import java.util.List;
import java.util.Map;

import com.material.model.Department;

public interface DepartmentDaoI {

	public int addDepartment(Department dept);
	public List<Map<String, Object>> getAllDepartment();
	public int updateDepartment(Department dept);
	public List<Department> getDepartmentDetails(int dept_id);
}
