package com.material.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.material.dao.DepartmentDaoImpl;
import com.material.model.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentServiceI {

	@Autowired
	DepartmentDaoImpl deptDaoImpl;
	
	@Override
	public int addDepartment(Department dept) {
		return deptDaoImpl.addDepartment(dept);
	}

	@Override
	public List<Map<String, Object>> getAllDepartment() {
		return deptDaoImpl.getAllDepartment();
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
