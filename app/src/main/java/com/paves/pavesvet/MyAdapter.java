package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ModelV> modelVS;

    public MyAdapter(Context c, ArrayList<ModelV> m) {
        context = c;
        modelVS = m;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.vetservices_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(modelVS.get(position).getFull_name());
        holder.mobile.setText(modelVS.get(position).getMobile_number());
        holder.kvb.setText(modelVS.get(position).getKvb_number());
        holder.email.setText(modelVS.get(position).getEmail_address());
        holder.expertise.setText(modelVS.get(position).getExpertise());
        holder.loc.setText(modelVS.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return modelVS.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, mobile,kvb,email,expertise, loc;


        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.full_name);
            mobile = itemView.findViewById(R.id.mobile_number);
            kvb = itemView.findViewById(R.id.kvb_number);
            email = itemView.findViewById(R.id.email_address);
            expertise = itemView.findViewById(R.id.expertise);
            loc = itemView.findViewById(R.id.location);

        }

    }


}
