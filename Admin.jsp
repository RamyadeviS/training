<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 60%;
  padding: 5px;
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
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 50%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 30%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
  margin: center;
  padding-left: 280px
  
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

<form action="/AdminLogin" style="border:1px solid #ccc"  method="post" > 
  <div class="container">
    <h1> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Admin Login</h1>


    <label for="Mail Id"><b>Email</b></label> <br>
    <input type="text" placeholder="Enter Mail Id" name="Mail Id" required>
<br>
    <label for="Password"><b>Password</b></label><br>
    <input type="Password" placeholder="Enter Password" name="Password" required>
<br>
    <label>
      <input type="checkbox" checked="checked" name="remember" required style="margin-bottom:15px"> Remember me
    </label>
    
    <div class="clearfix">
      <button value="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign In</button>
    </div>
  </div>
</form>

</body>
</html>
