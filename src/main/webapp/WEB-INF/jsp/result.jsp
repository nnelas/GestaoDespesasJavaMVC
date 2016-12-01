<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<fieldset>
    <legend>Informação</legend>
    <p>${message}</p>
    <br><br><br>
    <table>
        <tr>
            <td><form action="/home.jsp" method="get">
                <input type="submit" value="Voltar ao início" /></form></td>
            <td><form action="/list" method="get">
                <input type="submit" value="Lista de despesas" /></form></td>
            <td><form action="/form" method="get">
                <input type="submit" value="Adicionar nova despesa" /></form></td>
        </tr>
    </table>
</fieldset>
</body>
</html>
