package com.revature.repositories;

import java.util.List;

import com.revature.beans.User;

public interface UserRepository {
	
	public int createUser(User u);
	public void deleteUser(int id);
	public void editUser(User u);
	public List<User> getUsers();
	public User getUserByUsername(String username);
	public User getUserByUsernameAndPassword(String username, String password);
}
