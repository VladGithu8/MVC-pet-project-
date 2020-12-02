<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 30.11.20
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
          crossorigin="anonymous">
</head>
<br>

<nav class="navbar navbar-primary bg-dark">
    <h3 style="color: white">Customers</h3>
</nav>

</br>

<div class="row" >
    <div class="col-sm-4">
        <div class="container bg-dark text-white align-items-lg-baseline">

            <form id="CustomerForm" name="CustomerForm">
                <div class="form-group">
                    <label for="FirstNameInput">FIRST NAME</label>
                    <input type="text" name="FirstNameInput" class="form-control" id="FirstNameInput" aria-describedby="UserFirstname">
                    <small id="UserFirstname" class="form-text text-muted">We'll never share your information with anyone else.</small>
                </div>

                <div class="form-group" >
                    <label for="LastNameInput">LAST NAME</label>
                    <input type="text" name="LastNameInput" class="form-control" id="LastnameInput" aria-describedby="UserLastname">
                    <small id="UserLastname" class="form-text text-muted">We'll never share your information with anyone else.</small>
                </div>

                <div class="form-group" >
                    <label for="AgeInput">AGE</label>
                    <input type="number" name="AgeInput" class="form-control" id="AgeInput"  aria-describedby="UserAge">
                    <small id="UserAge" class="form-text text-muted">We'll never share your information with anyone else.</small>
                </div>

                <div class="form-group" >
                    <label for="PhoneInput">PHONE NUMBER</label>
                    <input type="tel" name="PhoneInput" class="form-control" id="PhoneInput" aria-describedby="UserPhone">
                    <small id="UserPhone" class="form-text text-muted">We'll never share your information with anyone else.</small>
                </div>

                <div class="form-group" >
                    <label for="EmailInput">E_MAIL</label>
                    <input type="email" name="EmailInput" class="form-control" id="EmailInput" aria-describedby="UserEmail">
                    <small id="UserEmail" class="form-text text-muted">We'll never share your information with anyone else.</small>
                </div>

                <div class="form-group" align="right">
                <button type="button" class="btn btn-info" id="save" onclick="addCustomer()" >ADD</button>
                <button type="button" class="btn btn-warning" id="reset" onclick="reSet" >RESET</button>
                </div>

            </form>

        </div>
    </div>
</div>

<div class="col-sm-8">
    <div class="panel-body align-items-right">

        <table id="tblCustomer" class="table table-bordered" cellpadding="0" cellspacing="0" width="100%">
            <thead>

            <tr>

            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>

            </tr>
           </thead>
        </table>

    </div>
</div>

<script src="component/jquery/jquery.js" type="text/javascript"></script>
<script src="component/jquery/jquery.min.js" type="text/javascript"></script>
<script src="component/jquery.validate.min.js" type="text/javascript"></script>

<script>

    var isNew = true;

    function addCustomer()
    {
    if ($("#CustomerForm").valid())
    {
        var url="";
        var data="";
        var method;

        if(isNew == true)
        {
            url = "add.jsp";
            data = $("#CustomerForm").serialize();
            method = 'POST'
        }

        $.ajax({
            type: method,
            url: url,
            dataType: JSON,
            data: data,

            success:function (data) {

            }

        })
    }
    }

</script>


</body>
</html>
