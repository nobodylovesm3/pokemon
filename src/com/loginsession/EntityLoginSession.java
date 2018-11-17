package com.loginsession;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "logged_user", schema = "pokedex_logged_user")
public class EntityLoginSession {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "isLogged")
    private String isLogged = "No";
    @Column(name = "LoggedUsername")
    private String loggedUsername = null;

    @ElementCollection
    @CollectionTable(name = "pokemons_created", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "created_pokemons")
    private List<String> namesOfCreatedPokemons = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(String isLogged) {
        this.isLogged = isLogged;
    }

    public String getLoggedUsername() {
        return loggedUsername;
    }

    public void setLoggedUsername(String loggedUsername) {
        this.loggedUsername = loggedUsername;
    }

    public List<String> getNamesOfCreatedPokemons() {
        return namesOfCreatedPokemons;
    }

    public void setNamesOfCreatedPokemons(List<String> namesOfCreatedPokemons) {
        this.namesOfCreatedPokemons = namesOfCreatedPokemons;
    }
}
