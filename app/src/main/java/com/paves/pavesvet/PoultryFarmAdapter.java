package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paves.pavesvet.model.PoultryFarm;

import java.util.ArrayList;

public class PoultryFarmAdapter extends RecyclerView.Adapter<PoultryFarmAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<PoultryFarm> poultryFarms;
    public PoultryFarmAdapter (Context c, ArrayList<PoultryFarm> m){
        context = c;
        poultryFarms = m;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.poultry_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PoultryFarmAdapter.MyViewHolder holder, int position) {
        holder.poultryGeneralInfo.setText(poultryFarms.get(position).getPoultry_general_info());
        holder.poultryBreeds.setText(poultryFarms.get(position).getPoultry_breeds());
        holder.poultryManagement.setText(poultryFarms.get(position).getPoultry_management());
        holder.poultryHatchery.setText(poultryFarms.get(position).getPoultry_hatchery());

    }

    @Override
    public int getItemCount() {
        return poultryFarms.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView poultryGeneralInfo, poultryBreeds, poultryManagement, poultryHatchery;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            poultryGeneralInfo = itemView.findViewById(R.id.poultry_general_info);
            poultryBreeds = itemView.findViewById(R.id.poultry_breeds);
            poultryManagement = itemView.findViewById(R.id.poultry_management);
            poultryHatchery = itemView.findViewById(R.id.poultry_hatchery);
        }
    }
}
