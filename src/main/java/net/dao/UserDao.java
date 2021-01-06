package net.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.entities.User;
import net.entities.UserMapper;

@Repository
@Transactional
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(User user) {
		String sql = "INSERT INTO users (user_id, user_name, password) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, user.getUser_id(), user.getUser_name(), user.getPassword());
	}
	
	public User checkUser(String user_name, String password) {
		String sql = "SELECT * FROM users WHERE user_name = ? AND password = ? ";
		return jdbcTemplate.queryForObject(sql, new UserMapper(), user_name, password);
	}
}
