package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.beans.User;
import com.revature.repositories.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserService us;
	
	@Mock
	private UserRepository ur;
	
	@Test
	public void testCreatingUser() {
		
		int expected = 1;
		User u = new User(1, "adonisc", "password", "admin");
		when(ur.createUser(u)).thenReturn(1);
		int actual = us.createUser(u);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGettingUsers() {
		
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		
		when(ur.getUsers()).thenReturn(users);
		assertEquals(us.getUsers().size(),3);
	}
	
	@Test
	public void testGettingUserByUsernameAndPassword() {
		
		User expected = new User(1, "adonisc", "password", "admin");
		when(ur.getUserByUsernameAndPassword("adonisc", "password")).thenReturn(new User(1, "adonisc", "password", "adnin"));
		User actual = ur.getUserByUsernameAndPassword("adonisc", "password");
		assertEquals(expected, actual);
	}

}
