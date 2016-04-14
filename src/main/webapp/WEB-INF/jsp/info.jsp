<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Informação</title>
</head>
<body>

<h1>Utilizador ${utilizador.id}</h1>
<p>Nome: ${utilizador.name}</p>
<p>Morada: ${utilizador.address}</p>
<a href="/edit/${utilizador.id}">Editar</a>
<form action="/delete/${utilizador.id}" method="post">
    <input type="submit" value="Apagar" />
</form>
</body>
</html>