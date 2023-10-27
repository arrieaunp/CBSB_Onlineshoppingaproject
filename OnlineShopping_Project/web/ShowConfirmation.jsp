<%-- 
    Document   : ShowComfirmation
    Created on : Oct 19, 2023, 10:22:47 AM
    Author     : aunchisachanatipkul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Confirmation</title>
        <link href="css/style.css" rel ="stylesheet" type ="text/css"/>
    </head>
    <body>
        <h1>Your Order is confirmed!</h1>
        <h1>The total amount is $<%= request.getAttribute("totalPrice") %></h1>
    </body>
</html>
