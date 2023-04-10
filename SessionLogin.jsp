<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String name=session.getAttribute("name").toString();    %>
<h6> <%=name %></h6>
<Style>
body{
background-color:silver;
}
</Style>
<form name="form" action="/Login" method="post">
Enter Aadhar No:<input type="text" name="AadharNo" placeholder="Aadhar No"><br><br>
    Enter Password  :<input type="password" name="Password" placeholder="Password"><br><br>
    
     <button type="Cancel">Cancel</button>
     <button type="Login">Login</button><br><br>
   
        <a href="ForgetPassword.jsp">Forget Password</a> <br> <br>
       
    
   <a href="/jspfiles/Register.jsp">Register</a> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
     </form>
</body>
</html>