﻿
﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Despesas</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
    <script type="text/javascript">
        function show() { document.getElementById('outra').style.display = 'block'; }
        function hide() { document.getElementById('outra').style.display = 'none'; }

        function dataSistema() {
            if (document.getElementById('checkDate').checked) {
                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth() + 1;
                var yyyy = today.getFullYear();

                if (dd < 10) {
                    dd = '0' + dd
                }

                if (mm < 10) {
                    mm = '0' + mm
                }

                today = yyyy + '-' + mm + '-' + dd;
                document.getElementById('date').value = today;
            } else {
                document.getElementById('date').value = "";
            }
        }
    </script>
</head>
<body>
<div class="container">
<form:form method="POST" modelAttribute="despesaForm" action="/form">
    <fieldset>
        <legend>Registar despesas</legend>
        <table>
            <tr>
                <td></td>
                <td><form:radiobutton path="categoria" value="Transportes" onclick="hide()"/> Transportes</td>
            </tr>
            <tr>
                <td></td>
                <td><form:radiobutton path="categoria" value="Alimentação" onclick="hide()"/> Alimentação</td>
            </tr>
            <tr>
                <td>Categoria: *</td>
                <td><form:radiobutton path="categoria" value="Propinas" onclick="hide()"/> Propinas</td>
            </tr>
            <tr>
                <td></td>
                <td><form:radiobutton path="categoria" value="Renda" onclick="hide()"/> Renda</td>
            </tr>
            <tr>
                <td></td>
                <td><form:radiobutton path="categoria" value="" onclick="show()"/> Outra <form:input path="categoria" id="outra" style="display: none;"/></td>
            </tr>
        </table>
        <form:errors path="categoria" cssClass="error"/><br/>

        <form:label path="data">Data: *</form:label><br/>
        <form:input type="date" id="date" path="data" label="Data" /> <input type="checkbox" id="checkDate" onclick="dataSistema()"/> utilizar data do sistema<br/>
        <form:errors path="data" cssClass="error"/><br/>

        <form:label path="descricao">Descrição: *</form:label><br/>
        <form:input type="text" path="descricao" label="Descricao" style="width:100%" placeholder="Pequena descrição da despesa (até 160 caracteres)"/><br/>
        <form:errors path="descricao" cssClass="error"/><br/>

        <form:label path="valor">Valor (em €): *</form:label><br/>
        <form:input path="valor" label="Valor" style="width:100%" placeholder="Valor da despesa incluindo cêntimos (ex: 30.25 euros)"/><br/>
        <form:errors path="valor" cssClass="error"/><br/>

        <form:label path="localizacao">Localização: (opcional)</form:label><br/>
        <form:input type="text" path="localizacao" style="width:100%" label="Localizacao" placeholder="Local onde foi realizada a despesa (ex: Restaurante Portugália na Av. Almirante de Reis)"/><br/><br/>
        <br/>
        <table>
            <tr>
                <td><a href="/home.jsp"><input type="button" value="Voltar" /></a></td>
                <td><input type="reset" name="Repor" /></td>
                <td><input type="submit" name="Gravar" /></td>
            </tr>
        </table>
        <br><br>
        <div align="right">
            * campos obrigatórios.
        </div>
    </fieldset>
</form:form>
</div>
</body>
</html>

