package com.example.hamburgertester;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

public class MarsRover_RecyclerViewAdapter extends RecyclerView.Adapter<MarsRover_RecyclerViewAdapter.roverViewHolder>{
    Context context;
    ArrayList<Images> results;

    public MarsRover_RecyclerViewAdapter(Context context, ArrayList<Images> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public MarsRover_RecyclerViewAdapter.roverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.rover_row,parent,false);

        return new MarsRover_RecyclerViewAdapter.roverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MarsRover_RecyclerViewAdapter.roverViewHolder holder, int position) {
        holder.date.setText(results.get(position).getEarth_date());

        String imageUrl = results.get(position).getImg_src();
        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_baseline_downloading_24)
                .error(R.drawable.ic_baseline_error_outline_24)
                .centerCrop()
                .override(300,200)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        // log exception
                        Log.e("TAG", "Error loading image", e);
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class roverViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView sol, date;

        public roverViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            date = itemView.findViewById(R.id.earthDate);
        }
    }
}
