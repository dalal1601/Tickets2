<%@ include file="Shared/Header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <title>Customer Edition</title>
</head>
<body>
<header>
    <h1>Customer Edition</h1>
</header>
<main>
    <form action="updateCustomer" method="post">
        <div>
            <label hidden="hidden" for="id">id : </label>
            <input hidden="hidden" type="text" id="id" name="id" value="${customerView.id}">
        </div>
        <div>
            <label for="firstName">First Name : </label>
            <input type="text" id="firstName" name="firstName" value="${customerView.firstName}">
        </div>
        <div>
            <label for="lastName">Last Name : </label>
            <input type="text" id="lastName" name="lastName" value="${customerView.lastName}">
        </div>
        <div>
            <label for="email">Email : </label>
            <input type="email" id="email" name="email" value="${customerView.email}">
        </div>
        <div>
            <label for="address">Address : </label>
            <input type="text" id="address" name="address" value="${customerView.address}">
        </div>
        <div>
            <input type="submit" value="Update">
        </div>
    </form>
</main>
<footer>
    <a href="customersList">Customers List</a>
</footer>
</body>
</html>
<%@ include file="Shared/Footer.jsp"%>

