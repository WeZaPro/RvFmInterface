package com.taweesak.rvfminterface;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentA extends Fragment {

    private ArrayList<MyModel> lstData = new ArrayList<>();
    RecyclerView recyclerView;
    Button button;
    MyAdapter myAdapter;
    Context context;
    MyInterface listener;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        button = v.findViewById(R.id.button);
        recyclerView = v.findViewById(R.id.myRecyclerView);

        data();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapter = new MyAdapter(lstData,listener,getActivity());
        recyclerView.setAdapter(myAdapter);

        return v;
    }

    private void data() {
        String country_[] = {"Kitty 1 |","Kitty 2 |","Kitty 3 |",
                "Kitty 4 |","Kitty 5 |","Kitty 6 |","Kitty 7 |",
                "Kitty 8 |","Kitty 9 |","Kitty 10 |","Kitty 11 |","Kitty 12 |"};
        double rates[] = {1,2,3,4,5,6,7,8,9,10,11,12};


        int dataSize = country_.length;

        for (int i = 0; i <dataSize ; i++) {
            MyModel model = new MyModel(country_[i],rates[i]);
            lstData.add(model);
        }
    }
}
