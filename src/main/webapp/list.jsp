<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 19.04.2017
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <h1>LIST STUDENTS</h1>
    <h2>
        <% String message = (String) request.getAttribute("studentHello"); %>
        <%=request.getAttribute("studentHello")%>
        <br/>
        <%=message%>
    </h2>

    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>group_id</th>
            <th>age</th>
        </tr>
        <c:forEach items="${requestScope.studentList}" var="student">
            <tr>
                <td><c:out value="${student.id}"></c:out></td>
                <td><c:out value="${student.name}"></c:out></td>
                <td><c:out value="${student.group_id}"></c:out></td>
                <td><c:out value="${student.age}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
