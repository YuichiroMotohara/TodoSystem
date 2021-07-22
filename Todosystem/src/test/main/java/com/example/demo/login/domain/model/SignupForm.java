package com.example.demo.login.domain.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class SignupForm {


	@NotBlank
	@Length(max=100)
	private String Article;  //項目名 item_name(todo_items)


	private int usersName; //担当者名


    @NotNull
    @DateTimeFormat(pattern="yyyy/MM/dd") //item_name(expire_date)
    private Date Limited;  //期限


    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date finished; //終了日


    private int id;


    private boolean check;


    private boolean checked;




}
