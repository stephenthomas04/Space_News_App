package com.example.hamburgertester;
import android.content.Context;
import android.util.Log;
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
    ArrayList<Above> aboveArrayList;
    Context context;

    // creating a constructor for our variables.
    public Satellite_RecyclerViewAdapter(ArrayList<Above> courseModalArrayList, Context context) {
        this.aboveArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Satellite_RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.

        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.satellite_row,parent,false);
        return new Satellite_RecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Satellite_RecyclerViewAdapter.ViewHolder holder, int position) {
        // setting data to our views of recycler view.

        Above above = aboveArrayList.get(position);
        Log.d("Enguerran", "Inside the onBindViewHolder");
        holder.SatelliteNameTV.setText(above.getSatname());
        holder.SatelliteLatitude.setText("Latitude: " +above.getSatlat());
        holder.SatelliteLongitude.setText("Longitude: " + above.getSatlng());
        holder.SatelliteAltitude.setText("Altitude: " +above.getSatalt());
        holder.SatelliteLaunchDate.setText("Launch Date: " + above.getLaunchDate());

        Log.d("Enguerran", "OnBindView "+above.getSatname());
        Log.d("Enguerran", "OnBindView "+above.getSatlat());
        Log.d("Enguerran", "OnBindView "+above.getSatlng());
        Log.d("Enguerran", "OnBindView "+above.getSatlat());

    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        Log.d("Enguerran", "GetItemCount "+ aboveArrayList.size());
        return aboveArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView SatelliteNameTV, SatelliteLatitude, SatelliteLongitude,SatelliteAltitude,
        SatelliteLaunchDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our views with their ids.
            SatelliteLatitude = itemView.findViewById(R.id.satelliteLatitude);
            SatelliteLongitude = itemView.findViewById(R.id.SatelliteLongitude);
            SatelliteAltitude = itemView.findViewById(R.id.SatelliteAltitude);
            SatelliteNameTV = itemView.findViewById(R.id.satelliteNameRow);
            SatelliteLaunchDate = itemView.findViewById(R.id.SatelliteDateLaunched);

        }
    }
}