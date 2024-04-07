<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Customers List</title>
</head>
<body>
<header>
    <h1>Customers List</h1>
</header>
<main>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">FIRST NAME</th>
            <th scope="col">LAST NAME</th>
            <th scope="col">ADDRESS</th>
            <th scope="col">STATE</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${customerVue}" var="customer">
                <tr>
                   <td></td>
                </tr>
            </c:forEach>
        </tbody>

    </table>


</main>
<footer>
    <a href="createCustomer">Customer Creation</a>
</footer>
</body>
</html>


