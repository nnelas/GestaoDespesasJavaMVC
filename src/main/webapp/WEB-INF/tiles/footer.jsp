<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="footer" align="center">
    <br><br>
    <security:authorize access="isAuthenticated()">
        <p>Bem-vindo <b><security:authentication property="principal.username"/></b>, <br><a href="/logout">Terminar sessão</a><br><security:authorize access="hasRole('ROLE_ADMIN')"><a href="/admin">Painel de administração</a></security:authorize></p>
    </security:authorize>

    <security:authorize access="!isAuthenticated()">
        <p>Projecto Prático de Engenharia de Software | Grupo 5 <br>Jorge Loureiro (21501465) | Nuno Coelho (21502276) | Nuno Nelas (21502312)</p>
    </security:authorize>
</div>