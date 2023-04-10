<%@page import="com.epassproject.epassform.model.EpassForm"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title> </title>
 
</head>
<style>
 body{
 background-color:aqua;
 }
tr{
background-color: teal;
}
th{
background-color:#FFA07A ;
color:white;
}
</style>

<body>
<h1 align="center"> &emsp;&emsp;Epass User List</h1> 
  <form action="/update" method="post">
  
  <% HttpSession session2=request.getSession();
   List<EpassForm>listEpassForm=(List<EpassForm>)request.getAttribute("List_Users");
   %>

   <table border="1"> <br>
       <thead>
       <tr>
       <th>applicantNo</th>
       <th>applicantName </th>
       <th>aadharNo </th>
       <th>gender</th>
       <th>reason</th>
       <th>fatherName</th>
       <th>dob</th>
       <th>fromDistrict</th>
       <th>toDistrict</th>
       <th>state</th>
       <th>travelDate</th>
       <th>returnDate</th>
       <th>NoOfPassengers</th>
       <th>vehicleNo</th>
       <th>mobileNo</th>
       <th>vaccinationCertificate</th>
       <th>status</th>
       <th>Certificate Image </th>
       </tr>
       </thead>
       </tbody>
     <% for(EpassForm epass:listEpassForm) { %>
       <tr>
          <td><input type ="checkbox"
          value="<%=epass.getApplicationNo() %>" name="checkbox">
          <%=epass.getApplicationNo() %> 
         </td>
       <td> <%=epass.getApplicantName() %> </td>
       <td> <%=epass.getAadharNo() %> </td>
       <td> <%=epass.getGender() %> </td>
       <td> <%=epass.getReason() %> </td>
       <td> <%=epass.getFatherName() %> </td>
       <td> <%=epass.getDob() %> </td>
       <td> <%=epass.getFromDistrict() %> </td>
       <td> <%=epass.getToDistrict() %> </td>
       <td> <%=epass.getState() %> </td>
       <td> <%=epass.getTravelDate() %> </td>
       <td> <%=epass.getReturnDate() %> </td>
       <td> <%=epass.getNoOfPassengers() %> </td>
       <td> <%=epass.getVehicleNo() %> </td>
       <td> <%=epass.getMobileNo() %> </td>
       <td> <%=epass.getVaccinationCertificate() %> </td>
       <td> <%=epass.getStatus() %> </td>
       <td> <img alt="image" src="data:image/jpg;base64,<%=epass.getImagePath() %>" style="width:400px; height:380px;"> </td>
      </tr>
      <% } %> 
      </tbody>
   </table>
   
 <button type="submit">Approve</button>
 <button type="submit" formaction="/reject" method="post">Reject</button>
   
</form>
</body>
</html>