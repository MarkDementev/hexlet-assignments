<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Show</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
        <tr>
        <td><c:out value="${user.get('id')}" /></td>
        <td><c:out value="${user.get('firstName')}" /></td>
        <td><c:out value="${user.get('lastName')}" /></td>
        <td><c:out value="${user.get('email')}" /></td>
        <td><a href='/users/delete?id=${user.get("id")}'>Удалить пользователя</a></td>
        </tr>
    </body>
</html>
<!-- END -->
