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
        <label for="authorName">First name:</label><br>
        <input type="text" id="authorName" name="authorName"><br>

        <label for="authorSurname">Last name:</label><br>
        <input type="text" id="authorSurname" name="authorSurname"><br><br>

        <input type="submit" value="Submit">
    </fieldset>
</form>
<p><c:out value="${booksOfAuthor}" default="" /></p>


<form action = "/Lib_war_exploded/GetBooksOfCoauthor" method = "get">
    <fieldset>
        <legend>Get books of this author as coauthor</legend>
        <label for="coauthorName">First name</label><br>
        <input type="text" id="coauthorName" name="coauthorName"><br>

        <label for="coauthorSurname">Last name</label><br>
        <input type="text" id="coauthorSurname" name="coauthorSurname"><br>
        <input type="submit" value="Submit">
    </fieldset>
</form>
<p><c:out value="${booksOfCoauthor}" default="" /></p>



<br>
</body>
</html>
