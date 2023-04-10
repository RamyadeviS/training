<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<Style>
body{
background-color: olive;
}
</Style>
 
</body>
</html>

<--
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="x-UA-compatible" content="IE-edge">
<meta name="viewport" content="width=device=width,initial-scale=1.0">
<title>Epass Apply Form</title>
<%
    String name=session.getAttribute("userName").toString();
%>
</head>

<body>

  <div class="container">
  <h1 align="center">Epass Apply Form</h1>
    <form  id="form1" name="myform1" onsubmit="validateForm1()" action="/EpassForm" method="post" enctype="multipart/form-data">

    <div class="content">
     
    <div class ="input-box"> 
   <label for ="ApplicantName">Applicant Name</label><br>
  <input type="text" name="ApplicantName" id="ApplicantName"  value=<%=name %> placeholder =" Applicant Name" required  onkeyup="nameValid()">
   <span id="name-error"></span>  
               
      <div class ="input-box">
    <label for ="AadharNo">Aadhar Number</label><br>
    <input type="number" name="AadharNo" id="AadharNo" placeholder="Aadhar No" required  onkeyup="aadharNoValidation()">
   <span id="aadharNo-error"></span>
   
  <br> <div class ="input-box">
    <label  for ="Gender"> Gender </label> <br>
           <span>  <Select name="Gender">
                  <option value="Female">Female</option>
                  <option value="Male">Male</option>
                  <option value="Transgender">Transgender</option>
              </Select>
              </span> 
              </div><br>  
       
 <div class ="input-box">
<label for ="Reason">Reason</label><br>
           <span>    <Select name="Reason">
                  <option value="logistic Deliveries">logistic Deliveries</option>
                  <option value="Medical Supply">Medical Supply</option>
                  <option value="Essential Services">Essential Services</option>
                  <option value="Medical Emergency">Medical Emergency</option>
                  <option value="Ecommerce Delivery Boys">Ecommerce Delivery Boys</option>
                  <option value="Death Cause">Death Cause</option>
                  <option value="Wedding Function">Wedding Function</option>
                  </span>
              </Select>
              </div>
       
    <div class ="input-box">
  <label for ="FatherName"> Father Name </label><br>
  <input type="text" name="FatherName" id="FatherName" placeholder="Father Name"  onkeyup="fatherNameValid()">
               <span id="fathername-error"></span>
   
   <div class ="input-box">
  <label for ="dob">Date Of Birth </label><br>
  <input type="date" name="dob" placeholder="DOB" id="dob" min="1950-01-01" max="2023-12-31">  
     
    <div class ="input-box">
  <label for ="FromDistrict">From District</label> <br>          
   <input type="text" name="FromDistrict" id="FromDistrict" placeholder="From District" onkeyup="fromDistrictValid()">
                 <span id="fromDistrict-error"></span>
    
     <div class ="input-box">
  <label for ="ToDistrict">To District</label>    <br>       
     <input type="text" name="ToDistrict" id="ToDistrict" placeholder="To District" onkeyup="toDistrictValid()" >
                 <span id="toDistrict-error"></span>            
    
<div class ="input-box">
  <label for ="State">State</label> <br>          
     <input type="text" name="State" id="State" placeholder="State">

  <div class ="input-box">
  <label for="TravelDate">Travel Date </label><br>
  <input type="date" name="TravelDate" placeholder="TravelDate" id="TravelDate" min="2023-02-08" max="2023-12-31">
         
   <div class ="input-box">                
   <label for="ReturnDate">Return Date </label><br>
   <input type="date" name="ReturnDate" placeholder="ReturnDate" id="ReturnDate" min="2023-02-08" max="2023-12-31"> 
            
   <div class ="input-box">               
   <label for="NoOfPassengers">No Of Passengers</label><br>
    <input type="number" name="NoOfPassengers" id="NoOfPassengers" placeholder="No Of Passengers"  onkeyup="passengersValidation()">
    <span id="passengers-error"></span>
    
    <div class ="input-box">                
   <label for="VehicleNo">Vehicle No</label> <br>
    <input type="text" name="VehicleNo" id="VehicleNo" placeholder="Vehicle No"  onkeyup="vehicleNoValidation()">
         <span id="vehicleNo-error"></span>
    
    <div class ="input-box">                
   <label for="MobileNo">  Mobile No</label><br>
      <Select name="Mobile No">
      <input type="number" name="MobileNo" id="MobileNo" placeholder="**********"   onkeyup="mobileNoValidation()">
      <span id="mobileNo-error"></span>
        </div>
          
  <div class ="input-box">             
   <label for="VaccinationCertificate">Vaccination Certificate</label><br>
   <Select name="VaccinationCertificate">
   <option value="Yes">Yes</option>
   <option value="No">No</option>
   </Select>
   </div>
  
    <div class ="input-box"> 
 <span for="image"><b>Upload Image</b> </span></div>

   <input type="file" id="image" name="image">
  <button type="Back">Back</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="submit">Submit</button>
    
    </form>
  
  <script type="text/javascript" src="/Java Script/ScriptValidation.js"></script>  
  --->
</body>
</html>


