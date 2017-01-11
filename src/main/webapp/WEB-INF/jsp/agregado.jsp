<%--
  Created by IntelliJ IDEA.
  User: nunonelas
  Date: 10/01/17
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <legend><ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/admin">Painel de Administração</a></li>
            <li class="breadcrumb-item active">Agregado Familiar</li>
        </ol></legend>

        <c:choose>
            <c:when test="${not empty agregados}">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Agregado</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="agregado" items="${agregados}">
                        <tr>
                            <td>${agregado.agregado1}</td>
                            <td>${agregado.agregado2}</td>
                            <td><form action="/agregadoEdit/${agregado.id}" method="get"><button type="submit" class="btn btn-primary btn-sm">Editar</button></form></td>
                            <td><form action="/agregadoDelete/${agregado.id}" method="post"><button type="submit" class="btn btn-danger btn-sm">Apagar</button></form></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>Não tem agregados adicionados.</p>
            </c:otherwise>
        </c:choose>

        <form:form method="POST" modelAttribute="agregadoForm" action="/agregado">
            <form:hidden path="id"/>
            <form:label path="agregado1">Nome do utilizador1 a adicionar: *</form:label><br/>
            <form:input path="agregado1" label="Agregado1" style="width:100%" placeholder="Nome do primeiro utilizador a adicionar ao agregado (ex: user1)"/><br/>
            <form:errors path="agregado1" cssClass="error"/><br/>

            <form:label path="agregado2">Nome do utilizador2 a adicionar: *</form:label><br/>
            <form:input path="agregado2" label="Agregado2" style="width:100%" placeholder="Nome do segundo utilizador a adicionar ao agregado (ex: user2)"/><br/>
            <form:errors path="agregado2" cssClass="error"/><br/>

            <div class="btn-toolbar" role="toolbar" align="center">
                <div class="btn-group" role="group">
                    <button type="submit" class="btn btn-primary">Adicionar Categoria</button>
                </div>
            </div>

        </form:form>

    </tiles:putAttribute>
</tiles:insertDefinition>