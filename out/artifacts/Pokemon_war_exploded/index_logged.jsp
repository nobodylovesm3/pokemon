<%@ page import="com.loginsession.EntityLoginSessionManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


    <link rel="stylesheet" type="text/css" href="css/logged_index.css">


</head>
<body>

<div class="image">

    <img src="pokemon_logo.png">
</div>

<p><%= request.getAttribute("successfulLog")%>
</p>

<div class="content">
    <form method="post" name="Login" action="redirect_to_pokemons_list">
        <input type="submit" value="See current Pokemons">
    </form>
    <div class="divider"></div>

    <form method="post" name="AddPokemon" action="add_pokemon">
        <input type="submit" value="Add a new Pokemon">
    </form>
</div>
<div class="outer_button">
    <form method="post" name="LOGOUT" action="logout">
        <input type="submit" value="Logout">
    </form>

</div>

</body>
</html>