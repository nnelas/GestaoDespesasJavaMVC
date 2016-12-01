<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Informação</title>
</head>
<body>
<fieldset>
    <legend>Informação da despesa com o ID: ${despesa.id}</legend>

    <p>Categoria: ${despesa.categoria}</p>
    <p>Data: ${despesa.data}</p>
    <p>Descrição: ${despesa.descricao}</p>
    <p>Valor: ${despesa.valor}</p>
    <p>Localização: ${despesa.localizacao}</p>
    <br><br>
    <table>
        <tr>
            <td><form action="/edit/${despesa.id}" method="get">
                <input type="submit" value="Editar" /></form></td>
            <td><form action="/delete/${despesa.id}" method="post">
                <input type="submit" value="Apagar" /></form></td>
            <td><form action="/list" method="get">
                <input type="submit" value="Voltar" /></form></td>
        </tr>
    </table>

</fieldset>
</body>
</html>