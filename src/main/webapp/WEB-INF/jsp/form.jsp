<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <legend>Registar despesas</legend>
        <form:form method="POST" modelAttribute="despesaForm" action="/form">
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

            <form:label path="descricao">Descrição: *</form:label><br/><input onblur="textCounter(this.form.recipients,this,160);" disabled  onfocus="this.blur();" tabindex="999" maxlength="3" size="3" value="160" name="counter"><small> Caracteres restantes</small>
            <form:input type="text" name="message" path="descricao" label="Descricao" style="width:100%" placeholder="Pequena descrição da despesa (até 160 caracteres)" onblur="textCounter(this,this.form.counter,160);" onkeyup="textCounter(this,this.form.counter,160);"/><br/>
            <form:errors path="descricao" cssClass="error"/><br/>

            <form:label path="valor">Valor (em €): *</form:label><br/>
            <form:input path="valor" label="Valor" style="width:100%" placeholder="Valor da despesa incluindo cêntimos (ex: 30.25 euros)"/><br/>
            <form:errors path="valor" cssClass="error"/><br/>

            <form:label path="localizacao">Localização: (opcional)</form:label><br/>
            <form:input type="text" path="localizacao" style="width:100%" label="Localizacao" placeholder="Local onde foi realizada a despesa (ex: Restaurante Portugália na Av. Almirante de Reis)"/><br/><br/>
            <br/>
            <table>
                <tr>
                    <td><a href="/"><input type="button" value="Voltar" /></a></td>
                    <td><input type="reset" name="Repor" /></td>
                    <td><input type="submit" name="Gravar" /></td>
                </tr>
            </table>
            <br><br>
            <div align="right">
                * campos obrigatórios.
            </div>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>

