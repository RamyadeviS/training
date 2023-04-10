<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/CSS files/EpaasForm.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Epass Form Apply</title>  
    <link rel ="stylesheet" href="/CSS files/Dashboard.css"> 
<%
   HttpSession session1 =request.getSession();
   String name=(String)session1.getAttribute("userName");
%>
</head>
<style>
body{
 background-color:#00FFFF;
}
</style>

<body>

<div class="menu-bar">
        <ul>
        
          <li><a href="/jspfiles/EpassForm.jsp"><i class="fa-sharp fa-solid fa-car-side"></i>&nbsp;E-Pass Form</a>
          <li><a href="/jspfiles/TravelEpassForm.jsp"><i class="fa-solid fa-plane"></i>&nbsp;Travel E-Pass Form</a></li>        
          <li><a href="/jspfiles/ApplicationNo.jsp"><i class="fa-brands fa-wpforms"></i>&nbsp;Epass Status View</a>
          <li><a href="/jspfiles/ApplicationStatus.jsp"><i class="fa-brands fa-wpforms"></i></i>&nbsp;Travel Pass Status View</a></li>        
          <li><a href="/jspfiles/Dashboard.jsp"><i class="fa-solid fa-right-from-bracket"></i>&nbsp;Logout</a> </li>
          
            <ul>
            
        </div>
         <h1 align="center">Epass Apply Form</h1>
  <header>
  <div class="container">
  <div class="left">
    <form  id="form1" name="myform1" onsubmit="validateForm1()" action="/EpassForm" method="post" enctype="multipart/form-data">
   
     Applicant Name
     <input type="text" name="ApplicantName" id="ApplicantName" value=<%=name%> placeholder="Applicant Name" onkeyup="nameValid()">
     <span id="name-error" color:red;> </span>  
       <br><br>
     Aadhar No <br>
     <input type="number" name="AadharNo" id="AadharNo" placeholder="Aadhar No" required  onkeyup="aadharNoValidation()">
     <span id="aadharNo-error"></span>
        
     <div id="zip">
     <label>       
     Gender <br><br>
     <Select name="Gender">
     <option value="Female">Female</option>
     <option value="Male">Male</option>
     <option value="Transgender">Transgender</option>
   </Select>
    </label>
   </div>
   <div>
   <label>
   <br>Reason <br><br>
  <Select name="Reason">
   <option value="logistic Deliveries">logistic Deliveries</option>
   <option value="Medical Supply">Medical Supply</option>
   <option value="Essential Services">Essential Services</option>
   <option value="Medical Emergency">Medical Emergency</option>
   <option value="Government Duty">Government Duty</option>
   <option value="Death Cause">Death Cause</option>
   <option value="Wedding Function">Wedding Function</option>
     </Select>
           </label>
           </div>     

  <br>  FatherName
    <input type="text" name="FatherName" id="FatherName" placeholder="Father Name"  onkeyup="fatherNameValid()">
    <span id="fathername-error"></span>

  <br><br> Date Of Birth
    <input type="date" name="dob" placeholder="DOB" id="dob" min="1950-01-01" max="2023-12-31">  
    <br>
   <br> From District
    <input type="text" name="FromDistrict" id="FromDistrict" placeholder="From District" onkeyup="fromDistrictValid()">
    <span id="fromDistrict-error"></span>
    <br>
 </div>
 
 &emsp; &emsp; &emsp; &emsp;
  <div class="right">
      <br> 
 To District   <br><br>               
    <input type="text" name="ToDistrict" id="ToDistrict" placeholder="To District" onkeyup="toDistrictValid()" >
    <span id="toDistrict-error"></span>  
     <br>  <br>
 
Travel Date 
 <input type="date" name="TravelDate" placeholder="TravelDate" id="TravelDate" min="2023-02-08" max="2023-12-31">
     <br>  <br> 
  Return Date
  <input type="date" name="ReturnDate" placeholder="ReturnDate" id="ReturnDate" min="2023-02-08" max="2023-12-31"> 
  <br>   <br>
  No Of Passengers<br><br>
   <input type="number" name="NoOfPassengers" id="NoOfPassengers" placeholder="No Of Passengers"  onkeyup="passengersValidation()">
   <span id="passengers-error"></span>
   <br> <br>
  Vehicle No <br><br>
   <input type="text" name="VehicleNo" id="VehicleNo" placeholder="Vehicle No"  onkeyup="vehicleNoValidation()">
        <span id="vehicleNo-error"></span>
        <br> <br>
   Mobile No <br><br>
     <input type="number" name="MobileNo" id="MobileNo" placeholder="**********"   onkeyup="mobileNoValidation()">
     <span id="mobileNo-error"></span>
     
   <br><br> 
  Vaccination Certificate &nbsp;(2 Dose)<br><br>
  <input type="text" name="VaccinationCertificate" id="VaccinationCertificate" placeholder="VaccinationCertificate" onkeyup="vaccinationCertificateValid()">
     <span id="vaccinationCertificate-error"></span>
     <br> <br> 
  
<br> 
  <label>
    Upload Image &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
 <input type="file" id="image" name="image" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;><br>
 <br>&emsp;&emsp; <input type="Submit" value="Go back!" onclick="history.back()"> &nbsp;&nbsp;&nbsp;
 <button type="submit">&nbsp;Submit</button>
   </label>
   
</div>
</div>
</form>
<script type="text/javascript" src="/Java Script/ScriptValidation.js"></script>  
</body>
</html>