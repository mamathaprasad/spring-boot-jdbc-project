package com.training;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate template;

	Integer getCountOfUsers() {
		return template.queryForObject("select count(*) from user", Integer.class);
	}

	String getUserName(int id, String address) {
		/* Integer ID = new Integer(id); */
		return template.queryForObject("select name from user where id=? and address=?", new Object[] { id, address },
				String.class);
	}

	

	//Add a user
		public int addUser(User user){
	        String query = "INSERT INTO user VALUES(?,?,?)";
	        return template.update(query,user.getId(),user.getName(),user.getAddress());
	}
		//Delete a user
		public int removeUser(int id){
	        String sql= "DELETE FROM user WHERE ID =?";
	        return template.update(sql,id);
	    }
		//update a user
		public int updateUser(User user)
		{
			String sql="update user set  address=? where id=?";
			return template.update(sql,user.getAddress(),user.getId());
		}
//list of users
	List<User> getAllUsers() {
		List<User> listUsers = template.query("select * from user"
					,new UserMapper() 
				);
		return listUsers;

	}
	User getUserById(int id) {

		return template.queryForObject("select * from user where id=?", new Object[] { id }, new UserMapper());
	}

	class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();


			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setAddress(rs.getString("address"));

			return user;
		}

	}

}
