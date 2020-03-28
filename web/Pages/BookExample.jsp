<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.03.2020
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Example</title>
</head>
<body>
<h2>This is page about Book Example</h2>

<br>
<form action="/Lib_war_exploded/getBookExampleCountDuringIndependence" method="get">
    <fieldset>
        <legend>Get book examples published during Ukrainian independence:</legend>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${independence}" default="" /></p>


<br>
<form action="/Lib_war_exploded/getBookExampleInfoByBookName" method="get">
    <fieldset>
        <legend>Get info about book:</legend>
        <label for="name">Book title:</label><br>
        <input type="text" id="name" name="name"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${info}" default="" /></p>



</body>
</html>
