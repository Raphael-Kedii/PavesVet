package com.paves.pavesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ExpertDashboardActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArrayList<ModelV> list;
    MyAdapter myAdapter;
    FirebaseAuth firebaseAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_dashboard);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.dashboard);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Other Experts Selected
        bottomNavigationView.setSelectedItemId(R.id.other_experts);

        //Perform ItemSelectedListListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.
                OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case  R.id.farmers:
                        startActivity(new Intent(getApplicationContext(),FarmersActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case  R.id.learn:
                        startActivity(new Intent(getApplicationContext(),ExpertsLearnActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });
        recyclerView = findViewById(R.id.other_vets_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("experts");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    ModelV modelV = dataSnapshot1.getValue(ModelV.class);
                    list.add(modelV);
                }
                myAdapter = new MyAdapter(ExpertDashboardActivity.this, list);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ExpertDashboardActivity.this, "Opss....Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_logout){
            firebaseAuth.signOut();

            Intent intent = new Intent(ExpertDashboardActivity.this, SelectionActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
