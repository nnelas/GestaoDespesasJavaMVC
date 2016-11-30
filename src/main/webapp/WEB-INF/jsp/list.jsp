<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Lista de despesas</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty despesas}">
    <table border="1">
        <tr>
            <th>Data</th>
            <th>Categoria</th>
            <th>Valor</th>
        </tr>
        <c:forEach var="despesa" items="${despesas}">
            <tr>
                <td>${despesa.data}</td>
                <td>${despesa.categoria}</td>
                <td>${despesa.valor}</td>
                <td><a href="/info/${despesa.id}">Mais info</a></td>
            </tr>
        </c:forEach>
    </table>
    </c:when>
    <c:otherwise>
        <p>Não tem resultados</p>
    </c:otherwise>
</c:choose>
<p>
  <a href="/form">Inserir nova despesa</a>
</p>
</body>
</html>

