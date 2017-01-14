<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <legend><ol class="breadcrumb">
            <li class="breadcrumb-item active">Bem-vindo(a)!</li>
        </ol></legend>

        <form action="<c:url value='/login' />" method="post">
            <c:if test="${param.error != null}"><div class="alert alert-danger" role="alert">
                <strong>Oh não!</strong> Erro na autenticação.</div><br/></c:if>


            <c:if test="${param.logout != null}"><div class="alert alert-success" role="alert">
                <strong>Boa!</strong> Logout feito com sucesso.</div><br/></c:if>
            <dl class="row">
                <dt class="col-sm-3"><label for="username">Nome de utilizador:</label></dt>
                <dd class="col-sm-9"><input type="text" id="username" name="username"/></dd>

                <dt class="col-sm-3"><label for="password">Password:</label></dt>
                <dd class="col-sm-9"><input type="password" id="password" name="password"></dd>
            </dl>
            <br>

            <div class="btn-toolbar" role="toolbar" align="center">
                <div class="btn-group" role="group">
                    <button type="submit" class="btn btn-primary">Entrar</button>
                </div>
            </div>

            <br><br>

        </form>
        <br><br><br><br><br><br><br><br><br><br><br><br>
    </tiles:putAttribute>
</tiles:insertDefinition>