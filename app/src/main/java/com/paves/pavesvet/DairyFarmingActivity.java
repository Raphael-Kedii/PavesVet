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
import com.paves.pavesvet.model.Dairy;

import java.util.ArrayList;

public class DairyFarmingActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArrayList<Dairy> list;
    DairyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_farming);

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

        recyclerView = findViewById(R.id.dairy_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("dairy_farming");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Dairy dairy = dataSnapshot1.getValue(Dairy.class);
                    list.add(dairy);
                }
                myAdapter = new DairyAdapter(DairyFarmingActivity.this, list);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DairyFarmingActivity.this, "Opss....Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }
}