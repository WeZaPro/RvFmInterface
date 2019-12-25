package com.taweesak.rvfminterface;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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
    View v;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment

        if(v == null){ // แก้ไขเรื่อง Dupplicate item in Recyclerview

            v = inflater.inflate(R.layout.fragment_a, container, false);
            button = v.findViewById(R.id.button);
            recyclerView = v.findViewById(R.id.myRecyclerView);

            data();

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            myAdapter = new MyAdapter(lstData,listener,getActivity());
            recyclerView.setAdapter(myAdapter);
        }
        
        Log.i("check","onCreateView");

        return v;
    }

    private void data() {
        String country_[] = {"Kitty 1 |","Kitty 2 |","Kitty 3 |",
                "Kitty 4 |","Kitty 5 |","Kitty 6 |","Kitty 7 |",
                "Kitty 8 |","Kitty 9 |","Kitty 10 |","Kitty 11 |",
                "Kitty 12 |","Kitty 13 |","Kitty 14 |","Kitty 15 |"};
        double rates[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};


        int dataSize = country_.length;

        for (int i = 0; i <dataSize ; i++) {
            MyModel model = new MyModel(country_[i],rates[i]);
            lstData.add(model);
        }
    }



    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.i("check","onAttachFragment");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("check","onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("check","onCreate");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("check","onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("check","onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("check","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("check","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("check","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("check","onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("check","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("check","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("check","onDetach");
    }


}

