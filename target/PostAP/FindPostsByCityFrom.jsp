<%@ page import="ir.ac.kntu.MyApp" %>
<%@ page import="ir.ac.kntu.domains.City" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Alireza
  Date: 11/11/2020
  Time: 10:58 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Posts By City From</title>
</head>
<body>
<form class="form-inline" name="form1" method="post" action="displayCity">

    <label class="my-1 mr-2" for="City">City:</label>
    <select class="custom-select my-1 mr-sm-2" id="City" name="city">
        <%
            List<City> cities = MyApp.getCityService().findAll();
        %>
        <%for (City city : cities) {%>
        <option value="<%=city.getName()%>"><%=city.getName()%>
        </option>
        <%}%>
    </select>
    <input type="submit" value="Submit">
</form>
</body>
</html>
