<%@ page import="ir.ac.kntu.domains.Customer" %>
<%@ page import="ir.ac.kntu.MyApp" %>

<%@ page import="ir.ac.kntu.domains.Post" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Alireza
  Date: 11/11/2020
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Customer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%
    String customerID = null;

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("desiredCustomer")) customerID = cookie.getValue();
        }
    }
    Customer customer = MyApp.getCustomerService().findById(Long.valueOf(customerID));
%>
<table class="table">
    <tr>
        <td colspan="2" style="text-align: center">Customer</td>
    </tr>
    <tr>
        <th scope=row class="bg-warning">Name</th>
        <td><%=customer.getName()%>
        </td>
    </tr>
    <tr>
        <th scope=row class="bg-warning">National Code</th>
        <td><%=customer.getNationalCode()%>
        </td>
    </tr>
    <tr>
        <th scope=row class="bg-warning">Discount</th>
        <td><%=customer.getDiscount()%>
        </td>
    </tr>
    <%
        List<Post> postsFrom = customer.getPostsFrom();
        List<Post> postsTo = customer.getPostsTo();
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
