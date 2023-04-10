<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
<link rel ="stylesheet" href="/CSS files/Dashboard.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">

</head>

<style>
body{
background-color: aqua;
}
    .container{
	height: 200px;
	width: 290px;
	background-color:#0000ff;
	border-radius: 10px;
	margin-top:140px;
	margin-left: 20px;
	align-content: center;
	align-text: bottom;
	align-content: center;
	margin-left:100px;
}
.container1{
	height: 200px;
	width: 290px;
	background-color: teal;
	border-radius: 10px;
	margin-top: -200px;
	margin-left: 30px;
	align-content: center;
	align-text: bottom;
    margin-left:480px;
}

.container2{
	height: 200px;
	width: 290px;
	background-color: #ff80c0;
	border-radius: 10px;
	margin-top: -200px;
	margin-left: 50px;
	align-content: center;
	align-text: bottom;
	margin-left:850px;	
}
</style>

<body>
<div class="menu-bar">
        <ul>
        
        <li><a href="/listEpassForm"><i class="fa-solid fa-table-list"></i></i>&nbsp;Epass Form List View</a></li>        
         <li><a href="/listTravelPass"><i class="fa-solid fa-table-list"></i>&nbsp;Travelpass Form List View</a></li>        
    <li> <a href="/jspfiles/Dashboard.jsp"><i class="fa-solid fa-right-from-bracket"></i>&nbsp;Logout</a></li>
     
       </ul>
       </div>
        <div class="container">
     <br><br><br><br>  <h2 class="topic-heading">Total Epass Count</h2>
            <p><b>${Epass_count}</b></p>
</div>
        
          <div class="container1">
       <br><br><br><br>  <h2 class="topic-heading">Total Travel Pass Count</h2>
            <p><b>${TravelPass_count}</b></p>
</div>

         <div class="container2">
      <br><br><br><br>   <h2 class="topic-heading">Total User Count</h2>
            <p><b>${TotalUser_count}</b></p>
</div>
          
        <body style="text-align:center">
   
    <div id="counter">
        <!-- counts -->
    </div>

</body>
</html>