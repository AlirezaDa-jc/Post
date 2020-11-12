<%@ page import="ir.ac.kntu.MyApp" %>

<%@ page import="ir.ac.kntu.domains.City" %>
<%@ page import="ir.ac.kntu.domains.Post" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Alireza
  Date: 11/11/2020
  Time: 11:10 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display City</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%
    String cityName = null;

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("desiredCity")) cityName = cookie.getValue();
        }
    }
    City city = MyApp.getCityService().findByName(cityName);
%>

<table class="table">
    <tr>
        <td colspan="2" style="text-align: center">City</td>
    </tr>
    <tr>
        <th scope=row class="bg-warning">Name</th>
        <td><%=city.getName()%>
        </td>
    </tr>
    <tr>
        <th scope=row class="bg-warning">Coordinations</th>
        <td><%=city.getCoordination()%>
        </td>
    </tr>

    <%
        List<Post> postsFrom = city.getPostsFrom();
        List<Post> postsTo = city.getPostsTo();
        for (Post post :
                postsFrom) {
    %>
    <tr>
        <th scope=row class="bg-warning">Sent Posts' Name:</th>
        <td><%=post.getName ()%>
        </td>
    </tr>
    <%
        }
        for (Post post :
                postsTo) {
    %>
    <tr>
        <th scope=row class="bg-warning">Received Posts' Name:</th>
        <td><%=post.getName()%>
        </td>
    </tr>
    <%}%>

</table>
</body>
</html>
