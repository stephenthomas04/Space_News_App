package com.example.hamburgertester;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IssUpdates_RecyclerViewAdapter extends RecyclerView.Adapter<IssUpdates_RecyclerViewAdapter.MyViewHolder> {
//Timestamp 17:36 inside the video

    @NonNull
    @Override
    public IssUpdates_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate the layout
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull IssUpdates_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //Assign Values to our rows
    }

    @Override
    public int getItemCount() {
        //The # of items in our row

        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //Kinda like Oncreate method
        ImageView imageView;
        TextView summary, date, title, websiteUrl;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.issImageView);
        }
    }
}
