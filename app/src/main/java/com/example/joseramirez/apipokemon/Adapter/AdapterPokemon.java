package com.example.joseramirez.apipokemon.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.joseramirez.apipokemon.Model.PokemonSpecy;
import com.example.joseramirez.apipokemon.Model.Results;
import com.example.joseramirez.apipokemon.R;

import java.util.List;

public class AdapterPokemon  extends RecyclerView.Adapter<AdapterPokemon.MyViewHolder>{

    private List<PokemonSpecy> resultList;
    Context context;
    // int rowLayout;
    AdapterPokemon.OnItemClickListener itemClickListener;

    public AdapterPokemon(List<PokemonSpecy> resultList,  Context context, AdapterPokemon.OnItemClickListener listener){
        this.resultList = resultList;
       // this.rowLayout = rowLayout;
        this.context = context;
        this.itemClickListener = listener;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPokemon.MyViewHolder holder, final int position) {
        final String url = resultList.get(position).getUrl().toString();
        final String name = resultList.get(position).getName().toString();

        holder.name.setText(resultList.get(position).getName());
        Glide.with(context)
                .load("http://pokeapi.co/media/sprites/pokemon/" +
                        resultList.get(position).getNumber()
                + ".png").centerCrop().crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imgView);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(name ,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imgView;
        public MyViewHolder(final View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.namePokemon);
            imgView = (ImageView)itemView.findViewById(R.id.imagePokemon);

        }
    }

    public interface  OnItemClickListener{
        void onItemClick(String name , int position);
    }

}
