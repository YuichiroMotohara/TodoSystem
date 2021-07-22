package com.example.demo.login.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class Users {

	private int id;
	private String user;
	private String password;
	private String family_name;
	private String first_name;
	private int is_deleted;
	private Date create_date_time;
	private Date update_date_time;
	private String role;

}
