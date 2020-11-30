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
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-12 bg-dark d-flex text-light justify-content-center align-items-center" style="height:100vh">

            <form>
                <div class="form-group">
                    <label for="FirstnameInput">FIRST NAME</label>
                    <input type="text" class="form-control" id="FirstnameInput" aria-describedby="UserFirstname">
                    <small id="UserFirstname" class="form-text text-muted">We'll never share your information with anyone else.</small>
                </div>

                <div class="form-group">
                    <label for="FirstNameInput">LAST NAME</label>
                    <input type="text" class="form-control" id="LastnameInput" aria-describedby="UserLastname">
                    <small id="UserLastname" class="form-text text-muted">We'll never share your information with anyone else.</small>
                </div>

                <div class="form-group">
                    <label for="AgeInput">AGE</label>
                    <input type="number" class="form-control" id="AgeInput" aria-describedby="UserAge">
                    <small id="UserAge" class="form-text text-muted">We'll never share your information with anyone else.</small>
                </div>

                <div class="form-group">
                    <label for="PhoneInput">PHONE NUMBER</label>
                    <input type="text" class="form-control" id="PhoneInput" aria-describedby="UserPhone">
                    <small id="UserPhone" class="form-text text-muted">We'll never share your information with anyone else.</small>
                </div>

                <div class="form-group">
                    <label for="EmailInput">E_MAIL</label>
                    <input type="text" class="form-control" id="EmailInput" aria-describedby="UserEmail">
                    <small id="UserEmail" class="form-text text-muted">We'll never share your information with anyone else.</small>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>

            </form>

        </div>
    </div>
</div>

</body>
</html>
