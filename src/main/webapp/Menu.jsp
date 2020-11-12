<%--
  Created by IntelliJ IDEA.
  User: Alireza
  Date: 11/10/2020
  Time: 4:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Menu</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")) userName = cookie.getValue();
        }
    }
%>
<h3><%=userName %></h3>
<br>
<div class="btn-group-vertical d-flex" style="width: 30%;justify-content: center">
<a class="btn btn-info" href="AddBranch.jsp" role="button">Add Branch</a><br><br>
<a class="btn btn-info" href="AddCustomer.html" role="button">Add Customer</a><br><br>
<a class="btn btn-info" href="AddCity.html" role="button">Add City</a><br><br>
<a class="btn btn-info" href="AddPost.jsp" role="button">Add Post</a><br><br>
<a class="btn btn-info" href="DisplayPosts.jsp" role="button">Display Posts</a><br><br>
<a class="btn btn-info" href="DisplaySentPosts.jsp" role="button">Display Sent Posts</a><br><br>
<a class="btn btn-info" href="DisplayReceivedPosts.jsp" role="button">Display Received Posts</a><br><br>
<a class="btn btn-info" href="FindCustomer.html" role="button">Find Customer</a><br><br>
<a class="btn btn-info" href="FindPostsByCityFrom.jsp" role="button">Find City</a><br><br>
<a class="btn btn-info" href="ChangeSituation.html" role="button">Update Situations</a><br><br>
<a class="btn btn-info" href="LogOutServlet" role="button">LogOut</a><br><br>
</div>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

</body>
</html>
