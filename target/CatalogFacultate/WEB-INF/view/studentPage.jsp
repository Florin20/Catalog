<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
Nume: ${student.studentId}<br>
<c:forEach items="${student.grades}" var="element">
    <tr>
        <td>Subject: ${element.subject}</td>
        <td>Grade: ${element.grade}</td>
    </tr>
</c:forEach>

</body>
</html>
