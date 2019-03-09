package com.material.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.material.constant.Constant;
import com.material.exception.CustomException;
import com.material.model.Department;
import com.material.service.DepartmentServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentServiceImpl deptServiceImpl;
	
	
		// Save Department Data
		@PostMapping("/saveRole")
		public ResponseEntity<Object> saveUserData(@RequestBody Department dept) {
			int result = deptServiceImpl.addDepartment(dept);
			if(result > 0) {
				 return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.DEPT_SAVE_FAIL), HttpStatus.OK);
			}else{
				
				 return new ResponseEntity<Object>(new CustomException(Constant.SUCCESS,Constant.DEPT_SAVE_SUCCESS), HttpStatus.OK);
			}
		}
	
		// Get Department Data
		@GetMapping("/getAllDepartment")
		public List<Map<String, Object>> getAllDepartment(){
			List<Map<String, Object>> result =  deptServiceImpl.getAllDepartment();
			return result;
		}
}
