<%@ page import="com.hcl.model.LoginModel" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Successful Login</title>
</head>
<body>

<%
    LoginModel model = (LoginModel) session.getAttribute("abc");
    out.println("<h1>Welcome " + model.getUsername() + "</h1>");
%>

</body>
</html>