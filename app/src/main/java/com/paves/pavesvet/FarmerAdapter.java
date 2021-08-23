package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FarmerAdapter extends RecyclerView.Adapter<FarmerAdapter.MyViewHolder>  {
    private Context context;
    private ArrayList<RegisteredFarmer> registeredFarmers;

    public FarmerAdapter(Context c, ArrayList<RegisteredFarmer> m) {
        context = c;
        registeredFarmers = m;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).
                inflate(R.layout.farmers_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.first_name.setText(registeredFarmers.get(position).getFirst_name());
        holder.last_name.setText(registeredFarmers.get(position).getLast_name());
        holder.number.setText(registeredFarmers.get(position).getNumber());
        holder.email.setText(registeredFarmers.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return registeredFarmers.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView first_name, last_name ,number, email;


        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            first_name = itemView.findViewById(R.id.firstName);
            last_name = itemView.findViewById(R.id.lastName);
            number = itemView.findViewById(R.id.mobileNumber);
            email = itemView.findViewById(R.id.emailAddress);

        }

    }


}