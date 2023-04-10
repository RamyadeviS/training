package com.epassproject.epassform.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import com.epassproject.epassform.model.EpassForm;
import com.epassproject.epassform.model.TravelEpassForm;
import com.epassproject.epassform.myexception.InvalidAadharNoException;
import com.epassproject.epassform.myexception.InvalidDobException;
import com.epassproject.epassform.myexception.InvalidMobileNoException;
import com.epassproject.epassform.myexception.InvalidNameException;
import com.epassproject.epassform.myexception.InvalidNoOfPassengers;
import com.epassproject.epassform.myexception.InvalidTicketNoException;
import com.epassproject.epassform.myexception.InvalidVaccinationCertificateException;
import com.epassproject.epassform.service.EpassService;
import com.epassproject.epassform.validation.ValidationUser;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class TravelPassController {
	EpassDao registerDao = new EpassDao();
      
	ValidationUser valid=new ValidationUser();
	EpassService epassService= new EpassService();
	Logger logger = LoggerFactory.getLogger(TravelPassController.class);
	
	@RequestMapping("/travelPassApply")
	public String travelFormApply(@ModelAttribute("Apply") TravelEpassForm travelPass,HttpSession session)  {
		return "TravelPassForm";
	}
	@PostMapping("/travelForm") 
	public String travelForm(@RequestParam("VaccineImage") MultipartFile image,@ModelAttribute("Apply") TravelEpassForm travelPass,HttpSession session,Model model) throws FileNotFoundException, IOException{
		
		String fileName = image.getOriginalFilename();
		try (FileInputStream file = new FileInputStream("C:\\Users\\ramy3344\\eclipse-workspace\\E-pass\\src\\main\\resources\\static\\Images\\" + fileName);) {
		byte[] images = file.readAllBytes();
		travelPass.setImages(images);
		}
		
		 for (int i = 1; i <=18; i++) {
	            session.removeAttribute("errorMessage1" + i);
	        }

	        if (Boolean.FALSE.equals(ValidationUser.nameValidation(travelPass.getFatherName1(), model))
	   || Boolean.FALSE.equals(valid.dateValidation(travelPass.getDateOfBirth(),model))
    || Boolean.FALSE.equals(ValidationUser.nameValidation(travelPass.getSource(), model))
    || Boolean.FALSE.equals(ValidationUser.nameValidation(travelPass.getDestination(), model))
	   || Boolean.FALSE.equals(valid.dateValidation(travelPass.getFromDate(),model))
	   || Boolean.FALSE.equals(valid.dateValidation(travelPass.getToDate(),model))
	   || Boolean.FALSE.equals(valid.noOfPassengersValidation(travelPass.getPassengers(),model))
	   || Boolean.FALSE.equals(ValidationUser.mobileNoValidation(travelPass.getPhoneNumber(), model))		
	   || Boolean.FALSE.equals(ValidationUser.ticketNoValidation(travelPass.getTicketNo(),model)))
	  // || Boolean.FALSE.equals(valid.vaccinationCertificateValidation(epass.getVaccinationCertificate(),model)))
	   
       {
	            
	            for (int j = 1; j <=18; j++) {
	                if (model.getAttribute("errorMessage" + j) != null) {
	                    String errorMessage = (String) model.getAttribute("errorMessage" + j);
	                    model.addAttribute("ErrorMessage", errorMessage);
	                }
	            }
	            return "ErrorPopup.html";
	        }
	        
		
		/*
		 * valid.nameValidation(travelPass.getApplicantName1());
		 * valid.nameValidation(travelPass.getFatherName1());
		 * valid.ticketNoValidation(travelPass.getTicketNo());
		 * valid.dobValidation(travelPass.getDateOfBirth());
		 * valid.aadharNoValidation(travelPass.getAadharNumber());
		 * valid.mobileNoValidation(travelPass.getPhoneNumber());
		 * valid.nameValidation(travelPass.getSource());
		 * valid.nameValidation(travelPass.getDestination());
		 * valid.noOfPassengersValidation(travelPass.getPassengers());
		 * valid.vaccinationCertificateValidation(travelPass.getCovidCertificate());
		 */
		epassService.travelPassApply(travelPass, session, model);
		
		
		return "TravelPassFormSuccess.html";

	}	

	@GetMapping("/listTravelPass")
	public String getListTravelPass(@ModelAttribute("travel")TravelEpassForm travelPass,Model model, HttpSession session) throws JsonProcessingException {
		epassService.getTravelpassList(model);
		return "TravelListView.html";

	}

	@PostMapping("/listTravelPassFormImage")
	public String getTravelPassFormUserImage(@RequestParam("travelImgView") Integer appId1, Model model) {
		List<TravelEpassForm> list = registerDao.listTravelPassFormImage(appId1);
		model.addAttribute("travelPass", list);
		return "TravelImageView.html";
	}

	@GetMapping("/travelPassApprove")
	public String getListTravelPassApprove(Model model, HttpSession session) {
		epassService.getTravelPassApproveList(model);
		return "TravelApproveList.html";
	}

	@GetMapping("/travelPassReject")
	public String getListTravelPassReject(Model model, HttpSession session) {
		epassService.getTravelPassRejectList(model);
		return "TravelRejectList.html";
	}

	@GetMapping("/travelPassPending")
	public String getListTravelPassPending(Model model, HttpSession session) {
		epassService.getTravelPassPendingList(model);
		return "TravelPendingList.html";

	}
	@GetMapping("/approve")
	public String approvedStatus(@ModelAttribute("travel")TravelEpassForm travelPass) {
		logger.info("To update the status");
			epassService.travelPassApproved(travelPass);
		return "TravelPassApprove.html";

	}

	@GetMapping("/travelReject")
	public String travelRejectStatus(@ModelAttribute("travel")TravelEpassForm travelPass) {
		logger.info("To update the status");
			epassService.travelPassReject(travelPass);
		return "TravelPassReject.html";
	}
	@GetMapping("/travelView")
	public String view(@ModelAttribute("applicationNumber") TravelEpassForm travelPass, Model model, HttpSession session) throws JsonProcessingException {
		logger.info("To get the status");
	    registerDao.listTravelPassForm(model);
		//model.addAttribute("TravelStatus_List", travelList);
		List<TravelEpassForm> statusView=registerDao.travelPassView(travelPass,model);
		session.setAttribute("TravelStatus_List", statusView);
 
		//epassService.viewTravelPass(travelPass, model, session);
		return "TravelPassStatusView.html";

	}

@GetMapping("/getTravelPass")
public String getTravelPass(@ModelAttribute("getTravel")TravelEpassForm travelPass,HttpSession session,Model model) {
	registerDao.getTravelPassForm(model, session);
	 String statusApproved=(String) session.getAttribute("Status1");
	 System.out.println(statusApproved);
	 for (int i = 1; i <=20; i++) {
            session.removeAttribute("errorMessage1" + i);
        }
	 
	 if (Boolean.FALSE.equals(valid.checkTravelStatus(statusApproved, model)))
			 
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

	return "TravelPassDownload.html";
}
}
}
