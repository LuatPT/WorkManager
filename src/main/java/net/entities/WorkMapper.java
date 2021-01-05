package net.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class WorkMapper implements RowMapper<Work>{
	 public Work mapRow(ResultSet rs, int rowNum) throws SQLException {
		 	Work work = new Work();
		 	work.setWork_id(rs.getString("work_id"));
		 	work.setWork_name(rs.getString("work_name"));
		 	work.setWork_start(rs.getString("work_start"));
		 	work.setWork_end(rs.getString("work_end"));
		 	work.setWork_percent(rs.getInt("work_percent"));
		 	work.setWork_status(rs.getString("work_status"));
		 	work.setUser_id(rs.getString("user_id"));
		    return work;
		  }

}
