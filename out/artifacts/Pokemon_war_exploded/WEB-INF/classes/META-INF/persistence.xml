package com.accountsentities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", schema = "pokedex_accounts")
public class AccountEntity {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @ElementCollection
    @CollectionTable(name = "user_created_pokemons", joinColumns=@JoinColumn(name="id"))
    @Column(name = "created_pokemons")
    private List<String> nameCreatedPokemon = new ArrayList<>();

    @ElementCollection
    @Column(name = "created_pokemons")
    @CollectionTable(name = "dates_creation", joinColumns=@JoinColumn(name="id"))
    private List<String> creationDate = new ArrayList<>();

    public AccountEntity(){

    }

    public AccountEntity(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
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

    public List<String> getNameCreatedPokemon() {
        return nameCreatedPokemon;
    }

    public void setNameCreatedPokemon(List<String> nameCreatedPokemon) {
        this.nameCreatedPokemon = nameCreatedPokemon;
    }

    public List<String> getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(List<String> creationDate) {
        this.creationDate = creationDate;
    }
}
