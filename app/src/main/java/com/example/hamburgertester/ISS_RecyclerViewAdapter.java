
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

public class ISS_RecyclerViewAdapter extends RecyclerView.Adapter<ISS_RecyclerViewAdapter.issViewHolder> {
    Context context;
    ArrayList<IssReportsObj> reportsObjArrayList;

    public ISS_RecyclerViewAdapter(Context context, ArrayList<IssReportsObj> reportsObjArrayList) {
        this.context = context;
        this.reportsObjArrayList = reportsObjArrayList;
    }

    @NonNull
    @Override
    public ISS_RecyclerViewAdapter.issViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.iss_row,parent,false);

        return new ISS_RecyclerViewAdapter.issViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ISS_RecyclerViewAdapter.issViewHolder holder, int position) {
        holder.issTitle.setText(reportsObjArrayList.get(position).getReportTitle());
        holder.summary.setText(reportsObjArrayList.get(position).getSummary());

        String imageUrl = reportsObjArrayList.get(position).getImageUrl();
        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_baseline_downloading_24)
                .error(R.drawable.ic_baseline_error_outline_24)
                .centerCrop()
                .override(320,133)
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
        return reportsObjArrayList.size();
    }



    public static class issViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView issTitle, summary;

        public issViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.issImageView);
            issTitle = itemView.findViewById(R.id.issTitle);
            summary = itemView.findViewById(R.id.issDesc);

        }
    }
}

