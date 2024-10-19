package com.example.parcial2;

public class Character {
    private String name;
    private String status;
    private String species;
    private String imageUrl;
    private String location;
    private String gender;

    public Character(String name, String status, String species, String imageUrl, String location, String gender) {
        this.name = name;
        this.status = status;
        this.species = species;
        this.imageUrl = imageUrl;
        this.location = location;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public String getGender() {
        return gender;
    }
}
