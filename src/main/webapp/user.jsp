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
    <title>User Management</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/toastr@2.1.4/build/toastr.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/toastr@2.1.4/build/toastr.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="card container px-6" style="height: 100vh">
        <h3 class="text-center">User Management</h3>
        <c:if test="${message != null}">
            <h6 class="d-none" id="message">${message}</h6>
        </c:if>
        <div>
            <a href="/user?action=create" class="btn btn-primary mb-2">Create</a>
            <a href="/user?action=showRestore" class="btn btn-primary mb-2">Restore</a>
        </div>

        <table class="table table-striped">
            <tr>
                <td>
                    Id
                </td>
                <td>
                    Last Name
                </td>
                <td>
                    First Name
                </td>
                <td>
                    User Name
                </td>
                <td>
                    Email
                </td>
                <td>
                    Date Of Birth
                </td>
                <td>
                    Role
                </td>
                <td>
                    Gender
                </td>
                <td>
                    Action
                </td>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>
                            ${user.id}
                    </td>
                    <td>
                            ${user.lastName}
                    </td>
                    <td>
                            ${user.firstName}
                    </td>
                    <td>
                            ${user.userName}
                    </td>
                    <td>
                            ${user.email}
                    </td>
                    <td>
                            ${user.dob}
                    </td>
                    <td>
                            ${user.role.name}
                    </td>
                    <td>
                            ${user.gender}
                    </td>
                    <td>
                        <a class="btn btn-danger" onclick="return confirm('Do you want remove ${user.firstName} ?')" href="/user?action=delete&id=${user.id}">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script>
    const message = document.getElementById('message');
    if (message !== null && message.innerHTML) {
        toastr.success(message.innerHTML);
    }
</script>
</body>
</html>