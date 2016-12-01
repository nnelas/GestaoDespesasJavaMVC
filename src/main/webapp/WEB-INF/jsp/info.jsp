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

    <p>Categoria: ${despesa.categoria}</p>
    <p>Data: ${despesa.data}</p>
    <p>Descrição: ${despesa.descricao}</p>
    <p>Valor: ${despesa.valor}€</p>
    <p>Localização: ${despesa.localizacao}</p>
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