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

import com.example.demo.login.domain.model.Users;
import com.example.demo.login.domain.repository.UsersDao;

@Repository("UsersDaoJdbcImpl")
public class UsersDaoJdbcImpl implements UsersDao {




	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public int insertOne(Users users)throws DataAccessException{

		String sql = "INSERT INTO  users2("
				+" user,"
				+" pass,"
				+" family_name,"
				+" first_name,"
				+" is_deleted,"
			    +" role) "
			    +" VALUES(?,?,?,?,?,?)";


		       int rowNumber = jdbc.update(sql,
						                    users.getUser(),
						                    users.getPassword(),
						                    users.getFamily_name(),
						                    users.getFirst_name(),
						                    users.getIs_deleted(),
						                    users.getRole());
				return rowNumber;
	}



	@Override
	public int count()throws DataAccessException{

		int count = jdbc.queryForObject("SELECT COUNT(*) FROM users2", Integer.class);


		return count;
	}







	@Override
	public Users selectOne(String userId)throws DataAccessException{

	   Map<String, Object> map = jdbc.queryForMap("SELECT * FROM users2 WHERE id = ?" , userId);

	     Users users = new Users();

		   users.setId((int)map.get("id"));
	       users.setUser((String)map.get("user"));
	       users.setPassword((String)map.get("pass"));
	       users.setFamily_name((String)map.get("family_name"));
	       users.setFirst_name((String)map.get("first_name"));
	       users.setIs_deleted((int)map.get("is_deleted"));
	       users.setCreate_date_time((Date)map.get("create_date_time"));
	       users.setUpdate_date_time((Date)map.get("update_date_time"));
	       users.setRole((String)map.get("role"));

	   return users;
	}



	@Override
	public List<Users>selectMany()throws DataAccessException{

			List<Map<String,Object>>getList= jdbc.queryForList("SELECT * FROM users2");

				List<Users>usersList= new ArrayList<>();

				  for(Map<String,Object>map:getList) {

					Users users = new Users();

						users.setId((int)map.get("id"));
					    users.setUser((String)map.get("user"));
					    users.setPassword((String)map.get("pass"));
					    users.setFamily_name((String)map.get("family_name"));
					    users.setFirst_name((String)map.get("first_name"));
					    users.setIs_deleted((int)map.get("is_deleted"));
					    users.setCreate_date_time((Date)map.get("create_date_time"));
					    users.setUpdate_date_time((Date)map.get("update_date_time"));
					    users.setRole((String)map.get("role"));


					usersList.add(users);
				 }

		return usersList;
	}



	@Override
	public int updateOne(Users users)throws DataAccessException{

		return 0;
	}



	@Override
	public int deleteOne(int userId)throws DataAccessException{

		return 0;
	}



	@Override
	public void userCsvOut()throws DataAccessException{


	}










}

