package com.example.hamburgertester;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Solar_System#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Solar_System extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Solar_System() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Solar_System.
     */
    // TODO: Rename and change types and number of parameters
    public static Solar_System newInstance(String param1, String param2) {
        Solar_System fragment = new Solar_System();
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

        ArrayList<Planet> planets = new ArrayList<>();
        planetMethod(planets);
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_solar__system, container, false);


        RecyclerView recyclerView = v.findViewById(R.id.pRecyclerView);
        Planets_RecyclerViewAdapter adapter = new Planets_RecyclerViewAdapter(v.getContext(), planets);


        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        recyclerView.setAdapter(adapter);

        return v;
    }


    public void planetMethod(ArrayList<Planet> planets){
        Drawable mercuryImage = ContextCompat.getDrawable(getActivity(), R.drawable.mercury);
        Drawable venusImage = ContextCompat.getDrawable(getActivity(), R.drawable.venus);
        Drawable earthImage = ContextCompat.getDrawable(getActivity(), R.drawable.earth);
        Drawable marsImage = ContextCompat.getDrawable(getActivity(), R.drawable.mars);
        Drawable jupiterImage = ContextCompat.getDrawable(getActivity(), R.drawable.jupiter);
        Drawable saturnImage = ContextCompat.getDrawable(getActivity(), R.drawable.saturn);
        Drawable uranusImage = ContextCompat.getDrawable(getActivity(), R.drawable.uranus);
        Drawable neptuneImage = ContextCompat.getDrawable(getActivity(), R.drawable.neptune);


        Planet mercury = new Planet("Mercury", getString(R.string.mercury_info), mercuryImage);
        Planet venus = new Planet("Venus",getString(R.string.venus_info),venusImage);
        Planet earth = new Planet("Earth",getString(R.string.earth_info),earthImage);
        Planet mars = new Planet("Mars",getString(R.string.mars_info),marsImage);
        Planet jupiter = new Planet("Jupiter",getString(R.string.jupiter_info),jupiterImage);
        Planet saturn = new Planet("Saturn",getString(R.string.saturn_info),saturnImage);
        Planet uranus = new Planet("Urnanus",getString(R.string.uranus_info),uranusImage);
        Planet neptune = new Planet("Neptune",getString(R.string.neptune_info),neptuneImage);


        planets.add(mercury);
        planets.add(venus);
        planets.add(earth);
        planets.add(mars);
        planets.add(jupiter);
        planets.add(saturn);
        planets.add(uranus);
        planets.add(neptune);


    }
}

