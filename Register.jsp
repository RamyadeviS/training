<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <title>Register Form </title>
 <link rel="stylesheet" href="/CSS files/Register.css">
</head>
<body>

<div class="container">
    <form  id="form" name="myform1" onsubmit="validateForm()" action="/register" method="post" align="center">
<h1 align="center"> Registration Form</h1>
  <div class="para">
  Aadhar No: 
    <input type="text" name="AadharNo" id="aadharNo" placeholder="Aadhar No" required  onkeyup="aadharNoValidation()">
     <span id="aadharNo-error"></span>
   <br><br>
  User Name:
    <input type="text" name="UserName" id="userName" placeholder="User Name" required onkeyup="nameValid()">
         <span id="name-error" color:red;> </span>  
        <br><br>
   Mail Id : 
      <input type="text" name="MailId" id="mailId" placeholder="Mail Id" required onkeyup="mailIdValidation()">
         <span id="mailId-error"></span>
    
     <br><br>
  Password :
    <input type="password" name="Password" id="password" placeholder="Password" required onkeyup="passwordValidation()">
       <span id="password-error"></span>  
  
  <br><br>
   Mobile No:
    <input type="text" name="MobileNo" id="mobileNo" placeholder="Mobile No"  onkeyup="mobileNoValidation()">
    <span id="mobileNo-error"></span>
 <br>
   <br><br> <input type="Checkbox" name="agree" required>
    <label for="agree">I agree to all the conditions of the Form</label>
    <br><br>
    <input type="Submit" value="Cancel" onclick="history.back()"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="Submit">Submit</button><br><br>
     Already have an account?<a href="/jspfiles/user.jsp">&nbsp;Login</a> <br><br>
    
    </div>
    </form>  
     
<!--      <script type="text/javascript" src="/Java Script/ScriptValidation.js"></script>
 -->     
 <script type="text/javascript">
 var nameError = document.getElementById("name-error"); 
 var aadharNoError =document.getElementById("aadharNo-error"); 
 var mobileNoError=document.getElementById("mobileNo-error");
 var mailIdError=document.getElementById("mailId-error");
 var passwordError=document.getElementById("password-error");
 
 
 function nameValid(){
	var name = document.getElementById("userName").value; 
	let nameValidation = '^[A-Za-z]*$'; 
	if(name == 0  || name.trim() == ""){ 
		text ='Name is required'; 
		nameError.innerHTML = text; 
		return false; 
	} 
	if(name.length < 3){
		text = 'Name should be greater than 3 characters';
		nameError.innerHTML = text; 
		return false; 
	}
	if(!name.match(nameValidation)){ 
		  text = 'Name must contain uppercase and lowecase'; 
		nameError.innerHTML = text;  
		return false; 
	}
	nameError.innerHTML ='<i class="fa-regular fa-circle-check"></i>'; 
	return true; 
}
 
 function aadharNoValidation() { 
		var aadharNo=document.getElementById("aadharNo").value; 
		let aadharNoValid ="\\d{12}";
		if(aadharNo == 0){
			text = 'Aadhar Number is required';
			aadharNoError.innerHTML = text;
			return false;
		}
		if (aadharNo.length < 12 ||aadharNo.length >12 ) {
	        text='aadharNo must be contain 12 digits';
	        aadharNoError.innerHTML = text;
			return false;
	          }

		if(!aadharNo.match(aadharNoValid)){
			text = 'Invalid Aadhar Number';
			aadharNoError.innerHTML = text;
			return false;
		}
		aadharNoError.innerHTML = '<i class="fa-regular fa-circle-check"></i>';
		return true;
	}
 function mobileNoValidation() { 
		var mobileNo=document.getElementById("mobileNo").value; 
		let mobileNoValid ="\\d{10}";
		if(mobileNo == 0){
			text = 'Mobile Number is required';
			mobileNoError.innerHTML = text;
			return false;
		}
		if (mobileNo.length < 10 ||mobileNo.length >10) {
	        text='Mobile No must be contain 10 digits';
	        mobileNoError.innerHTML = text;
			return false;
	          }

		if(!mobileNo.match(mobileNoValid)){
			text = 'Invalid mobile Number';
			mobileNoError.innerHTML = text;
			return false;
		}
		mobileNoError.innerHTML ='<i class="fa-regular fa-circle-check"></i>';
		return true;
	}
	
 function mailIdValidation() { 
		var mailId=document.getElementById("mailId").value; 
		let mailIdValid ="^[a-zA-Z0-9+.-]+@[a-zA-Z+.-]+$";
		if(mailId == 0){
			text = 'Mail Id is required';
			mailIdError.innerHTML = text;
			return false;
		}
		
		if(!mailId.match(mailIdValid)){
			text='Invalid mail id!! it should contain only alphabets after @ symbol';    
			mailIdError.innerHTML = text;
			return false;
		}
		mailIdError.innerHTML ='<i class="fa-regular fa-circle-check"></i>';
		return true;
	}
 
 function passwordValidation() { 
		var password=document.getElementById("password").value; 
		let passwordValid = '.[A-Za-z0-9]{1,}[@#$!%^&?><]{1,}.*';

		if(password == 0  || password.trim() == ""){ 
			text ='Password is required'; 
			passwordError.innerHTML = text; 
			return false; 
		} 
		if(!password.match(passwordValid)){
	        text = "Password Should be more than 6 characters";
			passwordError.innerHTML = text;
			return false;
		}
		passwordError.innerHTML ='<i class="fa-regular fa-circle-check"></i>';
		return true;
	}

 </script>
 </body>
 </html>
     
 


 
 