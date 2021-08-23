package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paves.pavesvet.model.Service;

import java.util.ArrayList;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Service> serviceAdapters;

    ServicesAdapter(Context c, ArrayList<Service> m){
        context = c;
        serviceAdapters = m;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.services_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesAdapter.MyViewHolder holder, int position) {

        holder.service_title.setText(serviceAdapters.get(position).getService_title());
    }

    @Override
    public int getItemCount() {
        return serviceAdapters.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView service_title;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            service_title = itemView.findViewById(R.id.service_name);
        }
    }
}
