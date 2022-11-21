package com.example.hamburgertester;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Satellite_RecyclerViewAdapter extends RecyclerView.Adapter<Satellite_RecyclerViewAdapter.ViewHolder> {

    // creating a variable for array list and context.
    private ArrayList<Satellite> satelliteArrayList;
    private Context context;

    // creating a constructor for our variables.
    public Satellite_RecyclerViewAdapter(ArrayList<Satellite> courseModalArrayList, Context context) {
        this.satelliteArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Satellite_RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.satellite_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Satellite_RecyclerViewAdapter.ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        Satellite satellite = satelliteArrayList.get(position);
        holder.SatelliteNameTV.setText(satellite.getName());
        //holder.SatelliteHeadingTV.setText(//satellite.getSatLatitude());
       // holder.SatelliteDesc.setText(satellite.getName()); //TEMPORARY

    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return satelliteArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView SatelliteNameTV, SatelliteHeadingTV, SatelliteDesc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our views with their ids.
            SatelliteDesc = itemView.findViewById(R.id.satelliteDesc);
            SatelliteHeadingTV = itemView.findViewById(R.id.satelliteHeadingRow);
            SatelliteNameTV = itemView.findViewById(R.id.satelliteMenu);
        }
    }
}