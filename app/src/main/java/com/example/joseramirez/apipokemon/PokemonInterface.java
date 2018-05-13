package com.example.joseramirez.apipokemon;

import com.example.joseramirez.apipokemon.Model.Generation;
import com.example.joseramirez.apipokemon.Model.Region;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonInterface {
    @GET("region")
    Call<Region> getRegions();
    @GET("generation/{id}")
    Call<Generation> getGeneration( @Path("id") String id );

}
