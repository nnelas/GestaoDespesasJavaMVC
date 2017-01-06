<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="footer" align="center">
    <br><br>
    <security:authorize access="isAuthenticated()">
        <p>Bem-vindo <b><security:authentication property="principal.username"/></b>, <br><a href="/logout">Sair</a></p>
    </security:authorize>
</div>