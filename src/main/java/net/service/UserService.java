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
	public void save (User user, String maxId) {
		userDao.save(user, maxId);
	}
	
	public User checkUser (User user) {
		return userDao.checkUser(user.getUser_name(), user.getPassword());
	}
	
	public boolean findById (String user_name) {
		return userDao.findById(user_name);
	}
	
	public int checkMaxId () {
		return userDao.checkMaxId();
	}
}
