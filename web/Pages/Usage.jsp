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
    <title>Usages</title>
</head>
<body>
<h2>This is page about Usage</h2>

<br>
<form action="/Lib_war_exploded/getCountOfUsagesOfPeriod" method="get">
    <fieldset>
        <legend>Get count of usages by period:</legend>
        <label for="start">Start (YYYY-MM-DD):</label><br>
        <input type="text" id="start" name="start"><br>

        <label for="end">End (YYYY-MM-DD):</label><br>
        <input type="text" id="end" name="end"><br>
        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${period}" default="" /></p>



</body>
</html>
