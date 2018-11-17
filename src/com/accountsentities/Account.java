package com.accountsentities;

import java.util.ArrayList;

public class Account {
    private long id;
    private String email;
    private String username;
    private String password;


    private ArrayList<String> createdPokemons;

    public Account(long id, String email, String username, String password, ArrayList<String> pokemons){
        this.id= id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createdPokemons = pokemons;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getCreatedPokemons() {
        return createdPokemons;
    }

    public void setCreatedPokemons(ArrayList<String> createdPokemons) {
        this.createdPokemons = createdPokemons;
    }

}
