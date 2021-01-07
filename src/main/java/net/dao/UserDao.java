package net.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
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

	public void save(User user, String maxId) {
		String sql = "INSERT INTO users (user_id, user_name, password) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, maxId, user.getUser_name(), user.getPassword());
	}

	public User checkUser(String user_name, String password) {
		String sql = "SELECT * FROM users WHERE user_name = ? AND password = ? ";
		return jdbcTemplate.queryForObject(sql, new UserMapper(), user_name, password);
	}

	public boolean findById(String user_name) {
		String sql = "SELECT * FROM users WHERE user_name = ? ";
		boolean check = false;
		try {
			if (jdbcTemplate.queryForObject(sql, new UserMapper(), user_name) != null) {
				check = true;
			}
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Error");
		} catch (IncorrectResultSizeDataAccessException e) {
			System.out.println("Error");
		}
		return check;
	}

	public int checkMaxId() {
		String sql = "SELECT MAX(SUBSTRING(user_id, 4, 5)) FROM users ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
