package com.material.model;

import java.sql.Date;

public class Role {

	private int role_id;
	private String role_type;
	private Date role_created;
	private int role_status;
	
	public Role() {}
	
	public Role(int role_id, String role_type, Date role_created, int role_status) {
		super();
		this.role_id = role_id;
		this.role_type = role_type;
		this.role_created = role_created;
		this.role_status = role_status;
	}

	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	public Date getRole_created() {
		return role_created;
	}
	public void setRole_created(Date role_created) {
		this.role_created = role_created;
	}
	public int getRole_status() {
		return role_status;
	}
	public void setRole_status(int role_status) {
		this.role_status = role_status;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_type=" + role_type + ", role_created=" + role_created
				+ ", role_status=" + role_status + "]";
	}
	

}
