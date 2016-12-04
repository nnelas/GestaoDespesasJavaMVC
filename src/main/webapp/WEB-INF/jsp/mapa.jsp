<%--
  Created by IntelliJ IDEA.
  User: nunonelas
  Date: 01/12/16
  Time: 02:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Mapa mensal de despesas</title>
</head>
<body>
<br>
<div class="container">
<fieldset>
    <legend>Mapa mensal de despesas</legend>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Mês</th>
                        <th>Transportes</th>
                        <th>Alimentação</th>
                        <th>Propinas</th>
                        <th>Renda</th>
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
                        <td>${janTotal}</td>
                        <td>janVariacao</td>
                    </tr>
                    <tr>
                        <th scope="row">Fevereiro</th>
                        <td>${fevTransportes}</td>
                        <td>${fevAlimentacao}</td>
                        <td>${fevPropinas}</td>
                        <td>${fevRenda}</td>
                        <td>${fevTotal}</td>
                        <td>fevVariacao</td>
                    </tr>
                    <tr>
                        <th scope="row">Março</th>
                        <td>${marTransportes}</td>
                        <td>${marAlimentacao}</td>
                        <td>${marPropinas}</td>
                        <td>${marRenda}</td>
                        <td>${marTotal}</td>
                        <td>marVariacao</td>
                    </tr>
                    <tr>
                        <th scope="row">Abril</th>
                        <td>${abrTransportes}</td>
                        <td>${abrAlimentacao}</td>
                        <td>${abrPropinas}</td>
                        <td>${abrRenda}</td>
                        <td>${abrTotal}</td>
                        <td>abrVariacao</td>
                    </tr>
                    <tr>
                        <th scope="row">Maio</th>
                        <td>${maiTransportes}</td>
                        <td>${maiAlimentacao}</td>
                        <td>${maiPropinas}</td>
                        <td>${maiRenda}</td>
                        <td>${maiTotal}</td>
                        <td>maiVariacao</td>
                    </tr>
                    <tr>
                        <th scope="row">Junho</th>
                        <td>${junTransportes}</td>
                        <td>${junAlimentacao}</td>
                        <td>${junPropinas}</td>
                        <td>${junRenda}</td>
                        <td>${junTotal}</td>
                        <td>junVariacao</td>
                    </tr>
                    <tr>
                        <th scope="row">Julho</th>
                        <td>${julTransportes}</td>
                        <td>${julAlimentacao}</td>
                        <td>${julPropinas}</td>
                        <td>${julRenda}</td>
                        <td>${julTotal}</td>
                        <td>julVariacao</td>
                    </tr>
                    <tr>
                        <th scope="row">Agosto</th>
                        <td>${agoTransportes}</td>
                        <td>${agoAlimentacao}</td>
                        <td>${agoPropinas}</td>
                        <td>${agoRenda}</td>
                        <td>${agoTotal}</td>
                        <td>agoVariacao</td>
                    </tr>
                    <tr>
                        <th scope="row">Setembro</th>
                        <td>${setTransportes}</td>
                        <td>${setAlimentacao}</td>
                        <td>${setPropinas}</td>
                        <td>${setRenda}</td>
                        <td>${setTotal}</td>
                        <td>setVariacao</td>
                    </tr>
                    <tr>
                        <th scope="row">Outubro</th>
                        <td>${outTransportes}</td>
                        <td>${outAlimentacao}</td>
                        <td>${outPropinas}</td>
                        <td>${outRenda}</td>
                        <td>${outTotal}</td>
                        <td>outVariacao</td>
                    </tr>
                    <tr>
                        <th scope="row">Novembro</th>
                        <td>${novTransportes}</td>
                        <td>${novAlimentacao}</td>
                        <td>${novPropinas}</td>
                        <td>${novRenda}</td>
                        <td>${novTotal}</td>
                        <td>novVariacao</td>
                    </tr>
                    <tr>
                        <th scope="row">Dezembro</th>
                        <td>${dezTransportes}</td>
                        <td>${dezAlimentacao}</td>
                        <td>${dezPropinas}</td>
                        <td>${dezRenda}</td>
                        <td>${dezTotal}</td>
                        <td>dezVariacao</td>
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
</fieldset>
</div>
</body>
</html>
