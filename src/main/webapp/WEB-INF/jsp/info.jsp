<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Informação</title>
</head>
<body>

<h1>Id da despesa: ${despesa.id}</h1>
<p>Categoria: ${despesa.categoria}</p>
<p>Data: ${despesa.data}</p>
<p>Descrição: ${despesa.descricao}</p>
<p>Valor: ${despesa.valor}</p>
<p>Localização: ${despesa.localizacao}</p>
<a href="/edit/${despesa.id}">Editar</a>
<form action="/delete/${despesa.id}" method="post">
    <input type="submit" value="Apagar" />
</form>
</body>
</html>