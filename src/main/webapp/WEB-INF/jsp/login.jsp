<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>

<form action="<c:url value='/login' />" method="post">

    <c:if test="${param.error != null}"><div>Erro na autenticação</div><br/></c:if>
    <c:if test="${param.logout != null}"><div>Logout com sucesso</div><br/></c:if>

    <label for="username">User:</label>
    <input type="text" id="username" name="username"/><br/>


    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br/>

    <div>
        <input name="submit" type="submit"/>
    </div>
</form>

</body>
</html>

