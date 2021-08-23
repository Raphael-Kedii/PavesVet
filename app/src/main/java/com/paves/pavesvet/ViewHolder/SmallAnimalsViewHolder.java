package com.paves.pavesvet.ViewHolder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.paves.pavesvet.Interface.SmallanimalClickListener;
import com.paves.pavesvet.R;

public class SmallAnimalsViewHolder extends RecyclerView.ViewHolder {
    public TextView disease_name, aetiological_agent, transmission, clinical_signs, differential_diagnosis,
            treatment_and_control;
    public RelativeLayout button;
    public ExpandableLinearLayout expandableLinearLayout;

    private SmallanimalClickListener smallanimalClickListener;

    public void setSmallanimalClickListener(SmallanimalClickListener smallanimalClickListener) {
        this.smallanimalClickListener = smallanimalClickListener;
    }

    public SmallAnimalsViewHolder(@NonNull View itemView) {
        super(itemView);

        disease_name = itemView.findViewById(R.id.disease_name);
        aetiological_agent = itemView.findViewById(R.id.aetiological_agent);
        transmission = itemView.findViewById(R.id.transmission);
        clinical_signs = itemView.findViewById(R.id.clinical_signs);
        differential_diagnosis = itemView.findViewById(R.id.differntial_diagnosis);
        treatment_and_control = itemView.findViewById(R.id.treatment_and_control);
        button = itemView.findViewById(R.id.button);
        expandableLinearLayout = itemView.findViewById(R.id.expandableLayout);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smallanimalClickListener.onClick(v,getAdapterPosition());
            }
        });
    }
}
