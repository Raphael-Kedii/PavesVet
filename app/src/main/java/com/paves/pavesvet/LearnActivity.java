package com.paves.pavesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LearnActivity extends AppCompatActivity {
    ImageView iv_cow, iv_sheep_goat, iv_poultry, iv_beef, iv_pig, iv_fish;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

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
                bottomNavigationView.setSelectedItemId(R.id.livestock);

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
                            case  R.id.other_farming:
                                startActivity(new Intent(getApplicationContext(),OtherFarmingActivity.class));
                                overridePendingTransition(0, 0);
                                return true;
                        }

                return false;
            }
        });
        iv_cow = findViewById(R.id.iv_cow);
        iv_sheep_goat = findViewById(R.id.iv_sheep_goat);
        iv_poultry = findViewById(R.id.iv_poultry);
        iv_beef = findViewById(R.id.iv_beef);
        iv_pig = findViewById(R.id.iv_pig);
        iv_fish = findViewById(R.id.iv_fish);

        iv_cow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, DairyFarmingActivity.class);
                startActivity(intent);
            }
        });

        iv_sheep_goat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, ShoatsFarmingActivity.class);
                startActivity(intent);
            }
        });

        iv_poultry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, PoultryFarmingActivity.class);
                startActivity(intent);
            }
        });

        iv_beef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, BeefFarmingActivity.class);
                startActivity(intent);
            }
        });
        iv_pig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LearnActivity.this, PigFarmingActivity.class);
                startActivity(intent);
            }
        });

        iv_fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, FishFarmingActivity.class);
                startActivity(intent);
            }
        });
    }
}
