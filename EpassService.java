package com.epassproject.epassform.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.epassproject.epassform.dao.EpassDao;
import com.epassproject.epassform.model.AdminLogin;
import com.epassproject.epassform.model.EpassForm;
import com.epassproject.epassform.model.UserDetails;
import com.epassproject.epassform.model.TravelEpassForm;
import com.epassproject.epassform.myexception.InvalidAadharNoException;
import com.epassproject.epassform.myexception.InvalidPwdException;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class EpassService {
    
	EpassDao registerDao=new EpassDao();
	public void registerUser(UserDetails register,HttpSession session) {
		registerDao.userRegister(register, session);
	}
	
	public boolean login(UserDetails register,HttpSession session,Model model) {
		return registerDao.userLogin(register, session);
	}
	
	public void loginAdmin(AdminLogin admin) throws InvalidPwdException {
		registerDao.adminLogin(admin);
	}
	
 public void epassFormApply(EpassForm epass,HttpSession session,Model model) {
	   registerDao.epassApplyForm(epass, session,model);
 }
 public void travelPassApply(TravelEpassForm travelPass,HttpSession session,Model model) {
      registerDao.travelPassApplyForm(travelPass, session,model);
 }		
 
 public void getEpassList(Model model) throws JsonProcessingException {
	
   registerDao.listEpassform(model);
	//model.addAttribute("List_Users", registers);
}
 public void getEpassApproveList(Model model,HttpSession session) {
		
	   List<EpassForm> registers=registerDao.approveEpass(model,session);
		model.addAttribute("List_Approve", registers);
	}
 public void getEpassRejectList(Model model) {
		
	   List<EpassForm> registers=registerDao.rejectEpass(model);
		model.addAttribute("List_Reject", registers);
	}
	 
 public void getEpassPendingList(Model model) {
		
	   List<EpassForm> registers=registerDao.pendingEpass(model);
		model.addAttribute("List_Pending", registers);
	}
 
 public void getTravelpassList(Model model) throws JsonProcessingException {
	registerDao.listTravelPassForm(model);
   	// model.addAttribute("Travel_List", register);		
}
 public void getTravelPassApproveList(Model model) {
	 List<TravelEpassForm> register=registerDao.approveTravelPassForm(model);
   	 model.addAttribute("Travel_Approve", register);		
}
 public void getTravelPassRejectList(Model model) {
	 List<TravelEpassForm> register=registerDao.rejectTravelPassForm(model);
   	 model.addAttribute("Travel_Reject", register);
		
}
 public void getTravelPassPendingList(Model model) {
	 List<TravelEpassForm> register=registerDao.pendingTravelPassForm(model);
   	 model.addAttribute("Travel_Pending", register);
		
}
 
 public void epassApproved(EpassForm epass) {
  registerDao.epassStatusUpdate(epass);
}
 
 public void epassReject(EpassForm epass) {
	 registerDao.epassStatusReject(epass);
		
 }
 public void travelPassApproved(TravelEpassForm travelPass) {
	 registerDao.travelStatusApprove(travelPass);
 }
 public void travelPassReject(TravelEpassForm travelPass) {
	 registerDao.travelStatusReject(travelPass);
 }
 public void epassView(EpassForm epass,Model model,HttpSession session) throws JsonProcessingException {
	       registerDao.listEpassform(model);
		//model.addAttribute("EpassStatus_List", epassList);
		List<EpassForm> status=registerDao.userView(epass,model);
		session.setAttribute("EpassStatus_List", status);
  }
 
 public void viewTravelPass(TravelEpassForm travelPass,Model model,HttpSession session)  {
		/*
		 * //List<TravelEpassForm> travelList= registerDao.listTravelPassForm(model);
		 * model.addAttribute("TravelStatus_List", travelList); List<TravelEpassForm>
		 * statusView=registerDao.travelPassView(travelPass,model);
		 * session.setAttribute("TravelStatus_List", statusView);
		 */
 }
 
}
