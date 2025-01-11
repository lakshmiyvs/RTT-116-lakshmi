<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <title>Employee Search</title>
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Employee Search</h1>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Role</th>
            <th>Department</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.role}</td>
                <td>${employee.department}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
