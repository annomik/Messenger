<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Chats</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">

        <div>
            <div>
                <div class="w3-container w3-green w3-left-align">
                    <h2>Chats</h2>
                </div>
                <c:forEach items="${myMessages}" var="item">
                            <p>${item.date} от ${item.fromUser}: ${item.message}</p>
                </c:forEach>
            </div>
        </div>
    </body>
</html>

