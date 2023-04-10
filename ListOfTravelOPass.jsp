<%@page import="com.epassproject.epassform.model.TravelEpassForm"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
 body{
 background-color:#FFA07A;
 }
tr{
background-color:#FF6347;
}
th{
background-color:#FF8C00;
color:white;
}
</style>
<body>

<h1 align="center">Travel Pass User List</h1>
<form action="/Approve" method="post">

<% HttpSession seesion=request.getSession();
 List<TravelEpassForm>listTravelPass=(List<TravelEpassForm>)request.getAttribute("Travel_List");
 %>
 
   <table border="1">
       <thead>
       <tr>
       <th>applicationNo</th>
       <th>applicantName </th>
       <th>gender</th>
       <th>fatherName</th>
       <th>ticketNo</th>
       <th>dob</th>
       <th>aadharNo </th>
       <th>mobileNo</th>
       <th>source</th>
       <th>destination </th>
       <th>travelDate</th>
       <th>returnDate</th>
       <th>reason</th>
       <th>NoOfPassengers</th>
       <th>vaccinationCertificate</th>
       <th>status</th>
       <th>Certificate Image </th>
       </tr>
       </thead> 
       </tbody>
       <% for(TravelEpassForm TravelPass:listTravelPass) { %>
       <tr>
       
         <td><input type ="checkbox"
          value="<%=TravelPass.getApplicationNo() %>" name="checkbox">
          <%=TravelPass.getApplicationNo() %>
         </td>
         </form>
         
       <td> <%=TravelPass.getApplicantName() %> </td>
       <td> <%=TravelPass.getGender() %> </td>
       <td> <%=TravelPass.getFatherName() %> </td>
       <td> <%=TravelPass.getTicketNo()%> </td>
       <td> <%=TravelPass.getDob()%> </td>
       <td> <%=TravelPass.getAadharNo() %> </td>
       <td> <%=TravelPass.getMobileNo()%> </td>
       <td> <%=TravelPass.getSource()%> </td>
       <td> <%=TravelPass.getDestination()%> </td>
       <td> <%=TravelPass.getTravelDate() %> </td>
       <td> <%=TravelPass.getReturnDate() %> </td>
       <td> <%=TravelPass.getReason() %> </td>
       <td> <%=TravelPass.getNoOfPassengers() %> </td>
       <td> <%=TravelPass.getVaccinationCertificate() %> </td>
       <td><%=TravelPass.getStatus() %></td>
        <td> <img alt="image" src="data:image/jpg;base64,<%=TravelPass.getImagePath() %>" style="width:400px;"></td>
       </tr>
       <% } %> 
      </tbody>
   </table>
   </form>
   <button type="Submit">Approve </button>
 <button type="Submit" formaction="/Reject" method="post">Reject</button>
   
   </form>
       </body>
</html>