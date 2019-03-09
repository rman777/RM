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
import com.material.model.Role;
import com.material.service.RoleServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleServiceImpl roleServiceImpl;
	
	// Save Role Data
	@PostMapping("/saveRole")
	public ResponseEntity<Object> saveUserData(@RequestBody Role role) {
		int result = roleServiceImpl.addRole(role);
		if(result > 0) {
			 return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.ROLE_SAVE_FAIL), HttpStatus.OK);
		}else{
			
			 return new ResponseEntity<Object>(new CustomException(Constant.SUCCESS,Constant.ROLE_SAVE_SUCCESS), HttpStatus.OK);
		}
	}
	

	// Get User Role Data
	@GetMapping("/getAllRole")
	public List<Map<String, Object>> getAllRoleData(){
		List<Map<String, Object>> result =  roleServiceImpl.getAllRoleData();
		return result;	
	}
	
	
	
	
	
	
	
}
