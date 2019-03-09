package com.material.constant;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constant {

	static Date date=new Date();
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static String formattedDate = formatter.format(date);
	public static final String  DATETIME = formattedDate;

	
	public static final String SUCCESS="success";
	public static final String FAIL="fail";
	/*------------------------------USER MESSAGES START------------------------------*/
	public static final String USER_DATA_NOT_FOUND = "No User Data Not Found";		
	public static final String EXCEL_READ_DATA_SUCCESS="Excel Data Uploaded Successfully";
	public static final String PASSWORD_CHANGE_FAIL="Failed to change password";
	public static final String PASSWORD_CHANGE_SUCCESS="User password changed Successfully";
	public static final String USER_LOGIN_SUCCESS="User login Successfully";
	public static final String USER_LOGIN_FAIL="Invalid username or password";
	public static final String USER_REGISTER_SUCCESS="User Registered Successfully";
	public static final String USER_ALREADY_EXIST="User Already Exists";
	public static final String USER_UPDATED_SUCCESS="User Data Updated Successfully";
	public static final String USER_UPDATED_FAIL="Failed to Update User Data";
	/*------------------------------USER MESSAGES END------------------------------*/
	
	
	/*------------------------------ROLE MESSAGES START------------------------------*/
	public static final String ROLE_SAVE_SUCCESS="User Role Added Successfully";
	public static final String ROLE_SAVE_FAIL="Failed to Save User Role Data";
	
	
	
	
	/*------------------------------ROLE MESSAGES END------------------------------*/
	


	/*------------------------------DEPARTMENT MESSAGES START------------------------------*/
	public static final String DEPT_SAVE_SUCCESS="Department Added Successfully";
	public static final String DEPT_SAVE_FAIL="Failed to Add Department Data";
	
	
	
	
	/*------------------------------DEPARTMENT MESSAGES END------------------------------*/
	

	
	
	
}
