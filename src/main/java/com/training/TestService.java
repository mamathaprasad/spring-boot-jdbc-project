package com.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	UserDao dao;
	
	Integer getCountOfUsers() {
		return dao.getCountOfUsers();
	}
	
	String getUserName(int id, String address) {
		return dao.getUserName(id, address);
	}
	public int addUser(User user)
	  {
		  return dao.addUser(user);
	  }
		public int updateUser(User user)
		{
			return dao.updateUser(user);
		}
		public int removeUser(int id)
		{
			return dao.removeUser(id);
		}
	
	List<User> getAllUsers() {
		return dao.getAllUsers();
	}
	
	User getUserById(int id) {
		return dao.getUserById(id);
	}
}
