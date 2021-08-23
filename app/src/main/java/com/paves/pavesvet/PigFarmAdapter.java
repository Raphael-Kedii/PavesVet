package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paves.pavesvet.model.PigsFarm;

import java.util.ArrayList;

public class PigFarmAdapter extends RecyclerView.Adapter<PigFarmAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<PigsFarm> pigsFarms;
    public PigFarmAdapter (Context c, ArrayList<PigsFarm> m){
        context = c;
        pigsFarms = m;
    }
    @NonNull
    @Override
    public PigFarmAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.pig_farm_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PigFarmAdapter.MyViewHolder holder, int position) {
        holder.pigGeneralInfo.setText(pigsFarms.get(position).getPig_general_info());
        holder.pigBreeds.setText(pigsFarms.get(position).getPig_breeds());
        holder.pigBreeding.setText(pigsFarms.get(position).getPig_breeding());
        holder.pigFeeding.setText(pigsFarms.get(position).getPig_feeding());
        holder.pigPens.setText(pigsFarms.get(position).getPig_pens());
        holder.pigManagement.setText(pigsFarms.get(position).getPig_management());

    }

    @Override
    public int getItemCount() {
        return pigsFarms.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView pigGeneralInfo, pigBreeds, pigBreeding, pigFeeding, pigPens, pigManagement;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pigGeneralInfo = itemView.findViewById(R.id.pig_general_info);
            pigBreeds = itemView.findViewById(R.id.pig_breeds);
            pigBreeding = itemView.findViewById(R.id.pig_breeding);
            pigFeeding = itemView.findViewById(R.id.pig_feeding);
            pigPens = itemView.findViewById(R.id.pig_pens);
            pigManagement= itemView.findViewById(R.id.pig_management);
        }
    }
}
