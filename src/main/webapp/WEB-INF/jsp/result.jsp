<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title></title>
</head>
<body>
<br>
<div class="container">
<fieldset style="width: 80%">
    <legend>Informação</legend>
    <p>${message}</p>
    <br><br><br>
    <table>
        <tr>
            <td><form action="/" method="get">
                <input type="submit" value="Voltar ao início" /></form></td>
            <td><form action="/list" method="get">
                <input type="submit" value="Lista de despesas" /></form></td>
            <td><form action="/form" method="get">
                <input type="submit" value="Adicionar nova despesa" /></form></td>
        </tr>
    </table>
</fieldset>
</div>
</body>
</html>
