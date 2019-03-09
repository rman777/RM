package com.material.model;

import java.sql.Date;

public class Department {

	private int dept_id;
	private String dept_name;
	private Date dept_created;
	private int dept_status;
	
	public Department() {}
	
	public Department(int dept_id, String dept_name, Date dept_created, int dept_status) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_created = dept_created;
		this.dept_status = dept_status;
	}

	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Date getDept_created() {
		return dept_created;
	}
	public void setDept_created(Date dept_created) {
		this.dept_created = dept_created;
	}
	public int getDept_status() {
		return dept_status;
	}
	public void setDept_status(int dept_status) {
		this.dept_status = dept_status;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + ", dept_created=" + dept_created
				+ ", dept_status=" + dept_status + "]";
	}
	
	
	
}
