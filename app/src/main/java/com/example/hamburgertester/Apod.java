package com.example.hamburgertester;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.google.gson.reflect.TypeToken;



import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Apod#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Apod extends Fragment implements NewsInterface {
    NewsInterface newsInterface = this;
    Context thisContext;
    ArrayList<NewsObj> newsArrayList = new ArrayList<>();
    String articleName = "Astronomy Picture of the Day";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Apod() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment_Apod.
     */
    // TODO: Rename and change types and number of parameters
    public Apod newInstance(String param1, String param2) {
        Apod fragment = new Apod();
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
        newsRequest(thisContext);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apod, container, false);


    }


    public void apodRequest(Context context, news_RecyclerViewAdapter adapter){
        String api_key = "vzch0p2dvpdzzKxLNnosLvbbwDxVxb3nqsjlXkYB";
        String Url = "https://api.nasa.gov/planetary/apod?api_key=" + api_key;



        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest objectRequest = new StringRequest(Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();



                try {
                    ApodObj apod = gson.fromJson(response, ApodObj.class);
                    Log.d("objstatus", "object parsed");

                    NewsObj apodToNews = new NewsObj( apod.getTitle(),
                            apod.getUrl(), apod.getUrl(),
                            apod.getExplanation() , apod.getDate(), articleName);

                    newsArrayList.set(0, apodToNews);
                    adapter.notifyItemChanged(0);
                    Log.d("objstatus", "object added");

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


    public void newsRequest(Context context){

        String Url = "https://api.spaceflightnewsapi.net/v3/articles";
        String defaultImage = "https://cdn.mos.cms.futurecdn.net/Tqq3BVZZAkbUyGvZmSfjQW-970-80.jpg";

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest objectRequest = new StringRequest(Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();



                try {
                    Type listType = new TypeToken<ArrayList<NewsObj>>(){}.getType();
                    newsArrayList = gson.fromJson(response, listType);

                    NewsObj tempObj = new NewsObj("Retrieving Data...",
                            defaultImage,defaultImage,"NO DATA" , "0000-00-00", articleName);

                    Log.d("objectResponse", "Temp Added");
                    newsArrayList.add(0, tempObj);

                    for(NewsObj n : newsArrayList) {
                        Log.d("NewsInfo", n.toString());
                    }

                    RecyclerView recyclerView = getView().findViewById(R.id.nRecyclerView);

                    news_RecyclerViewAdapter adapter = new news_RecyclerViewAdapter(context, newsArrayList, newsInterface);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(adapter);

                    apodRequest(thisContext, adapter);
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


    @Override
    public void onItemClick(int position) {
        String url = newsArrayList.get(position).getUrl();

        Intent viewIntent = new Intent("android.intent.action.VIEW",
                        Uri.parse(url));
        startActivity(viewIntent);
    }
}