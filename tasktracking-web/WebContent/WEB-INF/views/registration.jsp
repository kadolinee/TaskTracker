<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h3>Registration</h3>
<form:form method="POST" action="/registration" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="mail">Mail</form:label></td>
            <td><form:input path="mail"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td>
                <ul>
                    <form:select path="roleId">
                        <form:option value="1">Developer</form:option>
                        <form:option value="2">Manager</form:option>
                    </form:select>
                </ul>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>