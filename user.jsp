<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
</head>
<body>

<Style>
body 
{background-color:silver;}{font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}
/* Full-width input fields */
input[type=text], input[type=password] {
  width: 50%;
  padding: 5px;
  height:40px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #FF6347;
  outline: none;
}

hr {
  border: 1px solid #FF6347;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #800080;
  color: white;
  padding: 15px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 50%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

.signupbtn {
  padding: 10px 20px;
  background-color: #f44336;
  
}

/* Float cancel and signup buttons and add an equal width */
.signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
  margin: center;
  padding-left: 280px;
  font-size: 20px;
  
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
/*@media screen and (max-width: 100px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}*/
</style>
<body>
           <li class="active"><a href="/jspfiles/Dashboard.jsp"><i class="fa-solid fa-house-circle-exclamation"></i>&nbsp;Home</a>
 </li>
<form action=/Login style="border:1px solid #ccc"  method="post" > 
  <div class="container">
    <h1>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Login Here</h1>
<br>
&emsp;&emsp;&emsp;&emsp;
    <label for="User Name"><b>User Name</b></label> <br>
   &emsp;&emsp;&emsp;&emsp;
    <input type="text" placeholder="Enter "User Name" name="User Name" required>
<br>
&emsp;&emsp;&emsp;&emsp;
    <label for="Password"><b>Password</b></label><br>
    &emsp;&emsp;&emsp;&emsp;
    <input type="Password" placeholder="Enter Password" name="Password" required>
<br>
    
    <div class="clearfix">
   &emsp;&emsp;&emsp; &emsp; <button value="button" class="cancelbtn"> &emsp;&emsp;&emsp;Sign In</button>
    
    </div>
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
    <a href="ForgetPassword.jsp">Forgot Password?</a> <br> 
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
    <div class="Sign Up">
  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
   Don't have an account?<a href="/jspfiles/Register.jsp">&nbsp;SIGN UP </a>&nbsp;Here <br><br>
    </div>
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
    <a href="/jspfiles/Admin.jsp">Login Credentials</a> 
    
 </div>
</form>
</body>
</html>


