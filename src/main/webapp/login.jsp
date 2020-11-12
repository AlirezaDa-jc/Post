<%--
  Created by IntelliJ IDEA.
  User: Alireza
  Date: 11/10/2020
  Time: 9:36 PM
--%>
<%@ page import="ir.ac.kntu.MyApp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%
    if(!session.isNew()) {
        String userName = null;

        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")) userName = cookie.getValue();

            }
        }
        MyApp.getUserService().findByUserName(userName);
        response.sendRedirect("Menu.jsp");
    }
%>
<div class="form-group" >
    <form class="px-4 py-3" name="form1" method="post" action="login">
        <div class="form-group">
            <label for="Username">UserName</label>
            <input type="text" class="form-control" id="Username" placeholder="UserName" name="username">
        </div>
        <div class="form-group">
            <label for="Password">Password</label>
            <input type="password" class="form-control" id="Password" placeholder="Password" name="password">
        </div>

        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    <div class="dropdown-divider"></div>
    <button type="submit" class="btn btn-primary" onclick="function signUp() {
           location.href = 'SignUp.html';
        }
        signUp()">Sign Up</button>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<%--<form name="form1" method="post" action="login">--%>
<%--    <label for="UserName">UserName:</label><br>--%>
<%--    <input type="text" id="UserName" name="username"><br><br>--%>
<%--    <label for="Password">Password:</label><br>--%>
<%--    <input type="text" id="Password" name="password"><br><br>--%>
<%--    <input type="submit" value="Submit">--%>
<%--</form>--%>
</body>
</html>

