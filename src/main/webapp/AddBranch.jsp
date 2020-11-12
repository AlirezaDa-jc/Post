
<!--  Created by IntelliJ IDEA.-->
<!--  User: Alireza-->
<!--  Date: 11/11/2020-->
<!--  Time: 1:48 AM-->


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add Branch</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="form-group" >
    <form class="px-4 py-3" name="form1" method="post" action="addBranch">
        <div class="form-group">
            <label for="City">City</label>
            <input type="text" class="form-control" id="City" placeholder="example: Tehran , Shiraz ..." name="city">
        </div>
        <div class="form-group">
            <label for="Employees">Employees</label>
            <input type="number" class="form-control" id="Employees" placeholder="Employees" name="employees">
        </div>

        <button type="submit" class="btn btn-primary">Add Branch</button>
    </form>
    <div class="dropdown-divider"></div>
    <button type="submit" class="btn btn-primary" onclick="function returnMenu() {
           location.href = 'Menu.jsp';
        }
        returnMenu()">Menu</button>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>