package com.example.hamburgertester;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ISS#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ISS extends Fragment {

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


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        Log.d("Praneet", "onCreateView is displaying" );
        locationApi();
        reportAPi();
        Log.d("Praneet", "onCreateView is displaying 12212" );

        return inflater.inflate(R.layout.fragment_iss, container, false);
    }

    public void locationApi() {
        Log.d("Response", "loded api req");
        String Url = "https://api.wheretheiss.at/v1/satellites/25544";

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest objectRequest = new StringRequest(Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                try {
                    ISS_Object iss = gson.fromJson(response, ISS_Object.class);

                    double getLat =  Math.round(iss.getLatitude());
                    double getLong =  Math.round(iss.getLongitude());

                    //set info from class here
                    issLocation = (TextView) getView().findViewById(R.id.issLocation);
                    issLocation.setText(getLat + " , " + getLong);
                    Log.d("Enguerran", "overshot");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("Enguerran", "catch");
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

    public void reportAPi(){

        Log.d("Response", "Loaded report Api");
        String Url = "https://api.spaceflightnewsapi.net/v3/reports";

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest objectRequest = new StringRequest(Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                try {
                    ISS_Updates iss = gson.fromJson(response, ISS_Updates.class);

                    String description = iss.getSummary();

                    //set info from class here
                    issDescription = (TextView) getView().findViewById(R.id.issDesc);
                    issDescription.setText(description);

                    Log.d("Enguerran", "overshot report");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("Enguerran", "catch report api");
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
}