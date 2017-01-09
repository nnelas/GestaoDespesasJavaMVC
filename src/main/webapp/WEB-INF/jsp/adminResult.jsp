<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <legend><ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/admin">Painel de Administração</a></li>
            <li class="breadcrumb-item active">Informação</li>
        </ol></legend>
        <p>${message}</p>
        <br><br><br>

        <div class="btn-group mr-2" role="group">
            <form action="/admin" method="get"><button type="submit" class="btn btn-secondary">Voltar ao início</button></form>
        </div>
        <div class="btn-group mr-2" role="group">
            <form action="/categoria" method="get"><button type="submit" class="btn btn-secondary">Lista de categorias</button></form>
        </div>
        <div class="btn-group" role="group">
            <form action="/categoria" method="get"><button type="submit" class="btn btn-primary">Adicionar nova categoria</button></form>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>