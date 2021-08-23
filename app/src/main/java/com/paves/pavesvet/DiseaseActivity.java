package com.paves.pavesvet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DiseaseActivity extends AppCompatActivity {
    ImageView iv_cow, iv_sheep_goat, iv_poultry, iv_camel, iv_pig, iv_dog_cat, iv_rabbit_fish, iv_wild_animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

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
        iv_cow = findViewById(R.id.iv_cow);
        iv_sheep_goat = findViewById(R.id.iv_sheep_goat);
        iv_poultry = findViewById(R.id.iv_poultry);
        iv_camel = findViewById(R.id.iv_camel);
        iv_pig = findViewById(R.id.iv_pig);
        iv_dog_cat = findViewById(R.id.iv_dog_cat);
        iv_rabbit_fish = findViewById(R.id.iv_rabbit);
        iv_wild_animals = findViewById(R.id.iv_wild_animals);

        iv_cow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiseaseActivity.this, CowsActivity.class);
                startActivity(intent);
            }
        });
        iv_sheep_goat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiseaseActivity.this, SheepGoatsActivity.class);
                startActivity(intent);
            }
        });
        iv_poultry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiseaseActivity.this, PoultryActivity.class);
                startActivity(intent);
            }
        });
        iv_camel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiseaseActivity.this, CamelsActivity.class);
                startActivity(intent);
            }
        });
        iv_pig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiseaseActivity.this, PigsActivity.class);
                startActivity(intent);
            }
        });
        iv_dog_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiseaseActivity.this, DogsCatsActivity.class);
                startActivity(intent);
            }
        });
        iv_rabbit_fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiseaseActivity.this, RabitFishActivity.class);
                startActivity(intent);
            }
        });
        iv_wild_animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiseaseActivity.this, WildAnimalActivity.class);
                startActivity(intent);
            }
        });
    }
}
