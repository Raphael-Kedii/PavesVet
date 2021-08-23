package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paves.pavesvet.model.ShoatsFarm;

import java.util.ArrayList;

public class ShoatsFarmAdapter extends RecyclerView.Adapter<ShoatsFarmAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ShoatsFarm> shoatsFarms;
    public ShoatsFarmAdapter (Context c, ArrayList<ShoatsFarm> m){
        context = c;
        shoatsFarms = m;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.shoats_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShoatsFarmAdapter.MyViewHolder holder, int position) {
        holder.shoatsGeneralInfo.setText(shoatsFarms.get(position).getShoats_general_info());
        holder.shoatsBreeds.setText(shoatsFarms.get(position).getShoats_breeds());
        holder.shoatsManagement.setText(shoatsFarms.get(position).getShoats_management());
        holder.shoatsNutrition.setText(shoatsFarms.get(position).getShoats_nutrition());
        holder.shoatsFeeding.setText(shoatsFarms.get(position).getShoats_feeding());
        holder.shoatsHousing.setText(shoatsFarms.get(position).getShoats_housing());
        holder.shoatsManagementPrac.setText(shoatsFarms.get(position).getShoats_management_prac());
        holder.shoatsRecords.setText(shoatsFarms.get(position).getShoats_records());

    }

    @Override
    public int getItemCount() {
        return shoatsFarms.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView shoatsGeneralInfo, shoatsBreeds, shoatsManagement, shoatsNutrition, shoatsFeeding, shoatsHousing, shoatsManagementPrac, shoatsRecords;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            shoatsGeneralInfo = itemView.findViewById(R.id.shoats_general_info);
            shoatsBreeds = itemView.findViewById(R.id.shoats_breeds);
            shoatsManagement = itemView.findViewById(R.id.shoats_management);
            shoatsNutrition = itemView.findViewById(R.id.shoats_nutrition);
            shoatsFeeding = itemView.findViewById(R.id.shoats_feeding);
            shoatsHousing = itemView.findViewById(R.id.shoats_housing);
            shoatsManagementPrac = itemView.findViewById(R.id.shoats_management_prac);
            shoatsRecords = itemView.findViewById(R.id.shoats_records);
        }
    }
}
