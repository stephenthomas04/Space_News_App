package com.example.hamburgertester;

import static java.lang.Math.floor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


//import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ISS#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ISS extends Fragment implements AppInterface {
    AppInterface issInterface = this;
    private static ArrayList<IssReportsObj> issReportsArrayList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";




    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView issLocation;
    private TextView issDescription;
    private Context context;


    public ISS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ISS.
     */
    // TODO: Rename and change types and number of parameters
    public static ISS newInstance(String param1, String param2) {
        ISS fragment = new ISS();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationApi(); // Calling it twice so that when the app builds it creates coordinates, and
        //then on the oncreateview so that the create view updates the coordinates to the most recent

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

//

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_iss, container, false);
        context = this.getActivity();
        Log.d("Aash", context.toString());
        locationApi();
        reportApi();
        return v;
    }

    public void locationApi() {
        Log.d("Enguerran", "Loaded the location api req (line 112)");
        String Url = "https://api.wheretheiss.at/v1/satellites/25544";

        RequestQueue requestQueue = Volley.newRequestQueue(this.getActivity());

        StringRequest objectRequest = new StringRequest(Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                try {
                    ISS_Object iss = gson.fromJson(response, ISS_Object.class);
                    //The round num function rounds things to the decimal place
                    double getLat = roundNum(iss.getLatitude());
                    double getLong = roundNum(iss.getLongitude());

                    //set info from class here
                    issLocation = (TextView) getView().findViewById(R.id.issLocation);
                    issLocation.setText("Lat: "+getLat + "\nLong: " + getLong);
                    Log.d("Enguerran", "overshot");
                } catch (Exception e) {

                    e.printStackTrace();
                    Log.d("Enguerran", "catch");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Enguerran", "error (Line 147)");
            }
        });
        requestQueue.add(objectRequest);

    }


    public void reportApi(){
        String Url = "https://api.spaceflightnewsapi.net/v3/reports";

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest objectRequest = new StringRequest(Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                try {
                    Type listType = new TypeToken<ArrayList<IssReportsObj>>(){}.getType();
                    issReportsArrayList = gson.fromJson(response, listType);


                    for( IssReportsObj n : issReportsArrayList) {
                        Log.d("Iss_Reports", n.toString());
                    }

                    RecyclerView recyclerView = getView().findViewById(R.id.sRecyclerView);

                    ISS_RecyclerViewAdapter adapter = new ISS_RecyclerViewAdapter(context, issReportsArrayList, issInterface);
                    recyclerView.setNestedScrollingEnabled(false);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(adapter);

                } catch (Exception e){
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Response", "error");
            }
        });

        requestQueue.add(objectRequest);
    }


    public double roundNum(double x) {

        double total;
        total = 0.001 * floor(x * 1000.0); // Before it was 0.01 * floor(x * 100) to return a single decimal point
        return total;

    }

    @Override
    public void onItemClick(int position) {
        String url = issReportsArrayList.get(position).getReportUrl();

        Intent viewIntent = new Intent("android.intent.action.VIEW",
                Uri.parse(url));
        startActivity(viewIntent);
    }
}


