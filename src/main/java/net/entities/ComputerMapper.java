package net.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ComputerMapper implements RowMapper<Computer>{
	 public Computer mapRow(ResultSet rs, int rowNum) throws SQLException {
		 	Computer computer = new Computer();
		 	computer.setComputer_id(rs.getString("computer_id"));
		 	computer.setComputer_status(rs.getString("computer_status"));
		 	computer.setBill_id(rs.getString("bill_id"));
		    return computer;
		  }

}
