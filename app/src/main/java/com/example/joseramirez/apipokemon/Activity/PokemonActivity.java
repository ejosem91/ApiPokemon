package com.example.joseramirez.apipokemon.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.joseramirez.apipokemon.Adapter.AdapterPokemon;
import com.example.joseramirez.apipokemon.Apicliente.Retrofit;
import com.example.joseramirez.apipokemon.Model.Generation;
import com.example.joseramirez.apipokemon.Model.PokemonSpecy;
import com.example.joseramirez.apipokemon.Interfaces.PokemonInterface;
import com.example.joseramirez.apipokemon.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonActivity extends AppCompatActivity {
    Generation generation = new Generation();
    List<PokemonSpecy> specyList =  null;
    AdapterPokemon adapterPokemon;
    TextView textView ;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        Bundle b =  getIntent().getExtras();
        String name = b.getString("name");
        String id = getGeneration(name);
        getPokemonPerRegion(id);
        textView = (TextView)findViewById(R.id.name);
        recyclerView= (RecyclerView)findViewById(R.id.pokemonRecycler);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(false);


    }

    private String   getGeneration(String name ){
        String id = "";
        if(name.equals("kanto")){
            id = "1";
        }else if (name.equals("johto")){
            id = "2";
        }else if (name.equals("hoenn")){
            id= "3";
        }else if (name.equals("sinnoh")){
            id = "4";
        }else  if(name.equals("unova")){
            id= "5";
        }else  if(name.equals("kalos")){
            id= "6";
        }else  if(name.equals("alola")){
            id = "7";
        }
        return id ;
    }

    private void getPokemonPerRegion(String id){
        PokemonInterface pokemonInterface = Retrofit.getRetrofit().create(PokemonInterface.class);
        Call<Generation> getGenerationPokemon = pokemonInterface.getGeneration(id);
        getGenerationPokemon.enqueue(new Callback<Generation>() {
            @Override
            public void onResponse(Call<Generation> call, Response<Generation> response) {
                generation = response.body();
                specyList = generation.getPokemonSpecies();
                adapterPokemon= new AdapterPokemon(specyList, getBaseContext(), new AdapterPokemon.OnItemClickListener() {
                    @Override
                    public void onItemClick(String name, int position) {

                    }
                });
                recyclerView.setAdapter(adapterPokemon);
            }

            @Override
            public void onFailure(Call<Generation> call, Throwable t) {

            }
        });
    }
}
