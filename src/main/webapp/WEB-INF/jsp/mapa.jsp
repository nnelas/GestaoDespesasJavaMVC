<%--
  Created by IntelliJ IDEA.
  User: nunonelas
  Date: 01/12/16
  Time: 02:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Mapa mensal de despesas</title>
</head>
<body>
<br>
<div class="container">
<fieldset>
    <legend>Mapa mensal de despesas</legend>

    <c:choose>
        <c:when test="${not empty despesasMapa}">
            <table border="1">
                <tr>
                    <th>Mês</th>
                    <th>Transportes</th>
                    <th>Alimentação</th>
                    <th>Propinas</th>
                    <th>Renda</th>
                    <th>Total</th>
                    <th>Variação</th>
                </tr>
                <c:forEach var="despesasMapa" items="${despesasMapa}">
                    <tr>
                        <td>${despesa.data}</td>
                        <td>${despesa.categoria}</td>
                        <td>${despesa.categoria}</td>
                        <td>${despesa.categoria}</td>
                        <td>${despesa.categoria}</td>
                        <td>${despesa.valor}</td>
                        <td>${despesa.valor}</td>

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
            <td><form action="/home.jsp" method="get">
                <input type="submit" value="Voltar" /></form></td>
            <td><form action="/form" method="get">
                <input type="submit" value="Inserir nova despesa" /></form></td>
        </tr>
    </table>
</fieldset>
</div>
</body>
</html>
