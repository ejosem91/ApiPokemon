package com.example.joseramirez.apipokemon.Model;

import com.google.gson.annotations.SerializedName;

public class Name {
    @SerializedName("name")
    private String name;
    @SerializedName("language")
    Language language;

}
