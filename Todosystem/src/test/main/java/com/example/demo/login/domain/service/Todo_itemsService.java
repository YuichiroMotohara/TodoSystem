package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.Todo_items;
import com.example.demo.login.domain.repository.Todo_Dao;


@Service
public class Todo_itemsService {


	@Autowired
	Todo_Dao todo_dao;
	public boolean insertOne(Todo_items todo_items) {

		  int insert = todo_dao.insertOne(todo_items);

		  boolean result = false;

		    if(insert > 0) {

		      result= true;
		    }

		return result;
	}



	public List<Todo_items> selectMany(){

		List<Todo_items> workList = todo_dao.selectMany();

		return workList ;
	}



	public boolean updateOne(Todo_items todo_items) throws DataAccessException{

		   boolean result=false;

		     try {

		           int rowNumber = todo_dao.updateOne(todo_items);

		             if(rowNumber>0) {

		            	 result=true;
		             }
 		     }catch(Exception e) {
			         //ロールバック
			         //txManager.rollback(status);
			         //throw new
			         //DataAccessException("ERROR Update", e)
			         //{};
		     }

		return result;
	}



	public Todo_items selectOne(int todo_itemsId) {

		return todo_dao.selectOne(todo_itemsId);
    }



	public boolean deleteOne(int user_id) {

			  int rowNumber = todo_dao.deleteOne(user_id);

			    boolean result=false;

			     if(rowNumber>0) {

				     result=true;
			     }

		return result;
	}



	public List<Todo_items> search(String todo_itemsId) {

		   List<Todo_items> todo_items = todo_dao.search(todo_itemsId);

		 return todo_items;
	}



	public boolean finished(Todo_items todo_items) throws DataAccessException{

		    boolean result=false;

		      try {
			         int rowNumber = todo_dao.finished(todo_items);

		                if(rowNumber>0) {

			               result=true;
		                }

		      }catch(Exception e) {


		      }


		return result;
	}


}



