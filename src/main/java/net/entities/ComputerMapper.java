package net.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ComputerMapper implements RowMapper<Computer>{
	 public Computer mapRow(ResultSet rs, int rowNum) throws SQLException {
		 	Computer computer = new Computer();
		 	computer.setComputer_id(rs.getInt("computer_id"));
		 	computer.setComputer_status(rs.getString("computer_status"));
		    return computer;
		  }

}
