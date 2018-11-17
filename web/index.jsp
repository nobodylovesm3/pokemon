<%@ page import="com.loginsession.EntityLoginSessionManager" %>
<%@ page import="com.accountsentities.AccountManager" %>
<%@ page import="com.pokemonentities.PokemonEntitiesManager" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PokemonDeX</title>

    <link rel="stylesheet" type="text/css" href="css/successful_reg_or_log.css">

</head>
<body>

<%
    PokemonEntitiesManager pokemonEntitiesManager = new PokemonEntitiesManager();
    AccountManager accountManager = new AccountManager();
    EntityLoginSessionManager entityLoginSessionManager = new EntityLoginSessionManager();
    EntityLoginSessionManager.addFirstUserCredentials();
%>


<video id="myVid" autoplay loop muted="muted">
    <source id="mp4" src="pokemon.mp4" type="video/mp4">
</video>

<div class="buttons" >
    <a href="register.jsp">REGISTER</a>
    <a href="login.jsp">LOGIN</a>
</div>

<div class="image">

    <img src="pokemon_logo.png">

</div>
    <div class="content">

        <form method="post" name="Login" action="register.jsp">
            <input type="submit" value="Create account">
        </form>

    </div>
</body>
</html>