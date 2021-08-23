package com.paves.pavesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.paves.pavesvet.model.Aqua;

import java.util.ArrayList;

public class FishFarmingActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArrayList<Aqua> list;
    AquaFarmAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_farming);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LearnActivity.class));
            }
        });

        recyclerView = findViewById(R.id.aqua_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("fish_farming");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Aqua aqua = dataSnapshot1.getValue(Aqua.class);
                    list.add(aqua);
                }
                myAdapter = new AquaFarmAdapter(FishFarmingActivity.this, list);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FishFarmingActivity.this, "Opss....Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
