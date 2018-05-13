package com.example.joseramirez.apipokemon.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Generation {


    @SerializedName("abilities")
    private List<Object> abilities = null;
    @SerializedName("name")
    private String name;
    @SerializedName("version_groups")
    private List<VersionGroup> version_groups;
    @SerializedName("id")
    private int id;
    @SerializedName("names")
    private List<Name> names;
    @SerializedName("pokemon_species")
    private List<PokemonSpecy>  pokemonSpecies  = null;
    @SerializedName("moves")
    private List<Move> moves = null;
    @SerializedName("main_region")
    private  MainRegion main_region;
    @SerializedName("types")
    private List<Type> types = null;

    public List<Object> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Object> abilities) {
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VersionGroup> getVersion_groups() {
        return version_groups;
    }

    public void setVersion_groups(List<VersionGroup> version_groups) {
        this.version_groups = version_groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<PokemonSpecy> getPokemonSpecies() {
        return pokemonSpecies;
    }

    public void setPokemonSpecies(List<PokemonSpecy> pokemonSpecies) {
        this.pokemonSpecies = pokemonSpecies;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public MainRegion getMain_region() {
        return main_region;
    }

    public void setMain_region(MainRegion main_region) {
        this.main_region = main_region;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    //http://pokeapi.co/media/sprites/pokemon/25.png


}
