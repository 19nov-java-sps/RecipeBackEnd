package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
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
}
