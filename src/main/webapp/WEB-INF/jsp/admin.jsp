<%--
  Created by IntelliJ IDEA.
  User: nunonelas
  Date: 08/01/17
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <legend><ol class="breadcrumb">
            <li class="breadcrumb-item active">Painel de Administração</li>
        </ol></legend>

        <form action="/categoria" method="get"><button type="submit" class="btn btn-primary btn-lg btn-block">Customizar categorias</button></form><br>

        <form action="" method="get"><button type="submit" class="btn btn-secondary btn-lg btn-block">Adicionar elementos ao agregado familiar</button></form><br><br><br>

        <form action="/" method="get"><button type="submit" class="btn btn-primary btn-lg btn-block">Voltar à página principal</button></form><br>

        <br>

    </tiles:putAttribute>
</tiles:insertDefinition>