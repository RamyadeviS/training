<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/CSS files/ApplicationNo.css">

<%
    String name=session.getAttribute("userName").toString();

%>
</head>
<style>
body {
	background-color:#FF6666 ;
	
}
</style>
<body>
<div class="container">
<h1 align="center">Status View</h1>
<form name="form" action="/userView" method="post" align="center">
<br><br><br><br>
<div class="details">
 User Name :<br><input type="text" name="UserName" id="UserName" value=<%=name %>  placeholder="UserName"><br><br>
 Application No:<br><input type="number" name="search" id="ApplicationNo" placeholder="ApplicationNo"><br><br>
 
  <input type="button" value="Cancel">
   <button type="Submit">submit</button>

 </div>
 </form>
 </div>
</body>
</html>