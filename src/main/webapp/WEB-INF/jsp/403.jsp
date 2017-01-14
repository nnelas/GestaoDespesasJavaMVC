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

        <legend><ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Home</a></li>
            <li class="breadcrumb-item active">HTTP 403 - Acesso Negado</li>
        </ol></legend>

        <p>Lamentamos mas não tem permissões para aceder a esta página.</p>
        <br><br><br>

    </tiles:putAttribute>
</tiles:insertDefinition>