<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Lista de despesas</title>
</head>
<body>
<fieldset>
    <legend>Lista de despesas</legend>

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
                            <td><a href="/info/${despesa.id}">Ver detalhe</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
        <c:otherwise>
            <p>Não tem despesas.</p>
        </c:otherwise>
    </c:choose>

    <br><br>

    <table>
        <tr>
            <td><form action="/form" method="get">
                <input type="submit" value="Inserir nova despesa" /></form></td>
            <td><form action="/home.jsp" method="get">
                <input type="submit" value="Voltar ao início" /></form></td>
        </tr>
    </table>
</fieldset>
</body>
</html>

