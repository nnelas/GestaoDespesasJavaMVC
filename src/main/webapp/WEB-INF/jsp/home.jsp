<%--
  Created by IntelliJ IDEA.
  User: nunonelas
  Date: 01/12/16
  Time: 00:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <legend><ol class="breadcrumb">
            <li class="breadcrumb-item active">Home</li>
        </ol></legend>

        <form action="/form" method="get"><button type="submit" class="btn btn-primary btn-lg btn-block">Registar despesas</button></form><br>

        <form action="/upload" method="get"><button type="submit" class="btn btn-primary btn-lg btn-block">Carregar uma despesa a partir de um .csv</button></form><br>

        <form action="/list" method="get"><button type="submit" class="btn btn-primary btn-lg btn-block">Consultar despesas</button></form><br>

        <form action="/mapa" method="get"><button type="submit" class="btn btn-primary btn-lg btn-block">Mapa mensal de despesas</button></form><br>

        <form action="/agregado" method="get"><button type="submit" class="btn btn-primary btn-lg btn-block">Adicionar elementos ao agregado familiar</button></form><br>

        <form action="" method="get"><button type="submit" class="btn btn-secondary btn-lg btn-block">Mapa mensal de despesas do agregado familiar</button></form><br>

        <br>

    </tiles:putAttribute>
</tiles:insertDefinition>