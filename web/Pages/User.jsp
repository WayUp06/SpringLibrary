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
    <title>Users</title>
</head>
<body>
<h2>This is page about User</h2>



<br>
<form action="/Lib_war_exploded/getBooksUsedByUser" method="get">
    <fieldset>
        <legend>Get books used by user:</legend>
        <label for="id">Enter user id:</label><br>
        <input type="text" id="id" name="id"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${booksUsed}" default="" /></p>


<br>
<form action="/Lib_war_exploded/getBooksUsingByUser" method="get">
    <fieldset>
        <legend>Get books using by user:</legend>
        <label for="id2">Enter user id:</label><br>
        <input type="text" id="id2" name="id2"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${booksUsing}" default="" /></p>


<br>
<form action="/Lib_war_exploded/getDebtorsInPast" method="get">
    <fieldset>
        <legend>Get debtors in past:</legend>
        <label for="t1">Enter max possible term of using a book:</label><br>
        <input type="text" id="t1" name="t1"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${pastDebtors}" default="" /></p>




<br>
<form action="/Lib_war_exploded/getPeriodOfLibraryUsing" method="get">
    <fieldset>
        <legend>Get period of library using bu this user:</legend>
        <label for="id3">Enter user id:</label><br>
        <input type="text" id="id3" name="id3"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${usingPeriod}" default="" /></p>




<br>
<form action="/Lib_war_exploded/getTodayDebtors" method="get">
    <fieldset>
        <legend>Get today debtors:</legend>
        <label for="t2">Enter max possible term of using a book:</label><br>
        <input type="text" id="t2" name="t2"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${todaysDebtors}" default="" /></p>



<br>
<form action="/Lib_war_exploded/getUserAverageAge" method="get">
    <fieldset>
        <legend>Get average age among all users:</legend>
                <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${avAgeAll}" default="" /></p>



<br>
<form action="/Lib_war_exploded/getUserAverageAgeByAuthor" method="get">
    <fieldset>
        <legend>Get average age among users that read books of this author:</legend>
        <label for="aan">Enter author name:</label><br>
        <input type="text" id="aan" name="aan"><br>

        <label for="aas">Enter author surname:</label><br>
        <input type="text" id="aas" name="aas"><br>
        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${avgAgeByAuthor}" default="" /></p>



<br>
<form action="/Lib_war_exploded/getUserAverageAgeByBook" method="get">
    <fieldset>
        <legend>Get average age among users that read this book:</legend>
        <label for="aat">Enter book title:</label><br>
        <input type="text" id="aat" name="aat"><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${avgAgeByBook}" default="" /></p>

</body>
</html>
