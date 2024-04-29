<%@ include file="Shared/Header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Event Details</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card mt-5">
                <div class="card-header">
                    <h1 class="card-title">Event Details</h1>
                </div>
                <div class="card-body">
                    <img src="${event.imageUrl}" class="img-fluid" alt="Event Image">
                    <div class="mb-3">
                        <strong>Event Name:</strong> ${event.eventName}
                    </div>
                    <div class="mb-3">
                        <strong>Event Date:</strong> ${event.dateEvent}
                    </div>
                    <div class="mb-3">
                        <strong>Event Location:</strong> ${event.place}
                    </div>
                    <div>
                        <strong>Event Description:</strong>
                        <p>${event.description}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Iterate over the list of tickets and display their information -->



</body>
</html>

<%@ include file="Shared/Footer.jsp"%>
