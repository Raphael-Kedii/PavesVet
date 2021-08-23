package com.paves.pavesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paves.pavesvet.model.Record;

import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Record> records;

    public RecordAdapter(Context c, ArrayList<Record> m){
        context = c;
        records = m;
    }
    @NonNull
    @Override
    public RecordAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).
                inflate(R.layout.record_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecordAdapter.MyViewHolder holder, int position) {
        holder.livestockIncome.setText(records.get(position).getLivestock_income());
        holder.cropIncome.setText(records.get(position).getCrop_income());
        holder.otherIncome.setText(records.get(position).getOther_income());
        holder.totalIncome.setText(records.get(position).getTotal_income());
        holder.livestockExpense.setText(records.get(position).getLivestock_expense());
        holder.cropExpense.setText(records.get(position).getCrop_expense());
        holder.otherExpense.setText(records.get(position).getOther_expense());
        holder.totalExpense.setText(records.get(position).getTotal_expense());

    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView livestockIncome, cropIncome, otherIncome, totalIncome, livestockExpense, cropExpense, otherExpense, totalExpense;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            livestockIncome = itemView.findViewById(R.id.livestock_amount);
            cropIncome = itemView.findViewById(R.id.crop_amount);
            otherIncome = itemView.findViewById(R.id.other_amount);
            totalIncome = itemView.findViewById(R.id.total_amount);
            livestockExpense = itemView.findViewById(R.id.livestock_expenses);
            cropExpense = itemView.findViewById(R.id.crop_expenses);
            otherExpense = itemView.findViewById(R.id.other_expenses);
            totalExpense = itemView.findViewById(R.id.total_expenses);
        }
    }
}
