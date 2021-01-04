package net.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.entities.Computer;
import net.entities.ComputerMapper;

@Repository
@Transactional
public class ComputerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(Computer computer) {
		String sql = "INSERT INTO computers (computer_id, computer_status) VALUES (?, ?)";
		jdbcTemplate.update(sql, computer.getComputer_id(), computer.getComputer_status());
	}
	
	public void delete(String computer_id) {
		String sql = "DELETE FROM computers WHERE computer_id = ?";
		jdbcTemplate.update(sql, computer_id);
	}
	
	public void update(Computer computer) {
		String sql = "UPDATE computers SET computer_status = ? WHERE computer_id = ?";
		jdbcTemplate.update(sql, computer.getComputer_status(), computer.getComputer_id());
	}
	
	public Computer findById(String computer_id) {
		String sql = "SELECT * FROM computers WHERE computer_id = ?";
		return jdbcTemplate.queryForObject(sql, new ComputerMapper(), computer_id);
	}
	
	public List<Computer> findAll() {
		String sql = "SELECT * FROM computers";
		return jdbcTemplate.query(sql, new ComputerMapper());
	}
}
