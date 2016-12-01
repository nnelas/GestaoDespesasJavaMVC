<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Informação</title>
</head>
<body>
<br>
<div class="container">
<fieldset>
    <legend>Informação da despesa com o ID: ${despesa.id}</legend>

    <dl class="row">
        <dt class="col-sm-3">Categoria: </dt>
        <dd class="col-sm-9">${despesa.categoria}</dd>

        <dt class="col-sm-3">Data: </dt>
        <dd class="col-sm-9">${despesa.data}</dd>

        <dt class="col-sm-3">Descrição:</dt>
        <dd class="col-sm-9">${despesa.descricao}</dd>

        <dt class="col-sm-3">Valor:</dt>
        <dd class="col-sm-9">${despesa.valor}€</dd>

        <dt class="col-sm-3">Localização:</dt>
        <dd class="col-sm-9">${despesa.localizacao}</dd>
    </dl>
        <br><br>

        <table>
            <tr>
                <td><form action="/list" method="get">
                    <input type="submit" value="Voltar" /></form></td>
                <td><form action="/edit/${despesa.id}" method="get">
                    <input type="submit" value="Editar" /></form></td>
                <td><form action="/delete/${despesa.id}" method="post">
                    <input type="submit" value="Apagar" /></form></td>
            </tr>
        </table>
</fieldset>
</div>
</body>
</html>