package com.paves.pavesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FarmersActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArrayList<RegisteredFarmer> list;
    FarmerAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmers);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Other Experts Selected
        bottomNavigationView.setSelectedItemId(R.id.farmers);

        //Perform ItemSelectedListListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.
                OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.other_experts:
                        startActivity(new Intent(getApplicationContext(), ExpertDashboardActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.learn:
                        startActivity(new Intent(getApplicationContext(), ExpertsLearnActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });
        recyclerView = findViewById(R.id.farmers_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("farmers");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    RegisteredFarmer registeredFarmer = dataSnapshot1.getValue(RegisteredFarmer.class);
                    list.add(registeredFarmer);
                }
                myAdapter = new FarmerAdapter(FarmersActivity.this, list);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FarmersActivity.this, "Opss....Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}