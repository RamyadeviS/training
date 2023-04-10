package com.epassproject.epassform.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epassproject.epassform.model.EpassForm;

public class TravelHistoryMapper implements RowMapper {

	@Override
	public 	EpassForm mapRow(ResultSet rs, int rowNum) throws SQLException {
		EpassForm epass = new EpassForm();

		Long applicationNo = rs.getLong("application_no");
		epass.setApplicationNo(applicationNo);
		
		return epass;
	}

}
