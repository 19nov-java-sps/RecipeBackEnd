package com.revature.repositories.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;
import com.revature.repositories.UserRepository;
import com.revature.util.HibernateUtil;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Override
	public int createUser(User u) {
		
		int userCreated = 0;
		try(Session s = HibernateUtil.getSession()) {
			
			Transaction tx = s.beginTransaction();
			userCreated = (int) s.save(u);
			tx.commit();
			return userCreated;
		}
	}
	
	@Override
	public List<User> getUsers() {
		
		try(Session s = HibernateUtil.getSession()) {
			
			String hql = "from User";
			Query<User> q = s.createQuery(hql, User.class);
			List<User> users = q.getResultList();
			if (users.size() != 0) {
				return users;
			}
			return null;
		}
	}
	
	@Override
	public User getUserByUsername(String username) {
		
		try(Session s = HibernateUtil.getSession()) {
			
			String hql = "from User where user_name = :usernameVar";
			Query<User> q = s.createQuery(hql, User.class);
			q.setParameter("usernameVar", username);
			List<User> u = q.getResultList();
			if (u.get(0) != null) {
				return u.get(0);
			}
			return null;
		}
	}
	
	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		
		try(Session s = HibernateUtil.getSession()) {
			
			String hql = "from User where user_name = :usernameVar and pass_word = :passwordVar";
			Query<User> q = s.createQuery(hql, User.class);
			q.setParameter("usernameVar", username);
			q.setParameter("passwordVar", password);
			List<User> u = q.getResultList();
			if (u.size() != 0) {
				return u.get(0);
			}
			return null;
		}
	}

}
