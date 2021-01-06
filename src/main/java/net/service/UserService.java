package net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dao.UserDao;
import net.entities.User;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	public void save (User user) {
		userDao.save(user);
	}
	
	public User checkUser (User user) {
		return userDao.checkUser(user.getUser_name(), user.getPassword());
	}
}
