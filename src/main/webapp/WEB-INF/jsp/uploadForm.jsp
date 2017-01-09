<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <form:form method="POST" enctype="multipart/form-data" modelAttribute="uploadForm">

            <legend><ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/">Home</a></li>
                <li class="breadcrumb-item active">Carregar despesas</li>
            </ol></legend>

            <label for="file">Ficheiro .csv para fazer upload</label>
            <input type="file" name="file" id="file" />
            <br/><br/>

            <form:label path="name">Nome</form:label>
            <form:input path="name" label="name" />
            <form:errors path="name" cssClass="error"/><br/>

            <input type="submit" name="Upload"/>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>
