package com.epassproject.epassform.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.epassproject.epassform.model.AdminLogin;
import com.epassproject.epassform.model.EpassForm;
import com.epassproject.epassform.model.UserDetails;
import com.epassproject.epassform.model.TravelEpassForm;
import com.epassproject.epassform.myexception.DuplicationOfAadharNoException;
import com.epassproject.epassform.myexception.DuplicationOfMailIdException;
import com.epassproject.epassform.myexception.InvalidAadharNoException;
import com.epassproject.epassform.myexception.InvalidPwdException;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface EpassInterface {

	
	public void userRegister(UserDetails register, HttpSession session);
	public Boolean mailIdExisting(String mailId,Model model) ;
    public Boolean aadharNoExisting(Long aadharNo,Model model) ;
    public boolean userLogin(UserDetails register,HttpSession session);
    
    public void epassApplyForm(EpassForm epass,HttpSession session,Model model);
    public void travelPassApplyForm(TravelEpassForm travelPass,HttpSession session,Model model);
 
    public void adminLogin(AdminLogin admin) throws InvalidPwdException;
   
    public void listEpassform(Model model) throws JsonProcessingException;
    public void listTravelPassForm(Model model) throws JsonProcessingException;
   
    public void epassStatusUpdate(EpassForm epass);
    public void epassStatusReject(EpassForm epass);
   
    public void travelStatusApprove(TravelEpassForm travelPass);
    public void travelStatusReject(TravelEpassForm travelPass);
    
    public void userEpassView(EpassForm epass) ;
    public Integer totalEpassCount();
    public Integer totalTravelPassCount();
    public Integer totalUserCount();
    
    public List<EpassForm> userView(EpassForm epass,Model model);
    public List<TravelEpassForm> travelPassView(TravelEpassForm travelPass,Model model);
		 
}
