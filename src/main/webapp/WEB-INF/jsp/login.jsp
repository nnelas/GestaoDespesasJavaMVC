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
            <table>
                <tr>
                    <td><label for="username">Nome de utilizador:</label></td>
                    <td><input type="text" id="username" name="username"/><br/></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input type="password" id="password" name="password"><br/></td>
                </tr>
            </table>
            <br>

            <div class="btn-toolbar" role="toolbar" align="center">
                <div class="btn-group" role="group">
                    <button type="submit" class="btn btn-primary">Entrar</button>
                </div>
            </div>

            <br><br>

        </form>

        <p>Despesas, Fase 2</p>
        <p>Projecto prático de Engenharia de Software</p>
        <p>Grupo 5</p>

        <br><br>
        <div align="right">
            <p>Jorge Loureiro, nº 21501465</p>
            <p>Nuno Coelho, nº 21502276</p>
            <p>Nuno Nelas, nº 21502312</p>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>