package com.example.demo.login.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class Todo_items {

	private int id;
	private int user_id;
	private String item_name;
	private Date registration_date;
	private Date expire_date;
	private Date finished_date;
	private int is_deleted;
	private Date create_date_time;
	private Date update_date_time;
	private String user;

}
