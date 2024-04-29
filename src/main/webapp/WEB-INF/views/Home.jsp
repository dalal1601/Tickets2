<%@ include file="Shared/Header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Events</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Events</h1>
    <div class="row mt-4">
        <c:forEach items="${eventsVue}" var="event">
            <div class="col-md-4">
                <div class="card mb-4 shadow-sm">
                    <!-- Event Image (if available) -->
                    <!-- <img src="" class="card-img-top" alt="Event Image"> -->
                    <img src="${event.imageUrl}" class="card-img-top" alt="Event Image">
                    <div class="card-body">
                        <h5 class="card-title">${event.eventName}</h5>
                        <p class="card-text">Date: ${event.dateEvent}</p>
                        <p class="card-text">Location: ${event.place}</p>
                        <!-- Add more event details as needed -->
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <a href="detailsEvent?eventId=${event.id}">View Details</a>
                                <!-- Add more buttons/actions as needed -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>

<%@ include file="Shared/Footer.jsp"%>
