package com.material.service;

import java.util.List;
import java.util.Map;

import com.material.model.User;

public interface UserServiceI {

	public int addUser(User register);
	public int chkUserExists(String user_email);
	public List<User> chkLogin(String user_email);
	public List<Map<String, Object>> getAllUser();
	public int changePassword(int user_id,String user_password);
	public int updateUserData(User user);
	public List<User> getUserDetails(int user_id);
	public int deleteUser(int user_id);

	
}
