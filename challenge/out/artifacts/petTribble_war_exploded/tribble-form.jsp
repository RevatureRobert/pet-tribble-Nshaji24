<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tribble Form</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Tribble Management</h1>
    <h2>
        <a href="/new">Add New Tribble</a>
        &nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/list
">List All Tribbles</a>

    </h2>
</div>
<div align="center">
    <c:if test="${tribble != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${tribble == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${tribble != null}">
                            Edit Tribble
                        </c:if>
                        <c:if test="${tribble == null}">
                            Add New Tribble
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${tribble != null}">
                    <input type="hidden" name="id" value="<c:out value='${tribble.id}' />" />
                </c:if>
                <tr>
                    <th>Weight: </th>
                    <td>
                        <input type="text" name="weight" size="45"
                               value="<c:out value='${tribble.weight}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Height: </th>
                    <td>
                        <input type="text" name="height" size="45"
                               value="<c:out value='${tribble.height}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="5"
                               value="<c:out value='${tribble.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>