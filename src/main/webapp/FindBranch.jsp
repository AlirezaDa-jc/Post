<%@ page import="ir.ac.kntu.MyApp" %>
<%@ page import="ir.ac.kntu.domains.Branch" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Alireza
  Date: 11/12/2020
  Time: 11:36 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Branch</title>
</head>
<body>
<form class="form-inline" name="form1" method="post" action="displayBranch">

    <label class="my-1 mr-2" for="Branch">Branch:</label>
    <select class="custom-select my-1 mr-sm-2" id="Branch" name="branch">
        <%
            List<Branch> branches = MyApp.getBranchService().findAll();
        %>
        <%for (Branch branch : branches) {%>
        <option value="<%=branch.getId()%>">ID :<%=branch.getId()%> City:<%=branch.getCity().getName()%>
        </option>
        <%}%>
    </select>
    <input type="submit" value="Submit">
</form>
</body>
</html>
