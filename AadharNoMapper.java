package com.epassproject.epassform.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epassproject.epassform.model.UserDetails;

public class AadharNoMapper implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetails register = new UserDetails();
		Long aadharNo = rs.getLong("aadhar_no");
		register.setAadharNo(aadharNo);
		return register;
	}
}
