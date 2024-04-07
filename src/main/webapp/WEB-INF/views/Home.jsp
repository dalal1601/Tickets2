<%@ include file="Shared/Header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Events</title>
</head>
<body>
<h1>Events</h1>
<ul>
    <c:forEach items="${events}" var="event">
        <li>
            Event Name: ${event.eventName}<br>
            Event Date: ${event.eventDate}<br>
            Event Location: ${event.eventLocation}<br>
            <!-- Add more event details as needed -->
        </li>
    </c:forEach>
</ul>
</body>
</html>


<%@ include file="Shared/Footer.jsp"%>