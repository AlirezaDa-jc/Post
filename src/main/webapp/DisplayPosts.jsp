<%@ page import="ir.ac.kntu.MyApp" %>
<%@ page import="ir.ac.kntu.domains.Post" %>
<%@ page import="java.util.List" %>
<%--
Created by IntelliJ IDEA.
User: Alireza
Date: 11/11/2020
Time: 9:51 PM
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Posts</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<form method="GET" id="my_form" action="DisplayPostSituation.jsp"></form>

<div style="display: flex; justify-content: space-around">

    <% List<Post> posts = MyApp.getPostService().findAll();%>

    <table class="table">
        <thead>
        <tr class="table-danger" style="color: white">
            <th scope=col>Name</th>
            <th scope=col>Sender</th>
            <th scope=col>Receiver</th>
            <th scope=col>From</th>
            <th scope=col>To</th>
        </tr>

            <%for (Post post : posts) {%>
        <tr>
            <td><%=post.getName()%>
            </td>
            <td><%=post.getSender().getName()%>
            </td>
            <td><%=post.getReceiver().getName()%>
            </td>
            <td><%=post.getFrom().getName()%>
            </td>
            <td><%=post.getTo().getName()%>
            <td><input form="my_form" type="submit" value="See Situation" onclick="
                    function setCookie() {
                    document.cookie = 'post='+<%=post.getId()%>
                    }
                    setCookie()">
            </td>
        </tr>
            <%}%>

    </table>

</body>
</html>
