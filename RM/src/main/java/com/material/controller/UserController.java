package com.material.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.material.config.EmailConfig;
import com.material.constant.Constant;
import com.material.exception.CustomException;
import com.material.model.ExcelData;
import com.material.model.User;
import com.material.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
    private JavaMailSender sender;
	
	@PostMapping("/sendMail")
	public String SendMail() {
	
		 MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);

	        try {
	            helper.setTo("ranjeetsatpute777@gmail.com");
	            helper.setText("Greetings :)");
	            helper.setSubject("Mail From Spring Boot");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            return "Error while sending mail ..";
	        }
	        sender.send(message);
	        return "Mail Sent Success!";
	}
	
	

	
	
	
	
	
	
	
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
		
		
		//Delete(Inactive) User Data
		@PostMapping("/deleteUser")
		public ResponseEntity<?> deleteUserData(@RequestBody User user){
			if(userServiceImpl.deleteUser(user.getUser_id()) > 0) {
				return new ResponseEntity<Object>(new CustomException(Constant.SUCCESS,Constant.USER_DELETE_SUCCESS), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.USER_DELETE_FAIL), HttpStatus.OK);
			}
		}
		
		
		// Upload Excel File
		@RequestMapping(value="/import",method=RequestMethod.POST)
		public ResponseEntity<?> mapReapExcelDatatoDB(@RequestParam("file") MultipartFile excelFile) throws IOException {
		    XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
		    XSSFSheet worksheet = workbook.getSheetAt(0);
		    for(int i=0;i<worksheet.getPhysicalNumberOfRows() ;i++) {
		    	ExcelData exceldata = new ExcelData();
		        XSSFRow row = worksheet.getRow(i);
		        if(row.getCell(0) != null && row.getCell(1) != null) {
		        	exceldata.setPart_name((row.getCell(0).getStringCellValue().isEmpty())?"-":row.getCell(0).getStringCellValue());
		        	exceldata.setPart_qty((int) row.getCell(1).getNumericCellValue());
		        	//exceldata.setUser_id(user_id);
		        	 userServiceImpl.addExcelData(exceldata);
		        }		         
		    }
		    return new ResponseEntity<Object>(new CustomException("Excel Data Uploaded Successfully"), HttpStatus.OK);
		    
		}
		
		
		
		public String ChangeinGit() {
		return "Hello";
		}
	
	
}
