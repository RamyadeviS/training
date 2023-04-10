<%@page import="com.epassproject.epassform.model.EpassForm"%>
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
 background-color:aqua;
 display: flex;
 }
tr{
background-color: teal;
}
th{
background-color:#FFA07A ;
color:white;
}
.container{
 background-color:white;
  width: 400px;
  height:300px;
  padding: 0.9rem 1.5rem;
  padding-center: -110px;
  margin-left: 370px;
  margin-top: 90px; 
  font-size: 15px;
  align-content: right;
  margin-right:100px;
}

</style>

<body>
<br>
<div class="container">
<h1 align="center">Epass Status View</h1> 
<% HttpSession session2=request.getSession();
//List<EpassForm>listEpassForm=//(List<EpassForm>)request.getAttribute("List_Users");
 String status =(String) session2.getAttribute("status_List");
 %>
 
   <table border="10" align="center">
       <thead>
       <tr>
      <th>status</th>
       </tr>
      </thead>
      <tbody>
       <tr>
      <br><br>   <td> <%=status%> </td>
      </tr>
         </tbody>
         </table>
        </div> 
</body>
</html>