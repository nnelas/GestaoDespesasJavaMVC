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
                        <td>janeiro.transportes</td>
                        <td>janeiro.alimentação</td>
                        <td>janeiro.propinas</td>
                        <td>janeiro.renda</td>
                        <td>janeiro.total</td>
                        <td>janeiro.variação</td>
                    </tr>
                    <tr>
                        <th scope="row">Fevereiro</th>
                        <td>fevereiro.transportes</td>
                        <td>fevereiro.alimentação</td>
                        <td>fevereiro.propinas</td>
                        <td>fevereiro.renda</td>
                        <td>fevereiro.total</td>
                        <td>fevereiro.variação</td>
                    </tr>
                    <tr>
                        <th scope="row">Março</th>
                        <td>março.transportes</td>
                        <td>março.alimentação</td>
                        <td>março.propinas</td>
                        <td>março.renda</td>
                        <td>março.total</td>
                        <td>março.variação</td>
                    </tr>
                    <tr>
                        <th scope="row">Abril</th>
                        <td>abril.transportes</td>
                        <td>abril.alimentação</td>
                        <td>abril.propinas</td>
                        <td>abril.renda</td>
                        <td>abril.total</td>
                        <td>abril.variação</td>
                    </tr>
                    <tr>
                        <th scope="row">Maio</th>
                        <td>maio.transportes</td>
                        <td>maio.alimentação</td>
                        <td>maio.propinas</td>
                        <td>maio.renda</td>
                        <td>maio.total</td>
                        <td>maio.variação</td>
                    </tr>
                    <tr>
                        <th scope="row">Junho</th>
                        <td>junho.transportes</td>
                        <td>junho.alimentação</td>
                        <td>junho.propinas</td>
                        <td>junho.renda</td>
                        <td>junho.total</td>
                        <td>junho.variação</td>
                    </tr>
                    <tr>
                        <th scope="row">Julho</th>
                        <td>julho.transportes</td>
                        <td>julho.alimentação</td>
                        <td>julho.propinas</td>
                        <td>julho.renda</td>
                        <td>julho.total</td>
                        <td>julho.variação</td>
                    </tr>
                    <tr>
                        <th scope="row">Agosto</th>
                        <td>agosto.transportes</td>
                        <td>agosto.alimentação</td>
                        <td>agosto.propinas</td>
                        <td>agosto.renda</td>
                        <td>agosto.total</td>
                        <td>agosto.variação</td>
                    </tr>
                    <tr>
                        <th scope="row">Setembro</th>
                        <td>setembro.transportes</td>
                        <td>setembro.alimentação</td>
                        <td>setembro.propinas</td>
                        <td>setembro.renda</td>
                        <td>setembro.total</td>
                        <td>setembro.variação</td>
                    </tr>
                    <tr>
                        <th scope="row">Outubro</th>
                        <td>outubro.transportes</td>
                        <td>outubro.alimentação</td>
                        <td>outubro.propinas</td>
                        <td>outubro.renda</td>
                        <td>outubro.total</td>
                        <td>outubro.variação</td>
                    </tr>
                    <tr>
                        <th scope="row">Novembro</th>
                        <td>novembro.transportes</td>
                        <td>novembro.alimentação</td>
                        <td>novembro.propinas</td>
                        <td>novembro.renda</td>
                        <td>novembro.total</td>
                        <td>novembro.variação</td>
                    </tr>
                    <tr>
                        <th scope="row">Dezembro</th>
                        <td>dezembro.transportes</td>
                        <td>dezembro.alimentação</td>
                        <td>dezembro.propinas</td>
                        <td>dezembro.renda</td>
                        <td>dezembro.total</td>
                        <td>dezembro.variação</td>
                    </tr>
                </tbody>
            </table>
    <br><br>

    <table>
        <tr>
            <td><form action="/home.jsp" method="get">
                <input type="submit" value="Voltar" /></form></td>
            <td><form action="/form" method="get">
                <input type="submit" value="Inserir nova despesa" /></form></td>
        </tr>
    </table>
</fieldset>
</div>
</body>
</html>
