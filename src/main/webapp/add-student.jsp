<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 20.04.2017
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add student</title>
</head>
<body>
<%=request.getAttribute("is_adding")%>
<form action="/students/add-student" method="post">
    Name<input type="text" name="name" /><br/>
    age<input type="text" name="age" /><br/>
    group_id<input type="text" name="group_id" /><br/>
    id<input type="text" name="id" /><br/>
    <input type="submit" value="add" />
</form>
</body>
</html>
