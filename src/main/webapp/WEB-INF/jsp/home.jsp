<%--
  Created by IntelliJ IDEA.
  User: nunonelas
  Date: 01/12/16
  Time: 00:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Despesas</title>
</head>
<body>
<br>
<div class="container">
    <fieldset>
        <legend>Página de Entrada</legend>

        <form action="/form" method="get"><input type="submit" value="Registar despesas" /></form><br>

        <form action="/list" method="get"><input type="submit" value="Consultar despesas" /></form><br>

        <form action="/mapa" method="get"><input type="submit" value="Mapa mensal de despesas" /></form><br><br>

        <br><br><br><br>

        <p>Despesas, Fase 1</p>
        <p>Projecto prático de Engenharia de Software</p>
        <p>Grupo 5</p>

        <br><br>
        <div align="right">
        <p>Jorge Loureiro, nº 21501465</p>
        <p>Nuno Coelho, nº 21502276</p>
        <p>Nuno Nelas, nº 21502312</p>
        </div>
    </fieldset>
</div>
</body>
</html>
