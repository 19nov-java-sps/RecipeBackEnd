package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@PostMapping
	public int createUser(@RequestBody User u) {
		
		return us.createUser(u);
	}
	
	@GetMapping
	public List<User> getUsers() {
		
		return us.getUsers();
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable(value="id")int id) {
		us.deleteUser(id);
	}
	
	@PutMapping(value = "/edit")
	public void editUser(@RequestBody User u) {
		us.editUser(u);
	}
}
