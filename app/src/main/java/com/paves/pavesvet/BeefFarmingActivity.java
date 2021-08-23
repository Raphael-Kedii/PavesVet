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
import com.paves.pavesvet.model.Beef;
import com.paves.pavesvet.model.Dairy;

import java.util.ArrayList;

public class BeefFarmingActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArrayList<Beef> list;
    BeefAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beef_farming);

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

        recyclerView = findViewById(R.id.beef_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("beef_farming");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Beef beef = dataSnapshot1.getValue(Beef.class);
                    list.add(beef);
                }
                myAdapter = new BeefAdapter(BeefFarmingActivity.this, list);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(BeefFarmingActivity.this, "Opss....Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }
}