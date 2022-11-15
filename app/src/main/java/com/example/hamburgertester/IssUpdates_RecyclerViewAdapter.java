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

public class IssUpdates_RecyclerViewAdapter extends RecyclerView.Adapter<IssUpdates_RecyclerViewAdapter.MyViewHolder> {
//Timestamp 17:36 inside the video
    Context context;
    ArrayList<ISS_Updates> issModelArray;


    public IssUpdates_RecyclerViewAdapter(Context context, ArrayList<ISS_Updates> issModelArray){
        this.context = context;
        this.issModelArray = issModelArray;
    }

    @NonNull
    @Override
    public IssUpdates_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate the layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.iss_row, parent, false);



        return new IssUpdates_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IssUpdates_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //Assign Values to our rows

        holder.title.setText(issModelArray.get(position).getTitle());
        holder.date.setText(issModelArray.get(position).getDatePublished());
        holder.summary.setText(issModelArray.get(position).getSummary());


    }

    @Override
    public int getItemCount() {
        //The # of items in our row

        return issModelArray.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //Kinda like Oncreate method
        ImageView imageView;
        TextView summary, date, title;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.issImageView);
            title = itemView.findViewById(R.id.issHeadline);
            summary = itemView.findViewById(R.id.issDesc);
            date = itemView.findViewById(R.id.issPublishDate);

        }
    }
}
