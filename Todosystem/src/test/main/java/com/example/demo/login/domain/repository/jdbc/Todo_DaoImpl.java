package com.example.demo.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Todo_items;
import com.example.demo.login.domain.repository.Todo_Dao;


@Repository("Todo_DaoImpl")
public class Todo_DaoImpl implements Todo_Dao {

	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public int insertOne(Todo_items todo_items)throws DataAccessException{

		String sql = "INSERT INTO  todosystem.todo_items ("
				+" user_id,"
				+" item_name,"
				+" registration_date,"
				+" expire_date,"
			    +" finished_date) "
			    +" VALUES(?,?,?,?,?)";


		//"SELECT * FROM todo_items JOIN users2 "
       // + "ON todo_items.user_id = users2.id "
       // + "WHERE todo_items.is_deleted= 0 "


		System.out.println(sql);
		       int rowNumber = jdbc.update(sql,
						                    todo_items.getUser_id(),
						                    todo_items.getItem_name(),
						                    todo_items.getRegistration_date(),
						                    todo_items.getExpire_date(),
						                    todo_items.getFinished_date());



				return rowNumber;
	}



	@Override
	public Todo_items selectOne(int todo_itemsId)throws DataAccessException{

	   Map<String, Object> map = jdbc.queryForMap("SELECT * FROM todo_items  WHERE id = ?",todo_itemsId);

	        Todo_items todo_items = new Todo_items();

	               todo_items.setId((int)map.get("id"));
	               todo_items.setUser_id((int)map.get("user_id"));
	               todo_items.setItem_name((String)map.get("item_name"));
	               todo_items.setRegistration_date((Date)map.get("registration_date"));
	               todo_items.setExpire_date((Date)map.get("expire_date"));
	               todo_items.setFinished_date((Date)map.get("finished_date"));
	               todo_items.setIs_deleted((int)map.get("is_deleted"));
	               todo_items.setCreate_date_time((Date)map.get("create_date_time"));

	   return todo_items;
	}



	@Override
	public List<Todo_items>selectMany()throws DataAccessException{


		List<Map<String,Object>>getList= jdbc.queryForList( "SELECT * FROM todo_items JOIN users2 "
				                                           + "ON todo_items.user_id = users2.id "
				                                           + "WHERE todo_items.is_deleted= 0 "
				                                           + "ORDER BY expire_date ASC");

				List<Todo_items> todo_itemsList= new ArrayList<>();

				for(Map<String,Object>map:getList) {

					Todo_items todo_items  = new Todo_items();

					todo_items.setId((int)map.get("id"));
					todo_items.setUser_id((int)map.get("user_id"));
					todo_items.setItem_name((String)map.get("item_name"));
					todo_items.setRegistration_date((Date)map.get("registration_date"));
					todo_items.setExpire_date((Date)map.get("expire_date"));
					todo_items.setFinished_date((Date)map.get("finished_date"));
					todo_items.setIs_deleted((int)map.get("is_deleted"));
					todo_items.setCreate_date_time((Date)map.get("create_date_time"));
					todo_items.setUser((String)map.get("user"));

				 todo_itemsList.add(todo_items);
			    }

		return todo_itemsList;
	}



	@Override
	public int updateOne(Todo_items todo_items)throws DataAccessException{

				String sql="UPDATE todo_items SET "
		        		                   +" user_id=?,item_name=?, expire_date=?, finished_date=?"
		        		                   +" WHERE id=?;";

		        int rowNumber=jdbc.update(sql,
		        		                 todo_items.getUser_id(),
		        		                 todo_items.getItem_name(),
		        		                 todo_items.getExpire_date(),
		        		                 todo_items.getFinished_date(),
		        		                 todo_items.getId());


				return rowNumber;
	}



	@Override
	public int deleteOne(int id)throws DataAccessException{

		        int deleteNumber = jdbc.update("UPDATE todo_items "
		        		+ "SET is_deleted =1"
						+ " WHERE id=?",id);

				return deleteNumber;
	}



	@Override
	public List<Todo_items> search(String todo_itemsId)throws DataAccessException{

		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM todo_items JOIN users2"
				  + " ON todo_items.user_id = users2.id "
				  + "WHERE todo_items.is_deleted= 0 "
				  + "AND (todo_items.item_name LIKE ? OR  users2.user LIKE ? OR todo_items.registration_date "
				  + "LIKE ? OR todo_items.expire_date LIKE ? OR todo_items.finished_date LIKE ? )"
		          + "ORDER BY expire_date ASC","%"
				  + todo_itemsId + "%","%" + todo_itemsId + "%" ,"%" + todo_itemsId + "%","%" + todo_itemsId + "%" , "%" + todo_itemsId + "%" );

		List<Todo_items> todo_items = new ArrayList<>();

		for(Map<String,Object>map:getList) {

		Todo_items todo_itemsList  = new Todo_items();


		todo_itemsList.setId((int)map.get("id"));
		todo_itemsList.setUser_id((int)map.get("user_id"));
		todo_itemsList.setItem_name((String)map.get("item_name"));
		todo_itemsList.setRegistration_date((Date)map.get("registration_date"));
		todo_itemsList.setExpire_date((Date)map.get("expire_date"));
		todo_itemsList.setFinished_date((Date)map.get("finished_date"));
		todo_itemsList.setIs_deleted((int)map.get("is_deleted"));
		todo_itemsList.setCreate_date_time((Date)map.get("create_date_time"));
		todo_itemsList.setUser((String)map.get("user"));


		todo_items.add(todo_itemsList);

		}

		return todo_items;
	}



		@Override
		public int finished(Todo_items todo_items)throws DataAccessException{

			        String sql="UPDATE todo_items SET "
			        		                   +"finished_date=? "
			        		                   +" WHERE id=?;";

			        int rowNumber=jdbc.update(sql,
			        		                 todo_items.getFinished_date(),
			        		                 todo_items.getId());

					return rowNumber;
    }

}

