<%--
  Created by IntelliJ IDEA.
  User: nunonelas
  Date: 08/01/17
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <legend>HTTP 403 - Acesso negado</legend>

        <p>Lamentamos mas não tem permissões para aceder a esta página.</p>
        <br><br><br>

        <div class="btn-toolbar" role="toolbar" align="center">
            <div class="btn-group" role="group">
                <form action="/" method="get"><button type="submit" class="btn btn-primary">Voltar ao início</button></form>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>