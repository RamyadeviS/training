package com.epassproject.epassform.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.jdbc.core.RowMapper;

import com.epassproject.epassform.model.EpassForm;

public class GetEpassMapper implements RowMapper<EpassForm> {

	@Override
	public EpassForm mapRow(ResultSet rs, int rowNum) throws SQLException {
		EpassForm epass = new EpassForm();

		Long applicationNo = rs.getLong("application_no");
		epass.setApplicationNo(applicationNo);

		String applicantName = rs.getString("applicant_name");
		epass.setApplicantName(applicantName);

		Long aadharNo = rs.getLong("aadhar_no");
		epass.setAadharNo(aadharNo);
		
		String reason = rs.getString("reason");
		epass.setReason(reason);

		String fromDistrict = rs.getString("from_district");
		epass.setFromDistrict(fromDistrict);

		String toDistrict = rs.getString("to_district");
		epass.setToDistrict(toDistrict);

		Date travelDate = rs.getDate("travel_date");
		epass.setTravelDate(travelDate);

		Date returnDate = rs.getDate("return_date");
		epass.setReturnDate(returnDate);

		Integer noOfPassengers = rs.getInt("no_of_passengers");
		epass.setNoOfPassengers(noOfPassengers);

		String vehicleNo = rs.getString("vehicle_no");
		epass.setVehicleNo(vehicleNo);

		Long mobileNo = rs.getLong("mobile_no");
		epass.setMobileNo(mobileNo);
		
		String status = rs.getString("status");
		epass.setStatus(status);


		return epass;
	}
}
