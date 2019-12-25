package com.taweesak.rvfminterface;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH>{

    private ArrayList<MyModel> mDataList;
    MyInterface listener;
    Context context;

    public MyAdapter(ArrayList<MyModel> mDataList, MyInterface listener, Context context) {
        this.mDataList = mDataList;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);
        return new VH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        holder._country.setText(mDataList.get(position).getCountry());
        holder._rates.setText(""+mDataList.get(position).getRates());
        holder._imageFlag.setImageResource(mDataList.get(position).getImages());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    public class VH extends RecyclerView.ViewHolder{

        TextView _country;
        TextView _rates;
        ImageView _imageFlag;

        public VH(View itemView) {
            super(itemView);

            _country = itemView.findViewById(R.id.tv_country);
            _rates = itemView.findViewById(R.id.tv_rate);
            _imageFlag = itemView.findViewById(R.id.imageFlag);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Todo
                    int clickItem = (int) view.getTag();
                    listener.MyListener(mDataList.get(clickItem));
                    Toast.makeText(context,"data is "+mDataList.get(clickItem).getCountry(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (context instanceof MyInterface){
            listener = (MyInterface) context;
        }
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        listener = null;
    }




}
