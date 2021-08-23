package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paves.pavesvet.model.Dairy;

import java.util.ArrayList;

public class DairyAdapter extends RecyclerView.Adapter<DairyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Dairy> dairies;
    public DairyAdapter (Context c, ArrayList<Dairy> m){
        context = c;
        dairies = m;
        }
@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.dairyfarming_row, parent, false));
        }
@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.generalInfo.setText(dairies.get(position).getGeneral_info());
        holder.breed.setText(dairies.get(position).getBreeds());
        holder.calfFm.setText(dairies.get(position).getCalf_fm());
        holder.calfHs.setText(dairies.get(position).getCalf_hs());
        holder.calfM.setText(dairies.get(position).getCalf_m());
        holder.heifer.setText(dairies.get(position).getHeifers());
        holder.dairyFeed.setText(dairies.get(position).getDairy_feed());
        holder.dairyM.setText(dairies.get(position).getDairy_m());
        holder.routines.setText(dairies.get(position).getRoutine());
        holder.record.setText(dairies.get(position).getRecords());
        holder.dairyHs.setText(dairies.get(position).getDairy_hs());

        }

@Override
public int getItemCount() {
        return dairies.size();
        }

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView generalInfo, breed, calfFm, calfHs, calfM, heifer,dairyFeed, dairyM, routines, record, dairyHs;


    private MyViewHolder(@NonNull View itemView) {
        super(itemView);
        generalInfo = itemView.findViewById(R.id.general_info);
        breed= itemView.findViewById(R.id.breeds);
        calfFm= itemView.findViewById(R.id.calf_fm);
        calfM= itemView.findViewById(R.id.calf_m);
        calfHs= itemView.findViewById(R.id.calf_hs);
        heifer= itemView.findViewById(R.id.heifers);
        dairyFeed= itemView.findViewById(R.id.dairy_feed);
        dairyM= itemView.findViewById(R.id.dairy_m);
        routines= itemView.findViewById(R.id.routine);
        record= itemView.findViewById(R.id.records);
        dairyHs= itemView.findViewById(R.id.dairy_hs);


    }

}
        }
