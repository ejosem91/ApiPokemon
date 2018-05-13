package com.example.joseramirez.apipokemon.Model;

import com.google.gson.annotations.SerializedName;

public class PokemonSpecy {

    @SerializedName("url")
    private String url ;
    @SerializedName("name")
    private String name ;



    private int number;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        String[] urlparts = url.split("/");
        number =  Integer.parseInt(urlparts[urlparts.length -1]);
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
