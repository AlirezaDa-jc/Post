<%--
  Created by IntelliJ IDEA.
  User: Alireza
  Date: 11/10/2020
  Time: 04:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Success</title>
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
<h3>Hi <%=userName %>, Login successful.</h3>
<br>
<a href="Menu.jsp">Menu Page</a>
<form action="LogOutServlet" method="post">
    <input type="submit" value="Logout" >
</form>
</body>
</html>
