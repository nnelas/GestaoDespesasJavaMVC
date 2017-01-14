﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <legend><ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Home</a></li>
            <li class="breadcrumb-item active">Registar despesas</li>
        </ol></legend>

        <form:form method="POST" modelAttribute="despesaForm" action="/form">
            <input type="hidden" name="submitted" value="true">
            <c:if test="${param.submitted && (empty param.categoria || empty param.data || empty param.descricao || empty param.valor)}">
                <div class="alert alert-danger" role="alert">
                    <h4 class="alert-heading">Oh não!</h4>
                        <form:errors path="categoria" cssClass="error"/><br>
                        <form:errors path="data" cssClass="error"/><br>
                        <form:errors path="descricao" cssClass="error"/><br>
                        <form:errors path="valor" cssClass="error"/>
                </div>
            </c:if>
            <form:hidden path="id"/>
            <table>
                <tr>
                    <td></td>
                    <td><form:radiobutton path="categoria" value="Transportes"/> Transportes</td>
                </tr>
                <tr>
                    <td></td>
                    <td><form:radiobutton path="categoria" value="Alimentação"/> Alimentação</td>
                </tr>
                <tr>
                    <td><form:label path="categoria">Categoria: *</form:label></td>
                    <td><form:radiobutton path="categoria" value="Propinas"/> Propinas</td>
                </tr>
                <tr>
                    <td></td>
                    <td><form:radiobutton path="categoria" value="Renda"/> Renda</td>
                </tr>
                <c:choose>
                    <c:when test="${not empty categorias}">
                        <c:forEach var="categoria" items="${categorias}">
                            <tr>
                                <td></td>
                                <td><form:radiobutton path="categoria" value="${categoria.categoria}"/> ${categoria.categoria}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                </c:choose>
            </table>
            <br/>

            <form:label path="data">Data: *</form:label><br/>
            <form:input type="date" id="date" path="data" label="Data" /> <input type="checkbox" id="checkDate" onclick="dataSistema()"/> utilizar a data de hoje<br/>
            <br/>

            <form:label path="descricao">Descrição: *</form:label><br/><input onblur="textCounter(this.form.recipients,this,160);" disabled  onfocus="this.blur();" tabindex="999" maxlength="3" size="3" value="160" name="counter"><small> Caracteres restantes</small>
            <form:input type="text" name="message" path="descricao" label="Descricao" style="width:100%" placeholder="Pequena descrição da despesa (até 160 caracteres)" onblur="textCounter(this,this.form.counter,160);" onkeyup="textCounter(this,this.form.counter,160);"/><br/>
            <br/>

            <form:label path="valor">Valor (em €): *</form:label><br/>
            <form:input path="valor" label="Valor" style="width:100%" placeholder="Valor da despesa incluindo cêntimos (ex: 30.25 euros)"/><br/>
            <br/>

            <form:label path="localizacao">Localização: (opcional)</form:label><br/>
            <form:input type="text" path="localizacao" style="width:100%" label="Localizacao" placeholder="Local onde foi realizada a despesa (ex: Restaurante Portugália na Av. Almirante de Reis)"/><br/><br/>
            <br/>

            <div class="btn-toolbar" role="toolbar">
                <div class="btn-group mr-2" role="group">
                    <a href="/"><button type="button" class="btn btn-secondary">Voltar</button></a>
                </div>
                <div class="btn-group mr-2" role="group">
                    <button type="reset" class="btn btn-warning">Repor</button>
                </div>
                <div class="btn-group" role="group">
                    <button type="submit" class="btn btn-primary">Gravar</button>
                </div>
            </div>

            <br><br>
            <div align="right">
                * campos obrigatórios.
            </div>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>

