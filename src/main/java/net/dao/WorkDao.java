package net.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.entities.Work;
import net.entities.WorkMapper;

@Repository
@Transactional
public class WorkDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(Work work) {
		String sql = "INSERT INTO works (work_id, work_status) VALUES (?, ?)";
		jdbcTemplate.update(sql, work.getWork_id(), work.getWork_status());
	}
	
	public void delete(String work_id) {
		String sql = "DELETE FROM works WHERE work_id = ?";
		jdbcTemplate.update(sql, work_id);
	}
	
	public void update(Work work) {
		String sql = "UPDATE works SET work_status = ? WHERE work_id = ?";
		jdbcTemplate.update(sql, work.getWork_status(), work.getWork_id());
	}
	
	public Work findById(String work_id) {
		String sql = "SELECT * FROM works WHERE work_id = ?";
		return jdbcTemplate.queryForObject(sql, new WorkMapper(), work_id);
	}
	
	public List<Work> findAll() {
		String sql = "SELECT * FROM works";
		return jdbcTemplate.query(sql, new WorkMapper());
	}
}
