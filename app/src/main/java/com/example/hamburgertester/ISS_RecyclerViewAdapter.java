
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
    }

    @Override
    public int getItemCount() {
        return reportsObjArrayList.size();
    }



    public static class issViewHolder extends RecyclerView.ViewHolder{
        TextView issTitle, summary;

        public issViewHolder(@NonNull View itemView) {
            super(itemView);

            issTitle = itemView.findViewById(R.id.issTitle);
            summary = itemView.findViewById(R.id.issDesc);

        }
    }
}

