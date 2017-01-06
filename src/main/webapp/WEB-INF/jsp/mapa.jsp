<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <legend>Mapa mensal de despesas</legend>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Mês</th>
                <th>Transportes</th>
                <th>Alimentação</th>
                <th>Propinas</th>
                <th>Renda</th>
                <th>Outra</th>
                <th>Total</th>
                <th>Variação</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">Janeiro</th>
                <td>${janTransportes}</td>
                <td>${janAlimentacao}</td>
                <td>${janPropinas}</td>
                <td>${janRenda}</td>
                <td>${janOutro}</td>
                <td>${janTotal}</td>
                <td> - </td>
            </tr>
            <tr>
                <th scope="row">Fevereiro</th>
                <td>${fevTransportes}</td>
                <td>${fevAlimentacao}</td>
                <td>${fevPropinas}</td>
                <td>${fevRenda}</td>
                <td>${fevOutro}</td>
                <td>${fevTotal}</td>
                <td>${fevVariacao}%</td>
            </tr>
            <tr>
                <th scope="row">Março</th>
                <td>${marTransportes}</td>
                <td>${marAlimentacao}</td>
                <td>${marPropinas}</td>
                <td>${marRenda}</td>
                <td>${marOutro}</td>
                <td>${marTotal}</td>
                <td>${marVariacao}%</td>
            </tr>
            <tr>
                <th scope="row">Abril</th>
                <td>${abrTransportes}</td>
                <td>${abrAlimentacao}</td>
                <td>${abrPropinas}</td>
                <td>${abrRenda}</td>
                <td>${abrOutro}</td>
                <td>${abrTotal}</td>
                <td>${abrVariacao}%</td>
            </tr>
            <tr>
                <th scope="row">Maio</th>
                <td>${maiTransportes}</td>
                <td>${maiAlimentacao}</td>
                <td>${maiPropinas}</td>
                <td>${maiRenda}</td>
                <td>${maiOutro}</td>
                <td>${maiTotal}</td>
                <td>${maiVariacao}%</td>
            </tr>
            <tr>
                <th scope="row">Junho</th>
                <td>${junTransportes}</td>
                <td>${junAlimentacao}</td>
                <td>${junPropinas}</td>
                <td>${junRenda}</td>
                <td>${junOutro}</td>
                <td>${junTotal}</td>
                <td>${junVariacao}%</td>
            </tr>
            <tr>
                <th scope="row">Julho</th>
                <td>${julTransportes}</td>
                <td>${julAlimentacao}</td>
                <td>${julPropinas}</td>
                <td>${julRenda}</td>
                <td>${julOutro}</td>
                <td>${julTotal}</td>
                <td>${julVariacao}%</td>
            </tr>
            <tr>
                <th scope="row">Agosto</th>
                <td>${agoTransportes}</td>
                <td>${agoAlimentacao}</td>
                <td>${agoPropinas}</td>
                <td>${agoRenda}</td>
                <td>${agoOutro}</td>
                <td>${agoTotal}</td>
                <td>${agoVariacao}%</td>
            </tr>
            <tr>
                <th scope="row">Setembro</th>
                <td>${setTransportes}</td>
                <td>${setAlimentacao}</td>
                <td>${setPropinas}</td>
                <td>${setRenda}</td>
                <td>${setOutro}</td>
                <td>${setTotal}</td>
                <td>${setVariacao}%</td>
            </tr>
            <tr>
                <th scope="row">Outubro</th>
                <td>${outTransportes}</td>
                <td>${outAlimentacao}</td>
                <td>${outPropinas}</td>
                <td>${outRenda}</td>
                <td>${outOutro}</td>
                <td>${outTotal}</td>
                <td>${outVariacao}%</td>
            </tr>
            <tr>
                <th scope="row">Novembro</th>
                <td>${novTransportes}</td>
                <td>${novAlimentacao}</td>
                <td>${novPropinas}</td>
                <td>${novRenda}</td>
                <td>${novOutro}</td>
                <td>${novTotal}</td>
                <td>${novVariacao}%</td>
            </tr>
            <tr>
                <th scope="row">Dezembro</th>
                <td>${dezTransportes}</td>
                <td>${dezAlimentacao}</td>
                <td>${dezPropinas}</td>
                <td>${dezRenda}</td>
                <td>${dezOutro}</td>
                <td>${dezTotal}</td>
                <td>${dezVariacao}%</td>
            </tr>
            <tr>
                <th scope="row">Total</th>
                <td>${totalTransportes}</td>
                <td>${totalAlimentacao}</td>
                <td>${totalPropinas}</td>
                <td>${totalRenda}</td>
                <td>${totalOutro}</td>
                <td>${totalTotal}</td>
                <td> - </td>
            </tr>
            </tbody>
        </table>
        <br><br>

        <table>
            <tr>
                <td><form action="/" method="get">
                    <input type="submit" value="Voltar" /></form></td>
                <td><form action="/form" method="get">
                    <input type="submit" value="Inserir nova despesa" /></form></td>
            </tr>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>