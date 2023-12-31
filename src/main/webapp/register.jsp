<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/18/2023
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="card container px-6" style="height: 100vh">
        <h3 class="text-center">Register</h3>
        <form action="/auth?action=register" method="post">
            <div class="mb-3">
                <label for="userName" class="form-label">User Name</label>
                <input type="text" class="form-control" id="userName" name="userName" >
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" >
            </div>
            <div class="mb-3">
                <label for="re-password" class="form-label">Re-enter Password</label>
                <input type="password" class="form-control" id="re-password" onblur="checkPassword()" name="re-password" >
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName">
            </div>
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email" >
            </div>
            <div class="mb-3">
                <label for="dob" class="form-label">Date Of Birth</label>
                <input type="date" class="form-control" id="dob" name="dob" >
            </div>
            <div class="mb-3">
                <label for="role" class="form-label">Role</label>
                <select class="form-control" name="role" id="role">
                    <c:forEach var="role" items="${roles}">
                        <option value="${role.id}">${role.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="gender" class="form-label">Gender</label>
                <select class="form-control" name="gender" id="gender">
                    <c:forEach var="gender" items="${genders}">
                        <option value="${gender}">${gender}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
            <a href="login.jsp" class="btn btn-primary">Cancel</a>
        </form>
    </div>
</div>
<script>
    function checkPassword(){
        var password = document.getElementById('password').value;
        var repassword = document.getElementById('re-password').value;
        if (password !== repassword){
            alert('Passwords do not match')
        }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>