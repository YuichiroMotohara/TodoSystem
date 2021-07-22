package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.login.domain.model.Users;

public interface UsersDao {


	public int count() throws DataAccessException;


	public int insertOne(Users users)throws DataAccessException;


	public Users selectOne(String usersId)throws DataAccessException;


	public List<Users>selectMany()throws DataAccessException;


	public int updateOne(Users users)throws DataAccessException;


	public int deleteOne(int usersId) throws DataAccessException;


	public void userCsvOut()throws DataAccessException;



}
