package com.epassproject.epassform.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epassproject.epassform.model.AdminLogin;

public class AdminLoginMapper implements RowMapper<AdminLogin> {
	@Override
	public AdminLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminLogin admin = new AdminLogin();

		String mailId = rs.getString("mail_id");
		admin.setMailId(mailId);

		String password = rs.getString("password");
		admin.setPassword(password);
		return admin;

	}
}