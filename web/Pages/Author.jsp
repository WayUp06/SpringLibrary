<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.03.2020
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author</title>
</head>
<body>
<h2>This is page about authors</h2>
<br>
<form action="/Lib_war_exploded/GetBooksOfAuthor" method="get">
    <fieldset>
        <legend>Get books of author:</legend>
        <label for="author_name">First name:</label><br>
        <input type="text" id="author_name" name="author_name"><br>

        <label for="author_surname">Last name:</label><br>
        <input type="text" id="author_surname" name="author_surname"><br><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${books_of_author}" default="" /></p>


<form action = "/Lib_war_exploded/GetBooksOfCoauthor" method = "get">
    <fieldset>
        <legend>Get books of this author as coauthor</legend>
        <label for="coauthor_name">First name</label><br>
        <input type="text" id="coauthor_name" name="coauthor_name"><br>

        <label for="coauthor_surname">Last name</label><br>
        <input type="text" id="coauthor_surname" name="coauthor_surname"><br>
        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${books_of_coauthor}" default="" /></p>



<br>
</body>
</html>
