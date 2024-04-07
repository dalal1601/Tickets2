<%@ include file="Shared/Header.jsp"%>
<main>
    <h1>Customer Creation</h1>
    <form action="saveCustomer" method="post">
        <div class="form-group">
            <label class="form-label" for="firstName">First Name : </label>
            <input class="form-control" type="text" id="firstName" name="firstName">
        </div>
        <div class="form-group">
            <label class="form-label" for="lastName">Last Name : </label>
            <input class="form-control" type="text" id="lastName" name="lastName">
        </div>
        <div class="form-group">
            <label class="form-label" for="email">Email : </label>
            <input class="form-control" type="email" id="email" name="email">
        </div>
        <div class="form-group">
            <label class="form-label" for="address">Address : </label>
            <input class="form-control" type="text" id="address" name="address">
        </div>
        <div class="form-group">
            <input class="form-control btn-primary" class="form-control" type="submit" value="Save">
        </div>
    </form>
</main>
<footer>
    <a href="customersList">Customers List</a>
</footer>


<%@ include file="Shared/Footer.jsp"%>
