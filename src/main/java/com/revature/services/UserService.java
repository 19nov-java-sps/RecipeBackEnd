package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;

	public UserService() {
		super();
	}
	
	public int createUser(User u) {
		
		return ur.createUser(u);
	}
	
	public List<User> getUsers() {
		
		return ur.getUsers();
	}
	
	public User getUserByUsername(String username) {
		
		return ur.getUserByUsername(username);
	}
	
	public User getUserByUsernameAndPassword(String username, String password) {
		
		return ur.getUserByUsernameAndPassword(username, password);
	}
	
	public void deleteUser(int id) {
		
		ur.deleteUser(id);
	}
	
	public void editUser(User u) {
		ur.editUser(u);
	}
	
	
}
