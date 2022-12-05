package com.example.hamburgertester;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Satellites#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Satellites extends Fragment {

    Context context;
    Satellite_RecyclerViewAdapter satelliteAdapter;
    ArrayList<Satellite> satelliteArrayListMainActivity;
    RecyclerView satelliteRecyclerView;
    Activity activity = getActivity();
    private RequestQueue queue;
    private JSONArray getText;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    //This is the url for one of the Satellite's Apis
    //There might be more urls based off how the APi works, still gotta look into that.
    String url1 = "https://api.n2yo.com/rest/v1/satellite/above/41.702/-76.014/0/70/18/&apiKey=ULABLY-ZTED3R-TZA269-4YF2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Satellites() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Satellites.
     */
    // TODO: Rename and change types and number of parameters
    public static Satellites newInstance(String param1, String param2) {
        Satellites fragment = new Satellites();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //URL: https://api.n2yo.com/rest/v1/satellite/above/=42.0947/88.0648/100/70/0//&apiKey=3DM8MB-57EGHM-ZBX8TF-4SV3
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();


       // return inflater.inflate(R.layout.fragment_satellites, container, false);
    }




    public void getData(Context context, ArrayList<Satellite> Satellite){
        String Url = "https://api.n2yo.com/rest/v1/satellite/above/=42.0947/88.0648/100/70/0//&apiKey=3DM8MB-57EGHM-ZBX8TF-4SV3";

        StringRequest objectRequest = new StringRequest(Url, new Response.Listener<String>() {
            RequestQueue requestQueue = Volley.newRequestQueue(context);

            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();


            }

        });




    }





}