package com.material.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.material.dao.UserDaoImpl;
import com.material.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserServiceI{
	
	@Autowired
	UserDaoImpl userDaoImpl;

	@Override
	public int addUser(User user) {
		userDaoImpl.addUser(user);
		return 0;
	}

	@Override
	public int chkUserExists(String user_email) {
		return	userDaoImpl.chkUserExists(user_email);	
	}

	@Override
	public List<User> chkLogin(String user_email) {
		return userDaoImpl.chkLogin(user_email);
	}

	@Override
	public List<Map<String, Object>> getAllUser() {
		return userDaoImpl.getAllUser();
	}

	@Override
	public int changePassword(int user_id, String user_password) {
		return userDaoImpl.changePassword(user_id, user_password);
	}
	

	@Override
	public int updateUserData(User user) {
		return userDaoImpl.updateUserData(user);
	}

	@Override
	public List<User> getUserDetails(int user_id) {
		return userDaoImpl.getUserDetails(user_id);
	}

	

}
