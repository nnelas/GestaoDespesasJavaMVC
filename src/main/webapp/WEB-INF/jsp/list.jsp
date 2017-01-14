<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <legend><ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Home</a></li>
            <li class="breadcrumb-item active">Lista de Despesas</li>
        </ol></legend>

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
                <p>Ainda não tem despesas.</p>
            </c:otherwise>
        </c:choose>

        <br><br>

        <div class="btn-toolbar" role="toolbar" align="center">
            <div class="btn-group mr-2" role="group">
                <form action="/" method="get"><button type="submit" class="btn btn-secondary">Voltar</button></form>
            </div>
            <div class="btn-group" role="group">
                <form action="/form" method="get"><button type="submit" class="btn btn-primary">Inserir nova despesa</button></form>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>

