package com.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	TestService service;

	@RequestMapping("/count")
	Integer getCountOfUsers() {
		return service.getCountOfUsers();

	}
	
	
	@RequestMapping("/users/name/{id}/{address}")
	String getUserName(@PathVariable int id,@PathVariable String address) {
		return service.getUserName(id, address);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addUser")
	public int addUser(@RequestBody User user)
	{
		
		return service.addUser(user);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/updateUser")
	public int updateUser(@RequestBody User user)
	{
		return service.updateUser(user);
	}
	//Delete
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/{id}")
	public int removeUser(@PathVariable int id)
	{
		return service.removeUser(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
	List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getuser/byid/{id}")
	User getUserById(@PathVariable int id) {
		return service.getUserById(id);
	}
}
