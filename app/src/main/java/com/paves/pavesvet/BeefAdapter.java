package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paves.pavesvet.model.Beef;

import java.util.ArrayList;

public class BeefAdapter extends RecyclerView.Adapter<BeefAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Beef> beefs;
    public BeefAdapter (Context c, ArrayList<Beef> m){
        context = c;
        beefs = m;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new  MyViewHolder(LayoutInflater.from(context).inflate(R.layout.beef_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BeefAdapter.MyViewHolder holder, int position) {
        holder.beefGeneralInfo.setText(beefs.get(position).getBeef_general_info());
        holder.beefBreeds.setText(beefs.get(position).getBeef_breeds());
        holder.beefManagement.setText(beefs.get(position).getBeef_management());
        holder.beefManagementAct.setText(beefs.get(position).getBeef_management_act());
        holder.beefRecords.setText(beefs.get(position).getBeef_records());
        holder.beefNutrient.setText(beefs.get(position).getBeef_nutrient());

    }

    @Override
    public int getItemCount() {
        return beefs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView beefGeneralInfo, beefBreeds, beefManagement, beefManagementAct, beefRecords, beefNutrient;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            beefGeneralInfo = itemView.findViewById(R.id.beef_general_info);
            beefBreeds = itemView.findViewById(R.id.beef_breeds);
            beefManagement = itemView.findViewById(R.id.beef_management);
            beefManagementAct = itemView.findViewById(R.id.management_act);
            beefRecords = itemView.findViewById(R.id.beef_records);
            beefNutrient = itemView.findViewById(R.id.beef_nutrient);
        }
    }
}
