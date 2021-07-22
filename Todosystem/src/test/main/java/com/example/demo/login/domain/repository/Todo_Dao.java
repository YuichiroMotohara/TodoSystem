package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.login.domain.model.Todo_items;

public interface Todo_Dao {


		public int insertOne(Todo_items todo_items)throws DataAccessException;


		public Todo_items selectOne(int todo_itemsId)throws DataAccessException;


		public List<Todo_items>selectMany()throws DataAccessException;


		public int updateOne(Todo_items todo_items)throws DataAccessException;


		public int deleteOne(int id) throws DataAccessException;


        public List<Todo_items> search(String todo_itemsId)throws DataAccessException;


        public int finished(Todo_items todo_items)throws DataAccessException;


}
