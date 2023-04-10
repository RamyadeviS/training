<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
   
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/CSS files/TravelPass.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Travel Pass Apply Form</title>
        <link rel ="stylesheet" href="/CSS files/Dashboard.css"> 
    
     
<%
   HttpSession session1 =request.getSession();
   String name=session.getAttribute("userName").toString();
%>
</head>
<style>
 header{
 background-color:#8B008B;
 
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
            </ul>
        </div>
  <h1 align="center">Travel Pass Form</h1>    
  <header>
 
  <div class="container">
  <div class="left">
  <form id="form" name="myform1" onsubmit="validateForm()" action="/TravelForm" method="post" enctype="multipart/form-data" align="center">
    
     Applicant Name
     <input type="text" name="ApplicantName" id="ApplicantName" value=<%=name %> placeholder="Applicant Name"  onkeyup="nameValid()">
     <span id="name-error"></span>  
       
    <div id="zip">
     <label>       
     Gender <br>
     <Select name="Gender">
     <option value="Female">Female</option>
     <option value="Male">Male</option>
     <option value="Transgender">Transgender</option>
   </Select>
    </label>
   </div>
        
    <br>  FatherName
    <input type="text" name="FatherName" id="FatherName" placeholder="Father Name"  onkeyup="fatherNameValid()">
    <span id="fathername-error"></span>

     <br><br>
  Ticket No
   <input type="text" name="TicketNo" id="TicketNo" placeholder="Ticket No"  onkeyup="ticketNoValidation()">
        <span id="ticketNo-error"></span>
        <br>
    
  <br> Date Of Birth
    <input type="date" name="dob" placeholder="dob" id="dob" min="1950-01-01" max="2023-01-31">  
    <br>   
    <br>
  Aadhar No <br>
     <input type="number" name="AadharNo" id="AadharNo" placeholder="Aadhar No" required  onkeyup="aadharNoValidation()">
     <span id="aadharNo-error"></span>
  <br>
   Mobile No
     <input type="number" name="MobileNo" id="MobileNo" placeholder="**********"   onkeyup="mobileNoValidation()">
     <span id="mobileNo-error"></span>
     <br> 
        Source<br>
    <input type="text" name="Source" id="Source" placeholder="Source" onkeyup="sourceValid()">
    <span id="source-error"></span>
    <br><br>    
  </div>

 &emsp;&emsp;&emsp; <div class="right">
   &emsp;&emsp;  Destination<br><br>
    <input type="text" name="Destination" id="Destination" placeholder="Destination" onkeyup="destinationValid()">
    <span id="destination-error"></span>
    <br><br>    
 
    Travel Date 
 <input type="date" name="TravelDate" placeholder="TravelDate" id="TravelDate" min="2023-02-08" max="2023-12-31">
     <br> <br>  <br>
   Return Date
  <input type="date" name="ReturnDate" placeholder="ReturnDate" id="ReturnDate" min="2023-02-08" max="2023-12-31"> 
  <br>  
  
   <div>
   <label>
   <br>&emsp;&emsp;Reason <br><br>
  <Select name="Reason">
   <option value="logistic Deliveries">logistic Deliveries</option>
   <option value="Medical Supply">Medical Supply</option>
   <option value="Essential Services">Essential Services</option>
   <option value="Medical Emergency">Medical Emergency</option>
   <option value="Death Cause">Death Cause</option>
   <option value="Wedding Function">Wedding Function</option>
     </Select>
           </label>
           </div>     
     <br>    <br>  
 &emsp;&emsp;No Of Passengers <br><br>
   <input type="number" name="NoOfPassengers" id="NoOfPassengers" placeholder="No Of Passengers"  onkeyup="passengersValidation()">
   <span id="passengers-error"></span>
  <br>
  <br><br>
  &emsp;&emsp;Vaccination Certificate &nbsp;(2 Dose)<br><br>
  <input type="text" name="VaccinationCertificate" id="VaccinationCertificate" placeholder="VaccinationCertificate" onkeyup="vaccinationCertificateValid()">
     <span id="vaccinationCertificate-error"></span>
     <br> <br> 
<br> 
  <label>
   &emsp;&emsp; Upload Image &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br><br>  <input type="file" id="image" name="image" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;><br>
 <br>&emsp;&emsp;&emsp; <input type="Submit" value="Go back!" onclick="history.back()"> &nbsp;&nbsp;&nbsp;&nbsp;
 &emsp;&emsp; <button type="submit">&nbsp;Submit</button>
   </label>
   
</div>
</div>
</form>
<script type="text/javascript" src="/Java Script/ScriptValidation.js"></script>  

</body>
</html>