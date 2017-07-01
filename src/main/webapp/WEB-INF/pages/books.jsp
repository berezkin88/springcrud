<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 02/07/2017
  Time: 00:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<a href="/">Back to main menu</a>

<br/>
<br/>
<h1>Book list</h1>

<c:if test="${!empty listBooks}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Author</th>
            <th width="120">Price</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.bookTitle}</td>
                <td>${book.bookAuthor}</td>
                <td>${book.price/100}.${book.price%100}</td>
                <td><a href="<c:url value="/edit/${book.id}"/>">Edit</a></td>
                <td><a href="<c:url value="/remove/${book.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</c:if>

<h1>Add a Book</h1>

<c:url var="addAction" value="/books/add">


</c:url>

</body>
</html>
