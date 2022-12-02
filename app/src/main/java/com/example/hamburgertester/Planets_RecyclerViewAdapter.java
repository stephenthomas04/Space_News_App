package com.example.hamburgertester;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Planets_RecyclerViewAdapter extends RecyclerView.Adapter<Planets_RecyclerViewAdapter.planetViewHolder>{
    Context context;
    ArrayList<Planet> planets;

    public Planets_RecyclerViewAdapter(Context context,  ArrayList<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }

    @NonNull
    @Override
    public Planets_RecyclerViewAdapter.planetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.planet_row,parent,false);

        return new Planets_RecyclerViewAdapter.planetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Planets_RecyclerViewAdapter.planetViewHolder holder, int position) {
        holder.image.setImageDrawable(planets.get(position).getPlanetImage());
        holder.desc.setText(planets.get(position).getPlanetInfo());
        holder.name.setText(planets.get(position).getPlanetName());
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }



    public static class planetViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name, desc;

        public planetViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.planetImage);
            name = itemView.findViewById(R.id.planetName);
            desc = itemView.findViewById(R.id.planetInfo);

        }
    }}




