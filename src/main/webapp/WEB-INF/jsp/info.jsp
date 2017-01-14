<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <legend><ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Home</a></li>
            <li class="breadcrumb-item"><a href="/list">Lista de Despesas</a></li>
            <li class="breadcrumb-item active">Informação da despesa com o ID: ${despesa.id}</li>
        </ol></legend>

        <dl class="row">
            <dt class="col-sm-3">Utilizador: </dt>
            <dd class="col-sm-9">${despesa.utilizador}</dd><br>

            <dt class="col-sm-3">Categoria: </dt>
            <dd class="col-sm-9">${despesa.categoria}</dd><br>

            <dt class="col-sm-3">Data: </dt>
            <dd class="col-sm-9">${despesa.data}</dd><br>

            <dt class="col-sm-3">Descrição:</dt>
            <dd class="col-sm-9">${despesa.descricao}</dd><br>

            <dt class="col-sm-3">Valor:</dt>
            <dd class="col-sm-9">${despesa.valor}€</dd><br>

            <dt class="col-sm-3">Localização:</dt>
            <dd class="col-sm-9">${despesa.localizacao}</dd>
        </dl>
        <br><br>

        <div class="btn-toolbar" role="toolbar" align="center">
            <div class="btn-group mr-2" role="group">
                <form action="/list" method="get"><button type="submit" class="btn btn-secondary">Voltar</button></form>
            </div>
            <div class="btn-group mr-2" role="group">
                <form action="/edit/${despesa.id}" method="get"><button type="submit" class="btn btn-primary">Editar</button></form>
            </div>
            <div class="btn-group" role="group">
                <form action="/delete/${despesa.id}" method="post"><button type="submit" class="btn btn-danger">Apagar</button></form>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>