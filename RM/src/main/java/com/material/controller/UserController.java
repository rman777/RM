package com.material.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.material.constant.Constant;
import com.material.exception.CustomException;
import com.material.model.User;
import com.material.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping("/")
	public String index() {
		return "Welcome to Rest Api";
	}	
	
	// Save Register User Data
	@PostMapping("/register")
	public ResponseEntity<Object> saveUserData(@RequestBody User user) {
		int result = userServiceImpl.chkUserExists(user.getUser_email());
		if(result > 0) {
			 return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.USER_ALREADY_EXIST), HttpStatus.OK);
		}else{
			 user.setUser_password(passwordEncoder.encode(user.getUser_password()));
			 userServiceImpl.addUser(user);
			 return new ResponseEntity<Object>(new CustomException(Constant.SUCCESS,Constant.USER_REGISTER_SUCCESS), HttpStatus.OK);
		}
	}
	
	
		// Check User Login
		@PostMapping("/chkLogin")
		public ResponseEntity<?> chkLogin(@RequestBody User user) {
			List<User> result = userServiceImpl.chkLogin(user.getUser_email());
			if(result.isEmpty()) {
				return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.USER_LOGIN_FAIL), HttpStatus.OK);
			}
			else {
				User encPass = result.get(0);
				if(passwordEncoder.matches(user.getUser_password(),encPass.getUser_password())) {
					 return new ResponseEntity<List<User>>(result, HttpStatus.OK);
				}else {
					return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.USER_LOGIN_FAIL), HttpStatus.OK);
				}
			}
		}
		
		// Get All Active User Data
		@GetMapping("/getAllUser")
		public List<Map<String, Object>> getAllUserList(){
			List<Map<String, Object>> result =  userServiceImpl.getAllUser();
			return result;		
		}
				
		
		// Change User Password
		@PutMapping("/changePassword")
		public ResponseEntity<?> changePassword(@RequestBody User user){
			 if(userServiceImpl.changePassword(user.getUser_id(),passwordEncoder.encode(user.getUser_password())) > 0) {
					return new ResponseEntity<Object>(new CustomException(Constant.SUCCESS,Constant.PASSWORD_CHANGE_SUCCESS), HttpStatus.OK);
			 }else {
				 return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.PASSWORD_CHANGE_FAIL), HttpStatus.OK);
			 }
		}
		
		//Update User Data
		@PutMapping("/updateUser")
		public ResponseEntity<?> updateUserDetails(@RequestBody User user){
			if(userServiceImpl.updateUserData(user) > 0) {
				return new ResponseEntity<Object>(new CustomException(Constant.SUCCESS,Constant.USER_UPDATED_SUCCESS), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.USER_UPDATED_FAIL), HttpStatus.OK);
			}
		}
		
		
		// Get single user data
		@PostMapping("/getUserDetails")
		public ResponseEntity<?> getUserDetails(@RequestBody User user){
			List<User> result = userServiceImpl.getUserDetails(user.getUser_id());
			if(result.isEmpty()) {
				return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.USER_DATA_NOT_FOUND), HttpStatus.OK);
			}
			else {
				 return new ResponseEntity<List<User>>(result, HttpStatus.OK);
			}
		}
		
		
		
	
	
}
