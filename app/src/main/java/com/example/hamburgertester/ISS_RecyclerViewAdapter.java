
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

public class ISS_RecyclerViewAdapter extends RecyclerView.Adapter<ISS_RecyclerViewAdapter.ViewHolder> {
    //***ISS UPDATES****

    private ArrayList<ISS_Updates> ISS_UpdatesArrayList;
    private Context context;

    public ISS_RecyclerViewAdapter(ArrayList<ISS_Updates> ISS_UpdatesArrayList, Context context) {
        this.ISS_UpdatesArrayList = ISS_UpdatesArrayList;
        this.context = context;
    }

    public ArrayList<ISS_Updates> getISS_UpdatesArrayList() {
        return ISS_UpdatesArrayList;
    }

    public Context getContext() {
        return context;
    }

    public ISS_RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iss_row, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull ISS_RecyclerViewAdapter.ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        ISS_Updates updates = ISS_UpdatesArrayList.get(position);
        holder.IssHeadlineTV.setText(updates.getTitle());
        holder.IssPublishDateTV.setText(updates.getDate());
        holder.IssDescriptionTV.setText(updates.getSummary());
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return ISS_UpdatesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView IssHeadlineTV, IssPublishDateTV, IssDescriptionTV;
        private ImageView IssUpdateImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our views with their ids.
            IssHeadlineTV= itemView.findViewById(R.id.issHeadline);
            IssPublishDateTV = itemView.findViewById(R.id.issPublishDate);
            IssDescriptionTV = itemView.findViewById(R.id.issDesc);
            IssUpdateImg = itemView.findViewById(R.id.issImageView);
        }
    }



}

