<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String message = null; %>
<%
    if (request.getAttribute("message") != null) {
        message = (String) request.getAttribute("message");
    }
%>
<p>Just a test message</p>
<form method="post" name="GO BACK" action="pokemons_list.jsp">
    <input type="submit" value="GO BACK">
</form>

<h2><%= message%>
</h2>
</body>
</html>