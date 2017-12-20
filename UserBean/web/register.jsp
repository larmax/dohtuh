<%-- 
    Document   : register
    Created on : Dec 1, 2017, 12:07:20 PM
    Author     : s1601385
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, intial-scale=1.0">
    </head>
    
        <h1>Rekisteröityminen</h1>
        
        <c:forEach items="${errors}" var="e">
                   <c:out value="${e}"></c:out> 
        </c:forEach>
    
    
        <p>${errors}</p>
        <form action="register" method="post">
            <p>
                <label for="username"></label>
                <input type="text" name="username" value="${user.username}" placeholder="Käyttäjätunnus">
            </p>
            <p>
                <label for="salasana"></label>
                <input type="password" name="password" value="${user.password}" placeholder="Salasana">
            </p>
            <p>
                <label for="etunimi"></label>
                <input type="text" name="firstname" value="$(user.firstname)">
            </p>
            <p>
                <label for="sukunimi"></label>
                <input type="text" name="lastname" value="$(user.lastname)">
            </p>
            <p>
                <label for="email"></label>
                <input type="email" name="email" placeholder="Email">
            </p>
            <input type="submit" value="Kirjaudu" name="kirjaudu">
        </form>
    
</html>
