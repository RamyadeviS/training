package com.epassproject.epassform.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import com.epassproject.epassform.mapper.AadharNoMapper;
import com.epassproject.epassform.mapper.EpassFormMapper;
import com.epassproject.epassform.mapper.EpassStatusMapper;
import com.epassproject.epassform.mapper.GetEpassMapper;
import com.epassproject.epassform.mapper.GetTravelPassMapper;
import com.epassproject.epassform.mapper.MailIdExistingMapper;
import com.epassproject.epassform.mapper.ProfileMapper;
import com.epassproject.epassform.mapper.TravelEpassFormMapper;
import com.epassproject.epassform.mapper.TravelHistoryMapper;
import com.epassproject.epassform.mapper.TravelPassStausMapper;
import com.epassproject.epassform.mapper.UserLoginMapper;
import com.epassproject.epassform.model.AdminLogin;
import com.epassproject.epassform.model.EpassForm;
import com.epassproject.epassform.model.UserDetails;
import com.epassproject.epassform.model.TravelEpassForm;
import com.epassproject.epassform.myexception.DuplicationOfAadharNoException;
import com.epassproject.epassform.myexception.DuplicationOfMailIdException;
import com.epassproject.epassform.myexception.InvalidAadharNoException;
import com.epassproject.epassform.myexception.InvalidPwdException;
import com.epassproject.epassform.util.ConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EpassDao implements EpassInterface {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	Logger logger = LoggerFactory.getLogger(EpassDao.class);
	// crud-DB activities

	public void userRegister(UserDetails register, HttpSession session) {
		logger.info("To register Epass");
		String user = "Insert into userDetails1(aadhar_no,user_name,mail_id,password,mobile_no)values(?,?,?,?,?)";
		Object[] params = { register.getAadharNo(), register.getUserName(), register.getMailId(),
				register.getPassword(), register.getMobileNo() };
		jdbcTemplate.update(user, params);
		session.setAttribute("UserName", register.getUserName());
		session.setAttribute("AadharNo", register.getAadharNo());
	}

	public Boolean mailIdExisting(String mailId,Model model) {
		System.out.println("check"+mailId);
		String query = "Select mail_id from userDetails1";
		List<UserDetails> regList = jdbcTemplate.query(query, new MailIdExistingMapper());
		for (UserDetails registers : regList) {
			String email = registers.getMailId();
			logger.info(email);

			if (email.equals(mailId)) {
				 String errorMessage = "Email Id Already exist ";
	                model.addAttribute("errorMessage17", errorMessage);
	                
	                return false;

	            }
	        }
	        return true;
	    }
	
	public Boolean aadharNoExisting(Long aadharNo,Model model) {
		UserDetails register = new UserDetails();
		register.getAadharNo();

		String query = "Select aadhar_no from userDetails1";
		List<UserDetails> regList = jdbcTemplate.query(query, new AadharNoMapper());
		for (UserDetails registers : regList) {
			Long aNo = registers.getAadharNo();
			if (aNo.equals(aadharNo)) {
				 String errorMessage = "Aadhar Number Already exist ";
	                model.addAttribute("errorMessage18", errorMessage);
	                return false;

	            } else
	                logger.info("Valid Aadhar Number ");
	        }
	        return true;
	    }
	
	public boolean userLogin(UserDetails register, HttpSession session) {
			
		String userName = register.getUserName();
		String password = register.getPassword();
		Long aadharNo = register.getAadharNo();

		logger.info("To Login user");
		String query = "Select user_name,password,aadhar_no from userDetails1 where user_name=?";
		List<UserDetails> userList = jdbcTemplate.query(query, new UserLoginMapper(), userName);

		session.setAttribute("UserName", register.getUserName());
		session.setAttribute("AadharNo", register.getAadharNo());

		for (UserDetails userLi : userList) {
			userLi.getUserName();
			String pwd = userLi.getPassword();
			Long aNo = userLi.getAadharNo();

			if (pwd.equals(password)) {
				
				String sql = "Select application_no, applicant_name,aadhar_no ,reason,from_district ,to_district,travel_date ,return_date,no_of_passengers,vehicle_no, mobile_no,status from epassApply where aadhar_no=?";
				List<EpassForm> getEpass = jdbcTemplate.query(sql, new GetEpassMapper(), aadharNo);
				List<Map<String, Object>> epassGetList = new ArrayList<>();
				for (EpassForm approveList : getEpass) {
					Map<String, Object> approveListMap = new HashMap<>();
					
					approveListMap.put("Application No", approveList.getApplicationNo());
					Long applicationNo = approveList.getApplicationNo();
					session.setAttribute("ApplicationNumber", applicationNo);

					approveListMap.put("Applicant_Name", approveList.getApplicantName());
					String name = approveList.getApplicantName();
					session.setAttribute("Applicant_Name", name);

					approveListMap.put("Aadhar_No", approveList.getAadharNo());
					Long aadharNumber = approveList.getAadharNo();
					session.setAttribute("AadharsNo", aadharNumber);

					approveListMap.put("Reason", approveList.getReason());
					String reason = approveList.getReason();
					session.setAttribute("Reason", reason);

					approveListMap.put("From_District", approveList.getFromDistrict());
					String fromDistrict = approveList.getFromDistrict();
					session.setAttribute("From_District", fromDistrict);

					approveListMap.put("To_District", approveList.getToDistrict());
					String toDistrict = approveList.getToDistrict();
					session.setAttribute("To_District", toDistrict);

					approveListMap.put("Travel_Date", approveList.getTravelDate());
					Date travelDate = approveList.getTravelDate();
					session.setAttribute("Travel_Date", travelDate);

					approveListMap.put("Return_Date", approveList.getReturnDate());
					Date returnDate = approveList.getReturnDate();
					session.setAttribute("Return_Date", returnDate);

					approveListMap.put("No_of_passengers", approveList.getNoOfPassengers());
					Integer passengers = approveList.getNoOfPassengers();
					session.setAttribute("No_of_passengers", passengers);

					approveListMap.put("VehicleNo", approveList.getVehicleNo());
					String vehicleNo = approveList.getVehicleNo();
					session.setAttribute("VehicleNo", vehicleNo);

					approveListMap.put("Mobile_No", approveList.getMobileNo());
					Long mobileNo = approveList.getMobileNo();
					session.setAttribute("Mobile_No", mobileNo);
					
					approveListMap.put("Status", approveList.getStatus());
					String status = approveList.getStatus();
					session.setAttribute("Status", status);
					System.out.println(status);
					

					epassGetList.add(approveListMap);
					//System.out.println(epassGetList);	
				
					String sql1 = "Select application_no,applicant_name,ticket_no,aadhar_no,mobile_no,source,destination,travel_date,return_date,reason,no_of_passengers,status from travelHistory where aadhar_no=?";
					List<TravelEpassForm> travelPassView = jdbcTemplate.query(sql1, new GetTravelPassMapper(),aadharNo);
					List<Map<String, Object>> travelApproveList = new ArrayList<>();
					for (TravelEpassForm travelApprove : travelPassView) {
						Map<String, Object> travelApproveListMap = new HashMap<>();
						
						travelApproveListMap.put("application_number", travelApprove.getApplicationNumber());
						Long applicationNumber = travelApprove.getAadharNumber();
			            session.setAttribute("Application_Number", applicationNumber);
						
						travelApproveListMap.put("Applicant name", travelApprove.getApplicantName1());
						String applicantName = travelApprove.getApplicantName1();
						session.setAttribute("ApplicantName", applicantName);

						
						travelApproveListMap.put("Ticket_No", travelApprove.getTicketNo());
						String ticketNumber = travelApprove.getTicketNo();
						session.setAttribute("TicketNo", ticketNumber);

						
						travelApproveListMap.put("Aadhar_No", travelApprove.getAadharNumber());
						Long aadharNo1 = travelApprove.getAadharNumber();
						session.setAttribute("AadharNo", aadharNo1);

						
						travelApproveListMap.put("Mobile_No", travelApprove.getPhoneNumber());
						Long mobileNumber = travelApprove.getPhoneNumber();
						session.setAttribute("MobileNo", mobileNumber);

						
						travelApproveListMap.put("Source", travelApprove.getSource());
						String source = travelApprove.getSource();
						session.setAttribute("Source", source);

						
						travelApproveListMap.put("Destination", travelApprove.getDestination());
						String destination = travelApprove.getDestination();
						session.setAttribute("Destination", destination);

						
						travelApproveListMap.put("From_Date", travelApprove.getFromDate());
						Date fromDate = travelApprove.getFromDate();
						session.setAttribute("From_Date", fromDate);

						
						travelApproveListMap.put("To_Date", travelApprove.getToDate());
						Date toDate = travelApprove.getFromDate();
						session.setAttribute("To_Date", toDate);

						
						travelApproveListMap.put("Reasons", travelApprove.getReasons());
						String reasons = travelApprove.getReasons();
						session.setAttribute("Reasons", reasons);

						
						travelApproveListMap.put("Passengers", travelApprove.getPassengers());
						Integer passenger = travelApprove.getPassengers();
						session.setAttribute("Passengers", passenger);

						travelApproveListMap.put("Status1", travelApprove.getAction());
						String action = travelApprove.getAction();
						session.setAttribute("Status1", action);

						travelApproveList.add(travelApproveListMap);

				logger.info("Login Successfully");
				session.setAttribute("aadhar", aadharNo);
			
			}
				}
			}
			else {
				return false;
			}

			if (aNo.equals(aadharNo)) {
				logger.info("Login Successfully");
				return true;
			}

			else {
				return false;
			}

		}
		return false;
	}

	public void epassApplyForm(EpassForm epass, HttpSession session,Model model) {
		logger.info("To apply Epass");
		String apply = "Insert into epassApply(applicant_name,aadhar_no,gender,reason,father_name ,dob, from_district ,to_district ,state ,travel_date ,return_date,no_of_passengers ,vehicle_no, mobile_no ,vaccination_certificate,status,Certificate_image)values(?,?,?,?,?,?,?,?,'Tamilnadu',?,?,?,?,?,?,'Pending',?)";

		logger.info(apply);
		Object[] params = { epass.getApplicantName(), epass.getAadharNo(), epass.getGender(), epass.getReason(),
				epass.getFatherName(), epass.getDob(), epass.getFromDistrict(), epass.getToDistrict(),
				epass.getTravelDate(), epass.getReturnDate(), epass.getNoOfPassengers(), epass.getVehicleNo(),
				epass.getMobileNo(), epass.getVaccinationCertificate(), epass.getImage() };
		jdbcTemplate.update(apply, params);
		session.setAttribute("UserName", epass.getApplicantName());
		session.setAttribute("AadharNo", epass.getAadharNo());
	}

	public void travelPassApplyForm(TravelEpassForm travelPass, HttpSession session,Model model) {
		logger.info("To apply Epass");
		String travelPassApply = "insert into travelHistory(applicant_name,gender,father_name,ticket_no,dob,aadhar_no,mobile_no,source,destination,travel_date,return_date,reason,no_of_passengers,vaccination_certificate,status,Certificate_image)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,'Pending',?)";
		Object[] params = { travelPass.getApplicantName1(), travelPass.getGender1(), travelPass.getFatherName1(),
				travelPass.getTicketNo(), travelPass.getDateOfBirth(), travelPass.getAadharNumber(),
				travelPass.getPhoneNumber(), travelPass.getSource(), travelPass.getDestination(),
				travelPass.getFromDate(), travelPass.getToDate(), travelPass.getReasons(), travelPass.getPassengers(),
				travelPass.getCovidCertificate(), travelPass.getImages() };
		jdbcTemplate.update(travelPassApply, params);
		session.setAttribute("UserName", travelPass.getApplicantName1());
		session.setAttribute("AadharNo", travelPass.getAadharNumber());
		
	}

	public void adminLogin(AdminLogin admin) throws InvalidPwdException {
		String mailId = admin.getMailId();
		String pass = admin.getPassword();

		logger.info("To Login Admin");
		if (!mailId.equals("admin@gmail.com'")) {
			String input = "admin712";
			if (!pass.equals(input)) {
				throw new InvalidPwdException();
			} else
				logger.info("Login Successfully!!!...");
		}

	}

	public void listEpassform(Model model) throws JsonProcessingException {
		String sql = "Select application_no, applicant_name,aadhar_no ,gender,reason,father_name ,dob, from_district ,to_district ,state ,travel_date ,return_date,no_of_passengers ,vehicle_no, mobile_no ,vaccination_certificate,status,Certificate_image from epassApply";
		List<EpassForm> epassView = jdbcTemplate.query(sql, new EpassFormMapper());
		List<Map<String, Object>> epassList = new ArrayList<>();
		for (EpassForm list : epassView) {
			Map<String, Object> userListMap = new HashMap<>();
			userListMap.put("application_no", list.getApplicationNo());
			userListMap.put("applicant_name", list.getApplicantName());
			userListMap.put("aadhar_no", list.getAadharNo());
			userListMap.put("gender", list.getGender());
			userListMap.put("reason", list.getReason());
			userListMap.put("father_name", list.getFatherName());
			userListMap.put("dob", list.getDob());
			userListMap.put("from_district", list.getFromDistrict());
			userListMap.put("to_district", list.getToDistrict());
			userListMap.put("state", list.getState());
			userListMap.put("travel_date", list.getTravelDate());
			userListMap.put("return_date", list.getReturnDate());
			userListMap.put("no_of_passengers", list.getNoOfPassengers());
			userListMap.put("vehicle_no", list.getVehicleNo());
			userListMap.put("mobile_no", list.getMobileNo());
			userListMap.put("status", list.getStatus());
			userListMap.put("vaccination_certificate", list.getVaccinationCertificate());
			userListMap.put("Certificate_image", list.getImage());

			epassList.add(userListMap);

		}
		ObjectMapper epassMapper = new ObjectMapper();
		String epassAction = epassMapper.writeValueAsString(epassList);
		//System.out.println(epassAction + "epassAction");
		model.addAttribute("userList", epassAction);
	}

	public List<EpassForm> listEpassformImage(Integer appId) {
		String sql = "Select application_no, applicant_name,aadhar_no ,gender,reason,father_name ,dob, from_district ,to_district ,state ,travel_date ,return_date,no_of_passengers ,vehicle_no, mobile_no ,vaccination_certificate,status,Certificate_image from epassApply where application_no=?";
		return jdbcTemplate.query(sql, new EpassFormMapper(), appId);
	}

	public List<EpassForm> approveEpass(Model model, HttpSession session) {
		String sql = "Select application_no, applicant_name,aadhar_no ,gender,reason,father_name ,dob, from_district ,to_district ,state ,travel_date ,return_date,no_of_passengers ,vehicle_no, mobile_no ,vaccination_certificate,status,Certificate_image from epassApply where status='Approved'";
		List<EpassForm> epassView = jdbcTemplate.query(sql, new EpassFormMapper());
		List<Map<String, Object>> epassApproveList = new ArrayList<>();
		for (EpassForm approveList : epassView) {
			Map<String, Object> approveListMap = new HashMap<>();
			approveListMap.put("Application No", approveList.getApplicationNo());
			approveListMap.put("Applicant Name", approveList.getApplicantName());
			/*
			 * String name=approveList.getApplicantName();
			 * session.setAttribute("ApplicantName", name);
			 */
			approveListMap.put("Aadhar No", approveList.getAadharNo());
			approveListMap.put("Gender", approveList.getGender());
			approveListMap.put("Reason", approveList.getReason());
			approveListMap.put("Father Name", approveList.getFatherName());
			approveListMap.put("DOB", approveList.getDob());
			approveListMap.put("From District", approveList.getFromDistrict());
			approveListMap.put("To District", approveList.getToDistrict());
			approveListMap.put("State", approveList.getState());
			approveListMap.put("Travel Date", approveList.getTravelDate());
			approveListMap.put("Return Date", approveList.getReturnDate());
			approveListMap.put("No_of_passengers", approveList.getNoOfPassengers());
			approveListMap.put("Vehicle No", approveList.getVehicleNo());
			approveListMap.put("Mobile No", approveList.getMobileNo());
			approveListMap.put("Status", approveList.getStatus());
			approveListMap.put("Vaccination Certificate", approveList.getVaccinationCertificate());
			approveListMap.put("Certificate_Image", approveList.getImage());

			epassApproveList.add(approveListMap);
		}
		List<Map<String, Object>> ePass = epassApproveList.stream().toList();
		model.addAttribute("epassApproveList", ePass);
		return epassView;
	}

	public List<EpassForm> approveEpassformImage(Integer appNo) {
		String sql = "Select application_no, applicant_name,aadhar_no ,gender,reason,father_name ,dob, from_district ,to_district ,state ,travel_date ,return_date,no_of_passengers ,vehicle_no, mobile_no ,vaccination_certificate,status,Certificate_image from epassApply where status='Approved'";
		return jdbcTemplate.query(sql, new EpassFormMapper(), appNo);
	}

	public List<EpassForm> rejectEpass(Model model) {
		String sql = "Select application_no, applicant_name,aadhar_no ,gender,reason,father_name ,dob, from_district ,to_district ,state ,travel_date ,return_date,no_of_passengers ,vehicle_no, mobile_no ,vaccination_certificate,status,Certificate_image from epassApply where status='Rejected'";
		List<EpassForm> epassView = jdbcTemplate.query(sql, new EpassFormMapper());
		List<Map<String, Object>> epassRejectList = new ArrayList<>();
		for (EpassForm rejectList : epassView) {
			Map<String, Object> rejectListMap = new HashMap<>();
			rejectListMap.put("Application_no", rejectList.getApplicationNo());
			rejectListMap.put("Applicant_name", rejectList.getApplicantName());
			rejectListMap.put("Aadhar_no", rejectList.getAadharNo());
			rejectListMap.put("Gender1", rejectList.getGender());
			rejectListMap.put("Reason1", rejectList.getReason());
			rejectListMap.put("Father_name", rejectList.getFatherName());
			rejectListMap.put("Dob", rejectList.getDob());
			rejectListMap.put("From_district", rejectList.getFromDistrict());
			rejectListMap.put("To_district", rejectList.getToDistrict());
			rejectListMap.put("State1", rejectList.getState());
			rejectListMap.put("Travel_date", rejectList.getTravelDate());
			rejectListMap.put("Return_date", rejectList.getReturnDate());
			rejectListMap.put("No Of Passengers", rejectList.getNoOfPassengers());
			rejectListMap.put("Vehicle_no", rejectList.getVehicleNo());
			rejectListMap.put("Mobile_no", rejectList.getMobileNo());
			rejectListMap.put("Status1", rejectList.getStatus());
			rejectListMap.put("Vaccination_certificate", rejectList.getVaccinationCertificate());
			rejectListMap.put("Certificate_Image", rejectList.getImage());

			epassRejectList.add(rejectListMap);
		}
		List<Map<String, Object>> ePass = epassRejectList.stream().toList();
		model.addAttribute("epassRejectList", ePass);
		return epassView;
	}

	public List<EpassForm> pendingEpass(Model model) {
		String sql = "Select application_no, applicant_name,aadhar_no ,gender,reason,father_name ,dob, from_district ,to_district ,state ,travel_date ,return_date,no_of_passengers ,vehicle_no, mobile_no ,vaccination_certificate,status,Certificate_image from epassApply where status='Pending'";
		List<EpassForm> epassView = jdbcTemplate.query(sql, new EpassFormMapper());
		List<Map<String, Object>> epassPendingList = new ArrayList<>();
		for (EpassForm pendingList : epassView) {
			Map<String, Object> pendingListMap = new HashMap<>();
			pendingListMap.put("Application_no", pendingList.getApplicationNo());
			pendingListMap.put("Applicant_name", pendingList.getApplicantName());
			pendingListMap.put("Aadhar_no", pendingList.getAadharNo());
			pendingListMap.put("Gender1", pendingList.getGender());
			pendingListMap.put("Reason1", pendingList.getReason());
			pendingListMap.put("Father_name", pendingList.getFatherName());
			pendingListMap.put("Dob", pendingList.getDob());
			pendingListMap.put("From_district", pendingList.getFromDistrict());
			pendingListMap.put("To_district", pendingList.getToDistrict());
			pendingListMap.put("State1", pendingList.getState());
			pendingListMap.put("Travel_date", pendingList.getTravelDate());
			pendingListMap.put("Return_date", pendingList.getReturnDate());
			pendingListMap.put("No Of Passengers", pendingList.getNoOfPassengers());
			pendingListMap.put("Vehicle_no", pendingList.getVehicleNo());
			pendingListMap.put("Mobile_no", pendingList.getMobileNo());
			pendingListMap.put("Status1", pendingList.getStatus());
			pendingListMap.put("Vaccination_certificate", pendingList.getVaccinationCertificate());
			pendingListMap.put("CertificateImage", pendingList.getImage());

			epassPendingList.add(pendingListMap);
		}
		List<Map<String, Object>> ePass = epassPendingList.stream().toList();
		model.addAttribute("epassPendingList", ePass);
		return epassView;
	}

	public void listTravelPassForm(Model model) throws JsonProcessingException {
		String sql = "Select application_no,applicant_name,gender,father_name,ticket_no,dob,aadhar_no,mobile_no,source,destination,travel_date,return_date,reason,no_of_passengers,vaccination_certificate,status,Certificate_image from travelHistory";
		List<TravelEpassForm> travelPassView = jdbcTemplate.query(sql, new TravelEpassFormMapper());
		List<Map<String, Object>> travelList = new ArrayList<>();
		for (TravelEpassForm travel : travelPassView) {
			Map<String, Object> travelListMap = new HashMap<>();
			travelListMap.put("application_no", travel.getApplicationNumber());
			travelListMap.put("applicant_name", travel.getApplicantName1());
			travelListMap.put("gender", travel.getGender1());
			travelListMap.put("father_name", travel.getFatherName1());
			travelListMap.put("ticket_no", travel.getTicketNo());
			travelListMap.put("dob", travel.getDateOfBirth());
			travelListMap.put("aadhar_no", travel.getAadharNumber());
			travelListMap.put("mobile_no", travel.getPhoneNumber());
			travelListMap.put("source", travel.getSource());
			travelListMap.put("destination", travel.getDestination());
			travelListMap.put("travel_date", travel.getFromDate());
			travelListMap.put("return_date", travel.getToDate());
			travelListMap.put("reason", travel.getReasons());
			travelListMap.put("no_of_passengers", travel.getPassengers());
			travelListMap.put("vaccination_certificate", travel.getCovidCertificate());
			travelListMap.put("status", travel.getAction());
			travelListMap.put("Certificate_image", travel.getImages());

			travelList.add(travelListMap);

		}
		ObjectMapper travelMapper = new ObjectMapper();
		String travelAction = travelMapper.writeValueAsString(travelList);
		model.addAttribute("viewList", travelAction);

	}

	public List<TravelEpassForm> listTravelPassFormImage(Integer appId1) {
		String sql = "Select application_no,applicant_name,gender,father_name,ticket_no,dob,aadhar_no,mobile_no,source,destination,travel_date,return_date,reason,no_of_passengers,vaccination_certificate,status,Certificate_image from travelHistory where application_no=?";
		return jdbcTemplate.query(sql, new TravelEpassFormMapper(), appId1);
	}

	public List<TravelEpassForm> approveTravelPassForm(Model model) {
		String sql = "Select application_no,applicant_name,gender,father_name,ticket_no,dob,aadhar_no,mobile_no,source,destination,travel_date,return_date,reason,no_of_passengers,vaccination_certificate,status,Certificate_image from travelHistory where status='Approved'";
		List<TravelEpassForm> travelPassView = jdbcTemplate.query(sql, new TravelEpassFormMapper());
		List<Map<String, Object>> travelApproveList = new ArrayList<>();
		for (TravelEpassForm travelApprove : travelPassView) {
			Map<String, Object> travelApproveListMap = new HashMap<>();
			travelApproveListMap.put("application_number", travelApprove.getApplicationNumber());
			travelApproveListMap.put("Applicant name", travelApprove.getApplicantName1());
			travelApproveListMap.put("gender1", travelApprove.getGender1());
			travelApproveListMap.put("Father_Name", travelApprove.getFatherName1());
			travelApproveListMap.put("Ticket_No", travelApprove.getTicketNo());
			travelApproveListMap.put("DateOfBirth", travelApprove.getDateOfBirth());
			travelApproveListMap.put("Aadhar_No", travelApprove.getAadharNumber());
			travelApproveListMap.put("Mobile_No", travelApprove.getPhoneNumber());
			travelApproveListMap.put("Source", travelApprove.getSource());
			travelApproveListMap.put("Destination", travelApprove.getDestination());
			travelApproveListMap.put("From_Date", travelApprove.getFromDate());
			travelApproveListMap.put("To_Date", travelApprove.getToDate());
			travelApproveListMap.put("Reasons", travelApprove.getReasons());
			travelApproveListMap.put("Passengers", travelApprove.getPassengers());
			travelApproveListMap.put("Covid_Certificate", travelApprove.getCovidCertificate());
			travelApproveListMap.put("Action", travelApprove.getAction());
			travelApproveListMap.put("Certificate_images", travelApprove.getImages());

			travelApproveList.add(travelApproveListMap);

		}
		List<Map<String, Object>> travelPass = travelApproveList.stream().toList();
		model.addAttribute("ApproveList", travelPass);
		return travelPassView;
	}

	public List<TravelEpassForm> rejectTravelPassForm(Model model) {
		String sql = "Select application_no,applicant_name,gender,father_name,ticket_no,dob,aadhar_no,mobile_no,source,destination,travel_date,return_date,reason,no_of_passengers,vaccination_certificate,status,Certificate_image from travelHistory where status='Rejected'";
		List<TravelEpassForm> travelPassView = jdbcTemplate.query(sql, new TravelEpassFormMapper());
		List<Map<String, Object>> travelRejectList = new ArrayList<>();
		for (TravelEpassForm travelReject : travelPassView) {
			Map<String, Object> travelRejectListMap = new HashMap<>();
			travelRejectListMap.put("application_number", travelReject.getApplicationNumber());
			travelRejectListMap.put("Applicant_Name", travelReject.getApplicantName1());
			travelRejectListMap.put("gender1", travelReject.getGender1());
			travelRejectListMap.put("Father_Name", travelReject.getFatherName1());
			travelRejectListMap.put("Ticket_No", travelReject.getTicketNo());
			travelRejectListMap.put("DateOfBirth", travelReject.getDateOfBirth());
			travelRejectListMap.put("Aadhar_No", travelReject.getAadharNumber());
			travelRejectListMap.put("Mobile_No", travelReject.getPhoneNumber());
			travelRejectListMap.put("Source", travelReject.getSource());
			travelRejectListMap.put("Destination", travelReject.getDestination());
			travelRejectListMap.put("From_Date", travelReject.getFromDate());
			// System.out.println( travelReject.getFromDate());
			travelRejectListMap.put("To_date", travelReject.getToDate());
			travelRejectListMap.put("Reasons", travelReject.getReasons());
			travelRejectListMap.put("Passengers", travelReject.getPassengers());
			travelRejectListMap.put("Covid_Certificate", travelReject.getCovidCertificate());
			travelRejectListMap.put("Action", travelReject.getAction());
			travelRejectListMap.put("Certificate_images", travelReject.getImages());

			travelRejectList.add(travelRejectListMap);

		}
		List<Map<String, Object>> travelPass = travelRejectList.stream().toList();
		model.addAttribute("RejectList", travelPass);
		return travelPassView;
	}

	public List<TravelEpassForm> pendingTravelPassForm(Model model) {
		String sql = "Select application_no,applicant_name,gender,father_name,ticket_no,dob,aadhar_no,mobile_no,source,destination,travel_date,return_date,reason,no_of_passengers,vaccination_certificate,status,Certificate_image from travelHistory where status='Pending'";
		List<TravelEpassForm> travelPassView = jdbcTemplate.query(sql, new TravelEpassFormMapper());
		List<Map<String, Object>> travelPendingList = new ArrayList<>();
		for (TravelEpassForm travelPending : travelPassView) {
			Map<String, Object> travelPendingListMap = new HashMap<>();
			travelPendingListMap.put("Application Number", travelPending.getApplicationNumber());
			travelPendingListMap.put("Applicant Name", travelPending.getApplicantName1());
			travelPendingListMap.put("gender_", travelPending.getGender1());
			travelPendingListMap.put("Father Name", travelPending.getFatherName1());
			travelPendingListMap.put("Ticket No", travelPending.getTicketNo());
			travelPendingListMap.put("dob", travelPending.getDateOfBirth());
			travelPendingListMap.put("Aadhar Number", travelPending.getAadharNumber());
			travelPendingListMap.put("Mobile Number", travelPending.getPhoneNumber());
			travelPendingListMap.put("Source1", travelPending.getSource());
			travelPendingListMap.put("Destination1", travelPending.getDestination());
			travelPendingListMap.put("From Date", travelPending.getFromDate());
			travelPendingListMap.put("To Date", travelPending.getToDate());
			travelPendingListMap.put("Reason", travelPending.getReasons());
			travelPendingListMap.put("no of passengers", travelPending.getPassengers());
			travelPendingListMap.put("Covid Certificate", travelPending.getCovidCertificate());
			travelPendingListMap.put("action", travelPending.getAction());
			travelPendingListMap.put("certificateImage", travelPending.getImages());

			travelPendingList.add(travelPendingListMap);

		}
		List<Map<String, Object>> travelPass = travelPendingList.stream().toList();
		model.addAttribute("PendingList", travelPass);
		return travelPassView;
	}

	public void epassStatusUpdate(EpassForm epass) {
		logger.info("To Approve Epass");
		Long appNo = epass.getApplicationNo();
		Long applicationNumber = null;
		String applicationNo = appNo.toString();
		String updateStatus = "Update epassApply set status='Approved'where application_no=?";
		Object[] params = { appNo };
		jdbcTemplate.update(updateStatus, params);
	}

	public void epassStatusReject(EpassForm epass) {
		logger.info("To Reject Epass");
		String updateStatus = "update epassApply set status='Rejected' where application_no=?";
		Object[] params = { epass.getApplicationNo() };
		jdbcTemplate.update(updateStatus, params);
	}

	public void travelStatusApprove(TravelEpassForm travelPass) {
		logger.info("To Approve Travel Pass");
		String status = "update travelHistory set status='Approved' where application_no=?";
		Object[] params = { travelPass.getApplicationNumber() };
		jdbcTemplate.update(status, params);
	}

	public void travelStatusReject(TravelEpassForm travelPass) {
		logger.info("To Reject Travel Pass");
		String status = "update travelHistory set status='Rejected' where application_no=?";
		Object[] params = { travelPass.getApplicationNumber() };
		jdbcTemplate.update(status, params);
	}

	public void userEpassView(EpassForm epass) {
		logger.info("To view the Epass");
		String epassView = "Select application_no, applicant_name,aadhar_no ,gender,reason,father_name ,dob, from_district ,to_district ,state ,travel_date ,return_date,no_of_passengers ,vehicle_no, mobile_no ,vaccination_certificate,status from epassApply where application_no=?,status=?";
		Object[] params = { epass.getApplicationNo(), epass.getStatus() };
		jdbcTemplate.update(epassView, params);

	}

	public Integer totalEpassCount() {
		String sql = "SELECT COUNT(*) FROM epassApply";
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	public Integer totalTravelPassCount() {
		String sql = "SELECT COUNT(*) FROM travelHistory";
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	public Integer totalUserCount() {
		String sql = "Select (select count(*) from epassApply) + (select count(*) from travelHistory) sum from dual";
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	public Integer approvedCount() {
		String sql = "Select count(*) status from  epassApply where status = 'Approved'";
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	public Integer rejectedCount() {
		String sql1 = "Select count(*) status from  epassApply where status = 'Rejected'";
		return jdbcTemplate.queryForObject(sql1, Integer.class);

	}

	public Integer approveCount() {
		String sql = "Select count(*) status from  travelHistory where status = 'Approved'";
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	public Integer rejectCount() {
		String sql1 = "Select count(*) status from  travelHistory where status = 'Rejected'";
		return jdbcTemplate.queryForObject(sql1, Integer.class);

	}

	public Integer pendingEpassCount() {
		String sql = "Select count(*) status from  epassApply where status = 'Pending'";

		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	public Integer pendingCount() {
		String sql = "Select count(*) status from  travelHistory where status = 'Pending'";
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	public List<EpassForm> userView(EpassForm epass, Model model) {
		Long applicationNo = epass.getApplicationNo();
		String sql = "Select status from epassApply where application_no=?";
		List<EpassForm> epassStatusView = jdbcTemplate.query(sql, new EpassStatusMapper(), applicationNo);
		List<Map<String, Object>> epassList = new ArrayList<>();
		for (EpassForm epassStatus : epassStatusView) {
			Map<String, Object> epassStatusListMap = new HashMap<>();
			epassStatusListMap.put("status", epassStatus.getStatus());
			epassList.add(epassStatusListMap);

		}

		model.addAttribute("epassStatusView", epassList);
		return epassStatusView;
	}

	public List<TravelEpassForm> travelPassView(TravelEpassForm travelPass, Model model) {
		Long applicationNumber = travelPass.getApplicationNumber();
		String sql = "Select status from travelHistory where application_no=?";
		List<TravelEpassForm> travelPassView = jdbcTemplate.query(sql, new TravelPassStausMapper(), applicationNumber);
		List<Map<String, Object>> travelList = new ArrayList<>();
		for (TravelEpassForm travelPassStatus : travelPassView) {
			Map<String, Object> travelStatusListMap = new HashMap<>();
			travelStatusListMap.put("action", travelPassStatus.getAction());
			travelList.add(travelStatusListMap);
		}
		model.addAttribute("TravelPassStatusView", travelList);
		return travelPassView;
	}

	public void forgotPassword(UserDetails register) {
		logger.info("update password");

		String query = "Update userDetails1 set password=? where user_name=?";
		Object[] upd = { register.getPassword(), register.getUserName() };
		jdbcTemplate.update(query, upd);
		logger.info("Row updated");

	}

	public void epassHistory(Model model, HttpSession session) {
		String applicantName = session.getAttribute("UserName").toString();

		String sql = "Select application_no, applicant_name,aadhar_no ,gender,reason,father_name ,dob, from_district ,to_district ,state ,travel_date ,return_date,no_of_passengers ,vehicle_no, mobile_no ,vaccination_certificate,status,Certificate_image from epassApply where applicant_name=?";
		List<EpassForm> epassView = jdbcTemplate.query(sql, new EpassFormMapper(), applicantName);
		List<Map<String, Object>> epassList = new ArrayList<>();
		for (EpassForm list : epassView) {
			Map<String, Object> userListMap = new HashMap<>();
			userListMap.put("application_no", list.getApplicationNo());
			userListMap.put("applicant_name", list.getApplicantName());
			userListMap.put("aadhar_no", list.getAadharNo());
			userListMap.put("gender", list.getGender());
			userListMap.put("reason", list.getReason());
			userListMap.put("father_name", list.getFatherName());
			userListMap.put("dob", list.getDob());
			userListMap.put("from_district", list.getFromDistrict());
			userListMap.put("to_district", list.getToDistrict());
			userListMap.put("state", list.getState());
			userListMap.put("travel_date", list.getTravelDate());
			userListMap.put("return_date", list.getReturnDate());
			userListMap.put("no_of_passengers", list.getNoOfPassengers());
			userListMap.put("vehicle_no", list.getVehicleNo());
			userListMap.put("mobile_no", list.getMobileNo());
			userListMap.put("status", list.getStatus());
			userListMap.put("vaccination_certificate", list.getVaccinationCertificate());
			userListMap.put("Certificate_image", list.getImage());

			epassList.add(userListMap);
			//System.out.println(epassList);
		}
		// ObjectMapper epassMapper = new ObjectMapper();
		// String epassAction = epassMapper.writeValueAsString(epassList);
		model.addAttribute("userList", epassList);
	}

	public void travelPassHistory(Model model, HttpSession session) {

		String applicantName = session.getAttribute("UserName").toString();
		String sql = "Select application_no,applicant_name,gender,father_name,ticket_no,dob,aadhar_no,mobile_no,source,destination,travel_date,return_date,reason,no_of_passengers,vaccination_certificate,status,Certificate_image from travelHistory where applicant_name=?";
		List<TravelEpassForm> travelPassView = jdbcTemplate.query(sql, new TravelEpassFormMapper(), applicantName);
		List<Map<String, Object>> travelList = new ArrayList<>();
		for (TravelEpassForm travel : travelPassView) {
			Map<String, Object> travelListMap = new HashMap<>();
			travelListMap.put("application_no", travel.getApplicationNumber());
			travelListMap.put("applicant_name", travel.getApplicantName1());
			travelListMap.put("gender", travel.getGender1());
			travelListMap.put("father_name", travel.getFatherName1());
			travelListMap.put("ticket_no", travel.getTicketNo());
			travelListMap.put("dob", travel.getDateOfBirth());
			travelListMap.put("aadhar_no", travel.getAadharNumber());
			travelListMap.put("mobile_no", travel.getPhoneNumber());
			travelListMap.put("source", travel.getSource());
			travelListMap.put("destination", travel.getDestination());
			travelListMap.put("travel_date", travel.getFromDate());
			travelListMap.put("return_date", travel.getToDate());
			travelListMap.put("reason", travel.getReasons());
			travelListMap.put("no_of_passengers", travel.getPassengers());
			travelListMap.put("vaccination_certificate", travel.getCovidCertificate());
			travelListMap.put("status", travel.getAction());
			travelListMap.put("Certificate_image", travel.getImages());

			travelList.add(travelListMap);

		}
		// ObjectMapper travelMapper = new ObjectMapper();
		// String travelAction = travelMapper.writeValueAsString(travelList);
		model.addAttribute("viewList", travelList);

	}

	public void userProfile(UserDetails register, HttpSession session) {

		String name = session.getAttribute("UserName").toString();
		String sql1 = "Update userDetails1 set aadhar_no=?,mail_id=?,password=?,mobile_no=? where user_name=?";
		Object[] params = { register.getAadharNo(), register.getMailId(), register.getPassword(),
				register.getMobileNo(), name };
		// System.out.println( register.getAadharNo());
		jdbcTemplate.update(sql1, params);

	}

	public void userProfileView(UserDetails register, HttpSession session) {
		Long aadharNumber = (Long) session.getAttribute("AadharNo");
		String profile = "Select aadhar_no,user_name,mail_id,password,mobile_no from userDetails1 where aadhar_no=?";
		List<UserDetails> userProfile = jdbcTemplate.query(profile, new ProfileMapper(), aadharNumber);

		for (UserDetails details : userProfile) {

			Long aadharNo = details.getAadharNo();
			session.setAttribute("AadharNo", aadharNo);

			String userName = details.getUserName();
			session.setAttribute("UserName", userName);

			String mailId = details.getMailId();
			session.setAttribute("MailId", mailId);

			String password = details.getPassword();
			session.setAttribute("Password", password);

			Long mobileNo = details.getMobileNo();
			session.setAttribute("MobileNumber", mobileNo);

		}

	}

	
	public List<EpassForm> getEpass(Model model, HttpSession session) {
		String aadharNo = (String) session.getAttribute("aadharNo");

		String sql = "Select application_no, applicant_name,aadhar_no ,reason,from_district ,to_district,travel_date ,return_date,no_of_passengers,vehicle_no, mobile_no,status from epassApply where aadhar_no=?";
		List<EpassForm> getEpass = jdbcTemplate.query(sql, new GetEpassMapper(), aadharNo);
		List<Map<String, Object>> epassGetList = new ArrayList<>();
		for (EpassForm approveList : getEpass) {
			Map<String, Object> approveListMap = new HashMap<>();

			approveListMap.put("Application No", approveList.getApplicationNo());
			Long applicationNo = approveList.getApplicationNo();
		
			session.setAttribute("ApplicationNumber", applicationNo);
			//System.out.println(session.getAttribute("ApplicationNumber"));


			approveListMap.put("Applicant_Name", approveList.getApplicantName());
			String name = approveList.getApplicantName();
			session.setAttribute("Applicant_Name", name);

			approveListMap.put("Aadhar_No", approveList.getAadharNo());
			Long aadharNumber = approveList.getAadharNo();
			session.setAttribute("AadharsNo", aadharNumber);

			approveListMap.put("Reason", approveList.getReason());
			String reason = approveList.getReason();
			session.setAttribute("Reason", reason);

			approveListMap.put("From_District", approveList.getFromDistrict());
			String fromDistrict = approveList.getFromDistrict();
			session.setAttribute("From_District", fromDistrict);

			approveListMap.put("To_District", approveList.getToDistrict());
			String toDistrict = approveList.getToDistrict();
			session.setAttribute("To_District", toDistrict);

			approveListMap.put("Travel_Date", approveList.getTravelDate());
			Date travelDate = approveList.getTravelDate();
			session.setAttribute("Travel_Date", travelDate);

			approveListMap.put("Return_Date", approveList.getReturnDate());
			Date returnDate = approveList.getReturnDate();
			session.setAttribute("Return_Date", returnDate);

			approveListMap.put("No_of_passengers", approveList.getNoOfPassengers());
			Integer passengers = approveList.getNoOfPassengers();
			session.setAttribute("No_of_passengers", passengers);

			approveListMap.put("VehicleNo", approveList.getVehicleNo());
			String vehicleNo = approveList.getVehicleNo();
			session.setAttribute("VehicleNo", vehicleNo);

			approveListMap.put("Mobile_No", approveList.getMobileNo());
			Long mobileNo = approveList.getMobileNo();
			session.setAttribute("Mobile_No", mobileNo);

			approveListMap.put("Status", approveList.getStatus());
			String status = approveList.getStatus();
			session.setAttribute("Status", status);
			System.out.println(status);
			
			epassGetList.add(approveListMap);
			//System.out.println(epassGetList);
		}
  
		return getEpass;
	}

	public List<TravelEpassForm> getTravelPassForm(Model model,HttpSession session) {
		Long aadharNo = (Long) session.getAttribute("AadharNo");
  System.out.println(aadharNo);
		String sql1 = "Select application_no,applicant_name,ticket_no,aadhar_no,mobile_no,source,destination,travel_date,return_date,reason,no_of_passengers,status from travelHistory where aadhar_no=?";
		List<TravelEpassForm> travelPassView = jdbcTemplate.query(sql1, new GetTravelPassMapper(),aadharNo);
		System.out.println(travelPassView);
		List<Map<String, Object>> travelApproveList = new ArrayList<>();
		for (TravelEpassForm travelApprove : travelPassView) {
			Map<String, Object> travelApproveListMap = new HashMap<>();
			
			travelApproveListMap.put("application_number", travelApprove.getApplicationNumber());
			Long applicationNumber = travelApprove.getAadharNumber();
            session.setAttribute("Application_Number", applicationNumber);
			
			travelApproveListMap.put("Applicant name", travelApprove.getApplicantName1());
			String applicantName = travelApprove.getApplicantName1();
			session.setAttribute("ApplicantName", applicantName);

			
			travelApproveListMap.put("Ticket_No", travelApprove.getTicketNo());
			String ticketNumber = travelApprove.getTicketNo();
			session.setAttribute("TicketNo", ticketNumber);

			
			travelApproveListMap.put("Aadhar_No", travelApprove.getAadharNumber());
			Long aadharNo1 = travelApprove.getAadharNumber();
			session.setAttribute("AadharNo", aadharNo1);

			
			travelApproveListMap.put("Mobile_No", travelApprove.getPhoneNumber());
			Long mobileNumber = travelApprove.getPhoneNumber();
			session.setAttribute("MobileNo", mobileNumber);

			
			travelApproveListMap.put("Source", travelApprove.getSource());
			String source = travelApprove.getSource();
			session.setAttribute("Source", source);

			
			travelApproveListMap.put("Destination", travelApprove.getDestination());
			String destination = travelApprove.getDestination();
			session.setAttribute("Destination", destination);

			
			travelApproveListMap.put("From_Date", travelApprove.getFromDate());
			Date fromDate = travelApprove.getFromDate();
			session.setAttribute("From_Date", fromDate);
			
			travelApproveListMap.put("To_Date", travelApprove.getToDate());
			Date toDate = travelApprove.getFromDate();
			session.setAttribute("To_Date", toDate);
			
			travelApproveListMap.put("Reasons", travelApprove.getReasons());
			String reasons = travelApprove.getReasons();
			session.setAttribute("Reasons", reasons);

			
			travelApproveListMap.put("Passengers", travelApprove.getPassengers());
			Integer passenger = travelApprove.getPassengers();
			session.setAttribute("Passengers", passenger);

			travelApproveListMap.put("Status1", travelApprove.getAction());
			String action = travelApprove.getAction();
			session.setAttribute("Status1", action);
			System.out.println(action);
			
			
			travelApproveList.add(travelApproveListMap);

		}
		return travelPassView;
	}
	
}
