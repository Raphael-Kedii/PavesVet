package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paves.pavesvet.model.Aqua;

import java.util.ArrayList;

public class AquaFarmAdapter extends RecyclerView.Adapter<AquaFarmAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Aqua> aquas;
    public AquaFarmAdapter (Context c, ArrayList<Aqua> m){
        context = c;
        aquas = m;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.aqua_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AquaFarmAdapter.MyViewHolder holder, int position) {
        holder.aquaGeneralInfo.setText(aquas.get(position).getAqua_general_info());
        holder.aquaSpecies.setText(aquas.get(position).getAqua_species());
        holder.aquaManagement.setText(aquas.get(position).getAqua_management());
        holder.aquaPolyculture.setText(aquas.get(position).getPolyculture());
        holder.aquaMarket.setText(aquas.get(position).getAqua_market());
        holder.aquaCrocodile.setText(aquas.get(position).getAqua_crocodile());

    }

    @Override
    public int getItemCount() {
        return aquas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView aquaGeneralInfo, aquaSpecies, aquaManagement, aquaPolyculture, aquaMarket, aquaCrocodile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            aquaGeneralInfo =itemView.findViewById(R.id.aqua_general_info);
            aquaSpecies = itemView.findViewById(R.id.aqua_species);
            aquaManagement = itemView.findViewById(R.id.aqua_management);
            aquaPolyculture = itemView.findViewById(R.id.policulture);
            aquaMarket = itemView.findViewById(R.id.aqua_market);
            aquaCrocodile = itemView.findViewById(R.id.aqua_crocodile);
        }
    }
}
