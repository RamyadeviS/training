package com.epassproject.epassform.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epassproject.epassform.model.UserDetails;

public class UserLoginMapper implements RowMapper<UserDetails> {
	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetails register = new UserDetails();
        
		Long aadharNo = rs.getLong("aadhar_no");
		register.setAadharNo(aadharNo);

		
		String userName = rs.getString("user_name");
		register.setUserName(userName);

		String password = rs.getString("password");
		register.setPassword(password);
		return register;
	}
}