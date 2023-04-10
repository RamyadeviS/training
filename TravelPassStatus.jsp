<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <style>
body{
 background-color:#FF7F50;
</style>

 <form  id="form" name="myform1" action="/TravelPassStatus" method="post">
    <center>
    Enter Applicant Name:<input type="text" name="ApplicantName" id=" ApplicantName" placeholder=" Applicant Name"><br><br>
    
    Enter Ticket No:<input type="text" name="TicketNo" id="TicketNo" placeholder="Ticket No"><br><br>
    
     Enter Aadhar No:<input type="number" name="AadharNo" id="AadharNo" placeholder="Aadhar No"><br><br>
          
    Enter Source:<input type="text" name="Source" id="Source" placeholder=" Source"><br><br>
    Enter Destination:<input type="text" name="Destination" id="Destination" placeholder="Destination"><br><br>
    
    Enter Travel Date     :<input type="date" name="TravelDate" 
                            placeholder="dd-mm-yyyy" value=""
                            min="2023-02-08" max="2023-12-31"> <br><br>
          
    Enter Return Date     :<input type="date" name="ReturnDate" 
                           placeholder="dd-mm-yyyy" value=""
                           min="2023-02-08" max="2023-12-31"> <br><br>
   
    
    Enter Reason        :</label>
              <Select name="Reason">
                  <option value="logistic Deliveries">logistic Deliveries</option>
                  <option value="Medical Supply">Medical Supply</option>
                  <option value="Essential Services">Essential Services</option>
                  <option value="Medical Emergency">Medical Emergency</option>
                  <option value="Ecommerce Delivery Boys">Ecommerce Delivery Boys</option>
                  <option value="Death Cause">Death Cause</option>
                  <option value="Wedding Function">Wedding Function</option>
                  
              </Select>
              </div><br>  
   
   Enter No Of Passengers:<input type="number" name="NoOfPassengers" id="NoOfPassengers" placeholder="No Of Passengers"><br><br>
   
   <div><label>
    Enter Mobile No      :</label>
             <Select name="Mobile No">
             <option>+91</option>
             </Select>
             <input type="number" name="MobileNo" id="MobileNo" placeholder="**********"><br><br>    
        </select>
        </div>
        
    <div><label>
     Enter Vaccination Certificate:</label>
              <Select name="VaccinationCertificate">
                  <option value="Yes">Yes</option>
                   <option value="No">No</option>
              </Select>
              </div><br>
  <br>  <button type="Back">Back</button>&nbsp;&nbsp;
    <button type="Submit">Submit</button><br><br>
   </form>
   </center>
</body>
</html>
   
</body>
</html>