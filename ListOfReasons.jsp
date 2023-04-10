<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.DriverManager" %>
    <%@ page import="java.sql.PreparedStatement" %>
    <%@ page import="java.sql.ResultSet" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List Of Reasons</title>
</head>
<body>

<h2>List Of Reasons</h2>

<% 
	Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
        String query="select types_of_reasons from reason";
		//System.out.println(connection);
	    PreparedStatement ps =connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();	
		%>
		<table class="table">
		
		<tr>
		<td> types_of_reasons </td>
		</tr>
		
		<% while(rs.next()) { %>
		<tr>
		<td><%=rs.getString(1) %></td>
		</tr>
	<%	
	} %>
	
		</table>
</body>
</html>