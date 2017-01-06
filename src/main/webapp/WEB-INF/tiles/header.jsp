<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="header">
<security:authorize access="isAuthenticated()">
    <p>Hello <security:authentication property="principal.username"/>, <a href="/logout">Logout</a></p>
</security:authorize>

<security:authorize access="!isAuthenticated()">
<p>Not logged in</p>
</security:authorize>

<a href="/list">Listar</a> | <a href="/form">Novo</a></div>

