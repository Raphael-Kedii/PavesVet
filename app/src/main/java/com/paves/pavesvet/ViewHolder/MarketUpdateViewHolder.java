package com.paves.pavesvet.ViewHolder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.paves.pavesvet.Interface.MarketUpdateClickListener;
import com.paves.pavesvet.R;

public class MarketUpdateViewHolder extends RecyclerView.ViewHolder {
    public TextView market_name, cow, bull, doe, billy, ewe, ram, cock, hen;
    public RelativeLayout button;
    public ExpandableLinearLayout expandableLinearLayout;

    private MarketUpdateClickListener marketUpdateClickListener;

    public void setMarketUpdateClickListener(MarketUpdateClickListener marketUpdateClickListener){
        this.marketUpdateClickListener = marketUpdateClickListener;
    }

    public MarketUpdateViewHolder(@NonNull View itemView) {
        super(itemView);

        market_name = itemView.findViewById(R.id.market_name);
        cow = itemView.findViewById(R.id.cow);
        bull = itemView.findViewById(R.id.bull);
        doe = itemView.findViewById(R.id.doe);
        billy = itemView.findViewById(R.id.billy);
        ewe = itemView.findViewById(R.id.ewe);
        ram = itemView.findViewById(R.id.ram);
        cock = itemView.findViewById(R.id.cock);
        hen = itemView.findViewById(R.id.hen);
        button = itemView.findViewById(R.id.button);
        expandableLinearLayout = itemView.findViewById(R.id.expandableLayout);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marketUpdateClickListener.onClick(v, getAdapterPosition());
            }
        });
    }
}
