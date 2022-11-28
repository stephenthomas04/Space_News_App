package com.example.hamburgertester;

import static java.lang.Math.floor;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import java.lang.reflect.Type;
import java.util.ArrayList;

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

    private RecyclerView iss_UpdatesRecyclerView;

    private ISS_RecyclerViewAdapter iss_UpdatesAdapter;
    private ArrayList<ISS_Updates> iss_objectArrayList;

    String Iss_UpdatesUrl = "https://api.spaceflightnewsapi.net/v3/reports";


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

        iss_UpdatesRecyclerView = getView().findViewById(R.id.issRecyclerView);


        // below line we are creating a new array list
        iss_objectArrayList = new ArrayList<>();
//        issReportsApi();

        // calling method to
        // build recycler view.
//        buildRecyclerView();
        
      /*  IssUpdates_RecyclerViewAdapter adapter = new IssUpdates_RecyclerViewAdapter(context, iss_objectArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        locationApi();
        return inflater.inflate(R.layout.fragment_iss, container, false);
    }

    public void locationApi() {
        Log.d("Enguerran", "Loaded the location api req (line 112)");
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


                    //The round num function rounds things to the decimal place

                    double getLat = roundNum(iss.getLatitude());
                    double getLong = roundNum(iss.getLongitude());

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
                Log.d("Enguerran", "error (Line 147)");
            }
        });
        requestQueue.add(objectRequest);

    }

//    public void reportAPi(){
//
//    }

    public double roundNum(double x) {

        double total;
        total = 0.001 * floor(x * 1000.0); // Before it was 0.01 * floor(x * 100) to return a single decimal point
        return total;

    }
}



//    //Start of the Report API
//    private void issReportsApi() {
//        // creating a new variable for our request queue
//        RequestQueue queue = Volley.newRequestQueue(context);
//        // in this case the data we are getting is in the form
//        // of array so we are making a json array request.
//        // below is the line where we are making an json array
//        // request and then extracting data from each json object.
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Iss_UpdatesUrl, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                iss_UpdatesRecyclerView.setVisibility(View.VISIBLE);
//                for (int i = 0; i < response.length(); i++) {
//                    // creating a new json object and
//                    // getting each object from our json array.
//                    try {
//                        // we are getting each json object.
//                        JSONObject responseObj = response.getJSONObject(i);
//
//                        // now we get our response from API in json object format.
//                        // in below line we are extracting a string with
//                        // its key value from our json object.
//                        // similarly we are extracting all the strings from our json object.
//                        String updateTitles = responseObj.getString("title");
//                        String updateUrl = responseObj.getString("url");
//                        String updateDate = responseObj.getString("publishedAt");
//                        String updateSummary = responseObj.getString("summary");
//                        String updateImageURl = responseObj.getString("imageUrl");
//
//
//                        iss_objectArrayList.add(new ISS_Updates(updateTitles, updateUrl, updateImageURl,
//                                updateSummary, updateDate));
//                        buildRecyclerView();
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Fail to get the data..", Toast.LENGTH_SHORT).show();
//            }
//        });
//        queue.add(jsonArrayRequest);
//    }
//
//    private void buildRecyclerView() {
//
//        // initializing our adapter class.
//        iss_UpdatesAdapter = new ISS_RecyclerViewAdapter(iss_objectArrayList,context);
//
//        // adding layout manager
//        // to our recycler view.
//        LinearLayoutManager manager = new LinearLayoutManager(context);
//        iss_UpdatesRecyclerView.setHasFixedSize(true);
//
//        // setting layout manager
//        // to our recycler view.
//        iss_UpdatesRecyclerView.setLayoutManager(manager);
//
//        // setting adapter to
//        // our recycler view.
//        iss_UpdatesRecyclerView.setAdapter(iss_UpdatesAdapter);
//    }
//}