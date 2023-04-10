package com.epassproject.epassform.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.epassproject.epassform.dao.EpassDao;
import com.epassproject.epassform.model.AdminLogin;
import com.epassproject.epassform.model.EpassForm;
import com.epassproject.epassform.model.UserDetails;
import com.epassproject.epassform.model.TravelEpassForm;
import com.epassproject.epassform.myexception.InvalidAadharNoException;
import com.epassproject.epassform.myexception.InvalidApplicantNameException;
import com.epassproject.epassform.myexception.InvalidDobException;
import com.epassproject.epassform.myexception.DuplicationOfAadharNoException;
import com.epassproject.epassform.myexception.DuplicationOfMailIdException;
import com.epassproject.epassform.myexception.InvalidMailIdException;
import com.epassproject.epassform.myexception.InvalidMobileNoException;
import com.epassproject.epassform.myexception.InvalidNameException;
import com.epassproject.epassform.myexception.InvalidNoOfPassengers;
import com.epassproject.epassform.myexception.InvalidPasswordException;
import com.epassproject.epassform.myexception.InvalidPwdException;
import com.epassproject.epassform.myexception.InvalidReturnDateException;
import com.epassproject.epassform.myexception.InvalidVaccinationCertificateException;
import com.epassproject.epassform.myexception.InvalidVehicleNoException;
import com.epassproject.epassform.service.EpassService;
import com.epassproject.epassform.validation.ValidationUser;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class EpassController {

	EpassDao registerDao = new EpassDao();

	EpassService epassService = new EpassService();
	ValidationUser valid=new ValidationUser();
	Logger logger = LoggerFactory.getLogger(EpassController.class);
	
	@RequestMapping("/")
	public String dash() {
		return "DashBoard";

	}
	@GetMapping("/aboutUs")
	public String about() {
		return "AboutUsForm.html";

	}
	@GetMapping("/contactUs")
	public String contact() {
		return "ContactUsForm";
	}
	
	@RequestMapping("/userDashboard")
	public String userDashboard() {
		return "UserDashboard.html";

	}
	
	@GetMapping("/signUp")
	public String registerEpass(HttpSession session,@ModelAttribute("sign")UserDetails register,Model model) {	
		return "UserDetails.html";

	}
	@GetMapping("/register")
	public String register(HttpSession session,@ModelAttribute("sign")UserDetails register,Model model,Long aadharNo,String mailId) {	
		logger.info("Register successfully");
		
		 for (int i = 1; i <=20; i++) {
	            session.removeAttribute("errorMessage1" + i);
	        }

	        if (Boolean.FALSE.equals(ValidationUser.nameValidation(register.getUserName(), model))
	   || Boolean.FALSE.equals(valid.aadharNoValidation(register.getAadharNo(), model))
	   || Boolean.FALSE.equals(registerDao.aadharNoExisting(register.getAadharNo(),model))
	      
	   || Boolean.FALSE.equals(ValidationUser.mailIdValidation(register.getMailId(), model))
	   || Boolean.FALSE.equals (registerDao.mailIdExisting(register.getMailId(),model))
       || Boolean.FALSE.equals(ValidationUser.passwordValidation(register.getPassword(),model))
       || Boolean.FALSE.equals(valid.mobileNoValidation(register.getMobileNo(), model)))
	
             {
	            
	            for (int j = 1; j <=20; j++) {
	                if (model.getAttribute("errorMessage" + j) != null) {
	                    String errorMessage = (String) model.getAttribute("errorMessage" + j);
	                    model.addAttribute("ErrorMessage", errorMessage);
	                }
	            }
	            return "ErrorPopup.html";
	        }
	        epassService.registerUser(register, session);
		return "RegisterSuccessfully.html";
 
	}

	@GetMapping("/userLoginEpass")
	public String loginUserEpass(HttpSession session,@ModelAttribute("signIn")UserDetails register) {	
		return "UserLogin.html";

	}
	
	@GetMapping("/userLogin")
	public String loginUser(HttpSession session,Model model,@ModelAttribute("signIn")UserDetails register){
		logger.info("Login successfully");
		
		 if(Boolean.TRUE.equals(epassService.login(register, session, model))){
			
			 registerDao.getEpass(model, session);
			   registerDao.getTravelPassForm(model, session);
			   
			 return "LoginSuccess.html";
	   
	}
		 else if(Boolean.FALSE.equals(epassService.login(register, session, model))){
			 return "UserLogin.html";

	}
		 return "UserLogin.html";
	}	 

	@RequestMapping("/adminDashboard")         
	public String dashBoard() {
		return "AdminDashboard.html";

	}
	@GetMapping("/login")
	public String admin(Model model,@ModelAttribute("admin")AdminLogin admin) throws InvalidPwdException {
		return "Admin.html";
	}
	
	@GetMapping("/adminLogin")
	public String adminLogin(Model model,@ModelAttribute("admin")AdminLogin admin,@ModelAttribute("epass")EpassForm epass,@ModelAttribute("travel")TravelEpassForm travelPass) throws InvalidPwdException {

		logger.info("Epass Count");
		Integer epassCount = registerDao.totalEpassCount();
		model.addAttribute("Epass_count", epassCount);

		logger.info("Travel Pass Count");
		Integer travelPassCount = registerDao.totalTravelPassCount();
		model.addAttribute("TravelPass_count", travelPassCount);

		logger.info("Epass total Count");
		Integer totalCount = registerDao.totalUserCount();
		model.addAttribute("TotalUser_count", totalCount);

		logger.info("Epass Approve Count");
		Integer approveCount = registerDao.approvedCount();
		model.addAttribute("TotalApprove_count", approveCount);

		logger.info("Epass Reject Count");
		Integer rejectCount = registerDao.rejectedCount();
		model.addAttribute("TotalReject_count", rejectCount);

		logger.info("Approve Count");
		Integer travelApproveCount = registerDao.approveCount();
		model.addAttribute("TotalApprove_count1", travelApproveCount);

		logger.info("Reject Count");
		Integer travelRejectCount = registerDao.rejectCount();
		model.addAttribute("TotalReject_count1", travelRejectCount);

		logger.info("Epass Pending Count");
		Integer epassPendingCount = registerDao.pendingEpassCount();
		model.addAttribute("TotalPending_count", epassPendingCount);

		logger.info("Epass Pending Count");
		Integer travelPendingCount = registerDao.pendingCount();
		model.addAttribute("TotalPending_count1", travelPendingCount);

		epassService.loginAdmin(admin);
		return "AdminDashboard.html";

	}

	@RequestMapping("/EpassApply")
	public String epassFormApply(@ModelAttribute("FormApply")EpassForm epass,HttpSession session)  {
		return "EpassApplyForm.html";
	}
	
	@PostMapping("/epassForm")
	public String epassForm(@RequestParam("VaccineImage") MultipartFile image,@ModelAttribute("FormApply") EpassForm epass,HttpSession session,Model model) throws FileNotFoundException, IOException  {
		
		String fileName = image.getOriginalFilename();
		try (FileInputStream file = new FileInputStream("C:\\Users\\ramy3344\\eclipse-workspace\\E-pass\\src\\main\\resources\\static\\Images\\" + fileName);) {
			System.out.println(file);
		byte[] images = file.readAllBytes();
			epass.setImage(images);
		}
		 for (int i = 1; i <=20; i++) {
	            session.removeAttribute("errorMessage1" + i);
	        }

	        if (Boolean.FALSE.equals(ValidationUser.nameValidation(epass.getFatherName(), model))
	   || Boolean.FALSE.equals(valid.dateValidation(epass.getDob(),model))
       || Boolean.FALSE.equals(ValidationUser.nameValidation(epass.getFromDistrict(), model))
       || Boolean.FALSE.equals(ValidationUser.nameValidation(epass.getToDistrict(), model))
	   || Boolean.FALSE.equals(valid.dateValidation(epass.getTravelDate(),model))
	   || Boolean.FALSE.equals(valid.dateValidation(epass.getReturnDate(),model))
	   || Boolean.FALSE.equals(valid.noOfPassengersValidation(epass.getNoOfPassengers(),model))
	   || Boolean.FALSE.equals(ValidationUser.mobileNoValidation(epass.getMobileNo(), model))		
	   || Boolean.FALSE.equals(ValidationUser.vehicleNoValidation(epass.getVehicleNo(),model)))
	 
          {
	            
	            for (int j = 1; j <=20; j++) {
	                if (model.getAttribute("errorMessage" + j) != null) {
	                    String errorMessage = (String) model.getAttribute("errorMessage" + j);
	                    model.addAttribute("ErrorMessage", errorMessage);
	                }
	            }
	            return "ErrorPopup.html";
	        }
	        
			epassService.epassFormApply(epass, session,model );
		return "EpassFormSuccess.html";
	}
	
	@GetMapping("/listEpassForm")
	public String getEpassFormUser(@ModelAttribute("epass")EpassForm epass,Model model, HttpSession session) throws JsonProcessingException {
		epassService.getEpassList(model);
		return "EpassListView.html";
	}

	@PostMapping("/listEpassFormImage")

	public String getEpassFormUserImage(@RequestParam("imageView") Integer appId, Model model) {
		List<EpassForm> list = registerDao.listEpassformImage(appId);
		System.err.println(appId);
		model.addAttribute("adminDashboard", list);
		return "ImageView.html";
	}

	@GetMapping("/epassApproveList")
	public String getEpassApproved(Model model, HttpSession session) {
		epassService.getEpassApproveList(model,session);
		return "/EpassApproveList.html";
	}

	@PostMapping("/epassApproveImage")

	public String getEpassApproveImage(@RequestParam("approveImageView") Integer appId, Model model) {
		List<EpassForm> list = registerDao.approveEpassformImage(appId);
		System.err.println(appId);

		model.addAttribute("epassApprove", list);
		return "ApproveImageView.html";
	}

	
	@GetMapping("/epassRejectList")
	public String getEpassRejected(Model model, HttpSession session) {
		epassService.getEpassRejectList(model);
		return "EpassRejectList.html";
	}

	@GetMapping("/epassPendingList")
	public String getEpassPending(Model model, HttpSession session) {
		epassService.getEpassPendingList(model);
		return "EpassPendingList.html";
	}

	@GetMapping("/update")
	public String updateStatus(@ModelAttribute("epass")EpassForm epass) {
		logger.info("to update the status");
		epassService.epassApproved(epass);
		return "EpassApprove.html";
	}

	@GetMapping("/reject")
	public String rejectStatus(@ModelAttribute("epass")EpassForm epass) {
		logger.info("To reject the status");
		epassService.epassReject(epass);
		return "EpassReject.html";

	}

	@GetMapping("/userView")
	public String userView(@ModelAttribute("applicationNo") EpassForm epass ,Model model, HttpSession session) throws JsonProcessingException {
		logger.info("To get the status");
		epassService.epassView(epass, model, session);
		return "EpassStatusView.html";

	}
	
	@GetMapping("/forgot")
	public String updatePassword(@ModelAttribute("Forgot")UserDetails register) {
	return "ForgotPassword.html";

	}
	@GetMapping("/forgotPassword")
	public String updPassword(@ModelAttribute("Forgot")UserDetails register) {
		registerDao.forgotPassword(register);
		return "UserLogin.html";
		
		}
	
	@GetMapping("/epassHistory")
	public String travelHistory(@ModelAttribute("history")EpassForm epass,Model model, HttpSession session) {
   registerDao.epassHistory(model, session);
   registerDao.travelPassHistory(model,session);
    return "EpassHistory.html";
}
 
	@GetMapping("/profile")
	public String profieForm(@ModelAttribute("profile")UserDetails register,HttpSession session) {
		registerDao.userProfileView(register, session);
		return "Profile.html";
	}
	
	@GetMapping("/profileView")
	public String profieFormView(@ModelAttribute("profileView")UserDetails register,HttpSession session) {
		
		registerDao.userProfile(register, session);
		return "UserDashboard.html";
	}
	
	 @GetMapping("/getEpass")
	 public String getEpass(@ModelAttribute("epassGet")EpassForm epass,HttpSession session,Model model) {
		 registerDao.getEpass(model, session);
		 String statusApprove=(String) session.getAttribute("Status");
		 for (int i = 1; i <=20; i++) {
	            session.removeAttribute("errorMessage1" + i);
	        }
		 
		 if (Boolean.FALSE.equals(valid.checkStatus(statusApprove, model)))
				 
			          {
				            
				            for (int j = 1; j <=20; j++) {
				                if (model.getAttribute("errorMessage" + j) != null) {
				                    String errorMessage = (String) model.getAttribute("errorMessage" + j);
				                    model.addAttribute("ErrorMessage", errorMessage);
				                }
				            }
				            return "ErrorPopup.html";
				        }
		 else {	        
	  return "EpassDownload.html";
	  }
	 }
}	


	

