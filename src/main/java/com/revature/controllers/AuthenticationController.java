package com.revature.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class AuthenticationController {
	
	@Autowired
	private UserService us;
	
	@PostMapping(consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void authenticate(@RequestParam("username") String username,
							 @RequestParam("password") String password, HttpServletResponse response) {
		
		User u = us.getUserByUsernameAndPassword(username, password);

		if (u != null && u.getPassword().equals(password)) {
			String token = u.getUsername() + ":" + u.getId();
			response.setStatus(200);
			response.setHeader("access-control-expose-headers", "Authorization");
			response.setHeader("Authorization", token);
		} else {
			response.setStatus(400);
		}
	}
}