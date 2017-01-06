<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <legend>Login</legend>

        <form action="<c:url value='/login' />" method="post">
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
            <div>
                <input name="submit" type="submit"/>
            </div>
            <br><br>
            <c:if test="${param.error != null}"><div>Erro na autenticação</div><br/></c:if>
            <c:if test="${param.logout != null}"><div>Logout com sucesso</div><br/></c:if>
        </form>
    </tiles:putAttribute>
</tiles:insertDefinition>