package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paves.pavesvet.model.Crop;

import java.util.ArrayList;

public class CropAdapter extends RecyclerView.Adapter<CropAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Crop> crops;

    public CropAdapter (Context c, ArrayList<Crop> m){
        context = c;
        crops = m;
    }

    @NonNull
    @Override
    public CropAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.crop_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CropAdapter.MyViewHolder holder, int position) {
        holder.cropName.setText(crops.get(position).getCrop_name());
        holder.cropNameInfo.setText(crops.get(position).getCrop_nameInfo());


    }

    @Override
    public int getItemCount() {
        return crops.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cropName, cropNameInfo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cropName = itemView.findViewById(R.id.crop_name);
            cropNameInfo = itemView.findViewById(R.id.crop_nameInfo);

        }
    }
}
