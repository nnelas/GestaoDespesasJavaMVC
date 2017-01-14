<%--
  Created by IntelliJ IDEA.
  User: nunonelas
  Date: 08/01/17
  Time: 22:27
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
            <li class="breadcrumb-item active">Lista de Categorias</li>
        </ol></legend>

        <c:choose>
            <c:when test="${not empty categorias}">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Categorias adicionadas</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="categoria" items="${categorias}">
                        <tr>
                            <td align="center">${categoria.categoria}</td>
                            <td><form action="/categoriaEdit/${categoria.id}" method="get"><button type="submit" class="btn btn-primary btn-sm">Editar</button></form></td>
                            <td><form action="/categoriaDelete/${categoria.id}" method="post"><button type="submit" class="btn btn-danger btn-sm">Apagar</button></form></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>Não tem categorias adicionadas.</p>
            </c:otherwise>
        </c:choose>

        <form:form method="POST" modelAttribute="categoriaForm" action="/categoria">
            <form:hidden path="id"/>
            <input type="hidden" name="submitted" value="true">
            <c:if test="${param.submitted && empty param.categoria}">
                <div class="alert alert-danger" role="alert">
                    <h4 class="alert-heading">Oh não!</h4>
                    <form:errors path="categoria" cssClass="error"/>
                </div>
            </c:if>
            <form:label path="categoria">Nome da categoria a adicionar: *</form:label><br/>
            <form:input path="categoria" label="Categoria" style="width:100%" placeholder="Nome da categoria a adicionar (ex: Lazer)"/><br/>
            <br/>

            <div class="btn-toolbar" role="toolbar" align="center">
                <div class="btn-group" role="group">
                    <button type="submit" class="btn btn-primary">Adicionar Categoria</button>
                </div>
            </div>

        </form:form>

    </tiles:putAttribute>
</tiles:insertDefinition>