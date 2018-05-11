package com.example.joseramirez.apipokemon;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import com.example.joseramirez.apipokemon.Adapter.AdapterRegion;
import com.example.joseramirez.apipokemon.Apicliente.Retrofit;
import com.example.joseramirez.apipokemon.Model.Region;
import com.example.joseramirez.apipokemon.Model.Results;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Results> resultsList;
    Region region = new Region();
    AdapterRegion adapterRegion;
    String nameadapter , urlfromadapter ;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    //private RecyclerView.LayoutManager mLayoutManager;
    ProgressDialog progress ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getBaseContext(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(false);

        setProgresDialog();
        getdata();
    }

    private void getdata(){
        PokemonInterface instanceInterface = Retrofit.getRetrofit().create(PokemonInterface.class);
        retrofit2.Call<Region> getRegio = instanceInterface.getRegions();
        getRegio.enqueue(new Callback<Region>() {
            @Override
            public void onResponse(retrofit2.Call<Region> call, Response<Region> response) {
                region = response.body();
                resultsList = region.getResults();
                adapterRegion = new AdapterRegion(resultsList, R.layout.items_recycler, getBaseContext(), new AdapterRegion.OnItemClickListener() {
                    @Override
                    public void onItemClick(String name, String url, int position) {
                        nameadapter = name ;
                        urlfromadapter = url ;
                        Toast.makeText(getBaseContext(), "text"+ position,Toast.LENGTH_LONG).show();

                    }
                });
                recyclerView.setAdapter(adapterRegion);
                progress.dismiss();

            }

            @Override
            public void onFailure(retrofit2.Call<Region> call, Throwable t) {

            }
        });

    }


    private void  setProgresDialog(){
        progress = new ProgressDialog(this);
        progress.setMessage("Cargando regiones..");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setCanceledOnTouchOutside(false);
        progress.show();

    }



}
