<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
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
    </tiles:putAttribute>
</tiles:insertDefinition>

