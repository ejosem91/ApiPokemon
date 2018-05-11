package com.example.joseramirez.apipokemon.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseramirez.apipokemon.Model.Results;
import com.example.joseramirez.apipokemon.R;

import java.util.List;

public class AdapterRegion extends  RecyclerView.Adapter<AdapterRegion.MyViewHolder>{

    private List<Results> resultList;
    Context context;
    private int rowLayout;
    OnItemClickListener itemClickListener;

    public AdapterRegion(List<Results> resultList, int rowLayout, Context context, OnItemClickListener listener){
        this.resultList = resultList;
        this.rowLayout = rowLayout;
        this.context = context;
        this.itemClickListener = listener;

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).
                inflate(rowLayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final String url = resultList.get(position).getUrl().toString();
        final String name = resultList.get(position).getName().toString();

        holder.name.setText(resultList.get(position).getName());

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(name, url ,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public MyViewHolder(final View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);

        }
    }

    public interface  OnItemClickListener{
        void onItemClick(String name , String url , int position);
    }



}
