package com.example.hamburgertester;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
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
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public  class rockets_RecyclerViewAdapter extends RecyclerView.Adapter<rockets_RecyclerViewAdapter.rocketsViewHolder>{

    Context context;
    ArrayList<Results> results;

    public rockets_RecyclerViewAdapter(Context context, ArrayList<Results> results){
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public rockets_RecyclerViewAdapter.rocketsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.rockets_row,parent,false);

        return new rockets_RecyclerViewAdapter.rocketsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rockets_RecyclerViewAdapter.rocketsViewHolder holder, int position) {
        holder.rocketName.setText(results.get(position).getName());

        String date = results.get(position).getNet().substring(0,10);
        String time = results.get(position).getNet().substring(11,19);


        if (results.get(position).getStatus().abbrev.equals("Success")){
            holder.countDown.setText("Launched!");
        }else{
            holder.countDown.setText(time);
        }
        holder.date.setText(date);
        holder.company_name.setText((results.get(position).getLaunch_service_provider().getName()));
        holder.location.setText(results.get(position).getPad().getLocation().getName());
        holder.company_name.setText(results.get(position).getLaunch_service_provider().getName());
        //holder.description.setText(results.get(position).getMission().getDescription());




        if(results.get(position).getStatus().abbrev.equals("Go")|| (results.get(position).getStatus().abbrev.equals("Success"))){
            holder.status.setBackgroundResource(R.drawable.status_go);
        }else if((results.get(position).getStatus().abbrev.equals("TBC") || (results.get(position).getStatus().abbrev.equals("TBD")))){
            holder.status.setBackgroundResource(R.drawable.status_tbc);
        }
        holder.status.setText(results.get(position).getStatus().abbrev);


        String imageUrl = results.get(position).getImage();

        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_baseline_downloading_24)
                .error(R.drawable.ic_baseline_error_outline_24)
                .override(150, 210)
                .centerCrop()
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
                .into(holder.rocketImage);


    }



    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class rocketsViewHolder extends RecyclerView.ViewHolder{

        ImageView rocketImage;

        TextView rocketName, date, company_name, location, description, status, countDown;

        public rocketsViewHolder(@NonNull View itemView) {
            super(itemView);
            rocketImage = itemView.findViewById(R.id.rocketImage);
            rocketName = itemView.findViewById(R.id.rocketName);
            date = itemView.findViewById(R.id.date);
            company_name = itemView.findViewById(R.id.company_name);
            location = itemView.findViewById(R.id.location);
            //description = itemView.findViewById(R.id.description);
            status = itemView.findViewById(R.id.status);
            countDown = itemView.findViewById(R.id.countDown);
        }


    }
}
