package com.paves.pavesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.paves.pavesvet.model.Crop;

import java.util.ArrayList;

public class CropActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArrayList<Crop> list;
    CropAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
            }
        });
        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.learn_bottom_navigation);

        //Set Other Experts Selected
        bottomNavigationView.setSelectedItemId(R.id.crop);

        //Perform ItemSelectedListListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.
                OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case  R.id.other_farming:
                        startActivity(new Intent(getApplicationContext(),OtherFarmingActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case  R.id.livestock:
                        startActivity(new Intent(getApplicationContext(),LearnActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });
        recyclerView = findViewById(R.id.crop_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("crop_farming");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Crop crop = dataSnapshot1.getValue(Crop.class);
                    list.add(crop);
                }
                myAdapter = new CropAdapter(CropActivity.this, list);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CropActivity.this, "Opss....Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
