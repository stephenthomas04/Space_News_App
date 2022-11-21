package com.example.hamburgertester;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    Context thisContext;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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
        //createTeams();
        return inflater.inflate(R.layout.fragment_home, container, false);

    }


    public void createTeams(){

        Drawable aash = ContextCompat.getDrawable(getActivity(), R.drawable.aashman_pic);
        Drawable steph = ContextCompat.getDrawable(getActivity(), R.drawable.stephen_profilepic);

        Log.d("Aash", "82 ");
        ArrayList<TeamsObj> team = new ArrayList<>();

        TeamsObj aashman = new TeamsObj(aash, "Aashman", getString(R.string.sampleDesc));
        team.add(aashman);

        TeamsObj Stephen = new TeamsObj(steph, "Stephen", getString(R.string.sampleDesc));
        team.add(Stephen);
        



        RecyclerView recyclerView = getView().findViewById(R.id.teamRecycler);

        Teams_RecyclerViewAdapter adapter = new Teams_RecyclerViewAdapter(thisContext, team);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(thisContext));
        recyclerView.setAdapter(adapter);
    }
}