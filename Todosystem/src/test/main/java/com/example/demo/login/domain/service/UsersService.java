package com.example.demo.login.domain.service;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.domain.model.Users;
import com.example.demo.login.domain.repository.UsersDao;

@Service
@Transactional
public class UsersService {


	@Autowired
	PasswordEncoder passwordEncoder;


	@Autowired
	UsersDao dao;
	public List<Users> selectMany(){
		//List<Users> usersList = dao.selectMany();

		return dao.selectMany();
	}



	public int count() {

		return dao.count();
	}



	public Users selectOne(String id) {

		return dao.selectOne(id);
	}




	public boolean updateOne(Users users) throws DataAccessException{

			boolean result=false;


		   	  int rowNumber = dao.updateOne(users);

			     if(rowNumber>0) {

				      result=true;
			     }


		return result;
	}



	public void userCsvOut()throws DataAccessException{

			dao.userCsvOut();
	}



	public byte[]getFile(String fileName) throws IOException{


		FileSystem fs = FileSystems.getDefault();


		Path p =fs.getPath(fileName);


		byte[] bytes =Files.readAllBytes(p);


		return bytes;

	}



	public boolean insertOne(Users users) {

		  users.setPassword(passwordEncoder.encode(users.getPassword()));


		  int insert = dao.insertOne(users);

		  boolean result = false;

		    if(insert > 0) {

		      result= true;
		    }

		return result;
	}





}



