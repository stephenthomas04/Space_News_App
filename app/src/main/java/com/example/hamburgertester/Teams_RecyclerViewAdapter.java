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

public class Teams_RecyclerViewAdapter extends RecyclerView.Adapter<Teams_RecyclerViewAdapter.personViewHolder>{
    Context context;
    ArrayList<TeamsObj> team;

    @NonNull
    @Override
    public Teams_RecyclerViewAdapter.personViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.team_row,parent,false);

        return new Teams_RecyclerViewAdapter.personViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Teams_RecyclerViewAdapter.personViewHolder holder, int position) {
        holder.image.setImageDrawable(team.get(position).getPicture());
        holder.desc.setText(team.get(position).getDesc());
        holder.name.setText(team.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return team.size();
    }



    public static class personViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name, desc;

        public personViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.profilePic);
            name = itemView.findViewById(R.id.teamName);
            desc = itemView.findViewById(R.id.teamDesc);

        }
    }}
