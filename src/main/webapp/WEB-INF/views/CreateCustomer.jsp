<%@ include file="Shared/Header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Creation</title>
</head>
<body>
<header>
    <h1>Customer Creation</h1>
</header>
<main>
    <form action="saveCustomer" method="post">
        <div>
            <label for="firstName">First Name : </label>
            <input type="text" id="firstName" name="firstName">
        </div>
        <div>
            <label for="lastName">Last Name : </label>
            <input type="text" id="lastName" name="lastName">
        </div>
        <div>
            <label for="email">Email : </label>
            <input type="email" id="email" name="email">
        </div>
        <div>
            <label for="address">Address : </label>
            <input type="text" id="address" name="address">
        </div>
        <div>
            <input type="submit" value="Save">
        </div>
    </form>
</main>
<footer>
    <a href="customersList">Customers List</a>
</footer>
</body>
</html>

<%@ include file="Shared/Footer.jsp"%>
