<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Formulário do Utilizador</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>

</head>
<body>
    <form:form method="POST" modelAttribute="userForm" action="/form">

        <form:label path="name">Nome</form:label>
        <form:input path="name" label="Nome" /><br/>

        <form:label path="address">Morada</form:label>
        <form:input path="address" label="Morada" /><br/>

        <input type="submit" name="Gravar"/>
    </form:form>
</body>
</html>

