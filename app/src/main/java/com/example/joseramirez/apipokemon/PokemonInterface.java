package com.example.joseramirez.apipokemon;

import com.example.joseramirez.apipokemon.Model.Region;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonInterface {
    @GET("region")
    Call<Region> getRegions();
}
