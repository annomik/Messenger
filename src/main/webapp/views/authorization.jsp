<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding = "UTF-8"%>
<html>
    <head>
        <title>Authorization</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/api/login">
           <label>Please input login and password</label><br><br>
           <label>Login<input type="text" name = login></label><br><br>
           <label>Password<input type="password" name = password></label><br><br>
           <button type="submit">Authorization</button>
    </body>
</html>