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

<p><c:out value="${bookAvailability}" default="" /></p>

<br>
<form action="/Lib_war_exploded/getAverageBookReadingPeriod" method="get">
    <fieldset>
        <legend>Get average book reading period:</legend>
        <label for="readName">Book title:</label><br>
        <input type="text" id="readName" name="readName"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${readingPeriod}" default="" /></p>



<br>
<form action="/Lib_war_exploded/getCountOfBookUsage" method="get">
    <fieldset>
        <legend>Get count of book usage:</legend>
        <label for="usageName">Book title:</label><br>
        <input type="text" id="usageName" name="usageName"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${usageCount}" default="" /></p>




<br>
<form action="/Lib_war_exploded/getCountOfBookUsageByExample" method="get">
    <fieldset>
        <legend>Get count of book usage:</legend>
        <label for="usageCountByEx">Book title:</label><br>
        <input type="text" id="usageCountByEx" name="usageCountByEx"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${usageCountByExample}" default="" /></p>





<br>
<form action="/Lib_war_exploded/getMostAndLessPopularBooks" method="get">
    <fieldset>
        <legend>Get most popular and unpopular books by period:</legend>
        <label for="start">Start of the period (YYYY-MM-DD):</label><br>
        <input type="text" id="start" name="start"><br>

        <label for="end">End of the period (YYYY-MM-DD):</label><br>
        <input type="text" id="end" name="end"><br>
        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${popularity}" default="" /></p>

</body>
</html>
