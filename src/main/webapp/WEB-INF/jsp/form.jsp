﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Despesas</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
    <script type="text/javascript">
        function show() { document.getElementById('outros').style.display = 'block'; }
        function hide() { document.getElementById('outros').style.display = 'none'; }
    </script>
</head>
<body>
    <form:form method="POST" modelAttribute="despesaForm" action="/form">
    <fieldset>
        <legend>Registar despesas</legend>

        <form:hidden path="id"/>

        <table>
            <tr>
                <td></td>
                <td><input type="radio" name="categoria" value="Transportes" onclick="hide();"/> Transportes</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="radio" name="categoria" value="Alimentação" onclick="hide();"/> Alimentação</td>
            </tr>
            <tr>
                <td>Categoria: *</td>
                <td><input type="radio" name="categoria" value="Propinas" onclick="hide();"/> Propinas</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="radio" name="categoria" value="Renda" onclick="hide();"/> Renda</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="radio" name="categoria" value="Outros" onclick="show();"/> Outros <input type="text" id="outros" name="categoria" style="display: none;"></td>
            </tr>
        </table>

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
        <table>
            <tr>
                <td><input type="submit" name="Gravar"/></td>
                <td><a href="/home.jsp"><input type="button" value="Voltar" /></a></td>
            </tr>
        </table>
        <br><br>
        <div align="right">
        * campos obrigatórios.
        </div>
    </fieldset>
    </form:form>
</body>
</html>

