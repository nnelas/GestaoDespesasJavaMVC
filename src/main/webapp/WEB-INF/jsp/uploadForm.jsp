<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <legend><ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Home</a></li>
            <li class="breadcrumb-item active">Carregar despesas</li>
        </ol></legend>

        <form:form method="POST" enctype="multipart/form-data" modelAttribute="uploadForm">
            <input type="hidden" name="submitted" value="true">
            <c:if test="${param.submitted && empty param.nome}">
                <div class="alert alert-danger" role="alert">
                    <h4 class="alert-heading">Oh não!</h4>
                    <form:errors path="name" cssClass="error"/>
                </div>
            </c:if>

            <label for="file">Ficheiro .csv para fazer upload</label>
            <input type="file" name="file" id="file" />
            <br/><br/>

            <form:label path="name">Nome do ficheiro:</form:label><br>
            <form:input path="name" label="name" style="width:100%" placeholder="Nome do ficheiro até 10 caracteres (ex: d20161209)"/>
            <br/><br/>

            <br>

            <div class="btn-toolbar" role="toolbar">
                <div class="btn-group mr-2" role="group">
                    <a href="/"><button type="button" class="btn btn-secondary">Voltar</button></a>
                </div>
                <div class="btn-group mr-2" role="group">
                    <button type="reset" class="btn btn-warning">Repor</button>
                </div>
                <div class="btn-group" role="group">
                    <button type="submit" class="btn btn-primary">Upload</button>
                </div>
            </div>

        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>
