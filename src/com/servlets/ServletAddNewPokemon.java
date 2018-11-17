package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletAddNewPokemon", urlPatterns = "/add_pokemon")
public class ServletAddNewPokemon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String submittedPokemon = request.getParameter("addNewPokemon");
//        AccountManager.addPokemon(submittedPokemon);
//        Pokemon pokemon = new Pokemon();
//        pokemon.setName(submittedPokemon);
//        ArrayList<Pokemon> pokemons = PokemonEntitiesManager.getPokemonsListFromDB();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
