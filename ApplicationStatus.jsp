<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/CSS files/StatusView.css">

</head>
<body>
<%
    String name=session.getAttribute("userName").toString();
%>
</head>
<body>
<body>
<div class="container">
<h1 align="center">Status View</h1>
<form name="form" action="/travelView" method="post" align="center">
<br><br><br><br>
<div class="details">
 User Name :<br><input type="text" name="UserName" id="UserName" value=<%=name %>  placeholder="UserName"><br><br>
 Application No:<br><input type="number" name="search" id="ApplicationNo" placeholder="ApplicationNo"><br><br>
 
   <button type="Submit">submit</button>
 <input type="button" value="Cancel">
</div>
</form>
</div>

</body>
</html>