<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.03.2020
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h2>this is page about books</h2>

<br>
<form action="/Lib_war_exploded/checkAvailability" method="get">
    <fieldset>
        <legend>Get availability of the book:</legend>
        <label for="name">Book title:</label><br>
        <input type="text" id="name" name="name"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${book_availability}" default="" /></p>

<br>
<form action="/Lib_war_exploded/getAverageBookReadingPeriod" method="get">
    <fieldset>
        <legend>Get average book reading period:</legend>
        <label for="read_name">Book title:</label><br>
        <input type="text" id="read_name" name="read_name"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${reading_period}" default="" /></p>

</body>
</html>
