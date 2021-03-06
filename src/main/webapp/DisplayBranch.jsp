<%@ page import="ir.ac.kntu.MyApp" %>
<%@ page import="ir.ac.kntu.domains.Branch" %>
<%@ page import="ir.ac.kntu.domains.Post" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Alireza
  Date: 11/12/2020
  Time: 11:40 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Branch</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%
    String branchId = null;

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("desiredBranch")) branchId = cookie.getValue();
        }
    }
    Branch branch = MyApp.getBranchService().findById(Long.valueOf(branchId));
%>

<table class="table">
    <tr>
        <td colspan="2" style="text-align: center">City</td>
    </tr>
    <tr>
        <th scope=row class="bg-warning">Id</th>
        <td><%=branch.getId()%>
        </td>
    </tr>
    <tr>
        <th scope=row class="bg-warning">City</th>
        <td><%=branch.getCity().getName()%>
        </td>
    </tr>

    <%
        List<Post> posts = branch.getPosts();
        for (Post post :
                posts) {
    %>
    <tr>
        <th scope=row class="bg-warning">Posts' Name:</th>
        <td><%=post.getName()%>
        </td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
