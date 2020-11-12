<%@ page import="ir.ac.kntu.MyApp" %>
<%@ page import="ir.ac.kntu.domains.Branch" %>

<%@ page import="ir.ac.kntu.domains.City" %>
<%@ page import="ir.ac.kntu.domains.Customer" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Alireza
  Date: 11/11/2020
  Time: 2:28 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add post</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<%
    boolean availableCustomers = MyApp.getCustomerService().findAll().size() > 1;
    boolean availableCities = MyApp.getCityService().findAll().size() > 1;
    boolean availableBranches = MyApp.getBranchService().findAll().size() > 0;
    if (!availableCities || !availableBranches || !availableCustomers) {
%>
<b>Not Enough Branches Or Customers Or Cities</b>

<%
        response.sendRedirect("Menu.jsp");
    }
%>
<form class="form" name="form1" method="post" action="addPost">
    <div class="form-group">
        <label for="Name">Post Name</label>
        <input type="text" class="form-control" id="Name" placeholder="example: Mobile , Laptop , ..." name="name">
    </div>
    <br><br>
    <label class="my-1 mr-2" for="CustomerFrom">Sender's Name:</label>
    <select class="custom-select my-1 mr-sm-2" id="CustomerFrom" name="customerFrom">
        <%
            List<Customer> customers = MyApp.getCustomerService().findAll();
        %>
        <%for (Customer customer : customers) {%>
        <option value="<%=customer.getId()%>">Name:<%=customer.getName()%>
        </option>
        <%}%>
    </select> <br><br>
    <label class="my-1 mr-2" for="CustomerTo">Receiver's Name:</label>
    <select class="custom-select my-1 mr-sm-2" id="CustomerTo" name="customerTo">
        <%for (Customer customer : customers) {%>
        <option value="<%=customer.getId()%>">Name:<%=customer.getName()%>
        </option>
        <%}%>
    </select> <br><br>

    <label class="my-1 mr-2" for="Branch">Branch:</label>
    <select class="custom-select my-1 mr-sm-2" id="Branch" name="branch">
        <%
            List<Branch> branches = MyApp.getBranchService().findAll();
        %>
        <%for (Branch branch : branches) {%>
        <option value="<%=branch.getId()%>">ID :<%=branch.getId()%> City:<%=branch.getCity().getName()%>
        </option>
        <%}%>
    </select> <br><br>

    <label class="my-1 mr-2" for="City">City:</label>
    <select class="custom-select my-1 mr-sm-2" id="City" name="city">
        <%
            List<City> cities = MyApp.getCityService().findAll();
        %>
        <%for (City city : cities) {%>
        <option value="<%=city.getName()%>"><%=city.getName()%>
        </option>
        <%}%>
    </select> <br><br>

    <div class="form-group">
        <label for="Weight">Weight:</label>
        <input type="number" step="0.01" class="form-control" id="Weight" placeholder="example: 5.55,.." name="weight">
    </div>
    <br><br>
    <div class="form-group">
        <label for="SendDate">SendDate</label>
        <input type="text" class="form-control" id="SendDate" placeholder="YYYY-MM-DD" name="senddate">
    </div>

    <br><br>
    <div class="form-group">
        <label for="ReceiveDate">ReceiveDate</label>
        <input type="text" class="form-control" id="ReceiveDate" placeholder="YYYY-MM-DD" name="receivedate">
    </div>
    <br><br>

    <div class="form-group">
        <label for="Situation">Situation</label>
        <input type="text" class="form-control" id="Situation" placeholder="Store , Sent , Received" name="situation">
    </div>
    <br><br>

    <div class="form-group">
        <label for="Transportation">Transportation</label>
        <input type="text" class="form-control" id="Transportation" placeholder="Aerial , Ground , Maritime"
               name="transportation">
    </div>
    <br><br>

    <label>
        <input type="radio" value="VIP" name="type">
    </label>VIP
    <label>
        <input name="gender" type="radio" value="NORMAL">
    </label>Normal

    &nbsp;
    <input type="submit" value="Submit">

</body>
</html>
