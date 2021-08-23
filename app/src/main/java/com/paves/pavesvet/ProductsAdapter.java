package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paves.pavesvet.model.Product;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Product> productsAdapters;

    ProductsAdapter(Context c, ArrayList<Product> m){
        context = c;
        productsAdapters = m;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.products_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.product_title.setText(productsAdapters.get(position).getProduct_title());
    }

    @Override
    public int getItemCount() {
        return productsAdapters.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView product_title;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            product_title = itemView.findViewById(R.id.product_name);
        }
    }
}
