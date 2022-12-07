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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {
  
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home.
     */
    // TODO: Rename and change types and number of parameters
    public static home newInstance(String param1, String param2) {
        home fragment = new home();
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
        ArrayList<TeamsObj> team = new ArrayList<>();
        teamMethod(team);
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);


        RecyclerView recyclerView = v.findViewById(R.id.teamRecycler);
        Teams_RecyclerViewAdapter adapter = new Teams_RecyclerViewAdapter(v.getContext(), team);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }


    public void teamMethod(ArrayList<TeamsObj> team){
        Drawable aash = ContextCompat.getDrawable(getActivity(), R.drawable.aashman_pic);
        Drawable steph = ContextCompat.getDrawable(getActivity(), R.drawable.stephen_pic);
        Drawable eng = ContextCompat.getDrawable(getActivity(), R.drawable.enguerranpfp);




        TeamsObj aashman = new TeamsObj(aash, "Aashman", getString(R.string.aashmanDesc));
        team.add(aashman);

        TeamsObj Stephen = new TeamsObj(steph, "Stephen", getString(R.string.ST_desc));
        team.add(Stephen);

        TeamsObj Enguerran = new TeamsObj(eng, "Enguerran", getString(R.string.En_desc));
        team.add(Enguerran);



    }
}