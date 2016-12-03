<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Lista de despesas</title>
</head>
<body>
<br>
<div class="container">
<fieldset>
    <legend>Lista de despesas</legend>

    <c:choose>
        <c:when test="${not empty despesas}">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th>Categoria</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="despesa" items="${despesas}">
                            <tr>
                                <td>${despesa.data}</td>
                                <td>${despesa.categoria}</td>
                                <td>${despesa.valor}€</td>
                                <td><a href="/info/${despesa.id}">Ver detalhe</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
        <c:otherwise>
            <p>Não tem despesas.</p>
        </c:otherwise>
    </c:choose>

    <br><br>

    <table>
        <tr>
            <td><form action="/" method="get">
                <input type="submit" value="Voltar" /></form></td>
            <td><form action="/form" method="get">
                <input type="submit" value="Inserir nova despesa" /></form></td>
        </tr>
    </table>
</fieldset>
</div>
</body>
</html>

