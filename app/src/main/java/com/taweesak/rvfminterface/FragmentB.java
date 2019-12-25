package com.taweesak.rvfminterface;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentB extends Fragment {

    MyModel myModel;
    TextView tvCountry,tvRates,tvCalRates;
    ImageView imageView;
    Button button;
    EditText edittext;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        tvCountry = v.findViewById(R.id.tvCountry);
        tvRates = v.findViewById(R.id.tvRates);
        imageView = v.findViewById(R.id.imageView);

        myModel = new MyModel();

        if(getArguments() != null){
            myModel = getArguments().getParcelable("key");

            tvCountry.setText("country : "+myModel.getCountry());
            tvRates.setText("rates : "+myModel.getRates());
            imageView.setImageResource(myModel.getImages());
        }

        tvCalRates = v.findViewById(R.id.tvCalRates);
        button = v.findViewById(R.id.button);
        edittext = v.findViewById(R.id.edittext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    double numInput  = Double.parseDouble(edittext.getText().toString());
                    double calNum = myModel.getRates()*numInput;

                    tvCalRates.setText(""+calNum);

                }catch (NumberFormatException e){
                    Toast.makeText(getActivity(),"INPUT ERROR : "+e,Toast.LENGTH_SHORT).show();
                }

            }
        });
        return v;
    }
}
