<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title> Tribbles</title>
</head>
<body>
<div style="text-align: center;">
    <h1> Tribble crud</h1>
    <h2>
        <a href="<%=request.getContextPath()%>/new
">Add new Tribble</a>
        &nbsp;
        <a href="<%=request.getContextPath()%>/list
">List all Tribbles</a>
    </h2>
</div>

<div align="center">
    <table>
        <caption><h2>List of Tribbles</h2></caption>
        <tr>
            <th>ID</th>
            <th>Weight</th>
            <th>Height</th>
            <th>Name</th>
        </tr>
        <c:forEach var = "tribble" items="${listTribble}">
            <tr>
                <td><c:out value="${tribble.id}" /></td>
                <td><c:out value="${tribble.weight}" /></td>
                <td><c:out value="${tribble.height}" /></td>
                <td><c:out value="${tribble.name}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${tribble.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${tribble.id}' />">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>


</div>


</body>



</html>