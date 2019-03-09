package com.material.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.material.model.User;

@Repository
public class UserDaoImpl implements UserDaoI{

	@Autowired
	JdbcTemplate template;
	// Save User Data
	private  static final String SAVE_USER = "Insert into user(user_first_name,user_last_name,user_mobile,user_email,user_password,"
			+ "user_status,user_created,user_last_login,role_id,dept_id)values(?,?,?,?,?,?,?,?,?,?)";	
	
	//Check User already exists or not
	private  static final String CHK_USER_EXISTS ="SELECT COUNT(*) FROM user WHERE user_email=? AND user_status='1'";
	//Check User Login
	private  static final String CHK_LOGIN = "SELECT * from user where user_email=? AND user_status='1'";
	//Get All User Data
	private static final String GET_ALL_USER="SELECT * from user where user_status='1'";
	//change User Password Using id
	private static final String CHANGE_PASSWORD = "UPDATE user SET user_password=? where user_id=? AND user_status='1'";
	//Update user Data
	private static final String UPDATE_USER ="UPDATE user SET user_first_name=?,user_last_name=?,user_mobile=? where user_id=? AND user_status='1'";
	//Get User Details by ID
	private static final String GET_USER_BY_ID= "SELECT * from user where user_id=? AND user_status='1'";
	
	@Override
	public int addUser(User u)  {
		
		int result = template.update(SAVE_USER,u.getUser_first_name(),u.getUser_last_name(),u.getUser_mobile(),u.getUser_email()
				,u.getUser_password(),u.getUser_status(),u.getUser_created(),u.getUser_last_login(),u.getRole_id()
				,u.getDept_id());
		return result;
	}

	@Override
	public int chkUserExists(String user_email) {
		return template.queryForObject(CHK_USER_EXISTS,new Object[]{user_email},Integer.class);
	}

	@Override
	public List<User> chkLogin(String user_email) {
	
		return this.template.query(CHK_LOGIN, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_first_name(rs.getString("user_first_name"));
				user.setUser_last_name(rs.getString("user_last_name"));
				user.setUser_mobile(rs.getLong("user_mobile"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_status(rs.getInt("user_status"));
				user.setRole_id(rs.getInt("role_id"));
				user.setDept_id(rs.getInt("dept_id"));
				return user;
			}
		},user_email);
	}

	@Override
	public List<Map<String, Object>> getAllUser() {
		List<Map<String, Object>> userList =  template.queryForList(GET_ALL_USER);
		return userList;
	}
	
	@Override
	public int changePassword(int user_id, String user_password) {
		return template.update(CHANGE_PASSWORD, user_password,user_id);
	}

	@Override
	public int updateUserData(User user) {
		return template.update(UPDATE_USER,user.getUser_first_name(),user.getUser_last_name(),user.getUser_mobile(),user.getUser_id());
	}

	@Override
	public List<User> getUserDetails(int user_id) {
		return this.template.query(GET_USER_BY_ID, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_first_name(rs.getString("user_first_name"));
				user.setUser_last_name(rs.getString("user_last_name"));
				user.setUser_mobile(rs.getLong("user_mobile"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_status(rs.getInt("user_status"));
				user.setRole_id(rs.getInt("role_id"));
				user.setDept_id(rs.getInt("dept_id"));
				return user;
			}
		},user_id);
	}

	

	

	
	
	
	

}
