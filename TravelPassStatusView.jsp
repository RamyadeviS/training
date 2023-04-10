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
<body>

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
.container{
 background-color:white;
  width: 400px;
  height:300px;
  padding: 0.9rem 1.5rem;
  padding-center: -110px;
  margin-left: 370px;
  margin-top: 120px; 
  font-size: 15px;
  align-content: right;
  margin-right:100px;
}
</style>
<body>
<div class="container">
<form action="Approve" method="post">
<h1 align="center">Travel Pass Status View</h1> 
<% HttpSession session2=request.getSession();
//List<EpassForm>listEpassForm=//(List<EpassForm>)request.getAttribute("List_Users");
 String status =(String) session2.getAttribute("status_List");
 %>
   <br><br>
   <table border="10" align="center">
       <thead>
       <tr>
       <th>status</th>
       </tr>
      </thead>
      <tbody>
     
       <tr>
       <td> <%=status%> </td>
      </tr>
         </tbody>
         </table>
         </div>
</body>
</html>