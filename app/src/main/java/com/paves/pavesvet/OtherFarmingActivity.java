package com.paves.pavesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OtherFarmingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_farming);

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
        bottomNavigationView.setSelectedItemId(R.id.other_farming);

        //Perform ItemSelectedListListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.
                OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case  R.id.crop:
                        startActivity(new Intent(getApplicationContext(),CropActivity.class));
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
    }
}


