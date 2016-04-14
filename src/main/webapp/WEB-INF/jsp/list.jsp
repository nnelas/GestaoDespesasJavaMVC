<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Lista de utilizadores</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty utilizadores}">
    <table border="1">
        <tr>
            <th>id</th>
            <th>nome</th>
            <th>morada</th>
        </tr>
        <c:forEach var="utilizador" items="${utilizadores}">
            <tr>
                <td>${utilizador.id}</td>
                <td>${utilizador.name}</td>
                <td>${utilizador.address}</td>
                <td><a href="/info/${utilizador.id}">Mais info</a></td>
            </tr>
        </c:forEach>
    </table>
    </c:when>
    <c:otherwise>
        <p>Não tem resultados</p>
    </c:otherwise>
</c:choose>
<p>
  <a href="/form">Inserir novo utilizador</a>
</p>
</body>
</html>

