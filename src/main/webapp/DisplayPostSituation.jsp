<%@ page import="ir.ac.kntu.MyApp" %>
<%@ page import="ir.ac.kntu.domains.Post" %>

<%--
  Created by IntelliJ IDEA.
  User: Alireza
  Date: 11/11/2020
  Time: 10:27 PM

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Post Situation</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<body>
<%
    long id = 0;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("post")) id = Long.parseLong(cookie.getValue());
        }
    }
    Post post = MyApp.getPostService().findById(id);
%>
<table class="table">
    <thead>
    <tr class="table table-bordered table-dark" style="color: black">
        <th scope=col>Name</th>
        <th scope=col>Sender</th>
        <th scope=col>Receiver</th>
        <th scope=col>Situation</th>
        <th scope=col>Transportation</th>
        <th scope=col>From</th>
        <th scope=col>To</th>
        <th scope=col>Send Date</th>
        <th scope=col>Receive Date</th>
        <th scope=col>Type</th>
        <th scope=col>Weight</th>
    </tr>

    <tr>
        <td><%=post.getName()%></td>
        <td><%=post.getSender().getName()%></td>
        <td><%=post.getReceiver().getName()%></td>
        <td><%=post.getSituation()%></td>
        <td><%=post.getTransportation()%></td>
        <td><%=post.getFrom().getName()%></td>
        <td><%=post.getTo().getName()%></td>
        <td><%=post.getSendDate()%></td>
        <td><%=post.getReceiveDate()%></td>
        <td><%=post.getType()%></td>
        <td><%=post.getWeight()%></td>
    </tr>

</table>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
