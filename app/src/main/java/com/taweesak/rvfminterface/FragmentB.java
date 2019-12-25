package com.taweesak.rvfminterface;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentB extends Fragment {

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        TextView tvCountry = v.findViewById(R.id.tvCountry);
        TextView tvRates = v.findViewById(R.id.tvRates);
        ImageView imageView = v.findViewById(R.id.imageView);

        MyModel myModel = new MyModel();

        if(getArguments() != null){
            myModel = getArguments().getParcelable("key");

            tvCountry.setText("country : "+myModel.getCountry());
            tvRates.setText("rates : "+myModel.getRates());
            imageView.setImageResource(myModel.getImages());
        }

        return v;
    }
}
