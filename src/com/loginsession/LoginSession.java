package com.loginsession;

import java.util.ArrayList;

public class LoginSession {

    private String isLogged;
    private String isLoggedUsername;
    private ArrayList<String> createdPokemons;


    public LoginSession(String isLogged, String isLoggedUsername, ArrayList<String> createdPokemons) {
        this.isLogged = isLogged;
        this.isLoggedUsername = isLoggedUsername;
        this.createdPokemons = createdPokemons;
    }


    public String getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(String isLogged) {
        this.isLogged = isLogged;
    }

    public String getIsLoggedUsername() {
        return isLoggedUsername;
    }

    public void setIsLoggedUsername(String isLoggedUsername) {
        this.isLoggedUsername = isLoggedUsername;
    }

    public ArrayList<String> getCreatedPokemons() {
        return createdPokemons;
    }

    public void setCreatedPokemons(ArrayList<String> createdPokemons) {
        this.createdPokemons = createdPokemons;
    }
}
