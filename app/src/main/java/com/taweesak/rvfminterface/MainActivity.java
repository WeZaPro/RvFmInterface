package com.taweesak.rvfminterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MyInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();

        if(savedInstanceState == null){//แก้ไขเรื่อง Fragment ซ้อนกัน

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_top,fragmentA)
                    //.addToBackStack("")
                    .commit();

            /*getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_bottom,fragmentB)
                    .addToBackStack("")
                    .commit();*/
        }
    }

    @Override
    public void MyListener(MyModel myModel) {
        //Todo

        FragmentB fragmentB = new FragmentB();
        Bundle b = new Bundle();
        b.putParcelable("key",myModel);
        fragmentB.setArguments(b);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentContainer_top,fragmentB)
                .addToBackStack("")
                .commit();


    }
}
