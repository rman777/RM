package com.material.model;

import java.sql.Date;

public class ExcelData {

	private int part_id;
	private String part_name;
	private int part_qty;
	private Date part_uploaded;
	private int user_id;
	private int part_status;
		
	public ExcelData() {}

	public ExcelData(int part_id, String part_name, int part_qty, Date part_uploaded, int user_id, int part_status) {
		super();
		this.part_id = part_id;
		this.part_name = part_name;
		this.part_qty = part_qty;
		this.part_uploaded = part_uploaded;
		this.user_id = user_id;
		this.part_status = part_status;
	}

	public int getPart_id() {
		return part_id;
	}
	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public int getPart_qty() {
		return part_qty;
	}
	public void setPart_qty(int part_qty) {
		this.part_qty = part_qty;
	}
	public Date getPart_uploaded() {
		return part_uploaded;
	}
	public void setPart_uploaded(Date part_uploaded) {
		this.part_uploaded = part_uploaded;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPart_status() {
		return part_status;
	}
	public void setPart_status(int part_status) {
		this.part_status = part_status;
	}
	
	@Override
	public String toString() {
		return "ExcelData [part_id=" + part_id + ", part_name=" + part_name + ", part_qty=" + part_qty
				+ ", part_uploaded=" + part_uploaded + ", user_id=" + user_id + ", part_status=" + part_status + "]";
	}
	
	
}
