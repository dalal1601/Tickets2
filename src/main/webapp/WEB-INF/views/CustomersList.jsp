<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="Shared/Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
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
            <c:forEach items="${customersVue}" var="customer">
                <tr>
                   <td>${customer.id}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.address}</td>
                    <td>${customer.customerState}</td>
                    <td>
                        <a
                                onclick="return confirm('Are you sure to delete this cutomer?')"
                                href="deleteCustomer?id=${customer.id}" >
                            Delete
                        </a>
                    </td>
                    <td>
                        <a
                                href="editCustomer?id=${customer.id}" >
                            Edit
                        </a>
                    </td>
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

<%@ include file="Shared/Footer.jsp"%>
