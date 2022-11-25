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
import com.android.volley.toolbox.Volley;

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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView satelliteRecyclerView;


    Activity activity = getActivity();


    private Satellite_RecyclerViewAdapter satelliteAdapter;
    private ArrayList<Satellite> satelliteArrayListMainActivity;
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


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void getData(Context context){

        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                satelliteRecyclerView.setVisibility(View.VISIBLE);
                for (int i = 0; i < response.length(); i++) {
                    // creating a new json object and
                    // getting each object from our json array.
                    try {
                        TextView textView = getView().findViewById(R.id.satNameTestTV);
                        // we are getting each json object.
                        JSONObject responseObj = response.getJSONObject(i);

                        // now we get our response from API in json object format.
                        // in below line we are extracting a string with
                        // its key value from our json object.
                        // similarly we are extracting all the strings from our json object.
                        String satelliteLatitude = responseObj.getString("satlatitude");
                        String satelliteLongitude = responseObj.getString("satlongitude");
                        String satAltitude = responseObj.getString("sataltitude");
                        String satName = responseObj.getString("satname");

                        textView.setText(satelliteLatitude);

                        /*
                        satelliteArrayListMainActivity.add(new Satellite(satName,satelliteLatitude,satelliteLongitude,satAltitude));

                        LinearLayoutManager manager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);

                        // initializing our adapter class.
                        RecyclerView recyclerView = getView().findViewById(R.id.satelliteRecyclerView);


                        satelliteAdapter = new Satellite_RecyclerViewAdapter(satelliteArrayListMainActivity,context);

                        // adding layout manager
                        // to our recycler view.

                        recyclerView.setHasFixedSize(true);

                        recyclerView.setAdapter(satelliteAdapter);

                        // setting layout manager
                        // to our recycler view.
                        recyclerView.setLayoutManager(manager);

                        // setting adapter to
                        // our recycler view.
                        */


                        Log.i("Enguerran" , "Satellite items put in array");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }


        },new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Fail to get the data..", Toast.LENGTH_SHORT).show();
                Log.i("Enguerran", "Satellites failed to get data");
            }
        });
        queue.add(jsonArrayRequest);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        //satelliteArrayListMainActivity = new ArrayList<>();
        getData(context);
        // Inflate the layout for this fragment



        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        //satelliteRecyclerView.setLayoutManager(linearLayoutManager);


        //satelliteRecyclerView =  getView().findViewById(R.id.satelliteRecyclerView);

        //https://stackoverflow.com/questions/35489177/recyclerview-with-null-pointer-exception




       // Old return return inflater.inflate(R.layout.fragment_satellites, container, false);
        return inflater.inflate(R.layout.fragment_satellites, container, false);
    }
}