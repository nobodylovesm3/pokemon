package com.pokemonentities.pokemondatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonsDatabase {

    private static List<String> pokemonNames = Arrays.asList("Bulbasaur", "Charmander", "Squirtle", "Dratini", "Moltres", "Zapdos", "Caterpie",
            "Charizard", "Dragonair", "Dragonite");

    private static List<Pokemon> pokemons = new ArrayList<>();

    public static void initiateDatabase() {
        for (int i = 0; i < pokemonNames.size(); i++) {
            pokemons.add(new Pokemon(pokemonNames.get(i)));
        }
    }

    public static List<Pokemon> getPokemons() {
        return pokemons;
    }

}
