package com.example.demo.login.domain.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;



@Data
public class RegistrationForm {


    private int id;


    @NotBlank
	private String user;

	@NotBlank
	@Length(min=4, max=100)
	@Pattern(regexp="^[a-zA-Z0-9]+$")
	private String password;

	@NotBlank
    private String family_name;

	@NotBlank
    private String first_name;


    private String role;

    private int is_deleted;

}
