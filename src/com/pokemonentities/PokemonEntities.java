package com.pokemonentities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "pokemons", schema = "pokedex_pokemons")
public class PokemonEntities {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "created_date")
    private String createdDate = "";
    @Column(name = "habitat")
    private String location = "Earth";

    public PokemonEntities() {
    }

    public static String getCreatedDateForPokemons() {

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm a");
        String newFormat = currentDateTime.format(format);

        return newFormat;
    }


    public PokemonEntities(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return getCreatedDateForPokemons();
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
