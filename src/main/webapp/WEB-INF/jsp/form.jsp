<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Despesas</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>

</head>
<body>
    <form:form method="POST" modelAttribute="despesaForm" action="/form">
    <fieldset>
        <legend>Registar despesas</legend>

        <form:hidden path="id"/>

        Categoria: *<br/>
        <select name="categoria">
            <option value="Transportes">Transportes</option>
            <option value="Alimentação">Alimentação</option>
            <option value="Propinas">Propinas</option>
            <option value="Renda">Renda</option>
        </select><br/><br/>

        <form:label path="data">Data: *</form:label><br/>
        <form:input type="date" path="data" label="Data" /><br/>
        <form:errors path="data" cssClass="error"/><br/>

        <form:label path="descricao">Descrição: *</form:label><br/>
        <form:input type="text" path="descricao" label="Descricao" /><br/>
        <form:errors path="descricao" cssClass="error"/>
        <br/>

        <form:label path="valor">Valor: *</form:label><br/>
        <form:input path="valor" label="Valor" /><br/>
        <form:errors path="valor" cssClass="error"/><br/>

        <form:label path="localizacao">Localização: </form:label><br/>
        <form:input type="text" path="localizacao" label="Localizacao" /><br/><br/>
        <br/>
        <input type="submit" name="Gravar"/>
        <br><br>
        * campos obrigatórios.
    </fieldset>
    </form:form>
</body>
</html>

