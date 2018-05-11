package com.example.joseramirez.apipokemon.Apicliente;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    public static  final String BASE_URL = "http://pokeapi.co/api/v2/";
    private static retrofit2.Retrofit retrofit = null;

    public static retrofit2.Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
