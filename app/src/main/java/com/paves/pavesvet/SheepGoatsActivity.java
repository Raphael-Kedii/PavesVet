package com.paves.pavesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.Utils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.paves.pavesvet.ViewHolder.ShoatViewHolder;
import com.paves.pavesvet.model.Shoat;


import java.util.ArrayList;
import java.util.List;

public class SheepGoatsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Shoat> shoats = new ArrayList<>();
    FirebaseRecyclerAdapter<Shoat, ShoatViewHolder> adapter;
    SparseBooleanArray expandState = new SparseBooleanArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheep_goats);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DiseaseActivity.class));
            }
        });

        //Define recycleview
        recyclerView = findViewById(R.id.shoatsRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));

        //retrieve data
        retrieveData();

        //set data
        setData();

    }

    private void setData() {
        Query query = FirebaseDatabase.getInstance().getReference().child("shoats_disease");
        FirebaseRecyclerOptions<Shoat> options = new FirebaseRecyclerOptions.Builder<Shoat>()
                .setQuery(query, Shoat.class)
                .build();
        adapter = new FirebaseRecyclerAdapter<Shoat, ShoatViewHolder>(options) {
            //Ctl O

            @Override
            public int getItemViewType(int position) {
                return super.getItemViewType(position);
            }


            @Override
            protected void onBindViewHolder(@NonNull final ShoatViewHolder shoatViewHolder,
                                            final int position, @NonNull Shoat model) {
                shoatViewHolder.setIsRecyclable(false);
                shoatViewHolder.getItemViewType();
                shoatViewHolder.disease_name.setText(model.getDisease_title());

                shoatViewHolder.expandableLinearLayout.setInRecyclerView(true);
                shoatViewHolder.expandableLinearLayout.setExpanded(expandState.get(position));
                shoatViewHolder.expandableLinearLayout.setListener(new ExpandableLayoutListenerAdapter() {

                    @Override
                    public void onPreOpen() {
                        changeRotate(shoatViewHolder.button,0f,180f);
                        expandState.put(position,true);

                    }

                    @Override
                    public void onPreClose() {
                        changeRotate(shoatViewHolder.button,180f,0f);
                        expandState.put(position,false);

                    }

                });
                shoatViewHolder.button.setRotation(expandState.get(position)?180f:0f);
                shoatViewHolder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shoatViewHolder.expandableLinearLayout.toggle();
                    }
                });
                shoatViewHolder.aetiological_agent.setText(model.getAetiological_agent());
                shoatViewHolder.transmission.setText(model.getTransmission());
                shoatViewHolder.clinical_signs.setText(model.getClinical_signs());
                shoatViewHolder.differential_diagnosis.setText(model.getDifferential_diagnosis());
                shoatViewHolder.treatment_and_control.setText(model.getTreatment_and_control());



            }
            @Override
            public int getItemCount() {
                return shoats.size();
            }

            @NonNull
            @Override
            public ShoatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
                View view = LayoutInflater.from(viewGroup.getContext()).
                        inflate(R.layout.shoats_layout_with_children,viewGroup,false);
                return new ShoatViewHolder(view);
            }
        };
        //Init SparseArray
        expandState.clear();
        for (int i=0; i<shoats.size();i++)
            expandState.append(i,false);
        recyclerView.setAdapter(adapter);

    }

    private void changeRotate(RelativeLayout button, float from, float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(button,"rotation",from,to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
    }


    private void retrieveData() {
        shoats.clear();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference()
                .child("shoats_disease");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Shoat shoat = dataSnapshot1.getValue(Shoat.class);
                    shoats.add(shoat);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Error", ""+ databaseError.getMessage());

            }
        });
    }
    protected void onStart() {
        if (adapter != null)
            adapter.startListening();
        super.onStart();
    }
    protected void onStop(){
        if (adapter != null)
            adapter.stopListening();
        super.onStop();
    }
}
