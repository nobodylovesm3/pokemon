package com.pokemonentities.pokemondatabase;

public class Pokemon {

    private String name;
    private String location;
    private String createdDate;

    public Pokemon() {

    }

    public Pokemon(String name) {
        this.name = name;
    }

    public Pokemon(String name, String location, String createdDate) {
        this.name = name;
        this.location = location;
        this.createdDate = createdDate;
    }

    public Pokemon(String name, String createdDate) {
        this.name = name;
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
