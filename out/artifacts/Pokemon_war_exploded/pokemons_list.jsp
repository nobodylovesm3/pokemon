<%@ page import="com.loginsession.EntityLoginSessionManager" %>
<%@ page import="com.pokemonentities.pokemondatabase.Pokemon" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pokemonentities.PokemonEntitiesManager" %>
<%@ page import="com.accountsentities.AccountManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="css/pokemon_list.css">

</head>
<body>

<%
    ArrayList<Pokemon> pokemons = PokemonEntitiesManager.getPokemonsListFromDB();
%>

<%String loggedUsername = EntityLoginSessionManager.getLoggedUsername();%>


<div class="image">

    <img src="pokemon_logo_blurred.png">
</div>
</div>
<jsp:useBean id="currDate" class="java.util.Date"/>
<p>Current time: <%=currDate%>
</p>

<div id="tableAndTitle">
    <h1>Your current Pokemon collection: </h1>
    <br>
    <table class="table">

        <tr>
            <th class="table">ID</th>
            <th class="table">Pokemon name</th>
            <th class="table">Location</th>
        </tr>

        <%
            for (int i = 0; i < pokemons.size(); i++) {
        %>
        <tr>
            <td><%= i + 1 %>.
            </td>
            <td><%= pokemons.get(i).getName() + "  "%>
            </td>
            <td><%= pokemons.get(i).getLocation() %>
            </td>
            <td><%= pokemons.get(i).getCreatedDate() %>
            </td>
        </tr>


        <%
            } %>
    </table>
</div>

<div id="addPokemon">
    <form method="post" name="AddPokemon" action="add_pokemon">
        <input type="text" name="addNewPokemon" placeholder="Input the new Pokemon's name">
        <div class="divider"></div>
        <input type="submit" value="Add Pokemon to collection">
    </form>
</div>
</body>
</html>
