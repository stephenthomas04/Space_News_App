package com.example.hamburgertester;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mars#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mars extends Fragment {
    Context thisContext;
    MarsObj rover;
    ArrayList<Images> imagesArrayList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Mars() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment_Mars.
     */
    // TODO: Rename and change types and number of parameters
    public static Mars newInstance(String param1, String param2) {
        Mars fragment = new Mars();
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
        thisContext = getActivity();
        roverRequest(thisContext);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mars, container, false);
    }

    public void roverRequest(Context context){
        String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        Integer offsetDay = Integer.parseInt(date.substring(0,2)) - 2;

        date = date.substring(6) + "-" + date.substring(3,5) + "-" + offsetDay;

        String api_key = "vzch0p2dvpdzzKxLNnosLvbbwDxVxb3nqsjlXkYB";
        String Url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date="+date+ "&api_key=" + api_key;



        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest objectRequest = new StringRequest(Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("marsstatus", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();



                try {

                    ArrayList<Images> newImagesArrayList = new ArrayList<>();

                    rover = gson.fromJson(response, MarsObj.class);
                    imagesArrayList = rover.getPhotos();
                    Log.d("marsstatus", "object parsed");

                    if(imagesArrayList.size() >= 15){
                        for (int i = 0; i < 15; i++) {
                            newImagesArrayList.add(imagesArrayList.get(i));
                        }
                    }

                    LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);

                    RecyclerView recyclerView = getView().findViewById(R.id.sRecyclerView);

                    MarsRover_RecyclerViewAdapter adapter = new MarsRover_RecyclerViewAdapter(context, newImagesArrayList);

                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(layoutManager);

                    for(Images n : imagesArrayList) {
                        Log.d("marsstatusSol", n.getImg_src());
                    }


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
}