<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <legend>Informação</legend>
        <p>${message}</p>
        <br><br><br>
        <table>
            <tr>
                <td><form action="/" method="get">
                    <input type="submit" value="Voltar ao início" /></form></td>
                <td><form action="/list" method="get">
                    <input type="submit" value="Lista de despesas" /></form></td>
                <td><form action="/form" method="get">
                    <input type="submit" value="Adicionar nova despesa" /></form></td>
            </tr>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>